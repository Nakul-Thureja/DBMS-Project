CREATE TABLE Accounts(
  	AccNo BIGINT,
    CID BIGINT NOT NULL, 
    BranchNo MEDIUMINT NOT NULL,
    AccType VARCHAR(10) NOT NULL, 
    Balance BIGINT, 
    DOC DATE NOT NULL, 
    InterestAmount INT, 
    NomineeId BIGINT,
    PRIMARY KEY(AccNo)
    );


INSERT INTO Accounts(AccNo,CID,BranchNo,AccType,Balance,DOC,InterestAmount,NomineeID)
VALUES
  (100000000000001,1000000001,1,"Savings",52577,"2028-04-05",4286,1000000085),
  (100000000000002,1000000002,2,"Savings",23676,"2024-06-04",3469,1000000059),
  (100000000000003,1000000003,3,"Current",38670,"2029-11-23",3183,1000000079),
  (100000000000004,1000000004,2,"Savings",43594,"2028-11-27",4211,1000000027),
  (100000000000005,1000000005,3,"Current",54496,"2023-12-20",2397,1000000050),
  (100000000000006,1000000006,5,"Current",88671,"2028-05-31",3181,1000000061),
  (100000000000007,1000000007,3,"Current",95954,"2029-04-18",3166,1000000086),
  (100000000000008,1000000008,2,"Savings",68789,"2027-07-05",2323,1000000058),
  (100000000000009,1000000009,3,"Current",6280,"2029-10-25",2129,1000000094),
  (100000000000010,1000000010,2,"Current",22903,"2030-02-06",3081,1000000083),
  (100000000000011,1000000011,4,"Savings",78717,"2027-08-29",2017,1000000013),
  (100000000000012,1000000012,4,"Current",29088,"2024-03-17",4156,1000000089),
  (100000000000013,1000000013,3,"Savings",89295,"2029-09-03",3489,1000000074),
  (100000000000014,1000000014,3,"Savings",12414,"2027-04-30",3293,1000000092),
  (100000000000015,1000000015,2,"Current",41461,"2028-10-11",1844,1000000028),
  (100000000000016,1000000016,2,"Current",59196,"2029-01-22",3103,1000000048),
  (100000000000017,1000000017,2,"Current",71606,"2027-06-09",2179,1000000028),
  (100000000000018,1000000018,4,"Current",77421,"2026-03-03",1078,1000000020),
  (100000000000019,1000000019,3,"Current",31975,"2026-06-19",3059,1000000008),
  (100000000000020,1000000020,1,"Current",6476,"2027-11-12",1549,1000000056),
  (100000000000021,1000000021,4,"Savings",99602,"2024-12-19",3747,1000000007),
  (100000000000022,1000000022,2,"Savings",48206,"2023-05-25",4421,1000000034),
  (100000000000023,1000000023,4,"Current",86593,"2028-11-14",1517,1000000071),
  (100000000000024,1000000024,1,"Savings",91394,"2026-03-01",4481,1000000015),
  (100000000000025,1000000025,1,"Current",57016,"2025-11-22",3729,1000000092),
  (100000000000026,1000000026,3,"Savings",19406,"2028-03-16",2399,1000000086),
  (100000000000027,1000000027,3,"Savings",87331,"2025-10-19",2920,1000000011),
  (100000000000028,1000000028,4,"Current",75528,"2024-03-31",3621,1000000043),
  (100000000000029,1000000029,4,"Savings",12778,"2024-11-27",4829,1000000061),
  (100000000000030,1000000030,3,"Savings",23528,"2027-10-21",4236,1000000014),
  (100000000000031,1000000031,4,"Current",37322,"2027-01-14",1484,1000000041),
  (100000000000032,1000000032,5,"Savings",12946,"2028-05-12",1430,1000000047),
  (100000000000033,1000000033,2,"Savings",77778,"2029-08-08",3637,1000000064),
  (100000000000034,1000000034,1,"Savings",36802,"2025-07-13",2983,1000000026),
  (100000000000035,1000000035,1,"Savings",77927,"2023-07-10",1720,1000000006),
  (100000000000036,1000000036,4,"Current",54773,"2023-07-24",4950,1000000037),
  (100000000000037,1000000037,3,"Current",86999,"2026-08-03",2477,1000000012),
  (100000000000038,1000000038,3,"Current",36718,"2027-08-13",1596,1000000020),
  (100000000000039,1000000039,3,"Current",80477,"2024-07-04",3917,1000000026),
  (100000000000040,1000000040,4,"Current",21054,"2024-04-14",2607,1000000077),
  (100000000000041,1000000041,4,"Current",19986,"2023-07-21",3305,1000000049),
  (100000000000042,1000000042,4,"Savings",63733,"2026-07-01",1390,1000000018),
  (100000000000043,1000000043,4,"Savings",75480,"2028-08-06",1355,1000000099),
  (100000000000044,1000000044,2,"Current",89818,"2027-05-08",2596,1000000015),
  (100000000000045,1000000045,5,"Savings",37898,"2028-03-07",1153,1000000094),
  (100000000000046,1000000046,2,"Savings",16729,"2025-08-03",2527,1000000029),
  (100000000000047,1000000047,3,"Savings",61317,"2029-03-21",1053,1000000043),
  (100000000000048,1000000048,4,"Current",22143,"2024-02-15",3286,1000000021),
  (100000000000049,1000000049,4,"Current",7540,"2025-09-27",1386,1000000007),
  (100000000000050,1000000050,3,"Current",60527,"2027-11-16",4331,1000000070),
  (100000000000051,1000000051,4,"Current",6549,"2028-07-26",2069,1000000063),
  (100000000000052,1000000052,4,"Current",69307,"2029-03-20",1855,1000000030),
  (100000000000053,1000000053,1,"Current",91450,"2026-09-06",1192,1000000056),
  (100000000000054,1000000054,4,"Savings",94592,"2024-09-08",1411,1000000014),
  (100000000000055,1000000055,3,"Savings",92948,"2024-09-26",1930,1000000024),
  (100000000000056,1000000056,3,"Savings",38777,"2024-07-24",2860,1000000060),
  (100000000000057,1000000057,2,"Current",32293,"2025-10-08",3224,1000000015),
  (100000000000058,1000000058,2,"Savings",68922,"2024-02-28",2858,1000000042),
  (100000000000059,1000000059,1,"Current",95639,"2027-05-11",3729,1000000028),
  (100000000000060,1000000060,1,"Savings",7835,"2028-06-27",1920,1000000093),
  (100000000000061,1000000061,1,"Current",62859,"2029-02-26",3520,1000000099),
  (100000000000062,1000000062,2,"Savings",88334,"2028-01-01",4616,1000000078),
  (100000000000063,1000000063,2,"Current",23163,"2028-07-13",1913,1000000044),
  (100000000000064,1000000064,2,"Current",54254,"2029-09-05",2008,1000000054),
  (100000000000065,1000000065,5,"Current",43085,"2026-02-10",1128,1000000043),
  (100000000000066,1000000066,3,"Current",95873,"2028-12-23",2972,1000000019),
  (100000000000067,1000000067,3,"Current",13875,"2028-09-19",3613,1000000036),
  (100000000000068,1000000068,1,"Current",32479,"2029-11-16",1162,1000000035),
  (100000000000069,1000000069,5,"Current",9125,"2024-03-03",4525,1000000003),
  (100000000000070,1000000070,1,"Current",18862,"2029-06-06",3880,1000000036),
  (100000000000071,1000000071,4,"Savings",43677,"2027-02-05",4426,1000000093),
  (100000000000072,1000000072,2,"Savings",28776,"2026-05-03",3673,1000000094),
  (100000000000073,1000000073,3,"Savings",5295,"2025-06-26",1703,1000000038),
  (100000000000074,1000000074,3,"Current",62490,"2027-02-28",1070,1000000015),
  (100000000000075,1000000075,3,"Current",57205,"2023-12-20",2500,1000000055),
  (100000000000076,1000000076,5,"Savings",13873,"2025-04-23",2157,1000000041),
  (100000000000077,1000000077,4,"Savings",55981,"2026-03-21",4400,1000000045),
  (100000000000078,1000000078,4,"Current",43802,"2023-03-18",2223,1000000032),
  (100000000000079,1000000079,4,"Savings",10210,"2029-01-16",2944,1000000068),
  (100000000000080,1000000080,4,"Savings",87615,"2029-05-30",1949,1000000080),
  (100000000000081,1000000081,1,"Savings",63945,"2028-10-05",2499,1000000096),
  (100000000000082,1000000082,3,"Savings",10786,"2028-02-02",4430,1000000058),
  (100000000000083,1000000083,4,"Savings",65431,"2023-11-29",3064,1000000062),
  (100000000000084,1000000084,3,"Savings",91883,"2025-10-30",3887,1000000070),
  (100000000000085,1000000085,2,"Current",98507,"2030-02-16",3403,1000000057),
  (100000000000086,1000000086,4,"Current",8272,"2028-08-24",4334,1000000099),
  (100000000000087,1000000087,5,"Current",74414,"2026-10-31",4636,1000000031),
  (100000000000088,1000000088,4,"Current",71672,"2024-11-30",1350,1000000063),
  (100000000000089,1000000089,2,"Current",13885,"2027-04-21",4166,1000000052),
  (100000000000090,1000000090,2,"Savings",87704,"2029-09-25",2329,1000000087),
  (100000000000091,1000000091,5,"Savings",31946,"2029-06-18",3332,1000000002),
  (100000000000092,1000000092,3,"Savings",20974,"2023-12-08",1030,1000000070),
  (100000000000093,1000000093,1,"Current",84726,"2029-04-13",1700,1000000050),
  (100000000000094,1000000094,3,"Current",16787,"2024-04-08",2471,1000000034),
  (100000000000095,1000000095,4,"Current",26604,"2029-09-14",4664,1000000003),
  (100000000000096,1000000096,3,"Savings",61114,"2026-10-04",4681,1000000009),
  (100000000000097,1000000097,4,"Savings",15611,"2025-07-30",1187,1000000090),
  (100000000000098,1000000098,5,"Savings",32149,"2029-04-14",1246,1000000052),
  (100000000000099,1000000099,2,"Current",35126,"2027-12-25",4629,1000000010),
  (100000000000100,1000000100,3,"Current",26648,"2028-02-05",2651,1000000048);
