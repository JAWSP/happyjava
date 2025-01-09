function increaseAndPrint(n, callback) {
  setTimeout(() => {
    const increased = n + 1;
    console.log(increased);

    if (callback) {
      callback(increased);
    }
  }, 100);
}

//옛날엔 이렇게 했었다고 한다
//그 값을 유지하게끔 콜백을 계속 부르게 했다
//5번 반복 하고 싶다면 5중첩으로 100번 반복하고 싶다면 100중첩
increaseAndPrint(0, (n) => {
  increaseAndPrint(n, (n) => {
    increaseAndPrint(n, (n) => {
      increaseAndPrint(n, (n) => {
        increaseAndPrint(n, (n) => {
          console.log("끝");
        });
      });
    });
  });
});
