const todos = [
  {
    id: 1,
    text: "자바스크립트 입문",
    done: false,
  },
  {
    id: 2,
    text: "함수 배우기",
    done: true,
  },
  {
    id: 3,
    text: "객체와 배열 배우기",
    done: true,
  },
  {
    id: 4,
    text: "배열 내장함수 배우기",
    done: false,
  },
];

//id가 몇인 인덱스를 찾고 싶을때

const todoIndex = todos.findIndex((todo) => todo.id === 3);
console.log(todoIndex);

//필터도 된다
//근데 리턴이 인덱스가 아닌 인덱스에 해당되는 요소를 불러옴
const falseTodo = todos.filter((todo) => todo.id === 3);
console.log(falseTodo);

//원본을 잘라서 넣어줌
const newTodos = todos.splice(1, 2);
console.log(newTodos);
console.log(todos);

const numbers = [1, 2, 3, 4, 5];
let sum = numbers.reduce((accumulator, current) => {
  console.log(accumulator + " " + current);
  return accumulator + current;
  // console.log(accumulator + " " + current);
}, 0);
console.log(sum);

let i = 1;
let average = numbers.reduce((accumulator, current) => {
  if (i === numbers.length) return accumulator / numbers.length;
  i++;
  return accumulator + current;
}, 0);
console.log(average);

let avg = numbers.reduce((accumulator, current, index, array) => {
  if (index === array.length - 1) {
    return (accumulator + current) / array.length;
  }
  return accumulator + current;
}, 0);
console.log(avg);
