-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Waktu pembuatan: 09 Mar 2022 pada 16.17
-- Versi server: 10.4.20-MariaDB
-- Versi PHP: 7.3.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `onfashion`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `categories`
--

CREATE TABLE `categories` (
  `category_id` bigint(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `categories`
--

INSERT INTO `categories` (`category_id`, `description`, `name`) VALUES
(1, 'Pakaian Laki - laki', 'Men Outfit'),
(2, 'Pakaian Perempuan', 'Women Outfit'),
(6, 'Aksesoris', 'Accessory'),
(7, 'Kategori Sepatu', 'Sepatu');

-- --------------------------------------------------------

--
-- Struktur dari tabel `products`
--

CREATE TABLE `products` (
  `product_id` bigint(20) NOT NULL,
  `code` varchar(20) NOT NULL,
  `description` varchar(500) NOT NULL,
  `name` varchar(150) NOT NULL,
  `photo` varchar(255) NOT NULL,
  `price` double NOT NULL,
  `stock` int(11) NOT NULL,
  `category_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `products`
--

INSERT INTO `products` (`product_id`, `code`, `description`, `name`, `photo`, `price`, `stock`, `category_id`) VALUES
(1, 'P0001', 'Solids: 100% Cotton; Heathers: 60% Cotton, 40% Polyester Imported\r\nTwo-pack of classic regular-fit tees featuring all-cotton construction, a crew neckline and short-sleeves for comfort. Everyday made better: we listen to customer feedback and fine-tune every detail to ensure quality, fit, and comfort. Model is 6\'1\" and wearing size Medium', 'Classic Sweater', 'XT1WlST3mA_product1.jpg', 30, 8, 1),
(2, 'P0002', 'Solids: 100% Cotton; Heathers: 60% Cotton, 40% Polyester Imported\r\nTwo-pack of classic regular-fit tees featuring all-cotton construction, a crew neckline and short-sleeves for comfort. Everyday made better: we listen to customer feedback and fine-tune every detail to ensure quality, fit, and comfort. Model is 6\'1\" and wearing size Medium', 'Parka Jacket', '9FdO905VoE_product2.jpg', 50, 10, 1),
(3, 'P0003', 'Solids: 100% Cotton; Heathers: 60% Cotton, 40% Polyester Imported\r\nTwo-pack of classic regular-fit tees featuring all-cotton construction, a crew neckline and short-sleeves for comfort. Everyday made better: we listen to customer feedback and fine-tune every detail to ensure quality, fit, and comfort. Model is 6\'1\" and wearing size Medium', 'Basic Hoodie', '4dynbiv8E8_product3.jpg', 20, 10, 1),
(4, 'P0004', 'Solids: 100% Cotton; Heathers: 60% Cotton, 40% Polyester Imported\r\nTwo-pack of classic regular-fit tees featuring all-cotton construction, a crew neckline and short-sleeves for comfort. Everyday made better: we listen to customer feedback and fine-tune every detail to ensure quality, fit, and comfort. Model is 6\'1\" and wearing size Medium', 'Classic Pea Coat', 'fcbADcPu4i_product4.jpg', 36, 10, 1),
(5, 'P0005', 'Material: The V Neck T Shirts is of 35% Rayon,60% Polyester,5% Spandex. It\'s Soft with Stretchy,Breathable Fabric,it\'s Comfy against the Skin. Features: Casual V Neck T Shirts with Pocket, Solid Color Short Sleeve Tops, Plain Basic Tees, Loose Fit. It\'s Suitable to Pair this Casual tops under a Jacket or Coat in Spring, Fall or Winter. Perfect for all seasons. Match: The Simple Tshirt is Perfect with Jeans, Shorts, Leggings, Pants or Skirt for a Concise Look. A Must-Have Womens Tops in Your ', 'Basic Sweater', '05bHbxifwf_product5.jpg', 16, 10, 2),
(6, 'P0006', 'Material: The V Neck T Shirts is of 35% Rayon,60% Polyester,5% Spandex. It\'s Soft with Stretchy,Breathable Fabric,it\'s Comfy against the Skin. Features: Casual V Neck T Shirts with Pocket, Solid Color Short Sleeve Tops, Plain Basic Tees, Loose Fit. It\'s Suitable to Pair this Casual tops under a Jacket or Coat in Spring, Fall or Winter. Perfect for all seasons. Match: The Simple Tshirt is Perfect with Jeans, Shorts, Leggings, Pants or Skirt for a Concise Look. A Must-Have Womens Tops in Your ', 'Gathered Sweatshirt', 'uxRcsIBMBD_product6.jpg', 40, 10, 2),
(7, 'P0007', 'Material: The V Neck T Shirts is of 35% Rayon,60% Polyester,5% Spandex. It\'s Soft with Stretchy,Breathable Fabric,it\'s Comfy against the Skin. Features: Casual V Neck T Shirts with Pocket, Solid Color Short Sleeve Tops, Plain Basic Tees, Loose Fit. It\'s Suitable to Pair this Casual tops under a Jacket or Coat in Spring, Fall or Winter. Perfect for all seasons. Match: The Simple Tshirt is Perfect with Jeans, Shorts, Leggings, Pants or Skirt for a Concise Look. A Must-Have Womens Tops in Your ', 'Cropped Sweatshirt', 'ER4rzGz8gs_product7.jpg', 32, 10, 2),
(8, 'P0008', 'Material: The V Neck T Shirts is of 35% Rayon,60% Polyester,5% Spandex. It\'s Soft with Stretchy,Breathable Fabric,it\'s Comfy against the Skin. Features: Casual V Neck T Shirts with Pocket, Solid Color Short Sleeve Tops, Plain Basic Tees, Loose Fit. It\'s Suitable to Pair this Casual tops under a Jacket or Coat in Spring, Fall or Winter. Perfect for all seasons. Match: The Simple Tshirt is Perfect with Jeans, Shorts, Leggings, Pants or Skirt for a Concise Look. A Must-Have Womens Tops in Your ', 'Embroidered Sweatshirt', 'ZCy7fOKyTQ_product8.jpg', 33, 10, 2),
(9, 'P0009', 'This Dreubea casual tote bag is a basic item but also a fashionable one. It is big enough to hold wallet, Ipad, books, keys, cosmetics and change. Goes well with any clothes in any occasion like traveling, work, school, shopping and so on. It also can be a overnight bag. Great gift idea! Get it right now.', 'Basic City Bag', '0HXltQgaZX_product9.jpg', 29, 10, 6),
(10, 'P0010', 'This Dreubea casual tote bag is a basic item but also a fashionable one. It is big enough to hold wallet, Ipad, books, keys, cosmetics and change. Goes well with any clothes in any occasion like traveling, work, school, shopping and so on. It also can be a overnight bag. Great gift idea! Get it right now.', 'Leather City Bag', 'ZHGxPdo5Io_product10.jpg', 50, 10, 6),
(11, 'P0011', 'SEAMLESS INTEGRATED WEAVING & HOT-MELT PROCESS: High-quality integrated weaving combined with hot-melt process to fully reduce the discomfort of the foot and provide comfortable wrapping and support. The outsole of the Streetball Master is thick and solid, with a deep traction pattern that will wear nicely outdoors.', 'Basketball Sneakers', 'OHCG3cpbQE_product11.jpg', 34, 10, 6),
(12, 'P0012', 'SEAMLESS INTEGRATED WEAVING & HOT-MELT PROCESS: High-quality integrated weaving combined with hot-melt process to fully reduce the discomfort of the foot and provide comfortable wrapping and support. The outsole of the Streetball Master is thick and solid, with a deep traction pattern that will wear nicely outdoors.', 'Nike Sock Dart', '5G8qLt8e9X_product12.jpg', 56, 10, 6);

-- --------------------------------------------------------

--
-- Struktur dari tabel `transactions`
--

CREATE TABLE `transactions` (
  `transaction_id` bigint(20) NOT NULL,
  `address` varchar(255) NOT NULL,
  `code` varchar(100) NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `customer_name` varchar(50) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `email` varchar(100) NOT NULL,
  `phone_number` varchar(20) NOT NULL,
  `quantity` int(11) NOT NULL,
  `status` varchar(20) NOT NULL DEFAULT 'Not Yet Sent',
  `total_price` double NOT NULL,
  `product_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `transactions`
--

INSERT INTO `transactions` (`transaction_id`, `address`, `code`, `created_at`, `customer_name`, `description`, `email`, `phone_number`, `quantity`, `status`, `total_price`, `product_id`) VALUES
(1, 'Jl. Diponegoro No.39 Pesanggaran', 'OutIbuLwI4fGBn0urEzv_09032022', '2022-03-09 21:55:11.666000', 'Made Adi Adnyana', 'Ukuran 43', 'adiadnyana22@gmail.com', '081246868369', 1, 'Sent', 56, 12),
(2, 'Jl. Diponegoro No.39 Pesanggaran', 'qQfcuOnWu74NXaC2xNoH_09032022', '2022-03-09 21:56:18.542000', 'Made Adi Adnyana', '', 'adiadnyana22@gmail.com', '081246868369', 2, 'Sent', 60, 1),
(3, 'Jl. Diponegoro No.39 Pesanggaran', 'sGPmgyRJUWGEo4f7l112_09032022', '2022-03-09 21:56:35.099000', 'Made Adi Adnyana', '', 'adiadnyana22@gmail.com', '081246868369', 1, 'Not Yet Sent', 36, 4);

-- --------------------------------------------------------

--
-- Struktur dari tabel `users`
--

CREATE TABLE `users` (
  `user_id` bigint(20) NOT NULL,
  `fullname` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `username` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `users`
--

INSERT INTO `users` (`user_id`, `fullname`, `password`, `username`) VALUES
(1, 'Adi Adnyana Aja', '$2a$12$9rFVPasJqLIiWHzWFxt3aOqxtd6AuzKQrrhzsO884tyNzxefftMDi', 'adiadnyana22');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `categories`
--
ALTER TABLE `categories`
  ADD PRIMARY KEY (`category_id`);

--
-- Indeks untuk tabel `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`product_id`),
  ADD UNIQUE KEY `UK_57ivhy5aj3qfmdvl6vxdfjs4p` (`code`),
  ADD KEY `FKog2rp4qthbtt2lfyhfo32lsw9` (`category_id`);

--
-- Indeks untuk tabel `transactions`
--
ALTER TABLE `transactions`
  ADD PRIMARY KEY (`transaction_id`),
  ADD UNIQUE KEY `UK_4udd4y1at0nskgelat7kvqqb` (`code`),
  ADD KEY `FKcdpkn7bkq15bjvlw9mo46l9ft` (`product_id`);

--
-- Indeks untuk tabel `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `UK_r43af9ap4edm43mmtq01oddj6` (`username`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `categories`
--
ALTER TABLE `categories`
  MODIFY `category_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT untuk tabel `products`
--
ALTER TABLE `products`
  MODIFY `product_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT untuk tabel `transactions`
--
ALTER TABLE `transactions`
  MODIFY `transaction_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT untuk tabel `users`
--
ALTER TABLE `users`
  MODIFY `user_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `products`
--
ALTER TABLE `products`
  ADD CONSTRAINT `FKog2rp4qthbtt2lfyhfo32lsw9` FOREIGN KEY (`category_id`) REFERENCES `categories` (`category_id`);

--
-- Ketidakleluasaan untuk tabel `transactions`
--
ALTER TABLE `transactions`
  ADD CONSTRAINT `FKcdpkn7bkq15bjvlw9mo46l9ft` FOREIGN KEY (`product_id`) REFERENCES `products` (`product_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
