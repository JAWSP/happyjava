//promise는 2개의 인자로 되어있음

//얘는 1초 기다렸다가 1을 생행달라는거
const myPromise = new Promise((resolve, reject) => {
  setTimeout(() => {
    //resolve(1);
    reject(new Error());
  }, 1000);
});

//then은 기본적인 흐름들, promise의 resolve가 저걸 실행함
myPromise
  .then((n) => {
    console.log(n);
  })
  //catch는 에러처리
  .catch((error) => {
    console.log(error);
  });
