with recursive gen_tree as (
    select id, 1 as generation
    from ecoli_data
    where parent_id is null
    
    union all
    
    select e.id, g.generation + 1
    from ecoli_data e
    join gen_tree g on (e.parent_id = g.id)
)

select id
from gen_tree
where generation = 3;