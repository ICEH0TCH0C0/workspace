<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>1. fmt:formatNumber</h3>
	<p>
		숫자 데이터의 표시 형식을 지정 <br>
		(fmt:formatNumber value="출력할 값 
			[
				groupingUsed="true|false" <!-- 천단위 구분자(,) 사용여부 -->>
				type="number|precent|currency" <!-- 출력형식 -->>
				currencySymbol="문자" <!-- type=currency일경우 통화 기호를 강제로 지정 -->>
				currenctCode="통화" <!-- 통화문자대신 통화코드기반 포멧 : KRW, USD, JPY-->
			]
		)
	</p>
	<c:set var="num1" value="123456789"/>
	<c:set var="num2" value="0.7"/>
	<c:set var="num3" value="500000"/>
	
	출력 : ${num1} <br>
	세자리 구분 출력 : <fmt:formatNumber value="${num1}"/> <br>
	세자리 구분 없이 : <fmt:formatNumber value="${num1}" groupingUsed="false"/> <br> <br>
	
	퍼센트(기본) : <fmt:formatNumber value="${num2}" type="percent"/> <br>
	퍼센트(소수 1자리 고정) : <fmt:formatNumber value="${num2}" type="percent" minFractionDigits="1" maxFractionDigits="1"/> <br>
	
	통화 : <fmt:formatNumber value="${num3}" type="currency" currencySymbol="$"/> <br>
	통화 : <fmt:formatNumber value="${num3}" type="currency" currencyCode="KRW"/> <br>
	
	<h3>2. formatDate</h3>
	<p>날짜 및 시간 데이터의 포맷 지정(단, java.util.Date 객체 사용)</p>
	
	<c:set var="current" value="<%=new java.util.Date() %>"/>
	출력 : ${current}
	
	<ul>
		<li>현재 날짜 : <fmt:formatDate value="${current}" type="date"/></li>
		<li>현재 시간 : <fmt:formatDate value="${current}" type="time"/></li>
		<li>현재 날짜와 시간 : <fmt:formatDate value="${current}" type="both"/></li>
		<li>medium : <fmt:formatDate value="${current}" type="date" dateStyle="medium" timeStyle="medium"/></li>
		<li>long : <fmt:formatDate value="${current}" type="date" dateStyle="long" timeStyle="long"/></li>
		<li>short : <fmt:formatDate value="${current}" type="date" dateStyle="short" timeStyle="short"/></li>
		<li>full : <fmt:formatDate value="${current}" type="date" dateStyle="full" timeStyle="full"/></li>
		<li>pattern : <fmt:formatDate value="${current}" type="date" pattern="yyyy년 MM월 dd일 E요일 a HH시 mm분 ss초"/></li>
	</ul>
</body>
</html>