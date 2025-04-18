
# 1. 최댓값 구하기
SELECT a.DATETIME
from ANIMAL_INS a
order by a.DATETIME desc
limit 1;

# 2. 최솟값 구하기
SELECT a.DATETIME
from ANIMAL_INS a
order by a.DATETIME
limit 1

# 3. 동물의 수 구하기
SELECT count(a.ANIMAL_ID) as count
from ANIMAL_INS a

# 4. 중복 제거하기
SELECT count(distinct a.NAME)
from ANIMAL_INS a

# 5. 즐겨찾기가 가장 많은 식당 정보 출력하기
SELECT FOOD_TYPE, REST_ID, REST_NAME, FAVORITES
FROM REST_INFO
WHERE FAVORITES IN (
    SELECT MAX(FAVORITES) 
    FROM REST_INFO 
    GROUP BY FOOD_TYPE
)
GROUP BY FOOD_TYPE
ORDER BY FOOD_TYPE DESC

#6. 조건에 맞는 사용자와 총 거래금액 조회하기
SELECT u.WRITER_ID as USER_ID, b.NICKNAME, sum(u.price) as TOTAL_SALES
from USED_GOODS_BOARD u
inner join USED_GOODS_USER b on
    u.WRITER_ID = b.USER_ID
where u.STATUS = 'DONE'
group by u.WRITER_ID
having sum(u.price) >= 700000
order by TOTAL_SALES