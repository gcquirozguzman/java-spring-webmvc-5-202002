CREATE TABLE `Employee` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) NOT NULL,
  `apellido` varchar(20) NOT NULL,
  `edad` int(20) NOT NULL,
  `salario` DECIMAL(100,2) NOT NULL,
  `sexo` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
);