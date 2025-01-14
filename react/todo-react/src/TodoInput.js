const TodoInput = ({ addTodo }) => {
  const keyDownHandler = (e) => {
    console.log(e.key);
    if (e.key === "Enter") {
      //console.log(e.target.value);
      if (e.target.value === "") return; //공백이면 굳이...
      //엔터가 입력되면 여기서 리스트에 저장시킴 됨
      //근데 실제 저장되는건 박스에서 저장
      //왜냐고? 값을 거기서 담고 있거든
      addTodo(e.target.value);
      e.target.value = ""; //입력한 부분 초기화
    }
  };
  return (
    <input
      type="text"
      placeholer="여기에 할일입력 하고 엔터"
      //엔터 쳐서 반응하는 핸들러 추가
      //맥은 press로 해야 되나보네
      onKeyPress={keyDownHandler}
    />
  );
};

export default TodoInput;
