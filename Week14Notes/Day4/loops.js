// LOOPS IN JS

/**
 * 
 * many of the loop operations are exactly the same as in Java
 * 
 * the major exception is how JS handles the enhanced for loop
 */

// while
let counter = 0;

while (counter < 3) {
    console.log(counter);
    counter++;
}

// do-while
let counter2 = 3;

do {
    console.log(counter2);
    counter2++;
} while (counter2 < 3)

// standard for
// only difference from Java is that you have let i instead of <data type> i
for (let i = 0; i < 3; i++) {
    console.log('i = ' + i);
}


// enhanced for
// works a little differently
// there are two forms, one for iterating and one for enumerating
// iterating is going through each in a collection, like we're used to
// enumerating is going through the keys of an object

const nums = [ 1, 2, 3, 4, 5 ]

// this iterates through the array, num becomes the value at each index
// pretty much an enhanced for as we would expect it
for (let num of nums) {
    console.log(num);
}

// this enumerates the keys, in this case, the array indices, and prints those
for (let num in nums) {
    console.log(num);
}

const animal = {
    name: 'Fido',
    species: 'Doggo',
    variant: 'Chonker'
}

// can't do this on an object, because it is not iterable, i.e., we can't go through it in order
// for (let property of animal) {
//     console.log(property);
// }

// we CAN do this to enumerate the properties
// property becomes the key
// you can then use bracket notation to get to the value at that "index"
for (let property in animal) {
    console.log(property + ': ' + animal[property]);
}