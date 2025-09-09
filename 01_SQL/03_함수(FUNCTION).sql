SELECT LENGTH('오라클'), LENGTHB('오라클')
FROM DUAL;

----------------------------------------------------------------------------
/*
    INSTR
        문자열로부터 특정 문자의 시작위치를 찾아서 반환
        
        INSTR(컬럼 | '문자열', '찾고자하는 문자', ['찾을 위치의 기작값, 순번'])
            -> 결과는 NUMBER
*/
SELECT INSTR('AAABBCAAABBC', 'B') FROM DUAL;
-- 찾을 위치의 시작 값: 1, 순번 : 1 -> 기본값
SELECT INSTR('AAABBCAAABBC', 'B', 1) FROM DUAL;

SELECT INSTR('AAABBCAAABBC', 'B', -1) FROM DUAL;

SELECT INSTR('AAABBCAAABBC', 'B', 1, 2) FROM DUAL; 

SELECT EMAIL, INSTR(EMAIL, '@') AS "@위치"
FROM EMPLOYEE;

/*
    SUBSTR
        문자열에서 특정 문자열을 추출해서 반환
        
        [표현법]
        SUBSTR(컬럼 | '문자열', 추출 시작위치, [추출문자 갯수])
        
*/

SELECT SUBSTR('SHOWMETHEMONEY', 7 ) FROM DUAL;
-- 7번위치부터 끝까지
SELECT SUBSTR('SHOWMETHEMONEY', 5, 2 ) FROM DUAL;

SELECT SUBSTR('SHOWMETHEMONEY', 1, 6 ) FROM DUAL;

SELECT SUBSTR('SHOWMETHEMONEY', -8, 3 ) FROM DUAL;

SELECT EMP_NAME, EMP_NO, SUBSTR(EMP_NO, 8, 1) AS 성별
FROM EMPLOYEE;

-- 사원들 중 여자 사원들만 EMP_NAME, EMP_NO을 조회
SELECT EMP_NAME, EMP_NO
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO, 8, 1) IN ('2', '4');

-- 사원들 중 남자 사원들만 EMP_NAME, EMP_NO을 조회
SELECT EMP_NAME, EMP_NO
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO, 8, 1) IN ('1', '3');

-- 함수는 중첩 사용 가능
-- 이메일의 아이디 부분만 추출
SELECT EMP_NAME, EMAIL, SUBSTR(EMAIL, 1, INSTR(EMAIL, '@') -1)
FROM EMPLOYEE;

--------------------------------------------------------------------------------------
/*
    LPAD / RPAD
        문자열을 조회할 때 통일감있게 조회하고자 정렬을 하는 함수
        
        [표현법]
        LPAD/RPAD(문자열, 최종적으로 반환할 문자열의 길이, [덧붙이고자하는 문자])
        
    
*/
-- 30만큼의 길이 중 EMAIL 컬럼 값은 오른쪽으로 정렬하고 나머지 부분은 공백으로 채운다.
SELECT EMP_NAME, LPAD(EMAIL, 30)
FROM EMPLOYEE;

SELECT EMP_NAME, LPAD(EMAIL, 30, '#')
FROM EMPLOYEE;

SELECT EMP_NAME, RPAD(EMAIL, 30, '#')
FROM EMPLOYEE;

-- 사원들의 사원명, 주민등록번호("123456-1XXXXXX")
SELECT EMP_NAME, RPAD(SUBSTR(EMP_NO, 1, 8), 14, 'X')
--SELECT EMP_NAME, SUBSTR(EMP_NO, 1, 8) || 'XXXXXX'
FROM EMPLOYEE;

------------------------------------------------------------------------------
/*
    LTRIM/RTRIM
        문자열에서 특정 문자를 제거한 나머지를 반환
        
        [표현법]
            LTRIM/RTRIM(컬럼 | '문자열', [제거하고 싶은 문자들])
            
        문자열의 왼쪽 또는 오른쪽에서 제거하고자하는 무자들을 찾아서 제거한 나머지 문자열 반환
        
*/

