let oldName = "송아지";
let newName = "송대관";

//단축 평가가 사용하지 않은 코드
if (newName) {
  oldName = newName;
}
console.log("사용전 :" + oldName);
oldName = "송아지";
//단축평가 사용한 코드
newName && (oldName = newName); //newName이 있다면 오른쪽을 적용
console.log("사용후 :" + oldName);

//더 간단하게
oldName = "송아지";
////oldname이 있다면 그 값은 newName으로 바뀐다
oldName &&= newName; //oldName=newName;
console.log("더 간단한 사용후 :" + oldName);

const person = { name: "", age: 0 };
person.age ??= 21; //age에 값이 있다면 안넣고 없으면 21넣기
console.log(person.age);
//만약에 왼쪽의 값이 false면 왼쪽에 오른쪽을 넣는다
person.name ||= "asd";
console.log(person.name);
