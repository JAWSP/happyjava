import UseEffectCleanUp from "./component/useEffect/UseEffectCleanUp";
import UseEffectEx from "./component/useEffect/UseEffectEx";
import TodoBox from "./TodoBox";

const style = {
  border: "4px solid green",
  padding: "16px",
};
function App() {
  return (
    <div className="card" style={style}>
      <h1>Todo-List</h1>
      <TodoBox />
      {/* day30
      <TodoBox /> */}
      {/*day31
       <UseEffectEx></UseEffectEx> 
       <UseEffectCleanUp></UseEffectCleanUp>*/}
    </div>
  );
}

export default App;
