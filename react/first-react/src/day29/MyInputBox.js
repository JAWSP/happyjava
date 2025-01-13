import { useRef, useState } from "react";

const MyInputBox = () => {
  //텍스트가 바뀌는걸로
  const [text, setText] = useState("여기에 텍스트 입력");

  //useRef추가
  //얘를 이용하면 documents로 딱히 지정하지 않아도 가져올 수 있다고 한다
  const textInput = useRef();
  const labelRef = useRef();

  const resetHandler = () => {
    // alert("당신 입력한거 다시세트");
    setText("여기에 텍스트 입력");
    console.log(textInput);
    textInput.current.focus(); //아까 입력칸을 ref로 가져와서 넣은 textinput에 focus시킴
    console.log(labelRef);
  };
  const changeHandler = (e) => {
    //input에서 값을 받고
    //set함수로 값을 변경
    setText(e.target.value);
  };

  return (
    <div>
      <label ref={labelRef}>{text}</label> <br />
      {/* 저기는 그냥 적는데 */}
      <input
        type="text"
        value={text}
        onChange={changeHandler}
        ref={textInput}
      />
      {/* 요기는 버튼 */}
      <button onClick={resetHandler}>RESET</button>
    </div>
  );
};

export default MyInputBox;
