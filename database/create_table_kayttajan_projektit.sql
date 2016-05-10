CREATE TABLE kayttajan_projektit
(
kaytID INT(20),
projID INT(20),
PRIMARY KEY (kaytID),
FOREIGN KEY (kaytID) REFERENCES kayttaja(kaytID),
FOREIGN KEY (projID) REFERENCES projektit(projID)
)engine=InnoDB;