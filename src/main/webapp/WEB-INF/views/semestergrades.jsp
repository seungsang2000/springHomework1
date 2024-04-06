<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/course.css" >
</head>
<body>
<table>
    <tr>
        <th>수강년도</th>
        <th>학기</th>
        <th>취득 학점</th>
        <th>상세 보기</th>
    </tr>
    <c:set var="totalGrade" value="0" scope="page" />
    <c:forEach var="semesterGrade" items="${id_semesterGrades}">
        <tr>
            <td><c:out value="${semesterGrade.year}"/></td>
            <td><c:out value="${semesterGrade.semester}"/></td>
            <td><c:out value="${semesterGrade.totalGrade}"/></td>
            <td><a href="${pageContext.request.contextPath}/semestergrades/Details?year=${semesterGrade.year}&semester=${semesterGrade.semester}">링크</a></td>
            <c:set var="totalGrade" value="${totalGrade + semesterGrade.totalGrade}" scope="page" />
        </tr>
    </c:forEach>
</table>
<br>
<table>
    <tr>
        <td class="center-text skyblue-background">총 학점</td>
    </tr>
    <tr>
        <td class="center-text"><c:out value="${totalGrade}"/></td>
    </tr>
</table>
</body>
</html>
