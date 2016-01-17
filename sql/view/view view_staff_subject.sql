DROP VIEW IF EXISTS view_staff_has_subject;

CREATE VIEW view_staff_has_subject AS
SELECT 
	st.id_staff,
	st.degree,
	st.first_name, 
	st.last_name,
	su.id_subject,
	su.subject_name
FROM 
	staff st
INNER JOIN 
	staff_has_subject shs
	ON st.id_staff = shs.staff_id
INNER JOIN 
	subject su
    ON shs.subject_id = su.id_subject;

