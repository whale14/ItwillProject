
DROP TABLE CLIENT_INFO;


CREATE TABLE CLIENT_INFO(
    CLIENT_ID NUMBER(13) PRIMARY KEY,                                    -- 전화번호
    CLIENT_PW VARCHAR2(30) NOT NULL,                                     -- 비밀번호
    CLIENT_NAME VARCHAR2(50) NOT NULL,                                   -- 회원명
    REGION_ID VARCHAR2(50) NOT NULL,                                      -- 지역ID
    RELIABILITY NUMBER(3) DEFAULT 0 CHECK(RELIABILITY BETWEEN 0 AND 100) -- 신뢰도 
)
;

INSERT INTO CLIENT_INFO VALUES (01080003983, 'qwer3543@', '코코몽', '서울특별시', 77);
INSERT INTO CLIENT_INFO VALUES (01077773983, 'asdf1234@', '뽀로로', '서울특별시', 87);
INSERT INTO CLIENT_INFO VALUES (01099993983, 'zxcv1234@', '심슨', '대전광역시', 23);
INSERT INTO CLIENT_INFO VALUES (01054363983, 'uiop3543@', '스폰지밥', '서울특별시', 55);
INSERT INTO CLIENT_INFO VALUES (01023443983, 'dfadfhd3@', '앵그리버드', '부산광역시', 11);
INSERT INTO CLIENT_INFO VALUES (01012345678, 'gfagSDF3@', '피카츄', '인천광역시', 88);
INSERT INTO CLIENT_INFO VALUES (01076745663, 'SDFASDG4@', '루피', '경기도', 69);
INSERT INTO CLIENT_INFO VALUES (01099345345, 'wqeqe122@', '라이언', '인천광역시', 90);
INSERT INTO CLIENT_INFO VALUES (01052342343, 'asfagdad@', '도라에몽', '충청도', 100);
INSERT INTO CLIENT_INFO VALUES (01020077673, 'asdsd233@', '마리오', '전라도', 56);
COMMIT;

--> 추가사항 지역별로 회원 9명씩 만들기

