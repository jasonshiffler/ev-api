
drop database ev;
create database ev;

use ev;

create TABLE vehicle
(
  id int  NOT NULL AUTO_INCREMENT,
  user_id varchar (32),
  vehicle_id bigint,
  vin varchar(17),
  display_name varchar(32),
  option_codes varchar(256),
  color varchar(32),
  state varchar(32),
  in_service boolean,
  id_s varchar(32),
  calendar_enabled boolean,
  backseat_token varchar(32),
  backseat_token_updated_at TIMESTAMP,
  created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id)
);

create TABLE token
(
  id int  NOT NULL AUTO_INCREMENT,
  token_name varchar (32),
  vehicle_id int,
  created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id),
  FOREIGN KEY(vehicle_id) REFERENCES vehicle(id) ON delete CASCADE

);

create TABLE charge_state
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
  time_stamp bigint,
  created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id),
  FOREIGN KEY(id) REFERENCES vehicle(id) ON delete CASCADE
);

create TABLE drive_state
(
  id int  NOT NULL AUTO_INCREMENT,
  shift_state varchar(32),
  speed int,
  power int,
  heading int,
  longitude float,
  latitude float,
  gps_as_of bigint,
  native_location_supported int,
  native_latitude float,
  native_longitude float,
  native_type varchar(32),
  time_stamp bigint,
  created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id),
  FOREIGN KEY(id) REFERENCES vehicle(id) ON delete CASCADE
);

create TABLE vehicle_config
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
 time_stamp bigint,
 trim_badging varchar(32),
 wheel_type varchar(32),
 created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
 PRIMARY KEY (id),
 FOREIGN KEY(id) REFERENCES vehicle(id) ON delete CASCADE
);

create TABLE climate_state
(
 id int  NOT NULL AUTO_INCREMENT,
    inside_temp float,
    outside_temp float,
    driver_temp_setting float,
    passenger_temp_setting float,
    left_temp_direction varchar(32),
    right_temp_direction varchar(32),
    is_front_defroster_on boolean,
    is_rear_defroster_on boolean,
    fan_status int,
    is_climate_on boolean,
    min_avail_temp float,
    max_avail_temp float,
    seat_heater_left boolean,
    seat_heater_right boolean,
    seat_heater_rear_left boolean,
    seat_heater_rear_right boolean,
    seat_heater_rear_center boolean,
    seat_heater_rear_right_back int,
    seat_heater_rear_left_back int,
    battery_heater boolean,
    battery_heater_no_power boolean,
    steering_wheel_heater boolean,
    wiper_blade_heater boolean,
    side_mirror_heaters boolean,
    is_preconditioning boolean,
    smart_preconditioning boolean,
    is_auto_conditioning_on boolean,
    time_stamp bigint,
 created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
 PRIMARY KEY (id),
 FOREIGN KEY(id) REFERENCES vehicle(id) ON delete CASCADE
);

create table gui_settings(
  id int  NOT NULL AUTO_INCREMENT,
  gui_distance_units varchar(8),
  gui_temperature_units varchar(8),
  gui_charge_rate_units varchar(8),
  gui_24_hour_time boolean,
  gui_range_display varchar(32),
  time_stamp bigint,
  created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id),
  FOREIGN KEY(id) REFERENCES vehicle(id) ON delete CASCADE
);

create table vehicle_state(
  id int  NOT NULL AUTO_INCREMENT,
  api_version int,
  autopark_state_v2 varchar(32),
  autopark_style varchar(32),
  calendar_supported boolean,
  car_version varchar(32),
  center_display_state int,
  df int,
  dr int,
  ft int,
  homelink_nearby boolean,
  is_user_present boolean,
  last_autopark_error varchar(32),
  locked boolean,
  notifications_supported boolean,
  odometer float,
  parsed_calendar_supported boolean,
  pf int,
  pr int,
  remote_start boolean,
  remote_start_enabled boolean,
  remote_start_supported boolean,
  rt int,
  sentry_mode boolean,
  sun_roof_percent_open int,
  sun_roof_state varchar(32),
  time_stamp bigint,
  valet_mode boolean,
  vehicle_name varchar(64),
  PRIMARY KEY (id),
  FOREIGN KEY(id) REFERENCES vehicle(id) ON delete CASCADE
);


