DROP TABLE IF EXISTS duty;

CREATE TABLE duty (
	id INTEGER  NOT NULL,
	validity INTEGER,
	duty_name VARCHAR(45) NOT NULL,
	PRIMARY KEY(id)
);

INSERT INTO duty VALUES (1, 1, 'Dyrektor');
INSERT INTO duty VALUES (2, 2, 'Zastępca dyrektora');
INSERT INTO duty VALUES (3, 3, 'Pedagog');
INSERT INTO duty VALUES (4, 4, 'Bibliotekarka');