<%-- 
    Document   : addSchool
    Created on : Oct 3, 2016, 6:15:14 PM
    Author     : Abdullah Gürlek <abdullah.gurlek3 at gmail.com>
--%>

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
        <form:form commandName="Teacher">
            <form:label path="name">Öğretmen Adı : </form:label>
            <form:input path="name" />
            <form:errors path="name" />
            <br>
            <input type="submit"/>
        </form:form>
    </body>
</html>
