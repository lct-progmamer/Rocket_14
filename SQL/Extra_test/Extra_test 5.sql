USE adventureworks;

-- CÂU 1 :Viết 1 query lấy thông tin "Name" từ bảng Production.Product có namec Của ProductSubcategory là 'Saddles'.
SELECT
	`Name` 
FROM
	product 
WHERE
	ProductSubcategoryID IN ( SELECT ProductSubcategoryID FROM productsubcategory WHERE `Name` = 'Saddles' );
	
-- CÂU 2 : Thay đổi câu Query 1 để lấy được kết quả sau.
SELECT
	`Name` 
FROM
	product 
WHERE
	ProductSubcategoryID IN ( SELECT ProductSubcategoryID FROM productsubcategory WHERE `Name` LIKE 'Bo%' );
	
-- câu 3  Viết câu query trả về tất cả các sản phẩm có giá rẻ nhất (lowest ListPrice) và Touring Bike (nghĩa là ProductSubcategoryID = 3)
SELECT
	ProductID,
	`Name` 
FROM
	product 
WHERE
	ListPrice = ( SELECT MIN( ListPrice ) FROM product WHERE ProductSubcategoryID = ( SELECT ProductSubcategoryID FROM productsubcategory WHERE `Name` = 'Touring Bikes' ) );
	
-- CÂU 4 : Viết query lấy danh sách tên country và province được lưu trong AdventureWorks2008sample database.
SELECT
	a.`Name`,
	b.`Name` 
FROM
	countryregion a
	INNER JOIN stateprovince b ON a.CountryRegionCode = b.CountryRegionCode;

-- câu 5 : Tiếp tục với câu query trước và thêm điều kiện là chỉ lấy country Germany và Canada
SELECT
	a.`Name`,
	b.`Name` 
FROM
	countryregion a
	INNER JOIN stateprovince b ON a.CountryRegionCode = b.CountryRegionCode 
WHERE
	a.`Name` = 'Germany' 
	OR a.`Name` = 'Canada' 
ORDER BY
	a.`Name`;
	
-- câu 6 : Từ bảng SalesPerson, chúng ta lấy cột BusinessEntityID (là định danh của người sales), Bonus and the SalesYTD (là đã sale được bao nhiêu người trong năm nay)
SELECT
	a.SalesOrderID,
	a.OrderDate,
	b.SalesPersonID,
	b.SalesPersonID AS BusinessEntityID,
	b.Bonus,
	b.SalesYTD 
FROM
	salesorderheader a
	LEFT JOIN salesperson b ON a.SalesPersonID = b.SalesPersonID;


-- CÂU 7 :Sử dụng câu query ở question 3, thêm cột JobTitle and xóa cột SalesPersonID và BusinessEntityID.


	ALTER TABLE salesperson DROP JobTitle;
	
	ALTER TABLE salesperson ADD COLUMN JobTitle VARCHAR(50) NOT NULL;
	
	UPDATE  salesperson
	SET JobTitle = 'Sales Representative'
	WHERE JobTitle IS NOT NULL;

	
	
	