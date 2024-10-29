<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/question.css">
<script src="${pageContext.request.contextPath}/js/question.js"></script>
<html>
<head>
    <title>Easy-busan</title>
</head>
<body>
	<main>
	    <!-- 진행 중인 테스트가 있는지 확인 후 경고 메시지 출력 -->
		<c:if test="${!data.newTest}">
		    <script>
		        if (confirm("진행 중인 테스트가 있습니다. 계속 진행하시겠습니까?")) {
					continueTest();
		        } else {
					deleteTest();
		        }
		    </script>
		</c:if>
		<section class="question-section">
			<div class="image-container">
			    <div class="image">
			        <img src="/resources/img/boat-icon.png" class="boat-icon">
			        <div class="dots-container"></div>
			    </div>
			</div>

            <div class="question-bubble">
				<div class="character-icon-wrap">
                	<img src="/resources/img/boogi1.png" alt="character" class="character-icon">
				</div>
                <div class="bubble-text">
					<span class="question">${data.questionText}</span>
                </div>
            </div>
			
            <div class="answer-section">
                <div class="answer-selection">
					<c:forEach var="answer" items="${data.answerList}">
					    <button class="answer-btn" data-answer-id="${answer.answerId}">
					        ${answer.answerText}
					    </button>
					</c:forEach>
				</div>
			</div>
        </section>

	</main>
</body>
</html>
