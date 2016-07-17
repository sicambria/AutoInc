-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Hoszt: localhost
-- Létrehozás ideje: 2015. Jún 23. 13:49
-- Szerver verzió: 5.5.43-0ubuntu0.14.04.1
-- PHP verzió: 5.5.9-1ubuntu4.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Adatbázis: `EU_SUPP`
--
CREATE DATABASE IF NOT EXISTS `EU_SUPP` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
USE `EU_SUPP`;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `Chassis`
--

CREATE TABLE IF NOT EXISTS `Chassis` (
  `chassis_id` int(11) NOT NULL AUTO_INCREMENT,
  `chassis_name` enum('family_chassis','sport_chassis','smart_chassis') COLLATE utf8_unicode_ci NOT NULL,
  `quantity` int(11) NOT NULL,
  `comments` text COLLATE utf8_unicode_ci,
  PRIMARY KEY (`chassis_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=4 ;

--
-- A tábla adatainak kiíratása `Chassis`
--

INSERT INTO `Chassis` (`chassis_id`, `chassis_name`, `quantity`, `comments`) VALUES
(1, 'family_chassis', 4000, 'Chassis for Family model'),
(2, 'sport_chassis', 4000, 'Chassis for Sport model'),
(3, 'smart_chassis', 3400, 'Chassis for Smart model');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `Log`
--

CREATE TABLE IF NOT EXISTS `Log` (
  `log_id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) NOT NULL,
  `chassis_name` enum('family_chassis','sport_chassis','smart_chassis') COLLATE utf8_unicode_ci NOT NULL,
  `quantity` int(11) NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`log_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=56 ;

--
-- A tábla adatainak kiíratása `Log`
--

INSERT INTO `Log` (`log_id`, `order_id`, `chassis_name`, `quantity`, `date`) VALUES
(55, 906, 'smart_chassis', 600, '2015-06-23');
--
-- Adatbázis: `LOGISTICS`
--
CREATE DATABASE IF NOT EXISTS `LOGISTICS` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
USE `LOGISTICS`;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `Log`
--

CREATE TABLE IF NOT EXISTS `Log` (
  `transport_id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) NOT NULL,
  `supplier` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`transport_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=96 ;

--
-- A tábla adatainak kiíratása `Log`
--

INSERT INTO `Log` (`transport_id`, `order_id`, `supplier`, `date`) VALUES
(89, 5, 'REGIONAL', '2015-06-23'),
(90, 5, 'REGIONAL', '2015-06-23'),
(91, 5, 'REGIONAL', '2015-06-23'),
(92, 5, 'REGIONAL', '2015-06-23'),
(93, 52, 'REGIONAL', '2015-06-23'),
(94, 900, 'REGIONAL', '2015-06-23'),
(95, 906, 'EU', '2015-06-23');
--
-- Adatbázis: `RE_SUPP`
--
CREATE DATABASE IF NOT EXISTS `RE_SUPP` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
USE `RE_SUPP`;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `Accessories`
--

CREATE TABLE IF NOT EXISTS `Accessories` (
  `accessory_id` int(11) NOT NULL AUTO_INCREMENT,
  `part_name` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `quantity` int(11) NOT NULL,
  `comments` text COLLATE utf8_unicode_ci,
  PRIMARY KEY (`accessory_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=9 ;

--
-- A tábla adatainak kiíratása `Accessories`
--

INSERT INTO `Accessories` (`accessory_id`, `part_name`, `quantity`, `comments`) VALUES
(1, 'ac', 37974, 'A/C'),
(2, 'turbo_electric_charger', 100000, 'Turbo electric charger extra for Smart models'),
(3, 'radio', 18122, 'Radio'),
(4, 'sunroof', 100000, 'Sunroof extra'),
(5, 'regenerative_breaks', 98900, 'Regenerative breaks for Smart electric cars'),
(6, 'family_parts', 79441, 'Body parts for Family model'),
(7, 'sport_parts', 90000, 'Body parts for Sport model'),
(8, 'smart_parts', 83400, 'Body parts for Smart model');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `Log`
--

