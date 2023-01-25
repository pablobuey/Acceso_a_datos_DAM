CREATE DEFINER=`root`@`localhost` PROCEDURE `procedimiento2`(IN hospital varchar(50))
BEGIN

	SELECT doctor.Apellido, hospital.Nombre AS NombreHospital
    FROM doctor
    INNER JOIN
    hospital
    WHERE hospital = hospital.Nombre;

END