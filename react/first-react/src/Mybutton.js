//컴포넌트 안의 컴포넌트
//()안에 부모가 속성을 넘겨주는데 여러개를 넘겨줄 수 있으니 객체로 넘긴다고 한다
//props는 그냥 편의상 저리 넣어준거
const btnStyle = {
  color: "white",
  background: "teal",
  padding: ".375rem .75rem",
  margin: ".5rem",
  border: "1px solid teal",
};
//얜 그냥 const Mybutton({title, clickHandler})로
//구조분해 할당으로 할 수 있다고 한다
const Mybutton = (props) => {
  //title는 그렇게 쓰자고 약속해서
  return (
    <button style={btnStyle} onClick={props.clickHandler}>
      {props.title}
    </button>
  );
};

//디폴트 생성자 같은거
Mybutton.defaultProps = {
  title: "button",
  clickHandler: () => {
    alert("핸들러");
  },
};

export default Mybutton;
