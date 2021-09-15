

CREATE TABLE `reservas` (
  `IdR` int NOT NULL AUTO_INCREMENT,
  `Fecha` date NOT NULL,
  `Hora` time NOT NULL,
  `Precio` float NOT NULL,
  PRIMARY KEY (`IdR`),
  CONSTRAINT `IdInstalacion` FOREIGN KEY (`IdR`) REFERENCES `instalaciones` (`IdInstalaciones`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `IdUsuario` FOREIGN KEY (`IdR`) REFERENCES `usuarios` (`IdUsuario`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



