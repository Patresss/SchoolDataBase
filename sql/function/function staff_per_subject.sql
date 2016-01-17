CREATE OR REPLACE FUNCTION staff_per_subject()
RETURNS float AS $total$
declare
	count_staff FLOAT;
	count_subject FLOAT;
BEGIN
   SELECT count(*) into count_staff FROM staff;
   SELECT count(*) into count_subject FROM subject;
   
   RETURN count_staff/count_subject;
END;
$total$ LANGUAGE plpgsql;
