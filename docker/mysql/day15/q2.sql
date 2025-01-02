use hr;
desc employees;
desc departments;
desc jobs;
desc locations;
desc countries;
desc regions;
desc job_history;
select * from employees;
use scott;
select * from emp;
select deptno ename, sal, comm from emp order by 3 desc,2;
#1 모든 직원의 이름(first_name)과 성(last_name)을 조회
select first_name, last_name FROM employees;
-- 2모든 부서의 이름과 위치 ID를 조회
select department_name, location_id FROM departments;
-- 3 직업 ID와 직업 타이틀을 조회
SELECT job_id, job_title FROM jobs;
-- 4 각 위치의 주소와 우편번호를 조회
SELECT street_address, postal_code FROM locations;
-- 5 국가 ID와 국가 이름을 조회
SELECT country_id, country_name FROM countries;
-- 6 지역 ID와 지역 이름을 조회
SELECT * FROM regions;
-- 7 모든 직원의 직업 ID를 조회
SELECT employee_id, job_id FROM employees;
-- 8 부서 ID별로 부서 이름을 조회
SELECT department_id, department_name FROM departments;
-- 9 직원 ID와 부서 ID를 조회
SELECT employee_id, department_id FROM employees;
-- 10 직원 ID, 이름과 성을 조회
SELECT employee_id, last_name, first_name FROM employees;

## W H E R E
-- 1 급여가 10000 이상인 직원의 이름과 급여를 조회
SELECT first_name, salary FROM employees WHERE salary > 10000;
-- 2 위치 ID가 1700인 부서의 이름을 조회
SELECT department_name FROM departments WHERE location_id = 1700;
-- 3 직업 ID가 'IT_PROG'인 직원들의 전체 정보를 조회
SELECT * FROM employees WHERE job_id = 'IT_PROG';
-- 4 부서 ID가 90인 직원들의 이름과 급여를 
SELECT first_name, salary FROM employees WHERE department_id = 90;
-- 5 최소 급여가 5000 이상인 직업의 타이틀을 조회
SELECT job_title FROM jobs WHERE min_salary > 5000;
-- 6 성이 'King'인 직원의 전체 정보를 조회
SELECT * FROM employees WHERE last_name = 'king';
-- 7 국가 ID가 'US'인 위치의 상세 정보를 조회
SELECT * FROM locations WHERE country_id = 'US';
-- 8 시작 날짜가 '2001-01-01' 이전인 기록을 조회, 날짜는 date를 명시해야 하나보네
SELECT * FROM job_history WHERE start_date < DATE("2001-01-01");
-- 9 성에 'a'가 포함되는 직원들의 이름과 이메일을 조회
SELECT first_name, email FROM employees WHERE last_name LIKE "%a%";
-- 10 부서 이름이 'Sales'인 부서의 모든 직원 정보를 조회
-- 부서 이름이 sales를 조회 +  부서의 모든 직원의 정보를 조회
SELECT distinct e.* FROM employees e, departments d WHERE e.department_id = 
	(SELECT d.department_id FROM departments d WHERE d.department_name = 'Sales');
    
-- 1 각 직원의 입사 연도를 조회(연도만 뽑아서)
SELECT first_name, YEAR(hire_date) from employees;
-- 2 근무 기간을 월로 계산
SELECT employee_id, TIMESTAMPDIFF(MONTH, start_date, end_date) FROM job_history;
-- 3 오늘로부터 입사한 지 10년 된 직원들의 이름과 입사 날짜를 조회
SELECT last_name, hire_date from employees WHERE TIMESTAMPDIFF(YEAR, hire_date, now()) > 10;
-- 4 이번 달이 입사월인 직원들의 이름과 입사일을 조회
SELECT last_name, hire_date FROM employees WHERE DATE_FORMAT(now(), '%m') = DATE_FORMAT(hire_date, '%m');
-- 5 입사 날짜가 최근 30년 이내인 직원들의 이름과 입사 날짜를 조회
SELECT last_name, hire_date FROM employees WHERE TIMESTAMPDIFF(YEAR, hire_date, now()) < 30;
-- 6 job_history 테이블에서 직원이 특정 부서에 근무한 기간을 일(days) 단위로 조회
SELECT employee_id, department_id, TIMESTAMPDIFF(DAY, start_date, end_date) FROM job_history;
-- 7 가장 오래전에 입사한 직원의 이름과 입사 날짜를 조회
SELECT first_name, last_name, hire_date from employees ORDER BY hire_date LIMIT 1;
-- 8 employees 테이블에서 각 직원의 입사일로부터 경과한 일수를 조회하세요
SELECT first_name, last_name, hire_date, TIMESTAMPDIFF(DAY, hire_date, now()) from employees;
-- 9 1999년대에 시작된 모든 근무 기록을 조회
SELECT * FROM job_history WHERE DATE_FORMAT(start_date, '%Y') = 1999;
-- 10 각 직원의 입사 날짜를 요일로 표시
SELECT first_name, last_name, hire_date, DATE_FORMAT(hire_date,"%W") FROM employees;

