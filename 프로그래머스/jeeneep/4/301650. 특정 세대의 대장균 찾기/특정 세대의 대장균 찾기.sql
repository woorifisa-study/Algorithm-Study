with recursive GENERATION_DATA as (
    select 
        ID,
        PARENT_ID,
        1 as GENERATION
    from ECOLI_DATA
    where PARENT_ID is null
    
    union all
    
    select 
        CHILD.ID,
        CHILD.PARENT_ID,
        PARENT.GENERATION + 1 as GENERATION
    from ECOLI_DATA CHILD
    JOIN GENERATION_DATA PARENT
        on CHILD.PARENT_ID = PARENT.ID   
)

select ID
from GENERATION_DATA
where GENERATION = 3
order by ID asc;