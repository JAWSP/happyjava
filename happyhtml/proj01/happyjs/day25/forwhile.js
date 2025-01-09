//for
for (let i = 0; i < 10; i++) {
  console.log(i);
}
//배열
const names = ["a", "b", "c"];
for (let i = 0; i < names.length; i++) {
  console.log(names[i]);
}

const dog = {
  name: "doggo",
  age: 2,
  sound: "wall",
};
//for each같은 놈
for (let key in dog) {
  //key만 하면 변수명이 나오고 내용은 안나옴
  console.log(dog[key]);
}

//while
let i = 0;
while (i < 10) {
  console.log(i);
  i++;
}

for (let value of names) {
  console.log(value);
}

console.log(Object.entries(dog));
console.log(Object.keys(dog));
console.log(Object.values(dog));
