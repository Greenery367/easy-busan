<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/join.css">
<html>
<head>
    <title>회원가입</title>
</head>
<body>
<a href="/"><img src="/image/logo3.png"></a>
<div class="register-container">
    
    <div class="register-box">
        <form id="registerForm" action="/user/join" method="post">
            <div class="input-id-password">

                <div class="input-with-icon">
                    <span class="icon"><i class="fas fa-envelope"></i></span>
                    <input type="email" id="email" name="email" placeholder="이메일" required class="email-box">
                </div>

                <div class="input-with-icon">
                    <span class="icon"><i class="fas fa-lock"></i></span>
                    <input type="password" id="password" name="password" placeholder="비밀번호" required class="password-box" autocomplete="new-password">
                    <span class="icon-eye" id="togglePassword"><i class="fas fa-eye-slash"></i></span>
                </div>
				
                <div class="message-box">
	                <span id="emailMessage" class="message"></span>
	                <span id="passwordMessage" class="message"></span>
                </div>
            </div>
			
            <div class="input-other">
                <div class="input-with-icon">
                    <span class="icon"><i class="fas fa-user"></i></span>
                    <input type="text" id="user_name" name="user_name" placeholder="이름" required class="name-box">
                </div>

                <div class="input-with-icon">
                    <span class="icon"><i class="fas fa-phone"></i></span>
                    <input type="tel" id="phoneNumber" name="phoneNumber" placeholder="휴대폰 번호" required class="phone-box">
                </div>
				
                <div class="input-with-icon">
                    <span class="icon"><i class="fas fa-calendar-alt"></i></span>
                    <input type="number" id="age" name="age" placeholder="나이" required class="age-box">
                </div>
            </div>

            <div class="gender-options">
                <input type="radio" id="male" name="gender" value="male" required>
                <label for="male" class="gender-label">남자</label>

                <input type="radio" id="female" name="gender" value="female" required>
                <label for="female" class="gender-label">여자</label>
            </div>

            <div class="terms-box">
                <label><input type="checkbox" name="terms" required> 약관 동의</label>
            </div>

            <div id="authSection" style="display: none;">
                <div class="input-with-icon">
                    <span class="icon"><i class="fas fa-key"></i></span>
                    <input type="text" id="authCodeInput" placeholder="인증번호 입력" class="auth-code-box">
                    <button type="button" id="verifyCodeBtn" class="verify-btn">인증확인</button>
                </div>
            </div>
            
            <span id="timer" style="float: right; font-size: 14px; color: red;"></span>
            <button type="button" class="register-btn" id="sendSmsBtn">인증요청</button>
            <div id="joinDone" style="display: none;">
                <button type="submit" id="joinBtn" class="joinBtn">가입하기</button>
            </div>
        </form>
    </div>

</div>

</body>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/js/login/checkRepetition.js"></script>
<script type="text/javascript" src="/js/login/birth.js"></script>
<script>
    $("#togglePassword").on("click", function() {
        const passwordInput = $("#password");
        const icon = $(this).find("i");

        if (passwordInput.attr("type") === "password") {
            passwordInput.attr("type", "text");
            icon.removeClass("fa-eye-slash").addClass("fa-eye");
        } else {
            passwordInput.attr("type", "password");
            icon.removeClass("fa-eye").addClass("fa-eye-slash");
        }
    });
</script>
</html>
