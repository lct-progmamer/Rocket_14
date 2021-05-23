use testingsystem;

-- CÂU 1 :  Tạo store để người dùng nhập vào tên phòng ban và in ra tất cả các account thuộc phòng ban đó

-- CREATE PROCEDURE 
DROP PROCEDURE IF EXISTS get_acc_from_department;

DELIMITER $$
CREATE PROCEDURE get_acc_from_department ( IN put_department_name VARCHAR ( 30 ), OUT acc_id TINYINT UNSIGNED , OUT	acc_name VARCHAR(50))
	BEGIN
		SELECT
			b.AccountID , b.FullName INTO acc_id , acc_name
		FROM
			department a
			INNER  JOIN account b ON a.DepartmentID = b.DepartmentID
		WHERE a.DepartmentName = put_department_name;
	END$$
DELIMITER ;


-- USING 
SET @v_output_acc_ID = " ";
SET @v_output_acc_name = " ";

CALL get_acc_from_department('Bảo vệ', @v_output_acc_ID,@v_output_acc_name);

SELECT @v_output_acc_ID,@v_output_acc_name;


SELECT * FROM account;
SELECT * FROM department;


-- CÂU 2 :  Tạo store để in ra số lượng account trong mỗi group


-- CÁCH 1 : KHAI BÁO BIẾN VÀO Ở DÒNG ĐẦU



-- CREATE PROCEDURE

DROP PROCEDURE IF EXISTS get_count_acc_of_group;
DELIMITER $$
CREATE PROCEDURE get_count_acc_of_group(IN id_group TINYINT UNSIGNED , OUT count_acc INT)
			BEGIN
					SELECT
						COUNT( b.AccountID )  AS TOTAL_ACCOUNT
					FROM
						`group` a
						LEFT JOIN groupaccount b ON a.GroupID = b.GroupID 
					WHERE a.GroupID = id_group;
			END$$
DELIMITER ;

-- USING 

SET @v_of_count = 0;

CALL get_count_acc_of_group(3,@v_of_count);

SELECT @v_of_count;


-- CÁCH 2  : KHAI BÁO BIẾN NGAY TRONG BEGIN


DROP PROCEDURE IF EXISTS get_count_acc_of_group;
DELIMITER $$
CREATE PROCEDURE get_count_acc_of_group(IN id_group TINYINT UNSIGNED)
			BEGIN
					DECLARE count_acc INT;
					SELECT
						COUNT( b.AccountID )  INTO count_acc
					FROM
						`group` a
						LEFT JOIN groupaccount b ON a.GroupID = b.GroupID 
					WHERE a.GroupID = id_group;
					SELECT count_acc AS TOTAL_ACC;
			END$$
DELIMITER ;


-- USING 

CALL get_count_acc_of_group(2);



-- CREATE FUNCTION
				


DROP FUNCTION IF EXISTS get_count_acc_of_group_1;
DELIMITER $$
CREATE FUNCTION get_count_acc_of_group_1(id_group TINYINT UNSIGNED) RETURNS INT
			BEGIN
						
						DECLARE v_TOTAL INT;
						SELECT
							COUNT( b.AccountID ) INTO v_TOTAL
						FROM
							`group` a
							LEFT JOIN groupaccount b ON a.GroupID = b.GroupID 
						WHERE a.GroupID = id_group;
						RETURN v_TOTAL;
			END$$
DELIMITER ;
	
SELECT get_count_acc_of_group_1(1) AS TOTAL_ACC;


-- CÂU 3:  Tạo store để thống kê mỗi type question có bao nhiêu question được tạo trong tháng hiện tại
DROP PROCEDURE IF EXISTS get_count_question;

DELIMITER $$

CREATE PROCEDURE get_count_question( OUT count_question INT )
		BEGIN
					SELECT b.TypeID,COUNT(a.QuestionID) AS 'SỐ LƯỢNG CÂU HỎI'
					FROM 
							Question a
							RIGHT JOIN TypeQuestion b ON a.TypeID = b.TypeID
					GROUP BY b.TypeID;
		END$$
DELIMITER ;


SET @v_COUNT_QUESTION = " ";

