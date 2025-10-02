<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h3>1. 산술 연산</h3>
    기존 : 10 + 3 = <%= (int)request.getAttribute("big") + (int)request.getAttribute("small")%>

    <br><br>

    EL방식 <br>
    10 + 3 = ${big + small} <br>
    10 - 3 = ${big - small} <br>
    10 * 3 = ${big * small} <br>
    10 / 3 = ${big / small} 또는 ${big div small}<br>
    10 % 3 = ${big % small} 또는 ${big mod small}<br>
    
    <h3>2. 비교 연산</h3>
    10 &gt; 3 = ${big > small} 또는 ${big gt small}<br>
    10 &lt; 3 = ${big < small} 또는 ${big lt small}<br>
    10 &lt;= 3 = ${big <= small} 또는 ${big le small}<br>
    10 &gt;= 3 = ${big >= small} 또는 ${big ge small}<br>


    <h3>3. 동등 비교</h3>
    <p>el에서는 == 비교는 자바에서의 equals()와 같은 동작</p>
    strOne과 strTwo가 일치하는 가? ${strOne == strTwo} 또는 ${strOne eq strTwo}<br>
    strOne과 strTwo 일치하는 않는가? ${strOne != strTwo} 또는 ${strOne ne strTwo}<br>
    
    <%-- el구문안에서 문자열 리터럴값은 '', "" 구분하지 않음. --%>
    strThree와 "hello"와 일치하는 가? ${strThree == "hello"} 또는 ${strThree eq "hello"}<br>
    strThree와 "hello"와 일치하지 않는가? ${strThree != "hello"} 또는 ${strThree ne "hello"}

    <h3>4. 객체가 null인지 아닌지, list가 비어있는지 확인</h3>
    personOne이 null인가? ${personOne == null} 또는 ${personOne eq null} 또는 ${empty personOne}<br>
    personTwo이 null인가? ${personTwo == null} 또는 ${personTwo eq null} 또는 ${empty personTwo}<br>

    personTwo이 null이 아닌가? ${personTwo != null} 또는 ${personTwo ne null} 또는 ${not empty personTwo}<br>

    arrOne은 비어 있는가? ${empty arrOne}<br>
    arrTwo는 비어 있는가? ${empty arrTwo}<br>

    <h3>5. 논리 연산</h3>
    true && true = ${true && true} 또는 ${true and true}<br>
    false || false = ${false && false} 또는 ${false or flase}<br>

    big이 small보다 크고 arrOne은 비어있는가? <br>
    ${big > small && empty arrOne}<br>
    ${big gt small and empty arrOne}<br>
</body>
</html>