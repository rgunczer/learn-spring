USE master
GO

CREATE DATABASE school
GO

USE school
GO

CREATE TABLE student (
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](250) NOT NULL,
	[dob] SMALLINT NOT NULL
)
GO

INSERT INTO student ([name], [dob])
VALUES
('Jack', 1900),
('Joe', 1901),
('Jeff', 1900)
GO

SELECT * FROM student

CREATE PROCEDURE uspGetStudentsBornIn @Dob INT
AS
SELECT *
FROM student
WHERE dob = @Dob
GO

EXEC dbo.uspGetStudentsBornIn @Dob = 1900

-- DROP PROCEDURE uspGetStudentsBornIn
-- DROP TABLE student
