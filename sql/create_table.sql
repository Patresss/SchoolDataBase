use school;

DROP TABLE IF EXISTS subject;
DROP TABLE IF EXISTS teacher;
DROP TABLE IF EXISTS week_day;
DROP TABLE IF EXISTS class_room;
DROP TABLE IF EXISTS class;
DROP TABLE IF EXISTS lesson;
DROP TABLE IF EXISTS subject_by_teacher;


CREATE TABLE subject (
	id INTEGER UNSIGNED NOT NULL,
	name VARCHAR(45) NOT NULL,
	PRIMARY KEY(id)
);

CREATE TABLE teacher (
	id INTEGER UNSIGNED  NOT NULL,
    degree VARCHAR(45),
	first_name VARCHAR(45) NOT NULL,
	last_name VARCHAR(45) NOT NULL,
	PRIMARY KEY(id)
);

CREATE TABLE week_day (
	id INTEGER UNSIGNED  NOT NULL,
	name VARCHAR(20) NOT NULL,
	PRIMARY KEY(id)
);

CREATE TABLE room (
	id INTEGER UNSIGNED  NOT NULL,
	name VARCHAR(20) NOT NULL,
	limit_people INTEGER UNSIGNED NOT NULL,
	PRIMARY KEY(id)
);

CREATE TABLE class (
	id INTEGER UNSIGNED NOT NULL,
	year INTEGER UNSIGNED NOT NULL,
    letter_class CHAR,
	children_count INTEGER UNSIGNED  NOT NULL  ,
	PRIMARY KEY(id)
);

CREATE TABLE lesson (
	id INTEGER UNSIGNED  NOT NULL,
	number INTEGER UNSIGNED  NOT NULL,
	start_time TIME  NOT NULL,
	dyration TIME  NOT NULL DEFAULT '0:45',
	PRIMARY KEY(id)
);


INSERT INTO subject VALUES (1, 'Matematyka');
INSERT INTO subject VALUES (2, 'Informatyka');
INSERT INTO subject VALUES (3, 'Religia');
INSERT INTO subject VALUES (4, 'Historia');
INSERT INTO subject VALUES (5, 'WOS');
INSERT INTO subject VALUES (6, 'Godz. Wych.');
INSERT INTO subject VALUES (7, 'Biologia');
INSERT INTO subject VALUES (8, 'Geografia');
INSERT INTO subject VALUES (9, 'Chemia');
INSERT INTO subject VALUES (10, 'Fizyka');
INSERT INTO subject VALUES (11, 'WOK');
INSERT INTO subject VALUES (12, 'J. polski');
INSERT INTO subject VALUES (13, 'J. angielski');
INSERT INTO subject VALUES (14, 'J. francuski');
INSERT INTO subject VALUES (15, 'J. hiszpański');
INSERT INTO subject VALUES (16, 'Podstawy przedsiębiorczości');
INSERT INTO subject VALUES (17, 'WDŻWR');
INSERT INTO subject VALUES (18, 'EDB');


INSERT INTO teacher VALUES (1, 'mgr', 'Witold', 'Deptuch');
INSERT INTO teacher VALUES (2, 'mgr', 'Edyta', 'Janusz');
INSERT INTO teacher VALUES (3, 'mgr', 'Bogusława', 'Stasik');
INSERT INTO teacher VALUES (4, 'mgr', 'Jadwiga', 'Urbanek');

INSERT INTO teacher VALUES (10, 'mgr', 'Anna', 'Gierlach');
INSERT INTO teacher VALUES (11, 'mgr', 'Lucyna', 'Klein');
INSERT INTO teacher VALUES (12, 'mgr', 'Renata', 'Pernal');
INSERT INTO teacher VALUES (13, 'mgr', 'Tamara', 'Grodecka-Zaremba');
INSERT INTO teacher VALUES (14, 'mgr', 'Arkadiusz', 'Prajsnar');

