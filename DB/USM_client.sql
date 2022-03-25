
DROP TABLE CLIENT_INFO;


CREATE TABLE CLIENT_INFO(
    CLIENT_ID NUMBER(13) PRIMARY KEY,                                    -- 전화번호
    CLIENT_PW VARCHAR2(30) NOT NULL,                                     -- 비밀번호
    CLIENT_NAME VARCHAR2(50) NOT NULL,                                   -- 회원명
    REGION_ID VARCHAR2(50) NOT NULL,                                      -- 지역ID
    RELIABILITY NUMBER(3) DEFAULT 0 CHECK(RELIABILITY BETWEEN 0 AND 100) -- 신뢰도 
)
;

INSERT INTO CLIENT_INFO VALUES (01011111111, 'qwer3543@', '코코몽', '서울특별시', 77);
INSERT INTO CLIENT_INFO VALUES (01011111112, 'asdf1234@', '뽀로로', '서울특별시', 87);
INSERT INTO CLIENT_INFO VALUES (01011111113, 'zxcv1234@', '심슨', '대전광역시', 23);
INSERT INTO CLIENT_INFO VALUES (01011111114, 'uiop3543@', '스폰지밥', '서울특별시', 55);
INSERT INTO CLIENT_INFO VALUES (01011111115, 'dfadfhd3@', '앵그리버드', '부산광역시', 11);
INSERT INTO CLIENT_INFO VALUES (01011111116, 'gfagSDF3@', '피카츄', '인천광역시', 88);
INSERT INTO CLIENT_INFO VALUES (01011111117, 'SDFASDG4@', '루피', '경기도', 69);
INSERT INTO CLIENT_INFO VALUES (01011111118, 'wqeqe122@', '라이언', '인천광역시', 90);
INSERT INTO CLIENT_INFO VALUES (01011111119, 'asfagdad@', '도라에몽', '충청도', 100);
INSERT INTO CLIENT_INFO VALUES (01011111110, 'asdsd233@', '마리오', '전라도', 56);
COMMIT;

--> 추가사항 지역별로 회원 9명씩 만들기

