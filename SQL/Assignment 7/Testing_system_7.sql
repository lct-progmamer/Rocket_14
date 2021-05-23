USE testingsystem;


-- CÂU 1 : Tạo trigger không cho phép người dùng nhập vào Group có ngày tạo trước 1 năm trước


INSERT INTO `group` (GroupID , GroupName  , CreatorID  , CreateDate)
VALUES 							(24,'HIHIHE','1','2021-1-09 00:00:00');


DROP TRIGGER IF EXISTS CAU_1; 
DELIMITER $$

CREATE TRIGGER CAU_1
		
			BEFORE INSERT ON `group`
			FOR EACH ROW
			BEGIN
					IF NEW.`CreateDate` >  DATE_SUB(NOW() , INTERVAL 1 YEAR)  THEN
						SIGNAL SQLSTATE '12345'
						SET MESSAGE_TEXT = 'KHÔNG THỂ CHÈN VÀO GROUP ĐƯỢC TẠO DƯỚI 1 NĂM ';
					END IF; 
					
			END $$
DELIMITER ;



/* CÂU 2 : Tạo trigger Không cho phép người dùng thêm bất kỳ user nào vào
department "Sale" nữa, khi thêm thì hiện ra thông báo "Department
"Sale" cannot add more user" */


INSERT INTO `Account`(Email								, Username			, FullName				, DepartmentID	, PositionID, CreateDate)
VALUES 							('Email20@gmail.com'				, 'Username20'		,'Fullname20'				,   '2'			,   '1'		,'2020-03-05');



DROP TRIGGER IF EXISTS CAU_2;
DELIMITER $$
CREATE TRIGGER CAU_2
			BEFORE INSERT ON `Account`
			FOR EACH ROW
			BEGIN
					IF NEW.`DepartmentID` = 2 THEN 
						SIGNAL SQLSTATE '46001'
						SET MESSAGE_TEXT = " Department Sale cannot add more user";
					END IF;
		END $$
			
DELIMITER ;

-- CÂU 3 : Cấu hình 1 group có nhiều nhất là 5 user


INSERT INTO `GroupAccount`	(  GroupID	, AccountID	, JoinDate	 )
VALUES 					          	(	1		,    8		,'2019-03-05');




DROP TRIGGER IF EXISTS CAU_3;
DELIMITER $$
	
	CREATE TRIGGER CAU_3
				BEFORE INSERT	ON groupaccount
				FOR EACH ROW
				BEGIN
					SET @v_count_account = (SELECT COUNT(AccountID) FROM groupaccount WHERE GroupID = NEW.GroupID);
					IF @v_count_account = 5 THEN
					IF @v_count_account >= 5 THEN
						SIGNAL SQLSTATE '15423'
						SET MESSAGE_TEXT = "MỖI GROUP TỐI ĐA 5 ACC ! , KHÔNG THỂ INSERT THÊM ";
					END IF;
					
				END $$

DELIMITER ;

-- CÂU 4 : Cấu hình 1 bài thi có nhiều nhất là 10 Question

INSERT INTO ExamQuestion(ExamID	, QuestionID	) 
VALUES 										(	1	,		4	);
 
DROP TRIGGER IF EXISTS CAU_4;
DELIMITER $$
	CREATE TRIGGER CAU_4
			BEFORE INSERT ON ExamQuestion
			FOR EACH ROW
			BEGIN
						SET @v_count_ques	= (SELECT COUNT(QuestionID) FROM examquestion WHERE ExamID = NEW.ExamID);
						IF @v_count_ques >= 10 THEN 
								SIGNAL SQLSTATE '15234'
								SET MESSAGE_TEXT = "MỖI BÀI THI TỐI ĐA 10 CÂU HỎI !!";
						
						END IF;
			END $$
DELIMITER ;


SELECT ExamID,COUNT(QuestionID) FROM examquestion GROUP BY ExamID;

/* CÂU 5 : Tạo trigger không cho phép người dùng xóa tài khoản có email là
admin@gmail.com (đây là tài khoản admin, không cho phép user xóa),
còn lại các tài khoản khác thì sẽ cho phép xóa và sẽ xóa tất cả các thông
tin liên quan tới user đó */ 




DELETE FROM account WHERE Email = "Email1@gmail.com";

DROP TRIGGER IF EXISTS CAU_5;
DELIMITER $$
	
	CREATE TRIGGER CAU_5
				BEFORE DELETE ON account
				FOR EACH ROW
				BEGIN
						DECLARE v_account_id INT;
						SELECT AccountID INTO v_account_id FROM account WHERE Email = OLD.Email;
						
						
						IF OLD.Email = "admin@gmail.com" THEN 
								SIGNAL SQLSTATE '12532'
								SET MESSAGE_TEXT = "KHÔNG ĐƯỢC CẤP QUYỀN XÓA ! ";
						ELSE
								DELETE FROM groupaccount WHERE AccountID = v_account_id ;
								DELETE FROM `group` WHERE CreatorID = v_account_id;
								DELETE FROM question WHERE CreatorID = v_account_id ;
								DELETE FROM exam WHERE CreatorID = v_account_id;
						END IF;
				END $$
DELIMITER ;

/* câu 6 : Không sử dụng cấu hình default cho field DepartmentID của table
Account, hãy tạo trigger cho phép người dùng khi tạo account không điền
vào departmentID thì sẽ được phân vào phòng ban "waiting Department" */




INSERT INTO account (Email , Username , FullName , PositionID , CreateDate)
VALUES 							('chitai@gmail.com' , 'chitai' ,'Lê Chí Tài', 1,NOW());




