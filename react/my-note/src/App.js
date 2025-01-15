import NoteBox from "./NoteBox";
const style = {
  border: "4px solid green",
  padding: "16px",
  backgroundImage: "url(./image.gif)",
};
function App() {
  return (
    <>
      <div style={style}>
        <h1>이건 노트여</h1>
        <NoteBox />
      </div>
      <div>
        <img src="00501701_20171026.jpeg" heigh="600px" width="400px" />
      </div>
      <h1>인생 날로 먹고 싶어요</h1>
    </>
  );
}

export default App;
