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

insert into airplane values (1, '대한항공', '2023-06-23 07:00', '2023-06-23 09:00', '인천', '도쿄', 180, 180, 200000);
insert into airplane values (2, '피치항공', '2023-06-24 06:30', '2023-06-24 09:00', '인천', '도쿄', 200, 200, 120000);
insert into airplane values (3, '피치항공', '2023-06-22 10:30', '2023-06-22 17:00', '인천', '하와이', 180, 180, 230000);
insert into airplane values (4, '피치항공', '2023-06-21 07:30', '2023-06-21 15:00', '인천', '런던', 190, 190, 200000);
insert into airplane values (5, '대한항공', '2023-06-24 15:30', '2023-06-24 22:00', '인천', '런던', 160, 160, 250000);
insert into airplane values (6, '대한항공', '2023-06-24 06:30', '2023-06-24 12:00', '인천', '하와이', 150, 150, 280000);

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

insert into reservation values (1, 1, '홍길동', 'hong123@naver.com', '010-1234-5678', '2023-06-20 18:30');
insert into reservation values (2, 1, '둘리', 'hoi456@naver.com', '010-2345-6789', '2023-06-21 07:00');
insert into reservation values (3, 2, '또치', 'ddochi234@naver.com', '010-3456-7890', '2023-06-20 20:00');
insert into reservation values (4, 2, '마이콜', 'col345@naver.com', '010-4567-8901', '2023-06-21 09:30');

select * from reservation;

-- airplane 테이블 제일 큰 번호(insert시 사용)
select nvl(max(airplane_no), 0) from airplane;

-- airplane 테이블 데이터 개수
select nvl(count(*), 0) from airplane where airplane_name like '%항공%';

-- airplane 테이블 리스트 가져오기
select * from(
    select rownum rnum, data.* from(
        select airplane_no, airplane_name, departrue, arrival, price
        from airplane
        where airplane_name like '%항공%'
    order by airplane_no desc) data
) where rnum >= 1 and rnum <= 2;

-- airplane 테이블 insert
insert into airplane values(#{airplane_no}, #{airplane_name}, to_date(replace(#{departrue_date}, 'T', ''), 'YYYY-MM-DDHH24:MI:SS'), to_date(replace(#{arrival_date}, 'T', ''), 'YYYY-MM-DDHH24:MI:SS'), #{departrue}, #{arrival}, #{total_seat}, #{total_seat}, #{price});

-- db에서 꺼내올때 가져올 방식(수정화면 input창에 넣을때)
select (to_char(sysdate, 'YYYY-MM-DD')||'T'||to_char(sysdate, 'HH:MI:SS')) departrue_date from airplane where airplane_no = 1;

-- 테이블에 insert할때 넣을 방식
select to_date(replace('2023-06-22T01:57', 'T', ''), 'YYYY-MM-DDHH:MI:SS') from dual;
to_date(replace(#{departrue_date}, 'T', ''), 'YYYY-MM-DDHH:MI:SS')
to_date(replace(#{arrival_date}, 'T', ''), 'YYYY-MM-DDHH:MI:SS')

select replace('2023-06-22T01:57','T','') from dual;

commit;



