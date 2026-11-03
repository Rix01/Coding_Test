-- 코드를 작성해주세요
select distinct d.id, d.email, d.first_name, d.last_name
from developers d
join skillcodes s on ((s.code & d.skill_code) > 0)
where s.name in ('Python', 'C#')
order by d.id asc;