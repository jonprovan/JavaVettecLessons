// this is a single-line JavaScript (JS) comment

/**
 * this is a multi-line JS comment
 * it auto-fills stars per line, etc.
 */

/**
 * JS is a browser scripting language
 * it runs on the client-side
 * 
 * its speed is dependent on the browser/CPU speed
 * 
 * it's more flexible than Java, but that comes with some pitfalls
 * 
 * it is loosely-typed, meaning variables can basically hold any type of value
 * if I have a variable called test, it can be assigned a number, then reassigned a string, etc.
 */

// to use Node.js to run a .js file, navigate to the directory that holds the file
// then type node <filename> with or without the .js extension

// console.log() is like System.out.println() in Java
// semicolons after each line of code are OPTIONAL unless you put two lines of code on the same line
console.log("Hello, World!"); console.log("Hello, World!");

// quotes are interchangeable in JS, i.e., '' is the same as ""

// a function is what JS calls a method
// declare one using the function keyword

/**
 * you DO NOT declare a return type
 * you also DO NOT declare an access modifier
 * you CAN take in parameters, but you don't give them types
 */

function helloWorld() {
    console.log('Hello, World from within my function!');
}

// this function takes in untyped parameters and returns their "sum"
function sum(x, y) {
    return x + y;
}

helloWorld();

console.log(sum(1, 2));
// why?? we'll discuss later...
console.log(sum(true, false));
console.log("3");