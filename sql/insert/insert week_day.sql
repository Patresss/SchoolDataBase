DROP TABLE IF EXISTS week_day;

CREATE TABLE week_day (
	id INTEGER  NOT NULL,
	name VARCHAR(20) NOT NULL,
	PRIMARY KEY(id)
);

INSERT INTO week_day VALUES (1, 'Poniedziałek');
INSERT INTO week_day VALUES (2, 'Wtorek');
INSERT INTO week_day VALUES (3, 'Środa');
INSERT INTO week_day VALUES (4, 'Czwartek');
INSERT INTO week_day VALUES (5, 'Piątek');
INSERT INTO week_day VALUES (6, 'Sobota');
INSERT INTO week_day VALUES (7, 'Niedziela');