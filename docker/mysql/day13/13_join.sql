-- 사원 정보를 알고 싶고, 사원번호, 이름 부서명, 급여 정보를 알고싶을때
-- 다른건 다 emp테이블에 있는데 부서명은 다른 테이블에 있게 된다
select empno, ename, dname, sal from emp, dept;

desc dept;
select * from dept;
select * from emp;

-- 하지만 join을 쓰게 된다면?
-- where emp.deptno = dept.deptno;가 join조건같은거라던데...
select empno, ename, dname, sal from emp, dept where emp.deptno = dept.deptno;

-- deptno를 출력하니 오류가 발생하네
-- select deptno empno, ename, dname, sal from emp, dept where emp.deptno = dept.deptno;
-- 중복되는테이블이 있는데 어느 테이블의 어느 칼럼인지 모르니까

-- 구체적으로 알려줘야 한다
select emp.deptno, empno, ename, dname, sal from emp, dept where emp.deptno = dept.deptno;
-- 테이블 명도 alias 가능
select e.deptno, e.empno, e.ename, d.dname, e.sal from emp e, dept d where e.deptno = d.deptno;


-- join이 여러개일때

use hr; -- hr로 바뀜

select e.employee_id, e.email, r.region_name, c.country_name, r.region_name 
from employees e, departments d, locations l, countries c, regions r
where e.department_id = d.department_id
 and d.location_id = l.location_id
 and l.country_id = c.country_id;
 
select count(*) from employees;
select count(department_id) from employees;
-- 사원 이름과 부서명을 출력, 단 location id가 1800인경우
select l.location_id, concat(e.first_name, " ", e.last_name) as name, d.department_name
 from employees e, departments d, locations l
	where e.department_id = d.department_id and d.location_id = l.location_id
		and l.location_id = 1800;

use scott;

-- 얜 독자적인 table
desc salgrade;
select * from salgrade;
-- 얘가 theta join
select e.ename, e.sal, s.grade
from emp e, salgrade s
where e.sal between s.min_salary and s.max_salary;

-- natural join
-- 두 테이블에 같은 이름이 존재한다면 그 이름을 조인조건으로 취급
select e.ename, d.dname
from emp e natural join dept d;
-- using으로 명시를 해줘도 되고
select e.ename, d.dname
from emp e join dept d using(deptno);

select e.ename, d.dname
from emp e join dept d on (e.deptno=d.deptno);
-- 요렇게 써도 똑같은 결과가 나온다

-- self join
-- 하나의 테이블을 테이블2개란 식으로 생각하고 하는 join
-- 사원의 사원과 매니저 번호와 메니저 이름을 알고 싶다
-- 근데 매니저 번호와 매니저 이름은 다 한 테이블에 있다고 한다
select e.empno 사번, e.ename 사원이름,
	m.empno 메니저사번, m.ename 매니저이름
from emp e, emp m
where e.mgr = m.empno;
-- 이건 mz 버전
select e.empno 사번, e.ename 사원이름,
	m.empno 메니저사번, m.ename 매니저이름
from emp e join emp m on (e.mgr = m.empno);

-- sub Query
-- 쿼리 하나로 알아보기에는 힘든 경우
-- 스미스 사원의 속한 부서의 평균 급여를 알고 싶은 경우

-- 스미스 사원의 부서번호
select deptno from emp where ename = 'SMITH'; -- 20
-- 20번 부서의 평균 급
select avf(sal) from emp where deptno = 20;

-- 이 둘을 합치는 경우
select avg(sal) from emp where deptno = (select deptno from emp where ename = "smith");
-- 서브 쿼리가 필요로 할 것 같다면 작은 단위부터 해야
-- scott의 급여보다 높은 급여를 받는 사람의 이름을 출력
select sal from emp where ename = 'scott';
select ename from emp 
where sal > (select sal from emp where ename = 'scott');
-- 얘도 multi-row query인
select ename, sal from emp where sal < (select avg(sal) from emp);

-- 서브쿼리의 row가 여러개일 경우
-- in = or의 조합이다
select ename, sal, deptno from emp where ename in ('kang', 'clark', 'adams', 'allen');
-- any -> or에 비교연산자가 포함됨
# 아 늦음
select * from emp where sal > any(950, 3000, 1250);
-- all -> any의 all버전
select * from emp where sal > all(select avg(sal) from emp group by deptno);

select * from emp;
-- 사원의 이름, 급여, 부서 번호를 출력, 단, 사원의 급여가 그 사원의 속해있는 평균 급여보다 큰 경우
-- 일단 쪼개기, 사원이 속한 부서의 평균 급여
-- ? -> 얜 값이 매번 바뀜
# select ename, sal, deptno from emp 
# where sal >
# 	(select avg(sal) from emp where deptno = ?)
-- as 로 emp에 바깥이라고 명시를 한다 그리고 이후에 비교를 한다고 한다
-- 그러니
select ename, sal, deptno from emp o
 where sal >
 	(select avg(sal) from emp where deptno = o.deptno);

-- 각 부서별로 최고 급여를 받는 사원을 출력
-- 각 부서의 최고 급여를 출력
select deptno, max(sal) from emp group by deptno;    
select e.deptno, e.empno, e.ename, e.sal 
	from emp e, (select deptno, max(sal) mx from emp group by deptno) m
    where e.deptno = m.deptno and e.sal = m.mx; 


SELECT  deptno, empno, ename, sal
FROM emp e
WHERE e.sal = (SELECT max(sal)
FROM emp WHERE deptno = e.deptno);
