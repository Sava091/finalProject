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
                Your Food
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


    <div class="jumbotron pt-4">
    <c:if test="${calories gt 0}">
    <div class="alert alert-danger alert-dismissible fade show" role="alert">
      <strong><fmt:message key = "limit"/></strong>
      <button type="button" class="close" data-dismiss="alert" aria-label="Close">
        <span aria-hidden="true">&times;</span>
      </button>
    </div>
    </c:if>
	    <div class="container">
	        <h3 class="text-center"><fmt:message key = "myfood"/></h3>
	        <div class="row">
	            <div class="col-3">
			        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#AddTypeModal"><fmt:message key = "addmyfood"/></button>
	            </div>
	            <div class="offset-7 col-2">
			        <form method="link" action="logoutprocess.jsp">
			            <div class="text-right">
			                <input type="submit" class="btn btn-warning" value="<fmt:message key = "logout"/>"/>
			            </div>
			        </form>
			    </div>
			</div>
			<div class="card border-dark">
		    <div class="card-body pb-0">
				<form id="Add" method="POST" action="/meal">
					<p><fmt:message key = "select"/></p>
						<div class="row">
								<div class="col-4">
										<label for="ProductName"><fmt:message key = "prodname"/></label>
										<select class="form-control" name="productId">
										    <c:forEach var="product" items="${products}">
										        <option value="${product.id}">${product.name}</option>
										    </c:forEach>
										</select>
								</div>
								<div class="offset-1 col-3">
										<label for="Date"><fmt:message key = "date1"/></label>
										 <input class="form-control" type="date" id="Date" name="date" placeholder="date" required/>
								</div>
								<div class="offset-1 col-3">
										<label for="quantity"><fmt:message key = "quantport"/></label>
										<input type="number" class="form-control" name="quantity" id="quantity" min="0" data-bind="value:replyNumber" placeholder="0" required/>
								</div>
						</div>
                        <div class="card-footer text-right">
                                <button class="btn btn-danger" type="submit">
                                        <fmt:message key = "add"/>
                                </button>
                        </div>
				</form>
		</div>

</div>
	       <table class="table table-striped" id="datatable">
	           <thead>
	           <tr>
	               <th><fmt:message key = "date1"/></th>
				   <th><fmt:message key = "prod"/></th>
	               <th><fmt:message key = "fats"/></th>
	               <th><fmt:message key = "proteins"/></th>
	               <th><fmt:message key = "carbohydr"/></th>
	               <th><fmt:message key = "cal"/></th>
	           </tr>
	           </thead>
	           <tbody>
                    <c:forEach var="meal" items="${meals}">
                        <tr>
                            <td>${meal.date}</td>
                            <td>${meal.name}</td>
                            <td>${meal.fat}</td>
                            <td>${meal.protein}</td>
                            <td>${meal.carbohydrate}</td>
                            <td>${meal.caloriesPer100gr}</td>
                        </tr>
                    </c:forEach>
	           </tbody>
	       </table>

	       <c:if test="${page - 1 ge 0}">
	        <a href="/meal?page=${page - 1}">&lt;</a>
	       </c:if>
	       <c:if test="${page - 1 lt 0}">
	        &lt;
	       </c:if>

	       <c:if test="${page + 1 lt pagesCount}">
	        <a href="/meal?page=${page + 1}">&gt;</a>
	       </c:if>
	       <c:if test="${page + 1 ge pagesCount}">
	        &gt;
	       </c:if>

	   </div>
	</div>

	<div class="modal fade" id="AddTypeModal" tabindex="-1" role="dialog" aria-labelledby="AddTypeModal" aria-hidden="true">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="AddTypeModal">Add your Product</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
				<div class="modal-body">
                   <form id="product" action="/product">
	                   <div class="form-group">
	                       <label for="description" class="col-form-label"><fmt:message key = "prodname"/></label>
	                       <input type="text" name="description" class="form-control" id="description" name="description" placeholder="<fmt:message key = "prodname"/>" required/>
	                   </div>
							<div class="form-group">
	                       <label for="fat" class="col-form-label"><fmt:message key = "fats"/></label>
	                        <input type="number" name="fat" class="form-control" id="fat" min="0" step="0.1" data-bind="value:replyNumber" placeholder="<fmt:message key = "per100gr"/>" required/>
	                   </div>
							<div class="form-group">
	                       <label for="protein" class="col-form-label"><fmt:message key = "proteins"/></label>
	                        <input type="number" name="protein" class="form-control" id="protein" min="0" step="0.1" data-bind="value:replyNumber" placeholder="<fmt:message key = "per100gr"/>" required/>
	                   </div>
							<div class="form-group">
	                       <label for="carbohydrate" class="col-form-label"><fmt:message key = "carbohydr"/></label>
	                        <input type="number" name="carbohydrate" class="form-control" id="carbohydrate" min="0" step="0.1" data-bind="value:replyNumber" placeholder="<fmt:message key = "per100gr"/>" required/>
	                   </div>

	                   <div class="form-group">
	                       <label for="calories" class="col-form-label"><fmt:message key = "cal"/></label>
	                       <input type="number" name="calories" class="form-control" id="calories" name="calories" placeholder="<fmt:message key = "per100gr"/>" required/>
	                   </div>
                            <input type="submit" class="btn btn-primary" value="<fmt:message key = "add"/>"/>
                       </div>
                   </form>
	           </div>
	         </div>
	       </div>
	    </div>

    		<jsp:include page="footer.jsp"></jsp:include>


    		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>