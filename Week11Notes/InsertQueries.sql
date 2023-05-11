# We are going to insert our data from Excel into our tables
# To insert data into your tables you use an insert query

# We dont need to add the primary key, because MySQL does that for us
# Date format for mySQL is 'yyyy-MM-DD'
INSERT INTO inventory 
VALUES (1, 'Amazon', 'La Bibilioteca', 'Computer', '2023-05-04', 'Dan Pickles', '2023-05-05');

# I do not need to insert columns that mySQL auto increments, but if i do not insert it
# I need to help mySQL out
# When sql runs an insert statement it matches the columns in the order they are defined with
# What you hand it
# If i do not hand it exact columns I need to tell it which columns I handed it
INSERT INTO inventory 
	(Warehouse, Destination, ProductType, LabelCreated, Handler, LastHandled)
VALUES ('UPS', 'Unknown', 'Printer', '2023-05-02', 'Dan Pickles', '2023-05-03');

INSERT INTO inventory
	(Warehouse, Destination, ProductType, LabelCreated, Handler, LastHandled)
Values ('Target', 'US Army', 'Trumpet', '2023-04-21', 'Dan Pickles', '2023-04-22');

# Insert statements do change your table, so if i run a repeat insert statements I will get
# repeat data
INSERT INTO inventory
VALUES (4, 'Best Buy', 'Gym', 'TV', '2023-01-02', 'Dan Pickles', '2023-01-03');

# Insert statements are always formatted as 
# INSERT INTO <Where?> VALUES (<Actual Data>);
# More commonly -> INSERT INTO <Where?> (<What Values?>) VALUES (<Actual Data>);

INSERT INTO inventory
	(Warehouse, Destination, ProductType, LabelCreated, Handler, LastHandled)
VALUES ('Pep Boys', 'US Army', 'Pen', '2023-05-02', 'Dan Pickles', '2023-05-03');

INSERT INTO inventory
	(Warehouse, Destination, ProductType, LabelCreated, Handler, LastHandled)
VALUES  ('Walmart', 'Unknown', 'Suitcase', '2023-05-06', 'Dan Pickles', '2023-05-07');

INSERT INTO inventory
	(Warehouse, Destination, ProductType, LabelCreated, Handler, LastHandled)
VALUES  ('Office Depot', 'US Coast Guard', 'Desk', '2023-03-15', 'Dan Pickles', '2023-03-16');

INSERT INTO inventory
	(Warehouse, Destination, ProductType, LabelCreated, Handler, LastHandled)
VALUES  ('Kmart', 'US Airforce', 'Chair', '2023-04-05', 'Dan Pickles', '2023-04-06');

#Numeric types do not need quotes
INSERT INTO movies
	(Title, ReleaseYear, Genre, Rating, GrossProfit, Cost, Runtime, ReviewScore)
VALUES ('Training Day', 2001, 'Crime Thriller', 'R', 104900000.00, 45000000.00, 122, 7.7);

-- ----------------------------------------------------------------------------- --
INSERT INTO movies
	(Title, ReleaseYear, Genre, Rating, GrossProfit, Cost, Runtime, ReviewScore)
VALUES ('Red Dawn', 1984, 'Action', 'PG-13', 39900000.00, 17000000.00, 114, 6.3);

INSERT INTO movies
	(Title, ReleaseYear, Genre, Rating, GrossProfit, Cost, Runtime, ReviewScore)
VALUES ('Love and Basketball', 2000, 'Romance', 'PG-13', 27700000.00, 20000000.00, 127, 7.2);

INSERT INTO movies
	(Title, ReleaseYear, Genre, Rating, GrossProfit, Cost, Runtime, ReviewScore)
VALUES ('Forest Gump', 1994, 'Romance', 'PG-13', 678226465.00, 55000000.00, 142, 8.8);

INSERT INTO movies
	(Title, ReleaseYear, Genre, Rating, GrossProfit, Cost, Runtime, ReviewScore)
VALUES ('Oceans 11', 1960, 'Comedy', 'N/A', 5500000.00, 5000000.00, 127, 6.5);

INSERT INTO movies
	(Title, ReleaseYear, Genre, Rating, GrossProfit, Cost, Runtime, ReviewScore)
VALUES ('Deadpool', 2016, 'Action', 'R', 782600000.00, 58000000.00, 108, 8);

INSERT INTO movies
	(Title, ReleaseYear, Genre, Rating, GrossProfit, Cost, Runtime, ReviewScore)
