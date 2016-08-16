USE library_management_system;


/*Q1. displayinformation on books issued for more than two months*/
SELECT m.member_id, m.member_name, bi.accession_no, t.title_name, bi.issue_date, bi.due_date,
(DATEDIFF(br.return_date, bi.issue_date)/30) AS issue_duration FROM members m 
INNER JOIN book_issue bi ON bi.member_id = m.member_id
INNER JOIN books b ON b.accession_no = bi.accession_no
INNER JOIN titles t ON t. title_id = b.title_id 
INNER JOIN book_return br ON br.issue_date = bi.issue_date AND br.accession_no = bi.accession_no AND br.member_id = bi.member_id
WHERE (DATEDIFF(br.return_date, bi.issue_date)/30) > 2
ORDER BY m.member_name, t.title_name;


/*Q2. display member_name with maximum length*/
SELECT member_name, LENGTH(member_name) AS maxLength FROM members HAVING LENGTH(member_name) = (SELECT MAX(LENGTH(member_name)) FROM members);


/*Q3. display count of number of books issued so far*/
SELECT COUNT(DISTINCT accession_no) AS Total_Books_Issued FROM book_issue;