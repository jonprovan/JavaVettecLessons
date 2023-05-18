# SQL is built on the idea of Transactions 
# A.C.I.D. Transactions

# Everything in SQL is a transaction
# By default each individual statement you run is it's own transaction

# while a transaction is occuring you have the option to stop the transaction and void it
# When a transaction is saved/ is valid it is "committed", you commit the transaction
# When a transaction is voided it is "Rolled back", you rollback the transaction

# To start a transaction, and tell MySQL I am managing the transaction:
START TRANSACTION;

# anything i run is a part of the transaction
SELECT * FROM languages;
INSERT INTO languages (LanguageId, Name) VALUES (6, 'French');

# what i see is temporary, until I do something with the transaction
SELECT * FROM languages;

ROLLBACK; -- Voids the transaction, undoes everything in the transaction

SELECT * FROM languages;

# New transaction
# This transaction ends when I type either commit or rollback
# Everything up until commit or rollback is a part of the same transaction
START TRANSACTION;

# anything i run is a part of the transaction
SELECT * FROM languages;
INSERT INTO languages (LanguageId, Name) VALUES (6, 'Dutch');

# what i see is temporary, until I do something with the transaction
SELECT * FROM languages;

COMMIT; -- saves the transaction, everything in the transaction is permenant

SELECT * FROM languages;

# Transactions in SQL are built on the principle of A.C.I.D.
/*
	Atomicity - Transactions are a single unit of work. They either succeed completely or fail completely.
    Consistency - Transactions can only bring the database from one valid state to another valid state.
    Isolation - Transactions that are run concurrently run as if they were run sequentially. The operations
				of one transaction cannot interfere with the operations of another transaction. 
    Durability - Once a transaction is committed it's changes persist even in the case of system failure
*/
