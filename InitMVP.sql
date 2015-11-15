-- CREATE DATABASE IF NOT EXISTS ffcMVP;
-- 
-- USE ffcMVP;

CREATE TABLE Business (
	id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    address TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
);

CREATE TABLE Thank_You (
	id INT NOT NULL AUTO_INCREMENT,
	name VARCHAR(255),
	message TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	PRIMARY KEY (id)
);

CREATE TABLE Donation (
	id INT NOT NULL AUTO_INCREMENT,
	business_id INT,	
	doner_id INT,
	donation_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    FOREIGN KEY (business_id) REFERENCES Business(id)
);

CREATE TABLE Claim (
	id INT NOT NULL AUTO_INCREMENT,
    business_id INT NOT NULL,
    claim_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    FOREIGN KEY (business_id) REFERENCES Business(id)
);

CREATE TABLE Credentials (
    business_id INT NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (business_id) REFERENCES Business(id)
);

INSERT INTO Thank_You (name, message) VALUES 
	("Skrilly Daniels", "Toby Keith I Love this Bar and Grill"),
    ("Noah Rubin", "You suck"),
    ("Jackson Smith", "You're great"),
    ("Baird Howland", "We're gonna win RoHK"),
    ("Ishaan Javheri", "We're gonna make those homeless people happier than anyone else in this building could, Bonobos style.");

INSERT INTO Business (name, address) VALUES 
	("Dick's Barn Yard", "115 Suck Me Avenue Ithaca, NY 14850"),
    ("Model's", "26 Ridge Road Ithaca, NY 14850"),
    ("La Croix", "3 Tuxedo Drive Ithaca, NY 14850");

INSERT INTO Donation (business_id, doner_id) VALUES 
	(1, NULL),
    (1, NULL),
    (2, NULL),
    (2, NULL),
    (3, NULL);

INSERT INTO Claim (business_id) VALUES
	(1),
    (2),
    (3);

-- DROP TABLE IF EXISTS Thank_You;
-- DROP TABLE IF EXISTS Claim;
-- DROP TABLE IF EXISTS Business;
-- DROP TABLE IF EXISTS Donation;
-- DROP TABLE IF EXISTS Credentials;

SELECT * FROM Claim;