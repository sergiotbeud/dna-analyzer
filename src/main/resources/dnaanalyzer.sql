-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Sep 28, 2021 at 06:07 AM
-- Server version: 5.7.24
-- PHP Version: 7.4.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dnaanalyzer`
--

-- --------------------------------------------------------

--
-- Table structure for table `dna`
--

CREATE TABLE `dna` (
  `id` int(11) NOT NULL,
  `dna` tinyblob,
  `type` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `dna`
--

INSERT INTO `dna` (`id`, `dna`, `type`) VALUES
(1, 0xaced0005757200135b4c6a6176612e6c616e672e537472696e673badd256e7e91d7b47020000787000000006740006415447434341740006434147544743740006545441544754740006414741414747740006434343435441740006544341435447, 1),
(2, 0xaced0005757200135b4c6a6176612e6c616e672e537472696e673badd256e7e91d7b47020000787000000006740006435447434741740006434147544743740006545441544754740006414741414747740006434343435441740006544341435447, 1);

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(3);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `dna`
--
ALTER TABLE `dna`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
