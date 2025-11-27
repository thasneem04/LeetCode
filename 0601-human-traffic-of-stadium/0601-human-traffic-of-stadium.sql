# Write your MySQL query statement below
WITH Valid AS (
    SELECT *
    FROM Stadium
    WHERE people >= 100
),
GroupConsecutive AS (
    SELECT 
        *,
        id - ROW_NUMBER() OVER (ORDER BY id) AS grp
    FROM Valid
)
SELECT 
    id,
    visit_date,
    people
FROM GroupConsecutive
WHERE grp IN (
    SELECT grp
    FROM GroupConsecutive
    GROUP BY grp
    HAVING COUNT(*) >= 3
)
ORDER BY visit_date;
