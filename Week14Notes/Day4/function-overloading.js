// FUNCTION OVERLOADING IN JS

// You CANNOT overload functions in JS!

function testFunction() {
    console.log(1);
}

function testFunction(param) {
    console.log(param);
}

// this prints undefined because the second version of testFunction() overwrites the first
testFunction();


// there are some workarounds!

// we can provide default values inside the method declaration
function sentenceBuilder(name = 'No Name', age = 1, food = 'nougat') {

    if (age < 2) {
        age = 2;
    }

    console.log('Hello! My name is ' + name + ', I am ' + age + ' years old, and I love eating ' + food + '!');
}

sentenceBuilder('Marge', 45, 'calzones');
// if you use fewer than the correct number, they get fed in left to right
sentenceBuilder('Marge');
sentenceBuilder('Marge', 45);
// to skip arguments, we can use undefined, which does NOT overwrite the default value
sentenceBuilder('Marge', undefined, 'calzones');
// if you give it too many arguments, it discards the rest
sentenceBuilder('Marge', 45, 'calzones', 123, {});

// null DOES NOT EQUAL undefined -- similar, but different

// you can also base parameters on other parameters
function quadArea(width = 1, height = width) {
    console.log(width * height);
}

quadArea(4, 2);
quadArea(4);
quadArea();