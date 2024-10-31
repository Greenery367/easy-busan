<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
<html>
<head>
    <title>Login</title>
</head>
<body>
	<a href="/"><img src="/image/logo3.png"></a>
	
	<div class="login-container">
	    <div class="login-box">
	        <form action="/user/login" method="post">
	            <label for="email">이메일</label>
	            <input type="text" id="email" name="email" placeholder="이메일" required>
	
	            <label for="password">비밀번호</label>
	            <input type="password" id="password" name="password" placeholder="비밀번호" required>
	
	            <div class="options">
	                <label><input type="checkbox" name="remember"> 자동로그인</label>
	                <div class="links">
	                    <a href="/user/join">회원가입</a>
	                </div>
	            </div>
	
	            <button type="submit" id="login-btn" class="links">로그인</button>
	        </form>
	    </div>
	</div>
	
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script>
	    $(document).ready(function() {
	        $('body').css('opacity', '1');
	
	        $('.links a').on('click', function(e) {
	            e.preventDefault(); 
	            var linkUrl = $(this).attr('href');
	            $('body').animate({ opacity: 0 }, 500, function() {
	                window.location.href = linkUrl;
	            });
	        });
	
	        $('#login-btn').on('click', function() {
	            $('body').animate({ opacity: 0 }, 500);
	        });
	
	        $('form').on('submit', function() {
	            $('body').css('opacity', '0');
	        });
	
	        window.addEventListener('pageshow', function(event) {
	            if (event.persisted || (window.performance && window.performance.navigation.type === 2)) {
	                $('body').css('opacity', '1');
	            }
	        });
	    });
	</script>
	
	</body>
</html>
