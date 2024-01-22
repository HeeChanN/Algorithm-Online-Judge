
# 1. 대여 횟수가 많은 자동차들의 월별 대여 횟수 구하기
SELECT month(r.START_DATE) as MONTH, r.CAR_ID, count(r.HISTORY_ID) as RECORDS
from CAR_RENTAL_COMPANY_RENTAL_HISTORY r
where CAR_ID in (
    select rr.CAR_ID
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY rr
    where month(rr.START_DATE) in (8,9,10)
    group by rr.CAR_ID
    having count(rr.HISTORY_ID) >=5
) AND MONTH(START_DATE) IN (8,9,10)
group by MONTH,r.CAR_ID
having COUNT(HISTORY_ID) >= 1
order by 1, 2 desc


# 2. 성분으로 구분한 아이스크림 총 주문량
SELECT a.INGREDIENT_TYPE, sum(b.TOTAL_ORDER)
from ICECREAM_INFO a
inner join FIRST_HALF b on
    a.FLAVOR = b.FLAVOR
group by a.INGREDIENT_TYPE

# 3. 식품분류별 가장 비싼 식품의 정보 조회하기
SELECT f.CATEGORY, f.PRICE as MAX_PRICE, f.PRODUCT_NAME
from FOOD_PRODUCT f
inner join (
    select ff.CATEGORY, max(ff.price) as p
    from FOOD_PRODUCT ff
    where ff.CATEGORY in ('과자','국','김치','식용유')
    group by ff.CATEGORY
) as n on
    f.PRICE = n.p and f.CATEGORY = n.CATEGORY
order by 2 desc;

# 4. 년, 월, 성별 별 상품 구매 회원 수 구하기
SELECT year(o.SALES_DATE) as YEAR, month(o.SALES_DATE) as MONTH, u.GENDER , count(distinct u.USER_ID) as USERS
from ONLINE_SALE o
inner join USER_INFO u on
    o.USER_ID = u.USER_ID
WHERE U.GENDER IS NOT NULL
group by year(o.SALES_DATE), month(o.SALES_DATE), u.GENDER
order by 1,2,3

# 5. 고양이와 개는 몇 마리 있을까?
SELECT a.ANIMAL_TYPE, count(a.ANIMAL_ID)
from ANIMAL_INS a
group by a.ANIMAL_TYPE
order by a.ANIMAL_TYPE