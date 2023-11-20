CREATE TABLE IF NOT EXISTS continent
(
    id SERIAL PRIMARY KEY,
    code VARCHAR(2) NOT NULL UNIQUE,
    name VARCHAR(100) NOT NULL
);


CREATE TABLE IF NOT EXISTS country
(
    id SERIAL PRIMARY KEY,
	continent_id INT,
    code VARCHAR(2) NOT NULL UNIQUE,
    name VARCHAR(100) NOT NULL,
	FOREIGN KEY (continent_id) REFERENCES continent(id)
);

--
-- create city
--

CREATE TABLE IF NOT EXISTS city
(
    id SERIAL PRIMARY KEY,
	country_id INT,
    code VARCHAR(5),
    name VARCHAR(100) NOT NULL,
	FOREIGN KEY (country_id) REFERENCES country(id)
);

