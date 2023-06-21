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


