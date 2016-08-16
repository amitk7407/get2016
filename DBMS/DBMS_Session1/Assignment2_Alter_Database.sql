/*Q3. altering the table book_issue and set issue_date to current date and due_date to current date + 15 days*/
/*select CURRENT_TIMESTAMP+INTERVAL 15 DAY;
SELECT CURDATE();

ALTER TABLE book_issue
MODIFY COLUMN issue_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP;

ALTER TABLE book_issue
MODIFY COLUMN due_date TIMESTAMP NOT NULL DEFAULT DATE_ADD(CURRENT_TIMESTAMP, INTERVAL 15 DAY);
DESCRIBE book_issue;
*/

/*Q4. Delete table members*/
use library_management_system;
SET FOREIGN_KEY_CHECKS = 0;
drop table members;
SET FOREIGN_KEY_CHECKS = 1;


/*Q5. Create table members again*/
CREATE TABLE members(
	member_id INT AUTO_INCREMENT,
	member_name VARCHAR(100),
	address_line1 VARCHAR(150),
	address_line2 VARCHAR(150),
	category VARCHAR(10),
  PRIMARY KEY(member_id)
);

/*Adding the foreign key constraint to desired tables*/
ALTER TABLE book_issue ADD CONSTRAINT FOREIGN KEY(member_id) REFERENCES members(member_id);
ALTER TABLE book_return ADD CONSTRAINT FOREIGN KEY(member_id) REFERENCES members(member_id);

SHOW TABLES;