
CREATE TABLE CLIENT_INFO(
    CLIENT_ID NUMBER(13) PRIMARY KEY,                                    -- 전화번호
    CLIENT_PW VARCHAR2(30) NOT NULL,                                     -- 비밀번호
    CLIENT_NAME VARCHAR2(50) NOT NULL,                                   -- 회원명
    REGIN_ID VARCHAR2(50) NOT NULL,                                      -- 지역ID
    RELIABLIITY NUMBER(3) DEFAULT 0 CHECK(RELIABLIITY BETWEEN 0 AND 100) -- 신뢰도 
)
;


CREATE TABLE REGION(
    REGION_ID VARCHAR2(50) PRIMARY KEY,  -- 지역ID
    REGION_NAME VARCHAR2(50) NOT NULL   -- 지역명
)
;


CREATE TABLE PRODUCT(
    PRODUCT_ID NUMBER(10) PRIMARY KEY,  -- 상품ID
    PRODUCT_NAME VARCHAR2(50) NOT NULL, -- 상품명
    PRODUCT_DESCRIPTION VARCHAR(200),   -- 상품설명
    CLIENT_ID NUMBER(13) NOT NULL,      -- 회원ID
    REGION_ID VARCHAR2(50) NOT NULL,    -- 지역ID
    PRICE NUMBER(9) NOT NULL            -- 가격
)
;

