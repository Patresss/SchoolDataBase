DROP TABLE IF EXISTS subject;

ALTER SEQUENCE seq_subject RESTART;

CREATE TABLE subject (
	id INT DEFAULT nextval('seq_subject') NOT NULL,
	subject_name VARCHAR(45) NOT NULL,
	PRIMARY KEY(id)
);
  
INSERT INTO subject (subject_name) VALUES ('Historia');
INSERT INTO subject (subject_name) VALUES ('Wiedza o Społeczeństwie');
INSERT INTO subject (subject_name) VALUES ('Wiedza o kulturze');

INSERT INTO subject (subject_name) VALUES ('Matematyka');
INSERT INTO subject (subject_name) VALUES ('Podstawy przedsiębiorczości');
INSERT INTO subject (subject_name) VALUES ('Informatyka');

INSERT INTO subject (subject_name) VALUES ('Biologia');
INSERT INTO subject (subject_name) VALUES ('Chemia');
INSERT INTO subject (subject_name) VALUES ('Geografia');
INSERT INTO subject (subject_name) VALUES ('Fizyka');

INSERT INTO subject (subject_name) VALUES ('J. polski');
INSERT INTO subject (subject_name) VALUES ('J. angielski');
INSERT INTO subject (subject_name) VALUES ('J. niemiecki');
INSERT INTO subject (subject_name) VALUES ('J. francuski');
INSERT INTO subject (subject_name) VALUES ('J. łaciński');
INSERT INTO subject (subject_name) VALUES ('J. rosyjski');

INSERT INTO subject (subject_name) VALUES ('Godz. Wych.');
INSERT INTO subject (subject_name) VALUES ('Edukacja do bezpieczeństwa');
INSERT INTO subject (subject_name) VALUES ('Wychowanie Fizyczne');
INSERT INTO subject (subject_name) VALUES ('Religia');
INSERT INTO subject (subject_name) VALUES ('Wychowanie do życia w rodzinie');



