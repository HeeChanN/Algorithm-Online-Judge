# 1. 없어진 기록 찾기 (복습)
select o.ANIMAL_ID, o.NAME
from ANIMAL_OUTS o
left join ANIMAL_INS i on
    o.ANIMAL_ID = i.ANIMAL_ID
where i.DATETIME is null
order by 1

# 2. 헤비 유저가 소유한 장소
 select p.ID, p.NAME, p.HOST_ID
from PLACES p
inner join (
    select pp.HOST_ID
    from PLACES pp
    group by pp.HOST_ID
    having count(pp.ID) >= 2
) as h on
    p.HOST_ID = h.HOST_ID 


# 3. 조건별로 분류하여 주문상태 출력하기 (복습)
select f.ORDER_ID, f.PRODUCT_ID, DATE_FORMAT(f.OUT_DATE, "%Y-%m-%d"),
CASE WHEN f.OUT_DATE <= '2022-05-01' THEN '출고완료'
     when f.OUT_DATE > '2022-05-01'  then '출고대기'
     else '출고미정'
     end as '출고여부'
from FOOD_ORDER f
order by 1

# 4. 즐겨찾기가 가장 많은 식당 정보 출력하기 (복습)
SELECT FOOD_TYPE, REST_ID, REST_NAME, FAVORITES
from REST_INFO rr
where rr.FAVORITES in (
    select max(r.FAVORITES) 
    from REST_INFO r
    group by r.FOOD_TYPE
)
group by FOOD_TYPE
having rr.FAVORITES = max(rr.FAVORITES)
order by rr.FOOD_TYPE desc;



# 5. 카테고리 별 도서 판매량 집계하기 (복습)
select b.CATEGORY,sum(s.SALES) as TOTAL_SALES
from BOOK_SALES s 
inner join BOOK b on
    s.BOOK_ID = b.BOOK_ID
where s.SALES_DATE like '2022-01-%'
group by b.CATEGORY
order by 1

