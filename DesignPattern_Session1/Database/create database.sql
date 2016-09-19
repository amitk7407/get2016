/*Database Creation*/
CREATE DATABASE IF NOT EXISTS vehicle_details;
USE vehicle_details;

/*Table Creation*/
CREATE TABLE car(
CompanyName VARCHAR(30),
ModelName VARCHAR(30),
EngineInCC DECIMAL(5,2),
FuelCapacity DECIMAL(5,2),
Mileage DECIMAL(5,2),
Price DECIMAL(8,2),
RoadTax DECIMAL(3,2),
AC TINYINT(1),
PowerSteering TINYINT(1),
AccessoryKit TINYINT(1),
OnRoadPrice DECIMAL(8,2),

PRIMARY KEY(CompanyName, ModelName)
);