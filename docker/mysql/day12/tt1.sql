use hr;
use scott;

desc emp; -- 테이블 구조를 보여줌

select empno, deptno, ename from emp; -- emp테이블 에서 특정 열을 볼때
select * from emp; -- emp테이블에서 모든 열을 볼

show tables;

-- 조회하기
-- select ->보여주셈
-- emp ->조회할 테이블을
select empno,ename,job from emp; 
-- dept테이블 구조를 보여줌
desc dept;
-- 구조 보고 특정 열 보기
select deptno,loc from dept;

desc salgrade;
select grade, min_salary, max_salary from salgrade;
-- 다른 db를 보기
use hr;
-- hr db의 테이블들을 보기
show tables;

use scott;
desc emp;
-- 중복방지
select distinct deptno from emp;
-- alias 는 별칭으로 이름이 다르게 들어감
select empno 사번, sal as "이세상 어떤 무언가보다 바꿀 수 없는 소중한 " from emp;
-- 데이터에 연산시키기
select empno, sal * 18 as 연봉 from emp;
-- 컬럼의 합성, 오라클은 ||로 이용한다
select concat(ename, " ", job,"의 급여는", sal) as 사원, job as ass from emp;
-- 테이블의 정렬 뒤의 desc는 내림차순, 앞의 desc와는 다르다
select deptno,nename, sal from emp order by ename, sal desc;
select deptno ename, sal, comm from emp order by 3 desc,2;
select deptno,nename, sal from emp order by ename desc, sal desc;
-- where는 조건에 맞는 데이터타입 조회시켜줌
-- &&도 먹힘
select * from emp where sal >2500;
select * from emp where deptno >= 20 || sal > 1500;

select * from emp where hiredate < '1990-10-10';

-- null은 범위가 광대해서 =로 비교가 안됨
-- 따라서 is null, is not null로 해야 한다
select * from emp where comm is not null;

-- mySQL은 대소문자를 구분 안한다고 한다, 다른 DBMS들은 구분한다고 함
select * from emp where ename='smith';
select * from emp where ename='sMiTh';
select * from emp where lower(ename)= 'smith';
-- _, % -> _ 는 한글자를 대체, %0->문자 여러개를 대체가능하다

-- 얜 이름이 4글자
select * from emp where ename like '____';
-- 얜 이름이 s로 시작하는 사람
select * from emp where ename like "s%";
-- 얜 이름이 s로 끝나는 사람
select * from emp where ename like "%s";
-- 얜 3번째 글자가 e인 사람
select * from emp where ename like "__e%";
-- 10, 20값이 들어있는 얘들을 조회
select * from emp where deptno in (10, 20);
-- 10, 20외의 값이 들어있는 얘들을 조회
select * from emp where deptno in (10, 20);



-- to upper와 같은 경우
select upper('super') as 슈퍼;
-- 칼럼도 가능함
select upper(ename) as 어퍼 from emp;

-- 문자 자르기, 얜 인덱스는 1번부터 시작
-- 3번 인덱스에서 2자 잘라달라
select substring('happy day', 3, 2); -- pp
select substring('happy day', 5, 3); -- y d


desc emp;
select * from emp;
-- 날짜 1ㄴ 추가
select date_add(hiredate, INTERVAL 1 DAY) as "일자에 1일 추가" from emp;

select reverse(ename) from emp;

select * from all_users;
