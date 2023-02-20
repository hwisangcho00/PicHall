CREATE TABLE TBL_MUSIC_EXHIBITION(
	MUSIC_SEQ INT,
	EXHIBITION_SEQ INT,
	CONSTRAINT TBL_MUSIC_EX_MUSIC_SEQ_FK FOREIGN KEY(MUSIC_SEQ) REFERENCES TBL_MUSIC(MUSIC_SEQ),
	CONSTRAINT TBL_MUSIC_EX_EX_SEQ_FK FOREIGN KEY(EXHIBITION_SEQ) REFERENCES TBL_EXHIBITION(EXHIBITION_SEQ)
)

SELECT * FROM TBL_MUSIC_EXHIBITION

TRUNCATE TABLE TBL_MUSIC_EXHIBITION;