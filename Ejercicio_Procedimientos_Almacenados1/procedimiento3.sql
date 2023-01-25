CREATE DEFINER=`root`@`localhost` PROCEDURE `procedimiento3`()
BEGIN
declare salariototal decimal(9,2);
	SELECT SUM(plantilla.Salario) into salariototal
    FROM plantilla;

    IF salariototal < 1000000 THEN
		update plantilla 
        set Salario = Salario+5000;
        
   ELSE 
		update plantilla 
        set Salario=Salario-5000;
        
   END IF;

END