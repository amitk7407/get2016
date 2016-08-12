/*Q1. display subjectWise information on number of books purchased*/
select s.subject_id, s.subject_name, count(b.accession_no) AS total_books_purchased FROM subjects s LEFT JOIN titles t ON t.subject_id = s.subject_id 
LEFT JOIN books b ON b.title_id = t.title_id GROUP BY s.subject_id;


/*Q2. display those rows from book_issue table where a book can be returned after two months*/
SELECT *, (DATEDIFF(due_date, issue_date)/30) AS issue_duration FROM book_issue WHERE (DATEDIFF(due_date, issue_date)/30) > 2;


/*Q3. display the books having price greater than the minimum price of the books purchased so far*/
SELECT * FROM books WHERE price > (select MIN(price) from books);