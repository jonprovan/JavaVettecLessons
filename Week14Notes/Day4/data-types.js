// DATA TYPES IN JS

/**
 * JS has some similar data types to Java, with some significant differences
 * 
 * 
 * PRIMITIVES
 * int, long, byte, short
 * float, double
 * 
 * all of the above don't exist, we just have...
 * 
 * number -- any whole or decimal number up to 2^53 or so -- 3, 12345, 3.14, -590, -123.456, etc.
 * BigInt -- any whole or decimal number with NO UPPER LIMIT -- 10n, 1234567890n, etc.
 * (these cannot be combined in mathematical operations)
 * 
 * char, String
 * char doesn't exist, we just have...
 * 
 * String -- 'abc', "Hello, World!", '', "", etc.
 * 
 * boolean -- exactly the same, true/false
 * 
 * null -- its own data type in JS
 * undefined -- when a variable has been declared but has not yet been initialized
 * 
 * Symbol -- a unique item created in memory with a key you can use to access it (we won't use this one)
 * 
 * 
 * NON-PRIMITIVES
 * 
 * object -- this is pretty much anything else, include Objects and Arrays
 * 
 */

console.log(typeof 3);
console.log(typeof 3n);
console.log(typeof 'Hello!');
console.log(typeof false);
console.log(typeof null); // reads as object, but should be thought of as its own type
console.log(typeof undefined);
console.log(typeof { name: 'Joe' });
console.log(typeof [1, 2, 3]);
console.log(typeof Symbol('key')); // again, don't worry about this one


