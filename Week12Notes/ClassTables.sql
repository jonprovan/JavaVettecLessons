# Remove samurai tables
DROP TABLE IF EXISTS `samuraibattles`;
DROP TABLE IF EXISTS `samuraiweapons`;
DROP TABLE IF EXISTS `samurai`;
DROP TABLE IF EXISTS `armor`;
DROP TABLE IF EXISTS `weapons`;
DROP TABLE IF EXISTS `battles`;
DROP TABLE IF EXISTS `weather`;
DROP TABLE IF EXISTS `landmarks`;

# Add Samurai Tables
CREATE TABLE `landmarks` (
  `LandmarkId` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(100) NOT NULL,
  `Terrain` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`LandmarkId`)
);

CREATE TABLE `weather` (
  `WeatherId` int NOT NULL AUTO_INCREMENT,
  `Pattern` varchar(45) NOT NULL,
  PRIMARY KEY (`WeatherId`)
);

CREATE TABLE `battles` (
  `BattleId` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(100) NOT NULL,
  `Location` int DEFAULT NULL,
  `Weather` int DEFAULT NULL,
  `Year` int NOT NULL,
  `Commanders` int DEFAULT '0',
  PRIMARY KEY (`BattleId`),
  KEY `FK_LandmarkBattle_idx` (`Location`),
  KEY `FK_WeatherBattle_idx` (`Weather`),
  CONSTRAINT `FK_LandmarkBattle` FOREIGN KEY (`Location`) REFERENCES `landmarks` (`LandmarkId`),
  CONSTRAINT `FK_WeatherBattle` FOREIGN KEY (`Weather`) REFERENCES `weather` (`WeatherId`)
);

CREATE TABLE `weapons` (
  `WeaponId` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(60) NOT NULL,
  PRIMARY KEY (`WeaponId`)
);

CREATE TABLE `armor` (
  `ArmorId` int NOT NULL AUTO_INCREMENT,
  `Type` varchar(45) NOT NULL,
  PRIMARY KEY (`ArmorId`)
);

CREATE TABLE `samurai` (
  `SamuraiId` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(60) NOT NULL,
  `Armor` int DEFAULT NULL,
  `Mask` varchar(45) DEFAULT 'None',
  `FollowsCode` tinyint(1) NOT NULL DEFAULT '0',
  `SkillLevel` int DEFAULT NULL,
  PRIMARY KEY (`SamuraiId`),
  KEY `FK_ArmorSamurai_idx` (`Armor`),
  CONSTRAINT `FK_ArmorSamurai` FOREIGN KEY (`Armor`) REFERENCES `armor` (`ArmorId`)
);

CREATE TABLE `samuraiweapons` (
  `SamuraiId` int NOT NULL,
  `WeaponId` int NOT NULL,
  PRIMARY KEY (`SamuraiId`,`WeaponId`),
  KEY `FK_WeaponSamurai_idx` (`WeaponId`),
  CONSTRAINT `FK_SamuraiWeapon` FOREIGN KEY (`SamuraiId`) REFERENCES `samurai` (`SamuraiId`),
  CONSTRAINT `FK_WeaponSamurai` FOREIGN KEY (`WeaponId`) REFERENCES `weapons` (`WeaponId`)
);

CREATE TABLE `samuraibattles` (
  `SamuraiId` int NOT NULL,
  `BattleId` int NOT NULL,
  PRIMARY KEY (`SamuraiId`,`BattleId`),
  KEY `FK_BattleId_idx` (`BattleId`),
  CONSTRAINT `FK_BattleId` FOREIGN KEY (`BattleId`) REFERENCES `battles` (`BattleId`),
  CONSTRAINT `FK_SamuraiId` FOREIGN KEY (`SamuraiId`) REFERENCES `samurai` (`SamuraiId`)
);

#Add Samurai Data
INSERT INTO `landmarks` (`LandmarkId`, `Name`,`Terrain`) VALUES(1, 'Main Method', 'Eclipse');
INSERT INTO `landmarks` (`LandmarkId`, `Name`,`Terrain`) VALUES(2, 'Main Method', 'Eclipse');
INSERT INTO `landmarks` (`LandmarkId`, `Name`,`Terrain`) VALUES(3, 'Main Method', 'Eclipse');
INSERT INTO `landmarks` (`LandmarkId`, `Name`,`Terrain`) VALUES(4, 'Main Method', 'Eclipse');
INSERT INTO `landmarks` (`LandmarkId`, `Name`,`Terrain`) VALUES(5, 'Main Method', 'Eclipse');

INSERT INTO `weather` (`WeatherId`, `Pattern`) VALUES (1, 'Spring');
INSERT INTO `weather` (`WeatherId`, `Pattern`) VALUES (2, 'Snowy');
INSERT INTO `weather` (`WeatherId`, `Pattern`) VALUES (3, 'Rainy');
INSERT INTO `weather` (`WeatherId`, `Pattern`) VALUES (4, 'Sunny');
INSERT INTO `weather` (`WeatherId`, `Pattern`) VALUES (5, 'Foggy');

