DROP TABLE Emp_1513101;
CREATE TABLE Emp_1513101(
	EMPID Number(6) PRIMARY KEY,
	NAME Varchar2(50) not null,
	DESIGNATION Varchar2(25) not null,
	EXPERIENCE Number(3) not null,
	MOBILE Number(10) not null,
	SALARY Number(7,2));
	
select * from Emp_1513101

CREATE SEQUENCE Emp_1513101_id
  START WITH 1
  INCREMENT BY 1;
  
  drop sequence Emp_1513101_id
	
INSERT INTO Emp_1513101 VALUES(10001,'Ajay', 'ASE',3,1234567890, 12000.00);
INSERT INTO Emp_1513101 VALUES(10002,'Ram', 'Kumar', 18000.00);