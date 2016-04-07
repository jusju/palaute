CREATE TABLE poletti
(
polettiID INT(20) NOT NULL auto_increment,
satunnainen VARCHAR(50) NOT NULL,
kaytID INT (20) NOT NULL,
vanhenemispvm DATE NOT NULL,
PRIMARY KEY (polettiID),
FOREIGN KEY (kaytID) REFERENCES kayttaja(kaytID)
)engine=InnoDB;