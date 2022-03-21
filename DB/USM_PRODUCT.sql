-- USM_PRODUCT



INSERT INTO PRODUCT (PRODUCT_ID, PRODUCT_NAME, PRODUCT_DESCRIPTION, CLIENT_ID, PRICE)
    VALUES (1,'에어팟프로 팝니다','에어팟 프로 팝니다! A급에 애지중지 사용했어요! 네고 사절',01077773983,150000);

INSERT INTO PRODUCT 
    VALUES (2,'고급형 자전거 팝니다!',' 고급형 자전거 저렴하게 내놓습니다ㅠㅠ ',01080003983,900000);
           
INSERT INTO PRODUCT 
    VALUES (3,'나이키 범고래 285 판매합니다!',' 있는데 또 당첨돼서 저렴하게 내놓습니다 문의주세요! ',01099993983,280000);

INSERT INTO PRODUCT 
    VALUES (4,'아이폰 13프맥 급구해요!! ','지금 액정 깨져서 오늘안에 꼭 구매해야해요 ㅠㅠ ',01054363983,1580000);
    
INSERT INTO PRODUCT 
    VALUES (5,'남편 팔아요~! 무료나눔이에용 ♡ ','오늘 당장 파니까 폭풍문의 부탁드려용 ㅎㅎㅎ ',01012345678,0);

INSERT INTO PRODUCT 
    VALUES (6,'DN 캐논 AE-1 필카 판매 ',' 레트로 감성 살아있는 감성 카메라 판매합니다 애지중지 사용했어요! 네고안됩니다 ',01076745663,274000);
    
INSERT INTO PRODUCT 
    VALUES (7,'미개봉 에어프라이기 팔아요!',' 이사관계로 미개봉 새제품 판매합니다 ㅠㅠ 25일 13시까지만 판매가능 ㅠㅠ ',01099345345,111111);    

INSERT INTO PRODUCT 
    VALUES (8,'혼자 공부하는 자바 팝니다!',' 국비학원 다닐때 받은건데 한번도 안폈어요! 혼공할때 좋아요 ㅎㅎ ',01052342343,18000);    

INSERT INTO PRODUCT 
    VALUES (9,'띠부띠부씰 피카츄 나왔어요!!',' 피카츄 레언거 아시져? ㅋㅋ 50000만 팜! 쿨거래시 2천원 에눌 가능해유 ㅎㅎ ',01020077673,50000);    

INSERT INTO PRODUCT 
    VALUES (10,'미개봉 에어프라이기 팔아요!',' 이사관계로 미개봉 새제품 판매합니다 ㅠㅠ 25일 13시까지만 판매가능 ㅠㅠ ',01023443983,111111);    
    
INSERT INTO PRODUCT 
    VALUES ((SELECT MAX(product_id)+1 FROM product),'미개봉 에어프라이기 팔아요!',' 이사관계로 미개봉 새제품 판매합니다 ㅠㅠ 25일 13시까지만 판매가능 ㅠㅠ ',01023443983,111111);    
    


SELECT *
FROM PRODUCT P, CLIENT_INFO C , REGION R
WHERE P.CLIENT_ID = C.CLIENT_ID 
AND r.region_id = c.region_id
ORDER BY PRODUCT_ID;
    
    
