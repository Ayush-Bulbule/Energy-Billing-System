
-- Login Table -----
create table login(
meter_no varchar(20),
username varchar(30),
name varchar(30),
pass varchar(30),
usr varchar(30)
);

insert into login values('19007','ayushb','ayushbulbule','ayush_2413','admin');

-- Customer Table ----
create table customer(
 name varchar(30),
 meter varchar(20),
 address varchar(50),
 city varchar(20),
 state varchar(30),
 email varchar(30),
 phone varchar(20)
);

-- Meter Info Table ---
create table meter_info(
 meter_number varchar(20),
 meter_location varchar(20),
 meter_type varchar(20),
 phase_code varchar(20),
 bill_type varchar(20),
 days varchar(20)
);


--- Tax Table ---
create table tax(
 cost_per_unit varchar(20),
 meter_rent varchar(20),
 service_charge varchar(20),
 service_tax varchar(20),
 swacch_bharat_cess varchar(20),
 fixed_tax varchar(20)
);

---- Bill Table ---
create table bill(
 meter varchar(20),
 month varchar(20),
 units varchar(20),
 total_bill varchar(20),
 status varchar(20)
);