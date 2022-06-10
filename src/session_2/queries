use classicmodels;
-- kerkesa A)
select max(nrOfOrders) AS maxOrders, customerName from(select COUNT(orderNumber) AS nrOfOrders, customerName from orders
JOIN customers
ON orders.customerNumber = customers.customerNumber
group by customerName) as T
having maxOrders = max(nrOfOrders);
-- kerkesa B)
select customers.customerName, customers.country, O.customerNumber, O.orderNumber, O.productCode, O.quantityOrdered, O.priceEach, O.orderLineNumber
from customers
JOIN (select orders.customerNumber, orderdetails.orderNumber, productCode, quantityOrdered, priceEach, orderLineNumber   from orders
JOIN orderdetails
ON orders.orderNumber = orderdetails.orderNumber) AS O
WHERE country = 'Germany';
-- kerkesa C)
select employees.employeeNumber, employees.firstName, employees.lastName, N.paymentDate, N.amount from employees
JOIN (select payments.customerNumber, payments.amount, payments.paymentDate, customers.salesRepEmployeeNumber from payments
JOIN customers
ON customers.customerNumber = payments.customerNumber) AS N;
-- kerkesa D)
select M.orderNumber, products.productName, M.orderDate from products
JOIN (select orders.orderNumber, orderdetails.productCode, orders.orderDate from orders
JOIN orderdetails
ON orders.orderNumber = orderdetails.orderNumber
where orderDate < '2005-01-01' and orderDate > '2004-11-30') AS M
group by productName;
-- kerkesa E)
create table employeedetails AS
select employeeNumber, email as personalEmail from
employees;
alter table employeedetails
add bankAccount text;
alter table employeedetails
add address text;
alter table employeedetails
add phoneNumber text;
select * from employeedetails;

