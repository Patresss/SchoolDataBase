CREATE OR REPLACE VIEW list_duty AS 
SELECT 
	duty_name
FROM 
	duty
ORDER BY 
	validity;
