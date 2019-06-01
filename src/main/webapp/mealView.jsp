<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" session="false" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="lang" value="${not empty param.lang ? param.lang : not empty lang ? lang : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${lang}" />
    <fmt:setBundle basename="messages"/>

    <c:if test="${lang ne null}">
        <fmt:setLocale value="${lang}"/>
    </c:if>

<html lang="${lang}">

<html>
    <head>
        <tittle>Meal choising</tittle>
    </head>

    <body>
        <h2>Meal</h2>
    </body>
</html>