show databases;

use mysql;

show tables;

desc user;

select * from user;

create user ppm@localhost identified by '00001111';

create user ppmguest@localhost identified by '1234';

drop user ppmguest@localhost;

create user pmmguest2 identified by '1234';

-- DB는 정해줘야 함 --
grant all privileges on madanguniv.* to ppm@localhost;

-- 권한을 사용할 수 있음 --
flush privileges;

-- 권한 확인 --
show grants for ppm@localhost;

grant select on madangdb.book to ppm@localhost;
flush privileges;
select * from user;

