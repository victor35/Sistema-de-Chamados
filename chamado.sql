-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: 29-Jun-2017 às 22:52
-- Versão do servidor: 10.1.21-MariaDB
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `chamado`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `CHAMADO`
--

CREATE TABLE `CHAMADO` (
  `id` int(11) NOT NULL,
  `descricao` longtext NOT NULL,
  `local` varchar(200) NOT NULL,
  `requisitante` varchar(60) NOT NULL,
  `responsavel` varchar(60) NOT NULL,
  `prioridade` varchar(45) NOT NULL,
  `status` varchar(45) NOT NULL,
  `solucoes` longtext NOT NULL,
  `dataDeAbertura` varchar(40) NOT NULL,
  `dataDeFechamento` varchar(40) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `id_equipamentos` int(11) NOT NULL,
  `id_unidade` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `CHAMADO`
--

INSERT INTO `CHAMADO` (`id`, `descricao`, `local`, `requisitante`, `responsavel`, `prioridade`, `status`, `solucoes`, `dataDeAbertura`, `dataDeFechamento`, `id_usuario`, `id_equipamentos`, `id_unidade`) VALUES
(1, 'problema na rede', 'sala 24', 'victor', 'victor', 'alta', 'concluido', 'troca do cabo de rede', '2017-06-05', '2017/06/25', 1, 1, 1),
(3, 'problema no software virtualbox', 'sala 3 ', 'victor', 'victor', 'media', 'em atendimento', 'aguardando', '2017-06-05', '2017/06/25', 1, 4, 1),
(5, 'Faltando um mouse', 'sala 3 ', 'victor', 'victor', 'alta', 'em atendimento', 'aguardando', '2017-06-25', 'aguardando', 1, 3, 1),
(7, 'teste', 'teste', 'teste', 'aguardando', 'teste', 'concluido', 'teste', '2017-06-25', '2017/06/25 20:06:08', 1, 4, 1),
(13, 'teste', 'teste', 'teste', 'fillipe', 'alta', 'cancelado', 'teste', '2017/06/25 18:08:12', '2017/06/25 18:11:33', 6, 6, 4),
(15, 'teste', 'teste', 'teste', 'aguardando', 'teste', 'aberto', 'aguardando', '2017/06/25 21:42:45', 'aguardando', 4, 7, 7),
(16, 'problema no monitor', 'sala 55', 'victor', 'aguardando', 'alta', 'aberto', 'aguardando', '2017/06/29 17:43:17', 'aguardando', 1, 1, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `EQUIPAMENTOS`
--

CREATE TABLE `EQUIPAMENTOS` (
  `id` int(11) NOT NULL,
  `nome` varchar(60) NOT NULL,
  `descricao` longtext NOT NULL,
  `tipo` varchar(45) NOT NULL,
  `id_unidade` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `EQUIPAMENTOS`
--

INSERT INTO `EQUIPAMENTOS` (`id`, `nome`, `descricao`, `tipo`, `id_unidade`) VALUES
(1, 'sh123', 'computador', 'desktop', 1),
(3, 's100500', 'notebook', 'movel', 1),
(4, 's10014', 'modem', 'movel', 1),
(6, 's120', 'computador', 'desktop', 4),
(7, 'teste', 'teste', 'teste', 7);

-- --------------------------------------------------------

--
-- Estrutura da tabela `MENU`
--

CREATE TABLE `MENU` (
  `id` int(11) NOT NULL,
  `link` varchar(45) NOT NULL,
  `titulo` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `MENU`
--

INSERT INTO `MENU` (`id`, `link`, `titulo`) VALUES
(1, 'listar_perfil.jsp', 'PERFIL'),
(2, 'listar_menu.jsp', 'MENU'),
(3, 'listar_usuario.jsp', 'USUARIOS'),
(4, 'listar_chamado.jsp', 'CHAMADO'),
(5, 'listar_unidades.jsp', 'UNIDADE'),
(6, 'listar_equipamentos.jsp', 'EQUIPAMENTOS');

-- --------------------------------------------------------

--
-- Estrutura da tabela `MENU_PERFIL`
--

CREATE TABLE `MENU_PERFIL` (
  `id_perfil` int(11) NOT NULL,
  `id_menu` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `MENU_PERFIL`
--

INSERT INTO `MENU_PERFIL` (`id_perfil`, `id_menu`) VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(1, 5),
(1, 6),
(2, 1),
(2, 2),
(2, 3),
(2, 4),
(2, 5),
(2, 6),
(3, 3),
(3, 4),
(3, 6),
(4, 4);

-- --------------------------------------------------------

--
-- Estrutura da tabela `PERFIL`
--

CREATE TABLE `PERFIL` (
  `id` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `descricao` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `PERFIL`
--

INSERT INTO `PERFIL` (`id`, `nome`, `descricao`) VALUES
(1, 'Administrador', 'controle total do site'),
(2, 'Supervisor', 'Supervisiona os chamados'),
(3, 'Estagiario', 'Adiciona e atende os chamados'),
(4, 'Pesquisador', 'Adiciona e acompanha os chamados');

-- --------------------------------------------------------

--
-- Estrutura da tabela `UNIDADE`
--

CREATE TABLE `UNIDADE` (
  `id` int(11) NOT NULL,
  `endereco` varchar(200) NOT NULL,
  `cep` varchar(10) NOT NULL,
  `telefone` varchar(20) NOT NULL,
  `unidade` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `UNIDADE`
--

INSERT INTO `UNIDADE` (`id`, `endereco`, `cep`, `telefone`, `unidade`) VALUES
(1, 'QUADRA 02, CONJUNTO F, LOTE 09, 2 ANDAR, SETOR SUL - GAMA', '72415-106', '3484-4452', 'AGENCIA GAMA'),
(2, 'SDS - BL H - ED. VENANCIO II - 2 ANDAR - SALA 205 / ASA SUL - BRASILIA', '70393-900', '(61) 3319-2119', 'UNIDADE ESTADUAL DO DISTRITO FEDERAL'),
(3, 'AV. W3 SUL - QUADRA 509 - BL A - LOJAS 1 a 5 / ASA SUL - BRASILIA', '70360-510', '(61) 3319-2157', 'SDI'),
(4, 'RESERVA ECOLOGICA DO IBGE, DF 001, KM 38 - BRASALIA', 'nao possui', '(61) 3319-2195', 'CENTRO DE ESTUDOS AMBIENTAIS DO CERRADO'),
(5, 'CRS 509 BLOCO A - LJS 1 a 5 / ASA SUL - BRASALIA', '70360-510', '(61) 3319-2151 ', 'AGENCIA BRASILIA'),
(6, 'QUADRA 02, CONJUNTO F, LOTE 09, 2 ANDAR, SETOR SUL - GAMA', '72415-106', '(61) 3484-4544', 'AGENCIA GAMA'),
(7, 'QUADRA 10, CL 02, LOJAS 7 e 8 - ED.PORTINARI - SOBRADINHO', '73006-605', '(61) 3591-2113 ', 'AGENCIA SOBRADINHO'),
(8, 'CNB 09 - LOTE 11 - LOJA 01 / TAGUATINGA NORTE - TAGUATINGA', '72115-095', '(61) 3351-5753', 'AGENCIA TAGUATINGA');

-- --------------------------------------------------------

--
-- Estrutura da tabela `USUARIO`
--

CREATE TABLE `USUARIO` (
  `id` int(11) NOT NULL,
  `nome` varchar(60) NOT NULL,
  `login` varchar(45) NOT NULL,
  `senha` varchar(30) NOT NULL,
  `telefone` varchar(20) NOT NULL,
  `email` varchar(45) NOT NULL,
  `id_unidade` int(11) NOT NULL,
  `id_perfil` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `USUARIO`
--

INSERT INTO `USUARIO` (`id`, `nome`, `login`, `senha`, `telefone`, `email`, `id_unidade`, `id_perfil`) VALUES
(1, 'victor', 'victor', '1', '6199351223', 'victor@gmail.com', 1, 1),
(2, 'natsu', 'natsu', '1', '111111', 'dragonslayer@gmail.com', 2, 1),
(3, 'fillipe', 'fillipe', '1', '619999-5555', 'fillipe@gmail.com', 4, 2),
(4, 'victor2', 'victor2', '1', '6199995555', 'victor2@gmail.com', 7, 3),
(5, 'victor3', 'victor3', '1', '61 33192151 ', 'victor3@gmail.com', 4, 3),
(6, 'paulo', 'paulo', '1', '6188884444', 'paulo123@hotmail.com', 4, 4),
(7, 'Elissandra', 'Elissandra', '1', '061991388190', 'elissandra@hotmail.com', 1, 2),
(8, 'Gabriel', 'Gabriel', '1', '06198745632', 'gabriel@hotmail.com', 1, 3),
(9, 'pedro', 'pedro', '1', '06144152200', 'pedro@hotmail.com', 1, 4),
(10, 'admin2', 'admin2', '1', '0619988745', 'admin2@hotmail.com', 4, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `CHAMADO`
--
ALTER TABLE `CHAMADO`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_CHAMADO_USUARIO1_idx` (`id_usuario`),
  ADD KEY `fk_CHAMADO_EQUIPAMENTOS1_idx` (`id_equipamentos`),
  ADD KEY `fk_CHAMADO_UNIDADE1_idx` (`id_unidade`);

--
-- Indexes for table `EQUIPAMENTOS`
--
ALTER TABLE `EQUIPAMENTOS`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_EQUIPAMENTOS_UNIDADE1_idx` (`id_unidade`);

--
-- Indexes for table `MENU`
--
ALTER TABLE `MENU`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `MENU_PERFIL`
--
ALTER TABLE `MENU_PERFIL`
  ADD PRIMARY KEY (`id_perfil`,`id_menu`),
  ADD KEY `fk_PERFIL_has_MENU_MENU1_idx` (`id_menu`),
  ADD KEY `fk_PERFIL_has_MENU_PERFIL1_idx` (`id_perfil`);

--
-- Indexes for table `PERFIL`
--
ALTER TABLE `PERFIL`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `UNIDADE`
--
ALTER TABLE `UNIDADE`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `USUARIO`
--
ALTER TABLE `USUARIO`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_USUARIO_UNIDADE1_idx` (`id_unidade`),
  ADD KEY `fk_USUARIO_PERFIL1_idx` (`id_perfil`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `CHAMADO`
--
ALTER TABLE `CHAMADO`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
--
-- AUTO_INCREMENT for table `EQUIPAMENTOS`
--
ALTER TABLE `EQUIPAMENTOS`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `MENU`
--
ALTER TABLE `MENU`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `PERFIL`
--
ALTER TABLE `PERFIL`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `UNIDADE`
--
ALTER TABLE `UNIDADE`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `USUARIO`
--
ALTER TABLE `USUARIO`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `CHAMADO`
--
ALTER TABLE `CHAMADO`
  ADD CONSTRAINT `fk_CHAMADO_EQUIPAMENTOS1` FOREIGN KEY (`id_equipamentos`) REFERENCES `EQUIPAMENTOS` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_CHAMADO_UNIDADE1` FOREIGN KEY (`id_unidade`) REFERENCES `UNIDADE` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_CHAMADO_USUARIO1` FOREIGN KEY (`id_usuario`) REFERENCES `USUARIO` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `EQUIPAMENTOS`
--
ALTER TABLE `EQUIPAMENTOS`
  ADD CONSTRAINT `fk_EQUIPAMENTOS_UNIDADE1` FOREIGN KEY (`id_unidade`) REFERENCES `UNIDADE` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `MENU_PERFIL`
--
ALTER TABLE `MENU_PERFIL`
  ADD CONSTRAINT `fk_PERFIL_has_MENU_MENU1` FOREIGN KEY (`id_menu`) REFERENCES `MENU` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_PERFIL_has_MENU_PERFIL1` FOREIGN KEY (`id_perfil`) REFERENCES `PERFIL` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `USUARIO`
--
ALTER TABLE `USUARIO`
  ADD CONSTRAINT `fk_USUARIO_PERFIL1` FOREIGN KEY (`id_perfil`) REFERENCES `PERFIL` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_USUARIO_UNIDADE1` FOREIGN KEY (`id_unidade`) REFERENCES `UNIDADE` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
