const superheroes = ["아이언맨", "캡틴 아메리카", "토르", "닥터 스트레인지"];

//기존 내용 출력을
for (let i = 0; i < superheroes.length; i++) {
  console.log(superheroes[i]);
}

const hi = function (name) {
  console.log(`hi ${name}`);
};
//이렇게 for each로
//배열 내장함수에 forEach가 있다고 한다 -> 내가 해야할일을 구현한 함수
//hi를 출력하고 거기에 인자에 인자를 하나씩 넣어줌
superheroes.forEach(hi);

//이렇게 해도 됨
superheroes.forEach(function (n) {
  console.log(`hi ${n}`);
});
//화살표는 이렇게
superheroes.forEach((n) => {
  console.log(`hi ${n}`);
});
