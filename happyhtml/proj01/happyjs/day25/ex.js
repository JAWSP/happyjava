const f = (numbers) => {
  let result = 0;
  for (let i of numbers) {
    result += i;
  }
  return result;
};

console.log(f([0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]));
