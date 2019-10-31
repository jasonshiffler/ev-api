
drop database ev;
create database ev;

use ev;

CREATE TABLE vehicle
(
  id int  NOT NULL AUTO_INCREMENT,
  vin varchar(17),
  color varchar (32),
  user_id varchar (32),
  display_name varchar(32),
  created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id)

);

CREATE TABLE charge_state
(
  id int  NOT NULL AUTO_INCREMENT,
  percent_charged int,
  created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id),
  FOREIGN KEY(id) REFERENCES vehicle(id) ON DELETE CASCADE
);

CREATE TABLE drive_state
(
  id int  NOT NULL AUTO_INCREMENT,
  heading int,
  longitude float,
  latitude float,
  created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id),
  FOREIGN KEY(id) REFERENCES vehicle(id) ON DELETE CASCADE
);


INSERT INTO `vehicle`
(vin,color,user_id,display_name)
VALUES(1111111111111,"black","jshiffler","black car");

INSERT INTO charge_state
(percent_charged)
VALUES(100);

INSERT INTO drive_state
(heading, longitude, latitude)
VALUES(90,-76.125,36.8222);

****************************************8

INSERT INTO `vehicle`
(vin,color,user_id,display_name)
VALUES(1111111111112,"purple","vshiffler","purple car");

INSERT INTO `vehicle`
(vin,color,user_id,display_name)
VALUES(1111111111113,"red","vshiffler","purple car");

INSERT INTO `vehicle`
(vin,color,user_id,display_name)
VALUES(1111111111114,"green","vshiffler","purple car");

INSERT INTO `vehicle`
(vin,color,user_id,display_name)
VALUES(1111111111115,"yellow","vshiffler","purple car");

INSERT INTO `vehicle`
(vin,color,user_id,display_name)
VALUES(1111111111116,"orange","vshiffler","purple car");

INSERT INTO `vehicle`
(vin,color,user_id,display_name)
VALUES(1111111111117,"blue","vshiffler","purple car");

INSERT INTO `vehicle`
(vin,color,user_id,display_name)
VALUES(1111111111118,"mauve","vshiffler","purple car");

INSERT INTO `vehicle`
(vin,color,user_id,display_name)
VALUES(1111111111119,"pink","vshiffler","purple car");

INSERT INTO `vehicle`
(vin,color,user_id,display_name)
VALUES(1111111111120,"purple","vshiffler","purple car");

INSERT INTO `vehicle`
(vin,color,user_id,display_name)
VALUES(1111111111121,"purple","vshiffler","purple car");

INSERT INTO `vehicle`
(vin,color,user_id,display_name)
VALUES(1111111111122,"purple","vshiffler","purple car");

INSERT INTO `vehicle`
(vin,color,user_id,display_name)
VALUES(1111111111123,"purple","vshiffler","purple car");

INSERT INTO `vehicle`
(vin,color,user_id,display_name)
VALUES(1111111111124,"purple","vshiffler","purple car");

INSERT INTO `vehicle`
(vin,color,user_id,display_name)
VALUES(1111111111125,"purple","vshiffler","purple car");

INSERT INTO `vehicle`
(vin,color,user_id,display_name)
VALUES(1111111111126,"purple","vshiffler","purple car");




