SELECT AVG(developers.salary), projects.name
FROM developers_projects
LEFT JOIN developers
ON developers.id = developers_projects.dev_id
LEFT JOIN projects
ON projects.id = developers_projects.project_id
GROUP BY projects.id
HAVING MIN(projects.cost)
ORDER BY SUM(developers.salary) DESC
LIMIT 1;