SELECT LTRIM('    K  H    ') FROM DUAL; --앞에서부터 다른 문자가 나올때 까지 공백을 제거
SELECT RTRIM('123123KH123', '123') FROM DUAL;
SELECT LTRIM('ACABACCAKHBA', 'ABC') FROM DUAL; --제거하고자 하는 문자는 문자열이 아니라 문자들

/*
    TRIM
        문자열의 앞/뒤/양쪽에 있는 지정한 저장하는 문자들을 제거한 나머지 문자열 반환
        
        [표현법]
        TRIM([LEADING | TRAILING | BOTH] 제거하고자하는 문자열 FROM 문자열)
*/
SELECT TRIM('    K  H    ') FROM DUAL; --기본값은 양쪽
SELECT TRIM(BOTH 'Z' FROM 'ZZZZK  HZZZZ') FROM DUAL;
SELECT TRIM(LEADING 'Z' FROM 'ZZZZK  HZZZZ') FROM DUAL;
SELECT TRIM(TRAILING 'Z' FROM 'ZZZZK  HZZZZ') FROM DUAL;

------------------------------------------------------------------------------
/*
    LOWER / UPPER / INITCAP
        LOWER : 모든 문자열을 소문자로 변경해서 반환
        UPPER : 모든 문자열을 대문자로 변경해서 반환
        INITCAP : 띄어쓰기 기준 첫글자마다 대문자로 변경한 문자열 반환
*/

SELECT LOWER('Welcom To My KH') FROM DUAL;
SELECT UPPER('Welcom To My KH') FROM DUAL;
SELECT INITCAP('welcom to my kH') FROM DUAL;

-------------------------------------------------------------------------------
/*
    CONCAT
        문자열 두개 전달받아서 하나로 함친 후 반환
        
        [표현법]
        CONCAT(STR1, STR2)
*/

SELECT CONCAT('가나다', 'ABC') FROM DUAL;
SELECT '가나다' || 'ABC' FROM DUAL;

------------------------------------------------------------------------------
/*
    REPLACE
        특정 문자열에서 특정 부분을 다른 부분으로 교체
        
        [표현법]
            REPLACE(문자열, 찾을 문자열, 치환할 문자열)
*/

SELECT EMAIL, REPLACE(EMAIL, 'C##SERVER', 'kh') FROM EMPLOYEE;

-------------------------------------------------------------------------------
/*
    <숫자처리함수>
    ABS
        숫자의 절대값을 구하는 함수
*/

SELECT ABS(-10) FROM DUAL;

-------------------------------------------------------------------------------
/*
    MOD
        두 수를 나눈 나머지 값을 반환
        
        [표현법]
            MOD(값, 나눌값)
*/

SELECT MOD(10, 3) FROM DUAL;
SELECT MOD(10.9, 3) FROM DUAL;

-------------------------------------------------------------------------------
/*
    ROUND
        반올림한 값을 반환
        [표현법]
            ROUND(값, [위치])
*/

SELECT ROUND(123.456) FROM DUAL; --기본 차수는 소수점 첫번째 자리에서 반올림
SELECT ROUND(123.456, 1) FROM DUAL; --위치값이 양수로 증가할수록 소수점 뒤로 한칸씩 이동한다.
SELECT ROUND(123.456, -1) FROM DUAL; --위치값이 음수로 증가할수록 소수점 앞으로 한칸씩 이동한다.

-------------------------------------------------------------------------------
/*
    CEIL
        올림처리를 위한 함수
        
        [표현법]
            CEIL(값)
*/

SELECT CEIL(123.456) FROM DUAL;

-------------------------------------------------------------------------------
/*
    TRUNC, FLOOR
        버림처리함수
        
        [표현법]
            TRUNC(값, 위치)
            FLOOR(값)
*/

