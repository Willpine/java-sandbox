INSERT INTO USER (USER_NAME,USER_NICKNAME, USER_PASSWORD, USER_REGISTRATION_DATE) VALUES ('willpine','APELIDOWILL','$2a$10$TNl6vXAtYyAnT5kX9IZmfe34b2DEDe2Qfbx9aledgzwBse9Lh1fwG','2000-09-19');
INSERT INTO ROLE(ROLE_ID) VALUES ('ROLE_ADMIN');
INSERT INTO ROLE(ROLE_ID) VALUES ('ROLE_USER');
INSERT INTO USER (USER_NAME,USER_NICKNAME, USER_PASSWORD, USER_REGISTRATION_DATE) VALUES ('wine','APELIDOWINE','$2a$10$TNl6vXAtYyAnT5kX9IZmfe34b2DEDe2Qfbx9aledgzwBse9Lh1fwG','2005-09-19');
INSERT INTO USER_ROLES VALUES ('willpine','ROLE_ADMIN');
INSERT INTO USER_ROLES VALUES ('wine','ROLE_USER');
-- DROP TABLE COMMENT;
-- drop table DRAWING;
-- DROP TABLE USER;

-- CREATE TABLE `USER` (
--   `USER_NAME` varchar(20) NOT NULL,
--   `USER_PASSWORD` varchar(70) NOT NULL,
--   `USER_REGISTRATION_DATE` date NOT NULL,
--   `USER_ID` bigint(20) NOT NULL auto_increment,
--   PRIMARY KEY (`USER_ID`)
-- );

-- CREATE TABLE `DRAWING` (
--   `DRAWING_ID` bigint(20) NOT NULL auto_increment,
--   `NAME` varchar(30) NOT NULL,
--   `IMAGE` longblob NOT NULL,
--   `LIKES` int(11) NOT NULL DEFAULT 0,
--   `DISLIKES` int(11) NOT NULL DEFAULT 0,
--   `DT_POSTED` date NOT NULL,
--   `MY_COMMENT` varchar(300) DEFAULT NULL,
--   PRIMARY KEY (`DRAWING_ID`)
-- );

-- CREATE TABLE `COMMENT` (
--   `COMMENT_ID` bigint(20) NOT NULL auto_increment,
--   `TEXT` varchar(150) NOT NULL,
--   `DT_PUBLISHED` date NOT NULL,
--   `DT_EDITED` date DEFAULT NULL,
--   `LIKES` int(10) NOT NULL DEFAULT 0,
--   `DISLIKES` int(10) NOT NULL DEFAULT 0,
--   `USER_ID` bigint(20) NOT NULL,
--   `DRAWING_ID` bigint(20) NOT NULL,
--   PRIMARY KEY (`COMMENT_ID`),
--   CONSTRAINT `FK_DRAWING_ID` FOREIGN KEY (`DRAWING_ID`) REFERENCES `DRAWING` (`DRAWING_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
--   CONSTRAINT `FK_USER_ID` FOREIGN KEY (`USER_ID`) REFERENCES `USER` (`USER_ID`) ON DELETE CASCADE ON UPDATE CASCADE
-- );



--COMMIT;