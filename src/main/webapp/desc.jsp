<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
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
            <title>
                Description
            </title>
            <meta http-equiv="content-type" content="text/html" charset="utf-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <meta http-equiv="X-UA-Compatible" content="ie=edge">
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
                integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

            <link rel="stylesheet" href="css/main.css">
    </head>
    <body>
    <jsp:include page="header.jsp"></jsp:include>

    <div class="container-fluid">
        <div class="row jumbotron jumbotron-fluid my-1">
        	<div class="col-12 text-center ">
        	    <h2><fmt:message key = "finproj"/></h2>
                <h3><fmt:message key = "finprojtext"/></h3>
                <h2><fmt:message key = "requirements1"/> </h2>
                <p><fmt:message key = "requirements2"/> </p>
                <p><fmt:message key = "requirements3"/> </p>
                <p><fmt:message key = "requirements4"/> </p>
                <p><fmt:message key = "requirements5"/> </p>
                <p><fmt:message key = "requirements6"/> </p>
                <p><fmt:message key = "requirements7"/> </p>
                <p><fmt:message key = "requirements8"/> </p>
                <p><fmt:message key = "requirements9"/> </p>
                <p><fmt:message key = "requirements10"/> </p>
                <p><fmt:message key = "requirements11"/> </p>
                <p><fmt:message key = "requirements12"/> </p>
                <p><fmt:message key = "requirements13"/> </p>
                <p><fmt:message key = "requirements14"/> </p>
        	</div>
        </div>
    </div>






    <jsp:include page="footer.jsp"></jsp:include>


           <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
           <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
           <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>