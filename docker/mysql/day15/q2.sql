use hr;
desc employees;
desc departments;
desc jobs;
desc locations;
desc countries;
desc regions;
desc job_history;
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
    
-- 1 각 직원의 입사 연도를 조회
SELECT first_name, hire_date from employees;
