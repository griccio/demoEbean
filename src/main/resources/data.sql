
INSERT INTO continent (id,code,name) VALUES
 (1,'AF','AFRICA'),
 (2,'AS','ASIA'),
 (3,'EU','EUROPE'),
 (4,'NA','NORTH AMERICA'),
 (5,'SA','SOUTH AMERICA'),
 (6,'OC','OCEANIA'),
 (7,'AN','ANTARCTIC');

-- update the sequence
-- otherwise it should start from 1 generating a contraint error
SELECT setval('continent_id_seq', (SELECT MAX(id) FROM continent));



INSERT INTO country (id, continent_id, code, name) VALUES (1, 3, 'CH',  'SWITZERLAND');
INSERT INTO country (id, continent_id, code, name) VALUES (2, 3, 'DE',  'GERMANY');
INSERT INTO country (id, continent_id, code, name) VALUES (3, 3, 'DK',  'DENMARK');
INSERT INTO country (id, continent_id, code, name) VALUES (4, 3, 'ES', 'SPAIN');
INSERT INTO country (id, continent_id, code, name) VALUES (5, 3, 'FI', 'FINLAND');
INSERT INTO country (id, continent_id, code, name) VALUES (6, 3, 'FR',  'FRANCE');
INSERT INTO country (id, continent_id, code, name) VALUES (7, 3, 'GB', 'UNITED KINGDOM');
INSERT INTO country (id, continent_id, code, name) VALUES (8, 4, 'CA',  'CANADA');
INSERT INTO country (id, continent_id, code, name) VALUES (9, 4, 'MX', 'MEXICO');
INSERT INTO country (id, continent_id, code, name) VALUES (10, 5, 'BR','BRAZIL');
INSERT INTO country (id, continent_id, code, name) VALUES (11, 1, 'CG', 'CONGO');
INSERT INTO country (id, continent_id, code, name) VALUES (12, 2, 'CN', 'CHINA');
INSERT INTO country (id, continent_id, code, name) VALUES (13, 3, 'IT', 'ITALY');

-- update the sequence
-- otherwise it should start from 1 generating a contraint error
SELECT setval('country_id_seq', (SELECT MAX(id) FROM country));


insert into city (name,country_id) values
('Genoa',13),
('Paris',6),
('London',7),
('Toronto',8),
('Madrid',4),
('Rio De Janeiro',10),
('Beijing', 12),
('Kinshasa',11);

SELECT setval('city_id_seq', (SELECT MAX(id) FROM city));