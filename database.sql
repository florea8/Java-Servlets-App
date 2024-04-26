CREATE DATABASE Reprezentanta;
USE Reprezentanta;
drop database Reprezentanta;


create table auto (
 id  int AUTO_INCREMENT NOT NULL,
 marca varchar(120) NOT NULL,
 model varchar(120) NOT NULL,
 detalii varchar(255) NOT NULL,
 pret varchar(10) NOT NULL,
 PRIMARY KEY (id)
);

select * from auto;
