// BOOLEANS IN JS

// of course, we have the standard boolean datatype

let myTrueVariable = true;
let myFalseVariable = false;

console.log(myTrueVariable == !myFalseVariable);

console.log(2 == 2);

// this is true also...but why?
console.log(2 == '2');

// JS "coerces" different datatypes to match what it thinks you mean, to some extent

// EXPLICIT CASTING
let actualNumber = Number('45'); // returns NaN if the string doesn't parse
let actualString = String(67);
let actualBoolean = Boolean('false');  // ANY truthy value will return a boolean of true, and vice versa

console.log('-----EXPLICIT CASTING------')
console.log(typeof actualNumber);
console.log(actualBoolean);



// this is called the Strict Equality Operator
// it checks both value AND type
console.log(2 === '2'); // this returns false

console.log(2 !== '2'); // thir returns true

// for < and >, you need to check type on your own
console.log(2 < '3' && typeof 2 === typeof '3');

// what will this return?
console.log(null == undefined); // typeof null is object; typeof undefined is undefined
console.log(null === undefined);


// TRUTHY AND FALSY

/**
 * FALSY
 * any values which approximate or seem to represent false
 * 
 * 0
 * -0
 * 0.0
 * 0n
 * null
 * undefined
 * false
 * '' or ""
 * NaN
 * !true or !anythingthat'strue
 * 
 * 
 * TRUTHY
 * anything that's not falsy
 * 
 * e.g., 1, 'abc', true, !false, etc.
 * 
 * this includes ANY object or array, regardless of whether or not it's empty
 * 
 * 
 */

let myNum = 6;

if (myNum) {
    console.log('Truthy!');
} else {
    console.log('Falsy!');
}


// THE TERNARY OPERATOR
// works exactly the same as it does in Java
// boolean question ? if true return this : if false return this

let myName = (5 > 1) ? 'Jon' : 'Dave';

console.log(myName);

// the check statement can be a truthy/falsy value
let myLastName = (myName) ? 'Provan' : 'McLaughlin';

console.log(myLastName);

// shorthand for a certain type of ternary

let myAge = null;
let myOtherAge = 29;

let myValidatedAge = myAge || 0; // returns the first value if truthy, otherwise the second, regardless of truthiness

console.log(myValidatedAge);

let myFullyValidatedAge = myAge || myOtherAge || 0; // you can stack them, it reads L-to-R -- first arg || ALL OTHER ARGS, etc.
console.log(myFullyValidatedAge);

console.log();


console.log('1' + '2' + '3'); // standard string concatenation
console.log(1, 2, 3); // combines as strings with spaces between them

let first = 1;
let second = 2;
let third = 3;

console.log(`${first}, ${second}, ${third}`); // using template strings, inside the curly braces can be variables, function calls, etc.


console.log();

console.log('----- Caffeine Method -----');

function caffeineAmount(amount) {

    amount = Number(amount) || 10; // this clears us of anything that doesn't parse to a number (including null, undefined, etc.) as well as 0

    return `I, ${myName}, require ${amount} gallons of caffeine. Immediately!`;
}

console.log(caffeineAmount());


// THE NULLISH COALESCING OPERATOR -- ??
// this assesses the value on the left; if it's not null or undefined, it passes through; otherwise, we take the one on the right

// 0 is falsy, but not null or undefined, so it goes through
let sample = 0 ?? 'Other';

console.log(sample);

