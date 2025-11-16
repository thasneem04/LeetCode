-- 1. User who rated the most movies
WITH user_counts AS (
    SELECT 
        u.name,
        COUNT(*) AS cnt
    FROM MovieRating mr
    JOIN Users u ON mr.user_id = u.user_id
    GROUP BY u.user_id
),

max_user AS (
    SELECT 
        name
    FROM user_counts
    ORDER BY cnt DESC, name ASC
    LIMIT 1
),

-- 2. Movie with highest average rating in Feb 2020
feb_movies AS (
    SELECT 
        m.title,
        AVG(mr.rating) AS avg_rating
    FROM MovieRating mr
    JOIN Movies m ON mr.movie_id = m.movie_id
    WHERE mr.created_at BETWEEN '2020-02-01' AND '2020-02-29'
    GROUP BY m.movie_id
),

max_movie AS (
    SELECT 
        title
    FROM feb_movies
    ORDER BY avg_rating DESC, title ASC
    LIMIT 1
)

SELECT name AS results FROM max_user
UNION ALL
SELECT title AS results FROM max_movie;

