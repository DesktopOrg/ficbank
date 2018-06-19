-- phpMyAdmin SQL Dump
-- version 4.8.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 19-Jun-2018 às 04:42
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

DROP TABLE IF EXISTS `cliente`;
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
(1, 'kassia', '', '', NULL, NULL, NULL, NULL, NULL, '1478523691', NULL);

-- --------------------------------------------------------

--
-- Estrutura da tabela `conta`
--

DROP TABLE IF EXISTS `conta`;
CREATE TABLE `conta` (
  `id` int(11) NOT NULL,
  `user` varchar(20) NOT NULL,
  `senha` varchar(20) NOT NULL,
  `saldo` double DEFAULT NULL,
  `ativo` tinyint(1) DEFAULT NULL,
  `id_cliente` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `conta`
--

INSERT INTO `conta` (`id`, `user`, `senha`, `saldo`, `ativo`, `id_cliente`) VALUES
(2, 'kassia', '123', -30, NULL, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `operacao`
--

DROP TABLE IF EXISTS `operacao`;
CREATE TABLE `operacao` (
  `id` int(11) NOT NULL,
  `descricao` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `requisicao`
--

DROP TABLE IF EXISTS `requisicao`;
CREATE TABLE `requisicao` (
  `id` int(11) NOT NULL,
  `valor` double NOT NULL,
  `data` datetime NOT NULL,
  `aprovado` tinyint(4) DEFAULT NULL,
  `visualizado` tinyint(4) DEFAULT NULL,
  `id_operacao` int(11) NOT NULL,
  `id_tag` int(11) DEFAULT NULL,
  `id_conta_remetente` int(11) NOT NULL,
  `id_conta_destino` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tag`
--

DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag` (
  `id` int(11) NOT NULL,
  `descricao` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `transacao`
--

DROP TABLE IF EXISTS `transacao`;
CREATE TABLE `transacao` (
  `id` int(11) NOT NULL,
  `id_conta` int(11) NOT NULL,
  `id_tag` int(11) DEFAULT NULL,
  `valor` double DEFAULT NULL,
  `data` datetime DEFAULT NULL,
  `tipo` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
-- Indexes for table `operacao`
--
ALTER TABLE `operacao`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `requisicao`
--
ALTER TABLE `requisicao`
  ADD PRIMARY KEY (`id`,`valor`),
  ADD KEY `fk_Requisicao_op1_idx` (`id_operacao`),
  ADD KEY `fk_Requisicao_tag1_idx` (`id_tag`),
  ADD KEY `fk_Requisicao_conta1_idx` (`id_conta_remetente`),
  ADD KEY `fk_Requisicao_conta2_idx` (`id_conta_destino`);

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `conta`
--
ALTER TABLE `conta`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `operacao`
--
ALTER TABLE `operacao`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tag`
--
ALTER TABLE `tag`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `transacao`
--
ALTER TABLE `transacao`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

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
  ADD CONSTRAINT `fk_Requisicao_conta1` FOREIGN KEY (`id_conta_remetente`) REFERENCES `conta` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Requisicao_conta2` FOREIGN KEY (`id_conta_destino`) REFERENCES `conta` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Requisicao_op1` FOREIGN KEY (`id_operacao`) REFERENCES `operacao` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Requisicao_tag1` FOREIGN KEY (`id_tag`) REFERENCES `tag` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
