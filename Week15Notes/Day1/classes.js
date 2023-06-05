// CLASSES IN JS
// these are not actually classes -- "classes" are just fancy-looking constructor functions with Java-like syntax

// set up a class using the class keyword, no access modifier
// does NOT have to match the file name, like it does in Java
// Pascal case not required, but conventional

class Cookie {

    // static properties, associated with Cookie, not myCookie or any instance
    static IS_DELICIOUS = true;

    // declares an instance property, no access modifier or var/let/const necessary
    // # makes the variable private, meaning you can't access it outside the class
    #name;
    size;
    isDunkable;
    numberOnHand;
    ingredients;

    // constructor
    // can call a super constructor, if the class extends another
    constructor(name, size, isDunkable, numberOnHand, ingredients) {
        // must remember # for private variables
        this.#name = name;
        this.size = size;
        this.isDunkable = isDunkable;
        this.numberOnHand = numberOnHand;
        this.ingredients = ingredients;
    }

    // static method
    static amIDelicious() {
        if (this.IS_DELICIOUS) {
            console.log('I AM DELICOUS!!');
        } else {
            console.log('I should be unreachable code.');
        }
    }

    // instance method
    // just give the name of the function, set parameters, return whatever you wish, etc.
    speak() {
        console.log(`I am a ${this.name} cookie, there are ${this.numberOnHand} of me, and my ingredients are ${this.ingredients}.`)
    }

    // setters and getters
    // variables must be private to use these getters/setters

    // this allows read access to a private variable

    // getters have "get" before them, then the function name that will be called using . syntax
    get name() {
        return this.#name;
    }

    // this allows setting of a private variable
    // setters have "set" before them, then the function name
    set name(name) {
        this.#name = name;
    }

}

// creating an instance of our Cookie
const myCookie = new Cookie('Chocolate Chip', 'XL', false, 13, [ 'Sugar', 'Flour', 'Butter', 'Chocolate Chips' ]);

console.log(myCookie);

console.log(Cookie.IS_DELICIOUS);

// running an instance method
myCookie.speak();

// running a static method
Cookie.amIDelicious();


// when using getters and setters in your code, just call the variable using the . syntax -- don't need to run the get/set method
myCookie.name = 'abc';
console.log(myCookie.name);


let x = {};

x.size = 'Huge';

console.log(x);