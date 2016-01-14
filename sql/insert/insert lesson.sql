DROP TABLE IF EXISTS lesson;

ALTER SEQUENCE seq_lesson RESTART;

CREATE TABLE lesson (
	id_lesson INT DEFAULT nextval('seq_lesson') NOT NULL,
	number INTEGER  NOT NULL,
	start_time TIME  NOT NULL,
	dyration TIME  NOT NULL DEFAULT '0:45',
	PRIMARY KEY(id_lesson)
);

INSERT INTO lesson (number, start_time) VALUES (0, '7:10');
INSERT INTO lesson (number, start_time) VALUES (1, '8:00');
INSERT INTO lesson (number, start_time) VALUES (2, '8:50');
INSERT INTO lesson (number, start_time) VALUES (3, '9:45');
INSERT INTO lesson (number, start_time) VALUES (4, '10:35');
INSERT INTO lesson (number, start_time) VALUES (5, '11:25');
INSERT INTO lesson (number, start_time) VALUES (6, '12:30');
INSERT INTO lesson (number, start_time) VALUES (7, '13:20');
INSERT INTO lesson (number, start_time) VALUES (8, '14:10');
INSERT INTO lesson (number, start_time) VALUES (9, '15:00');
INSERT INTO lesson (number, start_time) VALUES (10, '15:50');
INSERT INTO lesson (number, start_time) VALUES (11, '16:40');

