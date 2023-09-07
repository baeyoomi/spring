<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//일반 JSP로 받는 형태
	/* 
	Controller Attribute 사용시 자료형에 맞는 구조를 생성하여 getAttribute로 로드하는 것이 중요
	 */
	List<String> list = (ArrayList<String>)request.getAttribute("person_list"); //자료형 명시,new 쓰면 안됌
	/* out.print(list); */
	
%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>spring 3일차 - Controller -> view로 배열값 출력</title>
</head>
<body>
<%-- ${person_list} --%>

<p>고객명 리스트 방식 1</p>
<ul>
	<%int w = 0;
		while(w < list.size()){%>
	<li><%= list.get(w) %></li>
	<%  w++; } %>
</ul>
<br>
<p>고객명 리스트 방식 2</p>
<ul>
	<%  int ww = 0;
		while(ww < list.size()){
		out.print("<li>"+list.get(ww)+"</li>");
		ww++; } %>
</ul>
</body>
</html>