
/*
 SET FOREIGN_KEY_CHECKS=0;
 SET FOREIGN_KEY_CHECKS=1;
DROP TABLE Customers;
DROP TABLE Sales;
DROP TABLE Flock;
DROP TABLE Pricing;
DROP TABLE Expenses;
DROP TABLE ChickenBreeds
*/



CREATE TABLE ChickenBreeds(
BreedID			int				NOT NULL AUTO_INCREMENT,
Breed_Name		varchar(50)		NOT NULL,
Egg_Color		varchar(20)		NOT NULL,
PRIMARY KEY  (BreedID)
);

CREATE TABLE Customers(
CustomerID		int				NOT NULL AUTO_INCREMENT,
First_Name    	varchar(20)	    NOT NULL,
Last_Name   	varchar(20)	    NOT NULL,
Phone     		varchar(15)    	NOT NULL,
PRIMARY KEY  (CustomerID)
);

CREATE TABLE Sales(
SaleID					int				NOT NULL AUTO_INCREMENT,
PriceID					int				NOT NULL,
CustomerID				int				NOT NULL,
Hatching_Eggs			int				NOT NULL,
Pullets					int				NOT NULL,
Chicks					int				NOT NULL,
Eating_Eggs12			int				NOT NULL,
Eating_Eggs6			int				NOT NULL,
Date_Sold   			date	    	NOT NULL,
PRIMARY KEY  (SaleID)
);

CREATE TABLE Flock(
FlockID					int				NOT NULL AUTO_INCREMENT,
BreedID					int				NOT NULL,
Breed					varchar(50)		NOT NULL,
Egg_Color				varchar(50)		NOT NULL,
Hens					int				NOT NULL,
Roosters				int				NOT NULL,
Hatch_Date   			varchar(500)	NOT NULL,
Group_Ended				bool			NOT NULL,
PRIMARY KEY  (FlockID)
);

CREATE TABLE Pricing(
PriceID					int				NOT NULL AUTO_INCREMENT,
FlockID					int				NOT NULL,
Hatching_Eggs			double			NOT NULL,
Pullets					double			NOT NULL,
Chicks					double			NOT NULL,
Eating_Eggs12			double			NOT NULL,
Eating_Eggs6			double			NOT NULL,
PRIMARY KEY  (PriceID)
);

CREATE TABLE Expenses (
ExpenseID				int				NOT NULL AUTO_INCREMENT,
Type					varchar(50)		NOT NULL,
Item_Name				varchar(50)		NOT NULL,
Cost					double			NOT NULL,
Date_Purchased   		date			NOT NULL,
PRIMARY KEY  (ExpenseID)
);

/*
INSERT INTO Sales (PriceID, CustomerID, Hatching_Eggs, Pullets, Chicks, Eating_Eggs12, Eating_Eggs6, Date_Sold)
VALUES (;
*/

SELECT sum(cost)
FROM expenses
WHERE type = 'gas';




ALTER TABLE Sales               ADD (
CONSTRAINT sale_price_fk           		FOREIGN KEY (PriceID)                   	REFERENCES Pricing(PriceID),
CONSTRAINT sale_customer_fk           	FOREIGN KEY (CustomerID)                   	REFERENCES Customers(CustomerID)
);

ALTER TABLE Flock               ADD (
CONSTRAINT flock_breed_fk           	FOREIGN KEY (BreedID)                   	REFERENCES ChickenBreeds(BreedID)
);

ALTER TABLE Pricing              ADD (
CONSTRAINT price_flock_fk           	FOREIGN KEY (FlockID)                   	REFERENCES Flock(FlockID)
);



/*
DELETE  
FROM Customers
WHERE CustomerID>0;

DELETE  
FROM Sales
WHERE SaleID>0;

DELETE  
FROM Prices
WHERE PriceID>0;

DELETE  
FROM Expenses
WHERE ExpenseID>0;

DELETE  
FROM Flock
WHERE FlockID>0;
*/


