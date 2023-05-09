CREATE PROCEDURE select_from_table (IN table_name VARCHAR(255))
BEGIN
    SET @query = CONCAT('SELECT * FROM ', table_name);
PREPARE stmt FROM @query;
EXECUTE stmt;
DEALLOCATE PREPARE stmt;
END
