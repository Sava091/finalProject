<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" session="false"%>

<meta http-equiv="content-type" content="text/html" charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css">


<html>
    <head>
            <title>
                Login form
            </title>
    </head>

    <body>
    <jsp:include page="header.jsp"></jsp:include>



<div class="container">
	    <form class="form-horizontal" role="form" method="POST" action="/register">
	        <div class="row">
	            <div class="col-md-3"></div>
	            <div class="col-md-6">
	                <h2>Register New User</h2>
	                <hr>
	            </div>
	        </div>
	        <div class="row">
	            <div class="col-md-3 field-label-responsive">
	                <label for="name">Name</label>
	            </div>
	            <div class="col-md-6">
	                <div class="form-group">
	                    <div class="input-group mb-2 mr-sm-2 mb-sm-0">
	                        <input type="text" name="name" class="form-control" id="name"
	                               placeholder="John Doe" required autofocus>
	                    </div>
	                </div>
	            </div>
	        </div>
					<div class="row">
	            <div class="col-md-3 field-label-responsive">
	                <label for="name">Age</label>
	            </div>
	            <div class="col-md-6">
	                <div class="form-group">
	                    <div class="input-group mb-2 mr-sm-2 mb-sm-0">
												<input type="number" min="12" max="100" class="form-control" id="InputAge" aria-describedby="InputAge" placeholder="Age" required>
	                    </div>
	                </div>
	            </div>
	        </div>
					<div class="row">
	            <div class="col-md-3 field-label-responsive">
	                <label for="name">Height(sm)</label>
	            </div>
	            <div class="col-md-6">
	                <div class="form-group">
	                    <div class="input-group mb-2 mr-sm-2 mb-sm-0">
	                        <input type="number" min="120" max="210" class="form-control" id="InputHeight" aria-describedby="InputHeight" placeholder="Height" required>
	                    </div>
	                </div>
	            </div>
	        </div>
					<div class="row">
							<div class="col-md-3 field-label-responsive">
									<label for="name">Acvivity per day</label>
							</div>
							<div class="col-md-6">
									<div class="form-group">
											<div class="input-group mb-2 mr-sm-2 mb-sm-0">
												<select class="form-control" id="FormControlActivity" required>
													<option>Minimum</option>
													<option>Low</option>
													<option>Medium</option>
													<option>High</option>
													<option>Maximum</option>
												</select>
											</div>
									</div>
							</div>
					</div>
					<div class="row">
							<div class="col-md-3 field-label-responsive">
									<label for="name">Sex</label>
							</div>
							<div class="col-md-6">
								<div class="form-inline">
									<label class="btn btn-default active">
										<input type="radio" class="form-check-input " name="optradio" checked="">Woman
									</label>
									<label class="btn btn-default">
										<input type="radio" class="form-check-input" name="optradio">Man
									</label>
								</div>
							</div>
					</div>
	        <div class="row">
	            <div class="col-md-3 field-label-responsive">
	                <label for="email">E-Mail Address</label>
	            </div>
	            <div class="col-md-6">
	                <div class="form-group">
	                    <div class="input-group mb-2 mr-sm-2 mb-sm-0">
	                       <input type="email" class="form-control" id="InputEmail1" aria-describedby="emailHelp" placeholder="example@example.com" required>
	                    </div>
	                </div>
	            </div>
	        </div>
	        <div class="row">
	            <div class="col-md-3 field-label-responsive">
	                <label for="password">Password</label>
	            </div>
	            <div class="col-md-6">
	                <div class="form-group has-danger">
	                    <div class="input-group mb-2 mr-sm-2 mb-sm-0">
	                        <input type="password" name="password" class="form-control" id="password"
	                               placeholder="Password" required>
	                    </div>
	                </div>
	            </div>
	        </div>
	        <div class="row">
	            <div class="col-md-3 field-label-responsive">
	                <label for="password">Confirm Password</label>
	            </div>
	            <div class="col-md-6">
	                <div class="form-group">
	                    <div class="input-group mb-2 mr-sm-2 mb-sm-0">
	                        <input type="password" name="password-confirmation" class="form-control"
	                               id="password-confirm" placeholder="Password" required>
	                    </div>
	                </div>
	            </div>
	        </div>
	        <div class="row">
	            <div class="col-md-3"></div>
	            <div class="col-md-6">
	                <button type="submit" class="btn btn-success"><i class="fa fa-user-plus"></i> Register</button>
	            </div>
	        </div>
	    </form>
	</div>

    <jsp:include page="footer.jsp"></jsp:include>


    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>