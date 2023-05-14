/*
Name: 
File: 
Purpose:
Student 
Date: 
Description: this file is created as a sql file to create users table that will be
used for the database web4201_db.

*/

CREATE EXTENSION IF NOT EXISTS pgcrypto;
-- Dropping tables clear out any existing data
DROP TABLE IF EXISTS users CASCADE;
-- CREATE the table, note that id has to be unique, and you must have a name
CREATE TABLE users(
	id INT PRIMARY KEY NOT NULL,
	email VARCHAR(255) 	NOT NULL,
	password VARCHAR(40) NOT  NULL,
	first_name VARCHAR(20) NOT NULL,
	last_name VARCHAR (30) NOT NULL,
	last_access DATE,
	enrolDate DATE NOT NULL,
	enable BOOLEAN NOT NULL,
	type VARCHAR(1) NOT NULL
);

-- inserting records for 6 users

-- User 1 of type student
INSERT INTO users(id, email, password, first_name, last_name, last_access,enrolDate,
enable, type)
VALUES(

	100743787,
	'misha.mansoor@dcmail.ca',
	ENCODE(DIGEST('dark','sha1'),'hex'),
	'Misha',
	'Mansoor',
	'2022-01-26',
	'2021-01-10',
	'true',
	's'
);
-- User 2 of type student
INSERT INTO users(id, email, password, first_name, last_name, last_access,enrolDate,
enable, type)
VALUES(

	101743797,
	'jdoe@dcmail.ca',
    	ENCODE(DIGEST('testpass','sha1'),
    		   'hex'),
    	'John',
    	'Doe',
    	'2022-01-26',
    	'2021-06-22',
    	'true',
    	's'
);

-- User 3 of type student
INSERT INTO users(id, email, password, first_name, last_name, last_access,enrolDate,
enable, type)
VALUES(

	100111111,
	'mike.jones@dcmail.ca',
    ENCODE(DIGEST('password','sha1'),
        'hex'),
    'Mike',
    'Jones',
    '2022-01-26',
    '2015-09-11',
    'true',
    's'
);

--User 4 of type faculty
INSERT INTO users(id, email, password, first_name, last_name, last_access,enrolDate,
enable, type)
VALUES(

	100123456,
	'darren@durhamcollege.ca',
	ENCODE(DIGEST('puffer','sha1'),
		   'hex'),
	'Darren',
	'Puffer',
	'2022-01-26',
	'2015-06-22',
	'true',
	'f'
);
--User 5 of type faculty
INSERT INTO users(id, email, password, first_name, last_name, last_access,enrolDate,
enable, type)
VALUES(

	100743890,
	'sue@durhamcollege.ca',
	ENCODE(DIGEST('pratt','sha1'),
		   'hex'),
	'Susan',
	'Pratt',
	'2022-01-26',
	'2016-06-22',
	'true',
	'f'
);
--User 6 of type faculty
INSERT INTO users(id, email, password, first_name, last_name, last_access,enrolDate,
enable, type)
VALUES(

	100245167,
	'jennifer@durhamcollege.ca',
	ENCODE(DIGEST('test','sha1'),
		   'hex'),
	'Jen',
	'Short',
	'2022-01-26',
	'2017-06-22',
	'true',
	'f'
);

select * from users;



