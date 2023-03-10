CREATE TABLE TBL_COMMENT(
	COMMENT_SEQ INT,
	BOARD_SEQ INT,
	COMMENT_TEXT VARCHAR(1000),
	COMMENT_DATE DATE,
	CONSTRAINT TBL_COMMENT_PK PRIMARY KEY(COMMENT_SEQ),
	CONSTRAINT TBL_COMMENT_BOARD_SEQ_FK FOREIGN KEY(BOARD_SEQ) REFERENCES TBL_BOARD(BOARD_SEQ)
);

CREATE SEQUENCE TBL_COMMENT_SEQ
START WITH 1
INCREMENT BY 1
MINVALUE 1
MAXVALUE 10000;

ALTER TABLE TBL_COMMENT ADD MEMBER_SEQ INT;

ALTER TABLE TBL_COMMENT ADD CONSTRAINT TBL_COMMENT_MEMBER_SEQ_FK FOREIGN KEY(MEMBER_SEQ) REFERENCES TBL_MEMBER(MEMBER_SEQ);

SELECT * FROM TBL_COMMENT;