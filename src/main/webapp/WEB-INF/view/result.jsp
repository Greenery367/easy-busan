<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>결과 페이지</h2>
	<p>${kind.kindName}</p>
	<p>${kind.kindText}</p>
	<h4>섹션 출력 테스트</h4>
	<p>1순위 ${sectionList[0].sectionName}</p>
	<p>2순위 ${sectionList[1].sectionName}</p>
	<p>3순위 ${sectionList[2].sectionName}</p>
	
</body>
</html>