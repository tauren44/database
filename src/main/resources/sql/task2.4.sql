ALTER TABLE projects ADD COLUMN cost INT;

UPDATE projects SET Cost = (SELECT SUM(developers.salary)
FROM developers_projects
LEFT JOIN developers
ON developers.id = developers_projects.dev_id
GROUP BY id);
