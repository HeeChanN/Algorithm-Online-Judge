
# 1. 모의고사 1
SELECT n.ID, n.CREATOR,n.LIKES
from NEW_POSTS n

union

select o.ID, o.CREATOR,0
from OLD_POSTS o

order by 1 desc


# 2. 모의고사 2
SELECT m.ALGORITHM_TYPE
from PROBLEMS m
group by m.ALGORITHM_TYPE
order by count(m.ID) desc, m.ALGORITHM_TYPE
limit 1

# 3. 조건에 부합하는 중고거래 상태 조회하기
SELECT B.BOARD_ID, B.WRITER_ID, B.TITLE, B.PRICE, 
CASE WHEN B.STATUS ='SALE' then '판매중'
     when b.STATUS = 'RESERVED' then '예약중'
     when b.STATUS = 'DONE' then '거래완료'
     END AS STATUS
from USED_GOODS_BOARD B
where B.CREATED_DATE = '2022-10-05'
order by 1 desc;


# 4. 자동차 평균 대여 기간 구하기
SELECT h.CAR_ID, round(avg(DATEDIFF(h.END_DATE,h.START_DATE)+1),1) as AVERAGE_DURATION
from CAR_RENTAL_COMPANY_RENTAL_HISTORY h
group by h.CAR_ID
having AVERAGE_DURATION >=7
order by 2 desc, 1 desc

# 5. 카테고리 별 상품 개수 구하기
SELECT substr(p.PRODUCT_CODE,1,2) AS CATEGORY, count(p.PRODUCT_ID)
from PRODUCT p
group by CATEGORY
order by 1;

