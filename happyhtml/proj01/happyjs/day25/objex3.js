const numbers = {
  _a: 1,
  _b: 2,
  //getter는 get으로 쓴다
  //:는 안씀
  get a() {
    console.log("getter");
    return this._a;
  },
  //이렇게로도 쓰임
  get sum() {
    return this._a + this._b;
  },
  //얜 오버로딩이 안되나보네
  set a(value) {
    console.log("setter");
    this._a = value;
  },
  get b() {
    console.log("getter");
    return this._b;
  },
  set b(value) {
    console.log("setter");
    this._b = value;
  },
};

//priviate가 아니니 그냥 밖에서 재설정이 가능함
numbers.a = 5;
numbers.b = 10;
console.log(numbers);
console.log(numbers._a);
console.log(numbers.b);
