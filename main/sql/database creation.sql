-- Dropping Tables --
/*
 SET FOREIGN_KEY_CHECKS=0;
DROP TABLE  ClientList;
DROP TABLE JobList;
DROP TABLE Partslist;
DROP TABLE finishedjobs;
 SET FOREIGN_KEY_CHECKS=1;
 */
-- Creating Tables --

CREATE TABLE ClientList(
ClientID		int				NOT NULL AUTO_INCREMENT,
First_Name    	varchar(20)	    NOT NULL,
Last_Name   	varchar(20)	    NOT NULL,
Phone     		varchar(15)    	NOT NULL,
Email     		varchar(50)	    NOT NULL,
Address   		varchar(50)	    NOT NULL,
PRIMARY KEY  (ClientID)
);

CREATE TABLE JobList(
JobID			int				NOT NULL AUTO_INCREMENT,
Make    		varchar(20)	    NOT NULL,
Model   		varchar(20)	    NOT NULL,
Year     		int,	    	
Type     		varchar(50)	    NOT NULL,
Issue   		varchar(200)	NOT NULL,
Start_Date   	date	    	NOT NULL,
ClientID		int				NOT NULL,
PRIMARY KEY  (JobID)
);

CREATE TABLE FinishedJobs(
JobID					int				NOT NULL,
ClientID				int				NOT NULL,
Start_Date   			date	    	NOT NULL,
End_Date   				date	    	NOT NULL,
Parts_Ordered			int				NOT NULL,
Total_Parts_Cost		double			NOT NULL,
Parts_Markup_Amount		double			NOT NULL,
Pickup_Delivery_Cost	double			NOT NULL,
Labor_Cost				double			NOT NULL,
Total_Amount_Owed		double			NOT NULL,
Payment_Status			boolean			NOT NULL,
PRIMARY KEY  (JobID, ClientID)
);

CREATE TABLE PartsList(
JobID			int				NOT NULL,
PartID			int				NOT NULL AUTO_INCREMENT,
PartName		varchar(50)		NOT NULL,
Cost			double			NOT NULL,
Quanity			int				NOT NULL,
DatePurchased 	date			NOT NULL,
PRIMARY KEY  (PartID)
);
-- Creating Primary Keys --
/*
ALTER TABLE ClientList               ADD (
CONSTRAINT client_pk             PRIMARY KEY (ClientID)
);

ALTER TABLE JobList               ADD (
CONSTRAINT job_pk             PRIMARY KEY (JobID)
);


ALTER TABLE PartsList               ADD (
CONSTRAINT parts_pk             PRIMARY KEY (JobID, PartID)
);

ALTER TABLE FinishedJobs               ADD (
CONSTRAINT finish_job_pk             PRIMARY KEY (JobID)
);
*/
-- Creating foreign Keys --

ALTER TABLE JobList               ADD (
CONSTRAINT job_client_fk           		FOREIGN KEY (ClientID)                   	REFERENCES ClientList(ClientID)
);

ALTER TABLE PartsList               ADD (
CONSTRAINT job_parts_fk           		FOREIGN KEY (JobID)                  	 	REFERENCES joblist(JobID)
);

ALTER TABLE FinishedJobs               ADD (
CONSTRAINT finished_client_fk           FOREIGN KEY (ClientID)                   	REFERENCES ClientList(ClientID),
CONSTRAINT finished_job_fk           	FOREIGN KEY (JobID)            				REFERENCES Joblist(JobID)

);
ALTER TABLE JobList					ADD COLUMN(
Complete boolean NOT NULL
);

/*

DELETE 
FROM ClientList
WHERE ClientID >0;

DELETE 
FROM joblist
WHERE JobID >0;

*/
SELECT *
FROM Joblist;


 
 /*
 INSERT INTO partslist (JobID, PartName, Cost, Quanity, DatePurchased)
SELECT JobID, "test", 50.25,1,'2022-01-02'
FROM JobList
WHERE JobID = 1;

SELECT sum(Cost) *1.05
FROM partslist
WHERE jobID =1;

SELECT j.jobID, j.Make, j.Model, count(p.PartID)"Parts Ordered", sum(p.Cost)"Parts Cost", sum(p.cost*.05)"Markup"
FROM joblist j
INNER JOIN partslist p
ON j.jobID = p.jobID
WHERE j.JobID = 2
GROUP BY JobID, Make, Model;

 SET FOREIGN_KEY_CHECKS=0;
delete
from clientlist
WHERE CLIENTID >4;


UPDATE finishedjobs
SET Payment_Status = FALSE
WHERE jobID >2;


SELECT *
FROM finishedJobs
WHERE payment_Status = TRUE;

SELECT round(sum(total_amount_owed) - sum(Total_parts_Cost),2)-(sum(Pickup_Delivery_Cost)/2) AS "Profit made"
FROM finishedjobs
WHERE payment_Status = TRUE AND MONTH(Start_Date) = 5 AND YEAR(Start_Date) = 2022;

DELETE FROM clientlist
WHERE ClientID >0;

DELETE FROM joblist
WHERE JobID>22;

DELETE FROM finishedjobs
WHERE JobID>0;

DELETE FROM partslist
WHERE PartID>0;



SELECT * 
FROM JobList;

SELECT * 
FROM clientList;

SELECT * 
FROM finishedjobs;

SELECT * 
FROM partsList;

SELECT *
FROM finishedjobs
WHERE Payment_Status = true;    

SELECT CURDATE();

INSERT INTO JobList  (Make, Model, Year, Type, Issue, Start_Date, ClientID) 
SELECT " make ", "  model  ", '1999' ,"ATV ","  issue  ",  '2022-06-30'  , '19' 
FROM  ClientList c 
INNER JOIN Joblist j 
WHERE c.First_Name = '' AND c.Last_Name = '' AND j.Start_date <= CURDATE();   


SHOW VARIABLES WHERE Variable_name = 'hostname';
SHOW VARIABLES WHERE Variable_name = 'port';
*/     





SELECT *
FROM Joblist;

SELECT *
FROM finishedjobs;

SELECT *
FROM clientlist;

SELECT *
FROM partslist;


/*

ALTER TABLE JobList					ADD COLUMN(
Complete boolean NOT NULL
);

INSERT INTO finishedjobs  (JobId, ClientID, Start_Date, End_Date, Parts_Ordered, Total_Parts_Cost, Parts_Markup_Amount, Pickup_Delivery_Cost, Labor_Cost, Total_Amount_Owed, Payment_Status)
 SELECT JobID, ClientID, Start_Date, '2022-09-01', '0','20.00', '4.00', '20.00', '350.00', '450.00', False
 FROM joblist
 WHERE JobID = '1';
 
 UPDATE joblist
 SET complete = true
 WHERE JobID = '1';

*/
