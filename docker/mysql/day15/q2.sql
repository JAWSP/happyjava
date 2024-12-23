use hr;
desc employees;
desc departments;
#1 모든 직원의 이름(first_name)과 성(last_name)을 조회
select first_name, last_name FROM employees;
-- 2모든 부서의 이름과 위치 ID를 조회
select department_name, location_id FROM departments;
-- 3 직업 ID와 직업 타이틀을 조회