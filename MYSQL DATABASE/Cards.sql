
CREATE TABLE Cards(
	CardNo INT ,
    CVV char(3),
    AccNo BIGINT NOT NULL,
    IssueDATE DATE,
    ExpDATE DATE,
    pin INT NOT NULL,
    PRIMARY KEY(CardNo)); 

INSERT INTO Cards(CardNo,cvv,AccNo,IssueDATE,ExpDATE,pin)
VALUES
  (10000,"910",100000000000001,"2022-02-24","2023-06-27",9672),
  (10001,"431",100000000000002,"2023-02-27","2023-03-25",6286),
  (10002,"578",100000000000003,"2022-10-03","2024-07-21",7403),
  (10003,"227",100000000000004,"2021-03-06","2024-03-09",6391),
  (10004,"215",100000000000005,"2021-07-16","2024-06-18",9070),
  (10005,"132",100000000000006,"2022-09-01","2023-07-15",4309),
  (10006,"618",100000000000007,"2023-01-13","2024-11-10",6612),
  (10007,"632",100000000000008,"2022-12-28","2024-04-02",7935),
  (10008,"989",100000000000009,"2021-12-05","2023-03-30",2831),
  (10009,"457",100000000000010,"2022-04-22","2023-11-11",3422);
  (10010,"265",100000000000011,"2022-08-20","2024-12-15",8405),
  (10011,"316",100000000000012,"2022-06-01","2024-05-24",1378),
  (10012,"634",100000000000013,"2022-01-17","2023-06-15",8532),
  (10013,"873",100000000000014,"2021-07-30","2024-10-01",9891),
  (10014,"492",100000000000015,"2021-08-29","2024-12-13",6748),
  (10015,"120",100000000000016,"2021-12-25","2024-02-09",1643),
  (10016,"413",100000000000017,"2022-12-26","2024-12-24",4040),
  (10017,"798",100000000000018,"2021-09-23","2024-02-25",6787),
  (10018,"743",100000000000019,"2022-07-14","2025-01-21",3900),
  (10019,"923",100000000000020,"2022-04-10","2024-10-07",3241);
  (10020,"972",100000000000021,"2022-11-30","2023-03-07",1904),
  (10021,"781",100000000000022,"2021-07-30","2025-01-04",3557),
  (10022,"733",100000000000023,"2021-04-01","2023-11-01",1137),
  (10023,"738",100000000000024,"2021-03-20","2024-11-01",5622),
  (10024,"652",100000000000025,"2022-05-01","2025-02-18",5561),
  (10025,"243",100000000000026,"2022-09-14","2023-04-01",1477),
  (10026,"306",100000000000027,"2022-07-06","2023-12-20",7853),
  (10027,"372",100000000000028,"2021-04-30","2023-04-08",9551),
  (10028,"607",100000000000029,"2022-04-18","2023-10-11",5331),
  (10029,"317",100000000000030,"2021-07-18","2024-08-09",8417);
  (10030,"442",100000000000031,"2021-10-23","2023-12-05",8719),
  (10031,"893",100000000000032,"2021-09-30","2023-09-30",8097),
  (10032,"363",100000000000033,"2021-07-26","2023-10-11",1218),
  (10033,"174",100000000000034,"2022-05-28","2023-04-04",6271),
  (10034,"414",100000000000035,"2022-10-13","2025-01-08",9713),
  (10035,"686",100000000000036,"2022-11-02","2024-11-17",8811),
  (10036,"659",100000000000037,"2021-12-21","2024-06-27",7626),
  (10037,"809",100000000000038,"2021-05-23","2024-05-05",7872),
  (10038,"195",100000000000039,"2022-05-04","2024-07-20",9136),
  (10039,"929",100000000000040,"2022-07-11","2024-03-23",1455);
  (10040,"756",100000000000041,"2022-01-03","2024-06-30",4293),
  (10041,"127",100000000000042,"2022-09-08","2023-03-10",2001),
  (10042,"834",100000000000043,"2022-02-03","2023-05-08",2026),
  (10043,"252",100000000000044,"2022-02-08","2024-06-28",4144),
  (10044,"123",100000000000045,"2021-05-02","2024-08-19",4319),
  (10045,"669",100000000000046,"2022-03-27","2024-11-17",8997),
  (10046,"330",100000000000047,"2022-05-26","2024-08-10",8383),
  (10047,"746",100000000000048,"2022-10-24","2024-03-25",1191),
  (10048,"812",100000000000049,"2021-08-04","2023-12-06",6713),
  (10049,"854",100000000000050,"2022-09-28","2023-10-21",1638);
  (10050,"643",100000000000051,"2022-01-30","2024-06-19",5544),
  (10051,"946",100000000000052,"2023-02-21","2024-02-11",9006),
  (10052,"592",100000000000053,"2021-03-10","2023-05-28",6785),
  (10053,"704",100000000000054,"2022-08-03","2023-05-28",3889),
  (10054,"597",100000000000055,"2021-04-21","2023-04-10",9999),
  (10055,"733",100000000000056,"2023-02-19","2023-09-24",7763),
  (10056,"635",100000000000057,"2021-04-21","2024-02-17",8050),
  (10057,"596",100000000000058,"2021-12-05","2023-12-04",9189),
  (10058,"423",100000000000059,"2022-08-31","2024-01-25",2870),
  (10059,"702",100000000000060,"2022-08-17","2024-08-13",7138);
  (10060,"145",100000000000061,"2021-02-28","2023-09-21",9842),
  (10061,"118",100000000000062,"2022-07-07","2024-09-08",9091),
  (10062,"664",100000000000063,"2022-06-28","2024-07-04",8465),
  (10063,"641",100000000000064,"2021-04-07","2025-02-05",2916),
  (10064,"761",100000000000065,"2022-08-10","2024-04-22",3981),
  (10065,"335",100000000000066,"2022-03-26","2024-11-05",7801),
  (10066,"395",100000000000067,"2022-01-06","2024-02-05",2306),
  (10067,"511",100000000000068,"2021-03-14","2023-03-28",8274),
  (10068,"764",100000000000069,"2022-02-04","2024-03-07",1255),
  (10069,"798",100000000000070,"2021-05-28","2023-09-01",8259);
  (10070,"224",100000000000071,"2022-01-10","2024-01-30",6442),
  (10071,"599",100000000000072,"2022-04-10","2023-08-31",4291),
  (10072,"750",100000000000073,"2021-05-16","2024-12-21",8074),
  (10073,"207",100000000000074,"2022-08-08","2024-04-02",4907),
  (10074,"354",100000000000075,"2022-07-07","2024-05-09",1867),
  (10075,"166",100000000000076,"2022-03-08","2024-12-22",3390),
  (10076,"769",100000000000077,"2021-05-05","2024-04-04",3546),
  (10077,"955",100000000000078,"2023-02-03","2023-04-04",9554),
  (10078,"398",100000000000079,"2023-01-15","2024-11-30",6189),
  (10079,"408",100000000000080,"2023-02-02","2024-06-21",1561);
  (10080,"639",100000000000081,"2022-01-26","2024-10-12",1977),
  (10081,"378",100000000000082,"2022-03-14","2024-04-06",5700),
  (10082,"141",100000000000083,"2021-06-16","2023-12-09",3929),
  (10083,"973",100000000000084,"2022-08-26","2023-10-12",1414),
  (10084,"440",100000000000085,"2022-02-03","2025-02-20",3986),
  (10085,"646",100000000000086,"2022-03-19","2024-02-22",1522),
  (10086,"318",100000000000087,"2022-01-14","2024-12-21",7494),
  (10087,"789",100000000000088,"2022-10-17","2025-01-28",1113),
  (10088,"638",100000000000089,"2022-09-03","2024-03-21",3874),
  (10089,"864",100000000000090,"2022-05-05","2024-09-30",2887);
  (10090,"308",100000000000091,"2022-03-17","2024-10-10",7008),
  (10091,"162",100000000000092,"2022-02-18","2024-06-22",1452),
  (10092,"771",100000000000093,"2023-01-06","2024-11-03",6133),
  (10093,"722",100000000000094,"2022-02-17","2024-03-15",5654),
  (10094,"381",100000000000095,"2022-11-05","2024-08-06",3002),
  (10095,"961",100000000000096,"2021-09-04","2023-06-18",9115),
  (10096,"993",100000000000097,"2022-06-28","2024-01-26",2638),
  (10097,"485",100000000000098,"2021-07-20","2025-01-15",4165),
  (10098,"122",100000000000099,"2022-05-15","2024-10-29",4282),
  (10099,"373",100000000000100,"2021-10-07","2023-12-20",7456);
