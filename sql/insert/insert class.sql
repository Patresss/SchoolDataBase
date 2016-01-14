DROP TABLE IF EXISTS class;

ALTER SEQUENCE seq_class RESTART;

CREATE TABLE class (
	id_class INT DEFAULT nextval('seq_class') NOT NULL,
	year INTEGER NOT NULL,
	letter_class CHAR,
	people_count INTEGER  NOT NULL  ,
	PRIMARY KEY(id_class)
);

INSERT INTO class (year, letter_class, people_count) VALUES (1, 'A', 30);
INSERT INTO class (year, letter_class, people_count) VALUES (1, 'B', 30);
INSERT INTO class (year, letter_class, people_count) VALUES (1, 'C', 30);
INSERT INTO class (year, letter_class, people_count) VALUES (1, 'D', 30);
INSERT INTO class (year, letter_class, people_count) VALUES (1, 'E', 30);
INSERT INTO class (year, letter_class, people_count) VALUES (1, 'F', 30);

INSERT INTO class (year, letter_class, people_count) VALUES (2, 'A', 30);
INSERT INTO class (year, letter_class, people_count) VALUES (2, 'B', 30);
INSERT INTO class (year, letter_class, people_count) VALUES (2, 'C', 30);
INSERT INTO class (year, letter_class, people_count) VALUES (2, 'D', 30);
INSERT INTO class (year, letter_class, people_count) VALUES (2, 'E', 30);
INSERT INTO class (year, letter_class, people_count) VALUES (2, 'F', 30);

INSERT INTO class (year, letter_class, people_count) VALUES (3, 'A', 30);
INSERT INTO class (year, letter_class, people_count) VALUES (3, 'B', 30);
INSERT INTO class (year, letter_class, people_count) VALUES (3, 'C', 30);
INSERT INTO class (year, letter_class, people_count) VALUES (3, 'D', 30);
INSERT INTO class (year, letter_class, people_count) VALUES (3, 'E', 30);
INSERT INTO class (year, letter_class, people_count) VALUES (3, 'F', 30);

