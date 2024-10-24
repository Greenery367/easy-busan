<%--
   임시로 만든 파일 지워도 되고 싹 갈아 엎어도됨
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:if test="${!data.newTest}">
        <script>
            if (confirm("진행중인 테스트가 있습니다. 계속 진행 하시겠습니까?")){
                // TODO 계속 진행하는 요청 (일반적인 퀴즈 요청과 동일)
            } else {
                // TODO 진행중이던 테스트 즉, 해당 user_kind_id를 삭제해야함 (cascade 적용 되어있음)
                // -> 삭제 후 리다이렉트 하면 조회 되는 user_kind_id는 없을것
            }
        </script>
    </c:if>
    <h2>질문 페이지</h2>
    <p>${data.questionText}</p>
    <p>${data.tip}</p>
    <ul>
        <c:forEach var="answer" items="${data.answerList}">
            <li data-answer-id = "${answer.answerId}">${answer.answerText}</li>
        </c:forEach>
    </ul>
    <c:if test="${data.last}">
        <p>결과 페이지로 이동시켜야함</p>
    </c:if>
</body>
</html>
