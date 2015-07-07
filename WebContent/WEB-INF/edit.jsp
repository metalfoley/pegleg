<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp" %><html>

<body>
	<div class="container col-md-12" id="maincontainer">
		<div id="mainbg">
		   	<div class="mainHead clearfix">
		    	<h1 class="pull-right">Ahoy Capatin WoodenLeg!</h1>
		    	<p><img src="img/logo.png" alt="Logo" />Booty Management System</p>
		   	</div>
		   	<div class="mainBody">
		   	<form id="editForm" method="post">
		   		<div class="form-group">
			   		<label for="firstName">First Name: </label>
			   		<input type="text" class="form-control" name="firstName" value="${pirate.getFirstName() }" required />
		   		</div>
		   		<div class="form-group">
			   		<label for="firstName">Last Name: </label>
			   		<input type="text" class="form-control" name="lastName" value="${pirate.getLastName() }" required />
		   		</div>
		   		<div class="form-group">
			   		<label for="firstName">Ship Name: </label>
			   		<input type="text" class="form-control" name="shipName" value="${pirate.getShipName() }" />
		   		</div>
		   		<div class="form-group">
			   		<label for="firstName">Pirate Name: </label>
			   		<input type="text" class="form-control" name="pirateName" value="${pirate.getPirateName() }" required />
		   		</div>
		   		<input type="submit" value="Shiver Me Timbers" >
		   	</form>
			</div>
	    </div>
        
    </div>

    <video autoplay loop poster="img/bg.png" id="bgvid">
        <source src="video/bg.webm" type="video/webm">
        <source src="video/bg.mp4" type="video/mp4">
    </video>

    <script src="js/jquery-1.11.3.min.js"></script>
	<script src="js/progress.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/main.js"></script>
</body>
</html>