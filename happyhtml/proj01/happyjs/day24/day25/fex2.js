//오버로딩
//중복이면 뭐다? 맨아래다
function add(a) {
  console.log("a + a");
  return a + a;
}

// function add(a, b) {
//   console.log(a + b);
// }
//console.log(add(3));
add(2, 3);
console.log(add(2, 3));

//arguments
//매개변수가 여러개일때 다룬다고 한다
function add(a, b, c) {
  console.log(arguments.length);
  console.log("1st argument :" + arguments[0]);
}

add(1, 2, 3, 4, 5, 6, 7);
