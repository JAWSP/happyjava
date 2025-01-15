import { useEffect, useState } from "react";

const UseEffectEx = () => {
  console.log("useEfect 랜더링");

  const [count, setCount] = useState(0);
  const name = "test";

  //useEffect -- 컴포넌트가 마운트, 업데이트, 마운트 해제될떄 부려짐
  //useEffect(() => {}) -- 랜더링 될때마다 매번 실행
  //useEffect(()=>{}, []) -- [] 요배열(디팬던시어레이) 값이 변경될때마다 실행
  // []만 있으면 최초 한번만 실행

  //함수안에 함수를 리턴
  //useEffect(() => {return () => {clean-up코드}}, [])//언마운팅될때 함수가 실행
  //언마운팅은? -> 삭제, 폼이 나왔다가 안나왔다가

  useEffect(() => {
    console.log("마! useEfect 실행했다");
  });
  useEffect(() => {
    console.log("마! useEfect count 실행했다");
  }, [count]);
  useEffect(() => {
    console.log("마! useEfect [] 실행했다");
  }, []);
  return (
    <div>
      <span>간단한 카운트 :: {count}</span>
      <button
        onClick={() => {
          setCount(count + 1);
        }}
      >
        날눌러
      </button>
    </div>
  );
};
export default UseEffectEx;
