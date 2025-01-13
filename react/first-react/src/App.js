//웹에 보여줄 놈
//전체 화면을 차지하는 컴퍼넌트(블럭)이라고 한다

import Counter from "./Counter";
import Hello from "./Hello";
import Mybutton from "./Mybutton";

//여기서 덧붙이면 된다고 함
function App() {
  console.log("앱 실행");
  //여기서 화면에 보여줄 코드를 구현
  //HTML도 아니고 JS도 아닌 JSX
  return (
    <div>
      <h1>버튼</h1>
      <Counter></Counter>
      <Mybutton title="나도 가능" />
      <Hello color="red" name="안녕" isSpecial={false} />
    </div>
  );
}

export default App;
