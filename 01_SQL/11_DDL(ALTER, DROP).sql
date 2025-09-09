/*
    DDL : 데이터 정의어
        
        <ALTER>
            객체를 변경하는 구문
            기존에 생성된 객체(테이블, 컬럼, 제약조건 등)의 구조를 변경(수정, 추가, 제거, 이름변경 등)에 사용
            
            ALTER 변경할객체 변경할객체이름 변경할내용
            
            ALTER TABLE 테이블명 변경할내용
            
            변경할내용
                1. 컬럼 추가/수정/삭제
                2. 제약조건을 추가/삭제 -> 수정 불가
                3. 컬럼명/제약조건/테이블명 변경
*/

SELECT * FROM DEPARTMENT;

--1-1) 컬럼 추가
--DEPARTMENT에 CNAME 컬럼을 추가
ALTER TABLE DEPARTMENT ADD CNAME VARCHAR2(20);

--LNAME -> 기본값 '한국'
ALTER TABLE DEPARTMENT ADD LNAME VARCHAR2(20) DEFAULT '한국';

--1-2) 컬럼 수정
--데이터 타입 수정 : MODIFY 컬럼명 변경하고자 하는 데이터타입
ALTER TABLE DEPARTMENT MODIFY CNAME VARCHAR2(30); 
ALTER TABLE DEPARTMENT MODIFY LNAME VARCHAR2(30); 

--DEFAULT값 수정 : MODIFY 컬럼명 DEFAULT 변경할 기본값
--LNAME컬럼의 DEFAULT '미국'으로 변경
ALTER TABLE DEPARTMENT MODIFY LNAME DEFAULT '미국';

--다중변경
ALTER TABLE DEPARTMENT
            MODIFY DEPT_TITLE VARCHAR2(40)
            MODIFY LNAME DEFAULT '중국';

--1-3) 컬럼 삭제
--(DROP COLUMN) : 삭제하고자 하는 컬럼
CREATE TABLE DEPT_COPY
AS (SELECT * FROM DEPARTMENT);

ALTER TABLE DEPT_COPY DROP COLUMN DEPT_ID;
ALTER TABLE DEPT_COPY DROP COLUMN CNAME;
ALTER TABLE DEPT_COPY DROP COLUMN LNAME;
ALTER TABLE DEPT_COPY DROP COLUMN DEPT_TITLE;

ALTER TABLE DEPT_COPY DROP COLUMN LOCATION_ID;
--테이블의 모든 열을 삭제할 수 없다. 하나는 반드시 남아있어야 한다.

--------------------------------------------------------------------------------

/*
    2) 제약조건 추가/삭제(수정은 삭제하고 다시 추가하면 수정)
        ALTER TABLE 테이블명 변경할 내용
        
        제약조건 추가방법
        -PRIMARY KEY : ALTER TABLE 테이블명 ADD [CONSTRAINT 제약조건명] PRIMARY KEY(컬럼명);
        -FOREIGN KEY : ALTER TABLE 테이블명 ADD  [CONSTRAINT 제약조건명] FOREIGN KEY(컬럼명) REFERENCES 참조할 테이블명(컬럼명);
        -UNIQUE : ALTER TABLE 테이블명 ADD [CONSTRAINT 제약조건명] UNIQUE(컬럼명);
        -CHECK : ALTER TABLE 테이블명 ADD [CONSTRAINT 제약조건명] CHECK(컬럼에 대한 조건식);
        
        위의 제약조건을 제거하여면
        -ALTER TABLE 테이블명 DROP CONSTRAINT 제약조건이름;
        -NOT NULL : ALTER TABLE 테이블명 MODIFY 컬럼명 NOT NULL;
                    ALTER TABLE 테이블명 MODIFY 컬럼명 NULL;
*/

DROP TABLE DEPT_COPY;
CREATE TABLE DEPT_COPY
AS (SELECT * FROM DEPARTMENT);

--DEPT_ID에 PRIMARY KEY 제약조건 추가
ALTER TABLE DEPT_COPY ADD CONSTRAINT DEPT_PK PRIMARY KEY(DEPT_ID);

--DEPT_TITLE에 UNIQUE 제약조건 추가
--LNAME에 NOT NULL 제약조건 추가
ALTER TABLE DEPT_COPY ADD CONSTRAINT DEPT_TITLE_UQ UNIQUE(DEPT_TITLE)
                        MODIFY LNAME CONSTRAINT DEPT_LNAME_NN NOT NULL;

--위에서 만든 제약조건 삭제
ALTER TABLE DEPT_COPY DROP CONSTRAINT DEPT_PK;

ALTER TABLE DEPT_COPY DROP CONSTRAINT DEPT_TITLE_UQ
                        MODIFY LNAME NULL;

--ALTER문으로 수정하는 이유는 서비스를 하다가 수정하려고 테이블 전체를 변경해버리면 데이터가 사라지기 때문에                        
            
--------------------------------------------------------------------------------

--테이블 삭제
--DROP TABLE 테이블명;
--어딘가에 참조되고 있는 부모테이블은 함부로 삭제가 되지 않는다.
--만약 지우고 싶다면.
--1. 자식테이블의 데이터 또는 테이블 자체를 전붑 삭제
--2. 그냥 부모테이블만 삭제하는데 제약조건까지 삭제
--      DROP TABLE 테이블명 CASCADE CONSTRAINT;

SELECT * FROM DEPT_COPY;

DROP TABLE DEPT_COPY;

CREATE TABLE DEPT_COPY
AS (SELECT * FROM DEPARTMENT);

--3. 1) 컬럼명 변경 : RENAME COLUMN 기존 컬럼명 TO 새로운 컬럼명
--DEPT_TITLE을 DEOT_NAME으로 변경
ALTER TABLE DEPT_COPY RENAME COLUMN DEPT_TITLE TO DEPT_NAME;

--3. 2) 제약조건명 변경 : RENAME CONSTRAINT 기존 제약조건명 TO 새로운 제약조건명
ALTER TABLE DEPT_COPY RENAME CONSTRAINT SYS_C008570 TO DEPT_IN_NN;

--3. 3) 테이블명 변경 : RENAME TO 변경할 테이블명
ALTER TABLE DEPT_COPY RENAME TO DEPT_TEST;

