# 1. 대여 횟수가 많은 자동차들의 월별 대여 횟수 구하기 (복습)
SELECT MONTH(START_DATE) AS MONTH, CAR_ID, COUNT(*) AS RECORDS
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE START_DATE BETWEEN '2022-08-01' AND '2022-10-31'
      AND CAR_ID IN (SELECT CAR_ID
                     FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
                     WHERE START_DATE BETWEEN '2022-08-01' AND '2022-10-31'
                     GROUP BY CAR_ID
                     HAVING COUNT(*)>= 5)
GROUP BY MONTH(START_DATE), CAR_ID 
ORDER BY MONTH, CAR_ID DESC

# 2. 자동차 대여 기록에서 대여중/대여 가능 여부 구분하기  (복습)
 SELECT c.CAR_ID, ifnull(r.AVAILABILTY,'대여 가능') as AVAILABILITY
 from (
    select cc.HISTORY_ID, cc.CAR_ID, '대여중' as AVAILABILTY
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY cc
    where cc.START_DATE <= '2022-10-16' and '2022-10-16' <= cc.END_DATE
 ) r
 right outer join  CAR_RENTAL_COMPANY_RENTAL_HISTORY c on 
    r.CAR_ID = c.CAR_ID
group by c.CAR_ID
order by c.CAR_ID desc


# 3. 대여 기록이 존재하는 자동차 리스트 구하기  (복습)
select distinct h.CAR_ID
from CAR_RENTAL_COMPANY_RENTAL_HISTORY h
inner join CAR_RENTAL_COMPANY_CAR c on
    h.CAR_ID = c.CAR_ID
where month(h.START_DATE) = '10' and c.CAR_TYPE = '세단'
order by 1 desc

# 4. 조건에 맞는 사용자와 총 거래 금액 조회하기 (복습)
select u.USER_ID, u.NICKNAME, sum(b.PRICE) as TOTAL_SALES
from USED_GOODS_BOARD b
inner join USED_GOODS_USER u on
    b.WRITER_ID = u.USER_ID
where b.STATUS = 'DONE'
group by u.USER_ID
having TOTAL_SALES >= 700000
order by 3


# 5. 조건에 맞는 사용자 정보 조회하기 (복습)
select u.USER_ID, u.NICKNAME, concat(u.CITY, " ",u.STREET_ADDRESS1," ",u.STREET_ADDRESS2) as '전체주소', concat(substr(TLNO,1,3),'-',substr(TLNO,4,4),'-',substr(TLNO,8,4)) as '전화번호'
from USED_GOODS_USER u
inner join USED_GOODS_BOARD b on
    u.USER_ID = b.WRITER_ID
group by u.USER_ID
having count(b.board_id) >= 3
order by 1 desc

# 6. 조회수가 가장 많은 중고거래 게시판의 첨부파일 조회하기 (복습)
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
