# https://codefights.com/challenge/YNefPAfkrBHy2Sfu5

/*Please add ; after each select statement*/
CREATE PROCEDURE dataTypes()
BEGIN
    SELECT id,
    CASE
        WHEN data REGEXP "^[0-9]{4}\-(0[0-9]|1[0-2])\-[0-9]{2}$" THEN 'DATETIME'
        WHEN data REGEXP "^(\\+|\\-)?(0|[1-9][0-9]*)\\.[0-9]*$" THEN 'DECIMAL'
        WHEN data IN ('0','1') THEN 'BIT'
        WHEN data REGEXP "^(\\+|\\-)?(0|[1-9][0-9]*)$" THEN 'INT'
    ELSE
        'STRING'
    END as data_type
    FROM flat_data;
END
