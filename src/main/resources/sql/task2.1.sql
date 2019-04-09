ALTER TABLE developers ADD COLUMN salary INT;

UPDATE developers SET salary=1700 WHERE id = 1;
UPDATE developers SET salary=1300 WHERE id = 2;
UPDATE developers SET salary=1200 WHERE id = 3;
UPDATE developers SET salary=2000 WHERE id = 4;
UPDATE developers SET salary=1700 WHERE id = 5;
UPDATE developers SET salary=1600 WHERE id = 6;