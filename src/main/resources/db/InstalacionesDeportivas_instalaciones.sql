
DROP DATABASE IF EXISTS InstalacionesDeportivas;
CREATE DATABASE InstalacionesDeportivas;


CREATE TABLE `instalaciones` (
  `IdInstalaciones` int NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) NOT NULL,
  `Descripcion` varchar(200) NOT NULL,
  `Imagen` varchar(1000) DEFAULT NULL,
  `Precio` float NOT NULL,
  PRIMARY KEY (`IdInstalaciones`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