CALL get_count_question(@v_COUNT_QUESTION);

SELECT  @v_COUNT_QUESTION;


-- CÂU 4: Tạo store để trả ra id của type question có nhiều câu hỏi nhất
DROP PROCEDURE IF EXISTS get_max_question;
DELIMITER $$
CREATE PROCEDURE get_max_question(OUT max_qs TINYINT UNSIGNED )
			BEGIN
						SELECT b.TypeID  INTO max_qs
						FROM Question a
						RIGHT JOIN typequestion b
						ON a.TypeID = b.TypeID
						GROUP BY b.TypeID
						HAVING COUNT(a.QuestionID) = (SELECT COUNT(QuestionID) FROM Question GROUP BY TypeID  ORDER BY COUNT(QuestionID) DESC LIMIT 1 );
			END$$
	DELIMITER ;
	
	
	
	SET @v_ID = "";
	
	CALL get_max_question(@v_ID);
	
	SELECT @v_ID;
	
	

-- CÂU 5 : Sử dụng store ở question 4 để tìm ra tên của type question
SELECT TypeName FROM typequestion WHERE TypeID = @v_ID ;


-- CÂU 6 Viết 1 store cho phép người dùng nhập vào 1 chuỗi và trả về group có tên
-- chứa chuỗi của người dùng nhập vào hoặc trả về user có username chứa
-- chuỗi của người dùng nhập vào INTO OUT_STRING_GROUP_NAMEINTO OUT_STRING_USER_NAME

DROP PROCEDURE IF EXISTS CAU_6;
DELIMITER $$
CREATE PROCEDURE CAU_6(IN in_string VARCHAR(50) , OUT out_string VARCHAR(50))
			BEGIN
					 SELECT GroupName INTO  out_string FROM `group`WHERE GroupName = in_string;
					 SELECT Username INTO out_string  FROM account WHERE Username = in_string;
			END$$
DELIMITER ;


SET @v_string = " "; 
CALL CAU_6('VTI Sale 01' ,@v_string  );

SELECT @v_string;


-- CÂU 7 : 


DROP PROCEDURE IF EXISTS CAU_7;
DELIMITER $$
	CREATE PROCEDURE CAU_7(IN in_full_name VARCHAR(50) , IN in_email VARCHAR(50))
			BEGIN
					INSERT INTO account (Email , Username , FullName , DepartmentID , PositionID ,CreateDate)
					VALUES							(in_email , SUBSTRING_INDEX(in_email,'@',1) ,in_full_name , 1, 1,NOW());
      END$$
DELIMITER ;

CALL CAU_7('LÊ CHÍ TÀI' , 'lechitai@gmail.com');



-- CÂU 8: 

DROP PROCEDURE IF EXISTS  CAU_8; 
DELIMITER $$
	
		CREATE PROCEDURE CAU_8(IN in_type_name ENUM('Essay','Multiple-Choice') , OUT max_content VARCHAR(50))
				BEGIN
							SELECT
							a.Content INTO max_content
							FROM
							question a
							INNER JOIN typequestion b ON a.TypeID = b.TypeID 
							WHERE b.TypeName = in_type_name AND CHAR_LENGTH( a.Content ) = ( SELECT CHAR_LENGTH( Content ) FROM question GROUP BY QuestionID ORDER BY CHAR_LENGTH( Content ) DESC LIMIT 1 );
					END$$
DELIMITER ;

SET @v_content = " ";
CALL CAU_8('Essay' ,@v_content );
SELECT @v_content AS ` CÂU HỎI DÀI NHÂT `;

-- CÂU 9 :
DROP PROCEDURE IF EXISTS remove_Exam;

DELIMITER $$

		CREATE PROCEDURE remove_Exam(IN in_exam_id TINYINT UNSIGNED)
					BEGIN
								DELETE FROM exam WHERE ExamID = in_exam_id;
					END$$
DELIMITER ;

CALL remove_Exam(1);


