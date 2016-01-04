DROP TABLE IF EXISTS subject_has_teacher;

create table subject_has_teacher (
	subject_id integer references subject (id),
	teacher_id integer references staff (id),
	primary key (subject_id, teacher_id)
);


INSERT INTO subject_has_teacher VALUES (20, 15);
INSERT INTO subject_has_teacher VALUES (20, 16);
INSERT INTO subject_has_teacher VALUES (20, 17);

INSERT INTO subject_has_teacher VALUES (21, 15);
INSERT INTO subject_has_teacher VALUES (21, 16);
INSERT INTO subject_has_teacher VALUES (21, 17);

INSERT INTO subject_has_teacher VALUES (22, 51);

INSERT INTO subject_has_teacher VALUES (30, 24);
INSERT INTO subject_has_teacher VALUES (30, 25);
INSERT INTO subject_has_teacher VALUES (30, 26);

INSERT INTO subject_has_teacher VALUES (31, 52);

INSERT INTO subject_has_teacher VALUES (32, 45);
INSERT INTO subject_has_teacher VALUES (32, 46);

INSERT INTO subject_has_teacher VALUES (40, 35);
INSERT INTO subject_has_teacher VALUES (40, 36);

INSERT INTO subject_has_teacher VALUES (41, 32);
INSERT INTO subject_has_teacher VALUES (41, 33);

INSERT INTO subject_has_teacher VALUES (42, 34);

INSERT INTO subject_has_teacher VALUES (43, 42);
INSERT INTO subject_has_teacher VALUES (43, 43);
INSERT INTO subject_has_teacher VALUES (43, 44);

INSERT INTO subject_has_teacher VALUES (50, 10);
INSERT INTO subject_has_teacher VALUES (50, 11);
INSERT INTO subject_has_teacher VALUES (50, 12);
INSERT INTO subject_has_teacher VALUES (50, 13);
INSERT INTO subject_has_teacher VALUES (50, 14);

INSERT INTO subject_has_teacher VALUES (51, 18);
INSERT INTO subject_has_teacher VALUES (51, 19);
INSERT INTO subject_has_teacher VALUES (51, 20);
INSERT INTO subject_has_teacher VALUES (51, 21);
INSERT INTO subject_has_teacher VALUES (51, 22);
INSERT INTO subject_has_teacher VALUES (51, 23);

INSERT INTO subject_has_teacher VALUES (52, 27);
INSERT INTO subject_has_teacher VALUES (52, 28);
INSERT INTO subject_has_teacher VALUES (52, 29);

INSERT INTO subject_has_teacher VALUES (53, 30);
INSERT INTO subject_has_teacher VALUES (53, 31);

INSERT INTO subject_has_teacher VALUES (54, 47);
INSERT INTO subject_has_teacher VALUES (54, 48);

INSERT INTO subject_has_teacher VALUES (54, 3);

INSERT INTO subject_has_teacher VALUES (62, 37);
INSERT INTO subject_has_teacher VALUES (62, 38);
INSERT INTO subject_has_teacher VALUES (62, 39);
INSERT INTO subject_has_teacher VALUES (62, 40);
INSERT INTO subject_has_teacher VALUES (62, 41);

INSERT INTO subject_has_teacher VALUES (63, 49);
INSERT INTO subject_has_teacher VALUES (63, 50);













