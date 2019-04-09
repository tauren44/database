SELECT SUM(developers.salary), projects.name
FROM developers_projects
LEFT JOIN developers
ON developers.id = developers_projects.dev_id
LEFT JOIN projects
ON projects.id = developers_projects.project_id
GROUP BY projects.id
ORDER BY SUM(developers.salary) DESC
LIMIT 1;
