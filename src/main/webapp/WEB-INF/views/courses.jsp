<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nykim
  Date: 2024-03-07
  Time: 오후 4:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:forEach var="course" items="${id_courses}" >
        <p> <c:out value="${course}"> </c:out> </p>
    </c:forEach>
</body>
</html>
