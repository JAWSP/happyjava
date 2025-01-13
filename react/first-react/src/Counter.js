import { useState } from "react";
import Mybutton from "./Mybutton";

//카운터 만들기
const Counter = () => {
  console.log("counter 컴포넌트가 실행");
  //훅 넣기
  //상태를 갱신하기 위하여 쓰인다
  //count는 화면에 보일 수, setcount는 화면에 보여달라고 해주는 함수?
  //훅은 useState이고 ()안의 값은 초기값
  //아래 저거 배열 맞음
  //const 쓰는 이유는 재할당이 필요없기 때문에
  const [count, setCount] = useState(0);
  //함수 정의하기
  const plusHandler = () => {
    console.log(count);
    //이것만 써봤자 함수 안의 값만 바뀜
    //count += 1;
    setCount(count + 1);
  };
  return (
    <div>
      <h2>{count}</h2>
      {/* 버튼 추가 
        onClick
      */}
      {/* <input type="button" value="+" onClick={plusHandler} />
      <input
        type="button"
        value="-"
        onClick={() => {
          console.log(count);
          //카운트가 변환되면 바로 실행
          setCount(count - 1);
        }}
      /> */}
      {/* 근데 버튼을 다른 프로퍼티로 둘 수 있다 */}
      <Mybutton title="+" clickHandler={plusHandler} />
      <Mybutton
        title="-"
        clickHandler={() => {
          console.log(count);
          setCount(count - 1);
        }}
      />
      <Mybutton title="안녕" clickHandler={() => alert("안녕")} />
      <Mybutton />
    </div>
  );
};

//외부 모듈에서 부를 수 있도록 해주는 키워드
export default Counter;
