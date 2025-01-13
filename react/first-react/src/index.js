import React from "react";
import ReactDOM from "react-dom/client";
import "./index.css";
import App from "./App";

//div root를 찾아오고
//reactDOM은 이미 가지고 있는거
//getElementById로 요소를 가져와서 그걸 토대로 루트를 만든다고 한다
const root = ReactDOM.createRoot(document.getElementById("root"));
//그 root에 app이란걸 보여준다고 한다
root.render(<App />);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
