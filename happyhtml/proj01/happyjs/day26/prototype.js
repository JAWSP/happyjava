function Animal(type, name, sound) {
  this.type = type;
  this.name = name;
  this.sound = sound;
}
//프로토타입 선언
Animal.prototype.say = function () {
  //this가 가능 어차피 animal안에 있으니
  console.log(this.sound);
};
Animal.prototype.shardValue = 1;

const dog = new Animal("dog", "doggo", "wall");
const cat = new Animal("Cat", "dantto", "mew");
dog.say();
cat.say();

//프로토 타입을 중간에 바꾸면
Animal.prototype.say = function () {
  console.log("sa");
};
//한번에 바뀜
dog.say();
cat.say();

cat.say = function () {
  console.log("냐");
};
cat.say();

//생성자 상속

function Dog(name, sound) {
  Animal.call(this, "dog", name, sound);
}
Dog.prototype = Animal.prototype;

const pdog = new Dog("doggo", "wall");
pdog.say();
