create database estate;

use estate;

-- 단독 소유 --
create table owner(
o_sn varchar(20) not null primary key,
o_name varchar(30) not null,
o_phone varchar(20) not null
);

create table ground(
g_id integer auto_increment not null primary key,
g_address varchar(100) not null,
g_price varchar(20) null,
o_sn varchar(20) not null primary key,
foreign key(o_sn) references owner(o_sn)
);


-- 공동 소유 --
create table owner(
o_sn varchar(20) not null primary key,
o_name varchar(30) not null,
o_phone varchar(20) not null
);

create table ground(
g_id integer auto_increment not null primary key,
g_address varchar(100) not null,
g_price varchar(20) null
);

create table hold(
g_id integer not null,
o_sn varchar(20) not null,
primary key(g_id, o_sn),
foreign key(g_id) references ground(g_id),
foreign key(o_sn) references owner(o_sn)
);