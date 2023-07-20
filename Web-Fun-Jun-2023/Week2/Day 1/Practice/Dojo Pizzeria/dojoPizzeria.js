function pizzaOven(crustType, sauceType, cheeses, toppings) {
    var pizza = {};
    pizza.crustType = crustType;
    pizza. sauceType =  sauceType;
    pizza.cheeses= cheeses;
    pizza.toppings = toppings;
    return sandwich;
}
    
var pizza1 = pizzaOven("deep dish", "traditional", ["mozzarella"], ["pepperoni", "sausage"]);
var pizza2 = pizzaOven("hand tossed", "marinara", ["mozzarella","feta"], ["mushrooms", "olives","onions"]);
var pizza3 = pizzaOven("hand tossed", "marinara", ["mozzarella","feta"], ["mushrooms", "olives","mergeuz"]);
var pizza2 = pizzaOven("hand tossed", "marinara", ["mozzarella","feta"], ["mushrooms", "olives","meat"]);

function randomPizza() {
    var crustTypes = ["deep dish", "hand tossed", "thin crust"];
    var sauceTypes = ["traditional", "marinara", "barbecue"];
    var cheeseOptions = [["mozzarella"], ["3fromages", "jben3arbi"], ["feta", "parmesan"]];
    var toppingOptions = [
      ["pepperoni", "sausage", "mushrooms", "olives"],
      ["chicken", "bacohalal", "onions", "peppers"],
      ["pineapple", "ham", "spinach", "tomatoes"]
    ];
  
    var crustType = crustTypes[Math.floor(Math.random() * crustTypes.length)];
    var sauceType = sauceTypes[Math.floor(Math.random() * sauceTypes.length)];
    var cheeses = cheeseOptions[Math.floor(Math.random() * cheeseOptions.length)];
    var toppings = toppingOptions[Math.floor(Math.random() * toppingOptions.length)];
  
    return pizzaOven(crustType, sauceType, cheeses, toppings);
  }