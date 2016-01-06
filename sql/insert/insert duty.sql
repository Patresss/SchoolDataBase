DROP TABLE IF EXISTS duty;

ALTER SEQUENCE seq_duty RESTART;

CREATE TABLE duty (
	id INT DEFAULT nextval('seq_duty') NOT NULL,
	validity INTEGER,
	duty_name VARCHAR(45) NOT NULL,
	PRIMARY KEY(id)
);

INSERT INTO duty (validity, duty_name) VALUES (1, 'Dyrektor');
INSERT INTO duty (validity, duty_name) VALUES (2, 'Zastępca dyrektora');
INSERT INTO duty (validity, duty_name) VALUES (3, 'Pedagog');
INSERT INTO duty (validity, duty_name) VALUES (4, 'Bibliotekarka');