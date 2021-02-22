INSERT INTO `company_types` VALUES (1,'Big company'),(2,'Small company'),(3,'Low cost'),(4,'Beginner company'),(5,'LowCost'),(6,'Starter');

INSERT INTO `air_companies` VALUES (1,2010,'Boss',5), (2,1950,'Astra',1), (3,1950,'PAN AM',1);

INSERT INTO `airplane_types` VALUES (1,'Big'),(2,'Small'),(3,'VIP'),(4,'CARRIAGE'),(5,'short distance');

INSERT INTO `airplanes` VALUES (1,2000,'fhdaj1y543',0,15156,'A320',0,1,1), (2,2020,'fajfkuy89738213',0,0,'K500',0,1,1), (3,2021,'fdafdf35yyhj56',0,0,'K500',0,1,1);

INSERT INTO `flight_statuses` VALUES (1,'PENDING'),(2,'ACTIVE'),(3,'DELAYED'),(4,'COMPLETED');

INSERT INTO `flights` VALUES (1,'2018-01-21 10:01:35',NULL,'Ukraine','Poland',500,NULL,56,NULL,1,2),(2,'2015-05-8 10:00:00',NULL,'Ukraine','India',1500,NULL,256,NULL,3,2);
INSERT INTO `flights` VALUES (3,'2017-02-18 10:00:00',NULL,'Ukraine','Germany',900,NULL,123,NULL,1,1),(4,'2010-08-7 10:00:00',NULL,'Ukraine','USA',2000,NULL,356,NULL,2,1);

INSERT INTO `flights_airplanes` VALUES (2,1);