-- 1. 충청도 8+1 = 9명
INSERT INTO CLIENT_INFO VALUES (02152123343, 'asfagdad@', '상디', '충청도', 23);
INSERT INTO CLIENT_INFO VALUES (02252123343, 'asfagdad@', '조로', '충청도', 34);
INSERT INTO CLIENT_INFO VALUES (02352342123, 'asfagdad@', '나미', '충청도', 45);
INSERT INTO CLIENT_INFO VALUES (02452342343, 'asfagdad@', '샹크스', '충청도', 65);
INSERT INTO CLIENT_INFO VALUES (02551232343, 'asfagdad@', '오야지', '충청도', 67);
INSERT INTO CLIENT_INFO VALUES (02651234513, 'asfagdad@', '해적왕', '충청도', 78);
INSERT INTO CLIENT_INFO VALUES (02752341233, 'asfagdad@', '쵸파', '충청도', 89);
INSERT INTO CLIENT_INFO VALUES (02852342343, 'asfagdad@', '브룩', '충청도', 23);
-- 2. 제주도 9명
INSERT INTO CLIENT_INFO VALUES (03951233343, 'asfagdad@', 'weqwew', '제주도', 34);
INSERT INTO CLIENT_INFO VALUES (03152123343, 'asfagdad@', 'qwr', '제주도', 23);
INSERT INTO CLIENT_INFO VALUES (03252123343, 'asfagdad@', 'asd', '제주도', 34);
INSERT INTO CLIENT_INFO VALUES (03352342123, 'asfagdad@', 'gds', '제주도', 45);
INSERT INTO CLIENT_INFO VALUES (03452342343, 'asfagdad@', 'sdfF', '제주도', 65);
INSERT INTO CLIENT_INFO VALUES (03551232343, 'asfagdad@', 'sdg', '제주도', 67);
INSERT INTO CLIENT_INFO VALUES (03651234513, 'asfagdad@', 'TYUK', '제주도', 78);
INSERT INTO CLIENT_INFO VALUES (03752341233, 'asfagdad@', 'WTRY', '제주도', 89);
INSERT INTO CLIENT_INFO VALUES (03852342343, 'asfagdad@', 'SGF', '제주도', 23);
-- 3. 전라도 8+1 = 9명
INSERT INTO CLIENT_INFO VALUES (04951233343, 'asfagdad@', '바보', '전라도', 34);
INSERT INTO CLIENT_INFO VALUES (04152123343, 'asfagdad@', '멍청이', '전라도', 23);
INSERT INTO CLIENT_INFO VALUES (04252123343, 'asfagdad@', '나쁜놈', '전라도', 34);
INSERT INTO CLIENT_INFO VALUES (04352342123, 'asfagdad@', '나쁜남자', '전라도', 45);
INSERT INTO CLIENT_INFO VALUES (04452342343, 'asfagdad@', '나란놈', '전라도', 65);
INSERT INTO CLIENT_INFO VALUES (04551232343, 'asfagdad@', '훗', '전라도', 67);
INSERT INTO CLIENT_INFO VALUES (04651234513, 'asfagdad@', '별거아니군', '전라도', 78);
INSERT INTO CLIENT_INFO VALUES (04752341233, 'asfagdad@', '오바마', '전라도', 89);
-- 4. 인천광역시 7+2 = 9명
INSERT INTO CLIENT_INFO VALUES (05951233343, 'asfagdad@', '오늘', '인천광역시', 34);
INSERT INTO CLIENT_INFO VALUES (05152123343, 'asfagdad@', '날씨', '인천광역시', 23);
INSERT INTO CLIENT_INFO VALUES (05252123343, 'asfagdad@', '레전드', '인천광역시', 34);
INSERT INTO CLIENT_INFO VALUES (05352342123, 'asfagdad@', '바람', '인천광역시', 45);
INSERT INTO CLIENT_INFO VALUES (05452342343, 'asfagdad@', '별로', '인천광역시', 65);
INSERT INTO CLIENT_INFO VALUES (05551232343, 'asfagdad@', '햇빛', '인천광역시', 67);
INSERT INTO CLIENT_INFO VALUES (05651234513, 'asfagdad@', '없어', '인천광역시', 78);
-- 5. 울산광역시 9명
INSERT INTO CLIENT_INFO VALUES (06951233343, 'asfagdad@', '아메리카노', '울산광역시', 34);
INSERT INTO CLIENT_INFO VALUES (06152123343, 'asfagdad@', '넘맛있다', '울산광역시', 23);
INSERT INTO CLIENT_INFO VALUES (06252123343, 'asfagdad@', '라때가', '울산광역시', 34);
INSERT INTO CLIENT_INFO VALUES (06352342123, 'asfagdad@', '먹고싶어', '울산광역시', 45);
INSERT INTO CLIENT_INFO VALUES (06452342343, 'asfagdad@', '지금', '울산광역시', 65);
INSERT INTO CLIENT_INFO VALUES (06551232343, 'asfagdad@', '당장', '울산광역시', 67);
INSERT INTO CLIENT_INFO VALUES (06651234513, 'asfagdad@', '돈줄게', '울산광역시', 78);
INSERT INTO CLIENT_INFO VALUES (06752341233, 'asfagdad@', '사줘', '울산광역시', 89);
INSERT INTO CLIENT_INFO VALUES (06852342343, 'asfagdad@', '걍사줘', '울산광역시', 23);
-- 6. 서울특별시 6+3 = 9명
INSERT INTO CLIENT_INFO VALUES (01012343983, 'qwer3543@', '나루토', '서울특별시', 34);
INSERT INTO CLIENT_INFO VALUES (01021332321, 'qwer3543@', '사스케', '서울특별시', 24);
INSERT INTO CLIENT_INFO VALUES (01098797893, 'qwer3543@', '리', '서울특별시', 78);
INSERT INTO CLIENT_INFO VALUES (01081233313, 'qwer3543@', '미나토', '서울특별시', 23);
INSERT INTO CLIENT_INFO VALUES (01087869553, 'qwer3543@', '히나타', '서울특별시', 34);
INSERT INTO CLIENT_INFO VALUES (01085967483, 'qwer3543@', '내지', '서울특별시', 13);
-- 7. 부산광역시 8+1 = 9명
INSERT INTO CLIENT_INFO VALUES (07951233343, 'asfagdad@', '안경', '부산광역시', 34);
INSERT INTO CLIENT_INFO VALUES (07752123343, 'asfagdad@', '기스엄청', '부산광역시', 23);
INSERT INTO CLIENT_INFO VALUES (07252123343, 'asfagdad@', '남사줘', '부산광역시', 34);
INSERT INTO CLIENT_INFO VALUES (07352342123, 'asfagdad@', '십삼만원', '부산광역시', 45);
INSERT INTO CLIENT_INFO VALUES (07452342343, 'asfagdad@', '넘비싸', '부산광역시', 65);
INSERT INTO CLIENT_INFO VALUES (07551232343, 'asfagdad@', '할인해줘', '부산광역시', 67);
INSERT INTO CLIENT_INFO VALUES (07651234513, 'asfagdad@', '훔치고싶다', '부산광역시', 78);
INSERT INTO CLIENT_INFO VALUES (07752341233, 'asfagdad@', '니마음', '부산광역시', 89);
-- 8. 대전광역시 8+1 = 9명
INSERT INTO CLIENT_INFO VALUES (08152123343, 'asfagdad@', '옆에', '대전광역시', 23);
INSERT INTO CLIENT_INFO VALUES (08252123343, 'asfagdad@', '친구는', '대전광역시', 34);
INSERT INTO CLIENT_INFO VALUES (08352342123, 'asfagdad@', '게임하네', '대전광역시', 45);
INSERT INTO CLIENT_INFO VALUES (08452342343, 'asfagdad@', '수업끝나면', '대전광역시', 65);
INSERT INTO CLIENT_INFO VALUES (08551232343, 'asfagdad@', '다인가', '대전광역시', 67);
INSERT INTO CLIENT_INFO VALUES (08651234513, 'asfagdad@', '너무하네', '대전광역시', 78);
INSERT INTO CLIENT_INFO VALUES (08752341233, 'asfagdad@', '피파4', '대전광역시', 89);
INSERT INTO CLIENT_INFO VALUES (08852342343, 'asfagdad@', '부럽다', '대전광역시', 23);
-- 9. 광주광역시 9명
INSERT INTO CLIENT_INFO VALUES (09951233343, 'asfagdad@', '3시20분', '광주광역시', 34);
INSERT INTO CLIENT_INFO VALUES (09152123343, 'asfagdad@', '시간넘빠르다', '광주광역시', 23);
INSERT INTO CLIENT_INFO VALUES (09252123343, 'asfagdad@', '벌써', '광주광역시', 34);
INSERT INTO CLIENT_INFO VALUES (09352342123, 'asfagdad@', '반오십', '광주광역시', 45);
INSERT INTO CLIENT_INFO VALUES (09452342343, 'asfagdad@', '결혼이란', '광주광역시', 65);
INSERT INTO CLIENT_INFO VALUES (09551232343, 'asfagdad@', '무엇인가', '광주광역시', 67);
INSERT INTO CLIENT_INFO VALUES (09651234513, 'asfagdad@', '남자는', '광주광역시', 78);
INSERT INTO CLIENT_INFO VALUES (09752341233, 'asfagdad@', '독고다이', '광주광역시', 89);
INSERT INTO CLIENT_INFO VALUES (09852342343, 'asfagdad@', '가즈아', '광주광역시', 23);
-- 10. 경상도 9명
INSERT INTO CLIENT_INFO VALUES (09121233343, 'asfagdad@', '가나', '경상도', 34);
INSERT INTO CLIENT_INFO VALUES (09132123343, 'asfagdad@', '다라', '경상도', 23);
INSERT INTO CLIENT_INFO VALUES (09142123343, 'asfagdad@', '마바', '경상도', 34);
INSERT INTO CLIENT_INFO VALUES (09162342123, 'asfagdad@', '사아', '경상도', 45);
INSERT INTO CLIENT_INFO VALUES (09172342343, 'asfagdad@', '자카', '경상도', 65);
INSERT INTO CLIENT_INFO VALUES (09181232343, 'asfagdad@', '타파', '경상도', 67);
INSERT INTO CLIENT_INFO VALUES (09191234513, 'asfagdad@', '하하', '경상도', 78);
INSERT INTO CLIENT_INFO VALUES (09202341233, 'asfagdad@', '파이팅', '경상도', 89);
INSERT INTO CLIENT_INFO VALUES (09212342343, 'asfagdad@', '정신차려', '경상도', 23);
-- 11. 경기도 8+1 = 9명
INSERT INTO CLIENT_INFO VALUES (08112123343, 'asfagdad@', '야스오', '경기도', 23);
INSERT INTO CLIENT_INFO VALUES (08122123343, 'asfagdad@', '요네', '경기도', 34);
INSERT INTO CLIENT_INFO VALUES (08132342123, 'asfagdad@', '한조', '경기도', 45);
INSERT INTO CLIENT_INFO VALUES (08142342343, 'asfagdad@', '위도우', '경기도', 65);
INSERT INTO CLIENT_INFO VALUES (08151232343, 'asfagdad@', '볼배', '경기도', 67);
INSERT INTO CLIENT_INFO VALUES (08161234513, 'asfagdad@', '코카콜라', '경기도', 78);
INSERT INTO CLIENT_INFO VALUES (08172341233, 'asfagdad@', '팹시', '경기도', 89);
INSERT INTO CLIENT_INFO VALUES (08182342343, 'asfagdad@', '칠성사이다', '경기도', 23);
-- 12. 강원도 9명
INSERT INTO CLIENT_INFO VALUES (0312233343, 'asfagdad@', '기차', '강원도', 34);
INSERT INTO CLIENT_INFO VALUES (03412123343, 'asfagdad@', '차도', '강원도', 23);
INSERT INTO CLIENT_INFO VALUES (03522123343, 'asfagdad@', '도라지', '강원도', 34);
INSERT INTO CLIENT_INFO VALUES (03762342123, 'asfagdad@', '지리산', '강원도', 45);
INSERT INTO CLIENT_INFO VALUES (03782342343, 'asfagdad@', '산울림', '강원도', 65);
INSERT INTO CLIENT_INFO VALUES (03541232343, 'asfagdad@', '임포스트', '강원도', 67);
INSERT INTO CLIENT_INFO VALUES (03331234513, 'asfagdad@', '트위터', '강원도', 78);
INSERT INTO CLIENT_INFO VALUES (03333331233, 'asfagdad@', '터프니', '강원도', 89);
INSERT INTO CLIENT_INFO VALUES (03454533343, 'asfagdad@', '니얼굴', '강원도', 23);
COMMIT;

SELECT * FROM CLIENT_INFO ORDER BY region_id;