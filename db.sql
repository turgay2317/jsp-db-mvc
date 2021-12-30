CREATE DATABASE `testdb`;

CREATE TABLE `users` (
  `userID` int NOT NULL AUTO_INCREMENT,
  `userName` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`userID`)
) ENGINE=InnoDB AUTO_INCREMENT=400 DEFAULT CHARSET=utf8mb3;

INSERT INTO `users` (`userID`,`userName`) VALUES (1,'Turgay Ceylan');
INSERT INTO `users` (`userID`,`userName`) VALUES (2,'John Doe');
INSERT INTO `users` (`userID`,`userName`) VALUES (3,'Peter Parker');
INSERT INTO `users` (`userID`,`userName`) VALUES (4,'Ben Parker');
INSERT INTO `users` (`userID`,`userName`) VALUES (300,'Serol Teber');
INSERT INTO `users` (`userID`,`userName`) VALUES (309,'Fyodor Dostoyevski');
