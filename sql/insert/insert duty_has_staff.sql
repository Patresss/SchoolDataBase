DROP TABLE IF EXISTS duty_has_staff ;

create table duty_has_staff (
	duty_id integer references duty (id_duty),
	staff_id integer references staff (id_staff),
	primary key (duty_id, staff_id)
);


INSERT INTO duty_has_staff VALUES (1, 1);
INSERT INTO duty_has_staff VALUES (2, 2);
INSERT INTO duty_has_staff VALUES (3, 4);
INSERT INTO duty_has_staff VALUES (4, 3);