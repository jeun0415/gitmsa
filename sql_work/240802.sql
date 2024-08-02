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

-- 두 개 이상의 서로 다른 출판사에서 도서를 구매한 고객의 이름???
select distinct name
from customer C, book B, orders O
where C.custid = O.custid and B.bookid = O.bookid
	and not B.publisher in (select publisher from book, orders, customer
    where customer.custid = orders.custid and book.bookid = orders.bookid);

-- 전체 고객의 30% 이상이 구매한 도서???
select book.bookname
from customer, book, orders
where customer.custid = orders.custid and book.bookid = orders.bookid
	and (count(orders.bookid) >= (sum(customer.custid)*0.3));
    
    
select abs(-78), abs(+78);

select round(4.875, 1);

-- 고객별 평균 주문 금액을 100원 단위로 반올림한 값을 구하세요.
select custid, round(avg(saleprice), -2)
from orders
group by custid;

select round(avg(saleprice)/100)*100
from orders
group by custid;

select concat('마당','서점');

select lower('MR.SCOTT');

select upper('mr.scott');

select lpad('page 1', 10, "*");

select replace('jack & jue', 'j', 'bl');

select substr('ABCDEFG', 3, 4);

select trim('=' from "=a=b=c d e=");

-- 도서 제목에 야구가 포함된 도서를 농구로 변경한 후 도서 목록을 나타내세요
select replace(bookname,'야구','농구')
from book;

-- 굿스포츠에서 출판한 도서의 제목과 제목의 문자 수 바이트 수를 출력하세요
select bookname, length(bookname) as '바이트 수', char_length(bookname) as '문자 수'
from book
order by bookname;

-- 마당 서점의 고객 중에서 성이 같은 사람이 몇명인지 성별 인원수 구하기
select substr(name, 1, 1) as '성', count(*) as '인원'
from customer
group by substr(name, 1, 1);

select substr(name, 1, 1) as '성', count(*) as '인원'
from customer
group by 성;

select adddate('2024-07-01', interval -5 day) before5,
	adddate('2024-07-01', interval +5 day) after5;
    
    
-- 마당서점은 주문일로부터 10일 후에 매출을 확정한다. 각 주문의 확정일자를 구하시오
select orderid, adddate(orderdate, interval +10 day) as '확정일자'
from orders;


-- 2024년 7월 4일 주문받은 도서를 모두 나타내시오
-- 단, 주문일은 240704, Jul 04 2024, 24-07-04 목요일 형태로???
select orderid as '주문번호',
	str_to_date('240704', '%y%m%d') as '주문날짜',
    str_to_date('20240704', '%M%d%Y') as '주문날짜',
    str_to_date('202407045', '%y%m%d%w') as '주문날짜',
    custid as '고객ID',
    bookid as '도서ID'
from orders
where orderdate = '2024-07-04';


create view Vorders
as select orderid, O.custid, name, O.bookid, bookname, saleprice, orderdate
from Customer C, Orders O, Book B
where C.custid = O.custid and B.bookid = O.bookid;

select * from vorders;


-- 대한민국에 거주하는 고객들로 구성된 뷰를 만들고 조회하세요
-- 뷰 이름은 vw_Customer???
create view vw_Customer
as select *
from Customer
where address like '대한민국%';

select * from vw_Customer;


-- Orders 테이블에서 고객명과 도서명을 확인할 수 있는 뷰를 생성한 후,
-- 김연아 고객이 구입한 도서의 주문번호, 도서명, 주문액을 출력하세요
create view vw_Ord
as select name, bookname, O.*
from customer C, orders O, book B
where C.custid = O.custid and B.bookid = O.bookid;

select * from vw_ord;

select name, orderid, bookname, saleprice
from vw_Ord
where name = '김연아';


select count(phone)
from customer;

create table Mybook(
bookid integer not null primary key,
price integer
);
INSERT INTO Mybook VALUES(1, 10000);
INSERT INTO Mybook VALUES(2, 20000);
INSERT INTO Mybook (bookid) VALUES(3);
alter table mybook add primary key (bookid);
drop table mybook;
select * from mybook;

select price + 100
from mybook
where bookid = 3;

select sum(price), avg(price), count(*), count(price)
from mybook;

select sum(price), avg(price), count(*), count(price)
from mybook
where bookid >= 4;

select *
from mybook
where price is null;

select *
from mybook
where price = ' ';

select name '이름', ifnull(phone, '연락처 없음') '전화번호'
from customer;

select bookid, ifnull(price, '가격 미입력') '가격'
from mybook;

set @seq:=0;
select (@seq:=@seq+1) '순번', custid, name, phone
from customer
where @seq < 2;

select sum(saleprice)
from orders
where custid = (select custid from customer where name = '박지성');

-- 평균 주문금액 이하의 주문에 대해서 주문번호와 금액을 나타내시오
select orderid, saleprice
from orders
where saleprice <= (select avg(saleprice)
					from orders);

-- 각 고객의 평균 주문금액보다 큰 금액의 주문 내역에 대해서 주문번호, 고객번호, 금액을 나타내시오
select orderid, custid, saleprice
from orders od1
where saleprice > (select avg(saleprice)
					from orders od2
                    where od1.custid = od2.custid);
                    
-- 3번 고객이 주문한 도서의 최고 금액보다 더 비싼 도서를 구입한 주문의 주문번호와 판매금액 보이시오
select orderid, saleprice
from orders
where saleprice > all(select saleprice
						from orders
						where custid = 3);
                        
-- 대한민국에 거주하는 고객에게 판매한 도서의 총판매액
select sum(saleprice) 'total'
from orders od
where exists(select * from customer cs where address like '%대한민국%' and
			cs.custid = od.custid);
            
-- 마당서점의 고객별 판매액
select (select name from customer cs where cs.custid = od.custid) 'name',
		sum(saleprice) 'total'
from orders od
group by od.custid;

-- 고객번호가 2 이하인 고객의 판매액(고객이름과 고객별 판매액 출력)
select cs.name, sum(od.saleprice) 'total'
from (select custid, name from customer where custid <=2) cs, orders od
where cs.custid = od.custid
group by cs.name;

-- book 테이블의 bookname 열을 대상으로 인덱스 ix_Book을 생성
create index ix_Book on book(bookname);

-- book 테이블의 publisher, price 열을 대상으로 인덱스 ix_Book2을 생성
create index ix_Book2 on book(publisher, price);