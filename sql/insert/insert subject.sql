DROP TABLE IF EXISTS subject;

CREATE TABLE subject (
	id INTEGER NOT NULL,
	subject_name VARCHAR(45) NOT NULL,
	PRIMARY KEY(id)
);
  
INSERT INTO subject VALUES (20, 'Historia');
INSERT INTO subject VALUES (21, 'Wiedza o Społeczeństwie');
INSERT INTO subject VALUES (22, 'Wiedza o kulturze');

INSERT INTO subject VALUES (30, 'Matematyka');
INSERT INTO subject VALUES (31, 'Podstawy przedsiębiorczości');
INSERT INTO subject VALUES (32, 'Informatyka');

INSERT INTO subject VALUES (40, 'Biologia');
INSERT INTO subject VALUES (41, 'Chemia');
INSERT INTO subject VALUES (42, 'Geografia');
INSERT INTO subject VALUES (43, 'Fizyka');

INSERT INTO subject VALUES (50, 'J. polski');
INSERT INTO subject VALUES (51, 'J. angielski');
INSERT INTO subject VALUES (52, 'J. niemiecki');
INSERT INTO subject VALUES (53, 'J. francuski');
INSERT INTO subject VALUES (54, 'J. łaciński');
INSERT INTO subject VALUES (55, 'J. rosyjski');



INSERT INTO subject VALUES (60, 'Godz. Wych.');
INSERT INTO subject VALUES (61, 'Edukacja do bezpieczeństwa');
INSERT INTO subject VALUES (62, 'Wychowanie Fizyczne');
INSERT INTO subject VALUES (63, 'Religia');
INSERT INTO subject VALUES (64, 'Wychowanie do życia w rodzinie');