-- 1 각 직원의 급여에 10% 인상된 금액을 계산하여 조회
SELECT first_name, last_name, salary * 1.1 FROM employees;
-- 2 각 직업의 최소 급여와 최대 급여의 차이를 계산
SELECT job_title, max_salary - min_salary FROM jobs;
-- 3 각 직원의 급여를 원화로 환산하여 조회
SELECT first_name, last_name, salary * 1500 FROM employees;
-- 4 전체 직원의 평균 급여보다 높은 급여를 받는 직원들의 이름과 급여를 조회
SELECT first_name, last_name, salary FROM employees WHERE salary > (SELECT avg(salary) FROM employees);
-- 5 각 직원의 급여에서 평균 급여를 뺀 금액을 계산하여 조회
SELECT first_name, last_name, salary - (SELECT avg(salary) FROM employees) FROM employees;
-- 6 급여의 표준 편차를 계산하여 조회
SELECT STD(salary) FROM employees;
-- 7 각 직원의 연봉을 계산하고, 연봉이 가장 높은 순으로 정렬하여 조회
SELECT first_name, last_name, salary * 12 FROM employees ORDER BY salary desc;
-- 8 부서 변경 횟수를 계산
SELECT COUNT(*) FROM job_history;
-- 9 직원들의 급여를 오름차순으로 정렬하여 조회
SELECT first_name, last_name, salary FROM employees ORDER BY salary;

-- 1 직원의 성(last_name)을 대문자로 변환하여 조회하기:
SELECT first_name, upper(last_name) FROM employees;
-- 2 직원의 이름(first_name)의 첫 글자를 추출하기:
SELECT substr(first_name, 1, 1), last_name FROM employees;
-- 3 직원의 성(last_name)에서 'a'가 몇 번 나오는지 세기:
-- 전체길이 - 찾고자 하는 부분 뺀 나머지 = 찾고자 하는 부분의 수
SELECT length(last_name) - length(REPLACE(last_name, 'a','')) FROM employees;
-- 4 직원의 이메일에서 도메인 부분만 추출하기 (@ 이후 문자열):
SELECT email FROM employees; #@가 없는데요
-- 5 직원의 전체 이름을 성과 이름으로 구분하여 조회하기:
SELECT concat(first_name, ' ', last_name) AS full_name FROM employees;
-- 6 직원의 이름(first_name)에서 세 번째 문자부터 세 글자 가져오기:
SELECT substr(first_name, 3, 3) FROM employees;
-- 7 모든 직원의 성(last_name)을 쉼표와 공백 후 이름(first_name)으로 표시하기:
SELECT concat(last_name, ', ', first_name) AS full_name FROM employees;
-- 8 직원의 이름(first_name)의 길이를 구하여 조회하기:
SELECT length(first_name) AS len FROM employees;
-- 9 직원의 성(last_name)이 'King'인 직원 찾기 (대소문자 구분 없이):
SELECT first_name, last_name FROM employees where last_name = "King";
-- 10 직원의 성(last_name) 중 'M'으로 시작하는 사람들의 수 구하기:
SELECT count(last_name) FROM employees where last_name like "M%";