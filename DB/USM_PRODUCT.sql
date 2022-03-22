-- USM_PRODUCT
DROP TABLE PRODUCT;



CREATE TABLE PRODUCT(
    PRODUCT_ID NUMBER(10) PRIMARY KEY,  -- 상품ID
    PRODUCT_NAME VARCHAR2(50) NOT NULL, -- 상품명
    PRODUCT_DESCRIPTION VARCHAR(200),   -- 상품설명
    PRICE NUMBER(9) NOT NULL,            -- 가격명
    CLIENT_ID NUMBER(13) NOT NULL,      -- 회원ID
    REGION_ID VARCHAR2(50) NOT NULL     -- 지역
)
;


INSERT INTO PRODUCT (PRODUCT_ID, PRODUCT_NAME, PRODUCT_DESCRIPTION, PRICE, CLIENT_ID, REGION_ID)
    VALUES (1,'에어팟프로 팝니다','에어팟 프로 팝니다! A급에 애지중지 사용했어요! 네고 사절',150000,01077773983,'서울특별시');

INSERT INTO PRODUCT 
    VALUES (2,'고급형 자전거 팝니다!',' 고급형 자전거 저렴하게 내놓습니다ㅠㅠ ',900000,01080003983,'서울특별시');
           
INSERT INTO PRODUCT 
    VALUES (3,'나이키 범고래 285 판매합니다!',' 있는데 또 당첨돼서 저렴하게 내놓습니다 문의주세요! ',280000,01099993983,'대전광역시');

INSERT INTO PRODUCT 
    VALUES (4,'아이폰 13프맥 급구해요!! ','지금 액정 깨져서 오늘안에 꼭 구매해야해요 ㅠㅠ ',1580000,01054363983,'서울특별시');
    
INSERT INTO PRODUCT 
    VALUES (5,'남편 팔아요~! 무료나눔이에용 ♡ ','오늘 당장 파니까 폭풍문의 부탁드려용 ㅎㅎㅎ ',0,01012345678,'인천광역시');

INSERT INTO PRODUCT 
    VALUES (6,'DN 캐논 AE-1 필카 판매 ',' 레트로 감성 살아있는 감성 카메라 판매합니다 애지중지 사용했어요! 네고안됩니다 ',274000,01076745663,'경기도');
    
INSERT INTO PRODUCT 
    VALUES (7,'미개봉 에어프라이기 팔아요!',' 이사관계로 미개봉 새제품 판매합니다 ㅠㅠ 25일 13시까지만 판매가능 ㅠㅠ ',111111,01099345345,'인천광역시');    

INSERT INTO PRODUCT 
    VALUES (8,'혼자 공부하는 자바 팝니다!',' 국비학원 다닐때 받은건데 한번도 안폈어요! 혼공할때 좋아요 ㅎㅎ ',18000,01052342343,'충청도');    

INSERT INTO PRODUCT 
    VALUES (9,'띠부띠부씰 피카츄 나왔어요!!',' 피카츄 레언거 아시져? ㅋㅋ 50000만 팜! 쿨거래시 2천원 에눌 가능해유 ㅎㅎ ',50000,01020077673,'전라도');    

INSERT INTO PRODUCT 
    VALUES (10,'미개봉 에어프라이기 팔아요!',' 이사관계로 미개봉 새제품 판매합니다 ㅠㅠ 25일 13시까지만 판매가능 ㅠㅠ ',111111,01023443983,'부산광역시');    
    
INSERT INTO PRODUCT 
    VALUES ((SELECT MAX(product_id)+1 FROM product),'미개봉 에어프라이기 팔아요!',' 이사관계로 미개봉 새제품 판매합니다 ㅠㅠ 25일 13시까지만 판매가능 ㅠㅠ ',111111,01023443983,'부산광역시');    
    


SELECT *
FROM PRODUCT P, CLIENT_INFO C , REGION R
WHERE P.CLIENT_ID = C.CLIENT_ID 
AND r.region_id = c.region_id
ORDER BY PRODUCT_ID;
    
    
