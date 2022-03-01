CREATE TABLE Rates(
	  Type VARCHAR(50),
    ROI FLOAT ,
    primary key(Type));

INSERT INTO Rates (Type,ROI)
VALUES
  ("Personal",9.25),
  ("Home",8.06),
  ("Car",7.20),
  ("Savings",2.22),
  ("Current",4.56);