// CONSTRUCTOR FUNCTIONS IN JS

// prior to the 6th JS convention in 2015(?), JS did not have Java-like "classes" or any of that sort of functionality
// they added a handful of things to make it easier for Java folks to use JS

// one of these was the concept of a constructor function
// this creates a "class" (not really a class) that enables to "instantiate" "objects"

// this is not a constructor function, despite the capital letter
function Coffee() {
    console.log('Yay, coffee!');
}

Coffee();

let coffee = Coffee();

console.log(coffee);


// this IS a constructor function
// we take in parameters and assign them to properties
// we can include methods as well, like our history(name) method below
function GreatCoffee(beanType, roastType, origin) {
    this.beanType = beanType;
    this.roastType = roastType;
    this.origin = origin;
    this.history = (name) => {
        console.log(`I, ${name}, am the greatest GreatCoffee that has ever been roasted!`);
    }
}

let myCoffee = new GreatCoffee('Arabica', 'Dark', 'Guatemala');

console.log(typeof myCoffee);
console.log(myCoffee);
myCoffee.history('Wendy');

// this instance is distinct from the first
let myOtherCoffee = new GreatCoffee('Cheap', 'Light', 'Colombia');

console.log(myOtherCoffee);

myOtherCoffee.beanType = 'Really Cheap';

console.log(myCoffee);
console.log(myOtherCoffee);
