import { useState } from "react";

const Note = ({ note, deleteNoteHandler, updateNoteHandler }) => {
  //폼
  const [updateMode, setupdateMode] = useState(false);
  const [title, setTitle] = useState(note.title);

  const updatingMode = () => setupdateMode(!updateMode);
  const changeHandler = (e) => setTitle(e.target.value);
  const updater = () => {
    updateNoteHandler({ id: note.id, title: title, createdAt: note.createdAt });
    setupdateMode(false);
  };
  if (updateMode) {
    return (
      <li>
        <input
          type="text"
          placeholder="여기에 수정내용 입력"
          onChange={changeHandler}
        ></input>
        <button onClick={updater}>저장</button>
        <button onClick={updatingMode}>취소</button>
      </li>
    );
  } else {
    return (
      <li>
        <p>{note.title}</p>
        {note.createdAt} <br />
        <button onClick={updatingMode}>최수종</button>
        <button onClick={() => deleteNoteHandler(note.id)}>김삭제</button>
      </li>
    );
  }
};

export default Note;
