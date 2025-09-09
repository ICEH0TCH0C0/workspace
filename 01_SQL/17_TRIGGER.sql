/*
    <트리거>
        특정 테이블에 대해 INSERT, UPDATE, DELETE와 같은 DML이벤트가 발생했을 때 
            자동으로 실행되는 PL/SQL코드 블록이다.
            
        EX)- 회원 탈퇴시 기존의 회원테이블에 데이터를 DELETE하기전에 항상 탈퇴한 회원들을
                저장하는 테이블에 INSERT 시켜줘야 한다.
           - 신고횟수가 일정 수를 넘었을 때 묵시적으로 해당 회원을 블랙리스트 목록에 
                추가해야할 때.
        
        트리거 특징
            사용자가 명시적으로 실행하지 않아도 자동 실행
            데이터 무결성, 로깅, 자동처리 등에 유용
            테이블 단위로 작성되며, 트리거 대상은 테이블.
        
        트리거 분류
            시점(안제 실행되냐?)
                BEFORE TRIGGER : 내가 지정한 테이블에 DML 이벤트가 실행되기 전에 동작
                AFTER TRIGGER : 내가 지정한 테이블에 DML 이벤트가 실행된 직후에 동작
            적용대상(어디에 적용하는가)
                문장 트리거 : 이벤트가 발생한 SQL문에 대해 딱 한번만 트리거 실행
                                (FOR EACH ROW 없음)
                행 트리거 : 이벤트가 적용된 각 행마다 실행(FOR EACH ROW 필요)
                            행 트리거에서는 변경 전/후 데이터를 참조 가능
                                :OLD : 기존 행 데이터
                                :NEW : 새로 들어오는 데이터
            [트리거 생성 표현법]
                CREATE [OR REPLACE] TRIGGER 트리거명
                BEFORE | AFTER  INSERT | UPDATE | DELETE
                ON 테이블명
                [FOR EACH ROW]  -- 행 트리거일 경우 표식
                [DECLARE 변수 선언]
                BEGIN
                    실행할 내용
                [EXCEPTION ...] --예외처리 가능
                END;
                /
*/

SET SERVEROUTPUT ON;

--EMPLOYEE 테이블에 새로운 행이 추가될 때마다 자동으로 '신입사원님 안녕하세요' 출력
CREATE OR REPLACE TRIGGER TRG_01
AFTER INSERT 
ON EMPLOYEE
BEGIN
    DBMS_OUTPUT.PUT_LINE('신입사원님 안녕하세요');
END;
/

INSERT INTO EMPLOYEE(EMP_ID, EMP_NAME, EMP_NO, JOB_CODE)
VALUES(301, '정원', '111111-2222222', 'J7');

--------------------------------------------------------------------------------
--입출고에 대한 데이터 기록(INSERT) 될때마다 해당 상품에 대한 재고수령을 매번 수정(UPDATE)
-- 상품테이블(재고), 입출고기록테이블

--1. 상품에대한 데이터를 보관할 상품 데이터(TB_PRDT)
CREATE TABLE TB_PRDT(
    PCODE NUMBER PRIMARY KEY,
    PNAME VARCHAR2(30) NOT NULL,
    BRAND VARCHAR2(30) NOT NULL,
    PRICE NUMBER,
    STOCK NUMBER DEFAULT 0
);

CREATE SEQUENCE SEQ_PCODE
START WITH 200
INCREMENT BY 5;

INSERT INTO TB_PRDT VALUES(SEQ_PCODE.NEXTVAL, '갤럭시폴드7', '삼성', 2200000, DEFAULT);
INSERT INTO TB_PRDT VALUES(SEQ_PCODE.NEXTVAL, '갤럭시S25', '삼성', 1400000, DEFAULT);
INSERT INTO TB_PRDT VALUES(SEQ_PCODE.NEXTVAL, '아이폰16', '애플',1600000, DEFAULT);

