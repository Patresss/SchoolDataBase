DROP TABLE IF EXISTS staff;

ALTER SEQUENCE seq_staff RESTART;

CREATE TABLE staff (
	id_staff INT DEFAULT nextval('seq_staff') NOT NULL,
	degree VARCHAR(45),
	first_name VARCHAR(45) NOT NULL,
	last_name VARCHAR(45) NOT NULL,
	PRIMARY KEY(id_staff)
);

INSERT INTO staff (degree, first_name, last_name) VALUES ('mgr', 'Witold', 'Deptuch');
INSERT INTO staff (degree, first_name, last_name) VALUES ('mgr', 'Edyta', 'Janusz');
INSERT INTO staff (degree, first_name, last_name) VALUES ('mgr', 'Bogusława', 'Stasik');
INSERT INTO staff (degree, first_name, last_name) VALUES ('mgr', 'Jadwiga', 'Urbanek');

INSERT INTO staff (degree, first_name, last_name) VALUES ('mgr', 'Anna', 'Gierlach');
INSERT INTO staff (degree, first_name, last_name) VALUES ('mgr', 'Lucyna', 'Klein');
INSERT INTO staff (degree, first_name, last_name) VALUES ('mgr', 'Renata', 'Pernal');
INSERT INTO staff (degree, first_name, last_name) VALUES ('mgr', 'Tamara', 'Grodecka-Zaremba');
INSERT INTO staff (degree, first_name, last_name) VALUES ('mgr', 'Arkadiusz', 'Prajsnar');

INSERT INTO staff (degree, first_name, last_name) VALUES ('mgr', 'Lucjan', 'Dynowski');
INSERT INTO staff (degree, first_name, last_name) VALUES ('dr', 'Elżbieta', 'Longosz');
INSERT INTO staff (degree, first_name, last_name) VALUES ('mgr', 'Elżbieta', 'Świstak');

INSERT INTO staff (degree, first_name, last_name) VALUES ('mgr', 'Elżbieta', 'Baran');
INSERT INTO staff (degree, first_name, last_name) VALUES ('mgr', 'Monika', 'Karnas');
INSERT INTO staff (degree, first_name, last_name) VALUES ('mgr', 'Tomasz', 'Kasprzyk');
INSERT INTO staff (degree, first_name, last_name) VALUES ('mgr', 'Beata', 'Kijowska');
INSERT INTO staff (degree, first_name, last_name) VALUES ('mgr', 'Irena', 'Kolanko');
INSERT INTO staff (degree, first_name, last_name) VALUES ('mgr', 'Agnieszka', 'Trybus-Gorczyca');

INSERT INTO staff (degree, first_name, last_name) VALUES ('mgr', 'Beata', 'Czuba');
INSERT INTO staff (degree, first_name, last_name) VALUES ('mgr', 'Mariola', 'Jastrzębska');
INSERT INTO staff (degree, first_name, last_name) VALUES ('mgr', 'Jolanta', 'Mięsowicz');

INSERT INTO staff (degree, first_name, last_name) VALUES ('mgr', 'Anna', 'Hadel');
INSERT INTO staff (degree, first_name, last_name) VALUES ('mgr', 'Anna', 'Przybyłowicz');
INSERT INTO staff (degree, first_name, last_name) VALUES ('mgr', 'Katarzyna', 'Przybyłowicz-Ciszewska');

INSERT INTO staff (degree, first_name, last_name) VALUES ('mgr', 'Edyta', 'Janusz ');
INSERT INTO staff (degree, first_name, last_name) VALUES ('mgr', 'Beata', 'Rachwał');

INSERT INTO staff (degree, first_name, last_name) VALUES ('dr', 'Agata', 'Chodorowicz-Bąk');
INSERT INTO staff (degree, first_name, last_name) VALUES ('mgr', 'Monika', 'Serwatka');

INSERT INTO staff (degree, first_name, last_name) VALUES ('mgr', 'Tatiana', 'Gonet');

INSERT INTO staff (degree, first_name, last_name) VALUES ('mgr', 'Maciej', 'Guzik');
INSERT INTO staff (degree, first_name, last_name) VALUES ('mgr',  'Tomasz', 'Szarłowicz');

INSERT INTO staff (degree, first_name, last_name) VALUES ('mgr', 'Jacek', 'Dawidko');
INSERT INTO staff (degree, first_name, last_name) VALUES ('mgr', 'Maria', 'Rachfał');
INSERT INTO staff (degree, first_name, last_name) VALUES ('mgr', 'Wojciech', 'Wilk');
INSERT INTO staff (degree, first_name, last_name) VALUES ('mgr', 'Tomasz', 'Zając');
INSERT INTO staff (degree, first_name, last_name) VALUES ('mgr', 'Renata', 'Dawidko');

INSERT INTO staff (degree, first_name, last_name) VALUES ('mgr inż.', 'Sławomir', 'Bloch');
INSERT INTO staff (degree, first_name, last_name) VALUES ('mgr', 'Stanisław', 'Józefczyk');
INSERT INTO staff (degree, first_name, last_name) VALUES ('mgr', 'Irma', 'Szott');

INSERT INTO staff (degree, first_name, last_name) VALUES ('mgr', 'Małgorzata', 'Dzierwa');
INSERT INTO staff (degree, first_name, last_name) VALUES ('mgr', 'Ryszard', 'Solecki');

INSERT INTO staff (degree, first_name, last_name) VALUES ('mgr', 'Jolanta', 'Żółkoś');
INSERT INTO staff (degree, first_name, last_name) VALUES ('mgr', 'Katarzyna', 'Kudroń');

INSERT INTO staff (degree, first_name, last_name) VALUES ('ks. mgr', 'Waldemar', 'Haręza');
INSERT INTO staff (degree, first_name, last_name) VALUES ('mgr', 'Wojciech', 'Matwiej');

INSERT INTO staff (degree, first_name, last_name) VALUES ('mgr', 'Małgorzata', 'Twardzik-Wilk');

INSERT INTO staff (degree, first_name, last_name) VALUES ('mgr inż.', 'Zbigniew', 'Suchodolski');
