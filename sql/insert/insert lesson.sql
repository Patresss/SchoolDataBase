DROP TABLE IF EXISTS lesson;

CREATE TABLE lesson (
	id INTEGER  NOT NULL,
	number INTEGER  NOT NULL,
	start_time TIME  NOT NULL,
	dyration TIME  NOT NULL DEFAULT '0:45',
	PRIMARY KEY(id)
);

INSERT INTO lesson (id, number, start_time) VALUES (0, 0, '7:10');
INSERT INTO lesson (id, number, start_time) VALUES (1, 1, '8:00');
INSERT INTO lesson (id, number, start_time) VALUES (2, 2, '8:50');
INSERT INTO lesson (id, number, start_time) VALUES (3, 3, '9:45');
INSERT INTO lesson (id, number, start_time) VALUES (4, 4, '10:35');
INSERT INTO lesson (id, number, start_time) VALUES (5, 5, '11:25');
INSERT INTO lesson (id, number, start_time) VALUES (6, 6, '12:30');
INSERT INTO lesson (id, number, start_time) VALUES (7, 7, '13:20');
INSERT INTO lesson (id, number, start_time) VALUES (8, 8, '14:10');
INSERT INTO lesson (id, number, start_time) VALUES (9, 9, '15:00');
INSERT INTO lesson (id, number, start_time) VALUES (10, 10, '15:50');
INSERT INTO lesson (id, number, start_time) VALUES (11, 11, '16:40');

