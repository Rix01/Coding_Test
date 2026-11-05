-- product_id, sales_amount, sales_date 겹침
-- 
select sales_date, product_id, user_id, sales_amount
from online_sale
where sales_date >= '2022-03-01' and sales_date < '2022-04-01'

union all

select sales_date, product_id, null as user_id, sales_amount
from offline_sale
where sales_date >= '2022-03-01' and sales_date < '2022-04-01'
order by sales_date, product_id, user_id;