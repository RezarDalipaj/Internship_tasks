use classicmodels;
-- query 1)
select max(nrOfOrders) AS maxOrders, customerName from(select COUNT(orderNumber) AS nrOfOrders, customers.customerNumber, customerName from orders
JOIN customers
ON orders.customerNumber = customers.customerNumber
group by customerNumber
order by nrOfOrders DESC) as T
having maxOrders = max(nrOfOrders);
-- query 2)
select c.customerNumber, c.customerName, c.country, odet.*
from customers as c
join orders as o
join orderdetails as odet
on c.customerNumber = o.customerNumber and o.orderNumber = odet.orderNumber
where c.country = 'Germany';
-- query 3)
select emp.employeeNumber, emp.firstName, emp.lastName, SUM(pay.amount) as totalAmount
from payments as pay
join customers as c
join employees as emp
on pay.customerNumber = c.customerNumber and c.salesRepEmployeeNumber = emp.employeeNumber
group by emp.employeeNumber;
-- query 4)
select p.productCode, p.productName, o.orderDate
from products as p
join orderdetails as odet
join orders as o
on p.productCode = odet.productCode and o.orderNumber = odet.orderNumber
where o.orderDate < '2005-01-01' and orderDate > '2004-11-30';
-- query 5)
drop table employeedetails;
create table employeedetails (
employeedetailsId int,
employeeNumber int,
bankAccount text,
address text,
phoneNumber text,
primary key(employeedetailsId),
foreign key(employeeNumber) references employees(employeeNumber)
)
select * from employeedetails;

