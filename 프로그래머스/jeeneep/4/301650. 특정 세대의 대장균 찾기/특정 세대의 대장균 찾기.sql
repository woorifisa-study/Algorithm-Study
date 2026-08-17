-- 코드를 작성해주세요

select G3.ID
from ECOLI_DATA G3
    join ECOLI_DATA G2 on G3.PARENT_ID = G2.ID
    join ECOLI_DATA G1 on G2.PARENT_ID = G1.ID
where G1.PARENT_ID is NULL
order by G3.ID;