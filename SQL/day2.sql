
# 1. 흉부외과 또는 일반외과 의사 목록 출력하기
SELECT d.DR_NAME, d.DR_ID, d.MCDP_CD, DATE_FORMAT(d.HIRE_YMD, "%Y-%m-%d") as HIRE_YMD
from DOCTOR d
where d.MCDP_CD = 'CS' or d.MCDP_CD = 'GS'
order by d.HIRE_YMD desc, d.DR_NAME;

# 2. 조건에 부합하는 중고거래 댓글 조회하기
SELECT b.TITLE, b.BOARD_ID, r.REPLY_ID, r.WRITER_ID, r.CONTENTS, DATE_FORMAT(r.CREATED_DATE,"%Y-%m-%d")
FROM USED_GOODS_BOARD b
inner join USED_GOODS_REPLY r on
    b.BOARD_ID = r.BOARD_ID
where b.CREATED_DATE >= '2022-10-01' and b.CREATED_DATE <='2022-10-31'
order by r.CREATED_DATE , b.TITLE

# 3. 과일로 만든 아이스크림 고르기
SELECT i.FLAVOR
from FIRST_HALF h
inner join ICECREAM_INFO i on
    h.FLAVOR = i.FLAVOR
where h.TOTAL_ORDER > 3000 and i.INGREDIENT_TYPE = 'fruit_based'
order by h.TOTAL_ORDER desc;

# 4. 서울에 위치한 식당 목록 출력하기 
SELECT i.REST_ID, i.REST_NAME, i.FOOD_TYPE, i.FAVORITES,i.ADDRESS,
round(avg(r.REVIEW_SCORE), 2) as SCORE
from REST_INFO i
inner join REST_REVIEW r on
   i.REST_ID = r.REST_ID
where i.ADDRESS like '서울%'
group by i.REST_ID
order by SCORE desc, i.FAVORITES desc

# 5. 강원도에 위치한 생산 공장 목록 출력하기
SELECT f.FACTORY_ID, f.FACTORY_NAME, f.ADDRESS
from FOOD_FACTORY f
where f.ADDRESS like '강원도%'
order by f.FACTORY_ID

# 6. 재구매가 일어난 상품과 회원 리스트 구하기
SELECT o.USER_ID, o.PRODUCT_ID
from ONLINE_SALE o
group by o.USER_ID, o.PRODUCT_ID
having count(user_id)>1
order by o.USER_ID, o.PRODUCT_ID desc;