-- phpMyAdmin SQL Dump
-- version 4.1.6
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jan 09, 2018 at 11:50 PM
-- Server version: 5.5.36
-- PHP Version: 5.4.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `tokobukudb`
--

-- --------------------------------------------------------

--
-- Table structure for table `bukutbl`
--

CREATE TABLE IF NOT EXISTS `bukutbl` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `kode_buku` varchar(10) NOT NULL,
  `judul_buku` varchar(100) NOT NULL,
  `pengarang` varchar(35) NOT NULL,
  `harga` int(11) NOT NULL,
  `deskripsi` text NOT NULL,
  `rating` int(11) NOT NULL,
  `kode_kategori` varchar(10) NOT NULL,
  `cover` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=14 ;

--
-- Dumping data for table `bukutbl`
--

INSERT INTO `bukutbl` (`id`, `kode_buku`, `judul_buku`, `pengarang`, `harga`, `deskripsi`, `rating`, `kode_kategori`, `cover`) VALUES
(1, 'B-1', 'Pemrograman Database Dengan Visual Basic 2010', 'Tri Joko Prabowo', 45000, 'Buku ini mengajarkan bagaimana cara sederhana membangun program database menggunakan database MySQL, dan bahasa pemrograman Visual Basic 2010. Buku ini dirancang secara sistematis dan bertahap, untuk bab pertama Anda akan diajarkan cara menginstall web server Xampp, dan pengaturan lainnya.', 5, 'K-2', 'B-1.jpg'),
(2, 'B-2', 'Toko Baju Online Dengan PHP & MySQL', 'Tri Yuningsih', 47500, 'Sebelumnya penulis telah membuat buku yang membahas bagaimana cara membuat toko online dengan php dan mysql. Dan dikesempatan yang kedua ini penulis kembali membahas toko online tapi kali ini lebih fokus ke toko baju, yang akan mengajarkan Anda cara membuat toko baju online dengan php dan mysql serta bantuan software Adobe Dreamweaver CS 6 dengan mudah', 5, 'K-2', 'B-2.jpg'),
(3, 'B-3', '20 Manipulasi Foto edisi Foto Pribadi Photoshop CS6', 'Ahmad Muhajir', 48500, '20 Manipulasi Foto edisi Foto Pribadi Photoshop CS6 merupakan edisi ke-2 yang menyajikan 20 manipulasi baru yang dibagi menjadi 4 Bab yaitu Stunt Master, City Star, It''s Me Again dan Animasi.', 5, 'K-1', 'B-3.jpg'),
(4, 'B-4', '7 Jam Belajar Interaktif Word 2013 untuk Orang Awa', 'Dian Kurniawan', 52500, 'Word 2013 adalah program pengolah kata canggih versi terbaru yang membantu Anda membuat dokumen pribadi maupun dokumen bisnis dengan cepat dan efisien. Dilengkapi dengan fitur - fitur baru seperti mengedit dokumen pdf, membuat bookmark otomatis, reply comment dan fitur baru lainnya.\r\n', 4, 'K-3', 'B-4.jpg'),
(5, 'B-5', '88 Trik Tersembunyi Windows 8', 'Putri Purnama', 53500, 'Windows 8 adalah sistem operasi terbaru dari Microsoft saat ini. Sistem operasi ini dirilis dengan banyak perubahan dari generasi pendahulunya, Windows 7. Sebagai sistem operasi terbaru, windows 8 tentu saja telah disertai perbaikan dan penyempurnaan beberapa kekurangan dari versi sebelumnya.', 5, 'K-4', 'B-5.jpg'),
(6, 'B-6', 'Jaringan Komputer untuk Orang Awam Edisi Ke-2', 'Tri Joko Prabowo', 53500, 'Kata-kata "Komputer" bukan hal yang asing lagi di telinga kita. Komputer ada di mana-mana, di kantor, kampus, rumah sakit semuanya menggunakan komputer. Tanpa Anda sadari, saat ini komputer sudah menjadi kebutuhan utama dan menjadi bagian dari kehidupan sehari-hari Anda. Seiring perkembangan zaman, komputer yang tadinya berdiri sendiri, kini bisa saling berhubungan dan bekerja bersamaan. Metode ini disebut sebagai jaringan, atau dikenal dengan istilah "jaringan komputer".', 0, 'K-5', 'B-6.jpg'),
(7, 'B-7', 'Photoshop CS6 untuk Fotografi Digital', 'Putri Purnama', 49500, 'Perkembangan teknologi kamera saat ini sudah semakin pesat, tidak hanya untuk kamera saku atau profesional, ponsel pun sudah dilengkapi kamera yang sangat mumpuni untuk menghasilkan gambar tajam dengan resolusi yang besar, belum lagi ditambah fitur editing dan aplikasi pendukung lainnya membuat kita semakin mudah untuk menjadi seorang fotografer atau editor foto.', 4, 'K-1', 'B-7.jpg'),
(8, 'B-8', 'Pemrograman Database dengan Java', 'Ahmad Muhajir', 53500, 'Java merupakan bahasa pemrograman yang "portabel", sekali compile bisa jalan di mana saja. Hal ini membuat java menjadi bahasa favorit untuk pengembangan software yang dijalankan pada perangkat portabel seperti smartphone.', 5, 'K-2', 'B-8.jpg'),
(9, 'B-9', '7 Jam Belajar Interaktif Excel 2013 untuk Orang Aw', 'Tri Yuningsih', 49500, 'Microsoft telah merilis versi terbaru program Spreadsheet yang sangat populer dan paling banyak digunakan yaitu Microsoft Excel 2013. Excel 2013 hadir dengan beragam fitur baru yang canggih untuk membuat pekerjaan menjadi lebih cepat, lebih mudah dengan hasil yang profesional. Seperti fitur Flash Fill, Quick Analysis Tool, media penyimpanan SkyDrive, fungsi-fungsi baru dan banyak lagi fitur baru lainnya.', 0, 'K-3', 'B-9.jpg'),
(10, 'B-10', 'Windows 8 untuk Orang Awam', 'Tri Joko Prabowo', 48500, 'Windows 8 adalah sistem operasi terbaru dari Microsoft saat ini. Sistem operasi ini dirilis dengan banyak perubahan dari generasi pendahulunya, yang tentu saja disertai perbaikan dan penyempurnaan beberapa kekurangan dari versi sebelumnya.', 4, 'K-4', 'B-10.jpg'),
(11, 'B-11', 'Membuat Aplikasi Android untuk Orang Awam', 'Tri Yuningsih', 52500, 'Android adalah sistem operasi untuk perangkat mobile yang bersifat "open source". Kemudahan mendapatkan aplikasi, serta dukungan komunitas di dunia maya membuat perangkat android menjadi pilihan banyak penggila smartphone.', 4, 'K-2', 'B-11.jpg'),
(12, 'B-12', 'Jaringan Komputer untuk Orang Awam', 'Dian Kurniawan', 39500, 'Saat ini siapa yang tidak kenal komputer ?, hampir semua orang mengenalnya, meskipun ada sebagian yang hanya sebatas mengenal dan belum sempat untuk memanfaatkannya. Diluar itu semua, bagi kalangan akademisi, mahasiswa, pelajar, karyawan dan lain-lain, komputer sudah menjadi kebutuhan untuk menunjang efektifitas dan efesiensi kerja sehari-hari. Tetapi jika ditanyakan bagaimana membuat komputer-komputer itu dapat saling berhubungan membentuk sebuah jaringan?, tidak semua para pengguna komputer dapat melakukannya dengan alasan klasik SULIT, walaupun tidak sedikit bahan bacaan yang mengulas masalah ini. Namun referensi tentang jaringan banyak bersifat teoritis sehingga para pembaca hanya tahu tentang peralatan jaringan tanpa tahu bagaimana menggunakannya. Hal ini yang membuat para pengguna komputer merasa sulit untuk mempelajari dan membangun sebuah jaringan.', 3, 'K-5', 'B-12.jpg'),
(13, 'B-13', 'Membuat Aplikasi Android untuk Orang Awam', 'Tri Joko Prabowo', 53, 'Android adalah sistem operasi untuk perangkat mobile yang bersifat "open source". Kemudahan mendapatkan aplikasi, serta dukungan komunitas di dunia maya membuat perangkat android menjadi pilihan banyak penggila smartphone.', 0, 'K-0', 'B-11.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `kategoritbl`
--

CREATE TABLE IF NOT EXISTS `kategoritbl` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `kode_kategori` varchar(10) NOT NULL,
  `nama_kategori` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `kategoritbl`
--

INSERT INTO `kategoritbl` (`id`, `kode_kategori`, `nama_kategori`) VALUES
(1, 'K-1', 'Design Grafis'),
(2, 'K-2', 'Pemrograman'),
(3, 'K-3', 'Office'),
(4, 'K-4', 'Sistem Operasi (OS)'),
(5, 'K-5', 'Jaringan');

-- --------------------------------------------------------

--
-- Table structure for table `pelanggantbl`
--

CREATE TABLE IF NOT EXISTS `pelanggantbl` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nama` varchar(50) NOT NULL,
  `alamat` text NOT NULL,
  `email` varchar(100) NOT NULL,
  `telepon` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `pelanggantbl`
--

INSERT INTO `pelanggantbl` (`id`, `nama`, `alamat`, `email`, `telepon`) VALUES
(3, 'bowo', 'jl.ganggang', 'bowo@gmail.com', '9764678'),
(4, 'ahmad', 'jl.sukamerindu', 'ahmad@gmail.com', '77399399'),
(5, 'putri', 'jl.panjang', 'putri@gmail.com', '875927582'),
(6, 'fajar', 'pringsewu', 'fajar@gmail.com', '7638884');

-- --------------------------------------------------------

--
-- Table structure for table `saran_kritiktbl`
--

CREATE TABLE IF NOT EXISTS `saran_kritiktbl` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nama` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `tanggal` date NOT NULL,
  `pesan` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `saran_kritiktbl`
--

INSERT INTO `saran_kritiktbl` (`id`, `nama`, `email`, `tanggal`, `pesan`) VALUES
(2, 'bowo', 'bowo@gmail.com', '2018-01-07', 'mantap gan . lanjutkan'),
(3, 'ahmad', 'ahmad@gmail.com', '2018-01-07', 'Joss gan'),
(4, 'yuni', 'yuni@gmail.com', '2018-01-07', 'lanjutkan gan'),
(5, 'ery', 'ery@gmail.com', '2018-01-08', 'mantap gan');

-- --------------------------------------------------------

--
-- Table structure for table `transaksi_jualtbl`
--

CREATE TABLE IF NOT EXISTS `transaksi_jualtbl` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(100) NOT NULL,
  `tanggal` date NOT NULL,
  `total` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=13 ;

--
-- Dumping data for table `transaksi_jualtbl`
--

INSERT INTO `transaksi_jualtbl` (`id`, `email`, `tanggal`, `total`, `status`) VALUES
(3, 'bowo@gmail.com', '2018-01-07', 150500, 0),
(4, 'ahmad@gmail.com', '2018-01-07', 96000, 0),
(5, 'bowo@gmail.com', '2018-01-07', 52500, 0),
(6, 'putri@gmail.com', '2018-01-07', 151000, 0),
(7, 'putri@gmail.com', '2018-01-07', 148500, 0),
(9, 'bowo@gmail.com', '2018-01-07', 53500, 0),
(10, 'bowo@gmail.com', '2018-01-07', 45000, 0),
(11, 'fajar@gmail.com', '2018-01-08', 103000, 0),
(12, 'putri@gmail.com', '2018-01-08', 53500, 0);

-- --------------------------------------------------------

--
-- Table structure for table `transaksi_jual_rincitbl`
--

CREATE TABLE IF NOT EXISTS `transaksi_jual_rincitbl` (
  `id` int(15) NOT NULL,
  `kode_buku` varchar(15) NOT NULL,
  `harga` int(11) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `sub_total` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transaksi_jual_rincitbl`
--

INSERT INTO `transaksi_jual_rincitbl` (`id`, `kode_buku`, `harga`, `jumlah`, `sub_total`) VALUES
(1, 'B-4', 52500, 1, 52500),
(1, 'B-2', 47500, 1, 47500),
(1, 'B-5', 53500, 1, 53500),
(2, 'B-3', 48500, 1, 48500),
(2, 'B-3', 48500, 1, 48500),
(2, 'B-7', 49500, 1, 49500),
(3, 'B-3', 48500, 1, 48500),
(3, 'B-7', 49500, 1, 49500),
(3, 'B-4', 52500, 1, 52500),
(4, 'B-3', 48500, 1, 48500),
(4, 'B-2', 47500, 1, 47500),
(5, 'B-11', 52500, 1, 52500),
(6, 'B-8', 53500, 1, 53500),
(6, 'B-1', 45000, 1, 45000),
(6, 'B-11', 52500, 1, 52500),
(7, 'B-7', 49500, 1, 49500),
(7, 'B-7', 49500, 1, 49500),
(7, 'B-7', 49500, 1, 49500),
(8, 'B-7', 49500, 1, 49500),
(9, 'B-5', 53500, 1, 53500),
(10, 'B-1', 45000, 1, 45000),
(11, 'B-9', 49500, 1, 49500),
(11, 'B-5', 53500, 1, 53500),
(12, 'B-8', 53500, 1, 53500);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
