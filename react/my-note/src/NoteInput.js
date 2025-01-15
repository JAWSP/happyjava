const NoteInput = ({ addNote }) => {
  const keyHandler = (e) => {
    //얜 키보드 입력시 나오는거
    //console.log(e.key);
    //얜 빈칸에 나온거
    //console.log(e.target.value);
    if (e.key === "Enter") {
      if (e.target.value === "") return;
      addNote(e.target.value);
      e.target.value = "";
    }
  };
  return (
    <input
      type="text"
      placeholder="여기에 노트입력"
      onKeyUp={keyHandler}
    ></input>
  );
};

export default NoteInput;
