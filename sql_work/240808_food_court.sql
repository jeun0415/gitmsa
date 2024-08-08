create database food_court;

use food_court;

create table restaurant(
	r_id integer auto_increment not null primary key,
    r_name varchar(30)
);

create table menu(
	m_id integer auto_increment not null primary key,
    m_name varchar(40) not null,
    r_id integer,
    m_price varchar(30),
    foreign key(r_id) references restaurant(r_id)
);

create table orders(
	o_id integer auto_increment not null primary key,
    r_id integer,
    m_id integer,
    foreign key(r_id) references restaurant(r_id),
    foreign key(m_id) references menu(m_id)
);


-- 푸드코드 ERD 요구사항

create table corner(
	corner_id varchar(6) primary key,
    corner_name varchar(20) not null
);

create table menu(
	menu_id varchar(6) primary key,
    menu_name varchar(20) not null,
    price integer not null,
    corner_id varchar(6),
    foreign key (corner_id) references corner(corner_id)
);

create table orders(
	order_id varchar(6) not null,
    menu_id varchar(6) not null,
    cnt integer not null,
    order_date datetime not null,
    status char(1) null,	-- 접수중, 픽업대기, 픽업완료 --
    foreign key (menu_id) references menu(menu_id),
    saleprice integer,
    primary key(order_id, menu_id, order_date)
);