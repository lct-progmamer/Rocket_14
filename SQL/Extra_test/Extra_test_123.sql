
-- ==== XÓA DATABASE NẾU ĐÃ TỒN TẠI === ---
DROP DATABASE IF EXISTS Trainning_Management;
CREATE DATABASE Trainning_Management;

USE Trainning_Management;


-- create table trainer
DROP TABLE IF EXISTS `Account`;
CREATE TABLE `Account`(
	TraineeID			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Full_Name			NVARCHAR(50) NOT NULL,
    Birth_Date			DATE NOT NULL,
    Gender				ENUM('male','female','unknown'),
    ET_IQ				TINYINT UNSIGNED Not NULL CHECK(ET_IQ>=0 AND ET_IQ <= 20),
    ET_Gmath			TINYINT UNSIGNED NOT NULL CHECK(ET_Gmath >= 0 AND ET_Gmath<=20), 
    Et_English			TINYINT	UNSIGNED NOT NULL CHECK(Et_English >= 0 AND Et_English<=50),
    Train_Class			CHAR(10) NOT NULL,
    Evaluation_Notes	TINYTEXT NOT NULL
);
ALTER TABLE `Account` ADD VTI_Account VARCHAR(20) NOT NULL UNIQUE;
ALTER TABLE `Account` ADD birth_month TINYINT NOT NULL;

-- create table 2

DROP TABLE IF EXISTS  Person;
CREATE TABLE Person(
	PersonID		TINYINT	AUTO_INCREMENT PRIMARY KEY,
    PersonName		NVARCHAR(50) NOT NULL,
    `Code`			CHAR(5)	NOT NULL UNIQUE , 
    ModifiedDate	DATETIME DEFAULT NOW()
);
-- create table 3
DROP TABLE IF EXISTS INFOR;
CREATE TABLE INFOR(
	ID		TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `Name`	NVARCHAR(20) NOT NULL,
    BirthDate	DATE NOT NULL,
    Gender		BIT,
    IsDeletedFlag	BIT DEFAULT 1
    
);


INSERT INTO `Account`(TraineeID , Full_Name , Birth_Date , Gender, ET_IQ , ET_Gmath , Et_English , Train_Class , Evaluation_Notes,VTI_Account,birth_month)
VALUES 				(' 1' ,      'FULLNAME1','2021/1/1',  'male','15' , ' 15' , ' 19' , 'hihi1', 'note1','hi',1),
					(' 2' ,      'FULLNAME2','2021/2/1',  'male','12' , ' 11' , ' 12' , 'hihi3', 'note12','hu',2),
                    (' 3' ,      'FULLNAME3','2021/3/1',  'male','13' , ' 11' , ' 12' , 'hihi4', 'note13','ho',3),
                    (' 4' ,      'FULLNAME4','2021/4/1',  'male', '14' , ' 11' , ' 12' , 'hihi4', 'note14','hehe',4),
                    (' 5' ,      'FULLNAME5','2021/5/1',  'male', '15' , ' 11' , ' 12' , 'hihi5', 'note15','htt',5),
                    (' 6' ,      'FULLNAME6','2021/2/12',  'female','16' , ' 7' , ' 9' , 'hihi3', 'note121','hu2',6),
                    (' 7' ,      'FULLNAME7','2021/3/13',  'female','17' , ' 19' , ' 0' , 'hihi45', 'note131','ho3',7),
                    (' 8' ,      'FULLNAME8','2021/4/14',  'female', '8' , ' 20' , ' 4' , 'hihi46', 'note142','hehe4',8),
                    (' 9' ,      'FULLNAME9','2021/5/15',  'female', '18' , ' 18' , ' 5' , 'hihi57', 'note153','htt5',9),
                    (' 10' ,      'FULLNAME10','2021/2/16',  'female','18' , ' 16' , ' 6' , 'hihi38', 'note124','hu6',10),
                    (' 11' ,      'FULLNAME11','2021/3/17',  'female','3' , ' 11' , ' 7' , 'hihi49', 'note135','ho7',9);


INSERT INTO Person(PersonID , PersonName , `Code` , ModifiedDate)
VALUES			('1' , 'name1','abc1','2021/2/3'),
				('2' , 'name2','abc2','2021/2/4'),
                ('3' , 'name3','abc3','2021/2/5'),
                ('4' , 'name4','abc4','2021/2/6'),
                ('5' , 'name5','abc5','2021/2/6'),
				('6' , 'name6','abc6','2021/2/4'),
                ('7' , 'name7','abc7','2021/2/5'),
                ('8' , 'name8','abc8','2021/2/6'),
                ('9' , 'name9','abc9','2021/2/6'),
				('11' , 'name9','abc10','2021/2/4'),
                ('12' , 'name10','abc11','2021/2/5');
     
                
                
                
INSERT INTO INFOR(ID , `Name` , BirthDate , Gender)
VALUES			('1' , 'name1','2021/2/3',1),
				('2' , 'name2','2021/2/4',0),
                ('3' , 'name3','2021/2/5',1),
                ('4' , 'name4','2021/2/6',1),
                ('5' , 'name5','2021/2/7',0),
                ('6' , 'name6','2021/2/8',0),
                ('7' , 'name7','2021/2/9',1),
                ('8' , 'name8','2021/2/10',1),
                ('9' , 'name9','2021/2/11',0),
                ('10' , 'name11','2021/2/12',0),
                ('11' , 'name12','2021/2/13',1);
  
-- lấy ra các thực tập sinh đã vượt qua bài test đầu vào: 
SELECT * FROM `Account`
WHERE 	ET_IQ>=10 AND ET_Gmath>=10 AND Et_English>=10
ORDER BY birth_month;
  
  
  
  
  
-- CAU 1 : Viết lệnh để lấy ra thực tập sinh có tên dài nhất, lấy ra các thông tin sau:
-- tên, tuổi, các thông tin cơ bản (như đã được định nghĩa trong table)
SELECT MAX(char_length(Full_Name)) FROM `Account`;
SELECT * FROM `Account`
WHERE char_length(Full_Name) = 10;

-- CAU 2:
SELECT * FROM `Account`
WHERE (ET_IQ+ET_Gmath)>=20 AND ET_IQ>=10 AND ET_Gmath>=10 AND Et_English>=18;



-- câu 3 : xóa các thực tập sinh có TraineeID = 3
DELETE FROM `Account`
WHERE TraineeID = 3;

-- CÂU 4 : Thực tập sinh có TraineeID = 5 được chuyển sang lớp "2". Hãy cập nhật thông tin vào database


UPDATE `Account`
SET Train_Class = 2
WHERE TraineeID =5 ;



                
                
                

                
