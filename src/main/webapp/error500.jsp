<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" session="false" isELIgnored="false" isErrorPage="true"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<html>
    <head>
            <title>
                <fmt:message key = "error"/> 500
            </title>
            <link rel="stylesheet" href="css/error.css">
            <meta http-equiv="content-type" content="text/html" charset="utf-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <meta http-equiv="X-UA-Compatible" content="ie=edge">
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
                integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
            <link href="https://fonts.googleapis.com/css?family=Montserrat:500" rel="stylesheet">
            <link href="https://fonts.googleapis.com/css?family=Titillium+Web:700,900" rel="stylesheet">

    </head>
<body>
	<div id="internal">
		<div class="internal">
			<div class="internal-500">
				<h1>500</h1>
			</div>
			<h2><fmt:message key = "oops"/> <fmt:message key = "error5001"/></h2>
			<p><fmt:message key = "error5002"/></p>
			<a href="index.jsp"><fmt:message key = "go_home"/></a>
		</div>
	</div>



    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>