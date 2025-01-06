//자바스크립트는 함수를 일급객체로 취급한다
//그러니까 함수도 타입이 된다

function test() {
  console.log("ttt");
  return 10;
}
//얘는 실행된 결과값을 a에게 넣어달라는거
let a = test();
let b = test;
console.log(a); //함수의 리턴값이 저장됨
console.log(b); //함수 그 자체가 저장됨
//함수를 매개변수로 받아낼 수 있음
sum(b); //b에 함수가 저장되어 있음
function sum(test) {
  test();
}
