<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false"%>
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
                <fmt:message key = "login1"/>
            </title>
            <fmt:setBundle basename="messages"/>
            <meta http-equiv="content-type" content="text/html" charset="utf-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <meta http-equiv="X-UA-Compatible" content="ie=edge">
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
                integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
            <link rel="stylesheet" href="css/main.css">
    </head>
    <body>
    <jsp:include page="header.jsp"></jsp:include>



        <div class="container">
          <div class="row">
            <div class="col-md-3"> </div>
            <div class="col-md-6 ">
              <form class="px-4 py-3" method="GET" action="/login">
              <div class="form-group">
                <label for="exampleDropdownFormEmail1"><fmt:message key = "email"/></label>
                <input type="text" name="login" class="form-control" id="exampleDropdownFormEmail1" placeholder="login" value="user">
              </div>
              <div class="form-group">
                <label for="exampleDropdownFormPassword1"><fmt:message key = "pass1"/></label>
                <input type="password" name="pass" class="form-control" id="exampleDropdownFormPassword1" placeholder="Password" value="user">
              </div>
              <button type="submit" class="btn btn-success" value="Login"><fmt:message key = "sign_in"/></button>
            </form>
                <c:if test="${errorMessage ne null}">
                    <p>Error ${errorMessage}</p>
                </c:if>
            </div>
          </div>
        </div>

    <jsp:include page="footer.jsp"></jsp:include>


    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>