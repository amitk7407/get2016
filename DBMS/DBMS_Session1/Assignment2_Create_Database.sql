/*Q1. Create all tables of LIS*/


/*create database LIS*/
CREATE DATABASE Library_Management_System;

/*Open datase LIS*/
USE library_management_system;

/*create table members*/
CREATE TABLE members(
	member_id INT AUTO_INCREMENT,
	member_name VARCHAR(100) NOT NULL,
	address_line1 VARCHAR(150) NOT NULL,
	address_line2 VARCHAR(150) NOT NULL,
	category VARCHAR(1) NOT NULL,
	PRIMARY KEY(member_id)
);


/*create table publishers*/
CREATE TABLE publishers(
	publisher_id INT AUTO_INCREMENT,
	publisher_name VARCHAR(100) NOT NULL,
	PRIMARY KEY(publisher_id)
);


/*create table subjects*/
CREATE TABLE subjects(
	subject_id INT AUTO_INCREMENT,
	subject_name VARCHAR(100) NOT NULL,
	PRIMARY KEY(subject_id)
);

	
/*create table authors*/
CREATE TABLE authors(
	author_id INT AUTO_INCREMENT,
	author_name VARCHAR(100) NOT NULL,
	PRIMARY KEY(author_id)
);

	
/*create table titles*/
CREATE TABLE titles(
	title_id INT AUTO_INCREMENT,
	title_name VARCHAR(100) NOT NULL,
	subject_id INT NOT NULL,
	publisher_id INT NOT NULL,
	FOREIGN KEY(subject_id) REFERENCES subjects(subject_id),
	FOREIGN KEY(publisher_id) REFERENCES publishers(publisher_id),
	PRIMARY KEY(title_id)
);


/*create table books*/
CREATE TABLE books(
	accession_no INT AUTO_INCREMENT,
	title_id INT NOT NULL,
	purchase_date DATE NOT NULL,
	price INT NOT NULL,
	status VARCHAR(200) NOT NULL,
	FOREIGN KEY(title_id) REFERENCES titles(title_id),
	PRIMARY KEY(accession_no)
);


/*create table book_issue*/
CREATE TABLE book_issue(
	issue_date DATE NOT NULL,
	accession_no INT NOT NULL,
	member_id INT NOT NULL,	
	due_date DATE NOT NULL,
	PRIMARY KEY(issue_date, accession_no, member_id),
	FOREIGN KEY(member_id) REFERENCES members(member_id),
	FOREIGN KEY(accession_no) REFERENCES books(accession_no)
);


/*create table book_return*/
CREATE TABLE book_return(
	return_date DATE NOT NULL,
	accession_no INT NOT NULL,
	member_id INT NOT NULL,
	issue_date DATE NOT NULL,
	PRIMARY KEY(return_date, accession_no, member_id),
	FOREIGN KEY(accession_no) REFERENCES books(accession_no),
	FOREIGN KEY(member_id) REFERENCES members(member_id)
);


/*create table title_author*/
CREATE TABLE title_author(	
	title_id INT NOT NULL,
	author_id INT NOT NULL,
	PRIMARY KEY(title_id, author_id),
	FOREIGN KEY(title_id) REFERENCES titles(title_id),
	FOREIGN KEY(author_id) REFERENCES authors(author_id)
);

/*Q2. Show all tables in LIS*/
SHOW TABLES;