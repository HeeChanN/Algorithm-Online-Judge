
# 1. 보호소에서 중성화한 동물
SELECT i.ANIMAL_ID, i.ANIMAL_TYPE, i.NAME
from ANIMAL_INS i
inner join ANIMAL_OUTS o on
    i.ANIMAL_ID = o.ANIMAL_ID
where i.SEX_UPON_INTAKE like 'Intact%' 
and (o.SEX_UPON_OUTCOME like 'Spayed%' 
or o.SEX_UPON_OUTCOME like 'Neutered%')
order by i.ANIMAL_ID


# 2. 오랜 기간 보호한 동물(2)
SELECT o.ANIMAL_ID, o.NAME
from ANIMAL_OUTS o
inner join ANIMAL_INS i on
    o.ANIMAL_ID = i.ANIMAL_ID
order by DATEDIFF(o.DATETIME, i.DATETIME) desc
limit 2;

# 3. 우유와 요거트가 담긴 장바구니 
SELECT c.CART_ID
from (
    select cc.CART_ID
    from CART_PRODUCTS cc
    where cc.NAME like 'Yogurt'
) y
inner join CART_PRODUCTS c on
    y.CART_ID = c.CART_ID
where c.NAME like 'Milk'
order by 1


# 4. 헤비 유저가 소유한 장소
select p.ID, p.NAME, p.HOST_ID
from PLACES p
inner join (
    SELECT pp.ID, pp.NAME, pp.HOST_ID
    from PLACES pp
    group by pp.HOST_ID
    having count(pp.ID) >= 2
) a on
    p.HOST_ID = a.HOST_ID

# 5. 조회수가 가장 많은 중고 거래 게시판의 첨부파일 조회하기
SELECT CONCAT('/home/grep/src/',u.BOARD_ID,'/',u.FILE_ID,u.FILE_NAME,u.FILE_EXT) FILE_PATH
from USED_GOODS_FILE u
inner join (
    select *
    from USED_GOODS_BOARD b
    order by b.VIEWS desc
    limit 1
) t on
    u.BOARD_ID = T.BOARD_ID
order by u.FILE_ID desc;