INSERT INTO `battles` (`BattleId`, `Name`, `Location`, `Weather`, `Year`, `Commanders`) VALUES (1, 'Java', 1, 1, 1995, 3);
INSERT INTO `battles` (`BattleId`, `Name`, `Location`, `Weather`, `Year`, `Commanders`) VALUES (2, '6 Fronts', 2, 2, 2000, 6);
INSERT INTO `battles` (`BattleId`, `Name`, `Location`, `Weather`, `Year`, `Commanders`) VALUES (3, 'Html, CSS, JS', 3, 3, 1995, 3);
INSERT INTO `battles` (`BattleId`, `Name`, `Location`, `Weather`, `Year`, `Commanders`) VALUES (4, 'Tatooine', 4, 4, 1977, 7);
INSERT INTO `battles` (`BattleId`, `Name`, `Location`, `Weather`, `Year`, `Commanders`) VALUES (5, 'Certification', 5, 5, 2023, 2);

INSERT INTO `weapons` (`WeaponId`, `Name`) VALUES (1, 'Katana');
INSERT INTO `weapons` (`WeaponId`, `Name`) VALUES (2, 'Bow');

INSERT INTO `armor` (`ArmorId`, `Type`) VALUES (1, 'Light');
INSERT INTO `armor` (`ArmorId`, `Type`) VALUES (2, 'Medium');
INSERT INTO `armor` (`ArmorId`, `Type`) VALUES (3, 'Heavy');

INSERT INTO `samurai` (`SamuraiId`, `Name`, `Armor`, `Mask`, `FollowsCode`, `SkillLevel`) VALUES (1, 'Tom Cruise', 3, 'Oni', 1, 1);
INSERT INTO `samurai` (`SamuraiId`, `Name`, `Armor`, `Mask`, `FollowsCode`, `SkillLevel`) VALUES (2, 'Jin Sakai', 2, 'Sakai Clan', 0, 10);
INSERT INTO `samurai` (`SamuraiId`, `Name`, `Armor`, `Mask`, `FollowsCode`, `SkillLevel`) VALUES (3, 'Yasuke', 2, 'None', 1, 10);
INSERT INTO `samurai` (`SamuraiId`, `Name`, `Armor`, `Mask`, `FollowsCode`, `SkillLevel`) VALUES (4, 'Jack', 1, 'None', 1, 10);
INSERT INTO `samurai` (`SamuraiId`, `Name`, `Armor`, `Mask`, `FollowsCode`, `SkillLevel`) VALUES (5, 'Afro', 1, 'None', 0, 10);
INSERT INTO `samurai` (`SamuraiId`, `Name`, `Armor`, `Mask`, `FollowsCode`, `SkillLevel`) VALUES (6, 'Miyamoto Musashi', 3, 'Oni', 1, 10);
INSERT INTO `samurai` (`SamuraiId`, `Name`, `Armor`, `Mask`, `FollowsCode`, `SkillLevel`) VALUES (7, 'Hattori Hanzo', 1, 'Oni', 0, 9);
INSERT INTO `samurai` (`SamuraiId`, `Name`, `Armor`, `Mask`, `FollowsCode`, `SkillLevel`) VALUES (8, 'Oda Nobunaga', 3, 'Oni', 1, 7);
INSERT INTO `samurai` (`SamuraiId`, `Name`, `Armor`, `Mask`, `FollowsCode`, `SkillLevel`) VALUES (9, 'Keanu Reeves', 2, 'None', 0, 10);

INSERT INTO `samuraibattles` (`SamuraiId`,`BattleId`) VALUES (1,1);
INSERT INTO `samuraibattles` (`SamuraiId`,`BattleId`) VALUES (2,1);
INSERT INTO `samuraibattles` (`SamuraiId`,`BattleId`) VALUES (3,1);
INSERT INTO `samuraibattles` (`SamuraiId`,`BattleId`) VALUES (8,1);
INSERT INTO `samuraibattles` (`SamuraiId`,`BattleId`) VALUES (9,1);
INSERT INTO `samuraibattles` (`SamuraiId`,`BattleId`) VALUES (1,2);
INSERT INTO `samuraibattles` (`SamuraiId`,`BattleId`) VALUES (2,2);
INSERT INTO `samuraibattles` (`SamuraiId`,`BattleId`) VALUES (6,2);
INSERT INTO `samuraibattles` (`SamuraiId`,`BattleId`) VALUES (8,2);
INSERT INTO `samuraibattles` (`SamuraiId`,`BattleId`) VALUES (2,3);
INSERT INTO `samuraibattles` (`SamuraiId`,`BattleId`) VALUES (7,3);
INSERT INTO `samuraibattles` (`SamuraiId`,`BattleId`) VALUES (9,3);
INSERT INTO `samuraibattles` (`SamuraiId`,`BattleId`) VALUES (4,4);
INSERT INTO `samuraibattles` (`SamuraiId`,`BattleId`) VALUES (7,4);
INSERT INTO `samuraibattles` (`SamuraiId`,`BattleId`) VALUES (9,4);
INSERT INTO `samuraibattles` (`SamuraiId`,`BattleId`) VALUES (1,5);
INSERT INTO `samuraibattles` (`SamuraiId`,`BattleId`) VALUES (4,5);
INSERT INTO `samuraibattles` (`SamuraiId`,`BattleId`) VALUES (5,5);
INSERT INTO `samuraibattles` (`SamuraiId`,`BattleId`) VALUES (6,5);
INSERT INTO `samuraibattles` (`SamuraiId`,`BattleId`) VALUES (9,5);

