CREATE OR REPLACE FUNCTION staff_per_duty()
RETURNS float AS $total$
declare
	count_staff float;
	count_duty float;
BEGIN
   SELECT count(*) into count_staff FROM staff;
   SELECT count(*) into count_duty FROM duty;
   
   RETURN count_staff/count_duty;
END;
$total$ LANGUAGE plpgsql;
