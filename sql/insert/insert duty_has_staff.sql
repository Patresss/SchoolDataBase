DROP TABLE IF EXISTS duty_has_staff;

create table duty_has_staff (
	duty_id INTEGER NOT NULL,
	staff_id INTEGER NOT NULL,
	PRIMARY KEY (duty_id, staff_id),
	CONSTRAINT duty_has_staff_customer_duty_id_fk
		FOREIGN KEY(duty_id)
		REFERENCES duty(id_duty)
		ON DELETE CASCADE,
	CONSTRAINT duty_has_staff_customer_staff_id_fk
		FOREIGN KEY(staff_id)
		REFERENCES staff(id_staff)
		ON DELETE CASCADE
);


INSERT INTO duty_has_staff VALUES (1, 1);
INSERT INTO duty_has_staff VALUES (2, 2);
INSERT INTO duty_has_staff VALUES (3, 4);
INSERT INTO duty_has_staff VALUES (4, 3);