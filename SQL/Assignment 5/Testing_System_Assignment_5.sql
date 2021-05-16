USE testing_management;


-- CâU 1: Tạo view có chứa danh sách nhân viên thuộc phòng ban sale

DROP VIEW IF EXISTS Sale_staff;
-- cách 1 : nối 
CREATE VIEW Sale_staff AS 
SELECT
b.* 
FROM
	Department a
	INNER JOIN `Account` b ON a.DepartmentID = b.DepartmentID 
WHERE
	A.DepartmentName = 'Sale';

-- cách 2 : subquery 
DROP VIEW
IF
	EXISTS Sale_staff;
CREATE VIEW Sale_staff AS SELECT
a.FullName AS 'TÊN NHÂN VIÊN',
a.Username AS ' NICK NAME' 
FROM
	`Account` a 
WHERE
	a.DepartmentID = ANY ( SELECT DepartmentID FROM Department WHERE DepartmentName = 'Sale' );
	
	
	
SELECT *
FROM Sale_staff;


-- CÂU 2 : 
DROP VIEW IF EXISTS HI;
CREATE VIEW HI AS
	SELECT
		a.AccountID,
		a.FullName,
		COUNT( b.GroupID ) 
	FROM
		`Account` a
		LEFT JOIN GroupAccount b ON a.AccountID = b.AccountID 
	GROUP BY
		a.AccountID 
	HAVING
	COUNT( b.GroupID ) = ( SELECT COUNT( GroupID ) FROM GroupAccount GROUP BY AccountID ORDER BY COUNT( GroupID ) DESC LIMIT 1 );




-- CÂU 3 : Tạo view có chứa câu hỏi có những content quá dài (content quá 300 từ được coi là quá dài) và xóa nó đi
DROP VIEW IF EXISTS Content_too_long;
CREATE VIEW Content_too_long AS SELECT
QuestionID 
FROM
	Question 
WHERE
	QuestionID IN  (SELECT QuestionID FROM Question WHERE CHAR_LENGTH(Content) > 300);

-- CÂU 4 :  Tạo view có chứa danh sách các phòng ban có nhiều nhân viên nhất
DROP VIEW IF EXISTS HU;
CREATE VIEW HU AS 
	SELECT
		DepartmentName,
		COUNT( a.AccountID ) AS TOTAL 
	FROM
		`Account` a
		LEFT JOIN Department b ON a.DepartmentID = b.DepartmentID 
	GROUP BY
		a.DepartmentID 
	HAVING
		TOTAL = ( SELECT COUNT( AccountID ) FROM `Account` GROUP BY DepartmentID ORDER BY COUNT( AccountID ) LIMIT 1 );
		
-- CÂU 5  : Tạo view có chứa tất các các câu hỏi do user họ Nguyễn tạo


DROP VIEW IF EXISTS HE;
CREATE VIEW HE AS
	SELECT b.QuestionID,b.Content,a.FullName
	FROM
		`Account` a
	LEFT JOIN Question b
	ON a.AccountID = b.CreatorID
	WHERE a.AccountID IN (SELECT AccountID FROM `Account` WHERE FullName LIKE '%Nguyen' OR FullName LIKE 'Nguyen%');


