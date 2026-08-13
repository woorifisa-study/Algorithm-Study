select P.ID, COUNT(C.ID) as CHILD_COUNT
from ECOLI_DATA P
left join ECOLI_DATA C on C.PARENT_ID = P.ID
group by P.ID
order by P.ID;