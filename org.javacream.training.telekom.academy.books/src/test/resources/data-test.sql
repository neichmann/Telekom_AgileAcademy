drop table KEYS if exists
drop table STORE if exists
drop table AUDIT if exists


create table KEYS (COL_KEY Integer)
create table AUDIT (message varchar(256))
create table STORE (category varchar(256), item_id varchar(256), stock Integer, primary key (category, item_id))


insert into BOOK (isbn, title, price) values ('TEST-ISBN', 'TEST-TITLE', 19.99)
insert into BOOK (isbn, title, price) values ('TEST-ISBN2', 'TEST-TITLE', 19.99)
insert into BOOK (isbn, title, price) values ('ISBN1', 'Spring', 9.99)
insert into BOOK (isbn, title, price) values ('ISBN2', 'Spring', 19.99)
insert into BOOK (isbn, title, price) values ('ISBN3', 'Spring', 29.99)

insert into STORE (category, item_id, stock) values ('BOOKS', 'ISBN1', 10)
insert into STORE (category, item_id, stock) values ('BOOKS', 'ISBN2', 5)
insert into STORE (category, item_id, stock) values ('BOOKS', 'ISBN3', 40)

insert into STORE (category, item_id, stock) values ('TEST_CATEGORY', 'TEST_ID', 42)

insert into KEYS values (42)
