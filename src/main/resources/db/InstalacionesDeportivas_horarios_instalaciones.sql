



CREATE TABLE `horarios_instalaciones` (
  `IdHorario` int NOT NULL AUTO_INCREMENT,
  `Dia_semana` date NOT NULL,
  `Hora_inicio` time NOT NULL,
  `Hora_fin` time NOT NULL,
  PRIMARY KEY (`IdHorario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

