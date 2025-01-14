create database madanguniv;

use madanguniv;

create table professor(
p_ssn integer auto_increment primary key,
p_name varchar(30) not null,
p_age integer null,
p_rank char(3) null,
p_speciality varchar(100) null
);

create table department(
dno integer auto_increment primary key,
dname varchar(30) not null,
office char(2) null,
run integer not null, -- run 학과장 --
foreign key(run) references professor(p_ssn)
);

create table graduate(		-- X
g_ssn integer auto_increment primary key,
g_name varchar(30) not null,
g_age integer null,
g_deg_prog char(1) not null,
g_major integer not null, -- major 전공학과 --
g_advisor integer null, -- 선임 대학원생 --
foreign key(advisor) references graduate(g_ssn),
foreign key(major) references department(dno)
);

create table project(
pid integer auto_increment primary key,
sponsor varchar(50) null,
start_date date not null,
end_date date not null,
budget varchar(100) not null

);

create table work_dept(
dno integer not null,
p_ssn integer not null,
pct_time integer not null,
primary key(dno, p_ssn),
foreign key(dno) references department(dno),
foreign key(p_ssn) references professor(p_ssn)
);

create table work_in(
pid integer not null,
p_ssn integer not null,
workrole char(1) not null,
primary key(pid, p_ssn),
foreign key(pid) references project(pid),
foreign key(p_ssn) references professor(p_ssn)
);

create table work_prog(		-- X
pid integer not null,
g_ssn integer not null,
primary key(pid, g_ssn),
foreign key(pid) references project(pid),
foreign key(g_ssn) references graduate(g_ssn)
);

-- 1) 프로젝트 테이블에 매니저 칼럼을 만들고, 교수테이블 참고 / work in 테이블에 프로젝트 아이디,
-- 교수 아이디를 참조하는 칼럼 두개인 테이블을 만들면 됨, 그러면 work in 테이블은
-- 무조건 공동연구책임자만 들어가는 테이블이 된다

-- 2) 프로젝트 테이블에 매니저 칼럼 만들 필요 없이, work in 이라는 테이블에 프로젝트 아이디, 
-- 교수 아이디를 참조해오고, 교수의 롤(매니저인지 공동연구책임자인지 구분해주는) 