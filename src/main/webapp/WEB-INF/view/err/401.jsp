400.jsp<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/view/layout/header.jsp" %>
<script>
    alert("로그인이 필요합니다.");
    window.href = "/login";
</script>
<h1>Unauthorized 401</h1>
<hr>
<h4>${message}</h4>
<%@ include file="/WEB-INF/view/layout/footer.jsp" %>