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
            <c:forEach items="${schools}" var="school">
                <li>${school.getName()} 
                    <a href="/ders/teacher/add/${school.getId()}">Öğretmen Ekle</a> 
                    <a href="/ders/teacher/showAll/${school.getId()}">Öğretmenler</a> 
                    <a href="/ders/lesson/add/${school.getId()}">Ders Ekle</a>
                    <a href="/ders/lesson/showAll/${school.getId()}">Dersler</a>
                    <a href="/ders/class/add/${school.getId()}">Sınıf Ekle</a>
                    <a href="/ders/class/showAll/${school.getId()}">Sınıflar</a>
                    <a href="/ders/classroom/add/${school.getId()}">Derslik Ekle</a>
                    <a href="/ders/classroom/showAll/${school.getId()}">Derslikler</a>
                </li>

            </c:forEach>
        </ul>
    </body>
</html>
