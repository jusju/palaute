CREATE TABLE kayttaja
(
kaytID INT(20) NOT NULL auto_increment,
etunimi VARCHAR(50) NOT NULL,
sukunimi VARCHAR(50) NOT NULL,
sahkoposti VARCHAR(50) NOT NULL,
salasana VARCHAR(255) NOT NULL,
PRIMARY KEY (kaytID)
)engine=InnoDB;