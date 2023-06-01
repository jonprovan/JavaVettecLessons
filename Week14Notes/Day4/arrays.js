// ARRAYS IN JS

/**
 * arrays in JS are notated like this: [ 1, 2, 3 ]
 * 
 * they can contain any combination of data types, in any order
 * they do NOT have a fixed size; can have a length of 0 -- []
 * 
 * really closest to an ArrayList of type Object -- can insert anything, but we can also include primitives
 * 
 * 
 * 
 */

const myArray = [ 1, 'abc', false, [], {}, null, undefined ];

console.log(myArray);

// elements may be accessed via index
console.log(myArray[0]);

// overwriting
myArray[0] = 2;
console.log(myArray);

// we have some ArrayList/LinkedList-type methods to use here

// adding to the end
myArray.push('Pushed');
console.log(myArray);

// removing from the end
myArray.pop();
console.log(myArray);

// adds to the beginning
myArray.unshift('Unshifted');
console.log(myArray);

// removing from the beginning
myArray.shift();
console.log(myArray);

// finding the index by content (returns the FIRST index)
console.log(myArray.indexOf(false));

const nums = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9];

// splice removes and/or inserts elements at a particular index
// syntax: splice(starting index, how many to remove, insertion item 1, insertion item 2, etc.)
nums.splice(2, 3, 2n, 3n, 4n);
console.log(nums);


// slice returns a copy of a particular portion of your array
const letters = [ 'a', 'b', 'c', 'd', 'e', 'f' ];

console.log(letters);

// does not affect the original array
letters.slice(2, 4);

const lettersAltered = letters.slice(2, 4);

lettersAltered[0] = 'C';

console.log(letters);
console.log(lettersAltered);

// arrays assigned to new variables are linked; a change to one affects the other
const nums2 = [ 1, 2, 3, 4, 5 ];
const nums3 = nums2;

nums2[0] = 10;

console.log(nums2);
console.log(nums3);

// to avoid this, use the spread operator ...
const nums4 = [ 1, 2, 3, 4, 5 ];
const nums5 = [ ...nums4 ];   // this takes the elements in nums4 and "spreads" copies of them out into nums5

nums4[0] = 10;

console.log(nums4);
console.log(nums5);


