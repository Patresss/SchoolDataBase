DROP VIEW IF EXISTS teacher_list;
CREATE VIEW teacher_list AS
SELECT 
	t.degree,
	t.first_name,
	t.last_name,
	s.subject_name
FROM 
	staff t
INNER JOIN 
	subject_has_teacher sh 
    ON t.id = sh.teacher_id
INNER JOIN 
	subject s 
    ON sh.subject_id = s.id;

SELECT * FROM teacher_list;