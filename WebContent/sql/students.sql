/*
Name: 
File: 
Purpose: WEBD4201-WEB DEVELOPMENT ENTERPRISE Lab 2
Student No: 
Date: 2022-01-26
Description: this file is created as a sql file to create student table that will be
used for the database web4201_db.

*/

-- Dropping tables clear out any existing data
DROP TABLE IF EXISTS students;
-- CREATE the table, note that id has to be unique, and you must have a name
CREATE TABLE students(
	id INT NOT NULL PRIMARY KEY REFERENCES users(id),
	program_code VARCHAR(20),
	program_description VARCHAR(50) ,
	year INT
);
-- User 1 of type student
INSERT INTO students(id, program_code, program_description, year)
VALUES(

	100743787,
	'CP',
	'Computer Programming',
	2
);
-- User 2 of type student
INSERT INTO students(id, program_code, program_description, year)
VALUES(

	101743797,
	'CPA',
	'Computer Programming and Analysis',
	3
);


-- User 3 of type student
INSERT INTO students(id, program_code, program_description, year)
VALUES(

	100111111,
	'CSTY',
	'Computer System Technology',
	3

);

select * from students;
