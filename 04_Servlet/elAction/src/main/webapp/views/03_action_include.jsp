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
    <h3>jsp:include</h3>
    <p>또 다른 페이지를 포함하고자 할 때 사용하는 태그</p>

    <h4>1. 기존의 include 지시어를 이용하는 방식</h4>
    <p>정적 include 방식 => 컴파일시에 include를 수행해주기 때문에 컴파일 시점에 포함된 형태로 구성이 된다.(.jsp에서 .java가 될 때 포함)</p>
	
	<%--
    <%@ include file="footer.jsp" %>
    <br><br>

    특징 : include하고 있는 페이지상의 선언되어 있는 변수를 현재 페이지에서도 사용가능 <br>
    include한 페이지의 year변수 : <%=year %> <br><br>
     --%>
     
     <h4>2. jsp표준액션 태그를 이용한 방식(동적 include == 런타임 포함되는 형태)</h4>
     <jsp:include page="footer.jsp"/>
     <br>
     
     특징 1. include 하고 있는 페이지에 선언된 변수를 공유하지 않는다. <br> 
     => include한 페이지의 변수를 신경쓰지 않고 페이지에서 변수를 사용할 수 있다 <br>
     <% int year = 2025; %>
     
     특징 2. 포함시에 include하는 페이지로 파라미터를 전달할 수 있음. <br>
     <jsp:include page="footer.jsp">
     	<jsp:param name="test" value="hello"/>
     </jsp:include>
</body>
</html>