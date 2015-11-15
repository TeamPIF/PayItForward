-- CREATE DATABASE IF NOT EXISTS ffcMVP;
-- 
-- USE ffcMVP;

CREATE TABLE Thank_You (
	id INT NOT NULL AUTO_INCREMENT,
	name VARCHAR(255),
	message TEXT,
	PRIMARY KEY (id)
);

CREATE TABLE Donation (
	id INT NOT NULL AUTO_INCREMENT,
	business_id INT,	
	doner_id INT,
	donation_time TIMESTAMP,
    PRIMARY KEY (id),
    FOREIGN KEY (business_id) REFERENCES Business(id)
);

CREATE TABLE Claim (
	id INT NOT NULL AUTO_INCREMENT,
    business_id INT NOT NULL,
    claim_time TIMESTAMP,
    PRIMARY KEY (id),
    FOREIGN KEY (business_id) REFERENCES Business(id)
);

CREATE TABLE Business (
	id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    address TEXT,
    PRIMARY KEY (id)
);

CREATE TABLE Credentials (
    business_id INT NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    FOREIGN KEY (business_id) REFERENCES Business(id)
);

INSERT INTO Thank_You (id, name, message) VALUES 
	(1, "Skrilly Daniels", "Toby Keith I Love this Bar and Grill"),
    (2, "Noah Rubin", "You suck"),
    (3, "Jackson Smith", "You're great"),
    (4, "Baird Howland", "We're gonna win RoHK"),
    (5, "Ishaan Javheri", "We're gonna make those homeless people happier than anyone else in this building could, Bonobos style.");



-- DROP TABLE Thank_You;-- 

