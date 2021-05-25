USE assignment6;


/* câu 1 
Viết triggers để tránh trường hợp người dùng nhập thông tin module Project không hợp
lệ
(Project_Modules.ProjectModulesDate < Projects.ProjectStartDate,
Project_Modules.ProjectModulesCompletedOn > Projects.ProjectCompletedOn)
*/
INSERT INTO Project_Modules (`ProjectID`, `ProjectModulesDate`, `ProjectModulesCompletedOn`, `ProjectModulesDescription`)
VALUES ('2', '2019/9/20', '2020/9/20', 'Lashinbang module 3');


DROP TRIGGER IF EXISTS CAU_D;
DELIMITER $$

		CREATE TRIGGER CAU_D
					BEFORE INSERT ON Project_Modules
					FOR EACH ROW
					BEGIN
								DECLARE Project_start_date DATE;
								DECLARE projects_completed DATE;
								SELECT ProjectStartDate INTO Project_start_date FROM projects WHERE ProjectID = NEW.ProjectID;
								SELECT ProjectCompletedOn INTO projects_completed FROM projects WHERE ProjectID = NEW.ProjectID;
								IF NEW.ProjectModulesDate < Project_start_date THEN
										SIGNAL SQLSTATE '12321'
										SET MESSAGE_TEXT = "LỖI NGÀY  ProjectModulesDate !!!";
								END IF;
								IF NEW.ProjectModulesCompletedOn > projects_completed THEN
										SIGNAL SQLSTATE '13241'
										SET MESSAGE_TEXT = "LỖI NGÀY ProjectModulesCompletedOn !!!";
								END IF;
					END $$
DELIMITER ;




USE trainning_management;
/* câu 2 :
Trong database phần Assignment 3, Tạo 1 VIEW để lấy ra tất cả các thực tập sinh là
ET, 1 ET thực tập sinh là những người đã vượt qua bài test đầu vào và thỏa mãn số
điểm như sau:

 ET_IQ + ET_Gmath>=20
 ET_IQ>=8
 ET_Gmath>=8
 ET_English>=18
*/

CREATE VIEW CAU_2 AS
	SELECT * FROM `Account`
	WHERE (ET_IQ+ET_Gmath)>=20 AND ET_IQ>=10 AND ET_Gmath>=10 AND Et_English>=18;

SELECT * FROM CAU_2;


