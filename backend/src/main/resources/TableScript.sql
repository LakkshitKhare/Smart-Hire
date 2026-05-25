drop database if exists smart_hire;
create database smart_hire;
use smart_hire;

CREATE TABLE users (

    user_id BIGINT PRIMARY KEY not null auto_increment,

    name VARCHAR(255),

    email VARCHAR(255) not null,

    role ENUM('CANDIDATE','RECRUITER','ADMIN') not null,

    password_hash VARCHAR(255) not null,

    tel_number VARCHAR(20)

);