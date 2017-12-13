CREATE DATABASE IF NOT EXISTS `bibliotech`;
USE `bibliotech`;

CREATE TABLE IF NOT EXISTS `alugueis` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `loginUsuario` varchar(50) NOT NULL,
  `idLivro` int(11) NOT NULL,
  `dataInicial` date NOT NULL,
  `dataFinal` date NOT NULL,
  PRIMARY KEY (`ID`)
);

CREATE TABLE IF NOT EXISTS `categorias` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `descricao` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) AUTO_INCREMENT=2;


CREATE TABLE IF NOT EXISTS `livros` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(60) NOT NULL DEFAULT '0',
  `descricao` varchar(100) DEFAULT '0',
  `categoria` varchar(50) NOT NULL DEFAULT '0',
  `quantidade` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) AUTO_INCREMENT=2;


CREATE TABLE IF NOT EXISTS `reservas` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `loginUsuario` varchar(50) NOT NULL,
  `idLivro` int(11) NOT NULL,
  `dataInicial` date NOT NULL,
  `dataFinal` date NOT NULL,
  PRIMARY KEY (`ID`)
);


CREATE TABLE IF NOT EXISTS `usuarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(50) NOT NULL DEFAULT '0',
  `nome` varchar(50) NOT NULL DEFAULT '0',
  `senha` varchar(50) NOT NULL DEFAULT '0',
  `tipoUsuario` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `Index 2` (`login`)
) AUTO_INCREMENT=2;


INSERT INTO `usuarios` (`id`, `login`, `nome`, `senha`, `tipoUsuario`) VALUES
	(1, 'admin', 'Administrador', 'admin', 'funcionario');