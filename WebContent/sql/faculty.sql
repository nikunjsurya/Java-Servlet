
/* 
Name: 
File: faculty.sql
Purpose: WEBD4201-WEB DEVELOPMENT ENTERPRISE Lab 2 
Student No: 1
Date: 2022-01-26
Description: this file is created as a sql file to create faculty table that will be 
used for the database web4201_db.

*/


-- Dropping tables clear out any existing data
DROP TABLE IF EXISTS faculty;
-- CREATE the table, note that id has to be unique, and you must have a name
CREATE TABLE faculty(
	id INT NOT NULL PRIMARY KEY REFERENCES users(id),
	schoolCode VARCHAR(15), 
	schoolDescription VARCHAR (255),
	office VARCHAR (20),
	extension INT
);

-- User 1 of type faculty
INSERT INTO faculty(id, schoolCode, schoolDescription, office, extension)
VALUES(

	100123456,
	'BITM',
	'Business and IT Management ',
	'C-134',
	324
);

-- User 2 of type faculty
INSERT INTO faculty(id, schoolCode, schoolDescription, office, extension)
VALUES(

	100743890,
	'BITM',
	'Information Technology ',
	'L-234',
	123
);

-- User 3 of type faculty
INSERT INTO faculty(id, schoolCode, schoolDescription,office,  extension)
VALUES(

	100245167,
	'BITM',
	'Business Management ',
	'A-178',
	456
);

select * from faculty;