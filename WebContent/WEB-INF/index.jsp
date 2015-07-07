<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../includes/header.jsp" %>
	<body ng-app="pirateApp" ng-controller="pirateCtrl">
        <div class="container col-md-12" id="maincontainer">
            <div id="mainbg">
            	<div class="mainHead clearfix">
	            	<h1 class="pull-right">Ahoy Capatin WoodenLeg!</h1>
	            	<p><img src="img/logo.png" alt="Logo" />Booty Management System</p>
            	</div>
            	<div class="mainBody" >
            		<h3>Total Currency = ${currency}</h3>
            		<button type="button" class="btn btn-danger btn-sm btn-convert" data-toggle="modal" data-target="#myModal">
					  Convert Ye' Ol' Booty
					</button>
					<button type="button" class="btn btn-success btn-sm" data-toggle="modal" data-target="#plunder">Plunder Ship</button>
					
					<p>{{error}}</p>
					<table class="table table-striped allPirates" ng-hide="tableHide" ng-class="{fadeIn: startFade}">
				      <thead>
				        <tr>
				          <th>First Name</th>
				          <th>Last Name</th>
				          <th>Ship Name</th>
				          <th>Pirate Name</th>
				          <th></th>
				        </tr>
				      </thead>
				      <tbody>
				      	<tr ng-repeat="pirate in pirates">
				      		<td>{{ pirate.firstName }}</td>
				      		<td>{{ pirate.lastName }}</td>
				      		<td>{{ pirate.shipName }}</td>
				      		<td>{{ pirate.pirateName }}</td>
				      		<td><a href="edit?id={{ pirate.ID }}"><button class='btn btn-danger btn-sm'>Edit</button></a></td>
				      	</tr>
				      </tbody>
				    </table>
				    <div class="progress" ng-hide="progress" ng-class="{fadeOut: startFade}">
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
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Doubloons to Dollars</h4>
        <h2>Total Doubloons: ${doubloons}</h2>
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
        <div class="modal fade" id="plunder" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title" id="myModalLabel">Ship To Plunder</h4>
		      </div>
		      <div class="modal-body">
		        <form action="edit" method="get">
						<select class="form-control" name="ships">
							<option value="" selected="selected" disabled>Select a Ship or Walk the Plank</option>
							<option value='{"ship":"S.S. Minow","doubloons":"546"}'>S.S. Minow</option>
							<option value='{"ship":"The Barbaric Abandoned","doubloons":"132"}'>The Barbaric Abandoned</option>
							<option value='{"ship":"The Sea Killer","doubloons":"3456"}'>The Sea Killer</option>
							<option value='{"ship":"The Speedy Revenge","doubloons":"432"}'>The Speedy Revenge</option>
							<option value='{"ship":"The Rising Hangman","doubloons":"333"}'>The Rising Hangman</option>
							<option value='{"ship":"Black Hydro","doubloons":"581"}'>Black Hydro</option>
							<option value='{"ship":"Bird of Thousand Colors","doubloons":"342"}'>Bird of Thousand Colors</option>
						</select>
						<div class="modal-footer">
							<button type="submit" class="btn btn-success btn-sm">Add New Crewmate</button>
							<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
		      			</div>
				</form>
		      </div> 
		    </div>
		  </div>
		</div>
        <script src="js/jquery-1.11.3.min.js"></script>
		<script src="js/progress.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<script src="js/angulartest.js"></script>
		<script src="js/main.js"></script>


    </body>
</html>
