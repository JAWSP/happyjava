//객체는 만들고 싶으면 만들 수 있음

const dog = {
  name: "doggo",
  age: 2,
};
console.log(typeof dog);
console.log(dog.name);
console.log(dog.age);
//이렇게 출력도 됨
console.log(dog["name"]);

const person = {
  name: "나",
  age: "왜 상처에 소금을 뿌리십니까",
  address: "이쁜 마스코트가 있는 고양시를 부러워하는 안양시",
};
