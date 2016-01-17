set schema 'School';
DROP VIEW IF EXISTS view_duty_has_staff;

CREATE VIEW view_duty_has_staff AS
SELECT 
	d.id_duty,
	d.duty_name,
	d.importance,
	s.id_staff,
	s.degree,
	s.first_name, 
	s.last_name
FROM 
	staff s
INNER JOIN 
	duty_has_staff dhs
	ON s.id_staff = dhs.staff_id
INNER JOIN 
	duty d 
    ON dhs.duty_id = d.id_duty
ORDER BY
	d.importance;
