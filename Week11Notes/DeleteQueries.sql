SELECT * FROM inventory;

# To remove data from a database table, you use a DELETE
# Your DELETE queries need a WHERE clause or else they will try to 
# delete everything in your table
DELETE FROM inventory WHERE ProductId = 9;

DELETE FROM inventory WHERE ProductId = 10;

# DELETE queries can be run multiple times, multiple runs won't affect the table
# You can only remove something once
DELETE FROM inventory WHERE ProductId = 9;

# In safe update mode, you can only delete from the table with a where clause
# That uses the primary key
DELETE FROM inventory WHERE Warehouse = 'Amazon';

# formatted as
# DELETE FROM <where?> WHERE <primary key>;

# Even after you DELETE something, the auto increment doesnt reset
INSERT INTO inventory
	(Warehouse, Destination, ProductType)
VALUES ('Walmart', 'Unknown', 'Cellphone');

SELECT * FROM inventory;
