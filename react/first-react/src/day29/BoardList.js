import Board from "./Board";

const boardList = [
  {
    id: 3,
    title: "게시판 제목 3",
    created: "2021-10-01",
    readCount: 10,
    writer: "고길동",
  },
  {
    id: 2,
    title: "게시판 제목 2",
    created: "2021-09-22",
    readCount: 5,
    writer: "둘리",
  },
  {
    id: 1,
    title: "게시판 제목 1",
    created: "2021-07-03",
    readCount: 4,
    writer: "도우너",
  },
];

boardList.sort((a, b) => b.readCount - a.readCount);
const BoardList = () => {
  return (
    <table border="1">
      <caption>게시판 목록</caption>
      <thead>
        <tr>
          <th>번호</th>
          <th>제목</th>
          <th>작성자</th>
          <th>작성일</th>
          <th>조회수</th>
        </tr>
      </thead>
      <tbody>
        {
          //바로 아래의 저 부분을 반복문으로 쓰기
          // () 는 리턴이 필요없고, {}는 리턴이 필요하
          boardList.map((board) => (
            <Board
              key={board.id}
              id={board.id}
              title={board.title}
              writer={board.writer}
              created={board.created}
              readCount={board.readCount}
            />
          ))
        }
      </tbody>
      {/* 이렇게 쓰기에는 너무 빡시니 좀 스마트하게 쓸거임
      <tr>
        <td>{boardList[0].id}</td>
        <td>{boardList[0].title}</td>
        <td>{boardList[0].writer}</td>
        <td>{boardList[0].created}</td>
        <td>{boardList[0].readCount}</td>
      </tr>
      <tr>
        <td>{boardList[1].id}</td>
        <td>{boardList[1].title}</td>
        <td>{boardList[1].writer}</td>
        <td>{boardList[1].created}</td>
        <td>{boardList[1].readCount}</td>
      </tr>
      <tr>
        <td>{boardList[2].id}</td>
        <td>{boardList[2].title}</td>
        <td>{boardList[2].writer}</td>
        <td>{boardList[2].created}</td>
        <td>{boardList[2].readCount}</td>
      </tr> */}
    </table>
  );
};

export default BoardList;
