SELECT 
    f.flavor
FROM
    first_half f
JOIN (
    SELECT
        flavor, SUM(total_order) AS total
    FROM
        july
    GROUP BY
        flavor
) j 
ON 
    f.flavor = j.flavor
ORDER BY
    f.total_order + j.total DESC
LIMIT 3