create table users(
    username varchar(50) not null primary key,
    password varchar(100) not null,
    enabled boolean not null
);

create table authorities (
    username varchar(50) not null,
    authority varchar(100) not null,
    constraint fk_authorities_users foreign key(username) references users(username)
);




^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

insert into users
(username,password,enabled)
values ("jshiffler","{bcrypt}$2a$10$tNUnHT4to9DF6wt.Zj6TyOdDZDCAGmAcPQjdfHLTHmu1yMFNFUIoS",true);

insert into authorities
(username,authority)
values ("jshiffler","ROLE_USER");


insert into users
(username,password,enabled)
values ("vshiffler","{bcrypt}$2a$10$tNUnHT4to9DF6wt.Zj6TyOdDZDCAGmAcPQjdfHLTHmu1yMFNFUIoS",true);

insert into authorities
(username,authority)
values ("vshiffler","ROLE_USER");


insert into `vehicle`
(vin,color,user_id,display_name,option_codes,vehicle_id,state,in_service,id_s,calendar_enabled,backseat_token,backseat_token_updated_at)
VALUES(1111111111111,"black","jshiffler","black car", "AD15,AF02,AH00",120323439,"online",null,"ids",true,null,null);


insert into `token`
(token_name, vehicle_id)
VALUES("token1", 1);

insert into `token`
(token_name, vehicle_id)
VALUES("token2", 1);

insert into drive_state
(power, latitude,longitude,heading,gps_as_of,native_location_supported,native_latitude,
native_longitude,native_type,time_stamp)

values(0, 40.459728, -79.923447,340, 1532927048,1,40.459728,-79.923447,"wgs",1532927316568);


insert into vehicle_config
(can_accept_navigation_requests ,can_actuate_trunks , car_special_type ,car_type ,
 charge_port_type ,eu_vehicle , exterior_color ,has_air_suspension , has_ludicrous_mode , motorized_charge_port ,
 perf_config , plg , rear_seat_heaters, rear_seat_type , rhd, roof_color , seat_type, spoiler_type , sun_roof_installed ,
 third_row_seats , time_stamp , trim_badging , wheel_type )

 values(true,true,"base","modelx","US",false,"MetallicBlack",true,false,true,"P1",true,3,3,false,"None",0,"Passive",
 0,"FuturisFoldFlat",1558229319160,"90d","AeroTurbine20");

insert into charge_state
(charging_state,fast_charger_type,fast_charger_brand,charge_limit_soc,charge_limit_soc_std,charge_limit_soc_min,
    charge_limit_soc_max, charge_to_max_range, max_range_charge_counter, fast_charger_present, battery_range,
    est_battery_range, ideal_battery_range, battery_level, usable_battery_level, charge_energy_added,
     charge_miles_added_rated, charge_miles_added_ideal, charger_voltage, charger_pilot_current, charger_actual_current,
    charger_power, time_to_full_charge,trip_charging,charge_rate, charge_port_door_open,conn_charge_cable,
    scheduled_charging_start_time, scheduled_charging_pending, user_charge_enable_request, charge_enable_request,
    charger_phases, charge_port_latch, charge_current_request, charge_current_request_max, managed_charging_active,
    managed_charging_user_canceled, managed_charging_start_time, battery_heater_on,not_enough_power_to_heat,
    time_stamp)

values(
 "Complete", "\u003cinvalid\u003e", "\u003cinvalid\u003e",  86, 90, 50, 100, false, 0, false, 219.06, 157.1, 280.53,
     86, 86, 18.77, 58.0, 74.0, 0, 7, 0, 0, 0.0, false, 0.0, true,"SAE", null, false, null, true, null, "Engaged",
    7, 7, false, false, null, false, false, 1532915238524);


