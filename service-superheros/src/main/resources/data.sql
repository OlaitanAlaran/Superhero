DROP TABLE IF EXISTS tbl_superhero CASCADE;

CREATE TABLE tbl_superhero (
       id INT ,
       name VARCHAR(50),
       country VARCHAR(20),
       status VARCHAR(20),
       PRIMARY KEY (id)
);


INSERT INTO tbl_superhero (id, name, country, status)
VALUES (2,'Spiderman', 'United Stated', 'active');

INSERT INTO tbl_superhero (id, name, country, status)
VALUES (3,'Batman', 'United Stated', 'active');

INSERT INTO tbl_superhero (id, name, country, status)
VALUES (4,'Olaitan', 'Nigeria', 'active');
