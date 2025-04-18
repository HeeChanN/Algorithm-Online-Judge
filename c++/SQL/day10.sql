1. 루시와 엘라 찾기
select a.ANIMAL_ID, a.NAME, a.SEX_UPON_INTAKE
from ANIMAL_INS a
where a.NAME in ('Lucy', 'Ella' ,'Pickle','Rogan','Sabrina','Mitty')

2. 중성화 여부 파악하기
SELECT a.ANIMAL_ID, a.NAME, CASE WHEN a.SEX_UPON_INTAKE like 'Spayed%' or a.SEX_UPON_INTAKE like 'Neutered%' THEN 'O'
ELSE 'X'
END AS '중성화'
from ANIMAL_INS a

3. 이름에 el이 들어가는 동물 찾기
SELECT a.ANIMAL_ID, a.NAME
from ANIMAL_INS a
where a.NAME like '%el%' and a.ANIMAL_TYPE = 'Dog'
order by 2

4. DATETIME에서 DATE로 형 변환
SELECT a.ANIMAL_ID, a.NAME, DATE_FORMAT(a.DATETIME, '%Y-%m-%d') as '날짜'
from ANIMAL_INS a
order by 1

5. 자동차 대여 기록에서 장기/단기 대여 구분하기
SELECT a.HISTORY_ID, a.CAR_ID, DATE_FORMAT(a.START_DATE,"%Y-%m-%d"), DATE_FORMAT(a.END_DATE,"%Y-%m-%d"),
CASE when (DATEDIFF(a.END_DATE,a.START_DATE) +1) >= 30 then '장기 대여'
            else '단기 대여'
            end as RENT_TYPE
from CAR_RENTAL_COMPANY_RENTAL_HISTORY a
where a.START_DATE like '2022-09-%'
order by a.HISTORY_ID desc