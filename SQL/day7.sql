
# 1. 동명 동물 수 찾기
SELECT a.NAME, count(a.ANIMAL_ID) as COUNT
from ANIMAL_INS a
where a.NAME is not NULL
group by a.NAME
having COUNT > 1
order by 1;


# 2. 입양 시각 구하기(1)
SELECT HOUR(o.DATETIME) as HOUR, count(o.ANIMAL_ID) as COUNT
from ANIMAL_OUTS o
where HOUR(DATETIME) between '9' and '19'
group by HOUR
order by 1;

# 3. 입양 시각 구하기(2)
SELECT num.HOUR, count(a.ANIMAL_ID) as COUNT
from (
   select ROW_NUMBER () OVER() - 1 as HOUR
    from ANIMAL_OUTS o
    limit 24
) as num
left outer join ANIMAL_OUTS a on
    num.HOUR = HOUR(a.DATETIME)
group by HOUR
order by 1;


# 4. 가격대 별 상품 개수 구하기
SELECT floor(p.PRICE / 10000) * 10000 as PRICE_GROUP, count(p.product_id) as PRODUCTS
from product p
group by PRICE_GROUP
order by 1;

# 5. 경기도에 위치한 식품창고 목록 출력하기
SELECT f.WAREHOUSE_ID, f.WAREHOUSE_NAME, f.ADDRESS, IFNULL(f.FREEZER_YN,'N')
from FOOD_WAREHOUSE f
where f.ADDRESS like '경기도%'
order by f.WAREHOUSE_ID