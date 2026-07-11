

-- SELECT * FROM (
--     SELECT J.FLAVOR, SUM(J.TOTAL_ORDER) + SUM(FH.TOTAL_ORDER) FROM JULY J
--     JOIN FIRST_HALF FH ON FH.SHIPMENT_ID = J.SHIPMENT_ID
--     GROUP BY J.FLAVOR
--     ORDER BY SUM(J.TOTAL_ORDER) + SUM(FH.TOTAL_ORDER) DESC
-- ) WHERE ROWNUM <= 3

select flavor from (
    select flavor, sum(total_order) as total_order from july
    group by flavor
    union all
    select flavor, sum(total_order) as total_order from first_half
    group by flavor
) 
group by flavor
order by sum(total_order) desc
FETCH FIRST 3 ROWS ONLY