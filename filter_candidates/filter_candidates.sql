# https://codefights.com/challenge/MWqbahbP8vRWtqEq2

/*Please add ; after each select statement*/
CREATE PROCEDURE filterCandidates()
BEGIN
    SELECT 
    * 
    FROM jobApplications
    WHERE country_code = 'US' 
        AND visa_type IN ('H1B', 'US citizen') 
        AND experience >= 2
    ORDER BY date,user_id ASC;
END

