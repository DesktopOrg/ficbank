-- phpMyAdmin SQL Dump
-- version 4.8.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 23-Jun-2018 às 18:19
-- Versão do servidor: 10.1.33-MariaDB
-- PHP Version: 7.2.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ficbank`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente`
--

CREATE TABLE `cliente` (
  `id` int(11) NOT NULL,
  `name` varchar(150) NOT NULL,
  `telefone` varchar(14) DEFAULT NULL,
  `email` varchar(50) NOT NULL,
  `estado` varchar(30) DEFAULT NULL,
  `cidade` varchar(50) DEFAULT NULL,
  `logradouro` varchar(50) DEFAULT NULL,
  `numero` varchar(6) DEFAULT NULL,
  `bairro` varchar(50) DEFAULT NULL,
  `cpf` varchar(11) NOT NULL,
  `ativo` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `cliente`
--

INSERT INTO `cliente` (`id`, `name`, `telefone`, `email`, `estado`, `cidade`, `logradouro`, `numero`, `bairro`, `cpf`, `ativo`) VALUES
(1, 'kassia', '', '', NULL, NULL, NULL, NULL, NULL, '1478523691', NULL),
(2, 'João Lucas', NULL, 'joao@mail.com', NULL, NULL, NULL, NULL, NULL, '11111111111', 1),
(3, 'João Lucas', NULL, 'joao@mail.com', NULL, NULL, NULL, NULL, NULL, '03897498189', 1),
(4, 'Kássia ', '6199988871', 'kassia@maim.com', 'DF', 'Brasilia', 'Quadra 2', '2', '234', '03897498189', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `conta`
--

CREATE TABLE `conta` (
  `id` int(11) NOT NULL,
  `user` varchar(20) NOT NULL,
  `senha` varchar(20) NOT NULL,
  `saldo` double DEFAULT NULL,
  `codigo_reparticao` varchar(20) DEFAULT NULL,
  `ativo` tinyint(1) DEFAULT NULL,
  `isAdmin` tinyint(1) DEFAULT NULL,
  `id_cliente` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `conta`
--

INSERT INTO `conta` (`id`, `user`, `senha`, `saldo`, `codigo_reparticao`, `ativo`, `isAdmin`, `id_cliente`) VALUES
(2, 'kassia', '123', -30, 'teste', 1, 1, 1),
(4, 'simples', '123', 500, '789', 1, 0, 1),
(5, 'joao', '123', 600, '456', 1, 0, 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `requisicao`
--

CREATE TABLE `requisicao` (
  `id` int(11) NOT NULL,
  `valor` double NOT NULL,
  `data` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `aprovado` tinyint(4) DEFAULT NULL,
  `visualizado` tinyint(4) DEFAULT NULL,
  `id_transacao` int(11) NOT NULL,
  `id_conta_requisicao` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `requisicao`
--

INSERT INTO `requisicao` (`id`, `valor`, `data`, `aprovado`, `visualizado`, `id_transacao`, `id_conta_requisicao`) VALUES
(1, 500, '2018-06-22 21:59:13', 0, 0, 8, 5),
(2, 50, '2018-06-22 22:22:59', 0, 0, 9, 5),
(3, 50, '2018-06-22 22:22:59', 0, 0, 9, 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `tag`
--

CREATE TABLE `tag` (
  `id` int(11) NOT NULL,
  `descricao` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `transacao`
--

CREATE TABLE `transacao` (
  `id` int(11) NOT NULL,
  `id_conta` int(11) NOT NULL,
  `id_tag` int(11) DEFAULT NULL,
  `valor` double DEFAULT NULL,
  `data` datetime DEFAULT CURRENT_TIMESTAMP,
  `tipo` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `transacao`
--

INSERT INTO `transacao` (`id`, `id_conta`, `id_tag`, `valor`, `data`, `tipo`) VALUES
(1, 4, NULL, 100, '2018-06-22 20:59:17', 4),
(2, 4, NULL, 100, '2018-06-22 21:20:15', 4),
(3, 4, NULL, 101, '2018-06-22 21:22:38', 4),
(4, 4, NULL, 104, '2018-06-22 21:26:28', 4),
(5, 4, NULL, 200, '2018-06-22 21:36:53', 4),
(6, 4, NULL, 400, '2018-06-22 21:55:31', 4),
(7, 4, NULL, 600, '2018-06-22 21:57:18', 4),
(8, 4, NULL, 500, '2018-06-22 21:59:13', 4),
(9, 4, NULL, 100, '2018-06-22 22:22:59', 4);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id`,`cpf`);

--
-- Indexes for table `conta`
--
ALTER TABLE `conta`
  ADD PRIMARY KEY (`id`,`user`),
  ADD KEY `fk_conta_cliente1_idx` (`id_cliente`);

--
-- Indexes for table `requisicao`
--
ALTER TABLE `requisicao`
  ADD PRIMARY KEY (`id`,`valor`),
  ADD KEY `fk_requisicao_transacao` (`id_transacao`),
  ADD KEY `fk_requisicao_conta` (`id_conta_requisicao`);

--
-- Indexes for table `tag`
--
ALTER TABLE `tag`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `transacao`
--
ALTER TABLE `transacao`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `conta`
--
ALTER TABLE `conta`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `requisicao`
--
ALTER TABLE `requisicao`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `tag`
--
ALTER TABLE `tag`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `transacao`
--
ALTER TABLE `transacao`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `conta`
--
ALTER TABLE `conta`
  ADD CONSTRAINT `fk_conta_cliente1` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `requisicao`
--
ALTER TABLE `requisicao`
  ADD CONSTRAINT `fk_requisicao_conta` FOREIGN KEY (`id_conta_requisicao`) REFERENCES `transacao` (`id`),
  ADD CONSTRAINT `fk_requisicao_transacao` FOREIGN KEY (`id_transacao`) REFERENCES `transacao` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
