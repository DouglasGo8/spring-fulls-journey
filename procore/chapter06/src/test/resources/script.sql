CREATE TABLE TBL_SINGER (
                            ID 				SERIAL 		NOT NULL,
                            FIRST_NAME		VARCHAR(60)	NOT NULL,
                            LAST_NAME		VARCHAR(40)	NOT NULL,
                            BIRTH_DATE		DATE,
                            UNIQUE(FIRST_NAME, LAST_NAME),
                            PRIMARY KEY (ID)
);
--
CREATE TABLE TBL_ALBUM (
                           ID 			SERIAL 			NOT NULL
    , SINGER_ID 	INT 			NOT NULL
    , TITLE 		VARCHAR(100) 	NOT NULL
    , RELEASE_DATE DATE
    , UNIQUE (SINGER_ID, TITLE)
    , PRIMARY KEY (ID)
    , CONSTRAINT FK_ALBUM FOREIGN KEY (SINGER_ID)
        REFERENCES TBL_SINGER (ID)
);

--

insert into TBL_SINGER (id, first_name, last_name, birth_date) values (1, 'John', 'Mayer', '1977-10-16');
insert into TBL_SINGER (id, first_name, last_name, birth_date) values (2, 'Ben', 'Barnes', '1981-08-20');
insert into TBL_SINGER (id, first_name, last_name, birth_date) values (3, 'John', 'Butler', '1975-04-01');
--

insert into TBL_ALBUM (id, singer_id, title, release_date) values (1, 1, 'The Search For Everything', '2017-01-20');
insert into TBL_ALBUM (id, singer_id, title, release_date) values (2, 1, 'Battle Studies', '2009-11-17');
insert into TBL_ALBUM (id, singer_id, title, release_date) values (3, 2, ' 11:11 ', '2021-09-18');

--
/* view the inserted data */
SELECT * FROM TBL_SINGER;
SELECT * FROM TBL_ALBUM;

--
/* simple join sample */
SELECT * FROM TBL_ALBUM A inner join TBL_SINGER S on SINGER_ID = S.ID WHERE S.ID=1;


