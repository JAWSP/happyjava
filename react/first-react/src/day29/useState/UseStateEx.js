import { useState } from "react";

const UseStateEx = () => {
  const [time, timeSet] = useState(1);
  const updateHandler = () => {
    // if (time === 12) {
    //   timeSet(1);
    //   return;
    // }
    time === 12 ? timeSet(1) : timeSet(time + 1);
  };
  return (
    <div>
      <span>아니 시간이 벌써 {time}시라고?</span> <br />
      <button onClick={updateHandler}>update</button>
    </div>
  );
};

export default UseStateEx;
