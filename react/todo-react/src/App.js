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
    </div>
  );
}

export default App;
