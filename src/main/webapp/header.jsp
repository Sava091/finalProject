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
<head>
    <meta http-equiv="content-type" content="text/html" charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

	<link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>


	<nav class="navbar navbar-expand-md navbar-dark bg-dark sticky-top py-0">
	    <div class="container-fluid">
	        <a href="index.jsp" class="navbar-brand"><img src="img/logo.png" class="logo-title"></a>
	        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
	            <span class="navbar-toggler-icon"></span>
	        </button>
					<div class="collapse navbar-collapse" id="navbarNav">
						<ul class="navbar-nav mr-auto navbar-brand">
							<li class="nav-item">
								<a href="index.jsp" class="nav-link active">FoodTracking</a>
							</li>
							<li class="nav-item">
								<a href="#" class="nav-link"><fmt:message key = "profile"/></a>
							</li>
							<li class="nav-item">
								<a href="#" class="nav-link"><fmt:message key = "links"/></a>
							</li>
						</ul>
					</div>
	        <div class="collapse navbar-collapse" id="navbarNav">
	            <ul class="navbar-nav ml-auto">
	                <li class="nav-item">
	                    <form class="form-inline">
	                        <a href="login_page.jsp">
						        <button class="btn btn-success" type="button"><fmt:message key = "login1"/></button>
							</a>
						</form>
					</li>
					<li class="nav-item">
					    <form class="form-inline">
							<a href="reg_page.jsp">
							    <button class="btn btn-success" type="button"><fmt:message key = "sing_up"/></button>
							</a>
						</form>
					</li>
					 <form action="/" method="GET">
					    <li class="nav-item dropdown">
                            <a class="dropdown-toggle nav-link my-1 ml-2" data-toggle="dropdown">ru</a>
                            <div class="dropdown-menu">
                                <a class="dropdown-item" value="en" ${lang == 'en' ? 'selected' : ''}>English</a>
                                <a class="dropdown-item" value="ru" ${lang == 'ru' ? 'selected' : ''}>Русский</a>
                            </div>
                        </li>
                     </form>
	            </ul>
	        </div>
	    </div>
	</nav>


	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>

