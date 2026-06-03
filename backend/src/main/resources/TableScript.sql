drop database if exists smart_hire;
create database smart_hire;
use smart_hire;

CREATE TABLE user (

    user_id BIGINT PRIMARY KEY not null auto_increment,

    name VARCHAR(255),

    email VARCHAR(255) not null,

    role ENUM('CANDIDATE','RECRUITER','ADMIN') not null,

    password VARCHAR(255) not null,

    mobile VARCHAR(20)

);

CREATE TABLE candidate_profile (

    profile_id BIGINT PRIMARY KEY AUTO_INCREMENT,

    full_name VARCHAR(255),

    mobile VARCHAR(20),

    email VARCHAR(255),

    location VARCHAR(255),

    linkedin_url VARCHAR(500),

    github_url VARCHAR(500),

    skills TEXT,

    experience_in_years INT,


    education TEXT,

    user_id BIGINT UNIQUE,

    CONSTRAINT fk_candidate_user
        FOREIGN KEY (user_id)
        REFERENCES user(user_id)

);

    CREATE TABLE resume (

        resume_id BIGINT PRIMARY KEY AUTO_INCREMENT,

        resume_name VARCHAR(255),

        resume_url VARCHAR(500),

        upload_time DATETIME,

        candidate_id BIGINT,

        CONSTRAINT fk_resume_candidate
            FOREIGN KEY (candidate_id)
            REFERENCES candidate_profile(profile_id)

            ON DELETE CASCADE

    );