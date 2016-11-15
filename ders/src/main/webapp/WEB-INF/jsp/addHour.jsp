<%-- 
    Document   : addSchool
    Created on : Oct 3, 2016, 6:15:14 PM
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
        <form:form>
            <table>
                <thead>
                    <c:forEach items="${Days}" var="Day">
                    <th>${Day}</th>
                    </c:forEach>
            </thead>
            <tbody>
                <tr>
                    <c:forEach items="${Hours}" var="Hour">
                    <tr>
                        <c:forEach items="${Days}" var="Day">
                            <td><input name="hours[]" value="${Day}_${Hour}" type="checkbox"
                                       <c:if test="${Day.isMesai() && Hour.isMesai()}">
                                           checked="checked"
                                       </c:if>
                                       >${Hour}</td>
                            </c:forEach>
                    </tr>
                </c:forEach>
                </tr>
            </tbody>
        </table>
        <input type="submit"/>
    </form:form>
</body>
</html>
