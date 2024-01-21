
# 1. 저자 별 카테고리 별 매출액 집계하기
SELECT b.AUTHOR_ID, a.AUTHOR_NAME, b.CATEGORY, sum(s.SALES * b.PRICE) as TOTAL_SALES
from BOOK b
inner join AUTHOR a on
    b.AUTHOR_ID = a.AUTHOR_ID
inner join BOOK_SALES s on
    b.BOOK_ID = s.BOOK_ID
where s.SALES_DATE between '2022-01-01' and '2022-01-31'
group by b.AUTHOR_ID, b.CATEGORY
order by a.AUTHOR_ID, b.CATEGORY desc

# 2. 카테고리별 도서 판매량 집계하기
SELECT b.CATEGORY, sum(bs.SALES)
from BOOK b
inner join BOOK_SALES bs on
    b.BOOK_ID = bs.BOOK_ID
where bs.SALES_DATE between '2022-01-01' and '2022-01-31'
group by b.CATEGORY
order by b.CATEGORY

# 3. 자동차 대여 기록에서 대여중 / 대여 가능 여부 구분하기
 SELECT c.CAR_ID, ifnull(r.AVAILABILTY,'대여 가능') as AVAILABILITY
 from (
    select cc.HISTORY_ID, cc.CAR_ID, '대여중' as AVAILABILTY
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY cc
    where cc.START_DATE <= '2022-10-16' and '2022-10-16' <= cc.END_DATE
 ) r
 right outer join  CAR_RENTAL_COMPANY_RENTAL_HISTORY c on 
    r.CAR_ID = c.CAR_ID
group by c.CAR_ID
order by c.CAR_ID desc

# 4. 진료과별 총 예약 횟수 출력하기
SELECT a.MCDP_CD as '진료과코드', count(a.APNT_NO) as '5월예약건수'
from appointment a
where a.APNT_YMD like "2022-05-%"
group by a.MCDP_CD
order by 2, 1

# 5. 자동차 종류 별 특정 옵션이 포함된 자동차 수 구하기
SELECT c.CAR_TYPE ,count(c.CAR_ID) as CARS
from CAR_RENTAL_COMPANY_CAR c
where c.OPTIONS like '%시트%'
group by c.CAR_TYPE
order by c.CAR_TYPE
