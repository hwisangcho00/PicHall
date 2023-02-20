DROP TABLE TBL_MUSIC;

CREATE TABLE TBL_MUSIC(
	MUSIC_SEQ INT,
	MUSIC_TITLE VARCHAR2(50),
	MUSIC_ARTIST VARCHAR2(4000),
	MUSIC_DATA VARCHAR2(50),
	MEMBER_SEQ INT,
	CONSTRAINT TBL_MUSIC_PK PRIMARY KEY(MUSIC_SEQ),
	CONSTRAINT TBL_MUSIC_MEMBER_SEQ_FK FOREIGN KEY(MEMBER_SEQ) REFERENCES TBL_MEMBER(MEMBER_SEQ)
);

ALTER TABLE TBL_MUSIC MODIFY(MUSIC_DATA VARCHAR2(4000));

CREATE SEQUENCE TBL_MUSIC_SEQ
START WITH 1
INCREMENT BY 1
MINVALUE 1
MAXVALUE 1000;

SELECT * FROM TBL_MUSIC
