//map 새로운 배열을 만들어서 리턴한다

const array = [1, 33, 4, 66, 77, 2323, 52];
const resultArr = [];

//새로운 배열에 기존의 배열의 제곱값을 넣는다
for (let i = 0; i < array.length; i++) {
  resultArr.push(array[i] * array[i]);
}

console.log(resultArr);

//하지만 map을 이용하면 좀 더 간편하게 이용이 가능하다
const maparr = array.map((n) => n * n);
console.log(maparr);

console.log(array.indexOf(323));
