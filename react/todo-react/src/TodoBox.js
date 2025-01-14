import { useEffect, useRef, useState } from "react";
import TodoInput from "./TodoInput";
import TodoList from "./TodoList";
import axios from "axios";

const TodoBox = () => {
  //왜 리스트를 박스에 넣냐
  //인풋에 넣고 리스트에도 넣어야 하기 때문에

  const [todoList, setTodoList] = useState([
    /*
    바로 아래에서 DB연동할려고 저리 함
    { id: 1, title: "숨쉬기" },
    { id: 2, title: "돈벌기" },
    { id: 3, title: "그리고 또 뭔가 있었는데" },
    */
  ]);

  //백앤드 서버에서 todoList를 가져오는 함수를 구현
  useEffect(() => {
    //비동기로 가져온다고 한다
    async function getTodos() {
      //값을 받을때까지 따로 기다림
      //아까 저 주소 보니까 JSON으로 받아왔자나
      const result = await axios.get("http://localhost:1577/api/todos");
      setTodoList(result.data);
    }
    //방금 선언한걸 쓴다
    getTodos();
  }, []);

  //id는 안쪽에서 저장되어서 증가만 하면 되기 때문에 useRef를 쓰면 된다고 한다
  //근데 id는 이미 따로 정의되어있는데..
  //추출 대신에 그냥 따로 만들어서 그 값을 넣어주면 되는거 아님?
  //const id = useRef(todoList.length + 1);
  const id = useRef(Math.max(...todoList.map((todo) => todo.id)));
  //근데 요게 더 안정적이라고 한다
  //윗놈은 꼭 12345순서대로 오거나 1부터 시작할 경우가 아닐 때도 있으니

  //대충 추가하는 함수

  const addTodoList = (title) => {
    console.log(title);
    //map로 ip값을 뽑아서 그걸 ...로 리스트화 시키고, 그걸 max로 구해낸다

    setTodoList([...todoList, { id: id.current, title: title }]);
    id.current += 1;
  };

  //대충 삭제하는 함수
  //id를 인자로
  //filter는 조건을 입맛대로 걸 수 있으며, 저걸로 다시 받을 수 있음
  const removeTodoList = (id) => {
    setTodoList(todoList.filter((list) => list.id !== id));
  };
  //대충 수정하는 함수
  //객체를 인자로
  const updateTodoList = (todo) => {
    console.log(todo);
    //리랜더링이 필요없다면
    todoList.map((list) => {
      if (list.id === todo.id) list.title = todo.title;
    });
    //수정 후 리랜더링이 필요할때
    // const todoList = todoList.filter((list) => {
    //   //만약에 둘이 같다면 그 값 대신 다른 값을 넣고, 아니면 리스트로 그대로 둠
    //   list.id === todo.id ? { ...list, title: todoList.title } : list;
    // });
  };
  return (
    <div>
      <TodoInput addTodo={addTodoList} />
      <TodoList
        todoList={todoList}
        removeHandler={removeTodoList}
        updateHandler={updateTodoList}
      />
    </div>
  );
};

export default TodoBox;
