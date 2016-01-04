CREATE OR REPLACE VIEW list_duty AS 
SELECT 
	id, validity, duty_name
FROM 
	duty
ORDER BY 
	validity;