INSERT INTO `samuraiweapons` (`SamuraiId`, `WeaponId`) VALUES (1, 1);
INSERT INTO `samuraiweapons` (`SamuraiId`, `WeaponId`) VALUES (2, 1);
INSERT INTO `samuraiweapons` (`SamuraiId`, `WeaponId`) VALUES (3, 1);
INSERT INTO `samuraiweapons` (`SamuraiId`, `WeaponId`) VALUES (4, 1);
INSERT INTO `samuraiweapons` (`SamuraiId`, `WeaponId`) VALUES (5, 1);
INSERT INTO `samuraiweapons` (`SamuraiId`, `WeaponId`) VALUES (6, 1);
INSERT INTO `samuraiweapons` (`SamuraiId`, `WeaponId`) VALUES (7, 1);
INSERT INTO `samuraiweapons` (`SamuraiId`, `WeaponId`) VALUES (8, 1);
INSERT INTO `samuraiweapons` (`SamuraiId`, `WeaponId`) VALUES (9, 1);

#Remove destinations
DROP TABLE IF EXISTS `destinationlanguages`;
DROP TABLE IF EXISTS `locationattractions`;
DROP TABLE IF EXISTS `trips`;
DROP TABLE IF EXISTS `attractions`;
DROP TABLE IF EXISTS `destinations`;
DROP TABLE IF EXISTS `languages`;
DROP TABLE IF EXISTS `airlines`;
DROP TABLE IF EXISTS `packages`;

#Add destination tables
CREATE TABLE `packages` (
  `PackageId` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) NOT NULL,
  PRIMARY KEY (`PackageId`)
);

CREATE TABLE `airlines` (
  `AirlineId` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(60) NOT NULL,
  PRIMARY KEY (`AirlineId`)
);

CREATE TABLE `destinations` (
  `LocationId` int NOT NULL AUTO_INCREMENT,
  `City` varchar(100) NOT NULL,
  `Country` varchar(60) NOT NULL,
  PRIMARY KEY (`LocationId`)
);

CREATE TABLE `languages` (
  `LanguageId` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(60) NOT NULL,
  PRIMARY KEY (`LanguageId`)
);

CREATE TABLE `attractions` (
  `AttractionId` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(100) NOT NULL,
  PRIMARY KEY (`AttractionId`)
);

CREATE TABLE `trips` (
  `ConfirmationNumber` int NOT NULL AUTO_INCREMENT,
  `Location` int DEFAULT NULL,
  `Airline` int DEFAULT NULL,
  `DepartureDate` date DEFAULT NULL,
  `ReturnDate` date DEFAULT NULL,
  `Package` int DEFAULT NULL,
  `Price` decimal(14,2) DEFAULT NULL,
  PRIMARY KEY (`ConfirmationNumber`),
  KEY `FK_LocationTrip_idx` (`Location`),
  KEY `FK_AirlineTrip_idx` (`Airline`),
  KEY `FK_PackageTrip_idx` (`Package`),
  CONSTRAINT `FK_AirlineTrip` FOREIGN KEY (`Airline`) REFERENCES `airlines` (`AirlineId`),
  CONSTRAINT `FK_LocationTrip` FOREIGN KEY (`Location`) REFERENCES `destinations` (`LocationId`),
  CONSTRAINT `FK_PackageTrip` FOREIGN KEY (`Package`) REFERENCES `packages` (`PackageId`)
);

CREATE TABLE `destinationlanguages` (
  `LocationId` int NOT NULL,
  `LanguageId` int NOT NULL,
  PRIMARY KEY (`LocationId`,`LanguageId`),
  KEY `FK_language_idx` (`LanguageId`),
  CONSTRAINT `FK_Language` FOREIGN KEY (`LanguageId`) REFERENCES `languages` (`LanguageId`),
  CONSTRAINT `FK_Location` FOREIGN KEY (`LocationId`) REFERENCES `destinations` (`LocationId`)
);

CREATE TABLE `locationattractions` (
  `LocationId` int NOT NULL,
  `AttractionId` int NOT NULL,
  PRIMARY KEY (`LocationId`,`AttractionId`),
  KEY `FK_Attraction_idx` (`AttractionId`),
  CONSTRAINT `FK_ALocation` FOREIGN KEY (`LocationId`) REFERENCES `destinations` (`LocationId`),
  CONSTRAINT `FK_Attraction` FOREIGN KEY (`AttractionId`) REFERENCES `attractions` (`AttractionId`)
);

#Add Destination Data
INSERT INTO `packages` (`PackageId`, `Name`) VALUES (1, 'Firster Class');
INSERT INTO `packages` (`PackageId`, `Name`) VALUES (2, 'Economy');
INSERT INTO `packages` (`PackageId`, `Name`) VALUES (3, 'Upper Class');
INSERT INTO `packages` (`PackageId`, `Name`) VALUES (4, 'Business Plus');
INSERT INTO `packages` (`PackageId`, `Name`) VALUES (5, 'Economy Plus');

