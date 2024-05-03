create database gdse70;

use gdse70;

create table customer(
    id varchar(5) primary key,
    name varchar(255),
    address varchar(255),
    contact varchar(255),
    nic varchar(255),
    email varchar(255),
    salary varchar(255),
    age varchar(255)
);

INSERT INTO customer VALUES('C001', 'John', 'Panadura', '0771234567', '123456789V', 'N0XKg@example.com', '10000', '30'),
('C002', 'Jane', 'Gale', '0771234567', '123456789V', 'N0XKg@example.com', '10000', '30'),
('C003', 'Jim', 'Colombo', '0771234567', '123456789V', 'N0XKg@example.com', '10000', '30'),
('C004', 'Jill', 'Gale', '0771234567', '123456789V', 'N0XKg@example.com', '10000', '30');