
DROP DATABASE IF EXISTS Testing_Management;

CREATE DATABASE Testing_Management;
USE Testing_Management;



CREATE TABLE Department(
	DepartmentID	INT,
    DepartmentName	VARCHAR(50)
);


CREATE TABLE `Position`(
	PositionID		INT,
    PositionName	VARCHAR(50)
);

CREATE TABLE `Account`(
	AccountID		INT,
    Email			VARCHAR(100),
    Username		VARCHAR(50),
    Fullname 		VARCHAR(50),
    DepartmentID	INT,
    PositionID		INT,
    CreateDate		DATE
);

CREATE TABLE `Group`(
	GroupID			INT,
    GroupName		VARCHAR(100),
    Username		VARCHAR(50),
    CreatorID		INT,
    CreateDate		Date
);

CREATE TABLE GroupAccount(
	GroupID			INT,
    AccountID		INT,
    JoinDate		Date
   
);


CREATE TABLE TypeQuestion(
	TypeID		INT,
    TypeName	VARCHAR(50)
);

CREATE TABLE CatetoryQuestion(
	CatetoryID		INT,
    CatetoryName	VARCHAR(50)
);

CREATE TABLE Question(
	QuestionID		INT,
    Content			VARCHAR(200),
    TypeID			INT,
	CatetoryID		INT,
	CreatorID		INT,
    CreateDate		Date
);

CREATE TABLE Answer(
	AnswerID	INT,
    Content		VARCHAR(200),
	QuestionID	INT,
    isCorrect	boolean
);



CREATE TABLE Exam(
	ExamID			INT,
    `Code`			INT,
	Title			VARCHAR(50),
    CatetoryID		INT,
    Duration		Date,
    CreatorID		INT,
    CreateDate		Date
    
);

CREATE TABLE ExamQuestion(
	ExamID		INT,
    QuestionID	INT	
);