INSERT INTO `airlines` (`AirlineId`, `Name`) VALUES (1, 'United Emirates');
INSERT INTO `airlines` (`AirlineId`, `Name`) VALUES (2, 'American Airlines');
INSERT INTO `airlines` (`AirlineId`, `Name`) VALUES (3, 'Delta');
INSERT INTO `airlines` (`AirlineId`, `Name`) VALUES (4, 'Air Canada');
INSERT INTO `airlines` (`AirlineId`, `Name`) VALUES (5, 'Frontier');

INSERT INTO `languages` (`LanguageId`, `Name`) VALUES (1, 'Spanish');
INSERT INTO `languages` (`LanguageId`, `Name`) VALUES (2, 'English');
INSERT INTO `languages` (`LanguageId`, `Name`) VALUES (3, 'Egyptian');
INSERT INTO `languages` (`LanguageId`, `Name`) VALUES (4, 'Norwegian');
INSERT INTO `languages` (`LanguageId`, `Name`) VALUES (5, 'Indonesian');

INSERT INTO `destinations` (`LocationId`, `City`, `Country`) VALUES (1, 'San Jose', 'Costa Rica');
INSERT INTO `destinations` (`LocationId`, `City`, `Country`) VALUES (2, 'Pittsburg', 'USE');
INSERT INTO `destinations` (`LocationId`, `City`, `Country`) VALUES (3, 'Cairo', 'Egypt');
INSERT INTO `destinations` (`LocationId`, `City`, `Country`) VALUES (4, 'Oslo', 'Norway');
INSERT INTO `destinations` (`LocationId`, `City`, `Country`) VALUES (5, 'Jakarta', 'Indonesia');

INSERT INTO `attractions` (`AttractionId`, `Name`) VALUES (1, 'Beaches');
INSERT INTO `attractions` (`AttractionId`, `Name`) VALUES (2, 'National Parks');
INSERT INTO `attractions` (`AttractionId`, `Name`) VALUES (3, 'One Man Submarine');
INSERT INTO `attractions` (`AttractionId`, `Name`) VALUES (4, 'Zip-lining');
INSERT INTO `attractions` (`AttractionId`, `Name`) VALUES (5, 'Fields');
INSERT INTO `attractions` (`AttractionId`, `Name`) VALUES (6, 'Parasailing');
INSERT INTO `attractions` (`AttractionId`, `Name`) VALUES (7, 'Skiing');
INSERT INTO `attractions` (`AttractionId`, `Name`) VALUES (8, 'Jungles');
INSERT INTO `attractions` (`AttractionId`, `Name`) VALUES (9, 'Ruins');

INSERT INTO `trips` (`ConfirmationNumber`, `Location`, `Airline`, `DepartureDate`, `ReturnDate`, `Package`, `Price`) VALUES (1, 1, 1, '2023-05-03', '2023-05-07', 1, 1000000.00);
INSERT INTO `trips` (`ConfirmationNumber`, `Location`, `Airline`, `DepartureDate`, `ReturnDate`, `Package`, `Price`) VALUES (2, 2, 2, '2023-05-04', '2023-05-04', 2, 5000.00);
INSERT INTO `trips` (`ConfirmationNumber`, `Location`, `Airline`, `DepartureDate`, `ReturnDate`, `Package`, `Price`) VALUES (3, 3, 3, '2023-04-21', '2023-04-25', 3, 3500.00);
INSERT INTO `trips` (`ConfirmationNumber`, `Location`, `Airline`, `DepartureDate`, `ReturnDate`, `Package`, `Price`) VALUES (4, 4, 4, '2023-03-01', '2023-03-10', 4, 4650.00);
INSERT INTO `trips` (`ConfirmationNumber`, `Location`, `Airline`, `DepartureDate`, `ReturnDate`, `Package`, `Price`) VALUES (5, 5, 5, '2023-06-03', '2023-06-06', 5, 7634.00);

INSERT INTO `locationattractions` (`LocationId`, `AttractionId`) VALUES (1, 1);
INSERT INTO `locationattractions` (`LocationId`, `AttractionId`) VALUES (1, 2);
INSERT INTO `locationattractions` (`LocationId`, `AttractionId`) VALUES (1, 3);
INSERT INTO `locationattractions` (`LocationId`, `AttractionId`) VALUES (2, 4);
INSERT INTO `locationattractions` (`LocationId`, `AttractionId`) VALUES (2, 5);
INSERT INTO `locationattractions` (`LocationId`, `AttractionId`) VALUES (3, 6);
INSERT INTO `locationattractions` (`LocationId`, `AttractionId`) VALUES (4, 7);
INSERT INTO `locationattractions` (`LocationId`, `AttractionId`) VALUES (5, 8);
INSERT INTO `locationattractions` (`LocationId`, `AttractionId`) VALUES (5, 9);

