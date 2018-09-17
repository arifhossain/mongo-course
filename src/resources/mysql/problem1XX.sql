# ----------------------------- Problem 182 -----------------------
#Write a SQL query to find all duplicate emails in a table named Person (Id, Email)

select email from (
select e.email as email, count(e.id) as Counter from Person e
group by e.email
having Counter >1) AS emaillist;

# ----------------------------- Problem 183 -----------------------

# Suppose that a website contains two tables, the Customers (ID, Name) table and the Orders(ID, CustomerID) table.
# Write a SQL query to find all customers who never order anything.


select c.name as Customers from customers c where ID not in (select customerid from orders);