SELECT TRUNC(123.456, 1) FROM DUAL;
SELECT TRUNC(123.456, -1) FROM DUAL;

-------------------------------------------------------------------------------
/*
    <날짜처리함수>
    
*/
--SYSDATE : 실행되는 시스템의 현재 날짜 및 시간을 반환
SELECT SYSDATE FROM DUAL;

--MONTHS_BETWEEN : 두 날짜 사이의 개월 수를 반환
-- 사원들의 사원명, 입사일, 근무일수, 근무 개월 수
SELECT EMP_NAME, HIRE_DATE, TRIM(SYSDATE - HIRE_DATE), CEIL(MONTHS_BETWEEN(SYSDATE, HIRE_DATE))
FROM EMPLOYEE;

--ADD_MONTHS : 특정 날짜에 개월수를 더한 값을 반환
SELECT ADD_MONTHS(SYSDATE, 7) FROM DUAL;

--사원테이블에서 사원명, 입사일, 수습기간 종료일(입사일로부터 3개월 뒤) 조회
SELECT EMP_NAME, HIRE_DATE, ADD_MONTHS(HIRE_DATE, 3) FROM EMPLOYEE;

--NEXT_DAY(DATE, 요일(문자 | 숫자)) : 특정 날짜 이후 가장 가까운 요일의 날짜를 반환
-- 1: 일요일 ~ 7: 토요일
SELECT NEXT_DAY(SYSDATE, 7) FROM DUAL; --> 숫자 추천

ALTER SESSION SET NLS_LNANGUAGE = AMERIACN;
-- 영어를 기본 설정
ALTER SESSION SET NLS_LNANGUAGE = KOREAN;
-- 한국어를 기본 설정

-- LAST_DAY(DATE) : 해당 월의 마지막 날짜를 구해서 반환
SELECT LAST_DAY(SYSDATE) FROM DUAL;

/*
    EXTRACT : 특정 날짜로부터 년|월|일 값만 추출해서 반환
    
        [표현법]
        EXTRACT(YEAR FROM DATE) : 연도만 추출
        EXTRACT(MONTH FROM DATE) : 월만 추출
        EXTRACT(DAY FROM DATE) : 일만 추출
*/

--사원의 사원명, 입사년도, 입사월, 입사일 조회
SELECT EMP_NAME,
        EXTRACT(YEAR FROM HIRE_DATE) AS 입사년도,
        EXTRACT(MONTH FROM HIRE_DATE) AS 입사월,
        EXTRACT(DAY FROM HIRE_DATE) AS 입사일
FROM EMPLOYEE;

-----------------------------------------------------------------------------
/*
    <형변환 함수>
        TO_CHAR : 숫자타입 또는 날짜타입의 값을 문자타입으로 변환시켜주는 함수
        
        [표현법]
            TO_CHAR(숫자 | 문자, [포멧])
*/

--숫자 -> 문자
SELECT TO_CHAR(1234) FROM DUAL;

SELECT TO_CHAR(12, '99999') FROM DUAL; -- 9의 자리수 만큼 공간 확보
SELECT TO_CHAR(12, '00000') FROM DUAL; -- 0의 자리수 만큼 공간 확보, 빈칸을 0으로 채움

SELECT TO_CHAR(1200000000, 'L9,999,999,999') FROM DUAL; 
--현재 설정된 나라의 로컬 화폐단위를 나타냄

--날짜 -> 문자
SELECT TO_CHAR(SYSDATE) FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'YYYY"년" MM"월" DD"일" DY HH24"시" MI"분" SS" 초"') FROM DUAL;

--년도와 관련된 포맷
SELECT TO_CHAR(SYSDATE, 'YYYY'),
        TO_CHAR(SYSDATE, 'RRRR'),
        TO_CHAR(SYSDATE, 'YY'),
        TO_CHAR(SYSDATE, 'YEAR')
FROM DUAL;

