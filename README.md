# create database
CREATE DATABASE test CHARACTER SET utf8;

USE test;

# create table
CREATE TABLE tbl_account(
	id INT PRIMARY KEY auto_increment,
	`name` VARCHAR(20),
	money DOUBLE
)ENGINE INNODB CHAR SET utf8;

# Insert test data
INSERT INTO tbl_account VALUES
	(NULL, 'Switch', 10000),
	(NULL, 'Kity', 20000);

# select data
SELECT * FROM tbl_account;