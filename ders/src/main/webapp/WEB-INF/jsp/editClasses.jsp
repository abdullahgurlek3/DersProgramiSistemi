<%-- 
    Document   : schools
    Created on : Oct 3, 2016, 6:21:21 PM
    Author     : Abdullah Gürlek <abdullah.gurlek3 at gmail.com>
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form:form commandName="">
            <c:forEach items="${classes}" var="class1">
                <input id="lesson_${class1.getId()}" type="checkbox" value="${class1.getId()}" name="classes[]" 
                       <c:if test="${selectedLessons.contains(lesson)}">
                           checked="checked"
                       </c:if>
                       />
                <label for="lesson_${class1.getId()}">${class1.getName()}</label>
            </c:forEach>
            <input type="submit">
        </form:form>
    </body>
</html>
