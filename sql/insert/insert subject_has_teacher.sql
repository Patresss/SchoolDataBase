DROP TABLE IF EXISTS subject_has_teacher CASCADE;

create table subject_has_teacher (
	subject_id integer references subject (id),
	teacher_id integer references staff (id),
	primary key (subject_id, teacher_id)
);


INSERT INTO subject_has_teacher VALUES (1, 10);
INSERT INTO subject_has_teacher VALUES (1, 11);
INSERT INTO subject_has_teacher VALUES (1, 12);

INSERT INTO subject_has_teacher VALUES (2, 10);
INSERT INTO subject_has_teacher VALUES (2, 11);
INSERT INTO subject_has_teacher VALUES (2, 12);

INSERT INTO subject_has_teacher VALUES (3, 46);

INSERT INTO subject_has_teacher VALUES (4, 19);
INSERT INTO subject_has_teacher VALUES (4, 20);
INSERT INTO subject_has_teacher VALUES (4, 21);

INSERT INTO subject_has_teacher VALUES (5, 47);

INSERT INTO subject_has_teacher VALUES (6, 40);
INSERT INTO subject_has_teacher VALUES (6, 41);

INSERT INTO subject_has_teacher VALUES (7, 30);
INSERT INTO subject_has_teacher VALUES (7, 31);

INSERT INTO subject_has_teacher VALUES (8, 27);
INSERT INTO subject_has_teacher VALUES (8, 28);

INSERT INTO subject_has_teacher VALUES (9, 29);

INSERT INTO subject_has_teacher VALUES (10, 37);
INSERT INTO subject_has_teacher VALUES (10, 38);
INSERT INTO subject_has_teacher VALUES (10, 39);

INSERT INTO subject_has_teacher VALUES (11, 5);
INSERT INTO subject_has_teacher VALUES (11, 6);
INSERT INTO subject_has_teacher VALUES (11, 7);
INSERT INTO subject_has_teacher VALUES (11, 8);
INSERT INTO subject_has_teacher VALUES (11, 9);

INSERT INTO subject_has_teacher VALUES (12, 13);
INSERT INTO subject_has_teacher VALUES (12, 14);
INSERT INTO subject_has_teacher VALUES (12, 15);
INSERT INTO subject_has_teacher VALUES (12, 16);
INSERT INTO subject_has_teacher VALUES (12, 17);
INSERT INTO subject_has_teacher VALUES (12, 18);

INSERT INTO subject_has_teacher VALUES (13, 22);
INSERT INTO subject_has_teacher VALUES (13, 23);
INSERT INTO subject_has_teacher VALUES (13, 24);

INSERT INTO subject_has_teacher VALUES (14, 25);
INSERT INTO subject_has_teacher VALUES (14, 26);

INSERT INTO subject_has_teacher VALUES (15, 42);
INSERT INTO subject_has_teacher VALUES (15, 43);

INSERT INTO subject_has_teacher VALUES (16, 3);

INSERT INTO subject_has_teacher VALUES (19, 32);
INSERT INTO subject_has_teacher VALUES (19, 33);
INSERT INTO subject_has_teacher VALUES (19, 34);
INSERT INTO subject_has_teacher VALUES (19, 35);
INSERT INTO subject_has_teacher VALUES (19, 36);

INSERT INTO subject_has_teacher VALUES (20, 44);
INSERT INTO subject_has_teacher VALUES (20, 45);