SELECT TO_DATE('2025', 'YYYY'), --> 많이 사용
    TO_DATE('2025', 'RRRR'),
    TO_DATE('60', 'YY'),    -- YY는 항상 입력 그대로 해석 -> 현재 년도를 반영
    TO_DATE('60', 'RR')     -- 2자리 입력시 현재 세기를 기준으로 자동보정
FROM DUAL;

-- 월과 관련된 포맷
SELECT TO_CHAR(SYSDATE, 'MM'), --> 많이 사용
    TO_CHAR(SYSDATE, 'MON'),
    TO_CHAR(SYSDATE, 'MONTH')
FROM DUAL;

-- 일과 관련된 포맷
SELECT TO_CHAR(SYSDATE, 'DD'), --오늘 일자
    TO_CHAR(SYSDATE, 'DDD'), --오늘이 이번 년도의 몇번째 일수
    TO_CHAR(SYSDATE, 'D') --요일
FROM DUAL;

--요일을 나타내는 포맷
SELECT TO_CHAR(SYSDATE, 'D'), --> 많이 사용
    TO_CHAR(SYSDATE, 'DAY'),
    TO_CHAR(SYSDATE, 'DY')
FROM DUAL;

-------------------------------------------------------------------------------
/*
    TO_DATE : 숫자타입 또는 문자타입을 날짜타입으로 변경하는 함수
    [표현법]
        TO_DATE(숫자 | 문자, [포맷]) -> DATE
*/

SELECT TO_DATE(20100101) FROM DUAL;
SELECT TO_DATE(611218) FROM DUAL; --기본적으로 연도를 2자리만 입력시 RR룰이 적용

SELECT TO_DATE(051010) FROM DUAL; --0으로 시작하는 숫자는 없다.
SELECT TO_DATE('050101') FROM DUAL;

SELECT TO_DATE('20020505 180500', 'YYYYMMDD HH24MISS') FROM DUAL;

--------------------------------------------------------------------------------
/*
    TO_NUMBER : 문자타입의 데이터를 숫자타입으로 변환해서 반환.
    
        [표현법]
        TO_NUMBER(문자, [포맷])
*/

SELECT TO_NUMBER('03213432432') FROM DUAL;
SELECT '1000' + '5000' FROM DUAL; --문자열 -> 숫자로 자동형변환이 진행된다.
SELECT TO_NUMBER('100,000', '999,999') FROM DUAL;

-------------------------------------------------------------------------------
/*
    <NULL처리 함수>
*/
--NVL(컬럼, 해당컬럼이 NULL일 경우 보여줄 값)
SELECT EMP_NAME, BONUS, NVL(BONUS, 0)
FROM EMPLOYEE;

--전 사원의 이름, 보너스 포함 연봉 조회
SELECT EMP_NAME, (SALARY + (SALARY * NVL(BONUS, 0)) * 12)
FROM EMPLOYEE;

--NVL2(컬럼, 반환값1, 반환값2)
--반환값1 : 해당컬럼이 존재하면 보여줄 값
--반환값2 : 해당컬럼이 존재하지 않으면 보여줄 값
SELECT EMP_NAME, BONUS, NVL2(BONUS, 'O', 'X')
FROM EMPLOYEE;

--NULLIF(비교대상1, 비교대상2)
--두값이 일치하면 NULL 반환, 일치하지 않으면 비교대상1 반환
SELECT NULLIF('123', '123') FROM DUAL;
SELECT NULLIF('123', '456') FROM DUAL;

--------------------------------------------------------------------------------
/*
    <선택함수>
        DECODE(비교하고자 하는 대상, 비교값1, 결과값1, 비교값2, 결과값2 ...)
*/

--사번, 사원명, 주민등록번호, 성별
SELECT EMP_ID, EMP_NAME, EMP_NO,
    DECODE(SUBSTR(EMP_NO, 8, 1), '1', '남', '2', '여', '3', '남', '4', '여', '잘못입력') AS 성별
FROM EMPLOYEE;

