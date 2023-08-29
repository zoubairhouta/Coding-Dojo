class Ninja {
  constructor(name, health) {
    this.name = name;
    this.health = health;
    this.speed = 3;
    this.strength = 3;
  }

  sayName() {
    console.log(`The ninja name is ${this.name}`);
  }

  showStats() {
    console.log(this);
  }

  drinkSake() {
    this.health += 10;
  }
}

class Sensei extends Ninja {

constructor(name) {
    super(name,200,10,10);
    this.wisdom = 10;
}

speakWisdom(){
    super.drinkSake();
    console.log("What one programmer can do in one month, two programmers can do in two months")
}
}

const mnaaa = new Sensei("mounir");
mnaaa.speakWisdom();

