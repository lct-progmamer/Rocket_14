USE testingsystem;

SELECT *
FROM department;

SELECT DepartmentID-- 
FROM department
WHERE DepartmentName = 'SALE';

-- // CACH 1
SELECT * FROM `Account`ORDER BY char_length(FullName) DESC
limit 1;

-- //CACH 2--
-- LAY DO DAI LON NHAT
SELECT  MAX(Char_length(FullName)) 
FROM Account; 
-- LAY RA TEN DAI NHAT 
SELECT * FROM account WHERE char_length(FULLNAME) = 10;
-- CACH 3 LAM LONG : 
SELECT * FROM account WHERE char_length(FULLNAME)=(SELECT MAX(Char_length(FullName)) FROM account);


-- CAU 6
SELECT GroupName FROM `Group` 
WHERE CreateDate < '2019/12/20';


-- CAU 7
SELECT QuestionID
FROM answer
GROUP BY QuestionID
HAVING count(QuestionID) >= 4;


-- CAU 8
SELECT `Code`
FROM Exam
WHERE Duration <= 60 AND CreateDate < '2019/12/20';
-- cau 9

-- CACH  LIMTIT
SELECT GroupName
FROM `Group`
ORDER BY CreateDate DESC 
LIMIT 5;

-- CAU 10
SELECT count(AccountID)
FROM `Account`
WHERE DepartmentID = 2;
-- CAU 11

SELECT count(AccountID)
FROM `Account`
WHERE FullName LIKE 'D%O';

-- CAU 12
DELETE  FROM Exam
WHERE CreateDate < '2019/12/20';

-- CAU 13
DELETE FROM Question
WHERE Content LIKE 'Câu hỏi%';

-- cau 14
UPDATE `Account`
SET Email = 'loc.nguyenba@vti.com.vn' , FullName = 'Nguyễn Bá Lộc'
WHERE AccountID = 5;

-- CAU 15
UPDATE `Group`
SET GroupID = 11
WHERE CreatorID = 5;










