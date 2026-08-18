with recursive GENERATION_DATA as (
    select
        ID,
        1 as GENERATION
    from ECOLI_DATA
    where PARENT_ID is null
    
    union all
    
    select
        CHILD.ID,
        PARENT.GENERATION + 1 as GENERATION
    from ECOLI_DATA CHILD
    join GENERATION_DATA PARENT 
        on PARENT.ID = CHILD.PARENT_ID
)

select 
    count(*) as COUNT,
    GENERATION
from GENERATION_DATA
where not exists (
    select 1
    from ECOLI_DATA CHILD
    where GENERATION_DATA.ID = CHILD.PARENT_ID
)
group by GENERATION
order by GENERATION asc;