-- 코드를 작성해주세요 item_tree t item_info i

select t.item_id, item_name, rarity
from item_tree t
join item_info i on (t.item_id = i.item_id)
where parent_item_id in(
        select item_id 
        from item_info 
        where rarity = 'RARE'
    )
order by t.item_id desc;