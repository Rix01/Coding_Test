with recursive gen_tree as (
    select id, 1 as generation
    from ecoli_data
    where parent_id is null
    
    union all
    
    select e.id, g.generation + 1
    from ecoli_data e
    join gen_tree g on (g.id = e.parent_id)
)

select count(*) as count, generation
from gen_tree
where id not in(
    select distinct parent_id
    from ecoli_data
    where parent_id is not null
)
group by (generation)
order by generation asc;