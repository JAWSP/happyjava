hello();

//얜(const) 호이스팅이 안됨
//왜냐면 정의가 안되었기 때문에
//func1();

//함수 호이스팅 ->아래에서 선언한걸 위에서 쓰기
function hello() {
  console.log("hello");
}

//함수 중복
//중복 선언시 가장 마지막에 정의된 함수가 온다
function hello() {
  console.log("hi");
}

const func1 = function () {
  console.log("f hello");
};

//여기서 써야됨 const는 호이스팅이 안되니
func1();

//값 2개 받아서 결과같을 리턴하는 함수
function sum(a, b) {
  return a + b;
}

console.log(sum(1, 2));

//아까 그거
const sum2 = function (a, b) {
  return a + b;
};

//화살표 함수 -> 이거 더럽게 신기하게 생김
// 화살표함수 (매개변수들) => 구현부
const func2 = () => console.log("f");

const sum3 = (a, b) => a + b;

func2();
console.log(sum3(1, 2)); //얘가 출력

//템플릿 리터럴
const hi = (name) => console.log(`안녕 ${name}`);
hi("asds");
