create table airplane (
    airplane_no number primary key,
    airplane_name varchar2(100) not null,
    departrue_date date not null,
    arrival_date date not null,
    departrue varchar2(100) not null,
    arrival varchar2(100) not null,
    left_seat number not null,
    total_seat number not null,
    price number not null
);

create table reservation (
    reservation_no number primary key,
    airplane_no number not null,
    user_name varchar2(100) not null,
    user_email varchar2(100) not null,
    user_phone varchar2(100) not null,
    reservation_date date not null,
    CONSTRAINT reservation_fk FOREIGN KEY(airplane_no) REFERENCES airplane(airplane_no) on delete cascade
);

-- db에서 꺼내올때 가져올 방식(수정화면 input창에 넣을때)
select to_char(sysdate, 'YYYY-MM-DD')||'T'||to_char(sysdate, 'HH:MI:SS') departrue_date from dual;

-- 테이블에 insert할때 넣을 방식
select to_date('2023-06-22오전01:57', 'YYYY-MM-DDPMHH:MI:SS') from dual;

