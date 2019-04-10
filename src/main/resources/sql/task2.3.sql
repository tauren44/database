SELECT SUM(developers.salary)
FROM developers_skills
LEFT JOIN developers
ON developers.id = developers_skills.dev_id
LEFT JOIN skills
ON skills.id = developers_skills.dev_id
WHERE `skills`.skill = 'Java';
