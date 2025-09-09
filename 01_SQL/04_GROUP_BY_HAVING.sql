/*
    <GROUP BY>
        그룹기준을 제시할 수 있는 구문(해당 그룹기준별로 여러 그룹으로 묶을 수 있음)
        여러개의 값들을 하나의 그룹으로 묶어서 처리하는 목적으로 사용
        
*/
--각 부서별 급여 총합
SELECT DEPT_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE;

--각 부서별 사원 수
SELECT DEPT_CODE, COUNT(*)
FROM EMPLOYEE
GROUP BY DEPT_CODE;

SELECT DEPT_CODE, COUNT(*), SUM(SALARY) --3
FROM EMPLOYEE  --1
GROUP BY DEPT_CODE  --2
ORDER BY DEPT_CODE;  --4

--GROUP BY절에 함수식 사용 가능(그룹을 나눌 수 있는 기준만 넣어주면)
--남자 사원과 여자사원의 수를 조회
SELECT DECODE(SUBSTR(EMP_NO, 8, 1), '1', '남', '2', '여'), COUNT(*)
FROM EMPLOYEE
GROUP BY SUBSTR(EMP_NO, 8, 1);

--GROUP BY절에 여러컬럼을 기술할 수 있음
--여러개의 컬럼을 기술하면 해당 여러컬럼들 모두를 하나의 기준으로 사용함
SELECT DEPT_CODE, JOB_CODE, COUNT(*)
FROM EMPLOYEE
GROUP BY DEPT_CODE, JOB_CODE;

/*
    <HAVING>
        그룹에 대한 조건을 제시할 때 사용되는 구문(주로 그룹함수식을 가지고 조건을 만든다)
*/

--각 부서별 평균 급여를 조회(부서코드, 평균급여)
SELECT DEPT_CODE, ROUND(AVG(SALARY))
FROM EMPLOYEE
GROUP BY DEPT_CODE;

--각 부서별 평균급여가 300만원 이상인 부서들만 부서코드, 평균급여 조회
--WHERE절이 GROUP BY이전에 실행되므로 해당 코드는 300만이상의 급여를 받는 사람을 먼저 필터링한 후 
-- 부서코드와 평균을 구한다
SELECT DEPT_CODE, ROUND(AVG(SALARY)), COUNT(*)
FROM EMPLOYEE
WHERE SALARY >= 3000000 --300만원 이상인 사원들 먼저 필터링을 거침
GROUP BY DEPT_CODE;

SELECT DEPT_CODE, ROUND(AVG(SALARY)), COUNT(*)
FROM EMPLOYEE
GROUP BY DEPT_CODE
HAVING AVG(SALARY) >= 3000000; 

--직급별 직급코드, 총 급여합(단, 직급별 총급여합이 1000만원 이상인 직급만 조회)
SELECT JOB_CODE,SUM(SALARY)
FROM EMPLOYEE
GROUP BY JOB_CODE
HAVING SUM(SALARY) >= 10000000;

--부서별 보너스를 받는 사원이 없는 부서의 부서코드
SELECT DEPT_CODE, COUNT(BONUS)
FROM EMPLOYEE
GROUP BY DEPT_CODE
HAVING COUNT(BONUS) = 0;

--------------------------------------------------------------------------------
/*
    SELECT *
    FROM 테이블
    WHERE 조건식
    GROUP NY 그룹기준 컬럼 | 함수식
    HAVING 조건식
    ORDER BY 정렬기준
    LIMIT (오라클 x)
    
    1. FROM > 2. WHERE > 3. GROUP BY > 4. HAVING > 5. SELECT > 6. ORDER BY > 7. LIMIT
    
*/

