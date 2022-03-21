

/*  REGION_ID에 따른 판매내역 보기 */

SELECT r.region_name, p.product_name, P.product_description, P.PRICE 
FROM REGION R, client_info C, PRODUCT P
WHERE r.region_id = C.REGION_ID 
AND C.CLIENT_ID = P.CLIENT_ID
AND C.REGION_ID = 1 
;



/* 상품정보 입력 -- DB에 추가*/
INSERT INTO PRODUCT VALUES (?,?,?,?,/*getID*/?);





