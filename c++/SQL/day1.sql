
# 1. 평균 일일 대여 금액 찾기
SELECT round(avg(DAILY_FEE),0) as AVERAGE_FEE
FROM CAR_RENTAL_COMPANY_CAR c
WHERE c.CAR_TYPE = 'SUV';

# 2. 조건에 맞는 도서 리스트 출력하기
SELECT b.BOOK_ID, DATE_FORMAT(b.PUBLISHED_DATE, '%Y-%m-%d') as PUBLISH_DATE
FROM BOOK b
WHERE year(b.PUBLISHED_DATE) = "2021" and b.CATEGORY = "인문";

# 3. 12세 이하인 여자 목록 출력하기
SELECT p.PT_NAME, p.PT_NO,  p.GEND_CD, p.AGE, IFNULL(p.TLNO,"NONE") as TLNO
FROM PATIENT p
WHERE p.AGE <= 12 and p.GEND_CD = 'W' 
ORDER BY p.AGE desc, p.PT_NAME;

# 4. 3월에 태어난 여성 회원 목록 출력하기
SELECT p.MEMBER_ID, p.MEMBER_NAME, p.GENDER, DATE_FORMAT(p.DATE_OF_BIRTH, '%Y-%m-%d') as DATE_OF_BIRTH
FROM MEMBER_PROFILE p
WHERE MONTH(p.DATE_OF_BIRTH) = 3 and p.GENDER ='W' and p.TLNO is not null
order by p.MEMBER_ID

# 5. 인기 있는 아이스크림
SELECT f.flavor
FROM FIRST_HALF f
order by f.TOTAL_ORDER desc, f.SHIPMENT_ID;