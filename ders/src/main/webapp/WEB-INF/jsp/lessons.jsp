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
            <c:forEach items="${lessons}" var="lesson">
                <li>${lesson.getName()} 
                    <a href="/ders/lesson/editTeachers/${lesson.getSchool().getId()}">Öğretmen Seç</a> 
                    <a href="/ders/lesson/editClasses/${lesson.getSchool().getId()}">Sınıf Ekle</a>
                    <a href="/ders/lesson/editClassRooms/${lesson.getSchool().getId()}">Derslik Ekle</a></li>
                </c:forEach>
        </ul>
    </body>
</html>
