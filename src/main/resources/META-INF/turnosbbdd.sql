-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 30-11-2023 a las 16:51:04
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.1.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `turnosbbdd`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `CIUDADANO`
--

CREATE TABLE `CIUDADANO` (
  `ID` bigint(20) NOT NULL,
  `APELLIDO` varchar(255) DEFAULT NULL,
  `DNI` varchar(255) DEFAULT NULL,
  `NOMBRE` varchar(255) DEFAULT NULL,
  `TELEFONO` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_spanish2_ci;

--
-- Volcado de datos para la tabla `CIUDADANO`
--

INSERT INTO `CIUDADANO` (`ID`, `APELLIDO`, `DNI`, `NOMBRE`, `TELEFONO`) VALUES
(1, 'Herrera', '142425468A', 'Paco', 679887789),
(2, 'El aparecido', '53452288N', 'Enrique', 678993042),
(3, 'Perez', '21354689N', 'Beatriz', 456797897),
(4, 'Cano', '12345678A', 'Nacho', 677877988),
(5, 'El aparecido', '53452288N', 'Enrique', 677032511),
(6, 'Ballesta Garcia', '53452288N', 'Juan Jose', 677032511),
(7, 'Corazzini Rubio', '45678945A', 'Adriana', 689787985),
(8, 'El aparecido', '53452288N', 'Enrique', 677032511);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `TURNO`
--

CREATE TABLE `TURNO` (
  `ID` bigint(20) NOT NULL,
  `ESTADO` tinyint(1) DEFAULT 0,
  `FECHA` date DEFAULT NULL,
  `HORA` varchar(255) DEFAULT NULL,
  `TRAMITE` varchar(255) DEFAULT NULL,
  `ciudadano_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_spanish2_ci;

--
-- Volcado de datos para la tabla `TURNO`
--

INSERT INTO `TURNO` (`ID`, `ESTADO`, `FECHA`, `HORA`, `TRAMITE`, `ciudadano_id`) VALUES
(1, 1, '2023-11-30', '16:00', 'DNI', 1),
(2, 1, '2023-11-30', '19:00', 'CITA MEDICA', 2),
(3, 0, '2023-11-30', '13:00', 'Abono transporte', 3),
(4, 1, '2023-11-14', '20:00', 'Medico', 4),
(5, 0, '2023-11-25', '16:00', 'DNI', 5),
(6, 0, '2023-12-01', '19:00', 'CITA MEDICA', 6),
(7, 0, '2023-11-30', '20:00', 'Titulacion', 7),
(8, 0, '2023-03-01', '19:00', 'DNI', 8);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `CIUDADANO`
--
ALTER TABLE `CIUDADANO`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `TURNO`
--
ALTER TABLE `TURNO`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_TURNO_ciudadano_id` (`ciudadano_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `CIUDADANO`
--
ALTER TABLE `CIUDADANO`
  MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `TURNO`
--
ALTER TABLE `TURNO`
  MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `TURNO`
--
ALTER TABLE `TURNO`
  ADD CONSTRAINT `FK_TURNO_ciudadano_id` FOREIGN KEY (`ciudadano_id`) REFERENCES `CIUDADANO` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
