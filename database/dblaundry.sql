-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.4.25-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             12.1.0.6537
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for dblaundry
CREATE DATABASE IF NOT EXISTS `dblaundry` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `dblaundry`;

-- Dumping structure for table dblaundry.tblcucian
CREATE TABLE IF NOT EXISTS `tblcucian` (
  `idjenis` int(11) NOT NULL,
  `jeniscucian` varchar(50) NOT NULL,
  `harga` int(11) NOT NULL,
  PRIMARY KEY (`idjenis`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table dblaundry.tblcucian: ~4 rows (approximately)
INSERT INTO `tblcucian` (`idjenis`, `jeniscucian`, `harga`) VALUES
	(1, 'Cuci Kering', 10000),
	(2, 'Cuci Basah', 5000),
	(3, 'Cuci Basah + Setrika', 15000),
	(4, 'Cuci Uap + Setrika', 20000),
	(5, 'Cuci Kerba', 19000);

-- Dumping structure for table dblaundry.tblpelanggan
CREATE TABLE IF NOT EXISTS `tblpelanggan` (
  `idpelanggan` int(11) NOT NULL,
  `namapelanggan` varchar(32) NOT NULL,
  `notelp` varchar(15) NOT NULL,
  `alamat` varchar(100) NOT NULL,
  PRIMARY KEY (`idpelanggan`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table dblaundry.tblpelanggan: ~4 rows (approximately)
INSERT INTO `tblpelanggan` (`idpelanggan`, `namapelanggan`, `notelp`, `alamat`) VALUES
	(1, 'Najwa', '088765764764', 'mana weh'),
	(3, 'Oca', '087873627868', 'dimana'),
	(4, 'Nazila', '085765265828', 'y'),
	(5, 'Hugo', '08566672974', 'ahbchsb');

-- Dumping structure for table dblaundry.tbltransaksi
CREATE TABLE IF NOT EXISTS `tbltransaksi` (
  `idtransaksi` int(11) NOT NULL,
  `tglorder` date NOT NULL,
  `tglselesai` date NOT NULL,
  `berat` int(3) NOT NULL,
  `totalharga` int(11) NOT NULL,
  `bayar` int(11) NOT NULL,
  `kembalian` int(11) NOT NULL,
  `idjeniscuci` int(11) NOT NULL,
  `idpel` int(11) NOT NULL,
  `uname` varchar(24) NOT NULL,
  PRIMARY KEY (`idtransaksi`),
  KEY `idpel` (`idpel`),
  KEY `username` (`uname`),
  KEY `idjeniscuci` (`idjeniscuci`),
  CONSTRAINT `tbltransaksi_ibfk_1` FOREIGN KEY (`idpel`) REFERENCES `tblpelanggan` (`idpelanggan`),
  CONSTRAINT `tbltransaksi_ibfk_2` FOREIGN KEY (`uname`) REFERENCES `tbluser` (`username`),
  CONSTRAINT `tbltransaksi_ibfk_3` FOREIGN KEY (`idjeniscuci`) REFERENCES `tblcucian` (`idjenis`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table dblaundry.tbltransaksi: ~7 rows (approximately)
INSERT INTO `tbltransaksi` (`idtransaksi`, `tglorder`, `tglselesai`, `berat`, `totalharga`, `bayar`, `kembalian`, `idjeniscuci`, `idpel`, `uname`) VALUES
	(1, '2021-04-15', '2020-05-06', 4, 8500, 40000, 6000, 1, 1, 'user'),
	(2, '2022-05-15', '2020-05-23', 5, 7000, 40000, 5000, 2, 3, 'user'),
	(3, '2022-05-15', '2020-05-19', 2, 8500, 20000, 3000, 1, 1, 'user'),
	(4, '2022-06-13', '2020-06-15', 2, 7000, 20000, 6000, 2, 3, 'user'),
	(5, '2022-06-13', '2020-06-16', 3, 10000, 40000, 10000, 3, 4, 'user'),
	(6, '2022-07-29', '2020-07-31', 3, 10000, 50000, 20000, 3, 3, 'user'),
	(7, '2022-07-29', '2020-07-31', 5, 7000, 50000, 15000, 2, 4, 'user');

-- Dumping structure for table dblaundry.tbluser
CREATE TABLE IF NOT EXISTS `tbluser` (
  `username` varchar(24) NOT NULL,
  `password` varchar(24) NOT NULL,
  `akses` varchar(10) NOT NULL,
  `nama` varchar(32) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table dblaundry.tbluser: ~11 rows (approximately)
INSERT INTO `tbluser` (`username`, `password`, `akses`, `nama`) VALUES
	('admin', 'admin', 'ADMIN', 'Min'),
	('dewi', 'dewi', 'USER', 'Dewi'),
	('hugo', 'hugo', 'ADMIN', 'hugo'),
	('qq', 'qq', 'null', 'qq'),
	('user', 'user', 'USER', 'Ser'),
	('wawa', ' wawa', 'null', 'wawa'),
	('wewe', 'wewe', 'null', 'wewe'),
	('wkwk', 'wkwk', 'null', 'wkwk'),
	('wow', 'wow', 'null', 'wow'),
	('wowo', 'wowo', 'null', 'wowo'),
	('wuwu', 'wuwu', 'null', 'wuwu'),
	('ww', 'ww', 'null', 'ww');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
tblcucian