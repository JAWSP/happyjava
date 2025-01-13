import { createContext, useState } from "react";

//state초기값에 배열을 이용
const UseStateEx2 = () => {
  const [input, setInput] = useState("");
  const [uploads, setUploads] = useState(["a", "b", "c"]);
  const inputHandler = (e) => {
    setInput(e.target.value); //입력바에 글자를 입력받으면 보이게 하는거
  };
  const uploadHandler = () => {
    console.log(...uploads);
    //이렇게 해도 된다고 한다, 이러면 배열의 모든 요소들을 출력함
    //배열을 만들고, 추가하기
    setUploads([input, ...uploads]);
    //push없이 이렇게 되는듯 새 배열을 통째로 만든다고 한다
    // 새로 나온놈에 기존에 있었던 요소까지 다 넣은 새로운 요소를 추가
  };

  return (
    <div>
      <input type="text" value={input} onChange={inputHandler} />
      <button onClick={uploadHandler}>입력</button> <br />
      {/* 입력 받은 값들을 리스트로 출력 
      근데 그냥 깡으로 하는 것 보다 키-벨류로 해주는게 안전하다고*/}
      {uploads.map((name) => {
        return <p>{name}</p>;
      })}
    </div>
  );
};

export default UseStateEx2;
