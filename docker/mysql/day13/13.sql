use hr;

select * from employees;

select * from employees where first_name = 'karen';
-- 이렇게 하나씩 찾기에는 빡셈
-- index는 값들을 가지고 트리를 만들어서 찾기 때문에 매우 빠르다
desc employees;
show index from employees;
-- 인덱스 생성 
-- 인덱스 거는게 더 효율적이라고 생각하고 거세요
-- 무턱대고 걸다가 입력,수정,삭제할때 추가 작업이 필요해서 오히려 성능이 떨어짐
create index ind_empolyees_firstname on employees(first_name);
-- 인덱스 삭제
drop index ind_empolyees_firstname on employees;


SELECT LPAD('hi', 5, '?');

use scott;

SELECT LPAD('hi', 5, '?');
-- 특정 문자로 채워주는 함수 2번째 인자보다 작을 경우 3번째 인자로 채워준다고 한다
select lpad(ename, 10, '*')from emp;
-- 숫자에 문자로 더해서 lpad할 수 없기 때문에 cast로 변환해서 쓴다
select empno, lpad(cast(sal as char), 10, '*') from emp;

-- 양 옆 공백 빼주는 함수
select LTRIM("   hi   "), RTRIM("    asd     "), TRIM("      hi    ");
-- 절대값을 보여주는 함수
SELECT abs(2), ABS(-2);
-- 나머지 보여주는 함수
SELECT MOD(123, 10), 123 %10;
-- ()보다 작지 않은 가장 작은 정수 찾기
select CEILING(1.23), CEILING(-1.23);
-- ()에 가장 근접한 정수
SELECT ROUND(-1.23), ROUND(-1.58), round(1.58);
-- pow(x, y) -> x의 y승
select pow(2,2), power(2, 2),POW(2, -2);
-- 음수이면 -1, 0이면 0, 양수면 1
select SIGN(-2), sign(0), SIGN(123);
-- 현재 날짜와 시각을 반환
SELECT CURDATE(), CURTIME(), CURRENT_TIME;
-- 날짜 출력 방식을 변경
select date_format(curdate(), '%W %m %y');
-- 날짜 차이를 반환
select period_diff(date_format(curdate(), '%y%m'), date_format(hiredate, '%y%m')) from emp;
-- 형변환
select cast(now() as date), cast(1-2 as unsigned);


-- 단일행 함수(한 행에 하나씩)
select lpad(ename, 10, '#') from emp;
-- 그룹 함수(여려 행에 하나의 결과)
select sum(sal) from emp;
select avg(sal) from emp;
-- count 는 총 수량 세기
select count(*) from emp;


-- 각 부서 급여의 총합을 알고 싶을때
select sum(sal) from emp where deptno = 10;
-- 모든 부서를 보고 싶다면 group by
select job, deptno, sum(sal) from emp group by job, deptno order by 1;

-- 직업별 사원수와 평균급여
select job, count(*), avg(sal) from emp group by job;
-- 20번 부소의 job별 평균급여를 알고 싶을때
select deptno, job, avg(sal) from emp where deptno = 20 group by job;
-- 부서별 총 급여액이 9000이 넘는 부서만 보고 싶을때 (얜 그룹핑한 데이터에 조건 걸고 싶으면 having)
select deptno from emp group by deptno having sum(sal) > 9000;
-- 부서별 평균액을 보고 싶지만 4500이상이거나 1000미만인 사원은 빼서 계산해주고 싶고, 평균 급여가 2500이하의 인원들만 보고 싶을떄
select deptno, avg(sal) from emp where sal < 4500 or sal >= 1000 group by deptno having avg(sal) < 2500;

select deptno, avg(sal) a from emp 
	where sal < 4500 or sal >= 1000 
	group by deptno having a < 2500;

-- join
-- 사원 이름과 부서명을 출력, 단, 부서번호가  20번인 사원만 출력
select e.deptno, e.ename, d.dname from emp e, dept d where e.deptno = d.deptno and e.deptno = 20;

-- 얜 독자적인 table
desc salgrade;
select * from salgrade;
-- 얘가 theta join
select e.ename, e.sal, s.grade
from emp e, salgrade s
where e.sal between s.losal and s.hisal;