create database madangdb;

USE madangdb;

CREATE TABLE Book(
bookid INTEGER PRIMARY KEY,
bookname VARCHAR(40),
publisher VARCHAR(40),
price INTEGER
);

CREATE TABLE Customer(
custid INTEGER PRIMARY KEY,
name VARCHAR(40),
address VARCHAR(50),
phone VARCHAR(20)
);

CREATE TABLE Orders(
orderid INTEGER PRIMARY KEY,
custid INTEGER,
bookid INTEGER,
saleprice INTEGER,
orderdate DATE,
FOREIGN KEY (custid) REFERENCES Customer(custid),
FOREIGN KEY (bookid) REFERENCES Book(bookid)
);

INSERT INTO Book VALUES(1, '축구의 역사', '굿스포츠', 7000);
INSERT INTO Book VALUES(2, '축구 아는 여자', '나무수', 13000);
INSERT INTO Book VALUES(3, '축구의 이해', '대한미디어', 22000);
INSERT INTO Book VALUES(4, '골프 바이블', '대한미디어', 35000);
INSERT INTO Book VALUES(5, '피겨 교본', '굿스포츠', 8000);
INSERT INTO Book VALUES(6, '배구 단계별기술', '굿스포츠', 6000);
INSERT INTO Book VALUES(7, '야구의 추억', '이상미디어', 20000);
INSERT INTO Book VALUES(8, '야구를 부탁해', '이상미디어', 13000);
INSERT INTO Book VALUES(9, '올림픽 이야기', '삼성당', 7500);
INSERT INTO Book VALUES(10, 'Olympic Champions', 'Pearson', 13000);

INSERT INTO Customer VALUES(1, '박지성', '영국 맨체스타', '000-5000-0001');
INSERT INTO Customer VALUES(2, '김연아', '대한민국 서울', '000-6000-0001');
INSERT INTO Customer VALUES(3, '김연경', '대한민국 경기도', '000-7000-0001');
INSERT INTO Customer VALUES(4, '추신수', '미국 클리블랜드', '000-8000-0001');
INSERT INTO Customer VALUES(5, '박세리', '대한민국 대전', NULL);

INSERT INTO Orders VALUES (1, 1, 1, 6000, STR_TO_DATE('2024-07-01','%Y-%m-%d'));
INSERT INTO Orders VALUES (2, 1, 3, 21000, STR_TO_DATE('2024-07-03','%Y-%m-%d'));
INSERT INTO Orders VALUES (3, 2, 5, 8000, STR_TO_DATE('2024-07-03','%Y-%m-%d'));
INSERT INTO Orders VALUES (4, 3, 6, 6000, STR_TO_DATE('2024-07-04','%Y-%m-%d'));
INSERT INTO Orders VALUES (5, 4, 7, 20000, STR_TO_DATE('2024-07-05','%Y-%m-%d'));
INSERT INTO Orders VALUES (6, 1, 2, 12000, STR_TO_DATE('2024-07-07','%Y-%m-%d'));
INSERT INTO Orders VALUES (7, 4, 8, 13000, STR_TO_DATE( '2024-07-07','%Y-%m-%d'));
INSERT INTO Orders VALUES (8, 3, 10, 12000, STR_TO_DATE('2024-07-08','%Y-%m-%d'));
INSERT INTO Orders VALUES (9, 2, 10, 7000, STR_TO_DATE('2024-07-09','%Y-%m-%d'));
INSERT INTO Orders VALUES (10, 3, 8, 13000, STR_TO_DATE('2024-07-10','%Y-%m-%d'));

-- 전체 칼럼 보기
select * from book;
SELECT * FROM Orders;
select * from Customer;

-- 원하는 칼럼 보기
select bookname, publisher from book;
select name, address from Customer;

select publisher, bookname
from Book
where bookname like '%축구%';

select name, phone
from customer
where name like '김연아';

select bookname, publisher
from book
where price >= 10000;

select bookname, publisher
from book
where price >= 10000 and price <= 20000;

select distinct publisher
from book;

select name
from customer
where phone is null;

select *
from book
where (publisher = '굿스포츠') and (price between 10000 and 19999);

select *
from book
where publisher in ('굿스포츠', '대한미디어');

select *
from book
where publisher not in ('굿스포츠', '대한미디어');

select *
from book
where bookname like '_구%';

update book
set bookname='그 여자의 축구'
where bookid=2;

delete from book
where bookid=2;

select *
from book
order by bookname desc;

select *
from book
order by price;

select *
from book
order by price desc, bookname;

select sum(saleprice)
from orders;

select avg(saleprice)
from orders;

select count(saleprice)
from orders;

select max(saleprice)
from orders;

select min(saleprice)
from orders;

select price as '판매가격' from book;

select 
sum(saleprice) as Total,
avg(saleprice) as Average,
min(saleprice) as Minimum,
max(saleprice) as Maximum
from orders;

select count(*)
from orders;

select custid, count(*) as '총수량' , sum(saleprice) as '총판매액'
from orders
group by custid;

select custid, count(*) as '8000원 이상 도서 구매 총수량'
from orders
where saleprice >= 8000
group by custid
having count(*) >= 2;

select *
from customer, orders;

select *
from customer, orders
where customer.custid = orders.custid
order by orders.orderdate;

select name, sum(saleprice)
from customer, orders
where customer.custid = orders.custid
group by customer.name
order by customer.name;

