

CREATE TABLE `reservas_horarios` (
  `IdReservasHorarios` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`IdReservasHorarios`),
  CONSTRAINT `IdHorario` FOREIGN KEY (`IdReservasHorarios`) REFERENCES `horarios_instalaciones` (`IdHorario`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `IdR` FOREIGN KEY (`IdReservasHorarios`) REFERENCES `reservas` (`IdR`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
