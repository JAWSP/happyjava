import { useState } from "react";
import Todo from "./Todo";

const TodoList = ({ todoList, removeHandler, updateHandler }) => {
  return (
    <ul>
      {todoList.map((todo) => (
        <Todo
          key={todo.id}
          todo={todo}
          removeHandler={removeHandler}
          updateHandler={updateHandler}
        />
        //삭제 버튼은 따로 컴포넌트로 분리
      ))}
    </ul>
  );
};

export default TodoList;
