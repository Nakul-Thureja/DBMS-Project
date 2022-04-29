create database bankingv2
Use BankingV2;
CREATE TABLE Customer(
	CID BIGINT,
    Pass INT,
    AadharNo CHAR(12) NOT NULL,
    PanNo CHAR(10) NOT NULL,
    Name VARCHAR(100) NOT NULL,
  	DOB DATE,
    Address VARCHAR(200),
    PhoneNo char(10) NOT NULL, 
    Email VARCHAR(100) NOT NULL, 
    Gender char(1),
    primary key(CID));

GO  
CREATE TRIGGER login_create ON Customer
AFTER INSERT
AS
BEGIN
    SET NOCOUNT ON;
	DECLARE
		@SQL nvarchar(MAX),
		@Username nchar(20),
		@Password nchar(4)
	SELECT @Username = INSERTED.[CID], @Password = INSERTED.[pass] FROM INSERTED
	print 'U'+@Username
	print ''''+@Password+''''
	SET @SQL = 'CREATE LOGIN U' + @Username + ' WITH PASSWORD = '''+@Password+''', CHECK_EXPIRATION = OFF';
	EXECUTE(@SQL);
	SET @SQL = 'CREATE User U' + @Username + ' for login U'+ @Username;
	EXECUTE(@SQL)
END

INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender) VALUES
  (1000000001,1101,877330152157,9227452219,'Orla Jana','1988-12-02','163-4567 Sed Av.',6956113830,'orlajana7733@aol.net','M');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender)
VALUES
  (1000000002,1102,621627470920,7555989700,'Isaiah Kumar','1998-09-23','1989 Duis Ave',3297585465,'isaiahkumar@yahoo.org','M');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender)
VALUES
  (1000000003,1103,224594397590,9599167414,'Ebony Puri','1989-05-23','P.O. Box 648, 7574 Vehicula Rd.',2823136538,'ebonypuri5614@yahoo.org','F');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender)
VALUES
  (1000000004,1104,758143371751,3305585335,'Elmo Subramani','2000-08-27','Ap #831-7169 Nulla. Av.',9911377661,'elmosubramani9757@icloud.net','M');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender)
VALUES
  (1000000005,1105,782824411660,2008319587,'Aileen Soni','1991-05-08','763-2019 Eu Av.',5889649197,'aileensoni8388@aol.edu','F');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender)
VALUES
  (1000000006,1106,422380954823,2710747181,'Bradley Ganesh','1988-01-05','Ap #499-6818 Orci. St.',1139789652,'bradleyganesh3530@hotmail.com','M');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender)
VALUES
  (1000000007,1107,713725250342,1852576699,'Camden Mehra','1998-06-27','778-355 Tristique Street',8643703858,'camdenmehra3887@google.net','F');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender)
VALUES
  (1000000008,1108,712343679762,3407118287,'Brock Vish','1992-08-29','Ap #105-9917 Nisl. St.',4275295155,'brockvish@icloud.net','F');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender)
VALUES
  (1000000009,1109,865630547331,1306550270,'Craig Lal','1992-05-21','P.O. Box 894, 282 Montes, Avenue',3229839412,'craiglal5302@outlook.edu','F');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender)
VALUES
  (1000000010,1110,899410868534,9517003347,'Lee Raje','1997-06-07','Ap #834-5910 Lorem Avenue',7157066923,'leeraje@aol.net','M');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender)
VALUES
  (1000000011,1111,630024993370,5964079634,'Daria Tyagi','1998-09-27','537-9945 Lorem Ave',8818892121,'dariatyagi@aol.edu','M');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender)
VALUES
  (1000000012,1112,962916017991,8141576857,'Serena Saxena','1993-04-22','Ap #348-6626 At Rd.',6676436130,'serenasaxena@google.net','M');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender)
VALUES
  (1000000013,1113,144878322691,6821062355,'Tucker Mittal','1996-07-26','114-9390 Nam Avenue',9664455368,'tuckermittal@yahoo.com','M');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender)
VALUES
  (1000000014,1114,736634773517,5051655450,'Hiroko Persaud','1985-07-14','311-3197 Augue Av.',5805761824,'hirokopersaud5458@google.com','F');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender)
VALUES
  (1000000015,1115,690491921611,3907779527,'Laura Roy','1985-09-15','Ap #898-2108 Sodales Street',1501249726,'lauraroy@icloud.edu','F');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender)
VALUES
  (1000000016,1116,782969432898,1139206135,'Lunea Vijaya','1989-02-03','P.O. Box 145, 1616 Vitae, Ave',1809566110,'luneavijaya@yahoo.net','F');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender)
VALUES
  (1000000017,1117,695741625523,7465363654,'Amery Jai','1985-09-13','P.O. Box 388, 7968 Lorem, Rd.',1170783701,'ameryjai6184@outlook.edu','M');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender)
VALUES
  (1000000018,1118,406787224761,9847235873,'Venus Saxena','2003-10-06','Ap #545-4690 Enim. Rd.',4350564694,'venussaxena7243@google.edu','F');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender)
VALUES
  (1000000019,1119,770902961840,8172070350,'Driscoll Shan','1999-07-09','361-4408 Ut Street',8662359102,'driscollshan5195@aol.com','M');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender)
VALUES
  (1000000020,1120,386460131005,9431242916,'Ina Engineer','1997-03-27','Ap #867-1321 Orci St.',2501274251,'inaengineer@outlook.org','F');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender)
VALUES
  (1000000021,1121,474099125761,8999032591,'Halee Kapoor','1994-09-02','9340 Blandit Street',2473815996,'haleekapoor5010@outlook.net','M');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender)
VALUES
  (1000000022,1122,883791298751,4540171881,'Gretchen Patel','1988-04-09','238-3751 Odio. St.',7941287403,'gretchenpatel@yahoo.net','M');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender)
VALUES
  (1000000023,1123,457011304761,8624993956,'Quinlan Veena','1986-10-04','Ap #366-3014 Scelerisque Rd.',2614132102,'quinlanveena@aol.net','M');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender)
VALUES
  (1000000024,1124,699385998257,5929664012,'Armando Nita','1993-08-30','Ap #388-582 Molestie St.',4145637571,'armandonita@hotmail.edu','F');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender)
VALUES
  (1000000025,1125,627820151310,3223928873,'Trevor Nara','2000-03-29','992-4975 Rutrum. Av.',4542166171,'trevornara@yahoo.edu','M');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender)
VALUES
  (1000000026,1126,945893889661,9884858056,'Karly Chaudhary','1986-03-09','Ap #477-1389 Ipsum Road',6816512911,'karlychaudhary3338@outlook.com','M');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender)
VALUES
  (1000000027,1127,672694097485,9044892926,'Reuben Chandrasekar','1994-12-07','6868 Sodales. Av.',3038637846,'reubenchandrasekar@icloud.net','M');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender)
VALUES
  (1000000028,1128,745981152341,8596081562,'Logan Saini','1991-05-25','6567 Lobortis. Av.',2858631690,'logansaini@google.net','M');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender)
VALUES
  (1000000029,1129,910424763941,4733322710,'Matthew Verma','2004-02-24','476-4946 Adipiscing Street',8751532577,'matthewverma6919@google.edu','F');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender)
VALUES
  (1000000030,1130,858271639981,8791570489,'Cadman Subramani','1991-02-26','Ap #360-710 Cursus. Rd.',2818120565,'cadmansubramani4415@google.com','F');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender)
VALUES
  (1000000031,1131,411653278015,2025373768,'Wynne Samuel','1999-07-31','P.O. Box 559, 5244 Eu Road',6655128082,'wynnesamuel9405@google.edu','F');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender)
VALUES
  (1000000032,1132,216250484075,7066476785,'Chanda Swami','1997-07-14','540-1923 Lacinia Road',8155330547,'chandaswami@aol.net','F');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender) VALUES
(1000000033,1133,943807025150,4165263122,'Cassandra Raman','1986-04-23','195-6435 Tempor Street',5998609549,'cassandraraman@yahoo.org','F');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender) VALUES
(1000000034,1134,127329918912,9156286914,'Darrel Mehra','2002-08-14','261-2772 Aliquet. Rd.',5523768117,'darrelmehra2278@icloud.net','F');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender) VALUES
(1000000035,1135,508220451975,3586972861,'Cain Raman','1993-09-30','Ap #818-9276 Felis. St.',1470479167,'cainraman7763@outlook.net','M');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender) VALUES
(1000000036,1136,513844410130,9008549165,'Nadine Neelam','1999-10-16','Ap #726-6125 Risus St.',7337362649,'nadineneelam2009@outlook.com','F');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender) VALUES
(1000000037,1137,779593845478,5331299082,'Jade Gandhi','1998-09-16','368-526 Massa. Street',2674447778,'jadegandhi@outlook.org','F');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender) VALUES
(1000000038,1138,543428437599,6088124243,'Cassidy Gandhi','1997-05-17','520-801 Tincidunt Avenue',6481914956,'cassidygandhi1655@outlook.net','F');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender) VALUES
(1000000039,1139,998103026946,4578793868,'Zachery Raman','1988-10-30','1047 Sed St.',6398978783,'zacheryraman@google.org','F');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender) VALUES
(1000000040,1140,443520613919,9238688340,'Quon Sahni','1995-11-06','P.O. Box 294, 3240 Pellentesque Street',8214238986,'quonsahni6528@icloud.edu','F');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender) VALUES
(1000000041,1141,351430616323,4522253587,'Sonya Roy','2001-08-06','P.O. Box 570, 9240 Arcu. Street',4700090886,'sonyaroy@aol.org','M');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender) VALUES
(1000000042,1142,982580184772,7589431500,'Ira Subramani','1998-11-15','298-9898 Egestas. Road',8246551676,'irasubramani6488@yahoo.org','M');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender) VALUES
(1000000043,1143,586173375347,3590227772,'Xaviera Sehgal','1989-04-28','9249 Venenatis Avenue',2538920877,'xavierasehgal1312@hotmail.net','M');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender) VALUES
(1000000044,1144,960642798522,6626467453,'Jason Sudha','1991-12-31','968-6104 Aenean Street',7676542961,'jasonsudha8621@outlook.org','F');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender) VALUES
(1000000045,1145,278339500195,4758784920,'Nina Naran','2000-08-23','P.O. Box 287, 7806 Sit St.',1553431971,'ninanaran7562@icloud.org','F');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender) VALUES
(1000000046,1146,539820259966,6879142993,'Gloria Joshi','1986-03-20','Ap #545-8044 Dignissim. Ave',2387251298,'gloriajoshi@google.net','F');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender) VALUES
(1000000047,1147,360095635644,8997824457,'Ulla Nirmal','2001-07-16','5025 Nec, Rd.',3768863579,'ullanirmal7542@hotmail.com','F');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender) VALUES
(1000000048,1148,183312493640,9607113387,'Vance Manju','1995-09-10','Ap #840-1633 Volutpat Avenue',1951669025,'vancemanju217@hotmail.edu','M');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender) VALUES
(1000000049,1149,943382794314,2257661647,'Dexter Srini','1989-02-04','Ap #117-3013 Non, Av.',6668339233,'dextersrini3889@icloud.net','F');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender) VALUES
(1000000050,1150,536335201519,4770708825,'Ainsley Veer','1995-03-29','Ap #975-5082 Nunc St.',9317004942,'ainsleyveer@hotmail.edu','F');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender) VALUES
(1000000051,1151,719269346069,7719718073,'Abraham Naran','1987-02-07','345-1999 Amet Av.',7784818879,'abrahamnaran4344@outlook.net','F');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender) VALUES
(1000000052,1152,993099371751,6446370712,'Zephr Naran','1998-08-02','491-9598 Magna. Ave',4290237675,'zephrnaran@hotmail.com','M');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender) VALUES
(1000000053,1153,900529981258,2742847428,'Jessica Sara','1989-08-06','307-2139 Aenean Ave',2007507568,'jessicasara5368@outlook.org','F');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender) VALUES
(1000000054,1154,647109845214,6062459999,'Carolyn Saini','1994-06-09','P.O. Box 349, 544 Ipsum Rd.',8290517437,'carolynsaini7303@google.net','M');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender) VALUES
(1000000055,1155,211153704496,9990972071,'Roth Nagpal','2003-03-13','Ap #844-203 Aliquam St.',4447488269,'rothnagpal4043@yahoo.net','F');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender) VALUES
(1000000056,1156,876188412303,5348031546,'Hakeem Swami','2000-08-18','868-1940 Ac, Av.',4288312055,'hakeemswami5564@google.net','M');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender) VALUES
(1000000057,1157,260595114087,8129165149,'Ignatius Nigam','1989-06-27','Ap #814-8828 Viverra. St.',1247240582,'ignatiusnigam7625@aol.com','F');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender) VALUES
(1000000058,1158,689512616801,6692796306,'Allen Srini','1997-03-06','288-3314 Eleifend Av.',9787057238,'allensrini455@aol.org','F');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender) VALUES
(1000000059,1159,750741627959,4177552435,'Paul Bhatt','1993-11-12','Ap #446-1209 Dictum Ave',6096298892,'paulbhatt9668@yahoo.org','M');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender) VALUES
(1000000060,1160,789261296618,6535155843,'Rudyard Jindal','2002-02-01','6100 Fusce Road',5480346823,'rudyardjindal@aol.com','M');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender) VALUES
(1000000061,1161,587204234879,3470199071,'Stephanie Lalit','1988-05-13','Ap #719-3080 Non Street',9310537074,'stephanielalit1160@hotmail.edu','F');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender) VALUES
(1000000062,1162,684003516688,9291115482,'Warren Narang','1995-06-17','496-3834 Semper Av.',6330524919,'warrennarang@yahoo.com','M');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender) VALUES
(1000000063,1163,148040185124,4977052425,'Samson Verma','1994-07-27','Ap #586-261 Varius Rd.',4999133257,'samsonverma6848@yahoo.net','M');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender) VALUES
(1000000064,1164,447155356576,5008571938,'Jaden Shan','2002-07-12','P.O. Box 752, 2207 Id Street',7102279383,'jadenshan@google.edu','F');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender) VALUES
(1000000065,1165,684446979183,1272011214,'Palmer Rana','1996-10-15','Ap #633-8521 Dolor. Rd.',9702687092,'palmerrana@google.net','M');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender) VALUES
(1000000066,1166,232118905037,4535599512,'Alika Narayan','1993-08-03','Ap #469-9166 Libero Road',5515091413,'alikanarayan@google.net','M');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender) VALUES
(1000000067,1167,945489981199,2667743507,'Chester Veena','1985-12-21','240-5915 Id Ave',7687243760,'chesterveena@google.net','M');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender) VALUES
(1000000068,1168,781483683581,1156778853,'Chandler Sudha','2000-11-17','865-6151 Interdum. Rd.',1344245039,'chandlersudha2593@google.com','M');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender) VALUES
(1000000069,1169,805560198053,1889709734,'Quinn Jana','2000-09-17','Ap #727-5707 Mollis. Ave',3173679664,'quinnjana7674@yahoo.edu','F');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender) VALUES
(1000000070,1170,223016744350,7482678810,'Raymond Swami','1994-04-14','4315 Sollicitudin St.',9689069723,'raymondswami@google.net','M');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender) VALUES
(1000000071,1171,272891620012,1226882780,'Cora Veena','1989-02-26','7823 Pellentesque St.',2784696279,'coraveena@aol.net','M');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender) VALUES
(1000000072,1172,339454804297,2588273533,'Dalton Sen','1987-09-23','Ap #735-5642 Volutpat St.',2643490133,'daltonsen@google.com','M');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender) VALUES
(1000000073,1173,399213719831,9523454823,'Wyatt Chandrasekar','1989-03-17','6319 Sit St.',6785261381,'wyattchandrasekar@outlook.com','M');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender) VALUES
(1000000074,1174,380123997865,4989914900,'Irene Madan','2000-01-26','Ap #951-2840 Bibendum. Rd.',3625507796,'irenemadan@google.edu','M');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender) VALUES
(1000000075,1175,443945934382,4948997999,'Brock Srini','2002-09-05','263-5971 Urna St.',9485207400,'brocksrini9624@aol.org','M');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender) VALUES
(1000000076,1176,300858779523,3302063381,'Ivan Patel','1989-05-18','669-5738 Egestas. Road',8239079336,'ivanpatel@icloud.edu','M');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender) VALUES
(1000000077,1177,892586504109,2811442599,'Courtney Patel','1989-09-24','8503 Nunc Ave',5062606202,'courtneypatel@aol.org','F');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender) VALUES
(1000000078,1178,163556555155,9058672165,'Adara Nigam','2003-07-24','3521 Nulla Av.',4946025765,'adaranigam@icloud.org','F');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender) VALUES
(1000000079,1179,318898910149,5507567902,'Harriet Narang','1997-07-26','Ap #499-5779 Commodo Rd.',2490595061,'harrietnarang5921@aol.net','M');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender) VALUES
(1000000080,1180,115160554670,2192711539,'Genevieve Chauhan','1994-01-26','586-1609 Lectus Rd.',6487317105,'genevievechauhan4827@aol.edu','F');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender) VALUES
(1000000081,1181,284529230664,9807926090,'Amery Anand','2000-07-03','Ap #986-9394 Leo Road',9499703753,'ameryanand@outlook.com','F');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender) VALUES
(1000000082,1182,979621881309,8704380264,'Deborah Sara','1987-09-04','P.O. Box 164, 1738 Non St.',8572968336,'deborahsara@hotmail.edu','F');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender) VALUES
(1000000083,1183,687762013057,2123272608,'Kermit Srivastav','1998-06-18','P.O. Box 308, 373 Lacinia Rd.',2185855068,'kermitsrivastav@google.org','F');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender) VALUES
(1000000084,1184,852321289741,2606208459,'Dante Sharma','1998-09-05','290-9981 Nulla St.',4074865625,'dantesharma@yahoo.org','F');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender) VALUES
(1000000085,1185,501166031595,7438322252,'Ayanna Ganesh','2001-04-06','Ap #344-8933 Ac Rd.',5163656551,'ayannaganesh4826@aol.edu','M');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender) VALUES
(1000000086,1186,127260714008,3375548448,'Logan Chander','2003-03-13','Ap #831-2806 Congue, St.',1612047112,'loganchander6592@aol.net','M');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender) VALUES
(1000000087,1187,488373029557,1250163610,'Garth Swami','1994-01-08','825-896 Integer Rd.',5325084336,'garthswami6397@outlook.com','F');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender) VALUES
(1000000088,1188,139628776833,4620285118,'Scarlet Rajagopal','1995-11-17','Ap #406-7670 Eget, Avenue',3148543402,'scarletrajagopal@aol.org','M');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender) VALUES
(1000000089,1189,180324903927,3445188115,'Eugenia Arun','1992-11-24','Ap #530-9293 Sed Av.',6343759722,'eugeniaarun@outlook.com','M');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender) VALUES
(1000000090,1190,687068243995,1147544857,'Zoe Raje','2003-02-10','634-3359 Fusce Road',6419785006,'zoeraje@outlook.org','F');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender) VALUES
(1000000091,1191,983782809116,9432552705,'Raymond Ganesh','1994-09-07','8184 Pellentesque Street',8667680742,'raymondganesh@icloud.edu','M');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender) VALUES
(1000000092,1192,995401571461,7880311434,'Aimee Gandhi','1998-08-14','582-1178 Ultrices Avenue',8844552449,'aimeegandhi6298@aol.net','M');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender) VALUES
(1000000093,1193,719662210609,5830446837,'Paul Vish','1986-02-14','Ap #246-6497 Nulla St.',7747564942,'paulvish@outlook.net','F');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender) VALUES
(1000000094,1194,598892180741,3041652063,'Kareem Saini','2000-05-16','485 Lacinia St.',5775718944,'kareemsaini@google.org','M');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender) VALUES
(1000000095,1195,506091197356,9645106006,'Ulric Tyagi','2001-09-09','P.O. Box 403, 2047 Nisl. St.',5997556086,'ulrictyagi@aol.net','F');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender) VALUES
(1000000096,1196,538309204272,7048797990,'Charles Lal','2002-01-03','P.O. Box 568, 8806 Laoreet Avenue',2216475605,'charleslal7346@outlook.com','F');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender) VALUES
(1000000097,1197,416080462850,3858986990,'Yael Chander','1998-02-28','191-312 Sed Street',1467257683,'yaelchander@outlook.edu','M');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender) VALUES
(1000000098,1198,311892984928,7848594393,'Olivia Saxena','2001-11-24','Ap #773-5619 Quis Street',7982991793,'oliviasaxena@hotmail.com','M');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender) VALUES
(1000000099,1199,980472245775,3191498668,'Lyle Arun','1986-09-24','536-1011 Parturient Street',2926453442,'lylearun@yahoo.com','F');
  INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender) VALUES
(1000000100,1200,837486889032,4526334898,'Cora Goel','1999-03-25','Ap #548-3349 Fermentum St.',7821638791,'coragoel1950@icloud.org','M');

CREATE TABLE Employee(
	  EmpID CHAR(12) NOT NULL,
	  Password int NOT NULL,
    AadharNo CHAR(12) NOT NULL,
    Name VARCHAR(100) NOT NULL, 
    DOB DATE, 
    Address VARCHAR(200), 
    PhoneNo CHAR(10), 
    Salary BIGINT NOT NULL, 
    Email VARCHAR(100),
    Gender CHAR(1),
    PRIMARY KEY(EmpID));

CREATE TABLE Branch (
  BranchNo BIGINT NOT NULL,
  ManagerID CHAR(12),
  Address VARCHAR(255),
  PhoneNo BIGINT,
  PRIMARY KEY (BranchNo));

GO  
CREATE TRIGGER Manage_login_create ON Branch
AFTER INSERT
AS
BEGIN
    SET NOCOUNT ON;
	DECLARE
		@SQL nvarchar(MAX),
		@Username nchar(20),
		@Password nchar(4)
	SELECT @Username = INSERTED.[ManagerID] FROM INSERTED
	SELECT @Password = Employee.[Password] from Employee where EmpID = @Username
	print 'M'+@Username
	print ''''+@Password+''''
	SET @SQL = 'CREATE LOGIN M' + @Username + ' WITH PASSWORD = '''+@Password+''', CHECK_EXPIRATION = OFF';
	EXECUTE(@SQL);
	SET @SQL = 'CREATE User M' + @Username + ' for login M'+ @Username;
	EXECUTE(@SQL)
END


  INSERT INTO Employee (EmpID,Password,AadharNo,Name,DOB,Address,PhoneNo,Salary,Email,Gender) VALUES
(100000000001,1101,465820459909,'Charles Bridges','1978-11-14','Ap #927-8085 Velit Av.','2467236706',6837121,'magna@icloud.com','M');
  INSERT INTO Employee (EmpID,Password,AadharNo,Name,DOB,Address,PhoneNo,Salary,Email,Gender) VALUES
(100000000002,1102,975461257851,'Darius Monroe','1996-04-04','Ap #666-1989 Pede Road','2757562234',9845541,'semper.nam@protonmail.ca','F');
  INSERT INTO Employee (EmpID,Password,AadharNo,Name,DOB,Address,PhoneNo,Salary,Email,Gender) VALUES
(100000000003,1103,870346124226,'Rama Hunter','1980-07-07','Ap #302-4178 Elit, Road','8220836266',4575848,'vitae.orci@outlook.org','M');
  INSERT INTO Employee (EmpID,Password,AadharNo,Name,DOB,Address,PhoneNo,Salary,Email,Gender) VALUES
(100000000004,1104,696777402363,'Jermaine Wilkins','2000-07-22','345-2872 Diam St.','0868278478',1237496,'malesuada@aol.org','F');
  INSERT INTO Employee (EmpID,Password,AadharNo,Name,DOB,Address,PhoneNo,Salary,Email,Gender) VALUES
(100000000005,1105,362072765594,'Lawrence Clay','1990-07-25','643-5880 Eu Ave','1162171547',2788345,'arcu@yahoo.net','M');
  INSERT INTO Employee (EmpID,Password,AadharNo,Name,DOB,Address,PhoneNo,Salary,Email,Gender) VALUES
(100000000006,1106,309862561561,'Amena Hunter','1976-03-02','9932 Parturient Road','8328227604',6544686,'laoreet.posuere@protonmail.net','F');
  INSERT INTO Employee (EmpID,Password,AadharNo,Name,DOB,Address,PhoneNo,Salary,Email,Gender) VALUES
(100000000007,1107,993136609014,'Karly Orr','1988-12-06','8146 Dui, St.','6526165318',1907383,'amet@aol.ca','M');
  INSERT INTO Employee (EmpID,Password,AadharNo,Name,DOB,Address,PhoneNo,Salary,Email,Gender) VALUES
(100000000008,1108,299536179442,'Branden Sloan','1996-11-11','Ap #385-8102 Lectus Street','3888113158',2971898,'donec.egestas.duis@google.edu','F');
  INSERT INTO Employee (EmpID,Password,AadharNo,Name,DOB,Address,PhoneNo,Salary,Email,Gender) VALUES
(100000000009,1109,150548566044,'Eric Webb','1998-01-14','152-5786 Ac, Avenue','9526742764',3110806,'fames@icloud.couk','F');
  INSERT INTO Employee (EmpID,Password,AadharNo,Name,DOB,Address,PhoneNo,Salary,Email,Gender) VALUES
(100000000010,1110,271231367754,'Patience Vega','1978-09-03','P.O. Box 149, 9882 Non St.','5458464550',9784332,'a.arcu@protonmail.net','F');
  INSERT INTO Employee (EmpID,Password,AadharNo,Name,DOB,Address,PhoneNo,Salary,Email,Gender) VALUES
(100000000011,1111,758340426641,'Amity Walls','1975-08-14','Ap #611-6081 Malesuada Av.','1348786863',1857992,'curae.phasellus@outlook.couk','M');
  INSERT INTO Employee (EmpID,Password,AadharNo,Name,DOB,Address,PhoneNo,Salary,Email,Gender) VALUES
(100000000012,1112,929534654323,'Cally Mathews','1997-06-05','Ap #809-3522 Suspendisse St.','0636354637',5772138,'nisi.mauris.nulla@hotmail.couk','M');
  INSERT INTO Employee (EmpID,Password,AadharNo,Name,DOB,Address,PhoneNo,Salary,Email,Gender) VALUES
(100000000013,1113,787245740845,'Quinlan Blankenship','2001-06-12','Ap #562-1989 Euismod Avenue','1521595685',6890439,'amet@aol.com','F');
  INSERT INTO Employee (EmpID,Password,AadharNo,Name,DOB,Address,PhoneNo,Salary,Email,Gender) VALUES
(100000000014,1114,897079004157,'Willa Little','1978-08-05','Ap #481-1045 Ligula Street','3117534845',4976740,'consequat.purus@yahoo.edu','M');
  INSERT INTO Employee (EmpID,Password,AadharNo,Name,DOB,Address,PhoneNo,Salary,Email,Gender) VALUES
(100000000015,1115,326202528843,'Lilah Mendez','1976-08-06','103-5779 Nibh Rd.','1113401184',4765123,'parturient.montes.nascetur@google.org','F');
  INSERT INTO Employee (EmpID,Password,AadharNo,Name,DOB,Address,PhoneNo,Salary,Email,Gender) VALUES
(100000000016,1116,937401136190,'Stephen Lawrence','1996-06-05','7599 At Rd.','1435337582',6709495,'conubia@protonmail.edu','F');
  INSERT INTO Employee (EmpID,Password,AadharNo,Name,DOB,Address,PhoneNo,Salary,Email,Gender) VALUES
(100000000017,1117,363054848200,'Alec Gates','1997-09-01','Ap #116-2747 Donec Rd.','2325713650',8911578,'amet@hotmail.com','M');
  INSERT INTO Employee (EmpID,Password,AadharNo,Name,DOB,Address,PhoneNo,Salary,Email,Gender) VALUES
(100000000018,1118,422404956539,'Virginia Wagner','1989-07-06','724-8198 Vitae Street','2816586564',8367921,'cursus.a.enim@hotmail.com','F');
  INSERT INTO Employee (EmpID,Password,AadharNo,Name,DOB,Address,PhoneNo,Salary,Email,Gender) VALUES
(100000000019,1119,847213732700,'Basil Herman','1998-05-31','Ap #320-950 A Road','1256869863',7356689,'nunc@hotmail.ca','M');
  INSERT INTO Employee (EmpID,Password,AadharNo,Name,DOB,Address,PhoneNo,Salary,Email,Gender) VALUES
(100000000020,1120,519795962937,'Katell Manning','1987-05-08','P.O. Box 246, 2368 Vel, Av.','3568876456',8188532,'quisque.fringilla.euismod@yahoo.ca','M');
  INSERT INTO Employee (EmpID,Password,AadharNo,Name,DOB,Address,PhoneNo,Salary,Email,Gender) VALUES
(100000000021,1121,726928384566,'Armand Pollard','1989-08-23','319-7139 Libero. St.','7818813521',5493866,'adipiscing.fringilla.porttitor@yahoo.com','M');
  INSERT INTO Employee (EmpID,Password,AadharNo,Name,DOB,Address,PhoneNo,Salary,Email,Gender) VALUES
(100000000022,1122,464441033786,'Ray Donaldson','1983-06-28','1606 Arcu Ave','6886775667',7282567,'posuere.cubilia@aol.edu','M');
  INSERT INTO Employee (EmpID,Password,AadharNo,Name,DOB,Address,PhoneNo,Salary,Email,Gender) VALUES
(100000000023,1123,206491508018,'Len Andrews','1980-07-25','P.O. Box 885, 2302 Mollis. Ave','6245769211',5949070,'hendrerit@google.edu','M');
  INSERT INTO Employee (EmpID,Password,AadharNo,Name,DOB,Address,PhoneNo,Salary,Email,Gender) VALUES
(100000000024,1124,471693236528,'Ciaran Mullen','1978-11-24','203-5390 Bibendum. Avenue','9038216318',7390618,'quis.accumsan.convallis@protonmail.org','M');
  INSERT INTO Employee (EmpID,Password,AadharNo,Name,DOB,Address,PhoneNo,Salary,Email,Gender) VALUES
(100000000025,1125,866714669627,'Miriam Cooley','1982-10-15','P.O. Box 742, 5206 Velit Rd.','4358536211',2148257,'proin@google.net','M');


INSERT INTO Branch (BranchNo,ManagerID,Address,PhoneNo)
VALUES
  (1,100000000001,'Ap #703-4893 Nunc Rd.',6916326850);
  INSERT INTO Branch (BranchNo,ManagerID,Address,PhoneNo)
VALUES
  (2,100000000002,'P.O. Box 645, 9873 Lacus. St.',8268560603);
  INSERT INTO Branch (BranchNo,ManagerID,Address,PhoneNo)
VALUES
  (3,100000000003,'198-8757 Faucibus. Ave',6821970200);
INSERT INTO Branch (BranchNo,ManagerID,Address,PhoneNo)
VALUES
  (4,100000000004,'Ap #692-5594 Duis Ave',5269130193);
  INSERT INTO Branch (BranchNo,ManagerID,Address,PhoneNo)
VALUES
  (5,100000000005,'3140 Porttitor Rd.',3234051526);
  


CREATE TABLE Rates(
	Type VARCHAR(10) NOT NULL,
    ROI FLOAT ,
    primary key(Type));

INSERT INTO Rates (Type,ROI)
VALUES
  ('Personal',9.25),
  ('Home',8.06),
  ('Car',7.20),
  ('Savings',2.22),
  ('Current',4.56);

  CREATE TABLE Accounts(
  	AccNo BIGINT,
    CID BIGINT NOT NULL, 
    BranchNo BIGINT NOT NULL,
    AccType VARCHAR(10) NOT NULL, 
    Balance BIGINT, 
    DOC DATE NOT NULL, 
    InterestAmount INT, 
    NomineeId BIGINT,
    PRIMARY KEY(AccNo),
	FOREIGN KEY(CID) References Customer(CID),
	FOREIGN KEY(BranchNo) References Branch(BranchNo),
	FOREIGN KEY(Acctype) References Rates(Type)
);


INSERT INTO Accounts(AccNo,CID,BranchNo,AccType,Balance,DOC,InterestAmount,NomineeID)
VALUES
  (100000000000001,1000000001,1,'Savings',52577,'2028-04-05',4286,1000000085),
  (100000000000002,1000000002,2,'Savings',23676,'2024-06-04',3469,1000000059),
  (100000000000003,1000000003,3,'Current',38670,'2029-11-23',3183,1000000079),
  (100000000000004,1000000004,2,'Savings',43594,'2028-11-27',4211,1000000027),
  (100000000000005,1000000005,3,'Current',54496,'2023-12-20',2397,1000000050),
  (100000000000006,1000000006,5,'Current',88671,'2028-05-31',3181,1000000061),
  (100000000000007,1000000007,3,'Current',95954,'2029-04-18',3166,1000000086),
  (100000000000008,1000000008,2,'Savings',68789,'2027-07-05',2323,1000000058),
  (100000000000009,1000000009,3,'Current',6280,'2029-10-25',2129,1000000094),
  (100000000000010,1000000010,2,'Current',22903,'2030-02-06',3081,1000000083),
  (100000000000011,1000000011,4,'Savings',78717,'2027-08-29',2017,1000000013),
  (100000000000012,1000000012,4,'Current',29088,'2024-03-17',4156,1000000089),
  (100000000000013,1000000013,3,'Savings',89295,'2029-09-03',3489,1000000074),
  (100000000000014,1000000014,3,'Savings',12414,'2027-04-30',3293,1000000092),
  (100000000000015,1000000015,2,'Current',41461,'2028-10-11',1844,1000000028),
  (100000000000016,1000000016,2,'Current',59196,'2029-01-22',3103,1000000048),
  (100000000000017,1000000017,2,'Current',71606,'2027-06-09',2179,1000000028),
  (100000000000018,1000000018,4,'Current',77421,'2026-03-03',1078,1000000020),
  (100000000000019,1000000019,3,'Current',31975,'2026-06-19',3059,1000000008),
  (100000000000020,1000000020,1,'Current',6476,'2027-11-12',1549,1000000056),
  (100000000000021,1000000021,4,'Savings',99602,'2024-12-19',3747,1000000007),
  (100000000000022,1000000022,2,'Savings',48206,'2023-05-25',4421,1000000034),
  (100000000000023,1000000023,4,'Current',86593,'2028-11-14',1517,1000000071),
  (100000000000024,1000000024,1,'Savings',91394,'2026-03-01',4481,1000000015),
  (100000000000025,1000000025,1,'Current',57016,'2025-11-22',3729,1000000092),
  (100000000000026,1000000026,3,'Savings',19406,'2028-03-16',2399,1000000086),
  (100000000000027,1000000027,3,'Savings',87331,'2025-10-19',2920,1000000011),
  (100000000000028,1000000028,4,'Current',75528,'2024-03-31',3621,1000000043),
  (100000000000029,1000000029,4,'Savings',12778,'2024-11-27',4829,1000000061),
  (100000000000030,1000000030,3,'Savings',23528,'2027-10-21',4236,1000000014),
  (100000000000031,1000000031,4,'Current',37322,'2027-01-14',1484,1000000041),
  (100000000000032,1000000032,5,'Savings',12946,'2028-05-12',1430,1000000047),
  (100000000000033,1000000033,2,'Savings',77778,'2029-08-08',3637,1000000064),
  (100000000000034,1000000034,1,'Savings',36802,'2025-07-13',2983,1000000026),
  (100000000000035,1000000035,1,'Savings',77927,'2023-07-10',1720,1000000006),
  (100000000000036,1000000036,4,'Current',54773,'2023-07-24',4950,1000000037),
  (100000000000037,1000000037,3,'Current',86999,'2026-08-03',2477,1000000012),
  (100000000000038,1000000038,3,'Current',36718,'2027-08-13',1596,1000000020),
  (100000000000039,1000000039,3,'Current',80477,'2024-07-04',3917,1000000026),
  (100000000000040,1000000040,4,'Current',21054,'2024-04-14',2607,1000000077),
  (100000000000041,1000000041,4,'Current',19986,'2023-07-21',3305,1000000049),
  (100000000000042,1000000042,4,'Savings',63733,'2026-07-01',1390,1000000018),
  (100000000000043,1000000043,4,'Savings',75480,'2028-08-06',1355,1000000099),
  (100000000000044,1000000044,2,'Current',89818,'2027-05-08',2596,1000000015),
  (100000000000045,1000000045,5,'Savings',37898,'2028-03-07',1153,1000000094),
  (100000000000046,1000000046,2,'Savings',16729,'2025-08-03',2527,1000000029),
  (100000000000047,1000000047,3,'Savings',61317,'2029-03-21',1053,1000000043),
  (100000000000048,1000000048,4,'Current',22143,'2024-02-15',3286,1000000021),
  (100000000000049,1000000049,4,'Current',7540,'2025-09-27',1386,1000000007),
  (100000000000050,1000000050,3,'Current',60527,'2027-11-16',4331,1000000070),
  (100000000000051,1000000051,4,'Current',6549,'2028-07-26',2069,1000000063),
  (100000000000052,1000000052,4,'Current',69307,'2029-03-20',1855,1000000030),
  (100000000000053,1000000053,1,'Current',91450,'2026-09-06',1192,1000000056),
  (100000000000054,1000000054,4,'Savings',94592,'2024-09-08',1411,1000000014),
  (100000000000055,1000000055,3,'Savings',92948,'2024-09-26',1930,1000000024),
  (100000000000056,1000000056,3,'Savings',38777,'2024-07-24',2860,1000000060),
  (100000000000057,1000000057,2,'Current',32293,'2025-10-08',3224,1000000015),
  (100000000000058,1000000058,2,'Savings',68922,'2024-02-28',2858,1000000042),
  (100000000000059,1000000059,1,'Current',95639,'2027-05-11',3729,1000000028),
  (100000000000060,1000000060,1,'Savings',7835,'2028-06-27',1920,1000000093),
  (100000000000061,1000000061,1,'Current',62859,'2029-02-26',3520,1000000099),
  (100000000000062,1000000062,2,'Savings',88334,'2028-01-01',4616,1000000078),
  (100000000000063,1000000063,2,'Current',23163,'2028-07-13',1913,1000000044),
  (100000000000064,1000000064,2,'Current',54254,'2029-09-05',2008,1000000054),
  (100000000000065,1000000065,5,'Current',43085,'2026-02-10',1128,1000000043),
  (100000000000066,1000000066,3,'Current',95873,'2028-12-23',2972,1000000019),
  (100000000000067,1000000067,3,'Current',13875,'2028-09-19',3613,1000000036),
  (100000000000068,1000000068,1,'Current',32479,'2029-11-16',1162,1000000035),
  (100000000000069,1000000069,5,'Current',9125,'2024-03-03',4525,1000000003),
  (100000000000070,1000000070,1,'Current',18862,'2029-06-06',3880,1000000036),
  (100000000000071,1000000071,4,'Savings',43677,'2027-02-05',4426,1000000093),
  (100000000000072,1000000072,2,'Savings',28776,'2026-05-03',3673,1000000094),
  (100000000000073,1000000073,3,'Savings',5295,'2025-06-26',1703,1000000038),
  (100000000000074,1000000074,3,'Current',62490,'2027-02-28',1070,1000000015),
  (100000000000075,1000000075,3,'Current',57205,'2023-12-20',2500,1000000055),
  (100000000000076,1000000076,5,'Savings',13873,'2025-04-23',2157,1000000041),
  (100000000000077,1000000077,4,'Savings',55981,'2026-03-21',4400,1000000045),
  (100000000000078,1000000078,4,'Current',43802,'2023-03-18',2223,1000000032),
  (100000000000079,1000000079,4,'Savings',10210,'2029-01-16',2944,1000000068),
  (100000000000080,1000000080,4,'Savings',87615,'2029-05-30',1949,1000000080),
  (100000000000081,1000000081,1,'Savings',63945,'2028-10-05',2499,1000000096),
  (100000000000082,1000000082,3,'Savings',10786,'2028-02-02',4430,1000000058),
  (100000000000083,1000000083,4,'Savings',65431,'2023-11-29',3064,1000000062),
  (100000000000084,1000000084,3,'Savings',91883,'2025-10-30',3887,1000000070),
  (100000000000085,1000000085,2,'Current',98507,'2030-02-16',3403,1000000057),
  (100000000000086,1000000086,4,'Current',8272,'2028-08-24',4334,1000000099),
  (100000000000087,1000000087,5,'Current',74414,'2026-10-31',4636,1000000031),
  (100000000000088,1000000088,4,'Current',71672,'2024-11-30',1350,1000000063),
  (100000000000089,1000000089,2,'Current',13885,'2027-04-21',4166,1000000052),
  (100000000000090,1000000090,2,'Savings',87704,'2029-09-25',2329,1000000087),
  (100000000000091,1000000091,5,'Savings',31946,'2029-06-18',3332,1000000002),
  (100000000000092,1000000092,3,'Savings',20974,'2023-12-08',1030,1000000070),
  (100000000000093,1000000093,1,'Current',84726,'2029-04-13',1700,1000000050),
  (100000000000094,1000000094,3,'Current',16787,'2024-04-08',2471,1000000034),
  (100000000000095,1000000095,4,'Current',26604,'2029-09-14',4664,1000000003),
  (100000000000096,1000000096,3,'Savings',61114,'2026-10-04',4681,1000000009),
  (100000000000097,1000000097,4,'Savings',15611,'2025-07-30',1187,1000000090),
  (100000000000098,1000000098,5,'Savings',32149,'2029-04-14',1246,1000000052),
  (100000000000099,1000000099,2,'Current',35126,'2027-12-25',4629,1000000010),
  (100000000000100,1000000100,3,'Current',26648,'2028-02-05',2651,1000000048);



CREATE TABLE Loan(
	LoanID BIGINT, 
    CID BIGINT NOT NULL,
    BranchNo BIGINT NOT NULL,
    LoanType VARCHAR(10) NOT NULL,
    duration INT,
    DOC DATE,
    TotalAmount BIGINT,
    RemainingAmount BIGINT,
    STATUS VARCHAR(14),
    NomineeId BIGINT,
    PRIMARY KEY(LoanID),
	FOREIGN KEY(CID) References Customer(CID),
	FOREIGN KEY(BranchNo) References Branch(BranchNo));

INSERT INTO Loan (LoanID,CID,BranchNo,LoanType,duration,DOC,TotalAmount,RemainingAmount,Status,NomineeID)
VALUES
  (1000000000001,1000000050,1,'Personal',1,'2016-07-07',824416,7104,'Approved',1000000039),
  (1000000000002,1000000068,3,'Personal',5,'2015-12-26',358152,7204,'Approved',1000000027),
  (1000000000003,1000000019,3,'Personal',1,'2013-05-15',557149,5274,'Approved',1000000009),
  (1000000000004,1000000067,2,'Home',5,'2010-07-08',913494,7587,'Approved',1000000063),
  (1000000000005,1000000088,1,'Home',2,'2014-12-15',840604,0,'Not-Approved',1000000012),
  (1000000000006,1000000038,3,'Personal',3,'2016-02-21',773076,0,'Not-Approved',1000000018),
  (1000000000007,1000000019,4,'Home',2,'2011-09-02',919354,0,'Not-Approved',1000000028),
  (1000000000008,1000000099,2,'Personal',3,'2018-03-26',901622,0,'Not-Approved',1000000005),
  (1000000000009,1000000087,3,'Car',3,'2012-11-03',293640,6540,'Approved',1000000025),
  (1000000000010,1000000022,5,'Car',1,'2017-10-05',291968,0,'Not-Approved',1000000085),
  (1000000000011,1000000026,4,'Car',1,'2016-04-26',550449,4592,'Approved',1000000027),
  (1000000000012,1000000030,4,'Car',2,'2021-07-16',164666,1176,'Approved',1000000073),
  (1000000000013,1000000094,1,'Car',3,'2008-04-25',756116,8010,'Approved',1000000019),
  (1000000000014,1000000097,2,'Home',3,'2014-09-22',374378,0,'Not-Approved',1000000086),
  (1000000000015,1000000037,5,'Car',1,'2021-08-06',856390,1726,'Approved',1000000100),
  (1000000000016,1000000053,2,'Car',2,'2009-06-21',97304,0,'Not-Approved',1000000077),
  (1000000000017,1000000053,3,'Home',4,'2010-08-22',945040,0,'Not-Approved',1000000084),
  (1000000000018,1000000029,4,'Car',4,'2014-12-15',113861,2678,'Approved',1000000062),
  (1000000000019,1000000049,2,'Car',4,'2013-09-01',351359,0,'Not-Approved',1000000028),
  (1000000000020,1000000061,3,'Personal',1,'2012-11-12',843821,0,'Not-Approved',1000000086),
  (1000000000021,1000000015,2,'Car',3,'2006-03-27',539539,0,'Not-Approved',1000000080),
  (1000000000022,1000000014,3,'Personal',5,'2019-09-15',334306,0,'Not-Approved',1000000026),
  (1000000000023,1000000075,4,'Car',2,'2016-08-02',657334,0,'Not-Approved',1000000041),
  (1000000000024,1000000093,1,'Car',2,'2014-07-15',596779,0,'Not-Approved',1000000080),
  (1000000000025,1000000040,2,'Home',2,'2015-02-10',399665,0,'Not-Approved',1000000063),
  (1000000000026,1000000047,3,'Car',5,'2013-02-02',834058,0,'Not-Approved',1000000034),
  (1000000000027,1000000092,1,'Car',3,'2007-01-09',228889,9705,'Approved',1000000059),
  (1000000000028,1000000031,5,'Home',3,'2009-09-14',287522,0,'Not-Approved',1000000006),
  (1000000000029,1000000039,3,'Home',4,'2008-12-28',83418,4910,'Approved',1000000063),
  (1000000000030,1000000017,1,'Car',3,'2010-02-12',760374,0,'Not-Approved',1000000039);



CREATE TABLE Transactions(
  	Tno BIGINT,
    TransactionType VARCHAR(50),
    SenderAccNo BIGINT NOT NULL,
    amount BIGINT NOT NULL,
    DOT DATE,
    ReceiverAccNo BIGINT,
    PRIMARY KEY(Tno),
	FOREIGN KEY(SenderAccNo) references Accounts(AccNo));

INSERT INTO Transactions (Tno,TransactionType,SenderAccNo,Amount,DOT,ReceiverAccNo)
VALUES
  (10000000001,'Net-Banking',100000000000041,34247774,'2016-01-11 ',100000000000026),
  (10000000002,'Net-Banking',100000000000078,17549904,'2021-04-18 ',100000000000081),
  (10000000003,'Card',100000000000004,92463518,'2015-09-26 ',100000000000090),
  (10000000004,'Card',100000000000079,2393608,'2018-12-03 ',100000000000015),
  (10000000005,'Net-Banking',100000000000059,77175656,'2019-01-30 ',100000000000017),
  (10000000006,'Net-Banking',100000000000052,55911846,'2021-11-29 ',100000000000059),
  (10000000007,'Card',100000000000096,87987083,'2015-06-19 ',100000000000092),
  (10000000008,'Net-Banking',100000000000009,7834068,'2019-09-18 ',100000000000027),
  (10000000009,'Card',100000000000068,95058775,'2016-01-02 ',100000000000059),
  (10000000010,'Net-Banking',100000000000089,22253626,'2016-06-07 ',100000000000070),
  (10000000011,'Net-Banking',100000000000022,83557329,'2018-12-08 ',100000000000098),
  (10000000012,'Net-Banking',100000000000011,8451133,'2018-05-24 ',100000000000095),
  (10000000013,'Net-Banking',100000000000063,16742341,'2020-07-12 ',100000000000046),
  (10000000014,'Card',100000000000082,83155199,'2019-08-03 ',100000000000016),
  (10000000015,'Card',100000000000082,85420276,'2020-02-04 ',100000000000077),
  (10000000016,'Card',100000000000086,53626849,'2018-08-05 ',100000000000061),
  (10000000017,'Card',100000000000090,69024933,'2019-11-07 ',100000000000084),
  (10000000018,'Card',100000000000002,65296801,'2020-07-06 ',100000000000074),
  (10000000019,'Card',100000000000044,61541020,'2019-05-12 ',100000000000011),
  (10000000020,'Net-Banking',100000000000032,68194755,'2018-03-11 ',100000000000034),
  (10000000021,'Net-Banking',100000000000095,84676653,'2019-04-21 ',100000000000063),
  (10000000022,'Card',100000000000041,63991218,'2020-06-23 ',100000000000043),
  (10000000023,'Card',100000000000071,75155591,'2018-03-01 ',100000000000006),
  (10000000024,'Card',100000000000010,84454914,'2020-11-21 ',100000000000094),
  (10000000025,'Card',100000000000094,6060590,'2017-03-08 ',100000000000043),
  (10000000026,'Card',100000000000008,79491853,'2018-01-20 ',100000000000085),
  (10000000027,'Net-Banking',100000000000034,10606583,'2021-03-16 ',100000000000099),
  (10000000028,'Net-Banking',100000000000041,8391636,'2022-01-21 ',100000000000007),
  (10000000029,'Card',100000000000042,36424410,'2017-09-05 ',100000000000071),
  (10000000030,'Card',100000000000014,3670370,'2017-12-11 ',100000000000018),
  (10000000031,'Card',100000000000069,6610556,'2018-01-04 ',100000000000010),
  (10000000032,'Net-Banking',100000000000009,19291074,'2020-01-16 ',100000000000036),
  (10000000033,'Card',100000000000050,32210727,'2017-10-10 ',100000000000023),
  (10000000034,'Card',100000000000031,83522352,'2015-12-12 ',100000000000081),
  (10000000035,'Card',100000000000064,23162158,'2016-01-06 ',100000000000004),
  (10000000036,'Card',100000000000065,1701632,'2020-01-24 ',100000000000041),
  (10000000037,'Net-Banking',100000000000087,61333850,'2020-12-24 ',100000000000037),
  (10000000038,'Card',100000000000018,65448764,'2020-01-12 ',100000000000024),
  (10000000039,'Card',100000000000025,6398933,'2021-11-05 ',100000000000061),
  (10000000040,'Card',100000000000066,60930403,'2015-05-17 ',100000000000055),
  (10000000041,'Net-Banking',100000000000010,9716273,'2021-11-21 ',100000000000013),
  (10000000042,'Net-Banking',100000000000035,44017577,'2018-06-23 ',100000000000087),
  (10000000043,'Net-Banking',100000000000031,37229696,'2021-07-30 ',100000000000025),
  (10000000044,'Card',100000000000063,48537007,'2015-10-23 ',100000000000016),
  (10000000045,'Net-Banking',100000000000008,2846700,'2017-05-29 ',100000000000012),
  (10000000046,'Net-Banking',100000000000013,72326687,'2021-05-01 ',100000000000045),
  (10000000047,'Card',100000000000072,11915149,'2015-10-23 ',100000000000096),
  (10000000048,'Card',100000000000064,20830859,'2021-07-24 ',100000000000088),
  (10000000049,'Net-Banking',100000000000077,25039821,'2018-06-02 ',100000000000098),
  (10000000050,'Card',100000000000074,51562683,'2021-05-14 ',100000000000050),
  (10000000051,'Net-Banking',100000000000049,18438766,'2018-09-24 ',100000000000086),
  (10000000052,'Card',100000000000023,6444829,'2018-09-06 ',100000000000068),
  (10000000053,'Net-Banking',100000000000052,72893664,'2016-09-10 ',100000000000012),
  (10000000054,'Card',100000000000057,44658821,'2015-11-04 ',100000000000041),
  (10000000055,'Net-Banking',100000000000072,94231687,'2021-02-24 ',100000000000013),
  (10000000056,'Net-Banking',100000000000075,40480325,'2017-03-02 ',100000000000026),
  (10000000057,'Card',100000000000092,40431372,'2019-06-30 ',100000000000095),
  (10000000058,'Net-Banking',100000000000003,67997104,'2020-01-29 ',100000000000061),
  (10000000059,'Card',100000000000036,50097759,'2017-01-29 ',100000000000041),
  (10000000060,'Card',100000000000020,94761413,'2016-02-09 ',100000000000050),
  (10000000061,'Net-Banking',100000000000050,91663441,'2020-01-14 ',100000000000032),
  (10000000062,'Card',100000000000054,69002942,'2019-10-17 ',100000000000036),
  (10000000063,'Card',100000000000081,80488457,'2018-08-29 ',100000000000007),
  (10000000064,'Net-Banking',100000000000042,6723933,'2017-10-25 ',100000000000068),
  (10000000065,'Card',100000000000015,85048177,'2016-11-07 ',100000000000048),
  (10000000066,'Net-Banking',100000000000022,94839211,'2020-11-10 ',100000000000069),
  (10000000067,'Net-Banking',100000000000039,3746624,'2021-11-03 ',100000000000085),
  (10000000068,'Card',100000000000053,38284668,'2015-12-21 ',100000000000001),
  (10000000069,'Net-Banking',100000000000022,79268001,'2019-09-25 ',100000000000088),
  (10000000070,'Net-Banking',100000000000047,69174996,'2018-08-10 ',100000000000029),
  (10000000071,'Card',100000000000065,3399041,'2018-01-27 ',100000000000092),
  (10000000072,'Net-Banking',100000000000059,80460998,'2016-10-11 ',100000000000016),
  (10000000073,'Net-Banking',100000000000019,53718418,'2019-05-15 ',100000000000015),
  (10000000074,'Card',100000000000077,7364549,'2019-03-18 ',100000000000037),
  (10000000075,'Card',100000000000039,3342868,'2015-07-27 ',100000000000054),
  (10000000076,'Card',100000000000092,91444928,'2021-07-12 ',100000000000059),
  (10000000077,'Card',100000000000066,96142948,'2018-05-16 ',100000000000061),
  (10000000078,'Net-Banking',100000000000002,18238344,'2021-05-13 ',100000000000027),
  (10000000079,'Net-Banking',100000000000075,72254467,'2016-11-13 ',100000000000072),
  (10000000080,'Net-Banking',100000000000006,62611068,'2019-12-05 ',100000000000048),
  (10000000081,'Net-Banking',100000000000042,28180013,'2016-10-12 ',100000000000058),
  (10000000082,'Card',100000000000018,94885905,'2021-12-25 ',100000000000072),
  (10000000083,'Net-Banking',100000000000099,41239405,'2016-06-04 ',100000000000021),
  (10000000084,'Net-Banking',100000000000080,86023249,'2016-11-20 ',100000000000083),
  (10000000085,'Card',100000000000098,44921756,'2018-05-01 ',100000000000023),
  (10000000086,'Net-Banking',100000000000098,26426306,'2016-09-22 ',100000000000098),
  (10000000087,'Card',100000000000023,88406205,'2018-08-15 ',100000000000086),
  (10000000088,'Net-Banking',100000000000072,77756634,'2020-12-24 ',100000000000024),
  (10000000089,'Net-Banking',100000000000032,84537643,'2021-02-22 ',100000000000063),
  (10000000090,'Card',100000000000042,87322406,'2020-04-10 ',100000000000030),
  (10000000091,'Net-Banking',100000000000057,17261849,'2018-06-11 ',100000000000013),
  (10000000092,'Net-Banking',100000000000024,7845082,'2018-06-19 ',100000000000033),
  (10000000093,'Net-Banking',100000000000028,20160873,'2018-02-14 ',100000000000043),
  (10000000094,'Card',100000000000084,76340579,'2021-08-17 ',100000000000085),
  (10000000095,'Card',100000000000023,28862334,'2020-07-12 ',100000000000057),
  (10000000096,'Card',100000000000009,42877776,'2016-03-24 ',100000000000090),
  (10000000097,'Card',100000000000028,6968161,'2016-05-31 ',100000000000075),
  (10000000098,'Net-Banking',100000000000076,32032223,'2021-12-10 ',100000000000026),
  (10000000099,'Card',100000000000015,67506984,'2016-05-26 ',100000000000017),
  (10000000100,'Card',100000000000027,60121694,'2019-03-20 ',100000000000089),
  (10000000101,'Net-Banking',100000000000025,18213197,'2016-05-12 ',100000000000096),
  (10000000102,'Net-Banking',100000000000092,64127856,'2020-09-28 ',100000000000011),
  (10000000103,'Net-Banking',100000000000091,17292024,'2021-04-11 ',100000000000024),
  (10000000104,'Card',100000000000032,48553874,'2017-05-22 ',100000000000028),
  (10000000105,'Net-Banking',100000000000064,50540815,'2015-10-04 ',100000000000025),
  (10000000106,'Card',100000000000020,65547602,'2019-10-17 ',100000000000064),
  (10000000107,'Net-Banking',100000000000009,1358084,'2016-05-17 ',100000000000090),
  (10000000108,'Net-Banking',100000000000083,72973679,'2021-08-20 ',100000000000012),
  (10000000109,'Card',100000000000098,47087740,'2019-08-25 ',100000000000016),
  (10000000110,'Net-Banking',100000000000043,53145766,'2019-07-09 ',100000000000096),
  (10000000111,'Net-Banking',100000000000100,78280538,'2017-04-07 ',100000000000053),
  (10000000112,'Net-Banking',100000000000056,91148603,'2018-09-05 ',100000000000027),
  (10000000113,'Net-Banking',100000000000009,12518647,'2015-03-16 ',100000000000045),
  (10000000114,'Net-Banking',100000000000053,74973052,'2015-12-13 ',100000000000007),
  (10000000115,'Card',100000000000095,82798004,'2017-08-08 ',100000000000024),
  (10000000116,'Card',100000000000038,38693621,'2015-04-28 ',100000000000089),
  (10000000117,'Net-Banking',100000000000035,88420204,'2018-05-13 ',100000000000066),
  (10000000118,'Net-Banking',100000000000094,20196316,'2017-12-05 ',100000000000035),
  (10000000119,'Net-Banking',100000000000039,88217598,'2018-09-10 ',100000000000087),
  (10000000120,'Net-Banking',100000000000029,71710182,'2016-12-19 ',100000000000017),
  (10000000121,'Net-Banking',100000000000045,89921293,'2020-03-11 ',100000000000091),
  (10000000122,'Net-Banking',100000000000048,1043945,'2015-05-04 ',100000000000018),
  (10000000123,'Net-Banking',100000000000018,31461257,'2021-06-10 ',100000000000062),
  (10000000124,'Net-Banking',100000000000009,56520176,'2015-12-25 ',100000000000059),
  (10000000125,'Card',100000000000051,77142533,'2019-03-24 ',100000000000022),
  (10000000126,'Card',100000000000017,78444665,'2016-06-20 ',100000000000032),
  (10000000127,'Net-Banking',100000000000026,39392156,'2019-03-02 ',100000000000091),
  (10000000128,'Card',100000000000076,7938505,'2018-12-25 ',100000000000091),
  (10000000129,'Net-Banking',100000000000006,67032276,'2017-10-19 ',100000000000053),
  (10000000130,'Card',100000000000038,47155765,'2017-12-15 ',100000000000100),
  (10000000131,'Card',100000000000064,51019121,'2021-06-17 ',100000000000005),
  (10000000132,'Net-Banking',100000000000047,22958495,'2020-08-19 ',100000000000094),
  (10000000133,'Card',100000000000097,9399167,'2019-07-08 ',100000000000009),
  (10000000134,'Card',100000000000048,13472663,'2015-05-25 ',100000000000061),
  (10000000135,'Card',100000000000057,54423440,'2020-05-16 ',100000000000042),
  (10000000136,'Card',100000000000050,40035149,'2021-03-29 ',100000000000016),
  (10000000137,'Card',100000000000056,63212329,'2016-01-01 ',100000000000061),
  (10000000138,'Net-Banking',100000000000030,37555432,'2016-09-25 ',100000000000070),
  (10000000139,'Net-Banking',100000000000064,97843317,'2018-04-03 ',100000000000064),
  (10000000140,'Net-Banking',100000000000026,96110013,'2017-04-27 ',100000000000048),
  (10000000141,'Net-Banking',100000000000042,92153178,'2016-09-11 ',100000000000033),
  (10000000142,'Net-Banking',100000000000064,91275120,'2021-08-14 ',100000000000038),
  (10000000143,'Card',100000000000087,96071284,'2017-08-01 ',100000000000085),
  (10000000144,'Card',100000000000079,20877626,'2021-11-29 ',100000000000050),
  (10000000145,'Card',100000000000065,47675101,'2020-12-01 ',100000000000037),
  (10000000146,'Net-Banking',100000000000007,5116679,'2021-11-20 ',100000000000091),
  (10000000147,'Net-Banking',100000000000031,29922497,'2018-02-09 ',100000000000049),
  (10000000148,'Card',100000000000090,38192104,'2019-08-14 ',100000000000034),
  (10000000149,'Card',100000000000075,15907234,'2017-05-07 ',100000000000077),
  (10000000150,'Net-Banking',100000000000009,73529137,'2021-09-12 ',100000000000003),
  (10000000151,'Net-Banking',100000000000067,26303346,'2017-08-26 ',100000000000073),
  (10000000152,'Card',100000000000051,13442708,'2016-02-28 ',100000000000035),
  (10000000153,'Card',100000000000012,26971077,'2018-01-08 ',100000000000096),
  (10000000154,'Net-Banking',100000000000025,67091346,'2020-05-18 ',100000000000016),
  (10000000155,'Card',100000000000083,45030558,'2021-07-28 ',100000000000033),
  (10000000156,'Card',100000000000008,80217221,'2018-03-13 ',100000000000093),
  (10000000157,'Net-Banking',100000000000037,82583227,'2021-02-02 ',100000000000041),
  (10000000158,'Net-Banking',100000000000017,93022005,'2016-02-15 ',100000000000069),
  (10000000159,'Card',100000000000003,64770463,'2019-10-18 ',100000000000052),
  (10000000160,'Net-Banking',100000000000036,97461865,'2016-11-01 ',100000000000062),
  (10000000161,'Net-Banking',100000000000064,94572198,'2020-04-13 ',100000000000045),
  (10000000162,'Net-Banking',100000000000078,41303190,'2016-04-29 ',100000000000084),
  (10000000163,'Net-Banking',100000000000014,89991293,'2017-01-17 ',100000000000094),
  (10000000164,'Card',100000000000046,39354739,'2019-03-31 ',100000000000004),
  (10000000165,'Net-Banking',100000000000023,21926987,'2019-04-22 ',100000000000035),
  (10000000166,'Net-Banking',100000000000026,82640364,'2016-03-19 ',100000000000050),
  (10000000167,'Net-Banking',100000000000086,20977946,'2016-02-23 ',100000000000046),
  (10000000168,'Net-Banking',100000000000088,97811636,'2020-08-21 ',100000000000099),
  (10000000169,'Net-Banking',100000000000087,37009519,'2017-03-07 ',100000000000089),
  (10000000170,'Net-Banking',100000000000042,45061720,'2020-03-24 ',100000000000097),
  (10000000171,'Net-Banking',100000000000086,56421521,'2016-12-31 ',100000000000074),
  (10000000172,'Net-Banking',100000000000088,38720494,'2016-09-21 ',100000000000079),
  (10000000173,'Card',100000000000054,43331330,'2018-10-30 ',100000000000023),
  (10000000174,'Net-Banking',100000000000054,34146792,'2018-10-10 ',100000000000028),
  (10000000175,'Card',100000000000059,43155905,'2016-09-10 ',100000000000037),
  (10000000176,'Card',100000000000009,37846964,'2020-06-14 ',100000000000093),
  (10000000177,'Card',100000000000077,81911528,'2017-09-06 ',100000000000091),
  (10000000178,'Net-Banking',100000000000060,60041276,'2020-12-26 ',100000000000020),
  (10000000179,'Card',100000000000021,70800229,'2018-02-19 ',100000000000088),
  (10000000180,'Card',100000000000011,81605594,'2015-06-30 ',100000000000032),
  (10000000181,'Card',100000000000015,36758705,'2016-08-12 ',100000000000066),
  (10000000182,'Card',100000000000073,74183911,'2016-05-01 ',100000000000082),
  (10000000183,'Card',100000000000053,41637891,'2019-05-04 ',100000000000061),
  (10000000184,'Net-Banking',100000000000080,43826921,'2016-03-31 ',100000000000083),
  (10000000185,'Card',100000000000058,8388801,'2021-05-29 ',100000000000071),
  (10000000186,'Card',100000000000098,73788640,'2017-10-13 ',100000000000078),
  (10000000187,'Card',100000000000085,63184261,'2016-02-18 ',100000000000022),
  (10000000188,'Card',100000000000033,20880331,'2015-03-01 ',100000000000070),
  (10000000189,'Card',100000000000034,31469676,'2017-09-02 ',100000000000019),
  (10000000190,'Net-Banking',100000000000058,58889172,'2020-06-19 ',100000000000061),
  (10000000191,'Card',100000000000058,2131738,'2016-04-11 ',100000000000096),
  (10000000192,'Card',100000000000026,91939639,'2017-05-04 ',100000000000022),
  (10000000193,'Net-Banking',100000000000066,78862652,'2015-03-09 ',100000000000037),
  (10000000194,'Net-Banking',100000000000038,99853113,'2017-12-11 ',100000000000087),
  (10000000195,'Net-Banking',100000000000084,62479295,'2015-10-15 ',100000000000094),
  (10000000196,'Card',100000000000042,2719848,'2019-11-11 ',100000000000052),
  (10000000197,'Card',100000000000006,70554146,'2019-11-15 ',100000000000061),
  (10000000198,'Net-Banking',100000000000074,1367024,'2016-12-04 ',100000000000048),
  (10000000199,'Net-Banking',100000000000075,90637178,'2021-02-07 ',100000000000050),
  (10000000200,'Net-Banking',100000000000058,68491264,'2017-03-09 ',100000000000070);

CREATE TABLE Works (
  BranchNo bigint,
  EmpID CHAR(12) NOT NULL,
  DOJ date,
  PRIMARY KEY(BranchNo,EmpID),
  FOREIGN KEY(EmpID) references Employee(EmpID),
  FOREIGN KEY(BranchNo) references Branch(BranchNo));

INSERT INTO Works (BranchNo,EmpID,DOJ)
VALUES
  (1,100000000001,'2002-06-11'),
  (2,100000000002,'2009-09-22'),
  (3,100000000003,'2004-08-25'),
  (4,100000000004,'2008-11-06'),
  (5,100000000005,'2009-04-18'),
  (5,100000000006,'2000-01-29'),
  (3,100000000007,'2001-02-21'),
  (2,100000000008,'2010-08-09'),
  (3,100000000009,'2010-05-11'),
  (3,100000000010,'2006-05-03'),
  (2,100000000011,'2010-05-20'),
  (5,100000000012,'2001-03-11'),
  (4,100000000013,'2005-01-22'),
  (2,100000000014,'2013-06-07'),
  (4,100000000015,'2006-04-05'),
  (4,100000000016,'2001-12-19'),
  (4,100000000017,'2007-02-15'),
  (2,100000000018,'2013-10-22'),
  (1,100000000019,'2000-04-30'),
  (1,100000000020,'2000-12-26'),
  (3,100000000021,'2003-02-09'),
  (2,100000000022,'2008-09-05'),
  (3,100000000023,'2004-12-02'),
  (4,100000000024,'2010-08-10'),
  (4,100000000025,'2006-07-19');

CREATE TABLE Cards(
  	CardNo INT ,
    CVV char(3),
    AccNo BIGINT NOT NULL,
    IssueDATE DATE,
    ExpDATE DATE,
    pin INT NOT NULL,
    PRIMARY KEY(CardNo),
    FOREIGN KEY(AccNo) REFERENCES Accounts(AccNo)); 

INSERT INTO Cards(CardNo,cvv,AccNo,IssueDATE,ExpDATE,pin)
VALUES
  (10000,'910',100000000000001,'2022-02-24','2023-06-27',9672),
  (10001,'431',100000000000002,'2023-02-27','2023-03-25',6286),
  (10002,'578',100000000000003,'2022-10-03','2024-07-21',7403),
  (10003,'227',100000000000004,'2021-03-06','2024-03-09',6391),
  (10004,'215',100000000000005,'2021-07-16','2024-06-18',9070),
  (10005,'132',100000000000006,'2022-09-01','2023-07-15',4309),
  (10006,'618',100000000000007,'2023-01-13','2024-11-10',6612),
  (10007,'632',100000000000008,'2022-12-28','2024-04-02',7935),
  (10008,'989',100000000000009,'2021-12-05','2023-03-30',2831),
  (10009,'457',100000000000010,'2022-04-22','2023-11-11',3422),
  (10010,'265',100000000000011,'2022-08-20','2024-12-15',8405),
  (10011,'316',100000000000012,'2022-06-01','2024-05-24',1378),
  (10012,'634',100000000000013,'2022-01-17','2023-06-15',8532),
  (10013,'873',100000000000014,'2021-07-30','2024-10-01',9891),
  (10014,'492',100000000000015,'2021-08-29','2024-12-13',6748),
  (10015,'120',100000000000016,'2021-12-25','2024-02-09',1643),
  (10016,'413',100000000000017,'2022-12-26','2024-12-24',4040),
  (10017,'798',100000000000018,'2021-09-23','2024-02-25',6787),
  (10018,'743',100000000000019,'2022-07-14','2025-01-21',3900),
  (10019,'923',100000000000020,'2022-04-10','2024-10-07',3241),
  (10020,'972',100000000000021,'2022-11-30','2023-03-07',1904),
  (10021,'781',100000000000022,'2021-07-30','2025-01-04',3557),
  (10022,'733',100000000000023,'2021-04-01','2023-11-01',1137),
  (10023,'738',100000000000024,'2021-03-20','2024-11-01',5622),
  (10024,'652',100000000000025,'2022-05-01','2025-02-18',5561),
  (10025,'243',100000000000026,'2022-09-14','2023-04-01',1477),
  (10026,'306',100000000000027,'2022-07-06','2023-12-20',7853),
  (10027,'372',100000000000028,'2021-04-30','2023-04-08',9551),
  (10028,'607',100000000000029,'2022-04-18','2023-10-11',5331),
  (10029,'317',100000000000030,'2021-07-18','2024-08-09',8417),
  (10030,'442',100000000000031,'2021-10-23','2023-12-05',8719),
  (10031,'893',100000000000032,'2021-09-30','2023-09-30',8097),
  (10032,'363',100000000000033,'2021-07-26','2023-10-11',1218),
  (10033,'174',100000000000034,'2022-05-28','2023-04-04',6271),
  (10034,'414',100000000000035,'2022-10-13','2025-01-08',9713),
  (10035,'686',100000000000036,'2022-11-02','2024-11-17',8811),
  (10036,'659',100000000000037,'2021-12-21','2024-06-27',7626),
  (10037,'809',100000000000038,'2021-05-23','2024-05-05',7872),
  (10038,'195',100000000000039,'2022-05-04','2024-07-20',9136),
  (10039,'929',100000000000040,'2022-07-11','2024-03-23',1455),
  (10040,'756',100000000000041,'2022-01-03','2024-06-30',4293),
  (10041,'127',100000000000042,'2022-09-08','2023-03-10',2001),
  (10042,'834',100000000000043,'2022-02-03','2023-05-08',2026),
  (10043,'252',100000000000044,'2022-02-08','2024-06-28',4144),
  (10044,'123',100000000000045,'2021-05-02','2024-08-19',4319),
  (10045,'669',100000000000046,'2022-03-27','2024-11-17',8997),
  (10046,'330',100000000000047,'2022-05-26','2024-08-10',8383),
  (10047,'746',100000000000048,'2022-10-24','2024-03-25',1191),
  (10048,'812',100000000000049,'2021-08-04','2023-12-06',6713),
  (10049,'854',100000000000050,'2022-09-28','2023-10-21',1638),
  (10050,'643',100000000000051,'2022-01-30','2024-06-19',5544),
  (10051,'946',100000000000052,'2023-02-21','2024-02-11',9006),
  (10052,'592',100000000000053,'2021-03-10','2023-05-28',6785),
  (10053,'704',100000000000054,'2022-08-03','2023-05-28',3889),
  (10054,'597',100000000000055,'2021-04-21','2023-04-10',9999),
  (10055,'733',100000000000056,'2023-02-19','2023-09-24',7763),
  (10056,'635',100000000000057,'2021-04-21','2024-02-17',8050),
  (10057,'596',100000000000058,'2021-12-05','2023-12-04',9189),
  (10058,'423',100000000000059,'2022-08-31','2024-01-25',2870),
  (10059,'702',100000000000060,'2022-08-17','2024-08-13',7138),
  (10060,'145',100000000000061,'2021-02-28','2023-09-21',9842),
  (10061,'118',100000000000062,'2022-07-07','2024-09-08',9091),
  (10062,'664',100000000000063,'2022-06-28','2024-07-04',8465),
  (10063,'641',100000000000064,'2021-04-07','2025-02-05',2916),
  (10064,'761',100000000000065,'2022-08-10','2024-04-22',3981),
  (10065,'335',100000000000066,'2022-03-26','2024-11-05',7801),
  (10066,'395',100000000000067,'2022-01-06','2024-02-05',2306),
  (10067,'511',100000000000068,'2021-03-14','2023-03-28',8274),
  (10068,'764',100000000000069,'2022-02-04','2024-03-07',1255),
  (10069,'798',100000000000070,'2021-05-28','2023-09-01',8259),
  (10070,'224',100000000000071,'2022-01-10','2024-01-30',6442),
  (10071,'599',100000000000072,'2022-04-10','2023-08-31',4291),
  (10072,'750',100000000000073,'2021-05-16','2024-12-21',8074),
  (10073,'207',100000000000074,'2022-08-08','2024-04-02',4907),
  (10074,'354',100000000000075,'2022-07-07','2024-05-09',1867),
  (10075,'166',100000000000076,'2022-03-08','2024-12-22',3390),
  (10076,'769',100000000000077,'2021-05-05','2024-04-04',3546),
  (10077,'955',100000000000078,'2023-02-03','2023-04-04',9554),
  (10078,'398',100000000000079,'2023-01-15','2024-11-30',6189),
  (10079,'408',100000000000080,'2023-02-02','2024-06-21',1561),
  (10080,'639',100000000000081,'2022-01-26','2024-10-12',1977),
  (10081,'378',100000000000082,'2022-03-14','2024-04-06',5700),
  (10082,'141',100000000000083,'2021-06-16','2023-12-09',3929),
  (10083,'973',100000000000084,'2022-08-26','2023-10-12',1414),
  (10084,'440',100000000000085,'2022-02-03','2025-02-20',3986),
  (10085,'646',100000000000086,'2022-03-19','2024-02-22',1522),
  (10086,'318',100000000000087,'2022-01-14','2024-12-21',7494),
  (10087,'789',100000000000088,'2022-10-17','2025-01-28',1113),
  (10088,'638',100000000000089,'2022-09-03','2024-03-21',3874),
  (10089,'864',100000000000090,'2022-05-05','2024-09-30',2887),
  (10090,'308',100000000000091,'2022-03-17','2024-10-10',7008),
  (10091,'162',100000000000092,'2022-02-18','2024-06-22',1452),
  (10092,'771',100000000000093,'2023-01-06','2024-11-03',6133),
  (10093,'722',100000000000094,'2022-02-17','2024-03-15',5654),
  (10094,'381',100000000000095,'2022-11-05','2024-08-06',3002),
  (10095,'961',100000000000096,'2021-09-04','2023-06-18',9115),
  (10096,'993',100000000000097,'2022-06-28','2024-01-26',2638),
  (10097,'485',100000000000098,'2021-07-20','2025-01-15',4165),
  (10098,'122',100000000000099,'2022-05-15','2024-10-29',4282),
  (10099,'373',100000000000100,'2021-10-07','2023-12-20',7456);

CREATE INDEX index_customer ON Customer (CID,Pass)
CREATE INDEX index_employee ON Employee (EmpID,Password)
CREATE INDEX index_cards ON Cards (expdate,AccNo)
CREATE INDEX index_transactions ON Transactions (DOT,SenderAccNo,ReceiverAccno)
CREATE INDEX index_loan ON Loan (CID)

GO  
CREATE TRIGGER availer ON Accounts
AFTER UPDATE
AS
BEGIN
    SET NOCOUNT ON;
	DECLARE
		@SQL nvarchar(MAX),
		@Username nvarchar(4)
	SELECT @Username = INSERTED.[pin] FROM INSERTED
	SET @SQL = 'Create or Alter View cards_view as Select * from Cards where Pin = '+@username;
	Execute(@SQL)
END


GO
Create trigger trans_update on Transactions
AFTER INSERT
AS
Begin
	Set NOCOUNT ON;
	DECLARE
		@SQL nvarchar(MAX),
		@Sender bigint,
		@Receiver bigint,
		@Amount bigint,
		@initamount bigint,
		@initamount2 bigint
	SELECT @SENDER = INSERTED.[SenderAccNo], @Receiver = INSERTED.[ReceiverAccNo], @Amount = INSERTED.[Amount] FROM INSERTED
	IF @Receiver > 0
    BEGIN
	SELECT @initamount = Accounts.[Balance] FROM Accounts WHERE AccNo = @Sender
	SELECT @initamount = Accounts.[Balance] FROM Accounts WHERE AccNo = @Receiver
    SET @SQL = 'Update Accounts set Balance = '+@initamount-@Amount+' where AccNo = '+ @Sender
	EXECUTE(@SQL)
	SET @SQL = 'Update Accounts set Balance = '+@initamount2+@Amount+' where AccNo = '+@Receiver
	EXECUTE(@SQL)
	SET @SQL = 'Create or Alter View transactions_view as Select * from Transactions where SenderAccNo = ' + @Sender +' or ReceiverAccNo = ' + @Receiver;
	Execute(@SQL)
    END
	ELSE
	SET @SQL = 'Create or Alter View transactions_view as Select * from Transactions where SenderAccNo = ' + @Sender +' or ReceiverAccNo = ' + @Receiver;
	Execute(@SQL)
END

GO
CREATE TRIGGER Employee_Delete ON WORKS
AFTER DELETE
AS
BEGIN
    SET NOCOUNT ON;
	DECLARE
		@SQL nvarchar(MAX),
		@ID nvarchar(15)
	SELECT @ID = DELETED.[EmpID] FROM DELETED
	SET @SQL = 'Delete from EMPLOYEE where Empid = '+@ID;
	Execute(@SQL)
END

