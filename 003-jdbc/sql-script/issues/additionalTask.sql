CREATE TABLE company
(
  id integer NOT NULL,
  name character varying,
  CONSTRAINT company_pkey PRIMARY KEY (id)
);
insert into company (id,name) VALUES (1,'Horns and hooves');
insert into company (id, name) VALUES (2, 'Golden calf');

CREATE TABLE IF NOT EXISTS person
(
  id integer NOT NULL,
  name character varying,
  company_id integer,
  CONSTRAINT person_pkey PRIMARY KEY (id)
);
INSERT INTO person (id, name, company_id) VALUES (1, 'Bendor', 2);
INSERT INTO person (id, name, company_id) VALUES (3, 'Panikovskiy', 2);
INSERT INTO person (id, name, company_id) VALUES (2, 'Panikovskiy', 1);

-- names of all persons that are NOT in the company with id = 5
SELECT name
FROM person
WHERE company_id <> 5;

-- company name for each person
SELECT
  per.name,
  (SELECT comp.name
   FROM company AS comp
   WHERE comp.id = per.id)
FROM person AS per;

-- company name for each person Left join
SELECT per.name, comp.name
FROM person AS per
  LEFT JOIN company AS comp ON comp.id = per.id
WHERE per.id is NOT NULL ;

-- Select the name of the company with the maximum number of persons + number of persons in this company
WITH company_id_count AS (SELECT
                            company_id,
                            count(company_id) AS counts
                          FROM person
                          GROUP BY company_id)
SELECT comp.name, counts
FROM company_id_count
left join company as comp on company_id = comp.id
WHERE counts = ANY (SELECT max(counts)
                    FROM company_id_count);