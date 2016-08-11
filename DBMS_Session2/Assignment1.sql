USE library_management_system;

/*Q1. Write a select query to display all the columns of the members table*/
SELECT * FROM members;


/*Q2. Write a select query to display member_name, member_id and category columns of the members table*/
SELECT member_name, member_id, category FROM members;


/*Q3. Write a select query to display all the columns of the members table where category of member if Faculty("F")*/
SELECT member_name, member_id, category FROM members WHERE category = 'F';


/*Q4. Write a select query to display various types of categories*/
SELECT DISTINCT category FROM members;


/*Q5. Write a select query to display member_name and their categories in the descending order of the member_name*/
SELECT member_name, category FROM members ORDER BY MEMBER_NAME DESC;


/*Q6. Write a select query to display all the titles, their subject and publishers*/
SELECT title_name AS Title, subject_name AS subject, publisher_name AS publisher FROM titles T 
INNER JOIN subjects S ON T.subject_id = S.subject_id 
INNER JOIN publishers P ON T.publisher_id = P.publisher_id;


/*Q7. Write a select query to display number of members present in each category*/
SELECT category, COUNT(member_name) AS count FROM members GROUP BY category;


/*Q8. Write a select query to display name of those members whose belong to the category as to which member "Keshav Sharma" belongs*/
SELECT m.member_name, m.category FROM members m INNER JOIN members mem ON m.category = mem.category WHERE mem.member_name = 'Keshav Sharma';


/*Q9. Write a select query to display the information on all the books issued(issue_date, accession_no, member_id, return_date)*/
SELECT i.issue_date, i.accession_no, i.member_id, IFNULL(return_date, "Book not returned") AS return_date FROM book_issue i 
LEFT JOIN book_return r ON i.accession_no = r.accession_no AND i.member_id = r.member_id AND i.issue_date = r.issue_date;