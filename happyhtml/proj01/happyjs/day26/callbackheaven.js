function increaseAndPrint(n) {
  return new Promise((resolve, rejcet) => {
    setTimeout(() => {
      const value = n + 1;
      if (value === 5) {
        //5일때 일부러 에러 내기
        const error = new Error();
        error.name = "5네";
        rejcet(error);
      }
      console.log(value);
      resolve(value);
    }, 1000);
  });
}

// increaseAndPrint(0)
//   .then((n) => {
//     return increaseAndPrint(n);
//   })
//   .then((n) => {
//     return increaseAndPrint(n);
//   })
//   .then((n) => {
//     return increaseAndPrint(n);
//   })
//   .then((n) => {
//     return increaseAndPrint(n);
//   })
//   .then((n) => {
//     return increaseAndPrint(n);
//   })
//   .then((n) => {
//     return increaseAndPrint(n);
//   })
//   .then((n) => {
//     return increaseAndPrint(n);
//   })
//   .then((e) => {
//     console.error;
//   }); //이렇게 해도 됨
increaseAndPrint(0)
  .then(increaseAndPrint)
  .then(increaseAndPrint)
  .then(increaseAndPrint)
  .then(increaseAndPrint)
  .then(increaseAndPrint)
  .then(increaseAndPrint)
  .then(increaseAndPrint)
  .then(increaseAndPrint)
  .catch((e) => {
    console.error;
  });
