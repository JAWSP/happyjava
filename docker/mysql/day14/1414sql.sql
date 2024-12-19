-- 테이블 생성
create table a (
-- 칼럼명 타입명
	name int 
);

create table b (
	name int
);

select database();

show tables;
-- 테이블에 값 추가
insert into a values(1);
insert into a values(2);
insert into a values(3);

insert into b values(4);
insert into b values(3);
insert into b values(2);

select * from a;
select * from b;
-- 테이블에 값 제거
delete from b where name = 2; -- 이게 정석인데 워크밴치가 막는중
-- 합집합
select * from a
union
select * from b;

select * from a
union all
select * from b;
-- 교집합
select * from a intersect select * from b;
-- 같은 의미
select b.name from a, b where a.name = b.name;

-- 여집합?
# select * from a minus select * from b; -- 얜 안되네
select a.name from a where a.name not in (select b.name from b);
-- not in이 저기 있는 값들중 없기만 하면 true라고 한다

-- rank
select sal, ename, rank() over(order by sal desc) as ranking
from emp;

-- 책이란 테이블을 생성해보자
create table book (
	id int primary key auto_increment, -- 기본키, 중복 방지를 위해 primary key로 해준다
    title varchar(100) not null, -- 문자열은 길이를 미리 할당하나보네, not null는 null을 허용하지 않는다고
    author varchar(100),
    published_date date,
	price int
);

create table auto_exam (
-- auto_increment는 자동으로 증가, primary key는 기본키라고 말해줌
id int primary key auto_increment, 
namdeptnoe varchar(100)
);
-- insert는 테이블에 데이터를 입력해주는 명령어라고 한다
-- insert into 테이블명 (칼럼들...) <-생략 가능 values (값);  <-- 이게 기본형이라고 한다
-- 칼럼들이 생략될떄는 values()안에 모든 칼럼의 값들이 나열되어야 한다
-- 하지만 auto는 vlaues()안에 안넣어도 되기 떄문에 저렇게 넣어줘야 한다

insert into auto_exam values ("sad"); -- 다 명시 안했는데 칼럼쪽에 명시안해서 오류
insert into auto_exam (name) values ("sad");
insert into auto_exam (name) values ("sss");
insert into auto_exam (name) values ("ass");
insert into auto_exam values ( null, "asss"); -- 이렇게 해도 됨
insert into auto_exam values ( 400, "ㅈㅂasss"); 
insert into auto_exam values ( 200, "awwsss");
insert into auto_exam values ( null, "2112/");
select * from auto_exam;
select distinct deptno from emp;
select distinct deptno from dept;

desc emp;
-- emp테이블에 데이터 한건 입력해보셈
-- 근데 포린키가 있을 경우 거기에 있는 값으로 잘 넣어둬야 한다
insert into emp values (null, "asd", "no job", null, null, 0, null, null);
delete from emp where ename = "asd"; 

create table roles (
id int auto_increment primary key,
name varchar(50) not null unique -- 유니크는 중복방지
);

create table user_accounts (
	id int auto_increment primary key,
    user_id varchar(50) not null unique ,
    user_name varchar(45) not null unique,
    email varchar(100) not null unique,
    password varchar(200) not null,
    create_at datetime default current_timestamp, -- default는 아무런 값을 안줬을 때 기본으로 들어가는 값
    role_id int,
    foreign key fk_user_roles (role_id) references roles(id) -- 포린키는 이렇게 준다고 한다
);

-- 제약 조건의 이름을 명시적으로 정해줄 수 있고, 정하지 않으면 DBMS가 알아서 정해줌 

insert into roles(name) values('admin'), ('user'), ("guest"); -- 한꺼번에 값을 넣을 수 있네?
select * from roles;

insert into user_accounts (user_id, user_name, email, password, role_id)
values("awswqd", "Aqsa", "2dasdaa221s", 2111212112, 2),
("assdwas", "2qㅈ", "2dasdaasw22", 21121222, 1),
("as3weqqd", "wABCD", "2dad12sdas", 2112122112, 3),
("가가d가가ㄱ가", "가e곡", "2dadsdas", 211111212, 1);

set time_zone = 'Asia/Seoul'; -- 시간 잘 맞추기
select * from user_accounts;

-- 트랜잭션(나눌 수 없는 하나의 업무단위..?)
-- 계좌이?

-- 수정 update 테이블명 set 업데이트할칼럼명 = '업데이트할 값', '업데이트할컬럼명' = '업데이트할 값' ....
show tables;
select * from a;

update a set name = 5;
select * from a;

rollback;
update a set name = 10;
rollback;
select * from a;
-- 삭제는 delete
-- 키가 있다면 부모키랑 같이 지우거나 냅두고 자기만 null되거나 된다
-- 그래서 그 부분을 알려줘야 한다

-- 삭제(연관관계가 있는 경우)
delete from roles where id = 1;
-- 근데 관계를 가지면 안잘라진다
select * from user_accounts;

-- 그래서 
alter table user_accounts
	drop foreign key fk_user_roles; -- 이름을 부여하지 않으면 자동으로 부여된다
    
alter table user_accounts
	add constraint fk_user_roles
    foreign key(role_id) references roles(id);
-- on delete cascade삭제시 같이 삭제
SELECT @@AUTOCOMMIT;


