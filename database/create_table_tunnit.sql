CREATE TABLE tunnit
(
tuntiID INT(20) NOT NULL auto_increment,
kaytID INT(20)NOT NULL,
projID INT(20)NOT NULL,
date VARCHAR(100)NOT NULL,
aloitusaika VARCHAR(100),
lopetusaika VARCHAR(100),
kuvaus VARCHAR(100),
PRIMARY KEY (tuntiID),
FOREIGN KEY (kaytID) REFERENCES kayttaja(kaytID),
FOREIGN KEY (projID) REFERENCES projektit(projID)
)engine=InnoDB;