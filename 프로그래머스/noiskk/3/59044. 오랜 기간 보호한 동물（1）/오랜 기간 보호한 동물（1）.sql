-- 아직 입양을 못 간 동물 중, 가장 오래 보호소에 있었던 동물 3마리의 이름과 보호 시작일을 조회
-- 보호 시작일 순으로 조회

-- 아직 입양을 못 간 동물 : animal_ins 에 있지만 animal_outs 에 없는 동물. 
SELECT
    ins.name AS NAME, ins.datetime AS DATETIME
FROM
    animal_ins AS ins
LEFT JOIN
    animal_outs AS outs
ON
    ins.animal_id = outs.animal_id
WHERE
    outs.animal_id IS NULL
ORDER BY
    datetime
LIMIT
    3;
    