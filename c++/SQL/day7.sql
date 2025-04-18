
# 1. 이름이 없는 동물의 아이디
SELECT a.ANIMAL_ID
from ANIMAL_INS a
where a.NAME is null
order by 1;


# 2. 이름이 있는 동물의 아이디
SELECT a.ANIMAL_ID
from ANIMAL_INS a
where a.NAME is not null
order by 1;

# 3. NULL 처리하기
SELECT  a.ANIMAL_TYPE, IFNULL(a.NAME, "No name"), a.SEX_UPON_INTAKE
from ANIMAL_INS a
order by a.ANIMAL_ID


# 4. 나이 정보가 없는 회원 수 구하기
SELECT count(u.USER_ID)
from USER_INFO u
where u.AGE is null;

# 5. 주문량이 많은 아이스크림들 조회하기
SELECT j.FLAVOR
from JULY j
inner join (
    select f.FLAVOR, sum(f.TOTAL_ORDER) as t
    from FIRST_HALF f
    group by f.FLAVOR
) fa ON
    j.FLAVOR = fa.FLAVOR
group by flavor
order by (sum(j.TOTAL_ORDER) + fa.t) desc
limit 3

# 6. 조건에 맞는 도서와 저자 리스트 출력하기
SELECT b.BOOK_ID, a.AUTHOR_NAME, DATE_FORMAT(b.PUBLISHED_DATE,"%Y-%m-%d")
from BOOK b
inner join AUTHOR a on
    b.AUTHOR_ID = a.AUTHOR_ID
where b.CATEGORY = '경제'
order by 3

# 7. 있었는데요 없었습니다.
SELECT i.ANIMAL_ID, i.NAME
from ANIMAL_INS i
inner join ANIMAL_OUTS o on
    i.ANIMAL_ID = o.ANIMAL_ID
where i.DATETIME > o.DATETIME
order by i.DATETIME