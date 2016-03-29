CREATE TABLE `kayttaja` (
  `kaytID` int(20) NOT NULL AUTO_INCREMENT,
  `etunimi` varchar(50) NOT NULL,
  `sukunimi` varchar(50) NOT NULL,
  `sahkoposti` varchar(50) NOT NULL,
  `salasana` varchar(255) NOT NULL,
  PRIMARY KEY (kaytID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `authority` (
  `id` int(11) NOT NULL,
  `role` varchar(255) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;


CREATE TABLE `kayttajan_authority` (
  `kayttaja_id` int(11) NOT NULL,
  `authority_id` int(11) NOT NULL,
  PRIMARY KEY (kayttaja_id),
  FOREIGN KEY (kayttaja_id) REFERENCES kayttaja(kaytID) ON DELETE NO ACTION ON UPDATE NO ACTION,
  FOREIGN KEY (authority_id) REFERENCES authority(id) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `projektit` (
  `projID` int(20) NOT NULL AUTO_INCREMENT,
  `projnimi` varchar(100) DEFAULT NULL,
  PRIMARY KEY (projID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `tunnit` (
  `tuntiID` int(20) NOT NULL AUTO_INCREMENT,
  `kaytID` int(20) NOT NULL,
  `projID` int(20) NOT NULL,
  `date` varchar(100) NOT NULL,
  `aloitusaika` varchar(100) DEFAULT NULL,
  `lopetusaika` varchar(100) DEFAULT NULL,
  `kuvaus` varchar(100) DEFAULT NULL,
PRIMARY KEY (tuntiID),
FOREIGN KEY (kaytID) REFERENCES kayttaja(kaytID),
FOREIGN KEY (projID) REFERENCES projektit(projID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

