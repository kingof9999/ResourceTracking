<!-- 
	* addPHCM.jsp
	*
	* version 1.4
	*
	* Date: 26/04/2017
 	*
 	* Copyright
 	* 
 	* Modification Logs:
 	* DATE				AUTHOR			DECRIPTION
 	* -------------------------------------------
 	* 08/05/2017		TinLQ			Create
 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add New</title>
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link
	href="http://cdn.datatables.net/plug-ins/a5734b29083/integration/bootstrap/3/dataTables.bootstrap.css"
	rel="stylesheet">
<link
	href="http://cdn.datatables.net/responsive/1.0.1/css/dataTables.responsive.css"
	rel="stylesheet">
<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet" href="css/myStyle.css" />
<!-- TABLE STYLES-->
<link href="js/dataTables/dataTables.bootstrap.css" rel="stylesheet" />
</head>
<body>
	<div class="container">
		<div class="header">
			<div class="header-top"></div>
			<div class="header-bottom"></div>
			<nav class="navbar navbar-default center-block">
				<div class="container-fluid">
					<div class="navbar-header">
	  					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#menu-collapse" aria-expanded="false">
					        <span class="sr-only">Toggle navigation</span>
					        <span class="icon-bar"></span>
					        <span class="icon-bar"></span>
					        <span class="icon-bar"></span>
	  					</button>
					</div>
	
					<div class="collapse navbar-collapse" id="menu-collapse">
						<ul class="nav navbar-nav">
							<li><a href="#">My Profile</a></li>
							<li><a href="#">Account Course</a></li>
							<li><a href="#">Account</a></li>
							<li><a href="#">Account Certificate</a></li>
							<li><a href="#">Language Score</a></li>
							<li><a href="#">Report</a></li>
							<li><a href="#">Security</a></li>
						</ul>
					</div>
				</div>
			</nav>
		</div>
		<div class="body">
			<div class="main-form col-md-12">
			<div class="top-text row" style="background-color: #bdbdbd;">
				<a href="#" style="margin-left: 20px;">
				<img border="0" src="img/a.png" width="15" height="15">
				</a>
				<span>Add Public Holiday Calendars...</span>
			</div>
			<div class="body-filter row">
				<div class="col-sm-12">
					<div class="col-sm-12" style="border: groove; margin-top: 30px;">
						<html:form action="/addPublicHoliday" method="post">
							<div style="margin-top: 10px;">
								Country:
								<html:select property="idCountry" style="margin-left: 30px;" styleId="country">
									<html:optionsCollection name="publicHolidayForm" property="listCountry" 
										label="nameCountry" value="idCountry" />
								</html:select>
								<span style="color: red;"><html:errors property="addCountryExistError"/></span>
							</div>
							<div style="margin-top: 10px;">
								Date of Public Holiday(dd/mm/yyyy)<span style="color: red;">(*)</span>: <span style="color: red;">
								<html:errors property="addNullError"/>
								<html:errors property="addTypeError"/>
								<html:errors property="addExistDateError"/>
								</span><br>
								<div style="margin-left: 170px;" id="dateCheckBox">
								
								</div>
								<div>
									<a id="btnAddnew" href="#" style="margin: 10px 0 0 15px; padding-left: 86px;">Add more</a>
								</div>
							</div>
							<div style="margin-left: 100px;">
								<button class="btn btn-default" id="remove">Clear</button>
								<html:submit styleId="submit" styleClass="btn btn-default" property="submit" value="Add">Add</html:submit>
								<html:link styleClass="btn btn-default" action="/list-public-holiday">Cancel</html:link>
							</div>
							<br>
						</html:form>
					</div>
				</div>
				</div>
			</div>
			<div class="footer">
			</div>
		</div>
	</div>
</body>
<!-- script -->
<script src="js/jquery.min.js"></script>
<script type="text/javascript">
	$("#country").focus();
	
	$('body').keydown(function(e) {
	    if (e.keyCode == 27) {
	        $('#remove').click();
	    }    
	});
</script>
<script type="text/javascript">
	function deleteFunction(iCnt) {
	    var r = confirm("Are you sure you want to delete this record?");
	    if (r == true) {
	    	var textRemove = '#'+iCnt;
	    	$(textRemove).remove();
	    } else {
	        txt = "You pressed Cancel!";
	    }
	}
	
	$('#btnAddnew').click(function() {
		var iCnt = 0;
		if (iCnt <= 19) {
			iCnt = iCnt + 1;
			
			$('#dateCheckBox').append('<div id=cb'+iCnt+'> ' +
					'<input name="publicHoliday" type=date style="margin: 10px 0 0 15px;" id=cb' + iCnt + ' ' +
                    'value="Text Element ' + iCnt + '" />' +
                    '<a href="#" onclick="deleteFunction('+"'"+'cb'+iCnt+"'"+')"><span style="margin-left: 10px 0 0 15px;"><i class="glyphicon glyphicon-remove icon-delete"></i></a></span></br></div>');
		}
	});
</script>

<!-- DATA TABLE SCRIPTS -->
    <script src="js/dataTables/jquery.dataTables.js"></script>
    <script src="js/dataTables/dataTables.bootstrap.js"></script>
    <script>
            $(document).ready(function () {
                $('#dataTables-example').dataTable();
            });
    </script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#example').DataTable( {
			"bPaginate" : false,
			"bFilter" : false,
			"bInfo" : true,
			"paging" : true,
			"bLengthChange" : false,
			"pagingType" : "full_numbers"
		});

	});
</script>

<script type="text/javascript">
	$('body').on('keydown', 'input, select, textarea', function(e) {
	    var self = $(this)
	      , form = self.parents('form:eq(0)')
	      , focusable
	      , next
	      ;
	    if (e.keyCode == 13) {
	        focusable = form.find('input,a,select,button,textarea').filter(':visible');
	        next = focusable.eq(focusable.index(this)+1);
	        if (next.length) {
	            next.focus();
	        } else {
	            form.submit();
	        }
	        return false;
	    }
	});
</script>
</html>