/*
SELECT *
FROM Customers;

SELECT *
FROM Pricing;

SELECT *
FROM Sales;

SELECT *
FROM Flock;

SELECT *
FROM Expenses;

SELECT *
FROM ChickenBreeds;

SELECT * 
FROM ChickenBreeds 
ORDER BY breed_Name asc;

*/
/*SELECT sum(p.Hatching_Eggs * s.Hatching_Eggs) +sum(p.Pullets * s.Pullets) + sum(p.Chicks * s.Chicks) + sum(p.Eating_Eggs12 * s.Eating_Eggs12) + sum(p.Eating_Eggs6 * s.Eating_Eggs6) AS "Total Cost"*/

SELECT sum(p.Hatching_Eggs * s.Hatching_Eggs)
FROM Flock f 
INNER JOIN Pricing p
ON f.flockID = p.flockID
INNER JOIN Sales s
ON s.PriceID = p.PriceID
WHERE s.Date_Sold between '2022-8-31' AND '2022-8-31';

SELECT *
FROM Flock f 
INNER JOIN Pricing p
ON f.flockID = p.flockID
INNER JOIN Sales s
ON s.PriceID = p.PriceID
WHERE s.Date_Sold between '2022-01-01' AND '2022-12-12';




/*
DELETE
FROM ChickenBreeds
WHERE breedID > 50;

DELETE
FROM Sales
WHERE SaleID > 0;

DELETE
FROM Customers
WHERE CustomerID >0;

DELETE
FROM Expenses
WHERE ExpenseID = 53;

DELETE
FROM Prices
WHERE PriceID = 53;

DELETE
FROM Flock
WHERE FlockID >0;
*/





/*
INSERT INTO ChickenBreeds(Breed_Name, Egg_Color)
VALUES 
("Blue Laced Red Wyandotte","Brown") ,
("Blue Andalusian","White"),
("Ancona","White"),
("White Leghorn","White"),
("Minorca","White"),
("Silver Spangled Hamburg","White"),
("Buttercup","Brown"),
("Crevecoeur","Brown"),
("Cuckoo Marans","Brown"),
("Dominique","Brown"),
("Egyptian Fayoumis","Brown"),
("Golden Campine","Brown"),
("Golden Laced Wyandotte","Brown"),
("Golden Penciled Hamburg","Brown"),
("Lakenvelder","Brown"),
("Modern BB Red Game","Brown"),
("Phoenix","Brown"),
("Redcap","Brown"),
("Red Shouldered Yokohama","Brown"),
("Silver Gray Dorking","Brown"),
("Silver Leghorn","Brown"),
("Silver Penciled Plymouth Rock","Brown"),
("Sultan","Brown"),
("Sumatra","Brown"),
("Welsummer","Brown"),
("White Faced Black Spanish","Brown"),
("White Laced Red Cornish","Brown"),
("American Bresse","Brown"),
("Australorp","Brown"),
("Bielefelder","Brown"),
("Cornish","Brown"),
("Delaware","Brown"),
("French Black Copper Marans","Brown"),
("Jersey Giant","Brown"),
("Lavender Orpington","Brown"),
("Blue Orpington","Brown"),
("Black Orpington","Brown"),
("White Orpington","Brown"),
("Buff Orpington","Brown"),
("Plymouth Rock","Brown"),
("Naked Neck 'Turken'","Brown"),
("New Hampshire Red","Brown"),
("Niederrheiner","Brown"),
("Rhode Island Red","Brown"),
("Sex-Link","Brown"),
("Speckled Sussex","Brown"),
("Light Sussex","Brown"),
("Corination Sussex","Brown"),
("White Marans","Brown"),
("Wyandotte","Brown")
;

UPDATE chickenBreeds
SET egg_color
= upper(egg_color)
WHERE breedID>0;

UPDATE chickenBreeds
SET breed_Name
= upper(breed_Name)
WHERE breedID>0;
*/
UPDATE Flock
SET 
Hens = 5,
Roosters = 5,
Hatch_Date = concat(hatch_date, ', 2022-08-16') 
WHERE flockID=2;




