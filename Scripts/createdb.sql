
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


CREATE TABLE vehicle_data

(
  id int  NOT NULL AUTO_INCREMENT,
  speed int ,
  running BOOLEAN,
  longitude varchar (32),
  latitude varchar(32),
  created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id)
);

INSERT INTO `vehicle`
(vin,color,user_id,display_name)
VALUES(1111111111111,"black","jshiffler","red car");

INSERT INTO `vehicle`
(vin,color,user_id,display_name)
VALUES(1111111111112,"purple","vshiffler","purple car");