DROP VIEW IF EXISTS list_duty_staff;

DROP VIEW IF EXISTS list_duty_staff;
CREATE VIEW list_duty_staff AS
SELECT 
	d.duty_name,
	s.degree,
	s.first_name, 
    s.last_name
FROM 
	staff s
INNER JOIN 
	staff_has_duty shd 
	ON s.id = shd.staff_id
INNER JOIN 
	duty d 
    ON shd.duty_id = d.id
ORDER BY
	d.validity;

SELECT * FROM list_duty_staff;