DROP TRIGGER IF EXISTS CAU_6;
DELIMITER $$

CREATE TRIGGER CAU_6
				BEFORE INSERT ON account
				FOR EACH ROW
				BEGIN
						IF NEW.DepartmentID IS NULL THEN
									
									UPDATE account SET waiting_department = 1 WHERE DepartmentID = NEW.DepartmentID;;
						END IF;
				END $$

DELIMITER ;


 -- câu 7 : Cấu hình 1 bài thi chỉ cho phép user tạo tối đa 4 answers cho mỗi question, trong đó có tối đa 2 đáp án đúng.
 
INSERT INTO answer (Content , QuestionID , isCorrect)
VALUES							('CÂU TRẢ LỜI 11' ,1,1);
 
 DELIMITER $$
 
	CREATE TRIGGER CAU_7
				BEFORE INSERT ON answer
				FOR EACH ROW
				BEGIN
						SET @v_count_question = ()
						SET @v_count_iscorrect
						IF 
						
				
				
				END $$
 
 
 DELIMITER ;

/* CÂU 8:Viết trigger sửa lại dữ liệu cho đúng:
Nếu người dùng nhập vào gender của account là nam, nữ, chưa xác định
Thì sẽ đổi lại thành M, F, U cho giống với cấu hình ở database */

ALTER TABLE account DROP Gender;
ALTER TABLE account ADD COLUMN Gender NVARCHAR(50);

UPDATE account SET Gender = "CHƯA XÁC ĐỊNH" WHERE Gender IS NULL;


DROP TRIGGER IF EXISTS CAU_8;
DELIMITER $$

	CREATE TRIGGER CAU_8
				BEFORE UPDATE ON account
				FOR EACH ROW
				BEGIN
						IF NEW.Gender = "NAM" THEN
								SET NEW.Gender = "M";
						
						END IF;
						IF NEW.Gender = "NỮ" THEN 
								SET NEW.Gender  = "F";
						END IF;
						IF NEW.Gender  = "CHƯA XÁC ĐỊNH" THEN
								SET NEW.Gender = "U";
						END IF;
						
				
				END $$	
DELIMITER ;


											
											


-- câu 9 : Viết trigger không cho phép người dùng xóa bài thi mới tạo được 2 ngày

DELETE FROM exam WHERE CreateDate = "2021-05-21 00:00:00";

DROP TRIGGER IF EXISTS CAU_9;
DELIMITER $$
	CREATE TRIGGER CAU_9
				BEFORE DELETE  ON exam
				FOR EACH ROW
				BEGIN	
						IF OLD.CreateDate > DATE_SUB(NOW(),INTERVAL 2 DAY) THEN
								SIGNAL SQLSTATE '12534'
								SET MESSAGE_TEXT = "KHÔNG XÓA ĐƯỢC ĐỀ THI TẠO DƯỚI 2 NGÀY !";
						END IF;
				END $$
DELIMITER ;


-- câu 10 : Viết trigger chỉ cho phép người dùng chỉ được update, delete các question khi question đó chưa nằm trong exam nào





/* câu 12 : Lấy ra thông tin exam trong đó:

Duration <= 30 thì sẽ đổi thành giá trị "Short time"
30 < Duration <= 60 thì sẽ đổi thành giá trị "Medium time"
Duration > 60 thì sẽ đổi thành giá trị "Long time" */

SELECT
	ExamID , `Code` , Title , CategoryID , CreatorID , CreateDate ,
		CASE
		
		WHEN Duration <= 30 THEN "Short Time"
		WHEN Duration > 30 AND Duration <= 60 THEN "Medium Time"
		ELSE "Long Time" 
			END AS `Duration` 
	FROM
		exam;

/* CÂU 13 :Thống kê số account trong mỗi group và in ra thêm 1 column nữa có tên
là the_number_user_amount và mang giá trị được quy định như sau:
Nếu số lượng user trong group =< 5 thì sẽ có giá trị là few
Nếu số lượng user trong group <= 20 và > 5 thì sẽ có giá trị là normal
Nếu số lượng user trong group > 20 thì sẽ có giá trị là higher
 */


DROP PROCEDURE IF EXISTS CAU_13;
DELIMITER $$
		
		CREATE PROCEDURE CAU_13()
					BEGIN
							SELECT
								GroupID AS 'NHÓM',COUNT(AccountID) AS 'SỐ LƯỢNG USER' , CASE 
																																				WHEN COUNT(AccountID) <= 5  THEN 'FEW'
																																				WHEN COUNT( AccountID ) <= 20 AND COUNT( AccountID ) > 5 THEN 'NORMAL' 
																																				ELSE 'HIGHER'
																																				END AS the_number_user_amount
								FROM
									groupaccount 
								GROUP BY
									GroupID;
					
					END $$
DELIMITER ;

CALL CAU_13();

-- câu 14 : Thống kê số mỗi phòng ban có bao nhiêu user, nếu phòng ban nào không có user thì sẽ thay đổi giá trị 0 thành "Không có User"

SELECT
	b.DepartmentName AS 'PHÒNG BAN',
	CASE
			WHEN COUNT( a.AccountID ) > 0  THEN COUNT( a.AccountID )
			ELSE 'KHÔNG CÓ USER'
	END AS 'SÓ LƯỢNG ACC'
FROM
	`account` a
	RIGHT JOIN department b ON a.DepartmentID = b.DepartmentID 
GROUP BY
	b.DepartmentID;