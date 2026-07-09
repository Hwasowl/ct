--  보호 시작일보다 입양일이 더 빠른 동물의 아이디와 이름을 조회하는 SQL문을 작성해주세요. 이때 결과는 보호 시작일이 빠른 순으로 조회해야합니다.
SELECT AO.ANIMAL_ID, AO.NAME FROM ANIMAL_INS AI -- 들어온 곳
JOIN ANIMAL_OUTS AO                       -- 나간곳 
ON AI.ANIMAL_ID = AO.ANIMAL_ID
WHERE AO.DATETIME < AI.DATETIME
ORDER BY AI.DATETIME ASC