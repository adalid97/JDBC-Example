# JDBC
Ejemplo ejercicio BD concesionario con JDBC.

```sql
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";

CREATE TABLE `clientes` (
  `idCliente` int(255) NOT NULL,
  `nombre` varchar(255) COLLATE utf8mb4_spanish_ci NOT NULL,
  `apellido` varchar(255) COLLATE utf8mb4_spanish_ci NOT NULL,
  `direccion` varchar(255) COLLATE utf8mb4_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

CREATE TABLE `coches` (
  `id` int(255) NOT NULL,
  `marca` varchar(255) COLLATE utf8mb4_spanish_ci NOT NULL,
  `modelo` varchar(255) COLLATE utf8mb4_spanish_ci NOT NULL,
  `matricula` varchar(255) COLLATE utf8mb4_spanish_ci NOT NULL,
  `motor` varchar(255) COLLATE utf8mb4_spanish_ci NOT NULL,
  `fechaMatriculacion` date NOT NULL,
  `precio` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

ALTER TABLE `clientes`
  ADD PRIMARY KEY (`idCliente`);

ALTER TABLE `coches`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `clientes`
  MODIFY `idCliente` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

ALTER TABLE `coches`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;
COMMIT;
```
