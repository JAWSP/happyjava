//웹에 보여줄 놈
//전체 화면을 차지하는 컴퍼넌트(블럭)이라고 한다

import Counter from "./Counter";
import BoardList from "./day29/BoardList";
import MyInputBox from "./day29/MyInputBox";
import ChildrenEx from "./day29/propsChildren/ChildrenEx";
import TitlePriceInputBox from "./day29/TitlePriceInputBox";
import UseRefEx from "./day29/UseRef/UseRefEx";
import UseStateEx from "./day29/useState/UseStateEx";
import UseStateEx2 from "./day29/useState/UseStateEx2";
import Welcome from "./day29/Welcome";
import Hello from "./Hello";
import Mybutton from "./Mybutton";

//여기서 덧붙이면 된다고 함
function App() {
  console.log("앱 실행");
  //여기서 화면에 보여줄 코드를 구현
  //HTML도 아니고 JS도 아닌 JSX
  return (
    <div>
      <UseRefEx />
      {/*
      <BoardList />
      //day29
      <UseStateEx2 />
      <ChildrenEx />
      <Welcome flag={true} />
      <MyInputBox />
      <MyInputBox />
      //day 28
      <h1>버튼</h1>
      <Counter></Counter>
      <Mybutton title="나도 가능" />
      <Hello color="red" name="안녕" isSpecial={false} /> */}
    </div>
  );
}

export default App;