-- cau 10 : : Tìm ra các exam được tạo từ 3 năm trước và xóa các exam đó đi (sử
 -- dụng store ở câu 9 để xóa)
 -- Sau đó in số lượng record đã remove từ các table liên quan trong khi
		
 -- removing
			
	DROP PROCEDURE IF EXISTS CAU_10;
	DELIMITER $$

		
		CREATE PROCEDURE CAU_10(OUT count_record INT)
					BEGIN
									SELECT COUNT(ExamID) INTO count_record
									FROM exam
									WHERE CreateDate = DATE_SUB('2021-5-20' , INTERVAL 3 YEAR);
									
									
									DELETE FROM exam WHERE CreateDate = DATE_SUB('2021-5-20' , INTERVAL 3 YEAR);
					END$$
	DELIMITER ;
	
	SET @v_COUNT = "";
	CALL CAU_10(@v_COUNT );		
	SELECT @v_COUNT AS TOTAL_REMOVE;			
			
			
			
	-- câu 11 :

	ALTER TABLE account DROP  Waiting_room;

	DROP PROCEDURE IF EXISTS CAU_11;
	DELIMITER $$
		CREATE PROCEDURE CAU_11(IN in_department_ment VARCHAR(100))
					BEGIN
								ALTER TABLE account ADD COLUMN Waiting_room VARCHAR(100);
								UPDATE account SET Waiting_room = 1 , DepartmentID = NULL  WHERE DepartmentID = (SELECT DepartmentID FROM department WHERE DepartmentName = in_department_ment);
								DELETE FROM department WHERE DepartmentName = in_department_ment;
					END $$
	DELIMITER ;
	
	
	CALL CAU_11('Sale');
	
	
		
	
	
	-- câu 12 :
	
DROP PROCEDURE IF EXISTS sta_question;
	DELIMITER $$
		CREATE PROCEDURE sta_question()
					BEGIN
									SELECT MONTH(CreateDate) AS ` THÁNG ` ,COUNT(QuestionID) AS ` SỐ LƯỢNG CÂU HỎI`
									FROM question
									GROUP BY MONTH(CreateDate);
					END$$
	DELIMITER ;

CALL sta_question();
	
	
	-- CÂU 13 : 
	
	DROP PROCEDURE IF EXISTS sta_question_six_month;
	DELIMITER $$
		CREATE PROCEDURE sta_question_six_month()
					BEGIN
							DROP TEMPORARY TABLE IF EXISTS 6month;
							CREATE TEMPORARY TABLE 6month AS
							SELECT YEAR(SYSDATE()) AS Year , MONTH(SYSDATE()) AS Month
							UNION
							SELECT YEAR(SYSDATE() - INTERVAL 1 MONTH) AS Year, MONTH(SYSDATE() - INTERVAL 1 MONTH) AS Month
							UNION
							SELECT YEAR(SYSDATE() - INTERVAL 2 MONTH) AS Year, MONTH(SYSDATE() - INTERVAL 2 MONTH) AS Month
							UNION
							SELECT YEAR(SYSDATE() - INTERVAL 3 MONTH)AS Year , MONTH(SYSDATE() - INTERVAL 3 MONTH) AS Month
							UNION
							SELECT YEAR(SYSDATE() - INTERVAL 4 MONTH) AS Year, MONTH(SYSDATE() - INTERVAL 4 MONTH) AS Month
							UNION
							SELECT YEAR(SYSDATE() - INTERVAL 5 MONTH) AS Year, MONTH(SYSDATE() - INTERVAL 5 MONTH) AS Month;
							
							DROP TEMPORARY TABLE IF EXISTS count_question;
							CREATE TEMPORARY TABLE count_question AS
							SELECT YEAR(CreateDate) AS Year, MONTH(CreateDate) AS Month , COUNT(*) AS TOTAL FROM question GROUP BY YEAR(CreateDate) , MONTH(CreateDate);

							SELECT a.Year , a.Month , CASE 
																						WHEN b.TOTAL > 0 THEN b.TOTAL
																						ELSE "KHÔNG CÓ CÂU HỎI NÀO TRONG THÁNG" END AS 'SỐ LƯỢNG CÂU HỎI'
							FROM 6month a LEFT JOIN count_question b ON a.Year = b.Year AND a.Month  = b.Month; 
															
					END$$
	DELIMITER ;

CALL sta_question_six_month();




