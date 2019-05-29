<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" session="false"%>




<html>
    <head>
            <title>
                FoodTracking
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


    <div class="carousel slide" data-ride="carousel" id="slides">
    		<ul class="carousel-indicators">
    			<li data-target="#slides" data-slide-to="0" class="active"></li>
    			<li data-target="#slides" data-slide-to="1" class="active"></li>
    			<li data-target="#slides" data-slide-to="2" class="active"></li>
    			<li data-target="#slides" data-slide-to="3" class="active"></li>
    		</ul>
    		<div class="carousel-inner">
    			<div class="carousel-item text-center active">
    				<img src="img/slide1.jpg" class="img-fluid" alt="">
    				<div class="carousel-caption">
    					<h1 class="display-2">Healthy LifeStyle</h1>
    					<h3>Calories Tracking Application</h3>
    				</div>
    			</div>
    			<div class="carousel-item text-center ">
    				<img src="img/slide2.jpg" class="img-fluid" alt="">
    				<div class="carousel-caption">
    					<h1 class="display-2">Healthy LifeStyle</h1>
    					<h3>Calories Tracking Application</h3>
    				</div>
    			</div>
    			<div class="carousel-item text-center">
    				<img src="img/slide3.jpg" class="img-fluid" alt="">
    				<div class="carousel-caption">
    					<h1 class="display-2">Healthy LifeStyle</h1>
    					<h3>Calories Tracking Application</h3>
    				</div>
    			</div>
    			<div class="carousel-item text-center">
    				<img src="img/slide4.jpg" class="img-fluid" alt="">
    				<div class="carousel-caption">
    					<h1 class="display-2">Healthy LifeStyle</h1>
    					<h3>Calories Tracking Application</h3>
    				</div>
    			</div>
    		</div>
    	</div>
    		<div class="container-fluid">
    			<div class="row jumbotron jumbotron-fluid my-1">
    				<div class="col-10">
    					<h3>Final Project
    						Weight Loss / Food Tracking System. Customer chooses food (name,
    						count proteins, fats, carbohydrates), which I ate (from the already prepared list) and writes
    						Amount. The client can add his type of food (name, calories, count.
    						proteins, fats, carbon). If the client has increased the daily rate, the system
    						will inform him of this and write down how much Norma was exceeded. Norm
    						take from the parameters Client (age, height, weight, lifestyle, etc.).</h3>
    				</div>
    				<div class="col-2">
    					<a href="#"><button class="btn btn-info btn-lg d-block mx-auto">Read more! </button></a>
    				</div>
    			</div>
    		</div>


    		<jsp:include page="footer.jsp"></jsp:include>


    		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>
