SELECT 
    RANK() OVER (ORDER BY SUM(points) DESC) AS rank,
    CASE 
        WHEN clan = '' THEN '[no clan specified]'
        ELSE clan
    END AS clan,
    SUM(points) AS total_points,
    COUNT(*) AS total_people
FROM 
    people
GROUP BY 
    clan
ORDER BY 
    total_points DESC;
