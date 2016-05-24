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

CREATE TABLE `toteutus` (
  `toteutusID` int(20) NOT NULL AUTO_INCREMENT,
  `toteutusTunnus` varchar(100) DEFAULT NULL,
  `toteutusNimi` varchar(100) DEFAULT NULL,
  `opettajaNimi` varchar(100) DEFAULT NULL,
  PRIMARY KEY (toteutusID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE kysymys(
  `kysymysID` int(20) NOT NULL AUTO_INCREMENT,
  `kysymysteksti` text(255) DEFAULT NULL,
  PRIMARY KEY (kysymysID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `vastaus` (
  `vastausID` int(20) NOT NULL AUTO_INCREMENT,
  `kysymysID` int(20) DEFAULT NULL,
  `vastausteksti` text(255) DEFAULT NULL,
  PRIMARY KEY (vastausID),
  FOREIGN KEY (kysymysID) REFERENCES kysymys(kysymysID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `palaute` (
  `palauteID` int(20) NOT NULL AUTO_INCREMENT,
  `toteutusID` int(20) NOT NULL,
  `vastaaja` varchar(50) DEFAULT NULL,
  `vahvistus` boolean DEFAULT 0 NOT NULL,
  `timestamp` timestamp default CURRENT_TIMESTAMP,
  PRIMARY KEY (palauteID),
  FOREIGN KEY (toteutusID) REFERENCES toteutus(toteutusID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `palautteen_vastaukset` (
  `palauteID` int(20) NOT NULL AUTO_INCREMENT,
  `vastausID` int(20) NOT NULL,
  PRIMARY KEY (palauteID),
  FOREIGN KEY (vastausID) REFERENCES vastaus(vastausID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `palautteen_linkki` (
  `linkkiID` int(20) NOT NULL AUTO_INCREMENT,
  `toteutusID` int(20) NOT NULL,
  `satunnainen` varchar(50) NOT NULL,
  `timestamp` timestamp default CURRENT_TIMESTAMP,
  PRIMARY KEY (linkkiID),
  FOREIGN KEY (toteutusID) REFERENCES toteutus(toteutusID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `vahvistus_linkki` (
  `vahvistusID` int(20) NOT NULL AUTO_INCREMENT,
  `palauteID` int(20) NOT NULL,
  `satunnainen` varchar(50) NOT NULL,
  PRIMARY KEY (vahvistusID),
  FOREIGN KEY (palauteID) REFERENCES palaute(palauteID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