INSERT INTO `destinationlanguages` (`LocationId`, `LanguageId`) VALUES (1, 1);
INSERT INTO `destinationlanguages` (`LocationId`, `LanguageId`) VALUES (1, 2);
INSERT INTO `destinationlanguages` (`LocationId`, `LanguageId`) VALUES (2, 2);
INSERT INTO `destinationlanguages` (`LocationId`, `LanguageId`) VALUES (4, 2);
INSERT INTO `destinationlanguages` (`LocationId`, `LanguageId`) VALUES (3, 3);
INSERT INTO `destinationlanguages` (`LocationId`, `LanguageId`) VALUES (4, 4);
INSERT INTO `destinationlanguages` (`LocationId`, `LanguageId`) VALUES (5, 5);

# remove people
DROP TABLE IF EXISTS `positioncompanies`;
DROP TABLE IF EXISTS `vehicles`;
DROP TABLE IF EXISTS `cellphones`;
DROP TABLE IF EXISTS `people`;
DROP TABLE IF EXISTS `positions`;
DROP TABLE IF EXISTS `companies`;

#Add People Tables
CREATE TABLE `companies` (
  `CompanyId` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(100) NOT NULL,
  PRIMARY KEY (`CompanyId`)
);

CREATE TABLE `positions` (
  `JobId` int NOT NULL AUTO_INCREMENT,
  `Title` varchar(100) DEFAULT NULL,
  `Salary` decimal(14,2) DEFAULT NULL,
  `Description` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`JobId`)
);

CREATE TABLE `people` (
  `PersonId` int NOT NULL AUTO_INCREMENT,
  `First` varchar(50) NOT NULL,
  `Last` varchar(50) NOT NULL,
  `HairColor` varchar(45) DEFAULT NULL,
  `Birthday` date NOT NULL,
  `BloodType` varchar(2) DEFAULT NULL,
  `FirstLanguage` varchar(45) DEFAULT NULL,
  `Job` int NOT NULL,
  PRIMARY KEY (`PersonId`),
  KEY `FK_PersonPosition_idx` (`Job`),
  CONSTRAINT `FK_PersonPosition` FOREIGN KEY (`Job`) REFERENCES `positions` (`JobId`)
);

CREATE TABLE `cellphones` (
  `PhoneNumber` int NOT NULL,
  `Color` varchar(45) DEFAULT NULL,
  `Brand` varchar(45) NOT NULL,
  `Model` varchar(45) NOT NULL,
  `Carrier` varchar(45) DEFAULT NULL,
  `Storage` int DEFAULT NULL,
  `ScreenSize` int DEFAULT NULL,
  `OwnerId` int DEFAULT NULL,
  PRIMARY KEY (`PhoneNumber`),
  UNIQUE KEY `OwnerId_UNIQUE` (`OwnerId`),
  KEY `FK_PhonePerson_idx` (`OwnerId`),
  CONSTRAINT `FK_PhonePerson` FOREIGN KEY (`OwnerId`) REFERENCES `people` (`PersonId`)
);

CREATE TABLE `vehicles` (
  `VIN` varchar(17) NOT NULL,
  `Make` varchar(45) NOT NULL,
  `Model` varchar(45) NOT NULL,
  `Year` int NOT NULL,
  `Color` varchar(45) DEFAULT NULL,
  `Doors` int DEFAULT NULL,
  `Trim` varchar(45) DEFAULT NULL,
  `Price` decimal(11,2) DEFAULT NULL,
  `TopSpeed` int DEFAULT NULL,
  `OwnerId` int DEFAULT NULL,
  PRIMARY KEY (`VIN`),
  KEY `PersonId_idx` (`OwnerId`),
  CONSTRAINT `FK_PeopleVehicle` FOREIGN KEY (`OwnerId`) REFERENCES `people` (`PersonId`)
);

CREATE TABLE `positioncompanies` (
  `PositionId` int NOT NULL,
  `CompanyId` int NOT NULL,
  PRIMARY KEY (`PositionId`,`CompanyId`),
  KEY `FK_CompanyPosition_idx` (`CompanyId`),
  CONSTRAINT `FK_CompanyPosition` FOREIGN KEY (`CompanyId`) REFERENCES `companies` (`CompanyId`),
  CONSTRAINT `FK_PositionCompany` FOREIGN KEY (`PositionId`) REFERENCES `positions` (`JobId`)
);

#Add People Data
INSERT INTO `companies` (`CompanyId`, `Name`) VALUES (1, 'Skillstorm');
INSERT INTO `companies` (`CompanyId`, `Name`) VALUES (2, 'Justice League');
INSERT INTO `companies` (`CompanyId`, `Name`) VALUES (3, 'Rebellion');
INSERT INTO `companies` (`CompanyId`, `Name`) VALUES (4, 'None');

INSERT INTO `positions` (`JobId`, `Title`, `Salary`, `Description`) VALUES (1, 'VP of Products', 200000.00, 'Marketing Lead');
INSERT INTO `positions` (`JobId`, `Title`, `Salary`, `Description`) VALUES (2, 'Trainer', 72000.00, 'Trainer');
INSERT INTO `positions` (`JobId`, `Title`, `Salary`, `Description`) VALUES (3, 'Batman', 0.00, 'Super Hero');
INSERT INTO `positions` (`JobId`, `Title`, `Salary`, `Description`) VALUES (4, 'Superman', 0.00, 'Super Hero');
INSERT INTO `positions` (`JobId`, `Title`, `Salary`, `Description`) VALUES (5, 'President', 2.00, 'World Leader');
INSERT INTO `positions` (`JobId`, `Title`, `Salary`, `Description`) VALUES (6, 'Rebel', 0.00, 'Sniper');
INSERT INTO `positions` (`JobId`, `Title`, `Salary`, `Description`) VALUES (7, 'Bat that Laughs', 23000.00, 'Earth 22');

