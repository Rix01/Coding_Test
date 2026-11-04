select p.id, count(d.parent_id) as child_count
from ecoli_data p
left join ecoli_data d on (p.id = d.parent_id)
group by p.id
order by p.id asc;