
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
  `vastattu` boolean DEFAULT 0 NOT NULL,
  `timestamp` datetime default CURRENT_TIMESTAMP,
  PRIMARY KEY (palauteID),
  FOREIGN KEY (toteutusID) REFERENCES toteutus(toteutusID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `palautteen_vastaukset` (
  `palauteID` int(20) NOT NULL AUTO_INCREMENT,
  `toteutusID` int(20) NOT NULL,
  PRIMARY KEY (palauteID),
  FOREIGN KEY (toteutusID) REFERENCES toteutus(toteutusID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `palautteen_linkki` (
  `linkkiID` int(20) NOT NULL AUTO_INCREMENT,
  `toteutusID` int(20) NOT NULL,
  `satunnainen` varchar(50) NOT NULL,
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
