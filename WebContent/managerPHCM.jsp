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
<title>Public Holiday Manager</title>
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link
	href="http://cdn.datatables.net/plug-ins/a5734b29083/integration/bootstrap/3/dataTables.bootstrap.css"
	rel="stylesheet">
<link
	href="http://cdn.datatables.net/responsive/1.0.1/css/dataTables.responsive.css"
	rel="stylesheet">
<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet" href="css/myStyle.css" />
<script src="js/jquery.min.js"></script>

<!-- dataTable -->
<script
	src="http://cdn.datatables.net/1.10.2/js/jquery.dataTables.min.js"></script>
<script
	src="http://cdn.datatables.net/responsive/1.0.1/js/dataTables.responsive.min.js"></script>
<script
	src="http://cdn.datatables.net/plug-ins/a5734b29083/integration/bootstrap/3/dataTables.bootstrap.js"></script>
<script
	src="https://cdn.datatables.net/rowgroup/1.0.0/css/rowGroup.dataTables.min.css"></script>
<script
	src="https://cdn.datatables.net/rowgroup/1.0.0/js/dataTables.rowGroup.min.js"></script>
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
			<span>List Public Holiday Calendars</span>
		</div>
		<div class="body-filter row">
			<form action="/#" method="get">
				<div class="qlnv-control">
				<div class="row">
				<div class="col-lg-2 top-item" style="margin-right: -103px;">
					<span
					class="form-control top-item"
					style="border: none !important; box-shadow: none !important;">
						Country:
					</span>
				</div>
				<div class="col-lg-2 top-item"><select name="option" class="form-control top-item">
					<option value="0">Singapore</option>
					<option value="1">Vietnam</option>
					<option value="2">Japanese</option>
				</select></div>
				<div class="col-lg-2 top-item" style="margin-right: -130px;">
					<span
					class="form-control top-item"
					style="border: none !important; box-shadow: none !important;">
						Year:
					</span>
				</div>
				<div class="col-lg-2 top-item"><select name="option" class="form-control top-item">
					<option value="0">2010</option>
					<option value="1">2011</option>
					<option value="2">2012</option>
				</select></div>
				<div class="col-lg-2 top-item"><input type="submit" name="submit"
					class="btn btn-danger" value="Filter" /></div>
				</div>
				</div>
			</form>
			<div class="row">
	                <div class="col-md-12">
	                    <!-- Advanced Tables -->
	                    <div class="panel panel-default">
	                        <div class="body-filter panel-body">
	                            <div class="body-filter table-responsive">
	                                <table id="tblSample" cellpadding="2" cellspacing="2" style="width: 60%; margin-left: 20%; text-align: center;" class="table table-striped table-bordered">
	                                    <thead class="headerTable">
	                                        <tr>
	                                            <th style="width: 45%">Country</th>
	                                            <th>Date of Public Holiday</th>
	                                            <th>Delete</th>
	                                        </tr>
	                                    </thead>
	                                    <tbody>
	                                        <logic:iterate id="ph" name="publicHolidayForm" property="listPublicHoliday">
	                                        	<tr>
		                                        	<td><bean:write name="ph" property="nameCountry"/></td>
		                                        	<td>
		                                        		<bean:write name="ph" property="datePublicHoliday"/>
		                                        	</td>
		                                        	<td><a href="#"><i class="glyphicon glyphicon-remove icon-delete"></i></a></td>
		                                        </tr>
	                                        </logic:iterate>
	                                    </tbody>
	                                </table>
	                                <div class="col-sm-offset-2">
	                                	<div class="col-sm-3">
	                                		<a href="addPHCM.jsp" style="margin-left: 20px;" class="btn btn-info">Add</a>
		                                </div>
		                                <div class="col-sm-7">
			                                <ul class="pagination">
			                                	<li><a href="#" style="color: #ffffff;margin-left: 3px;background-color: #8fc6ff;border-radius: 4px;"><< Previous Page</a></li>
											    <li><a href="#" style="color: #ffffff;margin-left: 3px;background-color: #8fc6ff;border-radius: 4px;">1</a></li>
											    <li class="active"><a href="#" style="color: #ffffff;margin-left: 3px;background-color: #397ab7;border-radius: 4px;">2</a></li>
											    <li><a href="#" style="color: #ffffff;margin-left: 3px;background-color: #8fc6ff;border-radius: 4px;">3</a></li>
											    <li><a href="#" style="color: #ffffff;margin-left: 3px;background-color: #8fc6ff;border-radius: 4px;">4</a></li>
											    <li><a href="#" style="color: #ffffff;margin-left: 3px;background-color: #8fc6ff;border-radius: 5px;">...</a></li>
											    <li><a href="#" style="color: #ffffff;margin-left: 3px;background-color: #8fc6ff;border-radius: 5px;">5</a></li>
											    <li><a href="#" style="color: #ffffff;margin-left: 3px;background-color: #8fc6ff;border-radius: 5px;">Next Page >></a></li>
											</ul>
		                                </div>
	                                </div>
	                            </div>
	                            
	                        </div>
	                    </div>
	                    <!--End Advanced Tables -->
	                </div>
	            </div>
		</div>
		<div class="body-table row">
		
		</table>
		</div>
	</div>
	<div class="footer">
	</div>
</div>
</div>
</body>
</html>
<!-- JS Merge table -->
<script type="text/javascript">
	$(document).ready(function () {
	    $('#tblSample').each(function () {
	        var Column_number_to_Merge = 1;
	
	        // Previous_TD holds the first instance of same td. Initially first TD=null.
	        var Previous_TD = null;
	        var i = 1;
	        $("tbody",this).find('tr').each(function () {
	            // find the correct td of the correct column
	            // we are considering the table column 1, You can apply on any table column
	            var Current_td = $(this).find('td:nth-child(' + Column_number_to_Merge + ')');
	             
	            if (Previous_TD == null) {
	                // for first row
	                Previous_TD = Current_td;
	                i = 1;
	            }
	            else if (Current_td.text() == Previous_TD.text()) {
	                // the current td is identical to the previous row td
	                // remove the current td
	                Current_td.remove();
	                // increment the rowspan attribute of the first row td instance
	                Previous_TD.attr('rowspan', i + 1);
	                i = i + 1;
	            }
	            else {
	                // means new value found in current td. So initialize counter variable i
	                Previous_TD = Current_td;
	                i = 1;
	            }
	        });
	    });
	});
</script>