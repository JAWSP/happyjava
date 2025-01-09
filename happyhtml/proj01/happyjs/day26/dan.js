//단축평가
// a || b에서 a가 참이면 b는 확인안함
//논리 연산자를 사용

const food = { foodName: "휫짜" };

function getFoodName(food) {
  if (!food) return "아무거나";
  return food.foodName;
}
console.log(getFoodName(food));
console.log(getFoodName());

//단축 평가 이용해서 getFoodname 함수를 수정
function getFoodName(food) {
  //한줄로 요약 가능
  //만약에 food가 있다면 오른쪽 부분을 실행
  return food && food.foodName;
}

//앞에 있는 조건이 true면 뒤의 부분을 실행
console.log(true && "hi");
//앞의 있는 조건이 false한 조건이면 앞의 부분을 실행
console.log(false && "hi");

//앞의 있는 조건이 true이면 뒷 부분을 실행안함
console.log(true || "hello");
//앞의 있는 조건이 false이면 뒷 부분을 실행함
console.log(false || "hi");
console.log("이 아래는 죄다 false");
//JS가 false라고 판단할때
console.log(false || "hi");
console.log(0 || "hi");
console.log("" || "hi");
console.log(null || "hi");
console.log(undefined || "hi");
console.log(NaN || "hi");
//js가 true라고 판단할떄
console.log("sa" || "hi");
console.log(1 || "hi");

console.log("??????????????");
//?? 단축평가
//거짓을 판단하는 기준이 단지 값으로만 판단
//즉 값이 unll이나 undefined인게 아니면 죄다 다르게
console.log(false ?? "hi");
console.log(0 ?? "hi");
console.log("" ?? "hi");
console.log(null ?? "hi"); //hi
console.log(undefined ?? "hi"); //hi
console.log(NaN ?? "hi");
