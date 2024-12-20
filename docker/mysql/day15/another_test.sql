insert into dept(deptno,dname,loc) values(70, 'lion', '');

commit;
update dept set dname='qwer' where deptno =90;
commit;
update dept set dname='qwesddar' where deptno =90;
delete from dept where deptno=90;
delete from dept where deptno=70;
commit;
select * from dept;
select deptno, dname, loc from dept where deptno=10;
desc emp;
select * from emp;
insert into emp(ename, job, mgr, sal, comm, deptno) values("AAA", "무직", null, 110, 220, null);
insert into emp(ename, job, mgr, sal, comm, deptno) values("test", "무직", 0, 110, 220, null);