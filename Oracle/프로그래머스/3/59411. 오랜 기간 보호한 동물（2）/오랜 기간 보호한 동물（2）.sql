-- 입양을 간 동물 중, 보호 기간이 가장 길었던 동물 두 마리의 아이디와 이름을 조회하는 SQL문을 작성해주세요. 이때 결과는 보호 기간이 긴 순으로 조회해야 합니다.

select AI.ANIMAL_ID, AI.NAME
FROM ANIMAL_INS AI
JOIN ANIMAL_OUTS AO ON AI.ANIMAL_ID = AO.ANIMAL_ID
ORDER BY MONTHS_BETWEEN(AO.DATETIME, AI.DATETIME) DESC
FETCH FIRST 2 ROWS ONLY

