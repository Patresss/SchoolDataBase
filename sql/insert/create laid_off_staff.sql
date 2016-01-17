set schema 'School';

DROP TABLE IF EXISTS laid_off_staff;

ALTER SEQUENCE seq_laid_off_staff RESTART;

CREATE TABLE laid_off_staff (
	id_laid_off_staff INT DEFAULT nextval('seq_laid_off_staff') NOT NULL,
	degree VARCHAR(45),
	first_name start_upper NOT NULL,
	last_name start_upper NOT NULL,
	CONSTRAINT pk_laid_off_staff PRIMARY KEY(id_laid_off_staff)
);