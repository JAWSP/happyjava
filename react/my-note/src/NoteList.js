import Note from "./Note";

//중괄호 쳐주셈
const NoteList = ({ notes, deleteNoteHandler, updateNoteHandler }) => {
  return (
    <ul>
      {notes.map((note) => {
        return (
          <Note
            key={note.id}
            note={note}
            deleteNoteHandler={deleteNoteHandler}
            updateNoteHandler={updateNoteHandler}
          />
        );
      })}
    </ul>
  );
};

export default NoteList;
