//대충 오래걸리는 일이라고 생각

function work() {
  setTimeout(() => {
    const start = Date.now();
    for (let i = 0; i < 1000000000; i++) {
      //암튼 존시나게 많은 작업이 있다고 함
    }
    const end = Date.now();
    console.log(end - start + "ms");
  }, 0);
}

console.log("worked");
work();
console.log("end");
