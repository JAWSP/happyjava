//프로토타입

//일종의 생성자 역할
function Animal(type, name, sound) {
  this.type = type;
  this.name = name;
  this.sound = sound;
  this.say = function () {
    console.log(this.sound);
  };
}

const dog = new Animal("dog", "doggo", "wall");
const cat = new Animal("Cat", "dantto", "mew");
dog.say();
cat.say();
//say의 함수를 바꿈
dog.say = function () {
  console.log("wqdqwd");
};
//바뀌었네
dog.say();
cat.say();