insert into climate_state(inside_temp, outside_temp, driver_temp_setting , passenger_temp_setting , left_temp_direction , right_temp_direction ,
    is_front_defroster_on ,is_rear_defroster_on , fan_status ,is_climate_on , min_avail_temp ,max_avail_temp , seat_heater_left , seat_heater_right ,
    seat_heater_rear_left , seat_heater_rear_right ,seat_heater_rear_center , seat_heater_rear_right_back ,seat_heater_rear_left_back ,  battery_heater ,
    battery_heater_no_power , steering_wheel_heater , wiper_blade_heater , side_mirror_heaters , is_preconditioning , smart_preconditioning ,    is_auto_conditioning_on ,  time_stamp)

values( null,null, 18.3,18.3, null, null, false, false, 0, false, 15.0, 28.0, false, false, false,false, false, 0,0,
      false, null, false,false,false, false,false, null,1532926836621);

insert into gui_settings(gui_24_hour_time,gui_charge_rate_units,gui_distance_units,gui_range_display,gui_temperature_units,time_stamp)
values(false,"mi/hr","mi/hr","Rated","F",1558229319160)


insert into vehicle_state(api_version, autopark_state_v2, autopark_style, calendar_supported, car_version ,
  center_display_state, df, dr , ft , homelink_nearby, is_user_present, last_autopark_error , locked ,
   notifications_supported, odometer, parsed_calendar_supported, pf, pr, remote_start, remote_start_enabled,
  remote_start_supported, rt, sentry_mode, sun_roof_percent_open, sun_roof_state, time_stamp, valet_mode,
  vehicle_name)


===============================

insert into `vehicle`
(vin,color,user_id,display_name)
VALUES(1111111111112,"purple","vshiffler","purple car");


insert into drive_state
(power, latitude,longitude,heading,gps_as_of,native_location_supported,native_latitude,
native_longitude,native_type,time_stamp)
values(0, 40.459728, -79.923447,340, 1532927048,1,40.459728,-79.923447,"wgs",1532927316568);


insert into vehicle_config
(can_accept_navigation_requests ,can_actuate_trunks , car_special_type ,car_type ,
 charge_port_type ,eu_vehicle , exterior_color ,has_air_suspension , has_ludicrous_mode , motorized_charge_port ,
 perf_config , plg , rear_seat_heaters, rear_seat_type , rhd, roof_color , seat_type, spoiler_type , sun_roof_installed ,
 third_row_seats , time_stamp , trim_badging , wheel_type )

 values(true,true,"base","modelx","US",false,"MetallicPurple",true,false,true,"P1",true,3,3,false,"None",0,"Passive",
 0,"FuturisFoldFlat",1558229319160,"90d","AeroTurbine20");

 insert into charge_state
(charging_state,fast_charger_type,fast_charger_brand,charge_limit_soc,charge_limit_soc_std,charge_limit_soc_min,
    charge_limit_soc_max, charge_to_max_range, max_range_charge_counter, fast_charger_present, battery_range,
    est_battery_range, ideal_battery_range, battery_level, usable_battery_level, charge_energy_added,
     charge_miles_added_rated, charge_miles_added_ideal, charger_voltage, charger_pilot_current, charger_actual_current,
    charger_power, time_to_full_charge,trip_charging,charge_rate, charge_port_door_open,conn_charge_cable,
    scheduled_charging_start_time, scheduled_charging_pending, user_charge_enable_request, charge_enable_request,
    charger_phases, charge_port_latch, charge_current_request, charge_current_request_max, managed_charging_active,
    managed_charging_user_canceled, managed_charging_start_time, battery_heater_on,not_enough_power_to_heat,
    time_stamp)

values(
 "Complete", "\u003cinvalid\u003e", "\u003cinvalid\u003e",  86, 90, 50, 100, false, 0, false, 219.06, 157.1, 280.53,
     86, 86, 18.77, 58.0, 74.0, 0, 7, 0, 0, 0.0, false, 0.0, true,"SAE", null, false, null, true, null, "Engaged",
    7, 7, false, false, null, false, false, 1532915238524);


================================


insert into `vehicle`
(vin,color,user_id,display_name)
VALUES(1111111111113,"orange","gshiffler","orange car");


insert into drive_state
(power, latitude,longitude,heading,gps_as_of,native_location_supported,native_latitude,
native_longitude,native_type,time_stamp)
values(0, 40.459728, -79.923447,340, 1532927048,1,40.459728,-79.923447,"wgs",1532927316568);

