DROP TABLE IF EXISTS staff_has_subject;

create table staff_has_subject (
	staff_id INTEGER NOT NULL,
	subject_id INTEGER NOT NULL,
	primary key (staff_id, subject_id),
	CONSTRAINT staff_has_subject_staff_id_fk
		FOREIGN KEY(staff_id)
		REFERENCES staff(id_staff)
		ON DELETE CASCADE,
	CONSTRAINT staff_has_subject_subject_id_fk
		FOREIGN KEY(subject_id)
		REFERENCES subject(id_subject)
		ON DELETE CASCADE
);


INSERT INTO staff_has_subject VALUES (10, 1);
INSERT INTO staff_has_subject VALUES (11, 1);
INSERT INTO staff_has_subject VALUES (12, 1);

INSERT INTO staff_has_subject VALUES (10, 2);
INSERT INTO staff_has_subject VALUES (11, 2);
INSERT INTO staff_has_subject VALUES (12, 2);

INSERT INTO staff_has_subject VALUES (46, 3);

INSERT INTO staff_has_subject VALUES (19, 4);
INSERT INTO staff_has_subject VALUES (20, 4);
INSERT INTO staff_has_subject VALUES (21, 4);

INSERT INTO staff_has_subject VALUES (47, 5);

INSERT INTO staff_has_subject VALUES (40, 6);
INSERT INTO staff_has_subject VALUES (41, 6);

INSERT INTO staff_has_subject VALUES (30, 7);
INSERT INTO staff_has_subject VALUES (31, 7);

INSERT INTO staff_has_subject VALUES (27, 8);
INSERT INTO staff_has_subject VALUES (28, 8);

INSERT INTO staff_has_subject VALUES (29, 9);

INSERT INTO staff_has_subject VALUES (37, 10);
INSERT INTO staff_has_subject VALUES (38, 10);
INSERT INTO staff_has_subject VALUES (39, 10);

INSERT INTO staff_has_subject VALUES (5, 11);
INSERT INTO staff_has_subject VALUES (6, 11);
INSERT INTO staff_has_subject VALUES (7, 11);
INSERT INTO staff_has_subject VALUES (8, 11);
INSERT INTO staff_has_subject VALUES (9, 11);

INSERT INTO staff_has_subject VALUES (13, 12);
INSERT INTO staff_has_subject VALUES (14, 12);
INSERT INTO staff_has_subject VALUES (15, 12);
INSERT INTO staff_has_subject VALUES (16, 12);
INSERT INTO staff_has_subject VALUES (17, 12);
INSERT INTO staff_has_subject VALUES (18, 12);

INSERT INTO staff_has_subject VALUES (22, 13);
INSERT INTO staff_has_subject VALUES (23, 13);
INSERT INTO staff_has_subject VALUES (24, 13);

INSERT INTO staff_has_subject VALUES (25, 14);
INSERT INTO staff_has_subject VALUES (26, 14);

INSERT INTO staff_has_subject VALUES (42, 15);
INSERT INTO staff_has_subject VALUES (43, 15);

INSERT INTO staff_has_subject VALUES (3, 16);

INSERT INTO staff_has_subject VALUES (32, 19);
INSERT INTO staff_has_subject VALUES (33, 19);
INSERT INTO staff_has_subject VALUES (34, 19);
INSERT INTO staff_has_subject VALUES (35, 19);
INSERT INTO staff_has_subject VALUES (36, 19);

INSERT INTO staff_has_subject VALUES (44, 20);
INSERT INTO staff_has_subject VALUES (45, 20);













