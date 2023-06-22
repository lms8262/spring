drop table reservation;
drop table airplane;

create table airplane (
    airplane_no number primary key,
    airplane_name varchar2(100),
    departrue_date date,
    arrival_date date,
    departrue varchar2(100),
    arrival varchar2(100),
    left_seat number,
    total_seat number,
    price number
);

insert into airplane values (1, '�����װ�', '2023-06-23 07:00', '2023-06-23 09:00', '��õ', '����', 180, 180, 200000);
insert into airplane values (2, '��ġ�װ�', '2023-06-24 06:30', '2023-06-24 09:00', '��õ', '����', 200, 200, 120000);
insert into airplane values (3, '��ġ�װ�', '2023-06-22 10:30', '2023-06-22 17:00', '��õ', '�Ͽ���', 180, 180, 230000);
insert into airplane values (4, '��ġ�װ�', '2023-06-21 07:30', '2023-06-21 15:00', '��õ', '����', 190, 190, 200000);
insert into airplane values (5, '�����װ�', '2023-06-24 15:30', '2023-06-24 22:00', '��õ', '����', 160, 160, 250000);
insert into airplane values (6, '�����װ�', '2023-06-24 06:30', '2023-06-24 12:00', '��õ', '�Ͽ���', 150, 150, 280000);

select * from airplane;

create table reservation (
    reservation_no number primary key,
    airplane_no number not null,
    user_name varchar2(100),
    user_email varchar2(100),
    user_phone varchar2(100),
    reservation_date date,
    CONSTRAINT reservation_fk FOREIGN KEY(airplane_no) REFERENCES airplane(airplane_no) on delete cascade
);

insert into reservation values (1, 1, 'ȫ�浿', 'hong123@naver.com', '010-1234-5678', '2023-06-20 18:30');
insert into reservation values (2, 1, '�Ѹ�', 'hoi456@naver.com', '010-2345-6789', '2023-06-21 07:00');
insert into reservation values (3, 2, '��ġ', 'ddochi234@naver.com', '010-3456-7890', '2023-06-20 20:00');
insert into reservation values (4, 2, '������', 'col345@naver.com', '010-4567-8901', '2023-06-21 09:30');

select * from reservation;

-- airplane ���̺� ���� ū ��ȣ(insert�� ���)
select nvl(max(airplane_no), 0) from airplane;

-- airplane ���̺� ������ ����
select nvl(count(*), 0) from airplane where airplane_name like '%�װ�%';

-- airplane ���̺� ����Ʈ ��������
select * from(
    select rownum rnum, data.* from(
        select airplane_no, airplane_name, departrue, arrival, price
        from airplane
        where airplane_name like '%�װ�%'
    order by airplane_no desc) data
) where rnum >= 1 and rnum <= 2;

-- airplane ���̺� insert
insert into airplane values(#{airplane_no}, #{airplane_name}, to_date(replace(#{departrue_date}, 'T', ''), 'YYYY-MM-DDHH24:MI:SS'), to_date(replace(#{arrival_date}, 'T', ''), 'YYYY-MM-DDHH24:MI:SS'), #{departrue}, #{arrival}, #{total_seat}, #{total_seat}, #{price});

-- db���� �����ö� ������ ���(����ȭ�� inputâ�� ������)
select (to_char(sysdate, 'YYYY-MM-DD')||'T'||to_char(sysdate, 'HH:MI:SS')) departrue_date from airplane where airplane_no = 1;

-- ���̺� insert�Ҷ� ���� ���
select to_date(replace('2023-06-22T01:57', 'T', ''), 'YYYY-MM-DDHH:MI:SS') from dual;
to_date(replace(#{departrue_date}, 'T', ''), 'YYYY-MM-DDHH:MI:SS')
to_date(replace(#{arrival_date}, 'T', ''), 'YYYY-MM-DDHH:MI:SS')

select replace('2023-06-22T01:57','T','') from dual;

commit;