insert into vehicle_config
(can_accept_navigation_requests ,can_actuate_trunks , car_special_type ,car_type ,
 charge_port_type ,eu_vehicle , exterior_color ,has_air_suspension , has_ludicrous_mode , motorized_charge_port ,
 perf_config , plg , rear_seat_heaters, rear_seat_type , rhd, roof_color , seat_type, spoiler_type , sun_roof_installed ,
 third_row_seats , time_stamp , trim_badging , wheel_type )

 values(true,true,"base","modelx","US",false,"MetallicOrange",true,false,true,"P1",true,3,3,false,"None",0,"Passive",
 0,"FuturisFoldFlat",1558229319160,"90d","AeroTurbine20");

 insert into charge_state
(charging_state,fast_charger_type,fast_charger_brand,charge_limit_soc,charge_limit_soc_std,charge_limit_soc_min,
    charge_limit_soc_max, charge_to_max_range, max_range_charge_counter, fast_charger_present, battery_range,
    est_battery_range, ideal_battery_range, battery_level, usable_battery_level, charge_energy_added,
     charge_miles_added_rated, charge_miles_added_ideal, charger_voltage, charger_pilot_current, charger_actual_current,
    charger_power, time_to_full_charge,trip_charging,charge_rate, charge_port_door_open,conn_charge_cable,
    scheduled_charging_start_time, scheduled_charging_pending, user_charge_enable_request, charge_enable_request,
    charger_phases, charge_port_latch, charge_current_request, charge_current_request_max, managed_charging_active,
    managed_charging_user_canceled, managed_charging_start_time, battery_heater_on,not_enough_power_to_heat,
    time_stamp)

values(
 "Complete", "\u003cinvalid\u003e", "\u003cinvalid\u003e",  86, 90, 50, 100, false, 0, false, 219.06, 157.1, 280.53,
     86, 86, 18.77, 58.0, 74.0, 0, 7, 0, 0, 0.0, false, 0.0, true,"SAE", null, false, null, true, null, "Engaged",
    7, 7, false, false, null, false, false, 1532915238524);


===============================

insert into `vehicle`
(vin,color,user_id,display_name)
VALUES(1111111111114,"red","jmshiffler","red car");

insert into drive_state
(power, latitude,longitude,heading,gps_as_of,native_location_supported,native_latitude,
native_longitude,native_type,time_stamp)
values(0, 40.459728, -79.923447,340, 1532927048,1,40.459728,-79.923447,"wgs",1532927316568);


insert into vehicle_config
(can_accept_navigation_requests ,can_actuate_trunks , car_special_type ,car_type ,
 charge_port_type ,eu_vehicle , exterior_color ,has_air_suspension , has_ludicrous_mode , motorized_charge_port ,
 perf_config , plg , rear_seat_heaters, rear_seat_type , rhd, roof_color , seat_type, spoiler_type , sun_roof_installed ,
 third_row_seats , time_stamp , trim_badging , wheel_type )

 values(true,true,"base","modelx","US",false,"CherryRed",true,false,true,"P1",true,3,3,false,"None",0,"Passive",
 0,"FuturisFoldFlat",1558229319160,"90d","AeroTurbine20");


insert into charge_state
(charging_state,fast_charger_type,fast_charger_brand,charge_limit_soc,charge_limit_soc_std,charge_limit_soc_min,
    charge_limit_soc_max, charge_to_max_range, max_range_charge_counter, fast_charger_present, battery_range,
    est_battery_range, ideal_battery_range, battery_level, usable_battery_level, charge_energy_added,
     charge_miles_added_rated, charge_miles_added_ideal, charger_voltage, charger_pilot_current, charger_actual_current,
    charger_power, time_to_full_charge,trip_charging,charge_rate, charge_port_door_open,conn_charge_cable,
    scheduled_charging_start_time, scheduled_charging_pending, user_charge_enable_request, charge_enable_request,
    charger_phases, charge_port_latch, charge_current_request, charge_current_request_max, managed_charging_active,
    managed_charging_user_canceled, managed_charging_start_time, battery_heater_on,not_enough_power_to_heat,
    time_stamp)

