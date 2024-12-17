show databases;

use hr;

desc employees;
-- 1
select first_name, last_name from employees;
-- 2
select department_name, location_id from departments;
-- 3
select job_id, job_title from jobs;
-- 4 
select street_address, postal_code from locations;
-- 5
select country_id, country_name from countries;
-- 6
select region_id, region_name from regions;
-- 7
select job_id from employees;
-- 8
select department_id as 부서id, department_name 부서명 FROM departments;
-- 9
select employee_id, department_id from job_history;
-- 10
select employee_id, first_name, last_name from employees;

-- USING WHERE

-- 1
select first_name, salary from employees where salary > 10000;
-- 2
select department_name from departments where location_id = 1700;
-- 3
select * from employees where job_id = 'IT_PROG';
-- 4
select first_name, salary from employees where department_id = 90;
-- 5
select job_title from jobs where min_salary >= 5000;
-- 6
select * from employees where last_name = 'King';
-- 7
select * from countries where country_id = 'US';
-- 8
select * from job_history where start_date < '2001-01-01';
-- 9
select first_name, email from employees where last_name like '%a%' order by first_name;
-- 10
select * from departments where department_name = "Sales";
