-- create database ThucTap
DROP DATABASE IF EXISTS ThucTap ;
CREATE DATABASE ThucTap ;
USE ThucTap;

-- 	create table GiangVien
DROP TABLE IF EXISTS GiangVien;
CREATE TABLE GiangVien(
	
		Magv 					TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
		Hoten 				VARCHAR(30) NOT NULL,
		Luong 				INT
);

-- 	create table SinhVien
DROP TABLE IF EXISTS SinhVien ;
CREATE TABLE SinhVien(
		
		Masv 					TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
		Hoten    			VARCHAR(30) NOT NULL,
		Namsinh 			DATE NOT NULL,
		QueQuan 			VARCHAR(50) NOT NULL

);


-- 	create table DeTai
DROP TABLE IF EXISTS DeTai ;
CREATE TABLE DeTai(

		Madt 					TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
		Tendt 				VARCHAR(30) NOT NULL UNIQUE,
		Kinhphi 			INT,
		Noithuctap 		VARCHAR(30) NOT NULL

);



-- 	create table HuongDan
DROP TABLE IF EXISTS HuongDan;
CREATE TABLE HuongDan(

		ID 						TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
		Masv 					TINYINT UNSIGNED ,
		Madt					TINYINT UNSIGNED,
		Magv 					TINYINT UNSIGNED ,
		Ketqua 				VARCHAR(30) 

);





-- insert data into table GiangVien
INSERT INTO GiangVien( Hoten , Luong)
VALUES			('Nguyễn Văn A','12300000'),
						('Lê Thị B','2415325'),
						('Trần Lê C','8072123'),
						('Đinh Văn Vít','45632871'),
						('Trần Thái Độ','57624983');



-- insert data into table SinhVien
INSERT INTO SinhVien (Hoten , Namsinh , QueQuan )
VALUES			('Lê thị Anh','2001/4/15','Minh khai , Hà Nội'),
						('Nguyễn Văn Bình','2001/5/21','Hà Đông , Hà Nội'),
						('Đinh Thái Cao','2000/6/12','Thanh Xuân , Hà Nội'),
						('Hà Thiên Đạt','2001/9/10','Hà Tây , Hà Nội'),
						('Trần Thị Hồng','2001/10/15','Hoài Đức , Hà Nội');
				
-- insert data into table DeTai
INSERT INTO DeTai(Tendt , Kinhphi , Noithuctap)
VALUES						('Trí Tuệ Nhân Tạo','10000000','VTI company'),
									('Web Bán Hàng','5000000','FPT company'),
									('App Liên Lạc','9800000','CMC company'),
									('Công Nghệ Sinh Học','25000000','VTI company'),
									('Xe Máy Thông Minh','30000000','VIN Group');

-- insert data into table HuongDan
INSERT INTO HuongDan (Masv,Madt,Magv,Ketqua)
VALUES							(1,2,1,'Đã Hoàn Thành'),
										(4,2,2,'Đã Hoàn Thành'),
										(2,4,4,'Đang Thực Hiện'),
										(5,4,4,'Đã Hoàn Thành'),
										(4,5,5,'Đã Hoàn Thành'),
										(1,1,3,'Đang Thực Hiện');

										


/* câu 2 : a) Lấy tất cả các sinh viên chưa có đề tài hướng dẫn
					 b) Lấy ra số sinh viên làm đề tài ‘CONG NGHE SINH HOC’ */
-- a) 
SELECT 
	a.Hoten , a.Namsinh , a.QueQuan
FROM
	SinhVien a
	LEFT JOIN HuongDan b ON a.Masv = b.Masv 
WHERE
	b.Masv IS NULL;
	
-- b)
SELECT
	 COUNT(a.Masv) AS 'SỐ LƯỢNG SINH VIÊN '
FROM
	HuongDan a
	INNER JOIN DeTai b ON a.Madt = b.Madt 
WHERE
	b.Tendt = "Công Nghệ Sinh Học";



/* CÂU 3 : Tạo view có tên là "SinhVienInfo" lấy các thông tin về học sinh bao gồm:
mã số, họ tên và tên đề tài
(Nếu sinh viên chưa có đề tài thì column tên đề tài sẽ in ra "Chưa có") */

-- create VIEW
DROP VIEW IF EXISTS SinhVienInfo;
CREATE VIEW SinhVienInfo AS 
	SELECT
		b.Masv,
		b.Hoten,
		CASE 
				WHEN c.Tendt IS NOT NULL THEN c.Tendt
				ELSE "Chưa có"
		END AS 'TÊN ĐỀ TÀI'
	FROM
		HuongDan a
		RIGHT JOIN SinhVien b ON a.Masv = b.Masv
		LEFT JOIN DeTai c ON a.Madt = c.Madt;

-- lấy thông tin từ VIEW
SELECT * FROM SinhVienInfo;


/* CÂU 4 : Tạo trigger cho table SinhVien khi insert sinh viên có năm sinh <= 1900
thì hiện ra thông báo "năm sinh phải > 1900" */

-- create trigger  : 
DROP TRIGGER IF EXISTS CAU_4;
DELIMITER $$
		CREATE TRIGGER CAU_4
		BEFORE INSERT ON SinhVien
		FOR EACH ROW
		BEGIN
					-- khởi tạo biến
					DECLARE year_of_birth INT;
					-- lấy ra năm sinh của bản record sắp được INSERT
					SELECT YEAR(NEW.Namsinh) INTO year_of_birth;
					-- kiểm tra điều kiện 
					IF year_of_birth <= 1900  THEN
							-- xét lỗi.
							SIGNAL SQLSTATE '15435'
							SET MESSAGE_TEXT = "năm sinh phải > 1900";
					END IF;
		END $$
DELIMITER ; 

INSERT INTO SinhVien (Hoten , Namsinh , QueQuan )
VALUES			('Thái thị Băm','1899/5/15','Đống Đa , Hà Nội');


/*
CÂU 5 :  Hãy cấu hình table sao cho khi xóa 1 sinh viên nào đó thì sẽ tất cả thông
tin trong table HuongDan liên quan tới sinh viên đó sẽ bị xóa đi
*/

-- create trigger
DROP TRIGGER IF EXISTS CAU_5;
DELIMITER $$
	
	CREATE TRIGGER CAU_5
			-- tự động thực hiện sau khi câu lệnh DELETE được chạy
			AFTER DELETE ON SinhVien
			FOR EACH ROW
			BEGIN
					-- xóa các thông tin liên qua đến SinhVien bị xóa ở bảng HuongDan
					DELETE FROM HuongDan WHERE Masv = OLD.Masv;
			END $$
DELIMITER ;


DELETE FROM SinhVien WHERE Masv = 2;










