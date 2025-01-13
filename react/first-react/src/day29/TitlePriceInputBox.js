import { useState } from "react";

const TitlePriceInputBox = () => {
  //useState값을 객체로 설정
  const [inputs, setInputs] = useState({
    title: "",
    price: "",
  });
  //이렇게 비구조 할당 가능
  const { title, price } = inputs;

  const changeHandler = (e) => {
    //타갯 객체에서 필요한 부분만 가져와서 비구조할당
    const { name, value } = e.target;
    //새로운 객체를 만들고 바뀐값은 바꿔주기
    setInputs({
      ...inputs,
      [name]: value,
    });
  };
  return (
    <div>
      <label>title : {title} </label>
      <br></br>
      <label>price :{price} </label>
      <br></br>
      제목 :{""}
      <input
        type="text"
        placeholder="제목을 입력하세요."
        name="title"
        onChange={changeHandler}
      />
      <br></br>
      가격 :{""}
      <input
        type="text"
        placeholder="가격을 입력하세요."
        name="price"
        onChange={changeHandler}
      />
      <br></br>
      <button>RESET</button>
    </div>
  );
};

export default TitlePriceInputBox;
