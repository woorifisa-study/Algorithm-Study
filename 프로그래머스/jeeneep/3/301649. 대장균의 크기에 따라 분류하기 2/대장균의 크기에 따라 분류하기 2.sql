with RANKED_ECOLI as (
    select
        ID,
        NTILE(4) OVER (ORDER BY SIZE_OF_COLONY DESC) AS COLONY_NAME
    from ECOLI_DATA
)
select 
    ID,
        case 
        when COLONY_NAME = 1 then 'CRITICAL'
        when COLONY_NAME = 2 then 'HIGH'
        when COLONY_NAME = 3 then 'MEDIUM'
        when COLONY_NAME = 4 then 'LOW'
    end as COLONY_NAME
from RANKED_ECOLI
order by ID asc;
