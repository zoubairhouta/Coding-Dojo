// // GIVEN
// console.log(example);
// var example = "I'm the example!";
// AFTER HOISTING BY THE INTERPRETER
// // var example;
// // console.log(example); // logs undefined
// // example = "I'm the example!";


// ======================1===========================

console.log(hello);                                   
var hello = 'world';          
  
// After Hosting It becomes  hello 
// log indefined 
// hello world


// ======================2===========================


var needle = 'haystack';
test();
function test(){
    var needle = 'magnet';
    console.log(needle);
}
// log magnet



// ======================3===========================
var brendan = 'super cool';
function print(){
    brendan = 'only okay';
    console.log(brendan);
}
console.log(brendan);
// log only okay then log super cool



// ======================4===========================

var food = 'chicken';
console.log(food);
eat();
function eat(){
    food = 'half-chicken';
    console.log(food);
    var food = 'gone';
}
// This how its interpreted 
var food = 'chicken';
function eat(){
    var food = 'gone';
        food = 'half-chicken';
        console.log(food);
        
    }
    console.log(food);
eat();


// ======================5===========================
mean();
console.log(food);
var mean = function() {
    food = "chicken";
    console.log(food);
    var food = "fish";
    console.log(food);
}
console.log(food);



// This how its readed 
var mean = function() {
        food = "chicken";
        console.log(food);
        var food = "fish";
        console.log(food);
    }
    mean();
    console.log(food);
    console.log(food);


    // ======================6===========================

    console.log(genre);
    var genre = "disco";
    rewind();
    function rewind() {
        genre = "rock";
        console.log(genre);
        var genre = "r&b";
        console.log(genre);
    }
    console.log(genre);
    


    // THis is how its hosted 
    var genre

    function rewind() {
        genre = "rock";
        console.log(genre);
        var genre = "r&b";
        console.log(genre);
    }
    console.log(genre); 
    var genre = "disco";
    rewind();
    console.log(genre);



 // ======================7===========================



 dojo = "san jose";
 console.log(dojo);
 learn();
 function learn() {
     dojo = "seattle";
     console.log(dojo);
     var dojo = "burbank";
     console.log(dojo);
 }
 console.log(dojo);


//  THis is how its read 
function learn() {
        dojo = "seattle";
        console.log(dojo);
        var dojo = "burbank";
        console.log(dojo);
    }

    dojo = "san jose";
 console.log(dojo);
 learn();
 console.log(dojo);


 // ======================8===========================

 
 console.log(makeDojo("Chicago", 65));
 console.log(makeDojo("Berkeley", 0));
 function makeDojo(name, students){
     const dojo = {};
     dojo.name = name;
     dojo.students = students;
     if(dojo.students > 50){
         dojo.hiring = true;
     }
     else if(dojo.students <= 0){
         dojo = "closed for now";
     }
     return dojo;
 }

 
//  This is how its read 

function makeDojo(name, students){
        const dojo = {};
        dojo.name = name;
        dojo.students = students;
        if(dojo.students > 50){
            dojo.hiring = true;
        }
        else if(dojo.students <= 0){
            dojo = "closed for now";
        }
        return dojo;
    }

    console.log(makeDojo("Chicago", 65));
    console.log(makeDojo("Berkeley", 0));
   
    
    
    
