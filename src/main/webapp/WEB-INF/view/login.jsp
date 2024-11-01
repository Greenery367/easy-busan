<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
<html>
<head>
    <title>Login</title>
</head>
<body>
	<a href="/"><img src="/images/buki.png"></a>
	
	<div class="login-container">
	    <div class="login-box">
	        <form action="/user/login" method="post">
	            <label for="email">이메일</label>
	            <input type="text" id="email" name="email" placeholder="이메일" required>
	
	            <label for="password">비밀번호</label>
	            <input type="password" id="password" name="password" placeholder="비밀번호" required>
	
	            <div class="options">
	                <div class="links">
	                    <a href="/user/join">회원가입</a>
	                </div>
	            </div>
	
	            <button type="submit" id="login-btn" class="links">로그인</button>
	        </form>
	    </div>
	</div>
	
	
	
	</body>
</html>
