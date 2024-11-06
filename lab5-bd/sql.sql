-- consulta 1: recupera pedidos con muchos artículos y calcula el precio total.
SELECT Orders.OrderID, SUM(OrderDetails.Quantity * OrderDetails.UnitPrice) AS TotalPrice
FROM Orders
JOIN OrderDetails ON Orders.OrderID = OrderDetails.OrderID
WHERE OrderDetails.Quantity > 10
GROUP BY Orders.OrderID;

-- Optimizacion: crear índices
CREATE INDEX idx_orderdetails_orderid ON OrderDetails(OrderID);
CREATE INDEX idx_orderdetails_quantity ON OrderDetails(Quantity);

-- Consulta optimizada
SELECT Orders.OrderID, SUM(OrderDetails.Quantity * OrderDetails.UnitPrice) AS TotalPrice
FROM Orders
JOIN (
    SELECT OrderID, Quantity, UnitPrice
    FROM OrderDetails
    WHERE Quantity > 10
) AS OrderDetailsFiltered ON Orders.OrderID = OrderDetailsFiltered.OrderID
GROUP BY Orders.OrderID;





-- consulta 2: encuentre todos los clientes de Londres y ordene por nombre de cliente
SELECT CustomerName FROM Customers WHERE City = 'London' ORDER BY CustomerName;

-- Optimizacion: crear índices
CREATE INDEX idx_customers_city ON Customers(City);

-- Consulta optimizada seria la misma que la original
SELECT CustomerName FROM Customers WHERE City = 'London' ORDER BY CustomerName;