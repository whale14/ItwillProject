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
    VALUES (11,'',' 이사관계로 미개봉 새제품 판매합니다 ㅠㅠ 25일 13시까지만 판매가능 ㅠㅠ ',111111,01023443983,'부산광역시');    




INSERT INTO PRODUCT 
    VALUES (11,'팔아요]아이패드 프로 11인치 128기가','5세대로 기변하면서 판매합니다. 쿨거래시 2만원 할인해드려요 ',990000,,'');    

INSERT INTO PRODUCT 
    VALUES (12,’급처) 삼성 냉장고 직접 가지러 오실 분만!’, ’경품 당첨되어 기존 제품 내놓아요 ㅎㅎ 제품이 무거워서 직접 가지러 오실분만 문의주세용 ㅎㅎ ‘,450000,,’’);    

INSERT INTO PRODUCT 
    VALUES (13,’젠틀몬스터 썬글라스 판매합니다! 보증서 있음’,’ 한창 유행할때 잠깐 쓰고 안써서 팝니다 실착 3회 정도되는거 같구요 보증서 있으니 편하게 문의 주세요~ ‘,250000, , ’ ’);    

INSERT INTO PRODUCT 
    VALUES (14,’무료나눔) 코스트코x현대 콜라보 백 ‘ , ’현대카드 만들면서 공짜로 받은건데 안써서 무료나눔합니다! 선착순 1분 ㅎㅎ ‘ , 0 , , ’ ’ );    


INSERT INTO PRODUCT 
    VALUES (15,’일룸 책상 판매합니다! ‘,’딸내미 학업이 끝나면서 책상정리합니다 ㅎㅎ 분해 조립 간단해서 여성분도 조립은 가능한데 무거워서 남성분 동반해서 오시는게 좋겠네요’ , 50000,,'');    


INSERT INTO PRODUCT 
    VALUES (16,’ 무료나눔) 콜라 좋아하시는분? ’ , ’콜라는 제로만 먹어서 배달 음식시키면서 온 콜라들이 잔뜩 쌓였네요 ㅠㅠ 좋아하시는분 다가져가셔요  ',0,,'');    


INSERT INTO PRODUCT 
    VALUES (17,’ 유모차 판매합니다 ~ ’,’우리 강아지 애기때 태우던건데 이젠 필요 없게되어 저렴하게 내놓아요 ^_^' ,50000, ,’ ’);    


INSERT INTO PRODUCT 
    VALUES (18,'급처) 보테가 베네타 크로스백 팔아요!!!' , ’급전 필요해서 판매합니다 ㅠㅠ 네고는 죄송해요 ㅠㅠ ',599999,,'');    


INSERT INTO PRODUCT 
    VALUES (19,’ 액파) 갤럭시노트10+ 팔아여 ,’갤노트 10+ 액정파손 이외에는 터치도 잘됩니다 고쳐서 사용하실만할꺼에요.  ‘,190000, ,’ ’);    


INSERT INTO PRODUCT 
    VALUES (20,’히가시노 게이고  작가 추리소설 판매합니다! ‘ ,’권당 5천원씩 11권 팔아요 책 조심스레 읽는 편이라 페이지 접힌거도 없습니다 ‘,5000, , ’ ’);    


INSERT INTO PRODUCT 
    VALUES (21,’애플워치SE 경품당첨되서 팔아여 ’,’ 너무 신기하게 당첨되서 빨리 팔고싶네용 네고문의는 어느정도만 받을게요 ㅠ ‘,250000, ,’ ’);    


INSERT INTO PRODUCT 
    VALUES (22,’ 철제 접이식 의자 팔아요~’ ,’행사용으로 한번 사용한 의자에요 철제로 되어서 튼튼합니다  ‘,15000, ,’ ’);    


INSERT INTO PRODUCT 
    VALUES (23,’스벅 기프티콘 3만원->2.5만 팜’,’스벅 커피 맛없어서 안가는편이라 팔아요  ‘,25000,,’’);    


INSERT INTO PRODUCT 
    VALUES (24,’ 이케아 조명 팔아여  ,’스마트 조명이라 스마트홈 구축 관심 있으신 분들 문의주세요   ‘,’20000, ,’ ’);    


INSERT INTO PRODUCT 
    VALUES (25,’ 20000MA보조배터리 팔아여 ’ ,’집에 굴러다니는게 너무 많네요 ㅠ 5천원에 팔아여 ‘,5000, , ’ ’);    


INSERT INTO PRODUCT 
    VALUES (26,’목발 팔아요! 병원에서 사면 비쌈  ’,’이제 안써서 저한테 사세여 병원에서 사면 비싸여 ‘,5000, ,’ ’);    


INSERT INTO PRODUCT 
    VALUES (27,’아이맥 21인치 m1 팔아요’ ,’ 맥os가 저랑 안맞아서 팔아요 ㅠ m1 탑재되면서 굉장히 빠르고 이뻐요 ㅎㅎ ‘,1250000, ,’ ’);    


INSERT INTO PRODUCT 
    VALUES (28,’용달) 소파 침대 냉장고 등 옮기기 무거우시죠?,’ 저희 용달에서 최저가로 모시겠습니다. 다마스부터 2.5톤 탑차까지! ‘,30000,,’’);    


INSERT INTO PRODUCT 
    VALUES (29,’가습기 팔아요! ’ ,’ 가습기 튼다고 뭐가 다른지 모르겠어서 팔아요;;  ‘ , 20000, ,’ ’);    


INSERT INTO PRODUCT 
    VALUES (30,’일리 커피 머신 팔아요~,’ 제일 힙하고 맛있는 커피가 일리커피 머신인거 아시죠? 중고 거래 특성상 환불은 어려워요! ‘,80000,,’’);    



    
INSERT INTO PRODUCT 
    VALUES ((SELECT MAX(product_id)+1 FROM product),'미개봉 에어프라이기 팔아요!',' 이사관계로 미개봉 새제품 판매합니다 ㅠㅠ 25일 13시까지만 판매가능 ㅠㅠ ',111111,01023443983,'부산광역시');    
    


SELECT *
FROM PRODUCT P, CLIENT_INFO C , REGION R
WHERE P.CLIENT_ID = C.CLIENT_ID 
AND r.region_id = c.region_id
ORDER BY PRODUCT_ID;
    
    
