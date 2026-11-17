-- fish_info f
-- fish_name_info n

select f.id, n.fish_name, f.length
from fish_info f
join fish_name_info n on (f.fish_type = n.fish_type)
where (f.fish_type, f.length) in (
    select fish_type, max(length)
    from fish_info
    group by (fish_type)
)
group by f.fish_type;