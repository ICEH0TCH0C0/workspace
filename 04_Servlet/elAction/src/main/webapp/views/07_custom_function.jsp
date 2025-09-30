<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>JSTL function</h1>
	<p>
		EL내에서 문자열, 배열, 컬렉션을 조작하는 함수 제공
	</p>
	
	<c:set var="str" value="How are you?"/>
	<c:set var="fruits" value="${fn:split('apple,banana,grape,tomato',',')}"/>
	
	문자열 길이 : ${str.length()} 또는 ${fn:length(str)} <br>
	"are" 시작 인덱스 : ${fn:indexOf(str, "are")} <br>
	대문자 변환 : ${fn:toUpperCase(str)} <br>
	소문자 변환 : ${fn:toLowerCase(str)} <br>
	
	공백제거 : ${fn:trim("        hello       ")} 또는 <!-- ${" hello  ".trim()} 오류나지만, 가능 --> 
	<!-- 더 많은 jstl function 기능이 있지만 대부분 자바의 기본 메서드로 대체가 가능하므로 기본 메서드를 사용 -->
</body>
</html>