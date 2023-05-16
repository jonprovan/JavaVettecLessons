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

SELECT * FROM vehicles;

# How would we use related tables/ data

# In order to grab related information you use a JOIN
# A join combines the data of multiple tables and returns it

-- LEFT JOIN : Takes everything from the left table and anything that matches on the right table

# In JOINS you need to tell them what column they are matching on using an ON
# SELECT * FROM Table1 LEFT JOIN Table2 ON <Table1>.<Column> = <Table2>.<Column>;

SELECT * FROM people LEFT JOIN vehicles ON people.PersonId = vehicles.OwnerId;

# In a LEFT JOIN you get everything from the left table, and if there is no match in the
# right table you get null

# The same statement as above, but with a different ordering of columns
SELECT 
	First, Last, HairColor, Birthday, BloodType, FirstLanguage, Job, PersonId, 
    OwnerId, VIN, Make, Model, Year, Color, Doors, Trim, Price, TopSpeed
FROM people LEFT JOIN vehicles
ON PersonId = OwnerId;

# Same as above, but with less columns being returned
SELECT
	PersonId, First, Last, Make, Model, Year, Color
FROM people LEFT JOIN vehicles
ON PersonId = OwnerId;

# Grab every person and their job information
SELECT * FROM people LEFT JOIN positions ON Job = JobId;

-- RIGHT JOIN
# Grabs everything in the right table and any matches on the left
# Same as with left joins, if there are no matches, it returns null
SELECT * FROM people RIGHT JOIN vehicles ON PersonId = OwnerId;

SELECT * FROM vehicles RIGHT JOIN people on PersonId = OwnerId;

SELECT * FROM people LEFT JOIN positions ON Job = JobId;

SELECT * FROM people RIGHT JOIN positions ON Job = JobId;

# The On tells the Join what condition it is using to connect the data
# If there is no condition to join on SQL does a Cross Join, which joins every row
# in table 1 with every row in table 2
# It is very expensive and should be avoided
SELECT * FROM people JOIN positions;

# Inner Join joins only the columns that have a match in both tables
SELECT * FROM people INNER JOIN vehicles ON PersonId = OwnerId;

# Without the On clause this does a cross join
SELECT * FROM people INNER JOIN vehicles;

# JOINS can be combined
# They can be chained together to create much larger result sets
# Select all people, their vehicle, and their job
SELECT * 
FROM ((people 
	LEFT JOIN vehicles ON PersonId = OwnerId)
	LEFT JOIN positions ON Job = JobId);

# It combines these one at a time
SELECT * 
FROM ((people 
	INNER JOIN vehicles ON PersonId = OwnerId)
	LEFT JOIN positions ON Job = JobId);

SELECT * FROM cellphones;

UPDATE cellphones SET OwnerID = 1 WHERE PhoneNumber = 4;
UPDATE cellphones SET OwnerID = 7 WHERE PhoneNumber = 3;
UPDATE cellphones SET OwnerID = 3 WHERE PhoneNumber = 1;
UPDATE cellphones SET OwnerID = 4 WHERE PhoneNumber = 2;
UPDATE cellphones SET OwnerID = 2 WHERE PhoneNumber = 5;

SELECT * 
FROM (((people 
	INNER JOIN vehicles ON PersonId = vehicles.OwnerId)
	LEFT JOIN positions ON Job = JobId)
	LEFT JOIN cellphones ON PersonId = cellphones.OwnerId);

# Can still add a where clause with your joins to further filter them
SELECT * 
FROM (((people 
	INNER JOIN vehicles ON PersonId = vehicles.OwnerId)
	LEFT JOIN positions ON Job = JobId)
	LEFT JOIN cellphones ON PersonId = cellphones.OwnerId) WHERE company = 'Justice League';

