CREATE SCHEMA `homework` ;
USE homework;

CREATE TABLE `homework`.`developers` (`id` INT NOT NULL AUTO_INCREMENT,

`name` VARCHAR(255) NOT NULL,
 
`age` INT NOT NULL,

`sex` VARCHAR(45) NOT NULL,

PRIMARY KEY (`id`));

INSERT INTO developers(name, age, sex) VALUES 
('Franklin Cooke', 23, 'male'),

('Anabella Barnett', 21, 'female'),

('Tonisha Dougherty', 22, 'female'),

('Radney Howels', 27, 'male'),

('Matylda Bernal', 26, 'female'),

('Raymond Corrigan', 28, 'male');

CREATE TABLE `homework`.`skills`(`id` INT NOT NULL AUTO_INCREMENT,
`skill` VARCHAR(255) NOT NULL,
`lvl` VARCHAR(255) NOT NULL,
PRIMARY KEY (`id`));

INSERT INTO skills(skill, lvl) VALUES ('Java', 'Junior'),
('Java', 'Middle'),
('Java', 'Senior'),
('C++', 'Junior'),
('C++', 'Middle'),
('C++', 'Senior'),
('C#', 'Junior'),
('C#', 'Middle'),
('C#', 'Senior'),
('JS', 'Junior'),
('JS', 'Middle'),
('JS', 'Senior');


CREATE TABLE `homework`.`projects` (`id` INT NOT NULL AUTO_INCREMENT,
`name` VARCHAR(255) NOT NULL,
`date` VARCHAR(255) NOT NULL,
PRIMARY KEY (`id`));

INSERT INTO projects(name, date) VALUES ('NewWebApp', '01.04.2019'),
('NewDesktopApp', '03.04.2019'),
('NewWebSite', '06.04.2019');


CREATE TABLE `homework`.`companies` (`id` INT NOT NULL AUTO_INCREMENT,
`name` VARCHAR(255) NOT NULL,
`site` VARCHAR(255) NOT NULL,
PRIMARY KEY (`id`));

INSERT INTO companies(name, site) VALUES ('Google', 'www.google.com'),
('Amazon', 'www.amazon.com'),
('Ebay', 'www.ebay.com');

CREATE TABLE `homework`.`customers` (`id` INT NOT NULL AUTO_INCREMENT,
`name` VARCHAR(255) NOT NULL,
`country` VARCHAR(255) NOT NULL,
PRIMARY KEY (`id`));

INSERT INTO customers(name, country) VALUES ('Ivan', 'Ukraine'),
('John', 'USA'),
('Victoria', 'Sweden');

CREATE TABLE `homework`.developers_projects(
`dev_id` INT,
FOREIGN KEY (dev_id) REFERENCES developers(id),
`project_id` INT,
FOREIGN KEY (project_id) REFERENCES projects(id));

INSERT INTO developers_projects(dev_id, project_id) VALUES (1, 2),
(1, 1),
(2, 3),
(3, 1),
(3, 3),
(4, 2),
(4, 3),
(5, 1),
(5, 2),
(5, 3),
(6, 2);

CREATE TABLE `homework`.developers_skills(
`dev_id` INT,
FOREIGN KEY (dev_id) REFERENCES developers(id),
`skills_id` INT,
FOREIGN KEY (skills_id) REFERENCES skills(id));

INSERT INTO developers_skills(dev_id, skills_id) VALUES (1, 2),
(1, 5),
(2, 12),
(3, 12),(3, 8),
(4, 4),(4, 9),
(5, 3),(5, 7),
(6, 3),(6, 6);

CREATE TABLE `homework`.companies_projects(
`company_id` INT,
FOREIGN KEY (company_id) REFERENCES companies(id),
`project_id` INT,
FOREIGN KEY (project_id) REFERENCES projects(id));

INSERT INTO companies_projects(company_id, project_id) VALUES (1, 1),
(1, 3),
(2, 1),
(2, 2),
(3, 2),
(3, 3);

CREATE TABLE `homework`.customers_projects(
`customer_id` INT,
FOREIGN KEY (customer_id) REFERENCES customers(id),
`project_id` INT,
FOREIGN KEY (project_id) REFERENCES projects(id));

INSERT INTO customers_projects(customer_id, project_id) VALUES (1, 1),
(1, 3),
(2, 1),
(2, 2),
(3, 2),
(3, 3);
