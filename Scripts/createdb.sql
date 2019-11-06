
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
  shift_state varchar(32),
  speed int,
  power int,
  heading int,
  longitude float,
  latitude float,
  gps_as_of double,
  native_location_supported int,
  native_latitude float,
  native_longitude float,
  native_type varchar(32),
  time_stamp double,
  created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id),
  FOREIGN KEY(id) REFERENCES vehicle(id) ON DELETE CASCADE
);

CREATE TABLE vehicle_config
(
 id int  NOT NULL AUTO_INCREMENT,
 can_accept_navigation_requests boolean,
 can_actuate_trunks boolean,
 car_special_type varchar(32),
 car_type varchar(32),
 charge_port_type varchar(8),
 eu_vehicle boolean,
 exterior_color varchar(32),
 has_air_suspension boolean,
 has_ludicrous_mode boolean,
 motorized_charge_port boolean,
 perf_config varchar(32),
 plg boolean,
 rear_seat_heaters int,
 rear_seat_type int,
 rhd boolean,
 roof_color varchar(32),
 seat_type int,
 spoiler_type varchar(32),
 sun_roof_installed int,
 third_row_seats varchar(32),
 time_stamp double,
 trim_badging varchar(32),
 wheel_type varchar(32),
 created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
 PRIMARY KEY (id),
 FOREIGN KEY(id) REFERENCES vehicle(id) ON DELETE CASCADE
);


^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

INSERT INTO `vehicle`
(vin,color,user_id,display_name)
VALUES(1111111111111,"black","jshiffler","black car");

INSERT INTO charge_state
(percent_charged)
VALUES(100);


INSERT INTO drive_state
(power, latitude,longitude,heading,gps_as_of,native_location_supported,native_latitude,
native_longitude,native_type,time_stamp)
VALUES(0, 40.459728, -79.923447,340, 1532927048,1,40.459728,-79.923447,"wgs",1532927316568);



INSERT INTO vehicle_config
(can_accept_navigation_requests ,can_actuate_trunks , car_special_type ,car_type ,
 charge_port_type ,eu_vehicle , exterior_color ,has_air_suspension , has_ludicrous_mode , motorized_charge_port ,
 perf_config , plg , rear_seat_heaters, rear_seat_type , rhd, roof_color , seat_type, spoiler_type , sun_roof_installed ,
 third_row_seats , time_stamp , trim_badging , wheel_type )

 VALUES(true,true,"base","modelx","US",false,"MetallicBlack",true,false,true,"P1",true,3,3,false,"None",0,"Passive",
 0,"FuturisFoldFlat",1558229319160,"90d","AeroTurbine20");

===============================

INSERT INTO `vehicle`
(vin,color,user_id,display_name)
VALUES(1111111111112,"purple","vshiffler","purple car");

INSERT INTO charge_state
(percent_charged)
VALUES(58);

INSERT INTO drive_state
(power, latitude,longitude,heading,gps_as_of,native_location_supported,native_latitude,
native_longitude,native_type,time_stamp)
VALUES(0, 40.459728, -79.923447,340, 1532927048,1,40.459728,-79.923447,"wgs",1532927316568);


INSERT INTO vehicle_config
(can_accept_navigation_requests ,can_actuate_trunks , car_special_type ,car_type ,
 charge_port_type ,eu_vehicle , exterior_color ,has_air_suspension , has_ludicrous_mode , motorized_charge_port ,
 perf_config , plg , rear_seat_heaters, rear_seat_type , rhd, roof_color , seat_type, spoiler_type , sun_roof_installed ,
 third_row_seats , time_stamp , trim_badging , wheel_type )

 VALUES(true,true,"base","modelx","US",false,"MetallicBlack",true,false,true,"P1",true,3,3,false,"None",0,"Passive",
 0,"FuturisFoldFlat",1558229319160,"90d","AeroTurbine20");

================================


INSERT INTO `vehicle`
(vin,color,user_id,display_name)
VALUES(1111111111113,"orange","gshiffler","orange car");

INSERT INTO charge_state
(percent_charged)
VALUES(99);


INSERT INTO drive_state
(power, latitude,longitude,heading,gps_as_of,native_location_supported,native_latitude,
native_longitude,native_type,time_stamp)
VALUES(0, 40.459728, -79.923447,340, 1532927048,1,40.459728,-79.923447,"wgs",1532927316568);

INSERT INTO vehicle_config
(can_accept_navigation_requests ,can_actuate_trunks , car_special_type ,car_type ,
 charge_port_type ,eu_vehicle , exterior_color ,has_air_suspension , has_ludicrous_mode , motorized_charge_port ,
 perf_config , plg , rear_seat_heaters, rear_seat_type , rhd, roof_color , seat_type, spoiler_type , sun_roof_installed ,
 third_row_seats , time_stamp , trim_badging , wheel_type )

 VALUES(true,true,"base","modelx","US",false,"MetallicBlack",true,false,true,"P1",true,3,3,false,"None",0,"Passive",
 0,"FuturisFoldFlat",1558229319160,"90d","AeroTurbine20");

===============================

INSERT INTO `vehicle`
(vin,color,user_id,display_name)
VALUES(1111111111114,"red","jmshiffler","red car");

INSERT INTO charge_state
(percent_charged)
VALUES(93);

INSERT INTO drive_state
(power, latitude,longitude,heading,gps_as_of,native_location_supported,native_latitude,
native_longitude,native_type,time_stamp)
VALUES(0, 40.459728, -79.923447,340, 1532927048,1,40.459728,-79.923447,"wgs",1532927316568);


INSERT INTO vehicle_config
(can_accept_navigation_requests ,can_actuate_trunks , car_special_type ,car_type ,
 charge_port_type ,eu_vehicle , exterior_color ,has_air_suspension , has_ludicrous_mode , motorized_charge_port ,
 perf_config , plg , rear_seat_heaters, rear_seat_type , rhd, roof_color , seat_type, spoiler_type , sun_roof_installed ,
 third_row_seats , time_stamp , trim_badging , wheel_type )

 VALUES(true,true,"base","modelx","US",false,"MetallicBlack",true,false,true,"P1",true,3,3,false,"None",0,"Passive",
 0,"FuturisFoldFlat",1558229319160,"90d","AeroTurbine20");

=========================================

INSERT INTO `vehicle`
(vin,color,user_id,display_name)
VALUES(1111111111114,"green","rshiffler","green car");

INSERT INTO charge_state
(percent_charged)
VALUES(64);


INSERT INTO drive_state
(power, latitude,longitude,heading,gps_as_of,native_location_supported,native_latitude,
native_longitude,native_type,time_stamp)
VALUES(0, 40.459728, -79.923447,340, 1532927048,1,40.459728,-79.923447,"wgs",1532927316568);


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




