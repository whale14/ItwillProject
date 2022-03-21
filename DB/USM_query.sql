





/* 내 주변 지역 지역명별 리스트 조회*/
-- 1. 제목에서 검색어로 찾기

SELECT c.client_name, p.product_name, P.PRICE ,c.reliablity

FROM REGION R, client_info C, PRODUCT P

WHERE r.region_id = C.REGION_ID 
AND C.CLIENT_ID = P.CLIENT_ID
AND p.product_name LIKE '%고%'  
;


/*지역명으로 검색*/
SELECT c.client_name, p.product_name, P.PRICE ,c.reliablity
FROM REGION R, client_info C, PRODUCT P
WHERE r.region_id = C.REGION_ID 
AND C.CLIENT_ID = P.CLIENT_ID
AND R.REGION_ID = '서울특별시'
;

/*지역+ 검색어로 검색*/
SELECT c.client_name, p.product_name, P.PRICE ,c.reliablity
FROM REGION R, client_info C, PRODUCT P
WHERE r.region_id = C.REGION_ID 
AND C.CLIENT_ID = P.CLIENT_ID
AND p.product_name LIKE '%고%'  
AND R.REGION_ID = '서울특별시'
;



SELECT PRODUCT_NAME, product_description, PRICE 
FROM product
WHERE product_id = 1
;

/* 상품정보 입력 -- DB에 추가*/
INSERT INTO PRODUCT VALUES (?,?,?,?,/*getID*/?);








