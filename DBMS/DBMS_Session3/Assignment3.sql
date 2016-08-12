/*Q1. display total number of students, total number of faculties and total number of others in a single row*/
SELECT  MAX(CASE WHEN category = 'S' THEN count ELSE 0 END) AS students,
        MAX(CASE WHEN category = 'F' THEN count ELSE 0 END) AS faculties,
        MAX(CASE WHEN category = 'O' THEN count ELSE 0 END) AS others
FROM (SELECT category, COUNT(category) AS count FROM members GROUP BY category) a;


/*Q2. display titles issued more than two times*/
SELECT t.title_id, t.title_name, count(bi.accession_no) AS total_issues FROM titles t
LEFT JOIN books b ON b.title_id = t.title_id
LEFT JOIN book_issue bi ON b.accession_no = bi.accession_no
GROUP BY t.title_id HAVING total_issues > 2;


/*Q3. display information on books isssued to members of category other than "F"*/
SELECT m.member_id, m.member_name, m.category, b.title_id, b.purchase_date, b.price, b.status FROM books b INNER JOIN book_issue bi ON b.accession_no = bi.accession_no
INNER JOIN members m ON m.member_id = bi.member_id WHERE m.category <> 'F';


/*Q4. display information on those authors for which atleast one book has been purchased*/
SELECT a.author_id, a.author_name, t.title_id, t.title_name, s.subject_id, s.subject_name, p.publisher_id, p.publisher_name, b.price FROM books b
INNER JOIN title_author ta ON ta.title_id = b.title_id
INNER JOIN authors a ON a.author_id = ta.author_id
INNER JOIN titles t ON b.title_id = t.title_id
INNER JOIN subjects s ON t.subject_id = s.subject_id
INNER JOIN publishers p ON t.publisher_id = p.publisher_id
ORDER BY a.author_id;