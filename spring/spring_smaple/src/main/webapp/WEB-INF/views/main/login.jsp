<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
	<style type="text/css">
		.card-columns .card {
		    margin-bottom: 0.75rem;
		}
		
		@media (min-width: 576px) {
		    .card-columns {
		        column-count: 3;
		        column-gap: 1.25rem;
		    }
		    .card-columns .card {
		        display: inline-block;
		        width: 100%;
		    }
		}
		.text-muted {
		    color: #9faecb !important;
		}
		
		p {
		    margin-top: 0;
		    margin-bottom: 1rem;
		}
		.mb-3 {
		    margin-bottom: 1rem !important;
		}
		
		.input-group {
		    position: relative;
		    display: flex;
		    width: 100%;
		}
	</style>
</head>
<body>

<div class="row justify-content-center">
  <div class="col-md-8">
    <div class="card-group mb-0">
      <div class="card p-4">
        <form class="card-body" action="<c:url value="/login"/>" method="post">
          <h1>Login</h1>
          <p class="text-muted">Sign In to your account</p>
          <div class="input-group mb-3">
            <span class="input-group-addon"><i class="fa fa-user"></i></span>
            <input type="text" class="form-control" placeholder="Username" name="me_id">
          </div>
          <div class="input-group mb-4">
            <span class="input-group-addon"><i class="fa fa-lock"></i></span>
            <input type="password" class="form-control" placeholder="Password" name="me_pw">
          </div>
          <div class="row">
            <div class="col-6">
              <button type="submit" class="btn btn-primary px-4">Login</button>
            </div>
            <div class="col-6 text-right">
              <button type="button" class="btn btn-link px-0">Forgot password?</button>
            </div>
          </div>
        </form>
      </div>
      <div class="card text-white bg-primary py-5 d-md-down-none" style="width:44%">
        <div class="card-body text-center">
          <div>
            <h2>Sign up</h2>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
            <button type="button" class="btn btn-primary active mt-3">Register Now!</button>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>

</body>
</html>
