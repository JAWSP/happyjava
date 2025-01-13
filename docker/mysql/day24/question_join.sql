use hr;
SELECT * from employees;
SELECT * from departments;
SELECT * FROM jobs;
-- 1. 각 직원의 이름과 그들이 속한 부서 이름을 조회하세요.
SELECT e.first_name, d.department_name FROM employees e, departments d 
WHERE e.department_id = d.department_id;
SELECT e.first_name, e.last_name, d.department_name
FROM employees e
JOIN departments d ON e.department_id = d.department_id;
-- 2. 모든 직원의 이름과 그들의 직무 타이틀을 조회하세요.
SELECT e.first_name, j.job_title FROM employees e, jobs j WHERE e.job_id = j.job_id;
-- 3 모든 직원의 이름, 부서 이름 및 그들이 근무하는 국가 이름을 조회하세요.
SELECT e.first_name, e.last_name, d.department_name, c.country_name
FROM employees e
JOIN departments d ON  e.department_id = d.department_id
JOIN locations l ON d.location_id = l.location_id
JOIN countries c ON l.country_id = c.country_id;
-- 4 1999년 이후에 입사한 직원들과 그들의 직무 타이틀을 조회하세요.
SELECT e.first_name, e.last_name, j.job_title 
FROM employees e
JOIN jobs j ON e.job_id = j.job_id;
-- 5 모든 직원의 이름과 그들이 근무한 지역 이름을 조회하세요.
SELECT e.first_name, e.last_name, r.region_name FROM employees e
JOIN departments d ON  e.department_id = d.department_id
JOIN locations l ON d.location_id = l.location_id
JOIN countries c ON l.country_id = c.country_id
JOIN regions r ON c.region_id = r.region_id;