CREATE DEFINER=`root`@`localhost` PROCEDURE `procedimiento4`(IN nombrehospital varchar(50))
BEGIN
declare numeroEmpleados int;
select COUNT(plantilla.Hospital_Cod) into numeroEmpleados from plantilla 
WHERE 
PLANTILLA.Hospital_Cod = (select hospital_cod from hospital where nombre=nombrehospital);

IF numeroEmpleados = 1 THEN
		SELECT 'El numero de empleados es 1';        
   ELSEIF numeroEmpleados > 2 && numeroEmpleados < 6 THEN
		SELECT 'Trabajan entre 2 y 6 empleados';
   ELSEIF numeroEmpleados > 6 THEN
		SELECT 'Trabajan más de 6 empleados';     
   END IF;

END