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
        <th>교과코드</th>
        <th>교과목명</th>
        <th>교과구분</th>
        <th>담당교수</th>
        <th>학점</th>
    </tr>
    <c:forEach var="semesterGradesDetails" items="${id_semesterGradesDetails}">
        <tr>
            <td><c:out value="${semesterGradesDetails.year}"/></td>
            <td><c:out value="${semesterGradesDetails.semester}"/></td>
            <td><c:out value="${semesterGradesDetails.code}"/></td>
            <td><c:out value="${semesterGradesDetails.subjectName}"/></td>
            <td><c:out value="${semesterGradesDetails.subjectClassification}"/></td>
            <td><c:out value="${semesterGradesDetails.professor}"/></td>
            <td><c:out value="${semesterGradesDetails.grade}"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