-- 1. 충청도 8+1 = 9명
INSERT INTO CLIENT_INFO VALUES (01011111121, 'asfagdad@', '상디', '충청도', 23);
INSERT INTO CLIENT_INFO VALUES (01011111122, 'asfagdad@', '조로', '충청도', 34);
INSERT INTO CLIENT_INFO VALUES (01011111123, 'asfagdad@', '나미', '충청도', 45);
INSERT INTO CLIENT_INFO VALUES (01011111124, 'asfagdad@', '샹크스', '충청도', 65);
INSERT INTO CLIENT_INFO VALUES (01011111125, 'asfagdad@', '오야지', '충청도', 67);
INSERT INTO CLIENT_INFO VALUES (01011111126, 'asfagdad@', '해적왕', '충청도', 78);
INSERT INTO CLIENT_INFO VALUES (01011111127, 'asfagdad@', '쵸파', '충청도', 89);
INSERT INTO CLIENT_INFO VALUES (01011111128, 'asfagdad@', '브룩', '충청도', 23);
-- 2. 제주도 9명
INSERT INTO CLIENT_INFO VALUES (01011111129, 'asfagdad@', 'weqwew', '제주도', 34);
INSERT INTO CLIENT_INFO VALUES (01011111130, 'asfagdad@', 'qwr', '제주도', 23);
INSERT INTO CLIENT_INFO VALUES (01011111131, 'asfagdad@', 'asd', '제주도', 34);
INSERT INTO CLIENT_INFO VALUES (01011111132, 'asfagdad@', 'gds', '제주도', 45);
INSERT INTO CLIENT_INFO VALUES (01011111133, 'asfagdad@', 'sdfF', '제주도', 65);
INSERT INTO CLIENT_INFO VALUES (01011111134, 'asfagdad@', 'sdg', '제주도', 67);
INSERT INTO CLIENT_INFO VALUES (01011111135, 'asfagdad@', 'TYUK', '제주도', 78);
INSERT INTO CLIENT_INFO VALUES (01011111136, 'asfagdad@', 'WTRY', '제주도', 89);
INSERT INTO CLIENT_INFO VALUES (01011111137, 'asfagdad@', 'SGF', '제주도', 23);
-- 3. 전라도 8+1 = 9명
INSERT INTO CLIENT_INFO VALUES (01011111138, 'asfagdad@', '바보', '전라도', 34);
INSERT INTO CLIENT_INFO VALUES (01011111139, 'asfagdad@', '멍청이', '전라도', 23);
INSERT INTO CLIENT_INFO VALUES (01011111140, 'asfagdad@', '나쁜놈', '전라도', 34);
INSERT INTO CLIENT_INFO VALUES (01011111141, 'asfagdad@', '나쁜남자', '전라도', 45);
INSERT INTO CLIENT_INFO VALUES (01011111142, 'asfagdad@', '나란놈', '전라도', 65);
INSERT INTO CLIENT_INFO VALUES (01011111143, 'asfagdad@', '훗', '전라도', 67);
INSERT INTO CLIENT_INFO VALUES (01011111144, 'asfagdad@', '별거아니군', '전라도', 78);
INSERT INTO CLIENT_INFO VALUES (01011111145, 'asfagdad@', '오바마', '전라도', 89);
-- 4. 인천광역시 7+2 = 9명
INSERT INTO CLIENT_INFO VALUES (01011111146, 'asfagdad@', '오늘', '인천광역시', 34);
INSERT INTO CLIENT_INFO VALUES (01011111147, 'asfagdad@', '날씨', '인천광역시', 23);
INSERT INTO CLIENT_INFO VALUES (01011111148, 'asfagdad@', '레전드', '인천광역시', 34);
INSERT INTO CLIENT_INFO VALUES (01011111149, 'asfagdad@', '바람', '인천광역시', 45);
INSERT INTO CLIENT_INFO VALUES (01011111150, 'asfagdad@', '별로', '인천광역시', 65);
INSERT INTO CLIENT_INFO VALUES (01011111151, 'asfagdad@', '햇빛', '인천광역시', 67);
INSERT INTO CLIENT_INFO VALUES (01011111152, 'asfagdad@', '없어', '인천광역시', 78);
-- 5. 울산광역시 9명
INSERT INTO CLIENT_INFO VALUES (01011111153, 'asfagdad@', '아메리카노', '울산광역시', 34);
INSERT INTO CLIENT_INFO VALUES (01011111154, 'asfagdad@', '넘맛있다', '울산광역시', 23);
INSERT INTO CLIENT_INFO VALUES (01011111155, 'asfagdad@', '라때가', '울산광역시', 34);
INSERT INTO CLIENT_INFO VALUES (01011111156, 'asfagdad@', '먹고싶어', '울산광역시', 45);
INSERT INTO CLIENT_INFO VALUES (01011111157, 'asfagdad@', '지금', '울산광역시', 65);
INSERT INTO CLIENT_INFO VALUES (01011111158, 'asfagdad@', '당장', '울산광역시', 67);
INSERT INTO CLIENT_INFO VALUES (01011111159, 'asfagdad@', '돈줄게', '울산광역시', 78);
INSERT INTO CLIENT_INFO VALUES (01011111160, 'asfagdad@', '사줘', '울산광역시', 89);
INSERT INTO CLIENT_INFO VALUES (01011111161, 'asfagdad@', '걍사줘', '울산광역시', 23);
-- 6. 서울특별시 6+3 = 9명
INSERT INTO CLIENT_INFO VALUES (01011111162, 'qwer3543@', '나루토', '서울특별시', 34);
INSERT INTO CLIENT_INFO VALUES (01011111163, 'qwer3543@', '사스케', '서울특별시', 24);
INSERT INTO CLIENT_INFO VALUES (01011111164, 'qwer3543@', '리', '서울특별시', 78);
INSERT INTO CLIENT_INFO VALUES (01011111165, 'qwer3543@', '미나토', '서울특별시', 23);
INSERT INTO CLIENT_INFO VALUES (01011111166, 'qwer3543@', '히나타', '서울특별시', 34);
INSERT INTO CLIENT_INFO VALUES (01011111167, 'qwer3543@', '내지', '서울특별시', 13);
-- 7. 부산광역시 8+1 = 9명
INSERT INTO CLIENT_INFO VALUES (01011111168, 'asfagdad@', '안경', '부산광역시', 34);
INSERT INTO CLIENT_INFO VALUES (01011111169, 'asfagdad@', '기스엄청', '부산광역시', 23);
INSERT INTO CLIENT_INFO VALUES (01011111170, 'asfagdad@', '남사줘', '부산광역시', 34);
INSERT INTO CLIENT_INFO VALUES (01011111171, 'asfagdad@', '십삼만원', '부산광역시', 45);
INSERT INTO CLIENT_INFO VALUES (01011111172, 'asfagdad@', '넘비싸', '부산광역시', 65);
INSERT INTO CLIENT_INFO VALUES (01011111173, 'asfagdad@', '할인해줘', '부산광역시', 67);
INSERT INTO CLIENT_INFO VALUES (01011111174, 'asfagdad@', '훔치고싶다', '부산광역시', 78);
INSERT INTO CLIENT_INFO VALUES (01011111175, 'asfagdad@', '니마음', '부산광역시', 89);
-- 8. 대전광역시 8+1 = 9명
INSERT INTO CLIENT_INFO VALUES (01011111176, 'asfagdad@', '옆에', '대전광역시', 23);
INSERT INTO CLIENT_INFO VALUES (01011111177, 'asfagdad@', '친구는', '대전광역시', 34);
INSERT INTO CLIENT_INFO VALUES (01011111178, 'asfagdad@', '게임하네', '대전광역시', 45);
INSERT INTO CLIENT_INFO VALUES (01011111179, 'asfagdad@', '수업끝나면', '대전광역시', 65);
INSERT INTO CLIENT_INFO VALUES (01011111180, 'asfagdad@', '다인가', '대전광역시', 67);
INSERT INTO CLIENT_INFO VALUES (01011111181, 'asfagdad@', '너무하네', '대전광역시', 78);
INSERT INTO CLIENT_INFO VALUES (01011111182, 'asfagdad@', '피파4', '대전광역시', 89);
INSERT INTO CLIENT_INFO VALUES (01011111183, 'asfagdad@', '부럽다', '대전광역시', 23);
-- 9. 광주광역시 9명
INSERT INTO CLIENT_INFO VALUES (01011111184, 'asfagdad@', '3시20분', '광주광역시', 34);
INSERT INTO CLIENT_INFO VALUES (01011111185, 'asfagdad@', '시간넘빠르다', '광주광역시', 23);
INSERT INTO CLIENT_INFO VALUES (01011111186, 'asfagdad@', '벌써', '광주광역시', 34);
INSERT INTO CLIENT_INFO VALUES (01011111187, 'asfagdad@', '반오십', '광주광역시', 45);
INSERT INTO CLIENT_INFO VALUES (01011111188, 'asfagdad@', '결혼이란', '광주광역시', 65);
INSERT INTO CLIENT_INFO VALUES (01011111189, 'asfagdad@', '무엇인가', '광주광역시', 67);
INSERT INTO CLIENT_INFO VALUES (01011111190, 'asfagdad@', '남자는', '광주광역시', 78);
INSERT INTO CLIENT_INFO VALUES (01011111191, 'asfagdad@', '독고다이', '광주광역시', 89);
INSERT INTO CLIENT_INFO VALUES (01011111192, 'asfagdad@', '가즈아', '광주광역시', 23);
-- 10. 경상도 9명
INSERT INTO CLIENT_INFO VALUES (01011111193, 'asfagdad@', '가나', '경상도', 34);
INSERT INTO CLIENT_INFO VALUES (01011111194, 'asfagdad@', '다라', '경상도', 23);
INSERT INTO CLIENT_INFO VALUES (01011111195, 'asfagdad@', '마바', '경상도', 34);
INSERT INTO CLIENT_INFO VALUES (01011111196, 'asfagdad@', '사아', '경상도', 45);
INSERT INTO CLIENT_INFO VALUES (01011111197, 'asfagdad@', '자카', '경상도', 65);
INSERT INTO CLIENT_INFO VALUES (01011111198, 'asfagdad@', '타파', '경상도', 67);
INSERT INTO CLIENT_INFO VALUES (01011111199, 'asfagdad@', '하하', '경상도', 78);
INSERT INTO CLIENT_INFO VALUES (01011111200, 'asfagdad@', '파이팅', '경상도', 89);
INSERT INTO CLIENT_INFO VALUES (01011111201, 'asfagdad@', '정신차려', '경상도', 23);
-- 11. 경기도 8+1 = 9명
INSERT INTO CLIENT_INFO VALUES (01011111202, 'asfagdad@', '야스오', '경기도', 23);
INSERT INTO CLIENT_INFO VALUES (01011111203, 'asfagdad@', '요네', '경기도', 34);
INSERT INTO CLIENT_INFO VALUES (01011111204, 'asfagdad@', '한조', '경기도', 45);
INSERT INTO CLIENT_INFO VALUES (01011111205, 'asfagdad@', '위도우', '경기도', 65);
INSERT INTO CLIENT_INFO VALUES (01011111206, 'asfagdad@', '볼배', '경기도', 67);
INSERT INTO CLIENT_INFO VALUES (01011111207, 'asfagdad@', '코카콜라', '경기도', 78);
INSERT INTO CLIENT_INFO VALUES (01011111208, 'asfagdad@', '팹시', '경기도', 89);
INSERT INTO CLIENT_INFO VALUES (01011111209, 'asfagdad@', '칠성사이다', '경기도', 23);
-- 12. 강원도 9명
INSERT INTO CLIENT_INFO VALUES (01011111210, 'asfagdad@', '기차', '강원도', 34);
INSERT INTO CLIENT_INFO VALUES (01011111211, 'asfagdad@', '차도', '강원도', 23);
INSERT INTO CLIENT_INFO VALUES (01011111212, 'asfagdad@', '도라지', '강원도', 34);
INSERT INTO CLIENT_INFO VALUES (01011111213, 'asfagdad@', '지리산', '강원도', 45);
INSERT INTO CLIENT_INFO VALUES (01011111214, 'asfagdad@', '산울림', '강원도', 65);
INSERT INTO CLIENT_INFO VALUES (01011111215, 'asfagdad@', '임포스트', '강원도', 67);
INSERT INTO CLIENT_INFO VALUES (01011111216, 'asfagdad@', '트위터', '강원도', 78);
INSERT INTO CLIENT_INFO VALUES (01011111217, 'asfagdad@', '터프니', '강원도', 89);
INSERT INTO CLIENT_INFO VALUES (01011111218, 'asfagdad@', '니얼굴', '강원도', 23);
COMMIT;

SELECT * FROM CLIENT_INFO ORDER BY region_id;