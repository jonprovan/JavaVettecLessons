# Normalization - A design principle that is used to reduce data redundancy to save disk space and help remove
# 				  inaccuracies in your data
/*
	- 3 Main Forms
		- 1st Normal Form (1NF):
				1. Every entry has a primary key
                2. No Repeating Groups - Every column has one entry (No comma separated values)
        - 2nd Normal Form (2NF):
				1. 1NF
                2. No Partial Dependencies - No columns are determined by only one part of the 
											 primary key
        - 3rd Normal Form (3NF):
*/

# Add data into languages, attractions, destinationlanguages, and locationattractions
INSERT INTO languages (Name)
VALUES 
	('Spanish'),
    ('English'),
    ('Egyptian'),
    ('Norwegian'),
    ('Indonesian');
    
INSERT INTO destinationlanguages
VALUES
	(1,1),
    (1,2),
    (2,2),
    (3,3),
    (4,4),
    (5,5);
    
INSERT INTO attractions (Name)
VALUES
	('Beaches'),
    ('National Parks'),
    ('One Man Submarine'),
    ('Zip-lining'),
    ('Fields'),
    ('Parasailing'),
    ('Skiing'),
    ('Jungles'),
    ('Ruins');
    
INSERT INTO locationattractions
VALUES 
	(1,1),
    (1,2),
    (1,3),
    (2,4),
    (2,5),
    (3,6),
	(4,7),
	(5,8),
	(5,9);

# SELECT every location and it's attractions	
SELECT * 
FROM ((destinations
	INNER JOIN locationattractions ON destinations.locationId = locationattractions.locationId)
    LEFT JOIN attractions ON attractions.attractionId = locationattractions.attractionId);
    
    
INSERT INTO destinationlanguages VALUES (4, 2);

SELECT * 
FROM ((destinations
	INNER JOIN destinationlanguages ON destinations.locationId = destinationlanguages.locationid)
    INNER JOIN languages ON languages.languageId = destinationlanguages.languageId)
WHERE languages.Name = 'English';
