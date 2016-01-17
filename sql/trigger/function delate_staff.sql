set schema 'School';
CREATE OR REPLACE FUNCTION delate_staff() 
RETURNS TRIGGER AS
$func$
BEGIN
INSERT INTO laid_off_staff (degree, first_name, last_name) VALUES (OLD.degree, OLD.first_name, OLD.last_name);
RETURN NEW;
END
$func$ LANGUAGE plpgsql;