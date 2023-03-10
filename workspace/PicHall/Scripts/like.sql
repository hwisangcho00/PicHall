DROP TABLE TBL_LIKE;

CREATE TABLE TBL_LIKE
(
    MEMBER_SEQ        INT    NOT NULL, 
    EXHIBITION_SEQ    INT    NOT NULL
);

ALTER TABLE TBL_LIKE
    ADD CONSTRAINT FK_TBL_LIKE_EXHIBITION_SEQ_TBL FOREIGN KEY (EXHIBITION_SEQ)
        REFERENCES TBL_EXHIBITION (EXHIBITION_SEQ);
        
SELECT * FROM TBL_LIKE;

TRUNCATE TABLE TBL_LIKE 

INSERT INTO TBL_LIKE
(MEMBER_SEQ, EXHIBITION_SEQ)
VALUES(25, 48);

INSERT INTO TBL_LIKE
(MEMBER_SEQ, EXHIBITION_SEQ)
VALUES(2, 48);

INSERT INTO TBL_LIKE
(MEMBER_SEQ, EXHIBITION_SEQ)
VALUES(13, 48);

INSERT INTO TBL_LIKE
(MEMBER_SEQ, EXHIBITION_SEQ)
VALUES(13, 44);

/*12.27추가-트리거 제거 해야함 */
SELECT * FROM ALL_TRIGGERS;

DROP TRIGGER TBL_LIKE_AI_TRG;

/*12.30 테스트*/
SELECT COUNT(EXHIBITION_SEQ) FROM TBL_LIKE WHERE EXHIBITION_SEQ=48 

SELECT COUNT(EXHIBITION_SEQ) FROM TBL_LIKE WHERE EXHIBITION_SEQ=44