CREATE DATABASE IF NOT EXISTS employee_details;

USE employee_details;

CREATE TABLE employee(
ID INT PRIMARY KEY,
name VARCHAR(50),
age TINYINT,
gender VARCHAR(6),
address VARCHAR(150)
);