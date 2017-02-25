CREATE TABLE users (id INT NOT NULL PRIMARY KEY AUTO_INCREMENT, 
username varchar(50),
password VARCHAR(10),
role VARCHAR(10) default 'student');


CREATE TABLE school_details (id INT NOT NULL PRIMARY KEY AUTO_INCREMENT, 
shcool_name varchar(50),
shcool_address VARCHAR(50),
shcool_principal VARCHAR(30),
university_code INT(10));


CREATE TABLE classes (id INT NOT NULL PRIMARY KEY AUTO_INCREMENT, 
standard int(10),
class_teacher VARCHAR(20),
intake INT(10));


CREATE TABLE teachers (id INT NOT NULL PRIMARY KEY AUTO_INCREMENT, 
teachar_name varchar(30),
subject VARCHAR(20),
degree VARCHAR(20),
mobile_no INT(10),
gender VARCHAR(10));



CREATE TABLE students (id INT NOT NULL PRIMARY KEY AUTO_INCREMENT, 
student_rno int(10),
student_name VARCHAR(30),
standard VARCHAR(20),
mobile_no INT(10));


CREATE TABLE attendance (id INT NOT NULL PRIMARY KEY AUTO_INCREMENT, 
student_rno int(10),
student_name VARCHAR(30),
standard VARCHAR(20),
class_teachers VARCHAR(30));