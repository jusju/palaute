INSERT INTO
	authority
VALUES
	(2,'ROLE_ADMIN'),
	(1,'ROLE_USER');
	
INSERT INTO
	kayttaja
VALUES
	(1,'admin','admini','admin@admini.fi','2238f0492eadf9d6c43ca832ec370e4196e9c592caee2cf40eaeab792706a58f3790d6739b04aa99');
	
INSERT INTO
	kayttajan_authority
VALUES
	(1,2);