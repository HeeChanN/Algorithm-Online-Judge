
# 1. 조건에 맞는 사용자 정보 조회하기
select u.USER_ID, u.NICKNAME, concat(u.CITY, " ",u.STREET_ADDRESS1," ",u.STREET_ADDRESS2) as '전체주소', concat(substr(TLNO,1,3),'-',substr(TLNO,4,4),'-',substr(TLNO,8,4)) as '전화번호'
from (
    select b.WRITER_ID 
    from USED_GOODS_BOARD b
    group by b.WRITER_ID
    having count(b.WRITER_ID) >= 3
) as w
inner join USED_GOODS_USER u on
    u.USER_ID = w.WRITER_ID
order by 1 desc


# 2. 대여 기록이 존재하는 자동차 리스트 구하기
select distinct cc.CAR_ID
from CAR_RENTAL_COMPANY_CAR cc
inner join (
    SELECT c.CAR_ID
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY c
    where MONTH(c.START_DATE) ='10') as oct on 
    cc.CAR_ID = oct.CAR_ID
where cc.CAR_TYPE = '세단'
order by 1 desc

# 3. 조건별로 분륳여 주문상태 출력하기
SELECT ORDER_ID, PRODUCT_ID, DATE_FORMAT(OUT_DATE, '%Y-%m-%d'),
    (CASE WHEN o.OUT_DATE <= '2022-05-01' THEN '출고완료'
         WHEN o.OUT_DATE > '2022-05-01' THEN '출고대기'
         ELSE '출고미정'
         END )AS '출고여부'
FROM FOOD_ORDER o
ORDER BY 1 ;


# 4. 취소되지 않은 진료 예약 조회하기
SELECT a.APNT_NO, p.PT_NAME, p.PT_NO, a.MCDP_CD, d.DR_NAME, a.APNT_YMD
from APPOINTMENT a
inner join PATIENT p on
    a.PT_NO = p.PT_NO
inner join DOCTOR d on
    d.DR_ID = a.MDDR_ID
where a.APNT_CNCL_YN = 'N' and DATE_FORMAT(a.APNT_YMD,'%Y-%m-%d')  ='2022-04-13' and a.MCDP_CD ='CS'
order by a.APNT_YMD

# 5. 상품 별 오프라인 매출 구하기
SELECT p.product_code, sum(sales_amount) * p.price
from PRODUCT p
inner join OFFLINE_SALE s on
    p.PRODUCT_ID = s.PRODUCT_ID
group by p.product_code
order by 2 desc,1

