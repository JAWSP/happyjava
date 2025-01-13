const Hello = ({ color, name, isSpecial }) => {
  return (
    <div style={{ color }}>
      안녕 {isSpecial} {name}
    </div>
  );
};

Hello.defaultProps = {
  color: "blue",
  name: "john doe",
  isSpecial: "asd",
};

export default Hello;
