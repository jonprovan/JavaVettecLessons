SELECT * FROM cellphones;

INSERT INTO cellphones
VALUES
	(1, 'Red', 'Apple', 'X', 'Verizon', 230, 16, null),
    (2, 'Red', 'Blackberry', 'GSM', 'AT&T', 200, 4, null),
    (3, 'Black', 'Samsung', 'Galaxy', 'AT&T', 245, 10, null),
    (4, 'Black', 'OnePlus', '11', 'Verizon', 256, 7, null),
    (5, 'Grey', 'Jitterbug', 'Flip2', 'Sprint', 100, 3, null);
    
# If you want to change a value you can use an UPDATE
# Because we are in safe update mode we need to use the primary key for updates
# and we need a WHERE clause. If we did not have those, we would be updating 
# every entry in the table
UPDATE cellphones SET ScreenSize = 6 WHERE PhoneNumber = 3;

UPDATE cellphones SET ScreenSize = 6 WHERE PhoneNumber = 1;

UPDATE cellphones SET Color = 'Blue' WHERE PhoneNumber = 3;

UPDATE cellphones SET Carrier = 'T-Mobile' WHERE PhoneNumber = 5;

SELECT * FROM cellphones;
# Updates will let you change the primary key, but this can cause conflicts 
# with auto incrementing
UPDATE cellphones SET PhoneNumber = 6 WHERE PhoneNumber = 5;
UPDATE cellphones SET PhoneNumber = 5 WHERE PhoneNumber = 6;

# Cannot add in a duplicate primary key, but can update to on that is not in use
UPDATE cellphones SET PhoneNumber = 3 WHERE PhoneNumber = 5;

# General syntax for updates is
# UPDATE <what?> SET <what field?> = <value> WHERE <primary key>;

SELECT * FROM positions;

#In UPDATE queries, you can also specify multiple fields to update
UPDATE positions SET Company = 'Justice League', Description = 'Super Hero', Salary = 0 WHERE JobId = 3;

UPDATE positions SET Company = 'Justice League', Description = 'Super Hero', Salary = 0 WHERE JobId = 4;

UPDATE positions SET Company = 'Skillstorm', Description = 'Marketing Lead', Salary = 200000.00 WHERE JobId = 1;

UPDATE positions SET Company = 'None', Salary = 0, Description = 'Jobless' WHERE JobId = 5;

UPDATE positions SET Company = 'Skillstorm', Description = 'Trainer', Salary = 72000.00 WHERE JobId = 2;

UPDATE positions SET Company = 'Rebellion', Description = 'Sniper', Salary = 0 WHERE JobId = 6;

UPDATE positions SET Title = 'President', Description = 'World Leader', Salary = 2 WHERE JobId = 5;

#Updates can be re-run and wont affect the data
UPDATE positions SET Company = 'USA' WHERE JobId = 5;

INSERT INTO positions 
	(Title, Company, Salary, Description)
Values ('Bat that Laughs', 'Gotham', 100, 'Earth 22');
