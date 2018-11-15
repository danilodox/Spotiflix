-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: spotiflix
-- ------------------------------------------------------
-- Server version	8.0.13

-- #####################################################
-- Schema Spotiflix
-- #####################################################
CREATE SCHEMA IF NOT EXISTS `Spotiflix` DEFAULT CHARACTER SET utf8 ;
USE `Spotiflix` ;

-- #####################################################
-- Table `Spotiflix`.`usuario`
-- #####################################################
CREATE TABLE `usuario` (
  `login` varchar(45) NOT NULL,
  `cpf` varchar(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `senha` varchar(20) NOT NULL,
  `email` varchar(90) DEFAULT NULL,
  `telefone` varchar(11) DEFAULT NULL,
  `cidade` varchar(45) DEFAULT NULL,
  `estado` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`login`,`cpf`),
  UNIQUE KEY `login_UNIQUE` (`login`),
  UNIQUE KEY `cpf_UNIQUE` (`cpf`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- #####################################################
-- Table `Spotiflix`.`musica`
-- #####################################################
CREATE TABLE `musica` (
  `cod` int(11) NOT NULL,
  `nomeCantor` varchar(45) NOT NULL,
  `nomeMusica` varchar(45) NOT NULL,
  `ano` year(4) DEFAULT NULL,
  PRIMARY KEY (`cod`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- #####################################################
-- Table `Spotiflix`.`ouvir`
-- #####################################################
CREATE TABLE `ouvir` (
  `usuario_login` varchar(45) NOT NULL,
  `musica_cod` int(11) NOT NULL,
  KEY `musica_cod` (`musica_cod`),
  KEY `usuario_login` (`usuario_login`),
  CONSTRAINT `ouvir_ibfk_1` FOREIGN KEY (`musica_cod`) REFERENCES `musica` (`cod`),
  CONSTRAINT `ouvir_ibfk_2` FOREIGN KEY (`usuario_login`) REFERENCES `usuario` (`login`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




-- #####################################################
-- Table `Spotiflix`.`categoria`
-- #####################################################
CREATE TABLE `categoria` (
  `sertanejo` tinyint(1) DEFAULT NULL,
  `mpb` tinyint(1) DEFAULT NULL,
  `samba` tinyint(1) DEFAULT NULL,
  `forro` tinyint(1) DEFAULT NULL,
  `rock` tinyint(1) DEFAULT NULL,
  `outro` tinyint(1) DEFAULT NULL,
  `musica_cod` int(11) NOT NULL,
  KEY `musica_cod` (`musica_cod`),
  CONSTRAINT `categoria_ibfk_1` FOREIGN KEY (`musica_cod`) REFERENCES `musica` (`cod`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



-- #####################################################
-- Table `Spotiflix`.`sessão`
-- #####################################################
CREATE TABLE `sessão` (
  `cod` int(11) NOT NULL,
  `titulo` varchar(45) NOT NULL,
  `ano` year(4) DEFAULT NULL,
  PRIMARY KEY (`cod`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



-- #####################################################
-- Table `Spotiflix`.`ver`
-- #####################################################
CREATE TABLE `ver` (
  `usuario_login` varchar(45) NOT NULL,
  `sessao_cod` int(11) NOT NULL,
  KEY `usuario_login` (`usuario_login`),
  KEY `sessao_cod` (`sessao_cod`),
  CONSTRAINT `ver_ibfk_1` FOREIGN KEY (`usuario_login`) REFERENCES `usuario` (`login`),
  CONSTRAINT `ver_ibfk_2` FOREIGN KEY (`sessao_cod`) REFERENCES `sessão` (`cod`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




-- #####################################################
-- Table `Spotiflix`.`série`
-- #####################################################
CREATE TABLE `série` (
  `nTemporadas` int(11) NOT NULL,
  `sessao_cod` int(11) NOT NULL,
  PRIMARY KEY (`nTemporadas`,`sessao_cod`),
  KEY `sessao_cod` (`sessao_cod`),
  CONSTRAINT `série_ibfk_1` FOREIGN KEY (`sessao_cod`) REFERENCES `sessão` (`cod`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



-- #####################################################
-- Table `Spotiflix`.`episodio`
-- #####################################################
CREATE TABLE `episodio` (
  `nSequencia` int(11) NOT NULL,
  `temporada` int(11) NOT NULL,
  `nomeEpisodio` varchar(45) NOT NULL,
  `duracao` int(11) DEFAULT NULL,
  `serie_nTemporadas` int(11) NOT NULL,
  `serie_sessao_cod` int(11) DEFAULT NULL,
  PRIMARY KEY (`nSequencia`,`temporada`),
  KEY `serie_nTemporadas` (`serie_nTemporadas`),
  KEY `serie_sessao_cod` (`serie_sessao_cod`),
  CONSTRAINT `episodio_ibfk_1` FOREIGN KEY (`serie_nTemporadas`) REFERENCES `série` (`ntemporadas`),
  CONSTRAINT `episodio_ibfk_2` FOREIGN KEY (`serie_sessao_cod`) REFERENCES `série` (`sessao_cod`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



-- #####################################################
-- Table `Spotiflix`.`filme`
-- #####################################################
CREATE TABLE `filme` (
  `duracao` int(11) DEFAULT NULL,
  `sessao_cod` int(11) NOT NULL,
  KEY `sessao_cod` (`sessao_cod`),
  CONSTRAINT `filme_ibfk_1` FOREIGN KEY (`sessao_cod`) REFERENCES `sessão` (`cod`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



-- #####################################################
-- Table `Spotiflix`.`gênero`
-- #####################################################
CREATE TABLE `gênero` (
  `cod` int(11) NOT NULL,
  `acao` tinyint(1) DEFAULT NULL,
  `aventura` tinyint(1) DEFAULT NULL,
  `animacao` tinyint(1) DEFAULT NULL,
  `comedia` tinyint(1) DEFAULT NULL,
  `fantasia` tinyint(1) DEFAULT NULL,
  `ficcaoCientifica` tinyint(1) DEFAULT NULL,
  `suspense` tinyint(1) DEFAULT NULL,
  `terror` tinyint(1) DEFAULT NULL,
  `drama` tinyint(1) DEFAULT NULL,
  `outro` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`cod`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



-- #####################################################
-- Table `Spotiflix`.`tipo`
-- #####################################################
CREATE TABLE `tipo` (
  `sessao_cod` int(11) NOT NULL,
  `genero_cod` int(11) NOT NULL,
  KEY `sessao_cod` (`sessao_cod`),
  KEY `genero_cod` (`genero_cod`),
  CONSTRAINT `tipo_ibfk_1` FOREIGN KEY (`sessao_cod`) REFERENCES `sessão` (`cod`),
  CONSTRAINT `tipo_ibfk_2` FOREIGN KEY (`genero_cod`) REFERENCES `gênero` (`cod`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




-- #####################################################
-- Inserção de dados
-- #####################################################

INSERT INTO `usuario` VALUES
('AlineMeurer','10423453545','Aline dos Santos','aline2018','alinesantos@hotmail.com','8399642214','Campina-Grande','Paraíba'),
('Arniton001','10423453449','Arnold Oliveira','arnitonn112','anrnold-oliveira@gmail.com','8499322339','Natal','Rio Grande do Norte'),
('Brainiak','1042241234','Danilo Medeiros','destruction123','danilomedeiros.dox@gmail.com','839934345','Campina-Grande','Paraíba'),
('camilanasc','23554445623',' Camila Nascimento','abacaxi10','camilanasc@gmail.com','8445353467','Jaçanã','Rio Grande do Norte'),
('Dan1','10321821481','Daniella Isla','dani007','daniela20018@hotmail.com','8312531141','Picuí','Paraíba'),
('diego2018','24113244246','Diego Cruz','diego2018','diego20018@gmail.com','8334765856','Cuité','Paraíba'),
('felipetomate','13232452323','Felipe Jorge','tomate20','felipetomate@yahoo.com.br','8354845838','Campina-Grande','Paraíba'),
('James_jup','10688928913','James Dantas','JamesDantas10','James_dantas@Yahoo.com.br','8191114648','Caruaru','Pernambuco'),
('R_t','10912434532','Rita Lilian','lili123','lili.rita@gmail.com','8303463545','Campina-Grande','Paraíba'),
('souto','10554365265','Lavinía Souto','sout10','souto2@hotmail.com','8456853467','Natal','Rio Grande do Norte');

INSERT INTO `musica` VALUES 
(10,'Dan Reynolds','Thunder',2017),
(11,'Dan Reynolds','Believer',2017),
(12,'Arnold Oliveira','The Chain',1997),
(13,'James Dantas','My Sweet Lord',1970),
(14,'Victor Hugo','Não vai voltar',2006),
(15,'Victor Hugo','Deixe me ir',2006),
(16,'Victor Hugo','Quero te encontrar',2006),
(17,'Victor Hugo','Pra falar de amor',2006),
(18,'Victor Hugo','Deixo você ir',2006),
(19,'Victor Hugo','Fica do meu lado',2006);


INSERT INTO `categoria` VALUES
(0,0,0,0,0,1,10),
(0,0,0,0,0,1,11),
(0,0,0,0,1,0,12),
(0,0,0,0,1,0,13),
(0,0,0,0,0,1,14),
(0,0,0,0,0,1,15),
(0,0,0,0,0,1,16),
(0,0,0,0,0,1,17),
(0,0,0,0,0,1,18),
(0,0,0,0,0,1,19);

INSERT INTO `sessão` VALUES 
(0,'The Avengers',2012),
(1,'Iron Man',2011),
(2,'Guardians of the Galaxy',2016),
(3,'Captain America',2011),
(4,'Um Sonho de Liberdade',1994),
(5,'O Poderoso Chefão',1972),
(6,'Clube da Luta',1999),
(7,'Inception',2010),
(8,'Matrix',1999),
(9,'A vida é Bela',1999),
(10,'The Big Bang Theory',2011),
(11,'Game of Thrones',2011),
(12,'Breaking Bad',2008),
(13,'The Walking Dead',2010),
(14,'American Horror History',2011),
(15,'Prison Break',2005),
(16,'Breaking Bad',2008),
(17,'Dexter',2006),
(18,'Lost',2004),
(19,'House of Cards',2013);

INSERT INTO `série` VALUES 
(12,10),
(7,11),
(5,12),
(8,13),
(8,14),
(5,15),
(5,16),
(5,17),
(5,18),
(4,19);

INSERT INTO `episodio` VALUES 
(3,1,'Home invasion',46,8,14),
(4,3,'The world',43,4,19),
(5,1,'The Hamburger Postulate',23,12,10),
(7,1,'Circle of friends',48,5,17),
(7,7,'You Win or You Die',53,7,11),
(8,4,'Tread lightly',47,5,12),
(9,4,'Bug',49,5,16),
(10,2,'Guts',44,8,13),
(12,4,'Valiant Hearts',51,5,15),
(18,3,'The brig',49,5,18);


INSERT INTO `filme` VALUES 
(180,0),
(177,1),
(165,2),
(120,3),
(136,4),
(169,5),
(156,6),
(120,7),
(177,8),
(167,9);


INSERT INTO `gênero` VALUES 
(0,1,1,0,0,0,1,0,0,0,0),
(1,1,1,0,0,0,0,1,0,0,0),
(2,1,1,0,1,0,1,0,0,0,0),
(3,1,1,0,0,0,0,0,0,0,0),
(4,0,0,0,0,0,0,0,0,1,0),
(5,1,0,0,0,0,0,0,0,1,0),
(6,1,1,0,0,0,0,0,0,0,0),
(7,0,0,0,0,0,1,0,0,0,0),
(8,1,0,0,0,0,0,1,0,0,0),
(9,0,0,0,0,0,0,0,0,1,0);