INSERT INTO `people` (`PersonId`, `First`, `Last`, `HairColor`, `Birthday`, `BloodType`, `FirstLanguage`, `Job`) VALUES (1, 'Dan', 'Pickles', 'Blonde', '1993-01-12', 'O+', 'Spanish', 1);
INSERT INTO `people` (`PersonId`, `First`, `Last`, `HairColor`, `Birthday`, `BloodType`, `FirstLanguage`, `Job`) VALUES (2, 'Miles', 'Mixon', 'Black', '1990-07-13', 'B+', 'English', 2);
INSERT INTO `people` (`PersonId`, `First`, `Last`, `HairColor`, `Birthday`, `BloodType`, `FirstLanguage`, `Job`) VALUES (3, 'Bruce', 'Wayne', 'Black', '1955-03-04', 'O+', 'English', 3);
INSERT INTO `people` (`PersonId`, `First`, `Last`, `HairColor`, `Birthday`, `BloodType`, `FirstLanguage`, `Job`) VALUES (4, 'Clark', 'Kent', 'Black', '1955-03-06', 'A-', 'Kryptonian', 4);
INSERT INTO `people` (`PersonId`, `First`, `Last`, `HairColor`, `Birthday`, `BloodType`, `FirstLanguage`, `Job`) VALUES (5, 'Shaggy', 'Rogers', 'Brown', '1969-07-10', 'B+', 'English', 5);
INSERT INTO `people` (`PersonId`, `First`, `Last`, `HairColor`, `Birthday`, `BloodType`, `FirstLanguage`, `Job`) VALUES (6, 'Jonathan', 'Provan', 'Brown', '1985-09-20', 'A-', 'English', 2);
INSERT INTO `people` (`PersonId`, `First`, `Last`, `HairColor`, `Birthday`, `BloodType`, `FirstLanguage`, `Job`) VALUES (7, 'Sabine', 'Wren', 'Purple', '4135-10-21', 'O+', 'Spanish', 6);

INSERT INTO `cellphones` (`PhoneNumber`, `Color`, `Brand`, `Model`, `Carrier`, `Storage`, `ScreenSize`, `OwnerId`) VALUES (1, 'Red', 'Apple', 'X', 'Verizon', 230, 6, 3);
INSERT INTO `cellphones` (`PhoneNumber`, `Color`, `Brand`, `Model`, `Carrier`, `Storage`, `ScreenSize`, `OwnerId`) VALUES (2, 'Red', 'Blackberry', 'GSM', 'AT&T', 200, 4, 4);
INSERT INTO `cellphones` (`PhoneNumber`, `Color`, `Brand`, `Model`, `Carrier`, `Storage`, `ScreenSize`, `OwnerId`) VALUES (3, 'Blue', 'Samsung', 'Galaxy', 'AT&T', 245, 6, 7);
INSERT INTO `cellphones` (`PhoneNumber`, `Color`, `Brand`, `Model`, `Carrier`, `Storage`, `ScreenSize`, `OwnerId`) VALUES (4, 'Black', 'OnePlus', '11', 'Verizon', 256, 7, 1);
INSERT INTO `cellphones` (`PhoneNumber`, `Color`, `Brand`, `Model`, `Carrier`, `Storage`, `ScreenSize`, `OwnerId`) VALUES (5, 'Grey', 'Jitterbug', 'Flip2', 'T-Mobile', 100, 3, 2);

