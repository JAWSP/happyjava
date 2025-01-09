const person = {
  name: "asd",
  job: {
    title: "student",
    manager: {
      name: "ww",
    },
  },
};

//매니저의 이름을 알고싶다
function printmanagerName(person) {
  console.log(
    person && person.job && person.job.manager && person.job.manager.name
  );
}

//위와 같긴함
function printmanagerName(person) {
  console.log(person?.job?.manager?.name);
}

printmanagerName(person);
printmanagerName({ name: "kim" });
printmanagerName();

const k = {
  name: "k",
  admin() {
    console.log("고나리자입니다");
  },
};

const j = {
  name: "j",
};

k.admin();
//함수가 있다면 실행, 아니면 실행x
j.admin?.();

//뒤에 맴버가 있다면 접근 아님 말구
console.log(k?.["age"]); //안나와
console.log(k?.["name"]); //나와
