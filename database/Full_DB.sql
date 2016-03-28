CREATE TABLE `authority` (
  `id` int(11) NOT NULL,
  `role` varchar(255) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

CREATE TABLE `kayttaja` (
  `kaytID` int(20) NOT NULL,
  `etunimi` varchar(50) NOT NULL,
  `sukunimi` varchar(50) NOT NULL,
  `sahkoposti` varchar(50) NOT NULL,
  `salasana` varchar(255) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=latin1;

CREATE TABLE `kayttajan_authority` (
  `id` int(11) NOT NULL,
  `kayttaja_id` int(11) NOT NULL,
  `authority_id` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

CREATE TABLE `projektit` (
  `projID` int(20) NOT NULL,
  `projnimi` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `tunnit` (
  `tuntiID` int(20) NOT NULL,
  `kaytID` int(20) NOT NULL,
  `projID` int(20) NOT NULL,
  `date` varchar(100) NOT NULL,
  `aloitusaika` varchar(100) DEFAULT NULL,
  `lopetusaika` varchar(100) DEFAULT NULL,
  `kuvaus` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

