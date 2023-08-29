
class Ninja {
    constructor(name,health)
    {
        this.name=name;
        this.health=health;
        this.speed = 3;
        this.strength = 3;
    }



sayName()
{
    console.log(`The ninja name is ${ this.name }`)
}

showStats() 
{
console.log(this)
}

drinkSake()
{
    this.health+=10;
}
}
const mnaaa = new Ninja("mounir",200);
mnaaa.sayName();
mnaaa.drinkSake()
mnaaa.showStats();
