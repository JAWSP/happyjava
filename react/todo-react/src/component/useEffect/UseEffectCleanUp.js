//함수안에 함수를 리턴
//useEffect(() => {return () => {clean-up코드}}, [])//언마운팅될때 함수가 실행
//언마운팅은? -> 삭제, 폼이 나왔다가 안나왔다가

import { useState } from "react";
import Timer from "./Timer";

const UseEffectCleanUp = () => {
  const [showTimer, setShowTimer] = useState(false);
  return (
    <div>
      {
        //만약에 쇼타이머가 false면 안보여주고
        //true면 타이머를 보여줌
        showTimer && <Timer />
      }
      <button
        onClick={() => {
          setShowTimer(!showTimer);
        }}
      >
        나는 팀버튼이 아니에요
      </button>
    </div>
  );
};
export default UseEffectCleanUp;
