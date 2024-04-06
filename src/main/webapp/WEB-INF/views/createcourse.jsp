<%--
  Created by IntelliJ IDEA.
  User: nykim
  Date: 2024-03-11
  Time: 오후 2:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/css/main.css" >

</head>
<body>
<sf:form method="post" action="${pageContext.request.contextPath}/docreate" modelAttribute="course">
    <table class="formtable">
        <tr>
            <td class="label"> 교과코드:</td>
            <td><sf:input class="control" type="text" path="code"/>  <br/>
                <sf:errors path="code" class="error"/>
            </td>
        </tr>
        <tr>
            <td class="label"> 교과목명 :</td>
            <td><sf:input class="control" type="text" path="subjectName"/>  <br/>
                <sf:errors path="subjectName" class="error"/>
            </td>
        </tr>
        <tr>
            <td class="label"> 교과구분 :</td>
            <td><sf:input class="control" type="text" path="subjectClassification"/> <br/>
                <sf:errors path="subjectClassification" class="error" />
            </td>
        </tr>
        <tr>
            <td class="label"> 담당교수:</td>
            <td><sf:input class="control" type="text" path="professor"/> <br/>
                <sf:errors path="professor" class="error" />
            </td>
        </tr>
        <sf:hidden path="semester" value="1"/>
        <sf:hidden path="year" value="2024"/>
        <tr>
            <td class="label"> 학점:</td>
            <td><sf:input class="control" type="text" path="grade"/> <br/>
                <sf:errors path="grade" class="error" />
            </td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Create Course"/> </td>
        </tr>
    </table>
</sf:form>
</body>
</html>
