select 
    TO_CHAR(SALES_DATE, 'YYYY-MM-DD') as SALES_DATE,
    PRODUCT_ID, 
    USER_ID, 
    SUM(SALES_AMOUNT) as SALES_AMOUNT 
from (
    SELECT O.USER_ID, O.PRODUCT_ID, O.SALES_AMOUNT, O.SALES_DATE 
    FROM ONLINE_SALE O
    UNION ALL
    SELECT NULL, OS.PRODUCT_ID, OS.SALES_AMOUNT, OS.SALES_DATE
    FROM OFFLINE_SALE OS
) 
where to_char(sales_date, 'YYYY-MM') = '2022-03'
group by product_id, user_id, sales_date
order by sales_date asc, product_id asc, user_id asc
