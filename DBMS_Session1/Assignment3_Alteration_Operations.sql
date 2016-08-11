/*Q2. update the address of the members to Jaipur for all members*/
SET SQL_SAFE_UPDATES = 0;
UPDATE members SET address_line2 = 'Jaipur';


/*Q3. update the address of the members to EPIP, Sitapura for female members*/
UPDATE members SET address_line1 = 'EPIP, Sitapura' WHERE category = 'F';
select * from members;


/*Q4. Delete all rows from Publishers table*/
SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE publishers;
SET FOREIGN_KEY_CHECKS = 1;
SELECT * FROM publishers;


/*Q5. Insert sample data back in publishers*/
SET @publisher_name = 'Pearson';
INSERT INTO publishers(publisher_name) VALUES (@publisher_name);
SET @publisher_name = 'McGraw-Hill Education';
INSERT INTO publishers(publisher_name) VALUES (@publisher_name);
SET @publisher_name = 'Harper Collins';
INSERT INTO publishers(publisher_name) VALUES (@publisher_name);
SET @publisher_name = 'Simon & Schuster';
INSERT INTO publishers(publisher_name) VALUES (@publisher_name);

SELECT * FROM publishers;


/*Q6. delete rows from titles table with publisher_id = 1*/
SET FOREIGN_KEY_CHECKS = 0;
DELETE FROM titles WHERE publisher_id = '1';
SET FOREIGN_KEY_CHECKS = 1;
SELECT * FROM titles;