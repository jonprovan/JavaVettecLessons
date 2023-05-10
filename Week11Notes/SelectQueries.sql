# This is a comment in SQL
#I do not need a space

-- this is a comment in SQL
-- this type of comment needs a space

/* 
	This is a multi
    line comment in SQL
*/

# DML - Data Manipulation Language - used to affect your data
# 		What we are doing today falls under DML

# DDL - Data Definition Language - used to affect your schemas
#		What workbench shows you when you create/ update a table is DDL

# Main main MaIn MaiN - in java these are 4 different things
# in SQL they are the same thing, SQL is not case sensitive

# Statements in SQL end in ; 
# Whitespace does not matter, but semi-colons do

# Anytime you want to grab data you use a SELECT query
SELECT * FROM artist;
seLect * frOm ArTiSt; # this is the exact same query as above

SELECT * FROM album;
SeLeCT * FrOM alBUm;

SELECT * FROM track;

SELECT * FROM genre;

# Select is the important keyword above. it tells SQL what type of query it is
# Select queries are always:
# SELECT <What?> FROM <Where?>;
# the Where needs to be accessible in the current table
# same with the what

# In SQL * is a wildcard that means "all" or "everything"
# applicable to columns (the what)
SELECT * FROM track;

# I can specify the specific columns I want in my SELECT queries
# If i am selecting multiple columns they need to be comma separated
SELECT Name, Composer, UnitPrice FROM track;
SELECT Name FROM track;

# SQL is not case sensitive
SELECT TrackId, AlbUmId, MedIaTypeId FROM track;

SELECT InvoiceId, CustomerId, BillingAddress, BillingCity, BillingCountry FROM invoice;

# The order matters
# The order I query for columns is the order they are returned in
SELECT CustomerId, InvoiceId, BillingCity, BillingAddress, BillingCountry FROM invoice;

SELECT BillingAddress, BillingCity, BillingCountry, CustomerId, Total FROM invoice;

# In Java if you want to access a field on an object
# Object = track
# if i want to grab the name it would be track.Name
# SQL works in the same way
# all three of the following queries do the same thing
SELECT Name FROM track; # <- it uses the selected table for this style of query
SELECT track.Name FROM track; # it knows more specifically i am looking for the name column in track
SELECT track.Name FROM chinook.track; # most specific of all

# I can use the full database name to query databases i am not connected to
SELECT Name FROM zulmak.samurai;

SELECT * FROM track;

# I can filter the data that is returned by my select queries
# to filter I must use a WHERE clause
# SELECT <what?> FROM <Where?> WHERE <something is true>;
SELECT * FROM track WHERE TrackId > 3000;

SELECT * FROM track WHERE TrackId = 200;
/*
	Where clauses use the same logical operators we use in Java
		> Greater than
        < Less than
        = equal to (not a ==)
        <= Less than or equal to
        >= Greater than or equal to
*/

SELECT * FROM track WHERE TrackId >= 3000;
SELECT * FROM track WHERE TrackId <= 1000;
SELECT * FROM track WHERE TrackId < 1000;

# The filter criteria does not need to appear in the columns you return
SELECT Name, AlbumId, Composer FROM track WHERE UnitPrice >= 1.99;
# SELECT Name, AlbumId, Composer, UnitPrice FROM track WHERE UnitPrice >= 1.99;

/* 
	SQL has all of the same logical operators
    ! -> in SQL it is NOT
    || -> in SQL it is OR
    && -> in SQL it is AND
*/

SELECT * FROM track WHERE AlbumId > 200 AND AlbumId < 300;
SELECT * FROM track WHERE NOT UnitPrice = 0.99;
# the not operator functions very similar to this -> !(variable > 3)

# Strings in SQL are surrounded with single quotes, but double double quotes work as well
SELECT * FROM track WHERE Composer = 'Green Day' OR Composer = 'Pearl Jam';

SELECT * FROM track WHERE Composer = 'Green day' OR Composer = 'pearl jam';

SELECT * FROM track WHERE Composer = "Green Day" OR Composer = "Pearl Jam";
# SQL will match the string characters exactly, not case sensitive, but spelling matters


