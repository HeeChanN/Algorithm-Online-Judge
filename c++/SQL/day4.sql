#1. 동물의 아이디와 이름

SELECT a.ANIMAL_ID, a.NAME
from ANIMAL_INS a
order by a.ANIMAL_ID

#2. 여러 기준으로 정렬하기
SELECT a.ANIMAL_ID, a.NAME, a.DATETIME
from ANIMAL_INS a
order by a.NAME,a.DATETIME desc

#3. 상위 n개의 레코드
SELECT a.NAME
from ANIMAL_INS a
order by a.DATETIME
limit 1;

#4. 조건에 맞는 회원수 구하기
SELECT count(u.USER_ID)
from USER_INFO u
where u.JOINED>='2021-01-01' and u.JOINED <='2021-12-31' and u.AGE >=20 and u.AGE<=29

#5. 가격이 제일 비싼 식품의 정보 출력하기
select f.*
from FOOD_PRODUCT f
order by f.PRICE desc
limit 1