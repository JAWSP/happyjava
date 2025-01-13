//자식을인자로 받는 부모?
const Parent = (p) => {
  const style = {
    border: "4px solid green",
    padding: "16px",
  };
  return <div style={style}>{p.children}</div>;
};
export default Parent;
