select version();
select current_date();
 -- select cuurent_user();
select sin(pi()/4);

select
version(),
4+1;
select user();
select current_user();
-- 주석(시로 시작하는 그거 아님)
-- 계정 만들기
-- @는 ~에서 접속한다, %는 모든것(*과 같음) 아무데서나
-- identified by는 create user와 같은 예약어인데 저걸 비번으로 쓴다는듯
create user 'like'@'%' identified by 'lion';
-- 이번엔 로컬 접속용으로 localhoset를 이용
create user 'like'@'localhost' identified by 'lion';
-- 사용자가 생성이 되었다고 해서, 어떤 일을 할 수 있는건 아니고
-- 권한이 필요한다고 한다
-- grant는 권한 명령 ALL privilges는 모든 사람? on는 어떤 DB를 대상으로
-- exampledb는 대상으로 지정할 db, *는 모든 권한을, like는 권한을 받을 대상 
grant ALL privileges on exampledb.* to 'like'@'%';
-- 요건 localhost 를 대사
grant ALL privileges on exampledb.* to 'like'@'localhost';

-- db 생성
create database hr;

grant ALL privileges on hr.* to 'like'@'%';
grant ALL privileges on hr.* to 'like'@'localhost';
-- 얘는 즉시 적용
flush privileges;

-- 유저 생성
create user 'back'@'%' identified by 'end';
create user 'back'@'localhost' identified by 'end';
-- db 생성
create database scott;
-- db 권한 주기
grant ALL privileges on scott.* to 'back'@'%';
grant ALL privileges on scott.* to 'back'@'localhost';

grant ALL privileges on hr.* to 'back'@'%';
grant ALL privileges on hr.* to 'back'@'localhost';

show databases;

drop database hr;
show databases;
create database hr;

-- 즉시 적용
flush privileges;
set GLOBAL time_zone = 'Asia/Seoul'; -- 시간 잘 맞추기

