const ironMan = {
  name: "토니 스타크",
  actor: "로버트 다우니 주니어",
  alias: "아이언맨",
};
const captainAmerica = {
  name: "스티븐 로저스",
  actor: "크리스 에반스",
  alias: "캡틴 아메리카",
};

const dog = {
  name: "doggo",
  age: 2,
};
console.log(ironMan);
console.log(captainAmerica);

function print(hero) {
  console.log(hero["name"]);
}
print(ironMan);
//객체 비구조화 할당
//객체 안의 구성 요소들을 따로 변수든 상수든 할당받음
function print(hero) {
  const { name, actor, alias } = hero;
  console.log(`${name}, ${actor}`);
}
//이렇게 해도 나온다
function print({ alias, name, actor }) {
  console.log(`${name}, ${actor}`);
}

//그냥 밖에서 꺼내도 됨
const { name, age } = dog;
console.log(name);
