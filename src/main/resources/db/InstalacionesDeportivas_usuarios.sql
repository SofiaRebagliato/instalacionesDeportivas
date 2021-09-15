
DROP TABLE IF EXISTS `usuarios`;

CREATE TABLE `usuarios` (
  `IdUsuario` int NOT NULL AUTO_INCREMENT,
  `Email` varchar(30) NOT NULL,
  `Pass` varchar(20) NOT NULL,
  `Nombre` varchar(20) NOT NULL,
  `Apellido1` varchar(20) NOT NULL,
  `Apellido2` varchar(20) NOT NULL,
  `Dni` varchar(9) NOT NULL,
  `Imagen` varchar(1000) DEFAULT NULL,
  `Tipo` enum('Usuario','Administrador') NOT NULL,
  `Estado` enum('Activo','Borrado') NOT NULL,
  PRIMARY KEY (`IdUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