--2. 상품 입출고 상세 이력 테이블 생성(TB_PRODETAIL)
--어떤 상품이 어떤 날짜에 몇개가 입/출고 되는지 기록
CREATE TABLE TB_PRODETAIL(
    DECODE NUMBER PRIMARY KEY,
    PCODE NUMBER REFERENCES TB_PRDT,
    PDATE DATE NOT NULL,
    AMOUNT NUMBER NOT NULL,
    STATUS CHAR(3) CHECK(STATUS IN ('IN', 'OUT'))
);

CREATE SEQUENCE SEQ_DECODE;

--200번 상품이 오늘 날짜 10개 입고
INSERT INTO TB_PRODETAIL
VALUES(SEQ_DECODE.NEXTVAL, 200, SYSDATE, 10, 'IN');

--200번 상품의 재고수량이 10증가
UPDATE TB_PRDT
SET STOCK = STOCK + 10
WHERE PCODE = 200;

COMMIT;

--205번 상품이 오늘 날짜 20개 입고
INSERT INTO TB_PRODETAIL
VALUES(SEQ_DECODE.NEXTVAL, 205, SYSDATE, 20, 'IN');

--205번 상품의 재고수량이 20증가
UPDATE TB_PRDT
SET STOCK = STOCK + 20
WHERE PCODE = 205;



--TB_PRODETAIL테이블에 INSERT이벤트 발생시
--TB_PRDT 테이블에 매번 자동으로 재고수량을 UPDATE하는 트리거

/*
    상품이 입고(IN) -> 해당 상품을 찾아서 재고 수량을 증가 UPDATE
    UPDATE TB_PRDT
    SET STOCK = STOCK + (INSERT된 자료의 AMOUNT)
    WHERE PCODE = (INSERT된 자료의 PCODE);
    
    상품이 출고(OUT) -> 해당 상품을 찾아서 재고 수량을 감소 UPDATE
    UPDATE TB_PRDT
    SET STOCK = STOCK - (INSERT된 자료의 AMOUNT)
    WHERE PCODE = (INSERT된 자료의 PCODE);
*/
DROP TRIGGER TRG_02;
CREATE OR REPLACE TRIGGER TRG_02
AFTER INSERT ON TB_PRODETAIL
FOR EACH ROW -- 행의 데이터를 그대로 가져올 때
BEGIN
    IF(:NEW.STATUS = 'IN') THEN
        UPDATE TB_PRDT
        SET STOCK = STOCK + :NEW.AMOUNT
        WHERE PCODE = :NEW.PCODE;
    ELSE
        UPDATE TB_PRDT
        SET STOCK = STOCK - :NEW.AMOUNT
        WHERE PCODE = :NEW.PCODE;
    END IF;
END;
/

--210번 상품이 오늘날짜로 7개 입고
INSERT INTO TB_PRODETAIL
VALUES(SEQ_DECODE.NEXTVAL, 210, SYSDATE, 7, 'IN');

--205번 상품이 오늘날짜로 5개 출고
INSERT INTO TB_PRODETAIL
VALUES(SEQ_DECODE.NEXTVAL, 205, SYSDATE, 5, 'OUT');

--------------------------------------------------------------------------------
--응용
--210번 상품의 수량을 10만큼 증가
UPDATE TB_PRDT
SET STOCK = STOCK + 10
WHERE PCODE = '210';

--210번 상품의 수량을 10만큼 감소
UPDATE TB_PRDT
SET STOCK = STOCK - 10
WHERE PCODE = '210';

--210번 상품의 STOCK 값이 증가할 경우, TB_PRODETAIL에 이력이 남는 트리거.
DROP TRIGGER TRG_03;
CREATE OR REPLACE TRIGGER TRG_03
AFTER UPDATE
ON TB_PRDT
FOR EACH ROW
BEGIN 
    IF :OLD.STOCK < :NEW.STOCK THEN
        INSERT INTO TB_PRODETAIL
        VALUES(SEQ_DECODE.NEXTVAL, 210, SYSDATE, :NEW.STOCK - :OLD.STOCK, 'IN');
    ELSE 
        INSERT INTO TB_PRODETAIL
        VALUES(SEQ_DECODE.NEXTVAL, 210, SYSDATE, ABS(:OLD.STOCK - :NEW.STOCK), 'OUT');
    END IF;
END;
/
