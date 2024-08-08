delimiter //
create procedure dorepeat(p1 int)
	begin
		set @x = 0;
        repeat set @x = @x + 1; until @x > p1 end repeat;
	end //
call dorepeat(1000);
select @x;


use madangdb;
delimiter //
create procedure InsertBook(
	In mybookid integer,
    In mybookname varchar(40),
    In mypublisher varchar(40),
    In myprice integer)
begin
	insert into Book(bookid, bookname, publisher, price)
		values(mybookid, mybookname, mypublisher, myprice);
end; 
//
delimiter ;
call InsertBook(13, '스포츠과학', '마당과학서적', 25000);


use madangdb;
delimiter //
create procedure BookInsertOrUpdate(
	mybookid integer,
    mybookname varchar(40),
    mypublisher varchar(40),
    myprice int)
begin
	declare mycount integer;
    select count(*) into mycount from book
		where bookname like mybookname;
	if mycount != 0 then
		set SQL_SAFE_UPDATES = 0; /* DELETE, UPDATE 연산에 필요한 설정문 */
        update book set price = myprice
        where bookname like mybookname;
	else
		insert into book(bookid, bookname, publisher, price)
			values(mybookid, mybookname, mypublisher, myprice);
	end if;
end;
//
delimiter ;


call BookInsertOrUpdate(15, '스포츠 즐거움', '마당과학서적', 25000);
select * from book;
call BookInsertOrUpdate(15, '스포츠 즐거움', '마당과학서적', 20000);
select * from book;


delimiter //
create procedure Averageprice(
	out AverageVal integer)
begin
	select AVG(price) into AverageVal
    from book where price is not null;
end;
//
delimiter ;


call Averageprice(@y);
select @y;

set global log_bin_trust_function_creators=ON;

create table Book_log(
	bookid_l integer,
    bookname_l varchar(40),
    publisher_l varchar(40),
    price_l integer);
    
    
delimiter //
create trigger AfterInserBook
	after insert on Book for each row
begin
	declare average integer;
    insert into book_log
    values(new.bookid, new.bookname, new.publisher, new.price);
end;
//
delimiter ;

insert into book values(14, '스포츠 과학 1', '이상미디어', 25000);
select * from book where bookid=14;
