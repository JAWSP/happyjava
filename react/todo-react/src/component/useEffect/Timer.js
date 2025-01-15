import { useEffect } from "react";

const Timer = () => {
  useEffect(() => {
    //비동기 그거, ~후에 실행해줘요

    const timer = setInterval(() => {
      console.log("째깍째깍");
    }, 1000);

    return () => {
      //이게 없다면 토글을 꺼도 실행됨
      //종료될때 해주는거
      //인터벌 종료
      clearInterval(timer);
      console.log("타이머 종료");
    };
  });
  return (
    <div>
      <span>타이머 시작함</span>
    </div>
  );
};

export default Timer;
