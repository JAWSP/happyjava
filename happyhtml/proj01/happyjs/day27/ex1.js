const btn = document.querySelector("btn1");
const btn2 = document.querySelector("btn2");
//버튼 선택자를 이렇게
console.log(btn);
//대충 예시 이벤트 핸들러
const hi = () => {
  alert("hello");
};
btn.addEventListener("click", hi);
//이번에는 화살표로 핸들러를
btn2.addEventListener("click", () => {
  alert(Date.now().toLocaleString("ko-KR"));
});
