CREATE TABLE `authority` (
  `id` int(11) NOT NULL,
  `role` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO `authority` (`id`, `role`) VALUES
(1, 'ROLE_USER'),
(2, 'ROLE_ADMIN');



CREATE TABLE `kayttaja` (
  `kaytID` int(20) NOT NULL,
  `sahkoposti` varchar(50) NOT NULL,
  `salasana` varchar(255) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;



INSERT INTO `kayttaja` (`kaytID`, `sahkoposti`, `salasana`) VALUES
(1, 'admin@admini.fi', '2238f0492eadf9d6c43ca832ec370e4196e9c592caee2cf40eaeab792706a58f3790d6739b04aa99'),
(3, 'a1402952', '007de03422bdc7f055c796b220eca3af325af24233034b4b6b661c5fb7868dc59fa9928ab67dc54d'),
(4, 'a1234567', '416964d4697b22ee46b2527bc9e38cdd4546533b2f4297bba43478ef507e9c90e0c65213f5f691f4');


CREATE TABLE `kayttajan_authority` (
  `kayttaja_id` int(11) NOT NULL,
  `authority_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



INSERT INTO `kayttajan_authority` (`kayttaja_id`, `authority_id`) VALUES
(3, 1),
(4, 1),
(1, 2);



CREATE TABLE `kysymys` (
  `kysymysID` int(20) NOT NULL,
  `kysymysteksti` text
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;


INSERT INTO `kysymys` (`kysymysID`, `kysymysteksti`) VALUES
(1, 'Minkä ikäinen olet?'),
(2, 'Mitä sinulle kuuluu?'),
(3, 'Mitä harrastat?'),
(4, 'Juotko alkoholia?'),
(5, 'Jos et, niin miksi?');



CREATE TABLE `palaute` (
  `palauteID` int(20) NOT NULL,
  `toteutusID` int(20) NOT NULL,
  `vastaaja` varchar(50) DEFAULT NULL,
  `vahvistus` tinyint(1) NOT NULL DEFAULT '0',
  `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `palautteen_linkki` (
  `linkkiID` int(20) NOT NULL,
  `toteutusID` int(20) NOT NULL,
  `satunnainen` varchar(50) NOT NULL,
  `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;



INSERT INTO `palautteen_linkki` (`linkkiID`, `toteutusID`, `satunnainen`, `timestamp`) VALUES
(1, 369, 'b32a9f42-e6ac-438e-93e4-421ef5b4f280', '2016-05-20 10:29:24'),
(2, 277, '392e43a2-73b5-415a-aa88-0cd0a9a083de', '2016-05-20 10:52:05'),
(3, 277, '43a1cf7f-bdcc-416b-beec-7714db4ec27c', '2016-05-20 10:52:12'),
(4, 277, 'fda3a948-0a83-4e21-952e-d672296c9714', '2016-05-20 11:30:12'),
(5, 277, '56621ec8-9820-428d-b8fb-84a0b29936aa', '2016-05-20 11:30:48'),
(6, 369, '7bbe6753-0634-4812-b2c4-ec8549469291', '2016-05-20 12:30:59'),
(7, 369, '8fbd3655-5e3e-4d3d-9784-c1bec9363adb', '2016-05-21 08:26:40');



CREATE TABLE `palautteen_vastaukset` (
  `palauteID` int(20) NOT NULL,
  `vastausID` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



CREATE TABLE `toteutus` (
  `toteutusID` int(20) NOT NULL,
  `toteutusTunnus` varchar(100) DEFAULT NULL,
  `toteutusNimi` varchar(100) DEFAULT NULL,
  `opettajaNimi` varchar(100) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=370 DEFAULT CHARSET=utf8;


INSERT INTO `toteutus` (`toteutusID`, `toteutusTunnus`, `toteutusNimi`, `opettajaNimi`) VALUES
(277, 'ICT1TA006-35', 'Ohjelmointi', 'Christian Brade'),
(278, 'ICT1TA006-36', 'Ohjelmointi', 'Anne Benson Seija Lahtinen Sirpa Marttila'),
(279, 'ICT1TA010-4', 'Orientaatio ICT-infrastruktuuriin', 'Tero Tuoriniemi Timo Ruohomaa'),
(280, 'ICT1TA010-5', 'Orientaatio ICT-infrastruktuuriin', 'Tero Tuoriniemi Timo Ruohomaa'),
(281, 'ICT1TF010-5', 'Orientation to ICT Infrastructures', 'Olavi Korhonen'),
(282, 'ICT1TF010-6', 'Orientation to ICT Infrastructures', 'Juhani Merilinna'),
(283, 'ICT1TN010-6', 'Orientaatio ICT-infrastruktuuriin', 'Petri Hirvonen'),
(284, 'ICT1TN010-7', 'Orientaatio ICT-infrastruktuuriin', 'Harto Holmström'),
(285, 'ICT1TN010-8', 'Orientaatio ICT-infrastruktuuriin', 'Petri Hirvonen'),
(286, 'ICT1TN010-9', 'Orientaatio ICT-infrastruktuuriin', 'Juhani Merilinna'),
(287, 'ICT1TN011-1', 'Windows palvelimet', 'Petri Hirvonen'),
(288, 'ICT1TN012-1', 'Tietoverkkojen perusteet', 'Harto Holmström'),
(289, 'ICT2TA007-23', 'Ohjelmistokehitys', 'Anne Benson Tiina Koskelainen'),
(290, 'ICT2TA007-24', 'Ohjelmistokehitys', 'Anne Benson Irene Vilpponen'),
(291, 'ICT2TA008-25', 'Usability and user interface', 'Heikki Hietala'),
(292, 'ICT2TA008-26', 'Usability and user interface', 'Juha Hinkula Heikki Hietala'),
(293, 'ICT2TA010-20', 'ICT architectures', 'Tero Tuoriniemi'),
(294, 'ICT2TA011-22', 'Tietotekninen selvitys ja kouluttaminen', 'Immo Hahtola Anna Rinnemaa'),
(295, 'ICT2TA011-23', 'Tietotekninen selvitys ja kouluttaminen', 'Taru Parikka Niina Kinnunen'),
(296, 'ICT2TN007-42', 'Ohjelmistokehitys', 'Jukka Juslin Anne Valsta'),
(297, 'ICT2TN007-43', 'Ohjelmistokehitys', 'Tanja Bergius Outi Virkki'),
(298, 'ICT2TN007-44', 'Ohjelmistokehitys', 'Minna Pellikka Hanna Närvänen'),
(299, 'ICT2TN008-42', 'Usability and user interface', 'Hanna Närvänen'),
(300, 'ICT2TN008-43', 'Usability and user interface', 'Teemu Ruohonen'),
(301, 'ICT2TN008-44', 'Usability and user interface', 'Teemu Ruohonen'),
(302, 'ICT2TN009-34', 'Tietohallinto', 'Jukka Mutikainen'),
(303, 'ICT2TN009-35', 'Tietohallinto', 'Jukka Mutikainen'),
(304, 'ICT2TN009-36', 'Tietohallinto', 'Jukka Mutikainen'),
(305, 'ICT2TN010-34', 'ICT architectures', 'Tuomo Ryynänen'),
(306, 'ICT2TN010-35', 'ICT architectures', 'Arvo Lipitsäinen'),
(307, 'ICT2TN010-36', 'ICT architectures', 'Tuomo Ryynänen'),
(308, 'ICT2TN011-37', 'Tietotekninen selvitys ja kouluttaminen', 'Anna Rinnemaa Anne Valsta'),
(309, 'ICT2TN011-38', 'Tietotekninen selvitys ja kouluttaminen', 'Arvo Lipitsäinen Tarja Paasi-May'),
(310, 'ICT2TN011-39', 'Tietotekninen selvitys ja kouluttaminen', 'Sauli Isonikkilä Tarja Paasi-May'),
(311, 'ICT2TN011-40', 'Tietotekninen selvitys ja kouluttaminen', 'Sauli Isonikkilä Pilvi Heinonen'),
(312, 'ICT4TN001-20', 'Windows palvelinkäyttöjärjestelmänä', 'Timo Ruohomaa'),
(313, 'ICT4TN001-21', 'Windows palvelinkäyttöjärjestelmänä', 'Timo Ruohomaa'),
(314, 'ICT4TN002-19', 'Windows palvelimena', 'Olavi Korhonen'),
(315, 'ICT4TN002-20', 'Windows palvelimena', 'Olavi Korhonen'),
(316, 'ICT4TN003-19', 'Linux palvelimena', 'Tero Karvinen'),
(317, 'ICT4TN003-20', 'Linux palvelimena', 'Tero Karvinen'),
(318, 'ICT4TN004-19', 'Lähiverkon toiminta', 'Harto Holmström'),
(319, 'ICT4TN004-20', 'Lähiverkon toiminta', 'Harto Holmström'),
(320, 'ICT4TN005-12', 'Verkon tietoturva', 'Titta Ahlberg'),
(321, 'ICT4TN006-12', 'Tietokantahallinta', 'Sauli Isonikkilä'),
(322, 'ICT4TN007-11', 'Järjestelmäprojekti I', 'Petri Hirvonen Olavi Korhonen Timo Ruohomaa'),
(323, 'ICT4TN008-12', 'Verkon suunnittelu ja toteutus', 'Harto Holmström'),
(324, 'ICT4TN009-13', 'Suojatut verkkoyhteydet', 'Titta Ahlberg'),
(325, 'ICT4TN010-11', 'Tietoturvan hallinta', 'Titta Ahlberg'),
(326, 'ICT4TN011-9', 'Linuxin keskitetty hallinta', 'Tero Karvinen'),
(327, 'ICT4TN012-11', 'Windows arkkitehtuurit', 'Timo Ruohomaa'),
(328, 'ICT4TN013-9', 'Windows ratkaisujen hallinta', 'Timo Ruohomaa'),
(329, 'ICT4TN014-8', 'Sovelluspalvelinten hallinta', 'Olavi Korhonen'),
(330, 'ICT4TN015-6', 'Sovelluspalvelujen virtualisointi', 'Olavi Korhonen'),
(331, 'ICT4TN017-9', 'Järjestelmäprojekti II', 'Petri Hirvonen Harto Holmström Olavi Korhonen Timo Ruohomaa'),
(332, 'ICT4TN018-6', 'Linux-projekti', 'Tero Karvinen'),
(333, 'SWD1TA001-3', 'Orientaatio ohjelmistotuotantoon', 'Sirpa Marttila'),
(334, 'SWD1TF001-3', 'Orientation to Software Engineering', 'Sauli Isonikkilä Juha Hinkula'),
(335, 'SWD1TF001-4', 'Orientation to Software Engineering', 'Sauli Isonikkilä Juha Hinkula'),
(336, 'SWD1TN001-6', 'Orientaatio ohjelmistotuotantoon', 'Tanja Bergius'),
(337, 'SWD1TN001-7', 'Orientaatio ohjelmistotuotantoon', 'Sauli Isonikkilä Jaakko Leikko'),
(338, 'SWD1TN001-8', 'Orientaatio ohjelmistotuotantoon', 'Tanja Bergius'),
(339, 'SWD1TN001-9', 'Orientaatio ohjelmistotuotantoon', 'Ohto Rainio'),
(340, 'SWD1TN002-1', 'Ohjelmointi (Java)', 'Jukka Juslin'),
(341, 'SWD1TN002-15', 'Ohjelmointi (Java)', 'Seija Lahtinen'),
(342, 'SWD1TN002-16', 'Ohjelmointi (Java)', 'Minna Pellikka'),
(343, 'SWD1TN002-2', 'Ohjelmointi (Java)', 'Christian Brade Jaakko Leikko'),
(344, 'SWD1TN003-1', 'Tietokannat ja tiedonhallinta', 'Outi Virkki'),
(345, 'SWD1TN003-15', 'Tietokannat ja tiedonhallinta', 'Seija Lahtinen'),
(346, 'SWD1TN003-16', 'Tietokannat ja tiedonhallinta', 'Minna Pellikka'),
(347, 'SWD1TN003-2', 'Tietokannat ja tiedonhallinta', 'Seija Lahtinen'),
(348, 'SWD4TA011-9', 'XML', 'Sirpa Marttila'),
(349, 'SWD4TA013-8', 'Web-ohjelmointi PHP:llä', 'Sirpa Marttila'),
(350, 'SWD4TF002-1', 'Programming (Java)', 'Juha Hinkula'),
(351, 'SWD4TF003-1', 'Data Management and Databases', 'Kari Silpiö'),
(352, 'SWD4TN002-16', 'Transaktion hallinta', 'Seija Lahtinen'),
(353, 'SWD4TN002-17', 'Transaktion hallinta', 'Seija Lahtinen'),
(354, 'SWD4TN004-19', 'Java EE', 'Jaakko Leikko Jukka Juslin'),
(355, 'SWD4TN004-20', 'Java EE', 'Jaakko Leikko Jukka Juslin'),
(356, 'SWD4TN005-14', 'Softalaprojekti I', 'Jukka Juslin Anne Valsta'),
(357, 'SWD4TN005-15', 'Softalaprojekti I', 'Ohto Rainio Hanna Närvänen'),
(358, 'SWD4TN006-10', 'Softalaprojekti II', 'Juha Hinkula Niina Kinnunen Jukka Juslin'),
(359, 'SWD4TN007-9', 'Softalaprojekti III', 'Ohto Rainio Juha Hinkula Jukka Juslin Anne Valsta'),
(360, 'SWD4TN008-10', 'Tietokannan suunnittelu ja toteutus', 'Outi Virkki'),
(361, 'SWD4TN008-9', 'Tietokannan suunnittelu ja toteutus', 'Sauli Isonikkilä'),
(362, 'SWD4TN010-9', 'Vaatimusmääritys', 'Hanna Närvänen'),
(363, 'SWD4TN011-11', 'XML', 'Sirpa Marttila'),
(364, 'SWD4TN012-9', '.NET sovelluskehitys', 'Sauli Isonikkilä'),
(365, 'SWD4TN013-11', 'Web-ohjelmointi PHP:llä', 'Sirpa Marttila'),
(366, 'SWD4TN014-12', 'Intranet- ja dokumentinhallintaratkaisut, SharePoint 2010', 'Elina Ulpovaara'),
(367, 'SWD4TN015-10', 'Hypermedia', 'Mirja Jaakkola'),
(368, 'SWD8TF808-1', 'Python programming', 'Juha Hinkula'),
(369, 'a1402952', 'Demo toteutus', 'Evgeny Oborotistov');


CREATE TABLE `vahvistus_linkki` (
  `vahvistusID` int(20) NOT NULL,
  `palauteID` int(20) NOT NULL,
  `satunnainen` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `vastaus` (
  `vastausID` int(20) NOT NULL,
  `kysymysID` int(20) DEFAULT NULL,
  `vastausteksti` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


ALTER TABLE `authority`
  ADD PRIMARY KEY (`id`);


ALTER TABLE `kayttaja`
  ADD PRIMARY KEY (`kaytID`);

  
ALTER TABLE `kayttajan_authority`
  ADD PRIMARY KEY (`kayttaja_id`),
  ADD KEY `authority_id` (`authority_id`);


ALTER TABLE `kysymys`
  ADD PRIMARY KEY (`kysymysID`);


ALTER TABLE `palaute`
  ADD PRIMARY KEY (`palauteID`),
  ADD KEY `toteutusID` (`toteutusID`);


ALTER TABLE `palautteen_linkki`
  ADD PRIMARY KEY (`linkkiID`),
  ADD KEY `toteutusID` (`toteutusID`);


ALTER TABLE `palautteen_vastaukset`
  ADD KEY `palauteID` (`palauteID`),
  ADD KEY `vastausID` (`vastausID`);


ALTER TABLE `toteutus`
  ADD PRIMARY KEY (`toteutusID`);


ALTER TABLE `vahvistus_linkki`
  ADD PRIMARY KEY (`vahvistusID`),
  ADD KEY `palauteID` (`palauteID`);


ALTER TABLE `vastaus`
  ADD PRIMARY KEY (`vastausID`),
  ADD KEY `kysymysID` (`kysymysID`);


ALTER TABLE `kayttaja`
  MODIFY `kaytID` int(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;

ALTER TABLE `kysymys`
  MODIFY `kysymysID` int(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;

ALTER TABLE `palaute`
  MODIFY `palauteID` int(20) NOT NULL AUTO_INCREMENT;

ALTER TABLE `palautteen_linkki`
  MODIFY `linkkiID` int(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=8;

ALTER TABLE `toteutus`
  MODIFY `toteutusID` int(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=370;

ALTER TABLE `vahvistus_linkki`
  MODIFY `vahvistusID` int(20) NOT NULL AUTO_INCREMENT;

ALTER TABLE `vastaus`
  MODIFY `vastausID` int(20) NOT NULL AUTO_INCREMENT;

ALTER TABLE `kayttajan_authority`
  ADD CONSTRAINT `kayttajan_authority_ibfk_1` FOREIGN KEY (`kayttaja_id`) REFERENCES `kayttaja` (`kaytID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `kayttajan_authority_ibfk_2` FOREIGN KEY (`authority_id`) REFERENCES `authority` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;


ALTER TABLE `palaute`
  ADD CONSTRAINT `palaute_ibfk_1` FOREIGN KEY (`toteutusID`) REFERENCES `toteutus` (`toteutusID`);


ALTER TABLE `palautteen_linkki`
  ADD CONSTRAINT `palautteen_linkki_ibfk_1` FOREIGN KEY (`toteutusID`) REFERENCES `toteutus` (`toteutusID`);


ALTER TABLE `palautteen_vastaukset`
  ADD CONSTRAINT `palautteen_vastaukset_ibfk_1` FOREIGN KEY (`palauteID`) REFERENCES `palaute` (`palauteID`),
  ADD CONSTRAINT `palautteen_vastaukset_ibfk_2` FOREIGN KEY (`vastausID`) REFERENCES `vastaus` (`vastausID`);


ALTER TABLE `vahvistus_linkki`
  ADD CONSTRAINT `vahvistus_linkki_ibfk_1` FOREIGN KEY (`palauteID`) REFERENCES `palaute` (`palauteID`);


ALTER TABLE `vastaus`
  ADD CONSTRAINT `vastaus_ibfk_1` FOREIGN KEY (`kysymysID`) REFERENCES `kysymys` (`kysymysID`);
