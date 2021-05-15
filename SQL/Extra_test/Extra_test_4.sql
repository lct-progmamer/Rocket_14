-- TẠO csdL
DROP DATABASE IF EXISTS Extra_Assignment;
CREATE DATABASE Extra_Assignment;
USE Extra_Assignment;


-- TAỌ BẢNG Department
DROP TABLE IF EXISTS Department;
CREATE TABLE Department(
	
	Department_Number		TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	Department_Name			VARCHAR(50) NOT NULL
);


-- TẠO BẢNG Employee_Table
DROP TABLE IF EXISTS Employee_Table;
CREATE TABLE 	Employee_Table(
	
	Employee_Number 		TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	Employee_Name				VARCHAR(50) NOT NULL,
	Department_Number		TINYINT UNSIGNED NOT NULL,
	FOREIGN KEY (Department_Number) REFERENCES Department(Department_Number)

);


-- TẠO BẢNG Employee_Skill_Table
DROP TABLE IF EXISTS Employee_Skill_Table;
CREATE TABLE Employee_Skill_Table(

	Employee_Number			TINYINT UNSIGNED AUTO_INCREMENT,
	Skill_Code					CHAR(10) NOT NULL,
	Date_Registered			DATETIME	DEFAULT NOW(),
	PRIMARY KEY(Employee_Number,Skill_Code),
	FOREIGN KEY(Employee_Number) REFERENCES Employee_Table(Employee_Number)
);




INSERT INTO Department (Department_Name)
VALUES									(N'KINH TẾ'),
												(N'BẢO VỆ'),
												(N'NHÂN SỰ'),
												(N'KẾ HOẠCH'),
												(N'BẾP'),
												(N'HỌP'),
												(N'GIẢI TRÍ'),
												(N'THU NGÂN'),
												(N'TIẾP TÂN'),
												(N'GIÁM ĐỐC'),
												(N'HÀNH CHÍNH'),
												(N'CHỦ TỊCH'),
												(N'NGỦ');
												
												
INSERT INTO Employee_Table(Employee_Number,Employee_Name,Department_Number)
VALUES										('1','NAME1','1'),
													('2','NAME2','1'),
													('3','NAME3','4'),
													('4','NAME4','4'),
													('5','NAME5','5'),
													('6','NAME6','6'),
													('7','NAME7','1'),
													('8','NAME8','4'),
													('9','NAME9','5'),
													('10','NAME10','2'),
													('11','NAME11','3');
																
																
																
INSERT INTO Employee_Skill_Table(Employee_Number,Skill_Code,Date_Registered)
VALUES													('1','JAVA','2019/1/2'),
																('2','PYTHON','2012/1/2'),
																('2','C++','2019/5/2'),
																('1','PYTHON','2019/12/19'),
																('5','C#','2018/1/2'),
																('4','JAVA','2009/1/2'),
																('7','JS','2019/10/2'),
																('8','RUBY','2019/11/20'),
																('9','JAVA','2009/10/2'),
																('10','REACT','2019/8/23'),
																('11','JAVA','2017/12/2');



-- CÂU 1 : Viết lệnh để lấy ra danh sách nhân viên (name) có skill Java
SELECT a.Employee_Name , b.Skill_Code
FROM Employee_Table a
INNER JOIN Employee_Skill_Table b
ON a.Employee_Number  = b.Employee_Number
WHERE b.Skill_Code = 'JAVA';

-- CÂU 2: Viết lệnh để lấy ra danh sách các phòng ban có >3 nhân viên

SELECT a.Department_Number, a.Department_Name, COUNT(b.Employee_Number)S
FROM Department a
LEFT JOIN Employee_Table b
ON a.Department_Number = b.Department_Number
GROUP BY a.Department_Number
HAVING COUNT(b.Employee_Number) >= 3;

-- CÂU 3 : Viết lệnh để lấy ra danh sách nhân viên của mỗi văn phòng ban.

SELECT  a.Department_Name AS 'TÊN PHÒNG BAN',GROUP_CONCAT(b.Employee_Name) AS 'TÊN NHÂN VIÊN'
FROM Department a
LEFT JOIN Employee_Table b
ON a.Department_Number = b.Department_Number
GROUP BY a.Department_Name;


-- CÂU 4 : Viết lệnh để lấy ra danh sách nhân viên có > 1 skills.


SELECT a.Employee_Number,a.Employee_Name,COUNT(b.Skill_Code) AS TOTAL_SKILLS
FROM Employee_Table a
INNER JOIN Employee_Skill_Table b
ON a.Employee_Number = b.Employee_Number
GROUP BY a.Employee_Number
HAVING TOTAL_SKILLS>1;