INSERT INTO `vehicles` (`VIN`, `Make`, `Model`, `Year`, `Color`, `Doors`, `Trim`, `Price`, `TopSpeed`, `OwnerId`) VALUES ('1NG2H3TY5', 'Oscar Myer', 'Weiner Mobile', 1998, 'Yellow', 4, 'Ultra', 30000.00, 150, 4);
INSERT INTO `vehicles` (`VIN`, `Make`, `Model`, `Year`, `Color`, `Doors`, `Trim`, `Price`, `TopSpeed`, `OwnerId`) VALUES ('3NTY6J745S', 'Reliant', 'Robin', 1973, 'Blue', 2, 'Base', 45000.00, 70, NULL);
INSERT INTO `vehicles` (`VIN`, `Make`, `Model`, `Year`, `Color`, `Doors`, `Trim`, `Price`, `TopSpeed`, `OwnerId`) VALUES ('87SDI32N3', 'DMC-12', 'Delorean', 1981, 'Silver', 2, 'Doc Special', 300000.00, 88, 5);
INSERT INTO `vehicles` (`VIN`, `Make`, `Model`, `Year`, `Color`, `Doors`, `Trim`, `Price`, `TopSpeed`, `OwnerId`) VALUES ('BNED6435W', 'Lincoln', 'Futura', 1955, 'Black', 2, 'Bat', 250000.00, 200, 3);
INSERT INTO `vehicles` (`VIN`, `Make`, `Model`, `Year`, `Color`, `Doors`, `Trim`, `Price`, `TopSpeed`, `OwnerId`) VALUES ('BT62G9172', 'Peel', 'p50', 1962, 'Red', 1, 'Mini', 131500.80, 40, NULL);
INSERT INTO `vehicles` (`VIN`, `Make`, `Model`, `Year`, `Color`, `Doors`, `Trim`, `Price`, `TopSpeed`, `OwnerId`) VALUES ('BY7WN9P9', 'Boat', 'Mobile', 1990, 'Invisible', 2, 'Invisible', 80000.00, 100, 1);
INSERT INTO `vehicles` (`VIN`, `Make`, `Model`, `Year`, `Color`, `Doors`, `Trim`, `Price`, `TopSpeed`, `OwnerId`) VALUES ('FF87SON90', 'Dodge', 'Mystery Machine', 1969, 'Green', 5, 'Mysterieous', 200000.00, 120, 5);
INSERT INTO `vehicles` (`VIN`, `Make`, `Model`, `Year`, `Color`, `Doors`, `Trim`, `Price`, `TopSpeed`, `OwnerId`) VALUES ('NJY7862NB', 'International', 'Scout II', 1973, 'Red', 2, 'Ultra', 56900.00, 120, 6);
INSERT INTO `vehicles` (`VIN`, `Make`, `Model`, `Year`, `Color`, `Doors`, `Trim`, `Price`, `TopSpeed`, `OwnerId`) VALUES ('SY7TH862N', 'Nissan', 'Altima', 2023, 'Black', 4, 'SR', 45000.00, 130, 2);

INSERT INTO `positioncompanies` (`PositionId`, `CompanyId`) VALUES (1, 1);
INSERT INTO `positioncompanies` (`PositionId`, `CompanyId`) VALUES (2, 1);
INSERT INTO `positioncompanies` (`PositionId`, `CompanyId`) VALUES (3, 2);
INSERT INTO `positioncompanies` (`PositionId`, `CompanyId`) VALUES (4, 2);
INSERT INTO `positioncompanies` (`PositionId`, `CompanyId`) VALUES (5, 4);
INSERT INTO `positioncompanies` (`PositionId`, `CompanyId`) VALUES (6, 3);

# remove inventory
DROP TABLE IF EXISTS `shipments`;
DROP TABLE IF EXISTS `inventory`;

#Add inventory tables
CREATE TABLE `inventory` (
  `ProductId` int NOT NULL AUTO_INCREMENT,
  `Warehouse` varchar(45) DEFAULT NULL,
  `ProductType` varchar(45) NOT NULL,
  `Stock` int DEFAULT NULL,
  PRIMARY KEY (`ProductId`)
);

CREATE TABLE `shipments` (
  `ShippingNumber` varchar(20) NOT NULL,
  `Destination` varchar(60) DEFAULT NULL,
  `LabelCreated` date DEFAULT NULL,
  `LastHandled` date DEFAULT NULL,
  `Handler` varchar(60) DEFAULT NULL,
  `ProductId` int DEFAULT NULL,
  PRIMARY KEY (`ShippingNumber`),
  KEY `FK_InventoryShipments_idx` (`ProductId`),
  CONSTRAINT `FK_InventoryShipments` FOREIGN KEY (`ProductId`) REFERENCES `inventory` (`ProductId`)
);

#Add Inventory Data
INSERT INTO `inventory` (`ProductId`, `Warehouse`, `ProductType`, `Stock`) VALUES (1, 'Amazon', 'Computer', 21);
INSERT INTO `inventory` (`ProductId`, `Warehouse`, `ProductType`, `Stock`) VALUES (2, 'UPS', 'Printer', 43);
INSERT INTO `inventory` (`ProductId`, `Warehouse`, `ProductType`, `Stock`) VALUES (3, 'Target', 'Trumpet', 14);
INSERT INTO `inventory` (`ProductId`, `Warehouse`, `ProductType`, `Stock`) VALUES (4, 'Best Buy', 'TV', 63);
INSERT INTO `inventory` (`ProductId`, `Warehouse`, `ProductType`, `Stock`) VALUES (5, 'Walmart', 'Suitcase', 40);
INSERT INTO `inventory` (`ProductId`, `Warehouse`, `ProductType`, `Stock`) VALUES (6, 'Office Depot', 'Desk', 12);
INSERT INTO `inventory` (`ProductId`, `Warehouse`, `ProductType`, `Stock`) VALUES (7, 'Kmart', 'Chair', 32);
INSERT INTO `inventory` (`ProductId`, `Warehouse`, `ProductType`, `Stock`) VALUES (8, 'Pep Boys', 'Pen', 114);
INSERT INTO `inventory` (`ProductId`, `Warehouse`, `ProductType`, `Stock`) VALUES (11, 'Walmart', 'Cellphone', 52);

