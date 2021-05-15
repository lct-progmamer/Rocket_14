USE testingsystem;


-- CÂU 1 : Viết lệnh để lấy ra danh sách nhân viên và thông tin phòng ban của họ
SELECT 
    a.*
FROM `Account` AS a
LEFT JOIN Department AS b ON a.DepartmentID = b.DepartmentID
-- Câu 2 :  Viết lệnh để lấy ra thông tin các account được tạo sau ngày 20/12/2010
SELECT * FROM `Account`
WHERE CreateDate > '2010/12/20';

-- CÂU 3 : Viết lệnh để lấy ra tất cả các developer
SELECT a.* FROM `Account` AS a
LEFT JOIN `Position` AS b ON a.PositionID = b.PositionID
WHERE PositionName = 'Dev';

-- CÂU 4 : Viết lệnh để lấy ra danh sách các phòng ban có >3 nhân viên
SELECT a.* , GROUP_CONCAT(b.FullName)   FROM Department AS a
LEFT JOIN `Account` AS b ON a.DepartmentID = b.DepartmentID
GROUP BY a.DepartmentName
HAVING count(AccountID) > 3;
	


-- CÂU 5 : Viết lệnh để lấy ra danh sách câu hỏi được sử dụng trong đề thi nhiều nhất
SELECT	a.Content,a.QuestionID,count(*) FROM Question AS a
INNER JOIN ExamQuestion AS b ON a.QuestionID = b.QuestionID
GROUP BY a.QuestionID
HAVING COUNT(*)  = (SELECT COUNT(*) FROM ExamQuestion GROUP BY QuestionID ORDER BY COUNT(*) DESC LIMIT 1);


-- cách 2:



-- CÂU 6: Thông kê mỗi category Question được sử dụng trong bao nhiêu Question

SELECT a.CategoryID,count(b.QuestionID) AS ' SỐ LƯỢNG QuestionID'
FROM CategoryQuestion a LEFT JOIN Question b
ON a.CategoryID = b.CategoryID
GROUP BY a.CategoryID;

-- CÂU 7 : Thông kê mỗi Question được sử dụng trong bao nhiêu Exam
SELECT b.QuestionID , count(a.ExamID) AS 'SỐ LƯỢNG EXAM'
FROM  ExamQuestion a LEFT JOIN Question b
ON a.QuestionID = b.QuestionID
GROUP BY b.QuestionID;


-- CÂU 8 : Lấy ra Question có nhiều câu trả lời nhất
SELECT a.QuestionID , count(b.AnswerID) AS 'SỐ LƯỢNG TRẢ LỜI'
FROM Question a LEFT JOIN Answer b
ON a.QuestionID  = b.QuestionID
GROUP BY a.QuestionID;
HAVING COUNT(b.AnswerID) = (SELECT COUNT(AnswerID) FROM Answer GROUP BY 

-- CÂU 9: Thống kê số lượng account trong mỗi group


SELECT a.GroupID,COUNT(b.AccountID)
FROM `Group` a LEFT JOIN GroupAccount b
ON a.GroupID = b.GroupID 
GROUP BY a.GroupID;


-- CÂU 10 : Tìm chức vụ có ít người nhất

SELECT a.PositionName , COUNT(b.AccountID)
FROM `Position` a 
LEFT JOIN `Account` b
ON a.PositionID  = b.PositionID
GROUP BY a.PositionName
HAVING COUNT(b.AccountID) = (SELECT COUNT(AccountID) FROM `Account` GROUP BY PositionID ORDER BY COUNT(AccountID) LIMIT 1);

-- câu 11: Thống kê mỗi phòng ban có bao nhiêu dev, test, scrum master, PM

SELECT b.DepartmentName , a.FullName , c.PositionName , COUNT(*)
FROM `Account` a
LEFT JOIN Department b
ON a.DepartmentID  = b.DepartmentID
LEFT JOIN `Position` c
ON a.PositionID = c.PositionID
GROUP BY b.DepartmentName,c.PositionName;


-- câu 12 : Lấy thông tin chi tiết của câu hỏi bao gồm: thông tin cơ bản của question, loại câu hỏi, ai là người tạo ra câu hỏi, câu trả lời là gì, ...



SELECT a.QuestionID,c.TypeName,d.FullName , b.Content 
FROM Question a
LEFT JOIN  Answer b
ON a.QuestionID  = b.AnswerID
LEFT JOIN TypeQuestion c
ON a.TypeID = c.TypeID
LEFT JOIN `Account` d
ON a.CreatorID = d.AccountID;



-- CÂU 13  : Lấy ra số lượng câu hỏi của mỗi loại tự luận hay trắc nghiệm
SELECT a.TypeName,COUNT(b.QuestionID) AS 'SL CÂU HỎI'
FROM  TypeQuestion a
LEFT JOIN  Question b
ON a.TypeID = b.TypeID
GROUP BY a.TypeName;


-- CÂU 14 : Lấy ra group không có account nào

SELECT a.GroupID
FROM `group` a
LEFT JOIN groupaccount b
ON a.GroupID = b.GroupID
WHERE b.AccountID IS NULL;



-- CÂU 16 : Lấy ra question không có answer nào

SELECT a.QuestionID , b.AnswerID
FROM Question a
LEFT JOIN answer b
ON a.QuestionID = b.QuestionID
WHERE b.AnswerID IS NULL;


-- CÂU 17 UNION

-- a) Lấy các account thuộc nhóm thứ 1
-- b) Lấy các account thuộc nhóm thứ 2
-- c) Ghép 2 kết quả từ câu a) và câu b) sao cho không có record nào trùng nhau

SELECT a.AccountID , a.GroupID
FROM groupaccount a
WHERE GroupID = 1
UNION
SELECT a.AccountID , a.GroupID
FROM groupaccount a
WHERE GroupID = 2;

-- CÂU 18: 
-- a)Lấy các group có lớn hơn 5 thành viên
-- b) Lấy các group có nhỏ hơn 7 thành viên



SELECT a.GroupID , COUNT(b.AccountID)
FROM groupaccount a
LEFT JOIN account b
ON a.AccountID = b.AccountID
GROUP BY a.GroupID
HAVING COUNT(b.AccountID) >= 5
UNION ALL
SELECT a.GroupID , COUNT(b.AccountID)
FROM groupaccount a
LEFT JOIN account b
ON a.AccountID = b.AccountID
GROUP BY a.GroupID
HAVING COUNT(b.AccountID) < 7;


-- BTVN : KẾT QUẢ TRẢ VỀ MỖI PHÒNG BAN CẦN THỐNG KÊ RA CÁC CHỨC VỤ









