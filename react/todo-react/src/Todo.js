import { useState } from "react";

const Todo = ({ todo, removeHandler, updateHandler }) => {
  //근데 굳이 박스를 만들고 싶지 않아서 플래그먼트로 쓴다
  // 수정과, 수정폼
  const [updateMode, setUpdateMode] = useState(false);
  //수정할 내용
  const [title, setTitle] = useState(todo.title);
  //업데이트 상태를 갱신하는놈
  const updateModeHandler = () => {
    setUpdateMode(true);
  };
  const changeHandler = (e) => {
    setTitle(e.target.value);
  };

  const updater = () => {
    //수정을 적용
    //객체로 들어가니 {}로
    //근데 아직 수정은 안되었으니 todo를 통재로 보내지 않는다
    updateHandler({ id: todo.id, title: title });
    //시켰으면 수정 부분을 닫아
    setUpdateMode(false);
  };

  if (updateMode) {
    return (
      <>
        <input type="text" value={title} onChange={changeHandler} />
        <button onClick={updater}>수정</button>
      </>
    );
  } else {
    return (
      //if문으로 수정모드면 수정양식이, 수정이 아니면 보여주고/삭제방식이
      <>
        {todo.title}
        <button onClick={() => removeHandler(todo.id)}>삭제</button>
        <button onClick={updateModeHandler}>수정</button>
      </>
    );
  }
};

export default Todo;