CREATE TABLE IF NOT EXISTS `Log` (
  `log_id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) NOT NULL,
  `part_name` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `quantity` int(11) NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`log_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=93 ;

--
-- A tábla adatainak kiíratása `Log`
--

INSERT INTO `Log` (`log_id`, `order_id`, `part_name`, `quantity`, `date`) VALUES
(86, 5, 'smart_parts', 1100, '2015-06-23'),
(87, 5, 'regenerative_breaks', 1100, '2015-06-23'),
(88, 5, 'smart_parts', 1100, '2015-06-23'),
(89, 5, 'smart_parts', 1100, '2015-06-23'),
(90, 5, 'smart_parts', 1050, '2015-06-23'),
(91, 52, 'smart_parts', 1050, '2015-06-23'),
(92, 900, 'smart_parts', 1200, '2015-06-23');
--
-- Adatbázis: `autoinc_shipping`
--
CREATE DATABASE IF NOT EXISTS `autoinc_shipping` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
USE `autoinc_shipping`;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `shipping_table`
--

CREATE TABLE IF NOT EXISTS `shipping_table` (
  `shipping_id` int(50) NOT NULL AUTO_INCREMENT,
  `order_id` int(50) NOT NULL,
  `model_name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `model_edition` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `model_color` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `quantity` int(50) NOT NULL,
  `customer_name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `customer_address` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `customer_country` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `order_received` date NOT NULL,
  `delivery_date` date NOT NULL,
  `shipping_status` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`shipping_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=59 ;

--
-- A tábla adatainak kiíratása `shipping_table`
--

INSERT INTO `shipping_table` (`shipping_id`, `order_id`, `model_name`, `model_edition`, `model_color`, `quantity`, `customer_name`, `customer_address`, `customer_country`, `order_received`, `delivery_date`, `shipping_status`) VALUES
(31, 106, 'family', 'standard', 'white', 100, 'Estella Maeghan', '123 Fake Street', 'singapore', '2015-06-22', '2015-07-07', 'shipped'),
(33, 120, 'family', 'standard', 'white', 100, 'Estella Maeghan', '123 Fake Street', 'singapore', '2015-06-22', '2015-07-07', 'shipped'),
(46, 36, 'family', 'standard', 'black', 100, 'Estella Maeghan', '123 Yellow Street', 'singapore', '2015-06-23', '2015-07-08', 'shipped'),
(47, 37, 'family', 'standard', 'black', 100, 'Estella Maeghan', '123 Yellow Street', 'singapore', '2015-06-23', '2015-07-08', 'canceled'),
(48, 38, 'family', 'standard', 'black', 100, 'Estella Maeghan', '123 Yellow Street', 'singapore', '2015-06-23', '2015-07-08', 'shipped'),
(49, 39, 'sport', 'standard', 'black', 100, 'Estella Maeghan', '123 Yellow Street', 'singapore', '2015-06-23', '2015-07-08', 'shipped'),
(50, 40, 'family', 'standard', 'black', 100, 'Estella Maeghan', '123 Yellow Street', 'singapore', '2015-06-23', '2015-07-08', 'shipped'),
(52, 43, 'smart', 'standard', 'black', 100, 'Estella Maeghan', '123 Yellow Street', 'singapore', '2015-06-23', '2015-07-08', 'shipped'),
(53, 44, 'smart', 'standard', 'black', 100, 'Estella Maeghan', '123 Yellow Street', 'singapore', '2015-06-23', '2015-07-08', 'shipped'),
(54, 45, 'smart', 'standard', 'black', 100, 'Estella Maeghan', '123 Yellow Street', 'singapore', '2015-06-23', '2015-07-08', 'shipped'),
(55, 46, 'sport', 'standard', 'black', 125, 'Estella Maeghan', '123 Yellow Street', 'singapore', '2015-06-23', '2015-07-08', 'canceled'),
(56, 47, 'family', 'standard', 'black', 100, 'Estella Maeghan', '123 Yellow Street', 'singapore', '2015-06-23', '2015-07-08', 'canceled'),
(57, 49, 'family', 'standard', 'black', 500, 'Estella Maeghan', '123 Yellow Street', 'singapore', '2015-06-23', '2015-07-08', 'shipped'),
(58, 51, 'smart', 'standard', 'black', 100, 'Estella Maeghan', '123 Yellow Street', 'singapore', '2015-06-23', '2015-07-08', 'shipped');
--
-- Adatbázis: `bank`
--
CREATE DATABASE IF NOT EXISTS `bank` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
USE `bank`;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `alpha`
--

CREATE TABLE IF NOT EXISTS `alpha` (
  `account_number` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `customer_name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `credit_limit` int(11) NOT NULL,
  `credit_requested` int(11) NOT NULL,
  PRIMARY KEY (`account_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- A tábla adatainak kiíratása `alpha`
--

INSERT INTO `alpha` (`account_number`, `customer_name`, `credit_limit`, `credit_requested`) VALUES
('238382255383882', 'Estella Maeghan', 750000000, 0),
('376942498684954', 'Lesly Sid', 450000000, 0),
('463543865384563', 'Patrice Fran', 890000000, 0),
('577734687772826', 'Braelyn Dorothea', 650000000, 0),
('988698983556463', 'Janelle Corrine', 450000000, 0);

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `euro`
--

CREATE TABLE IF NOT EXISTS `euro` (
  `account_number` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `customer_name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `credit_limit` int(11) NOT NULL,
  `credit_requested` int(11) NOT NULL,
  PRIMARY KEY (`account_number`),
  UNIQUE KEY `account_number` (`account_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- A tábla adatainak kiíratása `euro`
--

INSERT INTO `euro` (`account_number`, `customer_name`, `credit_limit`, `credit_requested`) VALUES
('243699866655223', 'Kortney Gladwin', 350000000, 0),
('764755492586782', 'Avril London', 650000000, 0),
('822575842452233', 'Cleve Krystal', 750000000, 0),
('855866842585634', 'Mattie Darrel', 650000000, 0),
('896383366478848', 'Josephine Denton', 780000000, 0);

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `piraeus`
--

CREATE TABLE IF NOT EXISTS `piraeus` (
  `account_number` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `customer_name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `credit_limit` int(11) NOT NULL,
  `credit_requested` int(11) NOT NULL,
  PRIMARY KEY (`account_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- A tábla adatainak kiíratása `piraeus`
--

INSERT INTO `piraeus` (`account_number`, `customer_name`, `credit_limit`, `credit_requested`) VALUES
('274549357374228', 'Vicky Philadelphia', 650000000, 0),
('384349825938886', 'Louise Christopher', 550000000, 0),
('424973377583357', 'Freya Penelope', 950000000, 0),
('798569832472954', 'Teagan Shavonne', 750000000, 0),
('825437963789977', 'Rosalin Alton', 850000000, 0);

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `transactions`
--

CREATE TABLE IF NOT EXISTS `transactions` (
  `transaction_id` int(11) NOT NULL AUTO_INCREMENT,
  `account_number` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `customer_name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `bank` enum('alpha','euro','piraeus') COLLATE utf8_unicode_ci NOT NULL,
  `ref` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `amount` int(11) NOT NULL,
  `status` enum('Accepted','Rejected','Initiated','Canceled') COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`transaction_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=238 ;

--
-- A tábla adatainak kiíratása `transactions`
--

INSERT INTO `transactions` (`transaction_id`, `account_number`, `customer_name`, `bank`, `ref`, `amount`, `status`) VALUES
(49, '238382255383882', 'Estella Maeghan', 'alpha', '7', 683333, 'Accepted'),
(180, '238382255383882', 'Estella Maeghan', 'alpha', '7', 6800, 'Canceled'),
(205, '238382255383882', 'Estella Maeghan', 'alpha', '120', 175000, 'Accepted'),
(206, '238382255383882', 'Estella Maeghan', 'alpha', '16', 175000, 'Accepted'),
(207, '238382255383882', 'Estella Maeghan', 'alpha', '0', 1500000, 'Accepted'),
(208, '238382255383882', 'Estella Maeghan', 'alpha', '0', 1500000, 'Accepted'),
(209, '238382255383882', 'Estella Maeghan', 'alpha', '27', 1000000, 'Accepted'),
(210, '238382255383882', 'Estella Maeghan', 'alpha', '28', 1000000, 'Accepted'),
(211, '238382255383882', 'Estella Maeghan', 'alpha', '29', 1500000, 'Accepted'),
(212, '238382255383882', 'Estella Maeghan', 'alpha', '30', 1000000, 'Accepted'),
(213, '238382255383882', 'Estella Maeghan', 'alpha', '31', 1000000, 'Accepted'),
(214, '238382255383882', 'Estella Maeghan', 'alpha', '32', 1000000, 'Accepted'),
(215, '238382255383882', 'Estella Maeghan', 'alpha', '33', 1000000, 'Accepted'),
(216, '238382255383882', 'Estella Maeghan', 'alpha', '34', 1000000, 'Canceled'),
(217, '238382255383882', 'Estella Maeghan', 'alpha', '35', 2500000, 'Canceled'),
(218, '238382255383882', 'Estella Maeghan', 'alpha', '36', 1000000, 'Canceled'),
(219, '238382255383882', 'Estella Maeghan', 'alpha', '37', 1000000, 'Canceled'),
(220, '238382255383882', 'Estella Maeghan', 'alpha', '38', 1000000, 'Accepted'),
(221, '238382255383882', 'Estella Maeghan', 'alpha', '39', 2500000, 'Accepted'),
(222, '238382255383882', 'Estella Maeghan', 'alpha', '40', 1000000, 'Accepted'),
(223, '238382255383882', 'Estella Maeghan', 'alpha', '41', 1500000, 'Accepted'),
(224, '238382255383882', 'Estella Maeghan', 'alpha', '42', 1500000, 'Accepted'),
(225, '238382255383882', 'Estella Maeghan', 'alpha', '100', 175000, 'Accepted'),
(226, '238382255383882', 'Estella Maeghan', 'alpha', '100', 175000, 'Accepted'),
(227, '238382255383882', 'Estella Maeghan', 'alpha', '100', 175000, 'Accepted'),
(228, '238382255383882', 'Estella Maeghan', 'alpha', '43', 1500000, 'Accepted'),
(229, '238382255383882', 'Estella Maeghan', 'alpha', '44', 1500000, 'Accepted'),
(230, '238382255383882', 'Estella Maeghan', 'alpha', '45', 1500000, 'Accepted'),
(231, '238382255383882', 'Estella Maeghan', 'alpha', '46', 3125000, 'Canceled'),
(232, '238382255383882', 'Estella Maeghan', 'alpha', '47', 1000000, 'Canceled'),
(233, '238382255383882', 'Estella Maeghan', 'alpha', '48', 3000000, 'Accepted'),
(234, '238382255383882', 'Estella Maeghan', 'alpha', '49', 5000000, 'Accepted'),
(235, '238382255383882', 'Estella Maeghan', 'alpha', '50', 5000000, 'Accepted'),
(236, '238382255383882', 'Estella Maeghan', 'alpha', '51', 1500000, 'Accepted'),
(237, '238382255383882', 'Estella Maeghan', 'alpha', '52', 3000000, 'Accepted');
--
-- Adatbázis: `phpmyadmin`
--
CREATE DATABASE IF NOT EXISTS `phpmyadmin` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `phpmyadmin`;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `pma_bookmark`
--

CREATE TABLE IF NOT EXISTS `pma_bookmark` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dbase` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '',
  `user` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '',
  `label` varchar(255) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `query` text COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Bookmarks' AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `pma_column_info`
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
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Column information for phpMyAdmin' AUTO_INCREMENT=6 ;

--
-- A tábla adatainak kiíratása `pma_column_info`
--

INSERT INTO `pma_column_info` (`id`, `db_name`, `table_name`, `column_name`, `comment`, `mimetype`, `transformation`, `transformation_options`) VALUES
(1, 'LOGISTICS', 'Log', 'date', '', '', '_', ''),
(2, 'EU_SUPP', 'Log', 'date', '', '', '_', ''),
(3, 'RE_SUPP', 'Log', 'date', '', '', '_', ''),
(4, 'RE_SUPP', 'Accessories', 'part_name', '', '', '_', ''),
(5, 'bank', 'transactions', 'status', '', '', '_', '');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `pma_designer_coords`
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
-- Tábla szerkezet ehhez a táblához `pma_history`
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
-- Tábla szerkezet ehhez a táblához `pma_pdf_pages`
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
-- Tábla szerkezet ehhez a táblához `pma_recent`
--

CREATE TABLE IF NOT EXISTS `pma_recent` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `tables` text COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Recently accessed tables';

--
-- A tábla adatainak kiíratása `pma_recent`
--

INSERT INTO `pma_recent` (`username`, `tables`) VALUES
('autoinc', '[{"db":"EU_SUPP","table":"Chassis"},{"db":"EU_SUPP","table":"Log"},{"db":"RE_SUPP","table":"Accessories"},{"db":"RE_SUPP","table":"Log"},{"db":"autoinc_shipping","table":"shipping_table"},{"db":"bank","table":"transactions"},{"db":"LOGISTICS","table":"Log"},{"db":"bank","table":"alpha"},{"db":"bank","table":"piraeus"},{"db":"bank","table":"euro"}]');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `pma_relation`
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
-- Tábla szerkezet ehhez a táblához `pma_table_coords`
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
-- Tábla szerkezet ehhez a táblához `pma_table_info`
--

CREATE TABLE IF NOT EXISTS `pma_table_info` (
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `display_field` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  PRIMARY KEY (`db_name`,`table_name`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Table information for phpMyAdmin';

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `pma_table_uiprefs`
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
-- A tábla adatainak kiíratása `pma_table_uiprefs`
--

INSERT INTO `pma_table_uiprefs` (`username`, `db_name`, `table_name`, `prefs`, `last_update`) VALUES
('autoinc', 'bank', 'transactions', '{"sorted_col":"`transactions`.`transaction_id` DESC"}', '2015-06-23 00:07:02');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `pma_tracking`
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
-- Tábla szerkezet ehhez a táblához `pma_userconfig`
--

CREATE TABLE IF NOT EXISTS `pma_userconfig` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `timevalue` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `config_data` text COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='User preferences storage for phpMyAdmin';

--
-- A tábla adatainak kiíratása `pma_userconfig`
--

INSERT INTO `pma_userconfig` (`username`, `timevalue`, `config_data`) VALUES
('root', '2015-06-04 08:38:54', '{"lang":"hu"}'),
('autoinc', '2015-06-23 08:41:57', '{"LoginCookieValidity":6000,"Server\\/hide_db":"","Export\\/file_template_server":"@SERVER@%c","lang":"hu"}');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
