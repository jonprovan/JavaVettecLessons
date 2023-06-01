// VARIABLES IN JS

/**
 * variables in JS are not typed; they can hold any type of value and be reassigned any type of value
 * 
 * there are three relevant scopes for a variable
 * 
 * global scope -- anywhere in the file
 * function scope -- anywhere within a function
 * block scope -- anywhere within a code block {}, e.g., a function's block, an if block, a loop block, etc.
 * 
 * 
 */

// we have var, let and const for declaring variables
// variables must be initialized when declared

// var declares a global variable
// var is able to be redeclared as well
// DO NOT USE!! Causes too many problems
var x = 10;
// this redeclares x and overwrites the original variable and value
var x = 11;

// let declares a Java-like variable, which can be reassigned
// it exists at the block or function scope level
let y = 20;

// just like let, except we can't change the value after it's been initialized
const z = 30;
// can't do this, because z is a const
// z = 50;

console.log(test);

console.log(x);
console.log(y);
console.log(z);

// the test variable is declared way down here, but the declaration (not the value) is accessible anywhere
if (true) {
    if (true) {
        if (true) {
            var test = 7;
            console.log(test);
        }
    }
}

if (true) {
    let letTest = 9;
    console.log(letTest);
}

// can't do this, because letTest is no longer in scope; stopped existing after the above code block
// console.log(letTest);

function sum(a, b) {
    return a + b;
}

console.log(sum(5, 6));
// can't do this either -- a and b are function-scoped
// console.log(a + b);


// with const, we can't change the object/array to which it's assigned, but we can change the contents/properties

const myObject =  {
    name: 'Joe Schmo',
    age: 30
}

// can change property values, add/remove properties, etc.
myObject.name = 'Joseph Schmoseph';
console.log(myObject);

const myArray = [ 1, 2, 3 ];

myArray.push(4);
console.log(myArray);
console.log(myArray[2]);