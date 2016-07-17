-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jun 23, 2015 at 01:48 PM
-- Server version: 5.5.43-0ubuntu0.14.04.1
-- PHP Version: 5.5.9-1ubuntu4.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `FACTORY`
--
CREATE DATABASE IF NOT EXISTS `FACTORY` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
USE `FACTORY`;

-- --------------------------------------------------------

--
-- Table structure for table `CarsProduced`
--

CREATE TABLE IF NOT EXISTS `CarsProduced` (
  `car_id` int(11) NOT NULL AUTO_INCREMENT,
  `order_date` datetime NOT NULL,
  `required_date` datetime NOT NULL,
  `done_date` datetime DEFAULT NULL,
  `model` enum('family','sport','smart') COLLATE utf8_unicode_ci NOT NULL,
  `color` enum('black','white','red','blue') COLLATE utf8_unicode_ci NOT NULL,
  `edition` enum('standard','comfort') COLLATE utf8_unicode_ci NOT NULL,
  `status` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `comments` text COLLATE utf8_unicode_ci,
  `quantity` int(11) NOT NULL,
  `order_id` int(11) NOT NULL,
  PRIMARY KEY (`car_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=9 ;

--
-- Dumping data for table `CarsProduced`
--

INSERT INTO `CarsProduced` (`car_id`, `order_date`, `required_date`, `done_date`, `model`, `color`, `edition`, `status`, `comments`, `quantity`, `order_id`) VALUES
(4, '2015-06-22 14:26:41', '2015-06-22 14:26:41', '2015-06-22 14:26:41', 'family', 'white', 'standard', 'ready', NULL, 100, 107),
(7, '2015-06-23 09:48:01', '2015-06-23 09:48:01', '2015-06-23 09:48:01', 'smart', 'black', 'standard', 'ready', NULL, 100, 45),
(8, '2015-06-23 09:54:16', '2015-06-23 09:54:16', '2015-06-23 09:54:16', 'sport', 'black', 'standard', 'ready', NULL, 125, 46);

-- --------------------------------------------------------

--
-- Table structure for table `ResupplyRequests`
--

CREATE TABLE IF NOT EXISTS `ResupplyRequests` (
  `order_id` int(12) NOT NULL,
  `model` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `edition` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `color` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `quantity` int(10) NOT NULL,
  `status` enum('pending','completed','cancelled','failed') COLLATE utf8_unicode_ci NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `ResupplyRequests`
--

INSERT INTO `ResupplyRequests` (`order_id`, `model`, `edition`, `color`, `quantity`, `status`, `date`) VALUES
(45, 'smart', 'standard', 'black', 100, 'completed', '2015-06-23 07:48:00'),
(46, 'sport', 'standard', 'black', 125, 'completed', '2015-06-23 07:54:15'),
(48, 'smart', 'standard', 'black', 200, 'pending', '2015-06-23 08:46:49');
--
-- Database: `headquaters`
--
CREATE DATABASE IF NOT EXISTS `headquaters` DEFAULT CHARACTER SET utf32 COLLATE utf32_general_ci;
USE `headquaters`;

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
  `country` enum('malaysia','thailand','indonesia','vietnam','singapore') NOT NULL,
  `address` varchar(256) NOT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf32 AUTO_INCREMENT=9 ;

--
-- Dumping data for table `customers`
--

INSERT INTO `customers` (`customer_id`, `email`, `password`, `name`, `phone_number`, `country`, `address`) VALUES
(3, 'easin_89@hotmail.com', '$2a$12$bIOu.gpGNNfdQGdcC0JYvOLtH/QSgqKTxcrFb6bhsBAtwR8DYOJoC', 'Easin Syed', '+88 01672478872', 'indonesia', '5 Rawalpindi Street'),
(4, 'ekhtiar@gmail.com', '$2a$12$x0MJlSIgt3RQuvNqOE2b2e5gEki9B16xYWruDsY/F3mrDnzpB8zkS', 'Ekhtiar Syed', '+88 01672478872', 'singapore', '123 Maple Street'),
(5, 'gaspar@email.com', '$2a$12$eMWMpwFL2b4CkNFBLtJvWePyRvpDmDuEK01S0p/jPj5neOKkscokS', 'Incze Gaspar', '+54 123444991', 'malaysia', '123 Fake street'),
(6, 'estella@email.com', '$2a$12$TZkygfXkpQWTjW6E.eyCp.iJVoRaGxBntB0sUq/nelYCltgD9tDFa', 'Estella Maeghan', '+84 33488559911', 'singapore', '123 Yellow Street'),
(7, 'john@email.com', '$2a$12$2i5FWjuXAqojUUDi.WQ3Zeo5RBVMvw5Dp76FODiaC2WduB/11fsuW', 'John Doe', '+83 0155563433', 'singapore', '123 Red Street'),
(8, 'samantha@email.com', '$2a$12$rcHJDFP7ofAi4j07XdOX9ecDkrZT4v4HoCU8pF/hZ2oykmOjnjVp6', 'Samantha Smith', '01554778654', 'singapore', '123 Fake street');

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE IF NOT EXISTS `orders` (
  `orders_id` int(50) NOT NULL AUTO_INCREMENT,
  `customer_id` int(50) NOT NULL,
  `model` enum('family','sport','smart') NOT NULL,
  `edition` enum('standard','comfort') NOT NULL,
  `color` enum('black','white','red','blue') NOT NULL,
  `quantity` int(50) NOT NULL,
  `amount` int(50) NOT NULL,
  `status` enum('initialized','paid','manufacture','shipping','canceled') NOT NULL,
  `order_date` date NOT NULL,
  `transaction_id` int(11) DEFAULT NULL,
  `delivery_date` varchar(50) DEFAULT NULL,
  `payment` varchar(10) DEFAULT NULL,
  `warehouse` varchar(10) DEFAULT NULL,
  `manufacturing` varchar(10) DEFAULT NULL,
  `shipping_status` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`orders_id`),
  KEY `customer_id` (`customer_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf32 AUTO_INCREMENT=53 ;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`orders_id`, `customer_id`, `model`, `edition`, `color`, `quantity`, `amount`, `status`, `order_date`, `transaction_id`, `delivery_date`, `payment`, `warehouse`, `manufacturing`, `shipping_status`) VALUES
(34, 6, 'family', 'standard', 'black', 100, 1000000, 'canceled', '2015-06-23', 216, '2015-07-08', 'true', 'true', 'false', 'shipped'),
(35, 6, 'sport', 'standard', 'black', 100, 2500000, 'canceled', '2015-06-23', 217, '2015-07-08', 'true', 'true', 'false', 'shipped'),
(36, 6, 'family', 'standard', 'black', 100, 1000000, 'canceled', '2015-06-23', 218, '2015-07-08', 'true', 'true', 'false', 'shipped'),
(37, 6, 'family', 'standard', 'black', 100, 1000000, 'canceled', '2015-06-23', 219, '2015-07-08', 'true', 'true', 'false', 'shipped'),
(38, 6, 'family', 'standard', 'black', 100, 1000000, 'initialized', '2015-06-23', 220, '2015-07-08', 'true', 'true', 'false', 'shipped'),
(39, 6, 'sport', 'standard', 'black', 100, 2500000, 'initialized', '2015-06-23', 221, '2015-07-08', 'true', 'true', 'false', 'shipped'),
(40, 6, 'family', 'standard', 'black', 100, 1000000, 'initialized', '2015-06-23', 222, '2015-07-08', 'true', 'true', 'false', 'shipped'),
(44, 6, 'smart', 'standard', 'black', 100, 1500000, 'initialized', '2015-06-23', 229, '2015-07-08', 'true', 'true', 'false', 'shipped'),
(45, 6, 'smart', 'standard', 'black', 100, 1500000, 'initialized', '2015-06-23', 230, '2015-07-08', 'true', 'false', 'true', 'shipped'),
(46, 6, 'sport', 'standard', 'black', 125, 3125000, 'canceled', '2015-06-23', 231, '2015-07-08', 'true', 'false', 'true', 'shipped'),
(47, 6, 'family', 'standard', 'black', 100, 1000000, 'canceled', '2015-06-23', 232, '2015-07-08', 'true', 'true', 'false', 'shipped'),
(48, 6, 'smart', 'standard', 'black', 200, 3000000, 'initialized', '2015-06-23', 0, 'tns:deliveryDate', 'true', 'false', 'false', 'tns:result'),
(49, 6, 'family', 'standard', 'black', 500, 5000000, 'initialized', '2015-06-23', 234, '2015-07-08', 'true', 'true', 'false', 'shipped'),
(50, 6, 'family', 'standard', 'white', 500, 5000000, 'initialized', '2015-06-23', 0, 'tns:deliveryDate', 'true', 'false', 'false', 'tns:result'),
(51, 6, 'smart', 'standard', 'black', 100, 1500000, 'initialized', '2015-06-23', 236, '2015-07-08', 'true', 'true', 'false', 'shipped'),
(52, 6, 'smart', 'standard', 'black', 200, 3000000, 'initialized', '2015-06-23', 0, 'tns:deliveryDate', 'true', 'false', 'false', 'tns:result');

-- --------------------------------------------------------

--
-- Table structure for table `payment_information`
--

CREATE TABLE IF NOT EXISTS `payment_information` (
  `customer_id` int(50) NOT NULL,
  `bank` enum('alpha','euro','piraeus') NOT NULL,
  `account_number` varchar(50) NOT NULL,
  UNIQUE KEY `customer_id_2` (`customer_id`),
  KEY `customer_id` (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf32;

--
-- Dumping data for table `payment_information`
--

INSERT INTO `payment_information` (`customer_id`, `bank`, `account_number`) VALUES
(3, 'alpha', '5160665933273216'),
(4, 'alpha', '5283194560580803'),
(5, 'alpha', '4583009881222455677332'),
(6, 'alpha', '238382255383882');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `customer_to_order` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`customer_id`);

--
-- Constraints for table `payment_information`
--
ALTER TABLE `payment_information`
  ADD CONSTRAINT `customer_payment_info` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`customer_id`);
--
-- Database: `phpmyadmin`
--
CREATE DATABASE IF NOT EXISTS `phpmyadmin` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `phpmyadmin`;

-- --------------------------------------------------------

--
-- Table structure for table `pma_bookmark`
--

CREATE TABLE IF NOT EXISTS `pma_bookmark` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dbase` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '',
  `user` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '',
  `label` varchar(255) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `query` text COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Bookmarks' AUTO_INCREMENT=3 ;

--
-- Dumping data for table `pma_bookmark`
--

INSERT INTO `pma_bookmark` (`id`, `dbase`, `user`, `label`, `query`) VALUES
(1, 'warehouse', 'root', 'FAMILY RED LIST', 'SELECT `model_id`, `model`, `edition`, `color`, `country`, `quantity`, `reserved` FROM `cars` WHERE `model`=''family'' AND `color`=''red'''),
(2, 'warehouse', 'root', 'LIST singapore black cars', 'SELECT `model_id`, `model`, `edition`, `color`, `country`, `quantity`, `reserved` FROM `cars` WHERE `country`=''singapore'' AND `color` = ''black''');

-- --------------------------------------------------------

--
-- Table structure for table `pma_column_info`
--

CREATE TABLE IF NOT EXISTS `pma_column_info` (
  `id` int(5) unsigned NOT NULL AUTO_INCREMENT,
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `column_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `comment` varchar(255) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `mimetype` varchar(255) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `transformation` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '',
  `transformation_options` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '',
  PRIMARY KEY (`id`),
  UNIQUE KEY `db_name` (`db_name`,`table_name`,`column_name`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Column information for phpMyAdmin' AUTO_INCREMENT=22 ;

--
-- Dumping data for table `pma_column_info`
--

INSERT INTO `pma_column_info` (`id`, `db_name`, `table_name`, `column_name`, `comment`, `mimetype`, `transformation`, `transformation_options`) VALUES
(1, 'FACTORY', 'CarsProduced', 'quantity', '', '', '_', ''),
(2, 'FACTORY', 'CarsProduced', 'order_id', '', '', '_', ''),
(3, 'warehouse', 'parts', 'part_name', '', '', '_', ''),
(4, 'FACTORY', 'ResupplyRequests', 'order_id', '', '', '_', ''),
(5, 'FACTORY', 'ResupplyRequests', 'model', '', '', '_', ''),
(6, 'FACTORY', 'ResupplyRequests', 'edition', '', '', '_', ''),
(7, 'FACTORY', 'ResupplyRequests', 'color', '', '', '_', ''),
(8, 'FACTORY', 'ResupplyRequests', 'quantity', '', '', '_', ''),
(9, 'FACTORY', 'ResupplyRequests', 'status', '', '', '_', ''),
(10, 'FACTORY', 'ResupplyRequests', 'date', '', '', '_', ''),
(11, 'headquaters', 'orders', 'order_date', '', '', '_', ''),
(12, 'headquaters', 'customers', 'country', '', '', '_', ''),
(13, 'headquaters', 'payment_information', 'bank', '', '', '_', ''),
(14, 'headquaters', 'orders', 'transaction_id', '', '', '_', ''),
(15, 'headquaters', 'orders', 'date', '', '', '_', ''),
(16, 'headquaters', 'orders', 'delivery_date', '', '', '_', ''),
(17, 'headquaters', 'orders', 'payment', '', '', '_', ''),
(18, 'headquaters', 'orders', 'warehouse', '', '', '_', ''),
(19, 'headquaters', 'orders', 'manufacturing', '', '', '_', ''),
(20, 'headquaters', 'orders', 'shipping_status', '', '', '_', ''),
(21, 'headquaters', 'orders', 'status', '', '', '_', '');

-- --------------------------------------------------------

--
-- Table structure for table `pma_designer_coords`
--

CREATE TABLE IF NOT EXISTS `pma_designer_coords` (
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `x` int(11) DEFAULT NULL,
  `y` int(11) DEFAULT NULL,
  `v` tinyint(4) DEFAULT NULL,
  `h` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`db_name`,`table_name`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Table coordinates for Designer';

-- --------------------------------------------------------

--
-- Table structure for table `pma_history`
--

CREATE TABLE IF NOT EXISTS `pma_history` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `db` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `table` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `timevalue` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `sqlquery` text COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`),
  KEY `username` (`username`,`db`,`table`,`timevalue`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='SQL history for phpMyAdmin' AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `pma_pdf_pages`
--

CREATE TABLE IF NOT EXISTS `pma_pdf_pages` (
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `page_nr` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `page_descr` varchar(50) CHARACTER SET utf8 NOT NULL DEFAULT '',
  PRIMARY KEY (`page_nr`),
  KEY `db_name` (`db_name`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='PDF relation pages for phpMyAdmin' AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `pma_recent`
--

CREATE TABLE IF NOT EXISTS `pma_recent` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `tables` text COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Recently accessed tables';

--
-- Dumping data for table `pma_recent`
--

INSERT INTO `pma_recent` (`username`, `tables`) VALUES
('root', '[{"db":"warehouse","table":"regional_orders"},{"db":"FACTORY","table":"CarsProduced"},{"db":"FACTORY","table":"ResupplyRequests"},{"db":"warehouse","table":"cars"},{"db":"warehouse","table":"parts"},{"db":"headquaters","table":"orders"},{"db":"headquaters","table":"payment_information"},{"db":"headquaters","table":"customers"},{"db":"warehouse","table":"customers"}]');

-- --------------------------------------------------------

--
-- Table structure for table `pma_relation`
--

CREATE TABLE IF NOT EXISTS `pma_relation` (
  `master_db` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `master_table` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `master_field` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `foreign_db` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `foreign_table` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `foreign_field` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  PRIMARY KEY (`master_db`,`master_table`,`master_field`),
  KEY `foreign_field` (`foreign_db`,`foreign_table`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Relation table';

-- --------------------------------------------------------

--
-- Table structure for table `pma_table_coords`
--

CREATE TABLE IF NOT EXISTS `pma_table_coords` (
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `pdf_page_number` int(11) NOT NULL DEFAULT '0',
  `x` float unsigned NOT NULL DEFAULT '0',
  `y` float unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`db_name`,`table_name`,`pdf_page_number`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Table coordinates for phpMyAdmin PDF output';

-- --------------------------------------------------------

--
-- Table structure for table `pma_table_info`
--

CREATE TABLE IF NOT EXISTS `pma_table_info` (
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `display_field` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  PRIMARY KEY (`db_name`,`table_name`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Table information for phpMyAdmin';

-- --------------------------------------------------------

--
-- Table structure for table `pma_table_uiprefs`
--

CREATE TABLE IF NOT EXISTS `pma_table_uiprefs` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `prefs` text COLLATE utf8_bin NOT NULL,
  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`username`,`db_name`,`table_name`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Tables'' UI preferences';

--
-- Dumping data for table `pma_table_uiprefs`
--

INSERT INTO `pma_table_uiprefs` (`username`, `db_name`, `table_name`, `prefs`, `last_update`) VALUES
('root', 'warehouse', 'regional_orders', '{"sorted_col":"`regional_orders`.`regional_id` ASC"}', '2015-06-22 10:45:41'),
('root', 'warehouse', 'cars', '{"sorted_col":"`cars`.`model_id` ASC"}', '2015-06-23 07:17:01'),
('root', 'headquaters', 'orders', '[]', '2015-06-22 21:43:48');

-- --------------------------------------------------------

--
-- Table structure for table `pma_tracking`
--

CREATE TABLE IF NOT EXISTS `pma_tracking` (
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `version` int(10) unsigned NOT NULL,
  `date_created` datetime NOT NULL,
  `date_updated` datetime NOT NULL,
  `schema_snapshot` text COLLATE utf8_bin NOT NULL,
  `schema_sql` text COLLATE utf8_bin,
  `data_sql` longtext COLLATE utf8_bin,
  `tracking` set('UPDATE','REPLACE','INSERT','DELETE','TRUNCATE','CREATE DATABASE','ALTER DATABASE','DROP DATABASE','CREATE TABLE','ALTER TABLE','RENAME TABLE','DROP TABLE','CREATE INDEX','DROP INDEX','CREATE VIEW','ALTER VIEW','DROP VIEW') COLLATE utf8_bin DEFAULT NULL,
  `tracking_active` int(1) unsigned NOT NULL DEFAULT '1',
  PRIMARY KEY (`db_name`,`table_name`,`version`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT COMMENT='Database changes tracking for phpMyAdmin';

-- --------------------------------------------------------

--
-- Table structure for table `pma_userconfig`
--

CREATE TABLE IF NOT EXISTS `pma_userconfig` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `timevalue` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `config_data` text COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='User preferences storage for phpMyAdmin';

--
-- Dumping data for table `pma_userconfig`
--

INSERT INTO `pma_userconfig` (`username`, `timevalue`, `config_data`) VALUES
('root', '2015-06-23 10:33:18', '{"LoginCookieValidity":9000,"Server\\/hide_db":""}');
--
-- Database: `warehouse`
--
CREATE DATABASE IF NOT EXISTS `warehouse` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `warehouse`;

-- --------------------------------------------------------

--
-- Table structure for table `cars`
--

CREATE TABLE IF NOT EXISTS `cars` (
  `model_id` int(11) NOT NULL AUTO_INCREMENT,
  `model` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `edition` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `color` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `country` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `quantity` int(11) DEFAULT NULL,
  `reserved` int(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`model_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=121 ;

--
-- Dumping data for table `cars`
--

INSERT INTO `cars` (`model_id`, `model`, `edition`, `color`, `country`, `quantity`, `reserved`) VALUES
(1, 'family', 'standard', 'red', 'bangladesh', 10225, 165),
(2, 'sport', 'standard', 'red', 'bangladesh', 10000, 0),
(3, 'smart', 'standard', 'red', 'bangladesh', 10000, 0),
(4, 'family', 'comfort', 'red', 'bangladesh', 10000, 0),
(5, 'sport', 'comfort', 'red', 'bangladesh', 10000, 0),
(6, 'small', 'comfort', 'red', 'bangladesh', 10000, 0),
(7, 'family', 'standard', 'blue', 'bangladesh', 10000, 0),
(8, 'sport', 'standard', 'blue', 'bangladesh', 10000, 0),
(9, 'smart', 'standard', 'blue', 'bangladesh', 10000, 0),
(10, 'family', 'comfort', 'blue', 'bangladesh', 10000, 0),
(11, 'sport', 'comfort', 'blue', 'bangladesh', 10000, 0),
(12, 'small', 'comfort', 'blue', 'bangladesh', 10000, 100),
(13, 'family', 'standard', 'black', 'bangladesh', 10000, 0),
(14, 'sport', 'standard', 'black', 'bangladesh', 10000, 0),
(15, 'smart', 'standard', 'black', 'bangladesh', 10000, 0),
(16, 'family', 'comfort', 'black', 'bangladesh', 10000, 0),
(17, 'sport', 'comfort', 'black', 'bangladesh', 10000, 0),
(18, 'small', 'comfort', 'black', 'bangladesh', 10000, 0),
(19, 'family', 'standard', 'white', 'bangladesh', 10000, 0),
(20, 'sport', 'standard', 'white', 'bangladesh', 10000, 0),
(21, 'smart', 'standard', 'white', 'bangladesh', 10000, 0),
(22, 'family', 'comfort', 'white', 'bangladesh', 9985, 60),
(23, 'sport', 'comfort', 'white', 'bangladesh', 10000, 0),
(24, 'small', 'comfort', 'white', 'bangladesh', 10000, 0),
(25, 'family', 'standard', 'red', 'singapore', 156000, 44100),
(26, 'sport', 'standard', 'red', 'singapore', 10000, 0),
(27, 'smart', 'standard', 'red', 'singapore', 10000, 0),
(28, 'family', 'comfort', 'red', 'singapore', 10000, 0),
(29, 'sport', 'comfort', 'red', 'singapore', 10000, 0),
(30, 'small', 'comfort', 'red', 'singapore', 10000, 0),
(31, 'family', 'standard', 'blue', 'singapore', 10000, 0),
(32, 'sport', 'standard', 'blue', 'singapore', 10000, 0),
(33, 'smart', 'standard', 'blue', 'singapore', 10000, 0),
(34, 'family', 'comfort', 'blue', 'singapore', 10000, 0),
(35, 'sport', 'comfort', 'blue', 'singapore', 10000, 0),
(36, 'small', 'comfort', 'blue', 'singapore', 10000, 0),
(37, 'family', 'standard', 'black', 'singapore', 8700, 0),
(38, 'sport', 'standard', 'black', 'singapore', 260, 0),
(39, 'smart', 'standard', 'black', 'singapore', 10, 0),
(40, 'family', 'comfort', 'black', 'singapore', 10000, 0),
(41, 'sport', 'comfort', 'black', 'singapore', 10000, 0),
(42, 'small', 'comfort', 'black', 'singapore', 10000, 0),
(43, 'family', 'standard', 'white', 'singapore', 10, 0),
(44, 'sport', 'standard', 'white', 'singapore', 10000, 0),
(45, 'smart', 'standard', 'white', 'singapore', 9900, 0),
(46, 'family', 'comfort', 'white', 'singapore', 10000, 0),
(47, 'sport', 'comfort', 'white', 'singapore', 10000, 0),
(48, 'small', 'comfort', 'white', 'singapore', 10000, 0),
(49, 'family', 'standard', 'red', 'malaysia', 10000, 0),
(50, 'sport', 'standard', 'red', 'malaysia', 10000, 0),
(51, 'smart', 'standard', 'red', 'malaysia', 10000, 0),
(52, 'family', 'comfort', 'red', 'malaysia', 11638, 4852),
(53, 'sport', 'comfort', 'red', 'malaysia', 10000, 0),
(54, 'small', 'comfort', 'red', 'malaysia', 10000, 0),
(55, 'family', 'standard', 'blue', 'malaysia', 10000, 0),
(56, 'sport', 'standard', 'blue', 'malaysia', 10000, 0),
(57, 'smart', 'standard', 'blue', 'malaysia', 10000, 0),
(58, 'family', 'comfort', 'blue', 'malaysia', 10000, 0),
(59, 'sport', 'comfort', 'blue', 'malaysia', 10000, 0),
(60, 'small', 'comfort', 'blue', 'malaysia', 10000, 0),
(61, 'family', 'standard', 'black', 'malaysia', 10000, 0),
(62, 'sport', 'standard', 'black', 'malaysia', 10000, 0),
(63, 'smart', 'standard', 'black', 'malaysia', 10000, 0),
(64, 'family', 'comfort', 'black', 'malaysia', 10000, 0),
(65, 'sport', 'comfort', 'black', 'malaysia', 10000, 0),
(66, 'small', 'comfort', 'black', 'malaysia', 10000, 0),
(67, 'family', 'standard', 'white', 'malaysia', 10000, 0),
(68, 'sport', 'standard', 'white', 'malaysia', 10000, 0),
(69, 'smart', 'standard', 'white', 'malaysia', 10000, 0),
(70, 'family', 'comfort', 'white', 'malaysia', 10000, 0),
(71, 'sport', 'comfort', 'white', 'malaysia', 10000, 0),
(72, 'small', 'comfort', 'white', 'malaysia', 10000, 0),
(73, 'family', 'standard', 'red', 'indonesia', 10000, 0),
(74, 'sport', 'standard', 'red', 'indonesia', 10000, 0),
(75, 'smart', 'standard', 'red', 'indonesia', 10000, 0),
(76, 'family', 'comfort', 'red', 'indonesia', 10000, 14),
(77, 'sport', 'comfort', 'red', 'indonesia', 10000, 0),
(78, 'small', 'comfort', 'red', 'indonesia', 10000, 0),
(79, 'family', 'standard', 'blue', 'indonesia', 10000, 0),
(80, 'sport', 'standard', 'blue', 'indonesia', 10000, 0),
(81, 'smart', 'standard', 'blue', 'indonesia', 10000, 0),
(82, 'family', 'comfort', 'blue', 'indonesia', 10000, 0),
(83, 'sport', 'comfort', 'blue', 'indonesia', 10000, 0),
(84, 'small', 'comfort', 'blue', 'indonesia', 10000, 0),
(85, 'family', 'standard', 'black', 'indonesia', 10000, 0),
(86, 'sport', 'standard', 'black', 'indonesia', 10000, 0),
(87, 'smart', 'standard', 'black', 'indonesia', 10000, 0),
(88, 'family', 'comfort', 'black', 'indonesia', 10000, 0),
(89, 'sport', 'comfort', 'black', 'indonesia', 10000, 0),
(90, 'small', 'comfort', 'black', 'indonesia', 10000, 0),
(91, 'family', 'standard', 'white', 'indonesia', 10000, 0),
(92, 'sport', 'standard', 'white', 'indonesia', 10000, 0),
(93, 'smart', 'standard', 'white', 'indonesia', 10000, 0),
(94, 'family', 'comfort', 'white', 'indonesia', 10000, 0),
(95, 'sport', 'comfort', 'white', 'indonesia', 10000, 0),
(96, 'small', 'comfort', 'white', 'indonesia', 10000, 0),
(97, 'family', 'standard', 'red', 'thailand', 10000, 0),
(98, 'sport', 'standard', 'red', 'thailand', 10000, 0),
(99, 'smart', 'standard', 'red', 'thailand', 10000, 0),
(100, 'family', 'comfort', 'red', 'thailand', 10000, 0),
(101, 'sport', 'comfort', 'red', 'thailand', 10000, 0),
(102, 'small', 'comfort', 'red', 'thailand', 10000, 0),
(103, 'family', 'standard', 'blue', 'thailand', 10000, 0),
(104, 'sport', 'standard', 'blue', 'thailand', 10000, 0),
(105, 'smart', 'standard', 'blue', 'thailand', 10000, 0),
(106, 'family', 'comfort', 'blue', 'thailand', 10000, 0),
(107, 'sport', 'comfort', 'blue', 'thailand', 10000, 0),
(108, 'small', 'comfort', 'blue', 'thailand', 10000, 0),
(109, 'family', 'standard', 'black', 'thailand', 10000, 0),
(110, 'sport', 'standard', 'black', 'thailand', 10000, 0),
(111, 'smart', 'standard', 'black', 'thailand', 10000, 0),
(112, 'family', 'comfort', 'black', 'thailand', 10000, 0),
(113, 'sport', 'comfort', 'black', 'thailand', 10000, 0),
(114, 'small', 'comfort', 'black', 'thailand', 10000, 0),
(115, 'family', 'standard', 'white', 'thailand', 10000, 0),
(116, 'sport', 'standard', 'white', 'thailand', 10000, 0),
(117, 'smart', 'standard', 'white', 'thailand', 10000, 0),
(118, 'family', 'comfort', 'white', 'thailand', 10000, 0),
(119, 'sport', 'comfort', 'white', 'thailand', 10000, 0),
(120, 'small', 'comfort', 'white', 'thailand', 10000, 0);

-- --------------------------------------------------------

--
-- Table structure for table `parts`
--

CREATE TABLE IF NOT EXISTS `parts` (
  `part_id` int(6) NOT NULL AUTO_INCREMENT,
  `part_name` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `quantity` int(15) NOT NULL,
  PRIMARY KEY (`part_id`),
  UNIQUE KEY `part_name` (`part_name`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=15 ;

--
-- Dumping data for table `parts`
--

INSERT INTO `parts` (`part_id`, `part_name`, `quantity`) VALUES
(3, 'family_chassis', 425),
(4, 'sport_chassis', 375),
(5, 'smart_chassis', 660),
(6, 'family_parts', 925),
(7, 'sport_parts', 475),
(8, 'smart_parts', 200),
(9, 'radio', 540),
(10, 'regenerative_breaks', 300),
(11, 'ac', 1625),
(12, 'sunroof', 230),
(14, 'turbo_electric_charger', 420);

-- --------------------------------------------------------

--
-- Table structure for table `regional_orders`
--

CREATE TABLE IF NOT EXISTS `regional_orders` (
  `regional_id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(50) NOT NULL,
  `customer_id` int(50) NOT NULL,
  `model_id` int(50) NOT NULL,
  `quantity` int(50) NOT NULL,
  `shipping_id` int(50) NOT NULL,
  `customer_name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `customer_address` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `country` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `status` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`regional_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=88 ;

--
-- Dumping data for table `regional_orders`
--

INSERT INTO `regional_orders` (`regional_id`, `order_id`, `customer_id`, `model_id`, `quantity`, `shipping_id`, `customer_name`, `customer_address`, `country`, `status`) VALUES
(44, 100, 17, 43, 100, 28, 'Estella Maeghan', '123 Fake Street', 'singapore', 'ready to ship'),
(47, 103, 17, 43, 100, 29, 'Estella Maeghan', '123 Fake Street', 'singapore', 'initialized'),
(69, 37, 6, 37, 100, 47, 'Estella Maeghan', '123 Yellow Street', 'singapore', 'canceled'),
(70, 38, 6, 37, 100, 48, 'Estella Maeghan', '123 Yellow Street', 'singapore', 'ready to ship'),
(71, 39, 6, 38, 100, 49, 'Estella Maeghan', '123 Yellow Street', 'singapore', 'ready to ship'),
(72, 40, 6, 37, 100, 50, 'Estella Maeghan', '123 Yellow Street', 'singapore', 'ready to ship'),
(78, 43, 6, 39, 100, 52, 'Estella Maeghan', '123 Yellow Street', 'singapore', 'initialized'),
(79, 44, 6, 39, 100, 53, 'Estella Maeghan', '123 Yellow Street', 'singapore', 'ready to ship'),
(80, 45, 6, 39, 100, 54, 'Estella Maeghan', '123 Yellow Street', 'singapore', 'ready to ship'),
(81, 46, 6, 38, 125, 55, 'Estella Maeghan', '123 Yellow Street', 'singapore', 'canceled'),
(82, 47, 6, 37, 100, 56, 'Estella Maeghan', '123 Yellow Street', 'singapore', 'canceled'),
(83, 48, 6, 39, 200, 57, 'Estella Maeghan', '123 Yellow Street', 'singapore', 'initialized'),
(84, 49, 6, 37, 500, 0, 'Estella Maeghan', '123 Yellow Street', 'singapore', 'ready to ship'),
(85, 50, 6, 43, 500, 0, 'Estella Maeghan', '123 Yellow Street', 'singapore', 'initialized'),
(86, 51, 6, 39, 100, 0, 'Estella Maeghan', '123 Yellow Street', 'singapore', 'ready to ship'),
(87, 52, 6, 39, 200, 0, 'Estella Maeghan', '123 Yellow Street', 'singapore', 'initialized');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
