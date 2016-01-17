set schema 'School';
CREATE TRIGGER trigger_fire
AFTER DELETE ON staff
FOR EACH ROW
EXECUTE PROCEDURE delate_staff() ;