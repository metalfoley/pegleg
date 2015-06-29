<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../includes/header.jsp" %>
	<body ng-app="pirateApp">
        <div class="container col-md-12" id="maincontainer">
            <div id="mainbg">
            	<div class="mainHead clearfix">
	            	<h1 class="pull-right">Ahoy Capatin WoodenLeg!</h1>
	            	<p><img src="img/logo.png" alt="Logo" />Booty Management System</p>
            	</div>
            	<div class="mainBody" ng-controller="pirateCtrl">
            		<h1>{{message}}</h1>
            		<h3>Total Doubloons = 598<span></span></h3>
            		<button type="button" class="btn btn-danger btn-sm btn-convert" data-toggle="modal" data-target="#myModal">
					  Convert Ye' Ol' Booty
					</button>
					<table class="table table-striped allPirates">
				      <thead>
				        <tr>
				          <th>#</th>
				          <th>First Name</th>
				          <th>Last Name</th>
				          <th>Ship Name</th>
				          <th>Pirate Name</th>
				          <th></th>
				        </tr>
				      </thead>
				      <tbody>
				      </tbody>
				    </table>
				    <div class="progress">
					  <div class="progress-bar progress-bar-info progress-bar-striped active" role="progressbar"
					  aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" style="width:100%">
					  </div>
					</div>  
            	</div>
            </div>
            
        </div>

        <video autoplay loop poster="img/bg.png" id="bgvid">
            <source src="video/bg.webm" type="video/webm">
            <source src="video/bg.mp4" type="video/mp4">
        </video>

        <%@ include file="../includes/footer.jsp" %>
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title" id="myModalLabel">Doubloons to Dollars</h4>
		      </div>
		      <div class="modal-body">
		        <form>
					<label for="dtod">Doubloons: </label>
					<input type="text" name="dtod" id="dtod" ng-model="number"/>
					<button type="submit" id="getConversion">Submit</button>
				</form>
				<p id="conversion">{{number}}</p>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
		      </div>
		    </div>
		  </div>
		</div>
    </body>
</html>
