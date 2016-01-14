DROP TABLE IF EXISTS room;

ALTER SEQUENCE seq_room RESTART;

CREATE TABLE room (
	id_room INT DEFAULT nextval('seq_room') NOT NULL,
	room_name VARCHAR(126) NOT NULL,
	limit_people INTEGER NOT NULL,
	PRIMARY KEY(id_room)
);


INSERT INTO room (room_name, limit_people) VALUES ('1', 34);
INSERT INTO room (room_name, limit_people) VALUES ('2', 34);
INSERT INTO room (room_name, limit_people) VALUES ('3', 34);
INSERT INTO room (room_name, limit_people) VALUES ('4', 34);
INSERT INTO room (room_name, limit_people) VALUES ('5', 34);
INSERT INTO room (room_name, limit_people) VALUES ('6', 34);
INSERT INTO room (room_name, limit_people) VALUES ('7', 34);
INSERT INTO room (room_name, limit_people) VALUES ('8', 34);
INSERT INTO room (room_name, limit_people) VALUES ('9', 34);
INSERT INTO room (room_name, limit_people) VALUES ('10', 34);
INSERT INTO room (room_name, limit_people) VALUES ('11', 34);
INSERT INTO room (room_name, limit_people) VALUES ('12', 34);
INSERT INTO room (room_name, limit_people) VALUES ('13', 34);
INSERT INTO room (room_name, limit_people) VALUES ('14', 34);
INSERT INTO room (room_name, limit_people) VALUES ('15', 34);
INSERT INTO room (room_name, limit_people) VALUES ('16', 34);
INSERT INTO room (room_name, limit_people) VALUES ('17', 34);
INSERT INTO room (room_name, limit_people) VALUES ('18', 34);
INSERT INTO room (room_name, limit_people) VALUES ('19', 34);
INSERT INTO room (room_name, limit_people) VALUES ('20', 34);
INSERT INTO room (room_name, limit_people) VALUES ('21', 34);
INSERT INTO room (room_name, limit_people) VALUES ('22', 34);
INSERT INTO room (room_name, limit_people) VALUES ('23', 34);
INSERT INTO room (room_name, limit_people) VALUES ('24', 34);
INSERT INTO room (room_name, limit_people) VALUES ('25', 34);
INSERT INTO room (room_name, limit_people) VALUES ('26', 34);
INSERT INTO room (room_name, limit_people) VALUES ('27', 34);
INSERT INTO room (room_name, limit_people) VALUES ('28', 34);
INSERT INTO room (room_name, limit_people) VALUES ('29', 34);
INSERT INTO room (room_name, limit_people) VALUES ('30', 34);
INSERT INTO room (room_name, limit_people) VALUES ('31', 34);
INSERT INTO room (room_name, limit_people) VALUES ('32', 34);
INSERT INTO room (room_name, limit_people) VALUES ('33', 34);
INSERT INTO room (room_name, limit_people) VALUES ('34', 34);
INSERT INTO room (room_name, limit_people) VALUES ('35', 34);
INSERT INTO room (room_name, limit_people) VALUES ('36', 34);
INSERT INTO room (room_name, limit_people) VALUES ('37', 34);
INSERT INTO room (room_name, limit_people) VALUES ('38', 34);
INSERT INTO room (room_name, limit_people) VALUES ('39', 34);
