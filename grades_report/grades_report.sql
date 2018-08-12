# https://app.codesignal.com/challenge/ECxw2gmfYWtdjLL33

/*Please add ; after each select statement*/
CREATE PROCEDURE gradesReport()
BEGIN
    SELECT IF(grade <= 'C', name, NULL) AS name, grade, mark FROM students s 
    INNER JOIN grades g ON s.mark >= g.min_mark AND s.mark <= g.max_mark
    ORDER BY grade, CASE WHEN grade <= 'C' THEN name END, CASE WHEN grade > 'C' THEN mark END;
END
