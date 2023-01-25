CREATE DEFINER=`root`@`localhost` PROCEDURE `procedimiento1`()
BEGIN
	DECLARE s INT DEFAULT 0;
	SELECT COUNT(Empleado_No) INTO s
    FROM plantilla
    WHERE Salario >500;
    SELECT s;
END