VALUES ('Detective Pikachu', 2019, 'Comedy', 'PG', 449762638.00, 150000000.00, 104, 6.5);

INSERT INTO movies
	(Title, ReleaseYear, Genre, Rating, GrossProfit, Cost, Runtime, ReviewScore)
VALUES ('Heat', 1995, 'Drama', 'R', 187436818.00, 60000000.00, 170, 8.3);


# Insert statements involve typing the same values  repeated, so there is a time saver
# I can attach all of my rows I want to insert to the same insert statement
# This is a batch insert query
INSERT INTO samurai 
	(Name, Weapon, Armor, Mask, FollowsCode, SkillLevel)
VALUES 
	('Tom Cruise', 'Katana', 'Heavy', 'Oni', 1, 1),
    ('Jin Sakai', 'Katana', 'Medium', 'Sakai Clan', 0, 10),
    ('Yasuke', 'Katana', 'Medium', 'None', 1, 10),
    ('Jack', 'Katana', 'Light', 'None', 1, 10),
    ('Afro', 'Katana', 'Light', 'None', 0, 10),
    ('Miyamoto Musashi', 'Katana', 'Heavy', 'Oni', 1, 10),
    ('Hattori Hanzo', 'Katana', 'Light', 'Oni', 0, 9),
    ('Oda Nobunaga', 'Katana', 'Heavy', 'Oni', 1, 7),
    ('Keanu Reeves', 'Katana', 'Medium', 'None', 0, 10);

# Backticks tell SQL it is a string literal, and that SQL should not try to parse it
# Because it is literal text it has no meaning, so SQL does not parse it
INSERT INTO battles
	(`Name`, `Terrain`, `Location`, `Weather`, `Year`, `Commanders`)
VALUES
	('Java', 'Eclipse', 'Main Method', 'Spring', 1995, 3),
    ('6 Fronts', 'Mountain', 'Twilight Gap', 'Snowy', 2000, 6),
    ('Html, CSS, JS', 'CORS', 'Frontend', 'Rainy', 1995, 3),
    ('Tatooine', 'Desert', 'A New Hope', 'Sunny', 1977, 7),
    ('Certification', 'Foundation', 'The Web', 'Foggy', 2023, 2);
    
INSERT INTO destinations
	(LocationName, City, Country, Price, Airline, Packages, Attractions, Language, DepartureDate, ReturnDate)
VALUES
	('Costa Rica', 'San Jose', 'Costa Rica', 1000000.00, 'United Emirates', 'Firster Class', 'Beaches, corcovado national park, one man submarine', 'Spanish, English', '2023-05-03', '2023-05-07'),
    ('Pittsburg', 'Pittsburg', 'USE', 5000.00, 'American Airlines', 'Economy', 'Zip-lining, Fields', 'English', '2023-05-04', '2023-05-04'),
    ('Egypt', 'Cairo', 'Egypt', 3500.00, 'Delta', 'Upper Class', 'Parasailing', 'Egyptian', '2023-04-21', '2023-04-25'),
    ('Norway', 'Oslo', 'Norway', 4650.00, 'Air Canada', 'Business Plus', 'Skiing', 'Norwegian', '2023-03-01', '2023-03-10'),
    ('Jakarta', 'Jakarta', 'Indonesia', 7634.00, 'Frontier', 'Economy Plus', 'Jungles, Ruins', 'Indonesian', '2023-06-03', '2023-06-06');

# Since the other columns in this tbale are nullable, I do not need to insert them
INSERT INTO positions
	(JobId, Title)
VALUES
	(1, 'VP of Products'),
    (2, 'Trainer'),
    (3, 'Batman'),
    (4, 'Superman'),
    (5, 'None'),
    (6, 'Rebel');

INSERT INTO people
VALUES
	(1, 'Dan', 'Pickles', 'Blonde', '1993-01-12', 'O+', 'Spanish', 1),
    (2, 'Miles', 'Mixon', 'Black', '1990-07-13', 'B+', 'English', 2),
    (3, 'Bruce', 'Wayne', 'Black', '1955-03-04', 'O+', 'English', 3),
    (4, 'Clark', 'Kent', 'Black', '1955-03-06', 'A-', 'Kryptonian', 4),
    (5, 'Shaggy', 'Rogers', 'Brown', '1969-07-10', 'B+', 'English', 5),
    (6, 'Jonathan', 'Provan', 'Brown', '1985-09-20', 'A-', 'English', 2),
    (7, 'Sabine', 'Wren', 'Purple', '4135-10-21', 'O+', 'Spanish', 6);
