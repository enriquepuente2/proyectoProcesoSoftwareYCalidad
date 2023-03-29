/* DELETE 'productsDB' database*/
DROP SCHEMA IF EXISTS productsDB;
/* DELETE USER 'spq' AT LOCAL SERVER*/
DROP USER IF EXISTS 'spq'@'localhost';

/* CREATE 'productsDB' DATABASE */
CREATE SCHEMA productsDB;
/* CREATE THE USER 'spq' AT LOCAL SERVER WITH PASSWORD 'spq' */
CREATE USER IF NOT EXISTS 'spq'@'localhost' IDENTIFIED BY 'spq';

GRANT ALL ON productsDB.* TO 'spq'@'localhost';