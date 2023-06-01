// OBJECTS IN JS

/**
 * JS objects are a bit more lightweight than Java objects, but more flexible
 * 
 * they have curly braces around them { }
 * inside are a series of key-value pairs with property names and their values
 * these values can be anything, including primitives, arrays, and other objects
 * 
 * Syntax:  {
 *              key1: 'abc',
 *              key2: 123
 *          }
 */

// you can declare them outright

const myPizza = {
    diameterInches: 18,
    origin: "Minsky's",
    isTasty: true
}

// don't need a toString() method
console.log(myPizza);

// can read invididual properties using . notation
console.log(myPizza.diameterInches);

// can change them in the same fashion
myPizza.diameterInches = 22;
console.log(myPizza.diameterInches);

// we can also add properties by simply assigning them a value
myPizza.hasStuffedCrust = false;
console.log(myPizza);

// and we can delete properties as well
delete myPizza.hasStuffedCrust;
console.log(myPizza);

console.log();


// a more advanced object

const artist = {
    name: {
        first: 'Kendrick',
        last: 'Lamar'
    },
    genre: 'Hip-Hop',
    yearsActive: 12,
    greatWorks: ['To Pimp A Butterfly', 'Good Kid, M.A.A.D. City', { title: 'Section 80',
                                                                     tracks: [ "Ab-Soul's Outro", 'Hol Up', 'Chapter Six' ] }, 'Damn']
}

console.log(artist);
console.log(artist.genre);
console.log(artist.name.last);

// get used to digging through JS objects for what you need
// your DB requests will often come back with complicated JSON objects/arrays
console.log(artist.greatWorks[2].tracks[2]);