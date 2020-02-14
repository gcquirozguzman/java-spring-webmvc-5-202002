--Tabla con datos de empleado

CREATE TABLE `Employee` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) NOT NULL,
  `apellido` varchar(20) NOT NULL,
  `edad` int(20) NOT NULL,
  `salario` DECIMAL(100,2) NOT NULL,
  `sexo` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
);

--Tabla detalle de estudios de empleado

CREATE TABLE `Studie` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `idEmployee` int(10) NOT NULL,
  `studie` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  foreign key (idEmployee) references Employee(id)
);