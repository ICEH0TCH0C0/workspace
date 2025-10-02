<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>피자 결제 페이지</title>
</head>
<body>
    <%
        String name = (String)request.getAttribute("userName");
        String phone = (String)request.getAttribute("phone");
        String address = (String)request.getAttribute("address");
        String message = (String)request.getAttribute("message");

        String pizza = (String)request.getAttribute("pizza");
        String[] topping = (String[])request.getAttribute("topping");
        String[] side = (String[])request.getAttribute("side");
        String pay = (String)request.getAttribute("payment");
        int priceTotal = (Integer)request.getAttribute("priceTotal");

    %>
    <h1>피자 결제 페이지</h1>
    <h3>주문 내역</h3>
    <h5>[주문자 정보]</h5>
    <ul>
        <li>성함 : <%=name%></li>
        <li>전화번호 : <%=phone%></li>
        <li>주소 : <%=address%></li>
        <li>요청사항 : <%=message%></li>
    </ul>

    <br>

    <h5>[주문 정보]</h5>
    <ul>
        <li>피자 : <%=pizza%></li>
         <% if(topping != null) { %>
        	<li>토핑 : <%=String.join(",", topping)%></li>
        <% } else { %>
        	<li>토핑 선택 안함.</li>
        <% } %>
        <% if(side != null) { %>
        	<li>사이드 : <%=String.join(",", side)%></li>
        <% } else { %>
        	<li>사이드 선택 안함.</li>
        <% } %>
        <li>결제방식 : <%=pay%></li>
    </ul>
    <h4>위와 같이 주문하셨습니다.</h4>
    <h2>총 가격 : <%=priceTotal%></h2>
</body>
</html>