INSERT INTO teacher VALUES (15, 'mgr', 'Lucjan', 'Dynowski');
INSERT INTO teacher VALUES (16, 'dr', 'Elżbieta', 'Longosz');
INSERT INTO teacher VALUES (17, 'mgr', 'Elżbieta', 'Świstak');

INSERT INTO teacher VALUES (18, 'mgr', 'Elżbieta', 'Baran');
INSERT INTO teacher VALUES (19, 'mgr', 'Monika', 'Karnas');
INSERT INTO teacher VALUES (20, 'mgr', 'Tomasz', 'Kasprzyk');
INSERT INTO teacher VALUES (21, 'mgr', 'Beata', 'Kijowska');
INSERT INTO teacher VALUES (22, 'mgr',  'Irena', 'Kolanko');
INSERT INTO teacher VALUES (23, 'mgr', 'Agnieszka', 'Trybus-Gorczyca');

INSERT INTO teacher VALUES (24, 'mgr', 'Beata', 'Czuba');
INSERT INTO teacher VALUES (25, 'mgr', 'Mariola', 'Jastrzębska');
INSERT INTO teacher VALUES (26, 'mgr', 'Jolanta', 'Mięsowicz');

INSERT INTO teacher VALUES (27, 'mgr', 'Anna', 'Hadel');
INSERT INTO teacher VALUES (28, 'mgr', 'Anna', 'Przybyłowicz');
INSERT INTO teacher VALUES (29, 'mgr', 'Katarzyna', 'Przybyłowicz-Ciszewska');

INSERT INTO teacher VALUES (30, 'mgr', 'Edyta', 'Janusz ');
INSERT INTO teacher VALUES (31, 'mgr', 'Beata', 'Rachwał');

INSERT INTO teacher VALUES (32, 'dr', 'Agata', 'Chodorowicz-Bąk');
INSERT INTO teacher VALUES (33, 'mgr', 'Monika', 'Serwatka');

INSERT INTO teacher VALUES (34, 'mgr', 'Tatiana', 'Gonet');

INSERT INTO teacher VALUES (35, 'mgr', 'Maciej', 'Guzik');
INSERT INTO teacher VALUES (36, 'mgr',  'Tomasz', 'Szarłowicz');

INSERT INTO teacher VALUES (37, 'mgr', 'Jacek', 'Dawidko');
INSERT INTO teacher VALUES (38, 'mgr', 'Maria', 'Rachfał');
INSERT INTO teacher VALUES (39, 'mgr', 'Wojciech', 'Wilk');
INSERT INTO teacher VALUES (40, 'mgr', 'Tomasz', 'Zając');
INSERT INTO teacher VALUES (41, 'mgr', 'Renata', 'Dawidko');

INSERT INTO teacher VALUES (42, 'mgr inż.', 'Sławomir', 'Bloch');
INSERT INTO teacher VALUES (43, 'mgr', 'Stanisław', 'Józefczyk');
INSERT INTO teacher VALUES (44, 'mgr', 'Irma', 'Szott');

INSERT INTO teacher VALUES (45, 'mgr', 'Małgorzata', 'Dzierwa');
INSERT INTO teacher VALUES (46, 'mgr', 'Ryszard', 'Solecki');

INSERT INTO teacher VALUES (47, 'mgr', 'Jolanta', 'Żółkoś');
INSERT INTO teacher VALUES (48, 'mgr', 'Katarzyna', 'Kudroń');

INSERT INTO teacher VALUES (49, 'ks. mgr', 'Waldemar', 'Haręza');
INSERT INTO teacher VALUES (50, 'mgr', 'Wojciech', 'Matwiej');

INSERT INTO teacher VALUES (51, 'mgr', 'Małgorzata', 'Twardzik-Wilk');

INSERT INTO teacher VALUES (52, 'mgr inż.', 'Zbigniew', 'Suchodolski');


