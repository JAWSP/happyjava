import First from "./First";
import Parent from "./Parent";
import Second from "./Second";

//실제로 사용되는 코드
const ChildrenEx = () => {
  return (
    //컴퍼넌트 안의 컴퍼넌트를 프롭스로 넘기겠다
    <Parent>
      <First></First>
      <Second name="asd" />
    </Parent>
  );
};
export default ChildrenEx;
