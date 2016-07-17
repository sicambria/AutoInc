-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jun 06, 2015 at 02:53 PM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `headquaters`
--

-- --------------------------------------------------------

--
-- Table structure for table `customers`
--

CREATE TABLE IF NOT EXISTS `customers` (
  `customer_id` int(50) NOT NULL AUTO_INCREMENT,
  `email` varchar(50) NOT NULL,
  `password` varchar(256) NOT NULL,
  `name` varchar(50) NOT NULL,
  `phone_number` varchar(50) NOT NULL,
  `country` enum('Malaysia','Thailand','Indonesia','Vietnam','Singapore') NOT NULL,
  `address` varchar(256) NOT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf32 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `customers`
--

INSERT INTO `customers` (`customer_id`, `email`, `password`, `name`, `phone_number`, `country`, `address`) VALUES
(3, 'easin_89@hotmail.com', '$2a$12$bIOu.gpGNNfdQGdcC0JYvOLtH/QSgqKTxcrFb6bhsBAtwR8DYOJoC', 'Easin Syed', '+88 01672478872', 'Singapore', '5 Rawalpindi Street');

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE IF NOT EXISTS `orders` (
  `orders_id` int(50) NOT NULL AUTO_INCREMENT,
  `customer_id` int(50) NOT NULL,
  `model` enum('family','sport','smart') NOT NULL,
  `edition` enum('standard','comfortable') NOT NULL,
  `color` enum('black','white','red','blue') NOT NULL,
  `quantity` int(50) NOT NULL,
  `amount` int(50) NOT NULL,
  `status` enum('initialized','paid','manufacture','shipping') NOT NULL,
  PRIMARY KEY (`orders_id`),
  KEY `customer_id` (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf32 AUTO_INCREMENT=1 ;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `customer_to_order` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`customer_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
