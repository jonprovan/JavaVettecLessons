INSERT INTO vehicles
VALUES 
	('1NG2H3TY5', 'Oscar Myer',	'Weiner Mobile', 1998, 'Yellow', 4, 'Ultra', 30000.00, 150, 4),
	('3NTY6J745S', 'Reliant',	'Robin', 1973, 'Blue', 2, 'Base', 45000.00, 70, null),
    ('SY7TH862N', 'Nissan',	'Altima', 2023, 'Black', 4, 'SR', 45000.00, 130, 2),
    ('NJY7862NB', 'International', 'Scout II',	1973, 'Red', 2, 'Ultra', 56900.00, 120, 6),
    ('BT62G9172', 'Peel', 'p50', 1962, 'Red', 1, 'Mini', 131500.80, 40,	null),
    ('FF87SON90', 'Dodge', 'Mystery Machine', 1969,	'Green', 5, 'Mysterieous', 200000.00, 120, 5),
    ('87SDI32N3', 'DMC-12', 'Delorean',	1981, 'Silver', 2, 'Doc Special', 300000.00, 88, 5),
    ('BY7WN9P9', 'Boat', 'Mobile', 1990, 'Invisible', 2, 'Invisible', 80000.00, 100, 1),
    ('BNED6435W', 'Lincoln', 'Futura', 1955, 'Black', 2, 'Bat',	250000.00, 200, 3);

# How would we use related tables/ data

# In order to grab related information you use a JOIN
# A join combines the data of multiple tables and returns it

-- LEFT JOIN : Takes everything from the left table and anything that matches on the right table

# In JOINS you need to tell them what column they are matching on using an ON
# SELECT * FROM Table1 LEFT JOIN Table2 ON <Table1>.<Column> = <Table2>.<Column>;

SELECT * FROM people LEFT JOIN vehicles ON people.PersonId = vehicles.OwnerId;

# In a LEFT JOIN you get everything from the left table, and if there is no match in the
# right table you get null
