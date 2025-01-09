// 배열 []

let arr1 = [1, 2, 3];

arr1 = [4, 5, 6];
const arr2 = [];

console.log(typeof arr2);
console.log(arr1[0]);

arr1[2] = 20;
console.log(arr1);

//10이라는 값이 하나 있는 배열
const arr3 = new Array(10);
console.log(arr3);

const arr4 = new Array(10, 2);
console.log(arr4);
//객체가 인자로 넣어짐
arr1[1] = { name: "asd" };
console.log(arr1);

//push로 뒤에 값이 추가가 됨
arr1.push(10);
console.log(arr1);

arr1.push(() => console.log("hi"));
console.log(arr1);

arr1[4]();
//배열의 비구조할당
//단, 순서는 맞게 해줘야 한다
const [a, b, c, d, e] = arr1;
console.log(a);
console.log(b);
console.log(c);
console.log(d);
e();

//pop하면 맨 뒤가 사라지
//스택인가?
console.log(arr1.pop()); //출력값은 pop한놈
console.log(arr1);
