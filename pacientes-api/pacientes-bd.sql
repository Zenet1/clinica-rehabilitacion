-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 07-08-2023 a las 06:16:18
-- Versión del servidor: 10.4.27-MariaDB
-- Versión de PHP: 8.1.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `pacientes-bd`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `antecedentes_familiares`
--

CREATE TABLE `antecedentes_familiares` (
  `id` bigint(20) NOT NULL,
  `alergias` varchar(255) DEFAULT NULL,
  `cardiopatias` varchar(255) DEFAULT NULL,
  `diabetes` varchar(255) DEFAULT NULL,
  `nefropatias` varchar(255) DEFAULT NULL,
  `neurologicas` varchar(255) DEFAULT NULL,
  `otros` varchar(255) DEFAULT NULL,
  `psiquiatricos` varchar(255) DEFAULT NULL,
  `id_paciente` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `antecedentes_familiares`
--

INSERT INTO `antecedentes_familiares` (`id`, `alergias`, `cardiopatias`, `diabetes`, `nefropatias`, `neurologicas`, `otros`, `psiquiatricos`, `id_paciente`) VALUES
(402, 'Padre', 'Abuela materna', 'Madre', 'Ninguno', 'Abuelo paterno', 'Ninguno', 'Ninguno', 52),
(403, 'Ninguno', 'Tío materno', 'Abuelo materno', 'Ninguno', 'Ninguno', 'Ninguno', 'Primo paterno', 53),
(404, 'Ninguno', 'Abuelo paterno', 'Padre', 'Ninguno', 'Tía materna', 'Ninguno', 'Madre', 54),
(405, 'Ninguno', 'Primo materno', 'Ninguno', 'Ninguno', 'Ninguno', 'Ninguno', 'Abuelo materno', 55);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `antecedentes_familiares_seq`
--

CREATE TABLE `antecedentes_familiares_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `antecedentes_familiares_seq`
--

INSERT INTO `antecedentes_familiares_seq` (`next_val`) VALUES
(501);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `antecedentes_gineco_obstetricos`
--

CREATE TABLE `antecedentes_gineco_obstetricos` (
  `id` bigint(20) NOT NULL,
  `fup` date NOT NULL,
  `ipsa` int(11) DEFAULT NULL,
  `abortos` int(11) DEFAULT NULL,
  `cesareas` int(11) DEFAULT NULL,
  `menarca` datetime(6) DEFAULT NULL,
  `partos` int(11) DEFAULT NULL,
  `ritmo_menstrual` varchar(255) DEFAULT NULL,
  `id_paciente` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `antecedentes_gineco_obstetricos`
--

INSERT INTO `antecedentes_gineco_obstetricos` (`id`, `fup`, `ipsa`, `abortos`, `cesareas`, `menarca`, `partos`, `ritmo_menstrual`, `id_paciente`) VALUES
(102, '2022-01-10', 0, 1, 0, '2008-03-14 18:00:00.000000', 2, 'Regular', 53),
(103, '2023-03-22', 0, 0, 0, '2010-08-09 19:00:00.000000', 1, 'Regular', 55);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `antecedentes_gineco_obstetricos_seq`
--

CREATE TABLE `antecedentes_gineco_obstetricos_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `antecedentes_gineco_obstetricos_seq`
--

INSERT INTO `antecedentes_gineco_obstetricos_seq` (`next_val`) VALUES
(201);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `antecedentes_no_patologicos`
--

CREATE TABLE `antecedentes_no_patologicos` (
  `id` bigint(20) NOT NULL,
  `zoonosis` varchar(255) DEFAULT NULL,
  `actividad_fisica` varchar(255) DEFAULT NULL,
  `alcoholismo` varchar(255) DEFAULT NULL,
  `alimentacion` varchar(255) DEFAULT NULL,
  `baño` varchar(255) DEFAULT NULL,
  `estado_civil` varchar(255) DEFAULT NULL,
  `habitacion` varchar(255) DEFAULT NULL,
  `habitos` varchar(255) DEFAULT NULL,
  `tabaquismo` varchar(255) DEFAULT NULL,
  `vacunas` varchar(255) DEFAULT NULL,
  `id_paciente` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `antecedentes_no_patologicos`
--

INSERT INTO `antecedentes_no_patologicos` (`id`, `zoonosis`, `actividad_fisica`, `alcoholismo`, `alimentacion`, `baño`, `estado_civil`, `habitacion`, `habitos`, `tabaquismo`, `vacunas`, `id_paciente`) VALUES
(102, 'No ha tenido contacto con zoonosis', 'Realiza ejercicio regularmente', 'No consume alcohol', 'Alimentación balanceada', 'Diario', 'Soltero/a', 'Comparte habitación', 'Buenos hábitos de higiene', 'No fuma', 'Vacunas al día', 52),
(103, 'Tuvo contacto con mascotas sin problemas', 'Realiza caminatas frecuentes', 'Consume alcohol ocasionalmente', 'Prefiere alimentos frescos', 'Diario', 'Casado/a', 'Individual', 'Hábitos de higiene regulares', 'No fuma', 'Algunas vacunas pendientes', 53),
(104, 'No ha tenido contacto con zoonosis', 'Practica yoga regularmente', 'No consume alcohol', 'Prefiere dieta vegetariana', 'Diario', 'Casado/a', 'Comparte habitación', 'Buenos hábitos de higiene', 'No fuma', 'Vacunas al día', 54),
(105, 'No ha tenido contacto con zoonosis', 'Participa en clases de baile', 'No consume alcohol', 'Alimentación equilibrada', 'Diario', 'Soltero/a', 'Individual', 'Hábitos de higiene regulares', 'No fuma', 'Vacunas al día', 55);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `antecedentes_no_patologicos_seq`
--

CREATE TABLE `antecedentes_no_patologicos_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `antecedentes_no_patologicos_seq`
--

INSERT INTO `antecedentes_no_patologicos_seq` (`next_val`) VALUES
(201);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `antecedentes_patologicos`
--

CREATE TABLE `antecedentes_patologicos` (
  `id` bigint(20) NOT NULL,
  `ets` varchar(255) DEFAULT NULL,
  `adicciiones` varchar(255) DEFAULT NULL,
  `alergias` varchar(255) DEFAULT NULL,
  `cirugias` varchar(255) DEFAULT NULL,
  `padecimientos_articulares` varchar(255) DEFAULT NULL,
  `traumatismos` varchar(255) DEFAULT NULL,
  `id_paciente` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `antecedentes_patologicos`
--

INSERT INTO `antecedentes_patologicos` (`id`, `ets`, `adicciiones`, `alergias`, `cirugias`, `padecimientos_articulares`, `traumatismos`, `id_paciente`) VALUES
(1, 'No tiene', 'No tiene', 'Ninguna', 'Apéndice en 2019', 'Artritis reumatoide', 'Fractura de muñeca en 2015', 52),
(2, 'No tiene', 'Tabaquismo', 'Ninguna', 'Cirugia de hernia en 2020', 'Osteoporosis', 'No tiene', 53),
(3, 'No tiene', 'Alcoholismo', 'Polen', 'No tiene', 'Artrosis', 'Lesión en la espalda en 2017', 54);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `antecedentes_patologicos_seq`
--

CREATE TABLE `antecedentes_patologicos_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `antecedentes_patologicos_seq`
--

INSERT INTO `antecedentes_patologicos_seq` (`next_val`) VALUES
(101);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `antecedentes_perinatales`
--

CREATE TABLE `antecedentes_perinatales` (
  `id` bigint(20) NOT NULL,
  `apgar` varchar(255) DEFAULT NULL,
  `pdp` varchar(255) DEFAULT NULL,
  `sdg` int(11) DEFAULT NULL,
  `embarazos` int(11) DEFAULT NULL,
  `nacimiento` datetime(6) DEFAULT NULL,
  `talla` int(11) DEFAULT NULL,
  `id_paciente` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `antecedentes_perinatales`
--

INSERT INTO `antecedentes_perinatales` (`id`, `apgar`, `pdp`, `sdg`, `embarazos`, `nacimiento`, `talla`, `id_paciente`) VALUES
(1, '9/100', 'Normal', 40, 2, '2023-08-05 18:00:00.000000', 52, 53),
(2, '8/10', 'Bajo peso al nacer', 39, 3, '2022-03-14 18:00:00.000000', 49, 55);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `antecedentes_perinatales_seq`
--

CREATE TABLE `antecedentes_perinatales_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `antecedentes_perinatales_seq`
--

INSERT INTO `antecedentes_perinatales_seq` (`next_val`) VALUES
(101);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paciente`
--

CREATE TABLE `paciente` (
  `id` bigint(20) NOT NULL,
  `apellidos` varchar(60) NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `direccion` varchar(255) NOT NULL,
  `email` varchar(60) NOT NULL,
  `escolaridad` varchar(40) NOT NULL,
  `estado_civil` varchar(40) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `nombre` varchar(40) NOT NULL,
  `ocupacion` varchar(60) NOT NULL,
  `telefono` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `paciente`
--

INSERT INTO `paciente` (`id`, `apellidos`, `created_at`, `direccion`, `email`, `escolaridad`, `estado_civil`, `fecha_nacimiento`, `nombre`, `ocupacion`, `telefono`) VALUES
(52, 'Pérez', '2023-08-06 22:04:04.000000', 'Calle 123, Ciudad', 'juan@example.com', 'Universidad', 'Soltero', '1990-05-15', 'Juan', 'Ingeniero', '1234567890'),
(53, 'Gómez', '2023-08-06 22:04:11.000000', 'Avenida 456, Ciudad', 'maria@example.com', 'Secundaria', 'Casada', '1985-10-25', 'María', 'Maestra', '9876543210'),
(54, 'Rodríguez', '2023-08-06 22:04:50.000000', 'Calle Principal 456, Ciudad', 'carlos@example.com', 'Maestría', 'Casado', '1982-03-20', 'Carlos', 'Abogado', '3334445555'),
(55, 'López', '2023-08-06 22:04:59.000000', 'Avenida Central 789, Ciudad', 'ana@example.com', 'Licenciatura', 'Soltera', '1998-07-08', 'Ana', 'Contadora', '7778889999');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paciente_seq`
--

CREATE TABLE `paciente_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `paciente_seq`
--

INSERT INTO `paciente_seq` (`next_val`) VALUES
(151);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `antecedentes_familiares`
--
ALTER TABLE `antecedentes_familiares`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK3fbkrqkvmksvsbos31722k7xk` (`id_paciente`);

--
-- Indices de la tabla `antecedentes_gineco_obstetricos`
--
ALTER TABLE `antecedentes_gineco_obstetricos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKohbshljthnmb2p1tm0df7mkqg` (`id_paciente`);

--
-- Indices de la tabla `antecedentes_no_patologicos`
--
ALTER TABLE `antecedentes_no_patologicos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKl4m4g3fsflg4hqx3ww25cn6r6` (`id_paciente`);

--
-- Indices de la tabla `antecedentes_patologicos`
--
ALTER TABLE `antecedentes_patologicos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK2ui68h10b193r179ymx4rcyb6` (`id_paciente`);

--
-- Indices de la tabla `antecedentes_perinatales`
--
ALTER TABLE `antecedentes_perinatales`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKa8wa8xli9a3o6rdp32dtm08cp` (`id_paciente`);

--
-- Indices de la tabla `paciente`
--
ALTER TABLE `paciente`
  ADD PRIMARY KEY (`id`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `antecedentes_familiares`
--
ALTER TABLE `antecedentes_familiares`
  ADD CONSTRAINT `FK3fbkrqkvmksvsbos31722k7xk` FOREIGN KEY (`id_paciente`) REFERENCES `paciente` (`id`);

--
-- Filtros para la tabla `antecedentes_gineco_obstetricos`
--
ALTER TABLE `antecedentes_gineco_obstetricos`
  ADD CONSTRAINT `FKohbshljthnmb2p1tm0df7mkqg` FOREIGN KEY (`id_paciente`) REFERENCES `paciente` (`id`);

--
-- Filtros para la tabla `antecedentes_no_patologicos`
--
ALTER TABLE `antecedentes_no_patologicos`
  ADD CONSTRAINT `FKl4m4g3fsflg4hqx3ww25cn6r6` FOREIGN KEY (`id_paciente`) REFERENCES `paciente` (`id`);

--
-- Filtros para la tabla `antecedentes_patologicos`
--
ALTER TABLE `antecedentes_patologicos`
  ADD CONSTRAINT `FK2ui68h10b193r179ymx4rcyb6` FOREIGN KEY (`id_paciente`) REFERENCES `paciente` (`id`);

--
-- Filtros para la tabla `antecedentes_perinatales`
--
ALTER TABLE `antecedentes_perinatales`
  ADD CONSTRAINT `FKa8wa8xli9a3o6rdp32dtm08cp` FOREIGN KEY (`id_paciente`) REFERENCES `paciente` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
