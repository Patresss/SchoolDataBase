DROP TABLE IF EXISTS duty;

ALTER SEQUENCE seq_duty RESTART;

CREATE TABLE duty (
	id INT DEFAULT nextval('seq_duty') NOT NULL,
	duty_name VARCHAR(45) NOT NULL,
	importance INTEGER,
	PRIMARY KEY(id)
);

INSERT INTO duty (duty_name, importance) VALUES ('Dyrektor', 1);
INSERT INTO duty (duty_name, importance) VALUES ('Zastępca dyrektora', 2);
INSERT INTO duty (duty_name, importance) VALUES ('Pedagog', 3);
INSERT INTO duty (duty_name, importance) VALUES ('Bibliotekarka', 4);