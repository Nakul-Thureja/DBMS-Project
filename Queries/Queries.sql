---- Query to print the maximum salary of employee branch wise.
select B.BranchNo,Max(E.salary) as MaxSalary from Branch B,Employee E,Works W 
where W.BranchNo = B.BranchNo and E.EmpID = W.EmpID
group by B.BranchNo;

-- Query to print the customer name having more than 5 Transactions as sender
Select C.name,count(*) from Customer C,Accounts A, Transactions T 
where A.cid = C.cid and T.SenderAccNo = A.AccNo
group by C.cid 
Having count(*)>=5;

-- Query to print customer id of customers having Accounts and Loan Account such that both accounts are not in the same branch 
select C.cid,A.BranchNo as AccBranch,L.BranchNo as LoanBranch from Customer C,Accounts A,Loan L 
where C.cid = A.cid and C.cid = L.cid and A.BranchNo != L.BranchNo;

-- Query to print passbook(All Transactions) in last 10 years
Select T.Tno,T.TransactionType,T.SenderAccNo as AccountNo,T.amount as Withdrwal,"" as Deposit ,T.DOT from Transactions T,Accounts A
where 1000000007 = A.cid and T.SenderAccNo = A.AccNo
and T.DOT >= date_sub(current_date, INTERVAL 10 YEAR)
UNION
Select T.Tno,T.TransactionType,T.ReceiverAccNo as AccountNo,"" as Withdrwal,T.amount as Deposit,T.DOT from Transactions T,Accounts A
where 1000000007 = A.cid and T.ReceiverAccNo = A.AccNo
and T.DOT >= date_sub(current_date, INTERVAL 10 YEAR)
order by DOT;

-- Query to print details of customer whose card is expiring in 2023
select A.AccNo,c.name,c.Email,cd.CardNo,cd.ExpDate from Accounts A,Customer C, Cards Cd
where c.cid = a.cid and A.AccNo = CD.AccNo  and
Cd.ExpDate between '2023-01-01' and '2024-01-01' 
order by cd.ExpDate; 

-- Query to print all employees with their branch number and Manager details
select W.EmpID,E.Name,B.ManagerID,B.BranchNo from Employee E,Branch B,Works W
where W.EmpID = E.EmpID and W.BranchNo = B.BranchNo and W.EmpID != B.ManagerID;

-- Query to print interest rates corresponding to different account type
select  A.AccNo,A.AccType,R.ROI from Customer C,Accounts A,Rates R 
where C.cid = A.cid and A.AccType = R.Type
Union 
select  L.LoanID,L.LoanType,R.ROI from Customer C,Loan L,Rates R 
where C.cid = L.cid and L.LoanType = R.Type;

-- Query to print number of loan applications based on type and status
select L.LoanType,L.status,count(*) 
from Loan L 
group by status,LoanType
order by LoanType,status;

-- Query to print branch contact details for a customer id
select B.BranchNo,B.PhoneNo,B.Address,E.Name as ManagerName,E.phoneNo as ManagerNumber 
from Accounts A, Branch B,Employee E
where A.cid = 1000000006 and A.BranchNo = B.BranchNo and B.ManagerID  = E.EmpID;

-- Query to update(decrease) the RemainingAmount of car loans by 5% as a bonus 
update Loan L
set RemainingAmount = 0.95*RemainingAmount 
where L.LoanId>0 and L.status = "approved" and L.LoanType = "car";



