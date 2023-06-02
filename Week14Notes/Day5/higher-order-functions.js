// HIGHER-ORDER FUNCTIONS IN JS

// in JS, functions are given a little more weight and functionality than in Java
// we can store functions as variables
// we can pass in functions as parameters
// we can return functions from functions


// storing functions as variables
let sampleFunction = () => console.log('Sample');

sampleFunction();

let squareFunction = num => num*num; // without brackets, the value of the righthand expression IS the return
let squareFunction2 = num => { return num*num }; // if you use brackets, you must specify the return

console.log(squareFunction(4));
console.log(squareFunction(5));

let sumFunction = (num1, num2) => { let sum = num1 + num2; return sum; }

console.log(sumFunction(3, 8));


// taking in functions as parameters

/**
 * four big ones you might use
 * 
 * forEach -- takes each item in a collection and does something with it
 * map -- takes each item in a collection, does something with it, and returns it an array that gets passed on
 * filter -- looks at each item in a collection, if it passes the filter, it gets added to an array that gets passed on
 * reduce -- somehow reduces the entire collection to a single value of some sort
 */

// forEach -- returns nothing

const nums = [ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 ];

// takes in a consumer function (no return)
nums.forEach((num) => {
    console.log('The number in array index ' + nums.indexOf(num) + ' is ' + num);
});


// map -- returns an array

// takes in a supplier function (returns a value)
let squares = nums.map((num) => {
    return num*num;
});

console.log(squares);

// you can chain these
nums
    .map(num => num*num)
    .forEach(num => console.log('New num = ' + num));


// filter -- returns an array

// this takes in a predicate function
// the return statement parses as "if the boolean statement is true, add the original value to the output array" (in this case, num)
let greaterThanSix = nums.filter((num) => {
    return num >= 6;
});

console.log(greaterThanSix);


// reduce -- returns a single value of some type

// this takes in two arguments
// the second is the starting value (0, in this case)
// the first is a function that also takes in two arguments
        // its first argument is the starting value if provided, and the second is the first item in the array
        // if no start value is provided, the two args are the first two items in the array
    // the return value becomes the new first arg, and the next item in the array becomes the new second arg
let sum = nums.reduce((num1, num2) => {
    return num1 + num2;
}, 0);

console.log(sum);

const nameArray = [ 'Jim', 'LeeRoy', 'Alexandra', 'Bill', 'Vicente', 'Ezra', 'Sarah' ];

let longestName = nameArray.reduce((name1, name2) => {
    return (name1.length > name2.length) ? name1 : name2; // if name1 is longer than name2, return name1, otherwise return name2
}, 'Nicolas!'); // optional starting value as second parameter

console.log(longestName);