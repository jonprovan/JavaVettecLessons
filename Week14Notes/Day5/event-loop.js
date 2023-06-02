// THE JS EVENT LOOP, TIMEOUTS AND INTERVALS

// the event loop runs off to the side
// timeouts and intervals wait until there's room in the code for them to run
// Promises (the result of async functions like DB calls) take priority

console.log('This will print FIRST.');

// a timeout takes two parameters -- a function to execute, the amount of time to wait before execution (in milliseconds)

let x = 1;

setTimeout(() => {
    x = 2;
    console.log('This prints after the timeout time has elapsed, and x is ' + x);
}, 3000);

// if I do this, the timeout will NEVER return
// while(true) {
//     console.log('Waiting...');
// }

console.log('When does this print? And what is x? === ' + x);

let counter = 1;
// assigning the interval to a variable, so we can clear it later
let myInterval = setInterval(() => {
    console.log('Iteration of Interval = ' + counter);
    counter++;
}, 1000);

// clearing the interval after ~5.5 seconds
setTimeout(() => {
    clearInterval(myInterval);
}, 5500);