values(
 "Complete", "\u003cinvalid\u003e", "\u003cinvalid\u003e",  86, 90, 50, 100, false, 0, false, 219.06, 157.1, 280.53,
     86, 86, 18.77, 58.0, 74.0, 0, 7, 0, 0, 0.0, false, 0.0, true,"SAE", null, false, null, true, null, "Engaged",
    7, 7, false, false, null, false, false, 1532915238524);

=========================================

insert into `vehicle`
(vin,color,user_id,display_name)
VALUES(1111111111114,"green","rshiffler","green car");


insert into drive_state
(power, latitude,longitude,heading,gps_as_of,native_location_supported,native_latitude,
native_longitude,native_type,time_stamp)
values(0, 40.459728, -79.923447,340, 1532927048,1,40.459728,-79.923447,"wgs",1532927316568);

insert into charge_state
(charging_state,fast_charger_type,fast_charger_brand,charge_limit_soc,charge_limit_soc_std,charge_limit_soc_min,
    charge_limit_soc_max, charge_to_max_range, max_range_charge_counter, fast_charger_present, battery_range,
    est_battery_range, ideal_battery_range, battery_level, usable_battery_level, charge_energy_added,
     charge_miles_added_rated, charge_miles_added_ideal, charger_voltage, charger_pilot_current, charger_actual_current,
    charger_power, time_to_full_charge,trip_charging,charge_rate, charge_port_door_open,conn_charge_cable,
    scheduled_charging_start_time, scheduled_charging_pending, user_charge_enable_request, charge_enable_request,
    charger_phases, charge_port_latch, charge_current_request, charge_current_request_max, managed_charging_active,
    managed_charging_user_canceled, managed_charging_start_time, battery_heater_on,not_enough_power_to_heat,
    time_stamp)

values(
 "Complete", "\u003cinvalid\u003e", "\u003cinvalid\u003e",  86, 90, 50, 100, false, 0, false, 219.06, 157.1, 280.53,
     86, 86, 18.77, 58.0, 74.0, 0, 7, 0, 0, 0.0, false, 0.0, true,"SAE", null, false, null, true, null, "Engaged",
    7, 7, false, false, null, false, false, 1532915238524);


****************************************8

insert into `vehicle`
(vin,color,user_id,display_name)
VALUES(1111111111112,"purple","vshiffler","purple car");

insert into `vehicle`
(vin,color,user_id,display_name)
VALUES(1111111111113,"red","vshiffler","purple car");

insert into `vehicle`
(vin,color,user_id,display_name)
VALUES(1111111111114,"green","vshiffler","purple car");

insert into `vehicle`
(vin,color,user_id,display_name)
VALUES(1111111111115,"yellow","vshiffler","purple car");

insert into `vehicle`
(vin,color,user_id,display_name)
VALUES(1111111111116,"orange","vshiffler","purple car");

insert into `vehicle`
(vin,color,user_id,display_name)
VALUES(1111111111117,"blue","vshiffler","purple car");

insert into `vehicle`
(vin,color,user_id,display_name)
VALUES(1111111111118,"mauve","vshiffler","purple car");

insert into `vehicle`
(vin,color,user_id,display_name)
VALUES(1111111111119,"pink","vshiffler","purple car");

insert into `vehicle`
(vin,color,user_id,display_name)
VALUES(1111111111120,"purple","vshiffler","purple car");

insert into `vehicle`
(vin,color,user_id,display_name)
VALUES(1111111111121,"purple","vshiffler","purple car");

insert into `vehicle`
(vin,color,user_id,display_name)
VALUES(1111111111122,"purple","vshiffler","purple car");

insert into `vehicle`
(vin,color,user_id,display_name)
VALUES(1111111111123,"purple","vshiffler","purple car");

insert into `vehicle`
(vin,color,user_id,display_name)
VALUES(1111111111124,"purple","vshiffler","purple car");

insert into `vehicle`
(vin,color,user_id,display_name)
VALUES(1111111111125,"purple","vshiffler","purple car");

insert into `vehicle`
(vin,color,user_id,display_name)
VALUES(1111111111126,"purple","vshiffler","purple car");




