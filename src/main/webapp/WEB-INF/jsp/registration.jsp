<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Alexis
  Date: 28/03/2019
  Time: 17:12
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">

<div class="container mt-4">
    <div class="card bg-light mt-4">
        <article class="card-body mx-auto" style="max-width: 400px;">
            <h4 class="card-title mt-3 text-center">Create Account</h4>
            <p class="text-center">Get started with your free account</p>
            <form method="post">
                <div class="form-group input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"> <i class="fa fa-envelope"></i> </span>
                    </div>
                    <input name="firstName" class="form-control" placeholder="FirstName" type="text" value="<c:out value="${firstName}" />">
                </div>
                <span><c:out value="${errors['firstName']}"/></span>
                <div class="form-group input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"> <i class="fa fa-lock"></i> </span>
                    </div>
                    <input class="form-control" name="lastName" placeholder="LastName" type="text"  value="<c:out value="${lastName}" />">
                </div>
                <span><c:out value="${errors['lastName']}"/></span>
                <div class="form-group input-group">
                    <select class="form-control" name="level" placeholder="Level">
                        <c:forEach items="${levels}" var="level">
                            <option value="<c:out value="${level}"/>"><c:out value="${level}"/></option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary btn-block"> Create Account  </button>
                </div>
            </form>
        </article>
    </div>

</div>

<br><br>
<article class="bg-secondary mb-3">
    <div class="card-body text-center">
        <h3 class="text-white mt-3">JavaEE Registration</h3>
        <p class="h5 text-white">Servlet and JSP template  <br> Alexis Mourlanne</p>   <br>
    </div>
    <br><br>
</article>
</body>
</html>

