
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
  charging_state varchar(32),
  fast_charger_type varchar(32),
  fast_charger_brand varchar(32),
  charge_limit_soc int,
  charge_limit_soc_std int,
  charge_limit_soc_min int,
  charge_limit_soc_max int,
  charge_to_max_range boolean,
  max_range_charge_counter int,
  fast_charger_present boolean,
  battery_range float,
  est_battery_range float,
  ideal_battery_range float,
  battery_level int,
  usable_battery_level int,
  charge_energy_added float,
  charge_miles_added_rated float,
  charge_miles_added_ideal float,
  charger_voltage int,
  charger_pilot_current int,
  charger_actual_current int,
  charger_power int,
  time_to_full_charge float,
  trip_charging boolean,
  charge_rate float,
  charge_port_door_open boolean,
  conn_charge_cable varchar(32),
  scheduled_charging_start_time double,
  scheduled_charging_pending boolean,
  user_charge_enable_request boolean,
  charge_enable_request boolean,
  charger_phases int,
  charge_port_latch varchar(32),
  charge_current_request int,
  charge_current_request_max int,
  managed_charging_active boolean,
  managed_charging_user_canceled boolean,
  managed_charging_start_time double,
  battery_heater_on boolean,
  not_enough_power_to_heat boolean,
  time_stamp double,
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

INSERT INTO charge_state
(charging_state,
    fast_charger_type,
    fast_charger_brand,
    charge_limit_soc,
    charge_limit_soc_std,
    charge_limit_soc_min,
    charge_limit_soc_max,
    charge_to_max_range,
    max_range_charge_counter,
    fast_charger_present,
    battery_range,
    est_battery_range,
    ideal_battery_range,
    battery_level,
    usable_battery_level,
    charge_energy_added,
    charge_miles_added_rated,
    charge_miles_added_ideal,
    charger_voltage,
    charger_pilot_current,
    charger_actual_current,
    charger_power,
    time_to_full_charge,
    trip_charging,
    charge_rate,
    charge_port_door_open,
    conn_charge_cable,
    scheduled_charging_start_time,
    scheduled_charging_pending,
    user_charge_enable_request,
    charge_enable_request,
    charger_phases,
    charge_port_latch,
    charge_current_request,
    charge_current_request_max,
    managed_charging_active,
    managed_charging_user_canceled,
    managed_charging_start_time,
    battery_heater_on,
    not_enough_power_to_heat,
    time_stamp)

VALUES(
 "Complete",
     "\u003cinvalid\u003e",
   "\u003cinvalid\u003e",
     86,
     90,
     50,
    100,
    false,
     0,
     false,
     219.06,
     157.1,
     280.53,
     86,
   86,
    18.77,
     58.0,
   74.0,
     0,
     7,
     0,
    0,
     0.0,
     false,
   0.0,
    true,
     "SAE",
     null,
     false,
     null,
     true,
     null,
     "Engaged",
    7,
     7,
     false,
     false,
     null,
    false,
     false,
   1532915238524

);


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




