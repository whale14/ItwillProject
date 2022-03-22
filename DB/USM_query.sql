





/* 리스트 조회(검색/ 지역+검색 /지역)*/
-- 1. 제목에서 검색어로 찾기

SELECT c.client_name, p.product_name, P.PRICE ,c.reliablity
FROM REGION R, client_info C, PRODUCT P
WHERE r.region_id = C.REGION_ID 
AND C.CLIENT_ID = P.CLIENT_ID
AND p.product_name LIKE '%검색어%'  
;

SELECT p.PRODUCT_ID, c.client_name, p.product_name, p.PRICE ,c.reliability
FROM client_info C JOIN product P
ON c.client_id = p.client_id
AND p.product_name like '%검색어%'
;




/*2. 지역+ 검색어로 검색*/
SELECT c.client_name, p.product_name, P.PRICE ,c.reliability
FROM REGION R, client_info C, PRODUCT P
WHERE r.region_id = C.REGION_ID 
AND C.CLIENT_ID = P.CLIENT_ID
AND p.product_name LIKE '%고%'  
AND R.REGION_ID = '서울특별시'
;

/*3. 지역명으로 검색*/
SELECT c.client_name, p.product_name, P.PRICE ,c.reliablity
FROM REGION R, client_info C, PRODUCT P
WHERE r.region_id = C.REGION_ID 
AND C.CLIENT_ID = P.CLIENT_ID
AND R.REGION_ID = '서울특별시'
;


/*상품 등록 번호 순서대로 검색*/
SELECT PRODUCT_NAME, product_description, PRICE 
FROM product
WHERE product_id = 1
;

/* 판매등록 쿼리*/
INSERT INTO PRODUCT (PRODUCT_ID, PRODUCT_NAME, PRODUCT_DESCRIPTION, CLIENT_ID, PRICE)
        VALUES((SELECT MAX(product_id)+1 FROM product),?,?,/*getID*/,?);

/*내가 올린 상품 조회 */
SELECT *
FROM PRODUCT
WHERE client_id = 1076745663
;

/*업데이트 상품명 */
UPDATE PRODUCT SET product_name = ' '
WHERE client_id = 1076745663
;

/*업데이트 내용*/  
UPDATE PRODUCT SET product_DESCRIPTION = ' '
WHERE client_id = 1076745663
;

/*업데이트 금액*/  
UPDATE PRODUCT SET PRICE = ' '
WHERE client_id = 1076745663
;

/*회원탈퇴*/
DELETE CLIENT_INFO WHERE CLIENT_ID = 1076745663;
SELECT * FROM CLIENT_INFO;
