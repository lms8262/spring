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

insert into airplane values (1, '�����װ�', '2023-06-23 07:00', '2023-06-23 09:00', '��õ', '����', 180, 180, 200000);
insert into airplane values (2, '��ġ�װ�', '2023-06-24 06:30', '2023-06-24 09:00', '��õ', '����', 200, 200, 120000);

select * from airplane;

create table reservation (
    reservation_no number primary key,
    airplane_no number not null,
    user_name varchar2(100) not null,
    user_email varchar2(100) not null,
    user_phone varchar2(100) not null,
    reservation_date date not null,
    CONSTRAINT reservation_fk FOREIGN KEY(airplane_no) REFERENCES airplane(airplane_no) on delete cascade
);

insert into reservation values (1, 1, 'ȫ�浿', 'hong123@naver.com', '010-1234-5678', '2023-06-20 18:30');
insert into reservation values (2, 1, '�Ѹ�', 'hoi456@naver.com', '010-2345-6789', '2023-06-21 07:00');
insert into reservation values (3, 2, '��ġ', 'ddochi234@naver.com', '010-3456-7890', '2023-06-20 20:00');
insert into reservation values (4, 2, '������', 'col345@naver.com', '010-4567-8901', '2023-06-21 09:30');

select * from reservation;

-- db���� �����ö� ������ ���(����ȭ�� inputâ�� ������)
select to_char(sysdate, 'YYYY-MM-DD')||'T'||to_char(sysdate, 'HH:MI:SS') departrue_date from dual;

-- ���̺� insert�Ҷ� ���� ���
select to_date(replace('2023-06-22T01:57','T',''), 'YYYY-MM-DDHH:MI:SS') from dual;

select replace('2023-06-22T01:57','T','') from dual;



