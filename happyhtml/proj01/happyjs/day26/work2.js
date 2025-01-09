function work(callback) {
  //console.log("work start");
  setTimeout(() => {
    const start = Date.now();
    const end = Date.now();
    console.log(end - start + "ms");
    callback();
  }, 0);
  //console.log("work end");
}

console.log("worked");
work(() => {
  console.log("작업끝");
});
console.log("end");
