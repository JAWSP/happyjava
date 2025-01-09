function sleep(ms) {
  return new Promise((resolve) => setTimeout(resolve, ms));
}
/*
function process() {
  console.log("hi");
  sleep(3000).then(() => {
    console.log("hello");
  });
}
*/

//바로 윗부분을  async로 바꾼게 이러라는데...
async function process() {
  console.log("hi");
  await sleep(1000);
  console.log("hello");
}

//일부러 에러 내기
async function makeError() {
  await sleep(1000);
  const error = new Error();
  throw error;
  //발생 시키지 않았다면 그냥 1초 있다 해야 할 작업이 나오게 된다
}

//이번엔 에러처리 포함
// async function process() {
//   try {
//     await makeError();
//   } catch (e) {
//     console.error(e);
//   }
// }

console.log("before process");
// process();
process().then(() => {
  console.log("end process");
});

console.log("after process");
