CREATE TABLE test (
    id int PRIMARY KEY AUTO_INCREMENT,
    name varchar(10) NOT NULL,
    create_time timestamp NOT NULL,
    update_time timestamp DEFAULT NULL
);