CREATE TABLE Employee(
	  EmpID CHAR(12) NOT NULL,
    Name VARCHAR(100) NOT NULL, 
    DOB DATE, 
    Address VARCHAR(200), 
    PhoneNo CHAR(10), 
    Salary BIGINT NOT NULL, 
    Email VARCHAR(100),
    Gender CHAR(1),
    PRIMARY KEY(EmpID));

INSERT INTO Employee (EmpID,Name,DOB,Address,PhoneNo,Salary,Email,Gender)
VALUES
  (100000000001,"Charles Bridges","1978-11-14","Ap #927-8085 Velit Av.","2467236706",6837121,"magna@icloud.com","M"),
  (100000000002,"Darius Monroe","1996-04-04","Ap #666-1989 Pede Road","2757562234",9845541,"semper.nam@protonmail.ca","F"),
  (100000000003,"Rama Hunter","1980-07-07","Ap #302-4178 Elit, Road","8220836266",4575848,"vitae.orci@outlook.org","M"),
  (100000000004,"Jermaine Wilkins","2000-07-22","345-2872 Diam St.","0868278478",1237496,"malesuada@aol.org","F"),
  (100000000005,"Lawrence Clay","1990-07-25","643-5880 Eu Ave","1162171547",2788345,"arcu@yahoo.net","M"),
  (100000000006,"Amena Hunter","1976-03-02","9932 Parturient Road","8328227604",6544686,"laoreet.posuere@protonmail.net","F"),
  (100000000007,"Karly Orr","1988-12-06","8146 Dui, St.","6526165318",1907383,"amet@aol.ca","M"),
  (100000000008,"Branden Sloan","1996-11-11","Ap #385-8102 Lectus Street","3888113158",2971898,"donec.egestas.duis@google.edu","F"),
  (100000000009,"Eric Webb","1998-01-14","152-5786 Ac, Avenue","9526742764",3110806,"fames@icloud.couk","F"),
  (100000000010,"Patience Vega","1978-09-03","P.O. Box 149, 9882 Non St.","5458464550",9784332,"a.arcu@protonmail.net","F");
  (100000000011,"Amity Walls","1975-08-14","Ap #611-6081 Malesuada Av.","1348786863",1857992,"curae.phasellus@outlook.couk","M"),
  (100000000012,"Cally Mathews","1997-06-05","Ap #809-3522 Suspendisse St.","0636354637",5772138,"nisi.mauris.nulla@hotmail.couk","M"),
  (100000000013,"Quinlan Blankenship","2001-06-12","Ap #562-1989 Euismod Avenue","1521595685",6890439,"amet@aol.com","F"),
  (100000000014,"Willa Little","1978-08-05","Ap #481-1045 Ligula Street","3117534845",4976740,"consequat.purus@yahoo.edu","M"),
  (100000000015,"Lilah Mendez","1976-08-06","103-5779 Nibh Rd.","1113401184",4765123,"parturient.montes.nascetur@google.org","F"),
  (100000000016,"Stephen Lawrence","1996-06-05","7599 At Rd.","1435337582",6709495,"conubia@protonmail.edu","F"),
  (100000000017,"Alec Gates","1997-09-01","Ap #116-2747 Donec Rd.","2325713650",8911578,"amet@hotmail.com","M"),
  (100000000018,"Virginia Wagner","1989-07-06","724-8198 Vitae Street","2816586564",8367921,"cursus.a.enim@hotmail.com","F"),
  (100000000019,"Basil Herman","1998-05-31","Ap #320-950 A Road","1256869863",7356689,"nunc@hotmail.ca","M"),
  (100000000020,"Katell Manning","1987-05-08","P.O. Box 246, 2368 Vel, Av.","3568876456",8188532,"quisque.fringilla.euismod@yahoo.ca","M");
  (100000000021,"Armand Pollard","1989-08-23","319-7139 Libero. St.","7818813521",5493866,"adipiscing.fringilla.porttitor@yahoo.com","M"),
  (100000000022,"Ray Donaldson","1983-06-28","1606 Arcu Ave","6886775667",7282567,"posuere.cubilia@aol.edu","M"),
  (100000000023,"Len Andrews","1980-07-25","P.O. Box 885, 2302 Mollis. Ave","6245769211",5949070,"hendrerit@google.edu","M"),
  (100000000024,"Ciaran Mullen","1978-11-24","203-5390 Bibendum. Avenue","9038216318",7390618,"quis.accumsan.convallis@protonmail.org","M"),
  (100000000025,"Miriam Cooley","1982-10-15","P.O. Box 742, 5206 Velit Rd.","4358536211",2148257,"proin@google.net","M");