--직업의 이름, 기존 급여, 인상된 급여 조회(각 직급별로 차등인상)
--직급이 J7은 급여를 10%인상(SALARY * 1.1)
--직급이 J6은 급여를 15%인상(SALARY * 1.15)
--직급이 J5은 급여를 20%인상(SALARY * 1.2)
--그 외 직원들은 급여를 5%인상(SALARY * 1.05)
SELECT EMP_NAME, JOB_CODE, SALARY AS 인상전,
        DECODE(JOB_CODE, 
                'J7', SALARY * 1.1, 
                'J6', SALARY * 1.15,
                'J5', SALARY * 1.2,
                SALARY * 1.05) AS 인상후
FROM EMPLOYEE;

/*
    CASE문
        SQL에서 조건에 따라 값을 분기하고 싶을 때 사용하는 구문
        
        [표현법]
        CASE 
            WHEN 조건1 THEN 결과1
            WHEN 조건2 THEN 결과2
            ...
            ELSE 기본결과
        END
*/

SELECT EMP_NAME, SALARY,
        CASE 
            WHEN SALARY >= 5000000 THEN '시니어'
            WHEN SALARY >= 3500000 THEN '미들'
            ELSE '주니어'
        END AS 급여
FROM EMPLOYEE;

-------------------------------------------------------------------------------
-- <그룹함수>, 전체 결과값을 한 그룹으로 생각

--1. SUM(숫자타입컬럼) : 해당 컬럼값들의 총 합계를 구해서 변환해주는 함수

--직원들의 모든 급여의 합
SELECT SUM(SALARY)
FROM EMPLOYEE;

--남자사원들의 총 급여
SELECT SUM(SALARY)
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO, 8, 1) IN ('1', '3');

--여자사원들의 총 급여
SELECT SUM(SALARY)
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO, 8, 1) IN ('2', '4');

--부서코드가 D5인 부서 사람들의 총 연봉(급여 * 12)
SELECT SUM(SALARY * 12)
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5';

--2. AVG(NUMBER) : 해당 컬럼값들의 평균을 구해서 반환
SELECT AVG(SALARY)
FROM EMPLOYEE;

--3. MIN(모든타입가능) : 해당 컬럼 값 중 가장 작은 값을 구해서 반환
SELECT MIN(EMP_NAME), MIN(SALARY), MIN(HIRE_DATE)
FROM EMPLOYEE;

--4. MAX(모든타입가능) : 해당 컬럼 값 중 가장 큰 값을 구해서 반환
SELECT MAX(EMP_NAME), MAX(SALARY), MAX(HIRE_DATE)
FROM EMPLOYEE;

--5. COUNT(* | 컬럼 | DISTINCT 컬럼) : 해당 조건에 맞는 행의 갯수를 세서 반환
--COUNT(*) : 조회된 결과의 모든 행의 갯수를 반환
--COUNT(컬럼) : 제시한 컬럼값이 NULL이 아닌것만 행의 수를 세서 반환
--COUNT(DISTINCT 컬럼) : 해당 컬럼 값에서 중복을 제거한 후 행의 갯수를 세서 반환

--전체 사원의 수
SELECT COUNT(*) FROM EMPLOYEE;

--여자 사원의 수
SELECT COUNT(*) 
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO, 8, 1) IN ('2', '4');

--보너스를 받는 사원의 수
SELECT COUNT(BONUS) --보너스 컬럼의 값이 NULL이 아닌 데이터만 카운트를 함.
FROM EMPLOYEE;
--WHERE BONUS IS NOT NULL;

--현재 사원들이 총 몇개의 부서에 분포되어 있는지 
SELECT COUNT(DISTINCT DEPT_CODE)
FROM EMPLOYEE;

-------------------------------------------------------------------------------
/*
SQL 구문 순서

SELECT *
FROM 테이블
WHERE 조건
ORDER BY 정렬기준

순서 1. 테이블, 2. 조건, 3 검색, 4. 정렬

*/





