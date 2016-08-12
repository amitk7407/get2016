/*Modify the SELECT command written for Question 9 to display results in ascending order of issue date
and within issue date in ascending order of member's name.*/

SELECT i.issue_date, m.member_name, i.accession_no, i.member_id, IFNULL(return_date, "Book not returned") AS return_date 
FROM book_issue i LEFT JOIN book_return r ON i.accession_no = r.accession_no AND i.member_id = r.member_id AND i.issue_date = r.issue_date 
INNER JOIN members m ON m.member_id = i.member_id ORDER BY issue_date, member_name DESC;
