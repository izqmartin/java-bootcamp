USE `highschool` ;

DELIMITER $$
DROP PROCEDURE IF EXISTS listCourse $$

CREATE PROCEDURE listCourse(`Course_Name` VARCHAR(45))
SALIR:BEGIN

	DECLARE messege VARCHAR(100);

	START TRANSACTION;
		SELECT 	c.`name` ,t.lastName, t.firstName, s.lastName, s.firstName
		FROM 	Student s JOIN Assists a ON s.idStudent = a.idStudent
		JOIN	Course c ON a.idCourse = c.idCourse
		JOIN 	Teacher t ON t.idTeacher = c.idTeacher
		WHERE c.`name` = `Course_Name`
		ORDER BY 4 ASC;
	COMMIT;

END$$

DELIMITER $$

DROP PROCEDURE IF EXISTS listFinalNotes$$

CREATE PROCEDURE listFinalNotes_StudentLastName(`Student Last Name` VARCHAR(45))

	SALIR:BEGIN
		
        DECLARE messege VARCHAR(100);
		
        SELECT c.`name`, a.finalNote, s.firstName , s.lastName 
        FROM Student s JOIN Assists a ON s.idStudent = a.idStudent
        JOIN Course c ON c.idCourse = a.idCourse
        WHERE s.lastName = `Student Last Name`
        ORDER BY 2,1 DESC;
    
    COMMIT;


END$$


DELIMITER $$

DROP PROCEDURE IF EXISTS listFinalNotes$$

CREATE PROCEDURE listFinalNotes_RegNum(`Registration Number` INT)

	SALIR:BEGIN
		
        DECLARE messege VARCHAR(100);
		
        SELECT c.`name`, a.finalNote, s.firstName , s.lastName 
        FROM Student s JOIN Assists a ON s.idStudent = a.idStudent
        JOIN Course c ON c.idCourse = a.idCourse
        WHERE s.idStudent = `Registration Number`
        ORDER BY 2,1 DESC;
    
    COMMIT;


END$$



DELIMITER $$

DROP PROCEDURE IF EXISTS courseStats$$

CREATE PROCEDURE courseStats(`Course Name` VARCHAR(45))

	SALIR:BEGIN
    
		DECLARE pass FLOAT(5,2);
        DECLARE fail FLOAT(5,2);
        DECLARE total INT;
        
        SET total = (SELECT COALESCE(COUNT(*),0) FROM Assists a JOIN Course c ON a.idCourse=c.idCourse WHERE c.`name`= `Course Name`);
        SET pass = ((SELECT COALESCE(COUNT(*),0) FROM Assists a JOIN Course c ON a.idCourse=c.idCourse WHERE a.finalNote >= 40.0 AND c.`name`= `Course Name`));
        SET fail = ((SELECT COALESCE(COUNT(*),0) FROM Assists a JOIN Course c ON a.idCourse=c.idCourse WHERE a.finalNote<40.0 AND c.`name`= `Course Name`));
        
        SET pass = (pass/total) *100;
        SET fail = (fail/total) *100;
        
        SELECT pass , fail ;
        
    COMMIT;

END $$


DELIMITER $$

DROP PROCEDURE IF EXISTS courseTimeLine$$

CREATE PROCEDURE courseTimeLine(`Teacher Name` VARCHAR(45))

	SALIR:BEGIN
		
        SELECT	 t.lastName, t.firstName , s.`day`, s.startTime, s.endTime , c.`name`
		FROM	 Teacher t JOIN Course c ON t.idTeacher = c.idTeacher
        JOIN 	 `Scheduler` s ON c.idCourse = s.idCourse
        WHERE 	 t.lastName = `Teacher Name`
        ORDER BY 1,2,3 ASC;
	
    COMMIT;

END $$

