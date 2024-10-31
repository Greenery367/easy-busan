
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>

    <head>
        <meta charset="UTF-8">
        <title>Insert title here</title>
        <%@ include file="/WEB-INF/view/layout/header.jsp" %>
            <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    </head>
    <section class="result-content">
        <div class="result-area">
            <img src="/images/map/img_강서구.png">
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

        <div class="bt-restart">다시하기</div>
    </div>
    </section>
    <%@ include file="/WEB-INF/view/layout/footer.jsp" %>

