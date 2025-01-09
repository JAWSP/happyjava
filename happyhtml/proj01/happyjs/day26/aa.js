function sleep(ms) {
  return new Promise((resolve) => setTimeout(resolve, ms));
}
const getDog = async () => {
  await sleep(1000);
  return "멍멍이";
};
const getRabbit = async () => {
  await sleep(500);
  return "토끼";
};
const getTurtle = async () => {
  await sleep(3000);
  return "거북이";
};
/*
async function process() {
  //순차적으로 하나씩 하고
  const dog = await getDog();
  console.log(dog);
  const rabbit = await getRabbit();
  console.log(rabbit);
  const turtle = await getTurtle();
  console.log(turtle);
  //이후에 하나씩 출력이 됨
}
*/

//배열로 보내기
//promise.all을 통하여 배열로 만들어서 순차적으로 출력한다고 한다
// async function process() {
//   const result = await Promise.all([getDog(), getRabbit(), getTurtle()]);
//   console.log(result);
// }

//배열로 보내기2
async function process() {
  const [dog, rabbit, turtle] = await Promise.all([
    getDog(),
    getRabbit(),
    getTurtle(),
  ]);
  console.log(dog);
  console.log(rabbit);
  console.log(turtle);
}
async function process() {
  const result = await Promise.race([getDog(), getRabbit(), getTurtle()]);
  console.log(result);
}

//얜 젤 먼저 도착한놈 하나가 나옴
process();
