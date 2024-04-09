<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <p>
    <button onclick="window.location.href='${pageContext.request.contextPath}/courses'">수강 신청 조회</button>
  </p>
  <p>
    <button onclick="window.location.href='${pageContext.request.contextPath}/createcourse'">수강신청하기</button>
  </p>
  <p>
    <button onclick="window.location.href='${pageContext.request.contextPath}/semestergrades'">학년별 이수 학점 조회</button>
  </p>


    <c:if test="${pageContext.request.userPrincipal.name != null}">
      <a href="javascript:document.getElementById('logout').submit()">Logout</a>
    </c:if>

    <c:if test="${pageContext.request.userPrincipal.name == null}">
      <form action="${pageContext.request.contextPath}/login" method="get">
        <input type="submit" value="Login"/>
      </form>
    </c:if>

    <form id="logout"  action="<c:url value="/logout" />"method="post">
      <input type="hidden" name="${_csrf.parameterName}"value="${_csrf.token}" />
    </form>

  </body>
</html>