INSERT INTO week_day VALUES (1, 'Poniedziałek');
INSERT INTO week_day VALUES (2, 'Wtorek');
INSERT INTO week_day VALUES (3, 'Środa');
INSERT INTO week_day VALUES (4, 'Czwartek');
INSERT INTO week_day VALUES (5, 'Piątek');
INSERT INTO week_day VALUES (6, 'Sobota');
INSERT INTO week_day VALUES (7, 'Niedziela');

INSERT INTO room VALUES (0, '90', 34);
INSERT INTO room VALUES (1, '91', 34);

INSERT INTO room VALUES (101, '1', 34);
INSERT INTO room VALUES (102, '2', 34);
INSERT INTO room VALUES (103, '3', 34);
INSERT INTO room VALUES (104, '4', 34);
INSERT INTO room VALUES (105, '5', 34);
INSERT INTO room VALUES (106, '6', 34);
INSERT INTO room VALUES (107, '7', 34);
INSERT INTO room VALUES (108, '8', 34);
INSERT INTO room VALUES (109, '9', 34);
INSERT INTO room VALUES (110, '10', 34);
INSERT INTO room VALUES (111, '11', 34);
INSERT INTO room VALUES (112, '12', 34);
INSERT INTO room VALUES (113, '13', 34);
INSERT INTO room VALUES (114, '14', 34);
INSERT INTO room VALUES (115, '15', 34);
INSERT INTO room VALUES (116, '16', 34);
INSERT INTO room VALUES (117, '17', 34);
INSERT INTO room VALUES (118, '18', 34);
INSERT INTO room VALUES (119, '19', 34);
INSERT INTO room VALUES (120, '20', 34);
INSERT INTO room VALUES (121, '21', 34);
INSERT INTO room VALUES (122, '22', 34);
INSERT INTO room VALUES (123, '23', 34);
INSERT INTO room VALUES (124, '24', 34);
INSERT INTO room VALUES (125, '25', 34);
INSERT INTO room VALUES (126, '26', 34);
INSERT INTO room VALUES (127, '27', 34);
INSERT INTO room VALUES (128, '28', 34);
INSERT INTO room VALUES (129, '29', 34);
INSERT INTO room VALUES (130, '30', 34);
INSERT INTO room VALUES (131, '31', 34);
INSERT INTO room VALUES (132, '32', 34);
INSERT INTO room VALUES (133, '33', 34);
INSERT INTO room VALUES (134, '34', 34);
INSERT INTO room VALUES (135, '35', 34);
INSERT INTO room VALUES (136, '36', 34);
INSERT INTO room VALUES (137, '37', 34);
INSERT INTO room VALUES (138, '38', 34);
INSERT INTO room VALUES (139, '39', 34);


INSERT INTO class VALUES (11, 1, 'A', 30);
INSERT INTO class VALUES (12, 1, 'B', 30);
INSERT INTO class VALUES (13, 1, 'C', 30);
INSERT INTO class VALUES (14, 1, 'D', 30);
INSERT INTO class VALUES (15, 1, 'E', 30);
INSERT INTO class VALUES (16, 1, 'F', 30);

INSERT INTO class VALUES (21, 2, 'A', 30);
INSERT INTO class VALUES (22, 2, 'B', 30);
INSERT INTO class VALUES (23, 2, 'C', 30);
INSERT INTO class VALUES (24, 2, 'D', 30);
INSERT INTO class VALUES (25, 2, 'E', 30);
INSERT INTO class VALUES (26, 2, 'F', 30);

INSERT INTO class VALUES (31, 2, 'A', 30);
INSERT INTO class VALUES (32, 2, 'B', 30);
INSERT INTO class VALUES (33, 2, 'C', 30);
INSERT INTO class VALUES (34, 2, 'D', 30);
INSERT INTO class VALUES (35, 2, 'E', 30);
INSERT INTO class VALUES (36, 2, 'F', 30);


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




