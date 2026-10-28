-- 아이템의 희귀도가 'RARE'인 아이템들의 모든 다음 업그레이드 아이템의 아이템 ID(ITEM_ID), 아이템 명(ITEM_NAME), 아이템의 희귀도(RARITY)를 출력하는 SQL 문을 작성해 주세요. 이때 결과는 아이템 ID를 기준으로 내림차순 정렬주세요.

SELECT
    i.item_id, i.item_name, i.rarity
FROM
    item_info i
JOIN 
    item_tree t ON i.item_id = t.item_id
JOIN
    item_info p ON t.parent_item_id = p.item_id
WHERE
    p.rarity = 'RARE'
ORDER BY
    i.item_id desc;


