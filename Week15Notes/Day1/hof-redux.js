// HIGHER-ORDER FUNCTIONS, PART DEUX
// see the file in Week 14, Day 5 for the first part
// ^^ assigning functions to variables, forEach/map/filter/reduce

// now, let's look at functions that RETURN functions

// CLOSURE
// a closure is an anonymous internal function which has access to the external function's parameters

function timesX(x) {
    return (num) => {
        return num * x;
    }
}

// the value of times 5 == (num) => { return num * 5; }
const times5 = timesX(5);

// running our output function
console.log(times5(10));

const times11 = timesX(11);
console.log(times11(10));

// return value of timesX(100) is itself a function we can run
console.log(timesX(100)(100));