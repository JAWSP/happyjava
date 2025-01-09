function hi() {
  console.log("hi");
}

function work() {
  //작업이 진행되는 동안 다른 작업을 하고 싶으면 비동기로 전환을 해준다고함
  //첫번쨰 인자는 함수(콜백함수)를 넣음, 두번째 인자는 ms만큼 쉬어달라는거
  setTimeout(hi, 0.1);
}
console.log("work 전");
work();
console.log("work 끝");

//함수니까 즉석에서 이렇게 해도 됨
setTimeout(function () {
  console.log("ㅁㄴㅇ");
}, 0);
//이렇게도 됨
setTimeout(() => {
  console.log("Asd");
}, 0);
//
console.log("찐 끝");
