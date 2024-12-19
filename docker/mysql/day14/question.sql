use hr;
/*
### 날짜형 함수 사용 (날짜 데이터 처리)

1. `employees` 테이블에서 각 직원의 입사 연도(year)를 조회하세요.
2. `job_history` 테이블에서 각 기록의 근무 기간을 월(months) 단위로 계산하세요.
3. `employees` 테이블에서 오늘로부터 입사한 지 30년이 된 직원들의 이름과 입사 날짜를 조회하세요.
4. `employees` 테이블에서 이번 달이 입사월인 직원들의 이름과 생일을 조회하세요.
5. `employees` 테이블에서 입사 날짜가 최근 30년 이내인 직원들의 이름과 입사

 날짜를 조회하세요.
6. `job_history` 테이블에서 직원이 특정 부서에 근무한 기간을 일(days) 단위로 조회하세요.
7. `employees` 테이블에서 가장 오래전에 입사한 직원의 이름과 입사 날짜를 조회하세요.
8. `employees` 테이블에서 각 직원의 입사일로부터 경과한 일수를 조회하세요.
9. `job_history` 테이블에서 1999년대에 시작된 모든 근무 기록을 조회하세요.
10. `employees` 테이블에서 각 직원의 입사 날짜를 요일로 표시하세요.

### 숫자형 함수 사용 (수치 데이터 처리)

1. `employees` 테이블에서 각 직원의 급여에 10% 인상된 금액을 계산하여 조회하세요.
2. `jobs` 테이블에서 각 직업의 최소 급여와 최대 급여의 차이를 계산하세요.
3. `employees` 테이블에서 각 직원의 급여를 원화(KRW)로 환산하여 조회하세요 (환율 가정: 1 USD = 1200 KRW).
4. `employees` 테이블에서 전체 직원의 평균 급여보다 높은 급여를 받는 직원들의 이름과 급여를 조회하세요.
5. `employees` 테이블에서 각 직원의 급여에서 평균 급여를 뺀 금액을 계산하여 조회하세요.
6. `employees` 테이블에서 급여의 표준 편차를 계산하여 조회하세요.
7. `employees` 테이블에서 각 직원의 연봉을 계산하고, 연봉이 가장 높은 순으로 정렬하여 조회하세요.
8. `job_history` 테이블에서 각 기록에 대해 부서 변경 횟수를 계산하세요.
9. `employees` 테이블에서 직원들의 급여를 오름차순으로 정렬하여 조회하세요.
*/

select * from employees;
select * from job_history;
-- 1
select first_name, date_format(hire_date, '%y') from employees;
-- 2 -> month는 m
select employee_id AS name,
	PERIOD_DIFF(DATE_FORMAT(end_date, '%Y%m'), DATE_FORMAT(start_date, "%Y%m"))
    from job_history;
-- 3 -> 대문자 Y는 4글자 다 소문자 y는 2글자만, PERIOD_DIFF는 개월수만 계산해줌
select first_name, hire_date, DATE_FORMAT(CURDATE(), '%Y') - DATE_FORMAT(hire_date, '%Y') as dif  from employees
	where DATE_FORMAT(CURDATE(), '%Y') - DATE_FORMAT(hire_date, '%Y') >= 30;

-- 4 아니 생일은 안보이는데요
SELECT first_name, hire_date FROM employees
	WHERE DATE_FORMAT(CURDATE(), '%m') = DATE_FORMAT(hire_date, '%m');

-- 5
select first_name, hire_date, DATE_FORMAT(CURDATE(), '%Y') - DATE_FORMAT(hire_date, '%Y') as dif  from employees
	where DATE_FORMAT(CURDATE(), '%Y') - DATE_FORMAT(hire_date, '%Y') < 30;

-- 6
SELECT DATE_FORMAT(end_date, '%Y%m%d') -  DATE_FORMAT(start_date, "%Y%m%d")
	FROM job_history;
-- 7 제일 오래된 사람 ->min(hiredate) from employees, 
SELECT first_name, hire_date FROM employees
	WHERE hire_date in (select min(hire_date) from employees);
-- =과 같아도 됨

-- 8 
SELECT first_name, 
	DATE_FORMAT(curdate(), '%Y%m%d') -  DATE_FORMAT(hire_date, "%Y%m%d") as carrer
    FROM employees;

-- 9 1990년대 
SELECT * FROM job_history 
	WHERE DATE_FORMAT(start_date, "%Y") >= 1990 and DATE_FORMAT(start_date, "%Y") < 2000;
-- 10 요일로 바꾸는게 있었나..?
SELECT dayname(hire_date) FROM employees;

-- 숫자형 함수

-- 1
SELECT first_name, salary *1.1 FROM employees;
-- 2
SELECT job_title, max_salary - min_salary FROM jobs;
-- 3
SELECT first_name, concat(salary * 1200, 'KRW') FROM employees;
-- 4
SELECT first_name, salary FROM employees
	WHERE salary > (SELECT avg(salary) FROM employees);
-- 5 역시 그룹함수는 단일로 연산이 안되는 것인가
SELECT first_name, salary - (SELECT avg(salary) FROM employees) from employees;
-- 6 표준편차는 STDDEV
SELECT STDDEV(salary) as '표준편차' FROM employees;
-- 7
select first_name, salary * 12 FROM employees order by salary desc;
-- 8
# 부서 변경이 뭐죠?
-- 9
select first_name, salary FROM employees order by salary desc;