select name, count(*) as '8000원 이상 도서 구매 총수량'
from customer, orders
where (saleprice >= 8000) and (customer.custid = orders.custid)
group by customer.custid
having count(*) >= 2
order by customer.name;

select customer.name, book.bookname
from book, customer, orders
where (customer.custid = orders.custid) and (book.bookid = orders.bookid) 
		and (orders.saleprice >= 20000)
order by book.bookname;


-- 1
select bookname
from book
where bookid = 1;

-- 2
select bookname
from book
where price >= 20000;

-- 3
select name, sum(saleprice)
from orders, customer
where customer.custid = orders.custid and customer.name = '박지성';

-- 4
select name, count(saleprice)
from customer, orders
where customer.custid = orders.custid and customer.name = '박지성';

-- 5
select name, count(distinct publisher)
from customer, book, orders
where customer.custid = orders.custid and book.bookid = orders.bookid 
and customer.name = '박지성';

-- 6
select book.bookname, book.price-orders.saleprice as '정가와 판매가 차이'
from customer, book, orders
where customer.custid = orders.custid and book.bookid = orders.bookid 
and customer.name = '박지성';

-- 7
select book.bookname
from customer, book, orders
where customer.custid = orders.custid and book.bookid = orders.bookid 
and customer.name != '박지성';
-- and customer.name <> '박지성';
-- and customer.name not in ('박지성');

-- 8
select count(*)
from book;

-- 9
select count(distinct publisher)
from book;

-- 10
select name, address
from customer;

-- 11
select *
from orders, book
where (orderdate between '2024-07-04' and '2024-07-07') 
		and (orders.bookid = book.bookid);

-- 12
select name, address
from customer
where name like '김%';

-- 13
select name, address
from customer
where name like '김_아';
-- where name like '김%' and name like '%아';

-- 14
select sum(saleprice), avg(saleprice)
from orders;

-- 15
select customer.name, sum(orders.saleprice)
from orders, customer
where orders.custid = customer.custid
group by orders.custid;

-- 16
select customer.name, orders.*, bookname
from customer, orders, book
where customer.custid = orders.custid and book.bookid = orders.bookid;

-- 서브쿼리
-- 가장 비싼 도서의 이름
select bookname
from book
where price = (select max(price) from book);

-- 도서를 구매한 이력이 있는 고객명
select name
from customer
where custid in (select distinct custid from orders);

-- 대한미디어에서 출판한 도서를 구매한 고객의 이름을 출력하세요.
select name
from customer
where custid in (select distinct custid from orders 
		where bookid in (select bookid from book where publisher = '대한미디어'));
        
select customer.name
from customer, book, orders
where customer.custid = orders.custid and book.bookid = orders.bookid
	and book.publisher = '대한미디어';

-- 대한민국에 거주하는 고객리스트 출력
select name
from customer
where address like '대한민국%';

-- 도서를 주문한 고객리스트 출력 (서브쿼리 사용)
select name
from customer
where custid in (select custid from orders);

-- 대한민국에 거주하는 고객의 이름과 도서를 주문한 고객의 이름을 출력
select name
from customer
where address like '대한민국%'
union all
-- union
select address
from customer
where custid in (select custid from orders);

-- 하나라도 걸리면 다 가져와라
select name, address
from customer cs
where exists (select * from orders od where cs.custid = od.custid);

create table NewBook(
bookid integer primary key,
bookname varchar(20),
publisher varchar(20),
price integer
);

create table NewCustomer(
custid integer primary key,
name varchar(40),
address varchar(40),
phone varchar(30)
);

create table NewOrders(
orderid integer primary key,
custid integer not null,
bookid integer not null,
saleprice integer,
orderdate date,
FOREIGN KEY (custid) REFERENCES NewCustomer(custid) on delete cascade
);


describe newbook;

alter table NewBook add isbn varchar(13);

alter table newbook modify isbn integer;

alter table newbook drop isbn;

alter table newbook modify bookname varchar(20) not null;

-- 이미 primary key 있어서 안됨
alter table newbook add primary key (bookname, publisher);

drop table newbook;

-- 항목의 이름을 일일이 지정해주는 것이 명확하고 좋음
insert into book(bookid, bookname, publisher, price) 
values (11, '스포츠 의학', '한솔의학서적', 90000);

-- 박지성이 구매한 도서의 출판사와 같은 출판사에서 도서를 구매한 고객의 이름
select distinct name
from customer C, book B, orders O
where C.custid = O.custid and B.bookid = O.bookid
	and B.publisher in (select publisher from book, orders, customer
    where customer.custid = orders.custid and book.bookid = orders.bookid
    and name = '박지성');

select name, bookname, publisher
from customer, book, orders
where customer.custid = orders.custid and book.bookid = orders.bookid
order by name;

-- 두 개 이상의 서로 다른 출판사에서 도서를 구매한 고객의 이름
select customer.name
from customer, book, orders
where customer.custid = orders.custid and book.bookid = orders.bookid
	and book.publisher not in (book.publisher)
group by orders.custid
having count(orders.custid) >= 2;

-- 전체 고객의 30% 이상이 구매한 도서
select book.bookname
from customer, book, orders
where customer.custid = orders.custid and book.bookid = orders.bookid
	and (count(orders.bookid) >= (sum(customer.custid)*0.3));