INSERT INTO `shipments` (`ShippingNumber`, `Destination`, `LabelCreated`, `LastHandled`, `Handler`, `ProductId`) VALUES ('A1', 'La Biblioteca', '2023-05-04', '2023-05-05', 'Dan Pickles', 1);
INSERT INTO `shipments` (`ShippingNumber`, `Destination`, `LabelCreated`, `LastHandled`, `Handler`, `ProductId`) VALUES ('A2', 'La Biblioteca', '2023-05-02', '2023-05-03', 'Dan Pickles', 2);
INSERT INTO `shipments` (`ShippingNumber`, `Destination`, `LabelCreated`, `LastHandled`, `Handler`, `ProductId`) VALUES ('A3', 'La Biblioteca', '2023-04-21', '2023-04-22', 'Dan Pickles', 3);
INSERT INTO `shipments` (`ShippingNumber`, `Destination`, `LabelCreated`, `LastHandled`, `Handler`, `ProductId`) VALUES ('A4', 'La Biblioteca', '2023-01-02', '2023-01-03', 'Dan Pickles', 4);
INSERT INTO `shipments` (`ShippingNumber`, `Destination`, `LabelCreated`, `LastHandled`, `Handler`, `ProductId`) VALUES ('A5', 'La Biblioteca', '2023-05-02', '2023-05-03', 'Dan Pickles', 5);
INSERT INTO `shipments` (`ShippingNumber`, `Destination`, `LabelCreated`, `LastHandled`, `Handler`, `ProductId`) VALUES ('A6', 'La Biblioteca', '2023-05-06', '2023-05-07', 'Dan Pickles', 6);
INSERT INTO `shipments` (`ShippingNumber`, `Destination`, `LabelCreated`, `LastHandled`, `Handler`, `ProductId`) VALUES ('A7', 'La Biblioteca', '2023-04-05', '2023-04-06', 'Dan Pickles', 7);

#remove movies
DROP TABLE IF EXISTS `movies`;

#Add movie table
CREATE TABLE `movies` (
  `Title` varchar(100) NOT NULL,
  `ReleaseYear` int NOT NULL,
  `Genre` varchar(45) NOT NULL,
  `Rating` varchar(10) NOT NULL DEFAULT 'Not Rated',
  `GrossProfit` decimal(14,2) DEFAULT NULL,
  `Cost` decimal(14,2) DEFAULT NULL,
  `Runtime` int DEFAULT NULL,
  `ReviewScore` decimal(3,1) DEFAULT NULL,
  PRIMARY KEY (`Title`,`ReleaseYear`)
);

#Add Movie Data
INSERT INTO `movies` (`Title`, `ReleaseYear`, `Genre`, `Rating`, `GrossProfit`, `Cost`, `Runtime`, `ReviewScore`) VALUES ('47 Ronin', 2013, 'Action', 'PG-13', 151800000.00, 225000000.00, 118, 6.2);
INSERT INTO `movies` (`Title`, `ReleaseYear`, `Genre`, `Rating`, `GrossProfit`, `Cost`, `Runtime`, `ReviewScore`) VALUES ('Deadpool', 2016, 'Action', 'R', 782600000.00, 58000000.00, 108, 8.0);
INSERT INTO `movies` (`Title`, `ReleaseYear`, `Genre`, `Rating`, `GrossProfit`, `Cost`, `Runtime`, `ReviewScore`) VALUES ('Detective Pikachu', 2019, 'Comedy', 'PG', 449762638.00, 150000000.00, 104, 6.5);
INSERT INTO `movies` (`Title`, `ReleaseYear`, `Genre`, `Rating`, `GrossProfit`, `Cost`, `Runtime`, `ReviewScore`) VALUES ('Forest Gump', 1994, 'Romance', 'PG-13', 678226465.00, 55000000.00, 142, 8.8);
INSERT INTO `movies` (`Title`, `ReleaseYear`, `Genre`, `Rating`, `GrossProfit`, `Cost`, `Runtime`, `ReviewScore`) VALUES ('Heat', 1995, 'Drama', 'R', 187436818.00, 60000000.00, 170, 8.3);
INSERT INTO `movies` (`Title`, `ReleaseYear`, `Genre`, `Rating`, `GrossProfit`, `Cost`, `Runtime`, `ReviewScore`) VALUES ('Love and Basketball', 2000, 'Romance', 'PG-13', 27700000.00, 20000000.00, 127, 7.2);
INSERT INTO `movies` (`Title`, `ReleaseYear`, `Genre`, `Rating`, `GrossProfit`, `Cost`, `Runtime`, `ReviewScore`) VALUES ('Oceans 11', 1960, 'Comedy', 'N/A', 5500000.00, 5000000.00, 127, 6.5);
INSERT INTO `movies` (`Title`, `ReleaseYear`, `Genre`, `Rating`, `GrossProfit`, `Cost`, `Runtime`, `ReviewScore`) VALUES ('Red Dawn', 1984, 'Action', 'PG-13', 39900000.00, 17000000.00, 114, 6.3);
INSERT INTO `movies` (`Title`, `ReleaseYear`, `Genre`, `Rating`, `GrossProfit`, `Cost`, `Runtime`, `ReviewScore`) VALUES ('Training Day', 2001, 'Crime Thriller', 'R', 104900000.00, 45000000.00, 122, 7.7);
