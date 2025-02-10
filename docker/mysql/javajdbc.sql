create database springdb;
create database praticedb;

-- 유저 만들기
create user 'giga'@'%'identified by 'chad';
create user 'giga'@'localhost'identified by 'chad';

-- 권한 부여하기, * 는 모든 권한
grant all privileges on springdb.* to 'giga'@'%';
grant all privileges on springdb.* to 'giga'@'localhost';
grant all privileges on praticedb.* to 'giga'@'%';
grant all privileges on praticedb.* to 'giga'@'localhost';
-- 권한 적용
flush privileges;