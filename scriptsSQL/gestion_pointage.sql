-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Client: 127.0.0.1
-- Généré le: Mar 03 Novembre 2015 à 16:37
-- Version du serveur: 5.5.27-log
-- Version de PHP: 5.4.6

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `gestion_pointage`
--

-- --------------------------------------------------------

--
-- Structure de la table `admin`
--

CREATE TABLE IF NOT EXISTS `admin` (
  `login` text NOT NULL,
  `pass` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `admin`
--

INSERT INTO `admin` (`login`, `pass`) VALUES
('test', 'test');

-- --------------------------------------------------------

--
-- Structure de la table `employe`
--

CREATE TABLE IF NOT EXISTS `employe` (
  `Matricule` int(11) NOT NULL,
  `nom` varchar(30) NOT NULL,
  `departemet` varchar(30) NOT NULL,
  `taux_pre` int(24) NOT NULL,
  `salaire_Jour` int(10) NOT NULL,
  PRIMARY KEY (`Matricule`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `employe`
--

INSERT INTO `employe` (`Matricule`, `nom`, `departemet`, `taux_pre`, `salaire_Jour`) VALUES
(10, 'ali', 'PK', 6, 18),
(100, 'salah', 'PK', 5, 15),
(101, 'el hakiri el', 'PK', 9, 27),
(102, 'loati ramzi', 'PK', 9, 27),
(103, ' khmai', 'PK', 9, 27),
(105, ' mehdi', 'PK', 6, 18),
(107, 'ahmed', 'PK', 9, 27),
(108, 'sarra', 'PK', 9, 27),
(111, 'nouha', 'PK', 5, 15),
(113, 'sami', 'PK', 4, 12);

-- --------------------------------------------------------

--
-- Structure de la table `pointage`
--

CREATE TABLE IF NOT EXISTS `pointage` (
  `idPointage` int(20) NOT NULL,
  `date` varchar(30) NOT NULL,
  `heure_deb` varchar(30) NOT NULL,
  `heure_fin` varchar(30) NOT NULL,
  `matricule` int(20) NOT NULL,
  PRIMARY KEY (`idPointage`),
  KEY `matricule` (`matricule`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `pointage`
--

INSERT INTO `pointage` (`idPointage`, `date`, `heure_deb`, `heure_fin`, `matricule`) VALUES
(1, '22/08/2015', '06:41', '12:03', 10),
(2, '22/08/2015', '07:04', '12:23', 100),
(3, '22/08/2015', '06:20', '15:09', 101),
(4, '22/08/2015', '06:26', '15:09', 102),
(5, '22/08/2015', '06:29', '15:08', 103),
(6, '22/08/2015', '06:51', '12:01', 105),
(7, '22/08/2015', '06:25', '15:04', 107),
(8, '22/08/2015', '06:58', '15:03', 108),
(9, '22/08/2015', '07:03', '12:03', 111),
(10, '22/08/2015', '07:34', '11:07', 113);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
