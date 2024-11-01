<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <%@ include file="/WEB-INF/view/layout/header.jsp" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <script src="${pageContext.request.contextPath}/js/result.js"></script>

</head>
<c:if test="${data.noResult}">
    <script>
        alert("테스트를 진행해주세요.")
        location.href = "/question";
    </script>
</c:if>
<section class="result-content">
    <div class="result-area">
        <img src="/images/map/img_${data.kindSGG}.png">
        <div class="result-text-box">
            <div class="result-title">
                ${data.kindName}
            </div>
            <div class="first-text">
                ${data.kindSGG}
            </div>
            <div class="second-text">
                ${data.kindText}
            </div>
        </div>
    </div>

    <a href="">
        <div class="re-start">
            <div class="btn-re">다시하기</div>
        </div>
    </a>
    <div class="answer-section">
        <div class="answer-selection">
            <c:forEach var="category" items="${data.sectionCategoryList}">
                <button class="category-btn" data-category-id="${category.sectionCategoryId}">
                        ${category.sectionCategoryName}
                </button>
            </c:forEach>
            <button class="result-btn">결과 보기</button>
        </div>
    </div>
    </div>
</section>
<%@ include file="/WEB-INF/view/layout/footer.jsp" %>
