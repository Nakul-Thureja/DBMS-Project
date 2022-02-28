-- Query to print the maximum salary of employee branch wise.
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
