//클래스
class Animal {
  //따로 맴버 변수선언을 안해도 생성자로 만들 수 있나보네
  constructor(type, name, sound) {
    this.type = type;
    this.name = name;
    this.sound = sound;
  }
  say() {
    console.log(this.sound);
  }
}

const dog = new Animal("dog", "doggo", "wall");
const cat = new Animal("cat", "dantto", "mew");

dog.say();
cat.say();
//심지어 상속도 됨
class Dog extends Animal {
  constructor(name, sound) {
    super("개", name, sound);
  }
}
