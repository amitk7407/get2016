/*create database country*/
CREATE DATABASE country;

/*open database country*/
USE country;

/*create table city_zip*/
CREATE TABLE city_zip(
    city_name VARCHAR(100),
    zip_code VARCHAR(10),
    PRIMARY KEY(zip_code)
);

/*create table state*/
CREATE TABLE state(
    state_name VARCHAR(100),
    zip_code VARCHAR(10),
    PRIMARY KEY(state_name, zip_code),
    FOREIGN KEY(zip_code) REFERENCES city_zip(zip_code)
);

/*insert data in table city_zip*/
INSERT INTO city_zip(city_name, zip_code) VALUES('pratap nagar', '302033');
INSERT INTO city_zip(city_name, zip_code) VALUES('sanganer', '302022');
INSERT INTO city_zip(city_name, zip_code) VALUES('rajendra nagar', '800016');
INSERT INTO city_zip(city_name, zip_code) VALUES('danapur', '800004');
INSERT INTO city_zip(city_name, zip_code) VALUES('bahadur pur', '800012');
INSERT INTO city_zip(city_name, zip_code) VALUES('mansarovar', '302010');

SELECT * FROM city_zip;


/*insert data in table state*/
INSERT INTO state(state_name, zip_code) VALUES('Rajasthan', '302033');
INSERT INTO state(state_name, zip_code) VALUES('Rajasthan', '302022');
INSERT INTO state(state_name, zip_code) VALUES('Bihar', '800016');
INSERT INTO state(state_name, zip_code) VALUES('Bihar', '800004');
INSERT INTO state(state_name, zip_code) VALUES('Bihar', '800012');

SELECT * FROM state;

/*query that returns a Resultset containing Zip Code, City Names and States ordered by State Name and City Name.*/
SELECT state.zip_code, city_name, state_name FROM state INNER JOIN city_zip
ON state.zip_code = city_zip.zip_code ORDER BY state_name, city_name;