-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 29 Jul 2021 pada 14.05
-- Versi server: 10.4.14-MariaDB
-- Versi PHP: 7.4.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `kopi_bae`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `detail_pesanan`
--

CREATE TABLE `detail_pesanan` (
  `id_order` varchar(20) NOT NULL,
  `id_kopi` varchar(20) NOT NULL,
  `jumlah` varchar(50) NOT NULL,
  `nama_cust` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `detail_pesanan`
--

INSERT INTO `detail_pesanan` (`id_order`, `id_kopi`, `jumlah`, `nama_cust`) VALUES
('ORD-5241', 'KP003', '1', 'asep'),
('ORD-5241', 'KP004', '2', 'asep'),
('ORD-4633', 'KP003', '1', 'Asep'),
('ORD-4633', 'KP008', '2', 'Asep'),
('ORD-5309', 'KP001', '1', 'test'),
('ORD-5309', 'KP002', '1', 'test'),
('ORD-5309', 'KP003', '2', 'test'),
('ORD-3759', 'KP009', '4', 'Clara'),
('ORD-3759', 'KP004', '2', 'Clara'),
('ORD-5719', 'KP005', '3', 'ijah'),
('ORD-5719', 'KP006', '1', 'ijah');

-- --------------------------------------------------------

--
-- Struktur dari tabel `kopi`
--

CREATE TABLE `kopi` (
  `id_kopi` varchar(20) NOT NULL,
  `nama_kopi` varchar(20) DEFAULT NULL,
  `harga` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `kopi`
--

INSERT INTO `kopi` (`id_kopi`, `nama_kopi`, `harga`) VALUES
('KP001', 'Americano', '40000'),
('KP002', 'Brown Sugar', '25000'),
('KP003', 'Hot Cappucciono', '40000'),
('KP004', 'Caramel Macchiato', '65000'),
('KP005', 'Dalgona Coffee', '30000'),
('KP006', 'Kopi Pandan', '28000'),
('KP007', 'Coffee Latte', '25000'),
('KP008', 'Expresso', '25000'),
('KP009', 'V 60', '35000'),
('KP010', 'Vietnam Drip', '27000');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pemesanan`
--

CREATE TABLE `pemesanan` (
  `id_order` varchar(20) NOT NULL,
  `tanggal` date NOT NULL,
  `jumlah` varchar(20) NOT NULL,
  `nm_customer` varchar(20) DEFAULT NULL,
  `id_user` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `pemesanan`
--

INSERT INTO `pemesanan` (`id_order`, `tanggal`, `jumlah`, `nm_customer`, `id_user`) VALUES
('ORD-3759', '2021-07-28', '4', 'Clara', 'ADM-001'),
('ORD-4633', '2021-07-28', '1', 'Asep', 'ADM-001'),
('ORD-5241', '2021-07-27', '1', 'asep', 'ADM-001'),
('ORD-5309', '2021-07-28', '1', 'test', 'ADM-001'),
('ORD-5719', '2021-07-28', '3', 'ijah', 'ADM-001');

-- --------------------------------------------------------

--
-- Struktur dari tabel `transaksi`
--

CREATE TABLE `transaksi` (
  `id_transaksi` int(11) NOT NULL,
  `id_user` varchar(10) DEFAULT NULL,
  `id_order` varchar(10) DEFAULT NULL,
  `nama_cust` varchar(20) NOT NULL,
  `tanggal` date DEFAULT NULL,
  `total_bayar` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `transaksi`
--

INSERT INTO `transaksi` (`id_transaksi`, `id_user`, `id_order`, `nama_cust`, `tanggal`, `total_bayar`) VALUES
(1, 'ADM-001', 'ORD-4633', 'Asep', '2021-07-28', '90000'),
(2, 'ADM-001', 'ORD-5241', 'asep', '2021-07-28', '170000'),
(3, 'ADM-001', 'KP009', 'Clara', '2021-07-28', '270000'),
(4, 'ADM-001', 'KP005', 'ijah', '2021-07-28', '118000');

-- --------------------------------------------------------

--
-- Struktur dari tabel `user`
--

CREATE TABLE `user` (
  `id_user` varchar(10) NOT NULL,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(15) DEFAULT NULL,
  `posisi` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `user`
--

INSERT INTO `user` (`id_user`, `username`, `password`, `posisi`) VALUES
('ADM-001', 'ekawijaya', 'eka', 'Admin'),
('OWN-001', 'tinasinaga', 'tina', 'Owner');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `detail_pesanan`
--
ALTER TABLE `detail_pesanan`
  ADD KEY `id_order` (`id_order`),
  ADD KEY `id_kopi` (`id_kopi`);

--
-- Indeks untuk tabel `kopi`
--
ALTER TABLE `kopi`
  ADD PRIMARY KEY (`id_kopi`);

--
-- Indeks untuk tabel `pemesanan`
--
ALTER TABLE `pemesanan`
  ADD PRIMARY KEY (`id_order`),
  ADD KEY `id_user` (`id_user`);

--
-- Indeks untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`id_transaksi`),
  ADD KEY `id_user` (`id_user`),
  ADD KEY `id_order` (`id_order`);

--
-- Indeks untuk tabel `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  MODIFY `id_transaksi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `detail_pesanan`
--
ALTER TABLE `detail_pesanan`
  ADD CONSTRAINT `detail_pesanan_ibfk_1` FOREIGN KEY (`id_order`) REFERENCES `pemesanan` (`id_order`),
  ADD CONSTRAINT `detail_pesanan_ibfk_2` FOREIGN KEY (`id_kopi`) REFERENCES `kopi` (`id_kopi`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
