//그럼 콜백지옥을 async로 나타내보자
function increased(n) {
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

async function increaseAndPrint(n) {
  try {
    while (1) n = await increased(n);
  } catch (error) {
    console.error(error);
  }
}

increaseAndPrint(0);