# For SQL statements you can always specifically reference the field in a table by giving it the table name
# Need to specify the table only when there are multiple columns with the same name accross tables (for instance color or OwnerId)
SELECT people.PersonId, people.First, people.Last, vehicles.Make, vehicles.Model, Vehicles.Year, Vehicles.color, 
	positions.title, positions.company, positions.salary, cellphones.PhoneNumber, cellphones.Color, cellphones.Brand,
    cellphones.Model, cellphones.carrier
FROM (((people 
	INNER JOIN vehicles ON people.PersonId = vehicles.OwnerId)
	LEFT JOIN positions ON people.Job = positions.JobId)
	LEFT JOIN cellphones ON people.PersonId = cellphones.OwnerId);

# All of the above are explicit joins, because I am telling SQL what to do I can do left, right, inner, etc joins
# SQL also gives the option to use implicit joins

# comma separating the tables creates an implicit join, if no condition is given you get a Cross join
SELECT * FROM people, vehicles;

# The ON clause only applies to explicit joins
# For implicit join you use a where clause
SELECT * FROM people, vehicles WHERE PersonId = OwnerId; # Does an inner join
# These two queries do the exact same thing
SELECT * FROM people INNER JOIN vehicles ON PersonId = OwnerId;

# Both of these queries do the exact same thing
SELECT * FROM people, vehicles WHERE PersonId = OwnerId AND FirstLanguage = 'English';
SELECT * FROM people INNER JOIN vehicles ON PersonId = OwnerId WHERE FirstLanguage = 'English';

SELECT * FROM samurai;
SELECT * FROM battles;

# Grab samurai.Name, Weapon, Armor, battle.Name, Location, Year for samurai and their battles
# Grab every samurai and any battles they have been a part of
SELECT samurai.Name, weapon, armor, battles.Name, location, Year
FROM ((samurai 
	LEFT JOIN samuraibattles ON samurai.SamuraiId = samuraibattles.SamuraiId)
	LEFT JOIN battles ON samuraibattles.BattleId = battles.BattleId);
    
# Does the same as above, but only for the samurai that were a part of the Battle of Java
SELECT samurai.Name, weapon, armor, battles.Name, location, Year
FROM ((samurai 
	LEFT JOIN samuraibattles ON samurai.SamuraiId = samuraibattles.SamuraiId)
	LEFT JOIN battles ON samuraibattles.BattleId = battles.BattleId)
WHERE battles.Name = 'Java';

# the above as an implicit join
# implicit joins cannot do left joins, but all of our samurai were a part of a battle
SELECT samurai.Name, weapon, armor, battles.Name, location, Year
FROM samurai, samuraibattles, battles
WHERE 
	samurai.SamuraiId = samuraibattles.SamuraiId 
	AND samuraibattles.BattleId = battles.BattleId 
    AND battles.Name = 'Java';

# The above, but just grabs the samurai information
# grab all the samurai information that were a part of xyz battle
SELECT samurai.Name, weapon, armor, SkillLevel
FROM ((samurai 
	LEFT JOIN samuraibattles ON samurai.SamuraiId = samuraibattles.SamuraiId)
	LEFT JOIN battles ON samuraibattles.BattleId = battles.BattleId)
WHERE battles.Name = 'Java';

# Cannot do a full join in MySQL it is not supported, but can get close with a UNION
# UNION takes two queries and combines the results. For this to work the two queries have
# to query the same columns in the same table/ tables
SELECT * FROM samurai WHERE SamuraiId < 3
UNION
SELECT * FROM samurai WHERE SamuraiId > 6;

# combining a left join and a right join is effectively the same as a full join, but not an actual full join
SELECT * FROM people LEFT JOIN vehicles ON PersonId = OwnerId
UNION
SELECT * FROM people RIGHT JOIN vehicles ON PersonId = OwnerId;

# Does not work when the number of columns is different, and not as useful when the tables are different
# SELECT * FROM samurai WHERE SamuraiId < 4
# UNION 
# SELECT * FROM cellphones;
