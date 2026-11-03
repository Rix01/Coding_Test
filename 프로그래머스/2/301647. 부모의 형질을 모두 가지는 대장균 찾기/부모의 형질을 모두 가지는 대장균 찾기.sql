-- ecoli e
-- ecoli parent ver ep

select e.id, e.genotype, ep.genotype as parent_genotype
from ecoli_data e
join ecoli_data ep on (e.parent_id = ep.id)
where (e.genotype & ep.genotype = ep.genotype)
order by e.id asc;