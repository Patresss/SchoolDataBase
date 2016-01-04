DROP TABLE IF EXISTS staff_has_duty;

create table staff_has_duty (
	staff_id integer references staff (id),
	duty_id integer references duty (id),
	primary key (staff_id, duty_id)
);


INSERT INTO staff_has_duty VALUES (1, 1);
INSERT INTO staff_has_duty VALUES (2, 2);
INSERT INTO staff_has_duty VALUES (4, 3);
INSERT INTO staff_has_duty VALUES (3, 4);