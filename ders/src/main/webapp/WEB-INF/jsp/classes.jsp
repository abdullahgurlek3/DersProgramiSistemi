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
        <ul>
            <c:forEach items="${classes}" var="class1">
                <li>${class1.getName()} 
                    <a href="/ders/teacher/add/${class1.getSchool().getId()}">Öğretmen Ekle</a> 
                    <a href="/ders/class/add/${class1.getSchool().getId()}">Sınıf Ekle</a>
                    <a href="/ders/classroom/add/${class1.getSchool().getId()}">Derslik Ekle</a></li>
                </c:forEach>
        </ul>
    </body>
</html>