drop login U1000000001;
drop user U1000000001;
drop login U1000000002;
drop user U1000000002;
drop login U1000000003;
drop user U1000000003;
drop login U1000000004;
drop user U1000000004;
drop login U1000000005;
drop user U1000000005;
drop login U1000000006;
drop user U1000000006;
drop login U1000000007;
drop user U1000000007;
drop login U1000000008;
drop user U1000000008;
drop login U1000000009;
drop user U1000000009;
drop login U1000000010;
drop user U1000000010;
drop login U1000000011;
drop user U1000000011;
drop login U1000000012;
drop user U1000000012;
drop login U1000000013;
drop user U1000000013;
drop login U1000000014;
drop user U1000000014;
drop login U1000000015;
drop user U1000000015;
drop login U1000000016;
drop user U1000000016;
drop login U1000000017;
drop user U1000000017;
drop login U1000000018;
drop user U1000000018;
drop login U1000000019;
drop user U1000000019;
drop login U1000000020;
drop user U1000000020;
drop login U1000000021;
drop user U1000000021;
drop login U1000000022;
drop user U1000000022;
drop login U1000000023;
drop user U1000000023;
drop login U1000000024;
drop user U1000000024;
drop login U1000000025;
drop user U1000000025;
drop login U1000000026;
drop user U1000000026;
drop login U1000000027;
drop user U1000000027;
drop login U1000000028;
drop user U1000000028;
drop login U1000000029;
drop user U1000000029;
drop login U1000000030;
drop user U1000000030;
drop login U1000000031;
drop user U1000000031;
drop login U1000000032;
drop user U1000000032;
drop login U1000000033;
drop user U1000000033;
drop login U1000000034;
drop user U1000000034;
drop login U1000000035;
drop user U1000000035;
drop login U1000000036;
drop user U1000000036;
drop login U1000000037;
drop user U1000000037;
drop login U1000000038;
drop user U1000000038;
drop login U1000000039;
drop user U1000000039;
drop login U1000000040;
drop user U1000000040;
drop login U1000000041;
drop user U1000000041;
drop login U1000000042;
drop user U1000000042;
drop login U1000000043;
drop user U1000000043;
drop login U1000000044;
drop user U1000000044;
drop login U1000000045;
drop user U1000000045;
drop login U1000000046;
drop user U1000000046;
drop login U1000000047;
drop user U1000000047;
drop login U1000000048;
drop user U1000000048;
drop login U1000000049;
drop user U1000000049;
drop login U1000000050;
drop user U1000000050;
drop login U1000000051;
drop user U1000000051;
drop login U1000000052;
drop user U1000000052;
drop login U1000000053;
drop user U1000000053;
drop login U1000000054;
drop user U1000000054;
drop login U1000000055;
drop user U1000000055;
drop login U1000000056;
drop user U1000000056;
drop login U1000000057;
drop user U1000000057;
drop login U1000000058;
drop user U1000000058;
drop login U1000000059;
drop user U1000000059;
drop login U1000000060;
drop user U1000000060;
drop login U1000000061;
drop user U1000000061;
drop login U1000000062;
drop user U1000000062;
drop login U1000000063;
drop user U1000000063;
drop login U1000000064;
drop user U1000000064;
drop login U1000000065;
drop user U1000000065;
drop login U1000000066;
drop user U1000000066;
drop login U1000000067;
drop user U1000000067;
drop login U1000000068;
drop user U1000000068;
drop login U1000000069;
drop user U1000000069;
drop login U1000000070;
drop user U1000000070;
drop login U1000000071;
drop user U1000000071;
drop login U1000000072;
drop user U1000000072;
drop login U1000000073;
drop user U1000000073;
drop login U1000000074;
drop user U1000000074;
drop login U1000000075;
drop user U1000000075;
drop login U1000000076;
drop user U1000000076;
drop login U1000000077;
drop user U1000000077;
drop login U1000000078;
drop user U1000000078;
drop login U1000000079;
drop user U1000000079;
drop login U1000000080;
drop user U1000000080;
drop login U1000000081;
drop user U1000000081;
drop login U1000000082;
drop user U1000000082;
drop login U1000000083;
drop user U1000000083;
drop login U1000000084;
drop user U1000000084;
drop login U1000000085;
drop user U1000000085;
drop login U1000000086;
drop user U1000000086;
drop login U1000000087;
drop user U1000000087;
drop login U1000000088;
drop user U1000000088;
drop login U1000000089;
drop user U1000000089;
drop login U1000000090;
drop user U1000000090;
drop login U1000000091;
drop user U1000000091;
drop login U1000000092;
drop user U1000000092;
drop login U1000000093;
drop user U1000000093;
drop login U1000000094;
drop user U1000000094;
drop login U1000000095;
drop user U1000000095;
drop login U1000000096;
drop user U1000000096;
drop login U1000000097;
drop user U1000000097;
drop login U1000000098;
drop user U1000000098;
drop login U1000000099;
drop user U1000000099;
drop login U1000000100;
drop user U1000000100;