import { useState } from "react";
import NoteInput from "./NoteInput";
import NoteList from "./NoteList";

//얘가 배열

const NoteBox = () => {
  const [notes, setNotes] = useState([
    {
      id: Date.now(),
      title: "대충 제목",
      createdAt: new Date().toLocaleString(),
    },
    {
      id: Date.now() + 1,
      title: "아아아",
      createdAt: new Date().toLocaleString(),
    },
    {
      id: Date.now() + 2,
      title: "노트제목입니다",
      createdAt: new Date().toLocaleString(),
    },
  ]);

  const addNoteHandler = (title) => {
    const newNote = {
      id: Date.now(),
      title: title,
      createdAt: new Date().toLocaleString(),
    };

    setNotes([...notes, newNote]);
  };

  const deleteNoteHandler = (id) => {
    //따로 두고 다시 만들고
    //notes = notes.filter((note) => note.id !== id);
    //초기화
    setNotes(notes.filter((note) => note.id !== id));
  };

  const updateNoteHandler = (note) => {
    notes.map((list) => {
      if (list.id === note.id) {
        list.title = note.title;
      }
    });
    setNotes(notes);
  };

  return (
    <div>
      <NoteInput addNote={addNoteHandler} />
      <NoteList
        notes={notes}
        deleteNoteHandler={deleteNoteHandler}
        updateNoteHandler={updateNoteHandler}
      />
    </div>
  );
};
export default NoteBox;
