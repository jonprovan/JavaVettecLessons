// OBJECT DESTRUCTURING IN JS

/**
 * sometimes, we want to access properties or values as individual variables
 * sometimes, we may want to use these as properties in a new object
 * sometimes, we may want to collect them into a new array, etc.
 */

const hanson = {
    type: 'Band',
    members: 3,
    isAwesome: true
}

let artist = hanson;

console.log(hanson);
console.log(artist);

hanson.type = 'Trio';

console.log(hanson);
console.log(artist);

// the spread operator -- ...
// spreads out the properties of an object OR the contents of an array into a new object/array

artist = {...hanson}

console.log(hanson);
console.log(artist);

hanson.type = 'Band';

console.log(hanson);
console.log(artist);

// works for arrays, too
const nums = [ 1, 2, 3, 4, 5 ];
const newNums = [ ...nums ];

newNums[0] = 11;

console.log(nums);
console.log(newNums);

// can be part of constructing a larger object/array

const longNums = [ ...nums, 6, 7, 8, 9, 10 ];
console.log(longNums);


// THE REST OPERATOR -- ...
// collects all remaining arguments into an array
// MUST BE LAST!!

function restCollector(param1, param2, ...param3) {
    console.log(
        {
            first: param1,
            second: param2,
            third: param3
        }
    )
}

// all params after 'Laura' get collected into the param3 array
restCollector(3, 'Laura', true, 16, 'Mike', false);


// assign destructured values to individual variables
// using our hanson object

// for an object
// variable names MUST match the property keys in the object in order to get the values
// these are decoupled from the original object (changing one does not change the other)

const { type, members, isAwesome } = hanson;

console.log(type);
console.log(members);

// in a function, to avoid using . syntax

function objectIntake( { color, size, image, wordsOnBack } ) {

    const { first, second } = wordsOnBack;

    console.log(color);
    console.log(size);
    console.log(image);
    console.log(first);
    console.log(second);
}

objectIntake( { color: 'Green', size: '16 fl oz.', image: 'The Grinch', wordsOnBack: { first: 'Merry', second: 'Grinchmas!' } } );


// with arrays, it's a little different
// arrays do not have "variable/property names", just indices

const heroes = [ 'Deadpool', 'Batman', 'Anthony\'s Mom', 'Shazam', 'Iron Man' ];

// creates variables with these names, corresponding to the items in the array
const [ a, b, c, d, e ] = heroes;

console.log(b);

// only grabbing the first two
const [ f, g ] = heroes;

console.log(f);

// can skip with empty commas to get to some values
const [ , , h, , i] = heroes;

console.log(h);

// collecting the rest
const [ j, k, l, ...m] = heroes;

console.log(j, k, l, m);

// strings are arrays, just like in Java
// in Java, they're arrays of chars; in JS, they're just arrays of one-character Strings
// most/all functions available for Strings in Java exist in JS, too

console.log('Sample'[2]);
const strArray = [ ...'Sample' ];

console.log(strArray[4]);

const [ one, two, three, ...rest ] = 'Sample';

console.log(one, two, three, rest);