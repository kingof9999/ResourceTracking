<!-- 
	* managerPHCM.jsp
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
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
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
	<!-- reload list  -->
	<script type="text/javascript">
		function myFunction() {
			setTimeout(function() {
				window.location.href = './list-public-holiday.do'
			}, 3000);
		}
	</script>
	<div class="modal fade" id="popUpMessage" role="dialog">
		<div class="modal-dialog modal-sm">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">
						<bean:write name="publicHolidayForm" property="message" />
					</h4>
				</div>
			</div>
		</div>
	</div>
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
			<html:form action="/list-public-holiday" method="get">
				<div class="qlnv-control">
				<div class="row">
				<div class="col-lg-2 top-item" style="margin-right: -103px;">
					<span
					class="form-control top-item"
					style="border: none !important; box-shadow: none !important;">
						Country:
					</span>
				</div>
				<div class="col-lg-2 top-item">
					<html:select property="idCountry" styleClass="form-control top-item" style="background-color: white;">
						<option value="">-- Select Country --</option>
						<html:optionsCollection name="publicHolidayForm" property="listCountry" 
							label="nameCountry" value="idCountry"/>
					</html:select>
				</div>
				<div class="col-lg-2 top-item" style="margin-right: -130px;">
					<span
					class="form-control top-item"
					style="border: none !important; box-shadow: none !important;">
						Year:
					</span>
				</div>
				<div class="col-lg-2 top-item">
					<html:select property="year" styleClass="form-control top-item" style="background-color: white;">
						<option value="">-- Select Year --</option>
						<html:optionsCollection name="publicHolidayForm" property="listYear" 
							label="year" value="year" />
					</html:select>
				</div>
				<div class="col-lg-2 top-item"><input type="submit" name="submit"
					class="btn btn-danger" value="Filter" style="background-color: #bdbdbd; border-color: #fff;"/></div>
				</div>
				</div>
			</html:form>
			<div class="row">
	                <div class="col-md-12">
	                	<logic:notEmpty name="publicHolidayForm" property="message">
							<script type="text/javascript">
								myFunction();
								$('#popUpMessage').modal('show');
							</script>
						</logic:notEmpty>
	                    <!-- Advanced Tables -->
	                    <div class="panel panel-default">
	                        <div class="body-filter panel-body">
	                            <div class="body-filter table-responsive">
	                                <table id="tblSample" cellpadding="2" cellspacing="2" style="width: 60%; margin-left: 20%; text-align: center;" class="table table-striped table-bordered">
	                                    <thead class="headerTable">
	                                        <tr style="background-color: #bdbdbd;">
	                                            <th style="width: 45%; text-align: center;">Country</th>
	                                            <th style="text-align: center;">Date of Public Holiday</th>
	                                            <th style="text-align: center;">Delete</th>
	                                        </tr>
	                                    </thead>
	                                    <tbody>
	                                    	<tr>
	                                    		<td colspan="3">
	                                    			<p style="color: red;">
	                                    				<html:errors property="deleteError"/>
	                                    				<html:errors property="nullListError"/>
	                                    			</p>
	                                    		</td>
	                                    	</tr>
	                                        <logic:iterate id="ph" name="publicHolidayForm" property="listPublicHoliday">
	                                        	<tr>
		                                        	<td>
		                                        		<a href="#"><bean:write name="ph" property="nameCountry"/></a>
		                                        	</td>
		                                        	<td>
		                                        		<bean:write name="ph" property="datePublicHoliday"/>
		                                        	</td>
		                                        	<td>
		                                        		<bean:define id="idph" name="ph" property="idPublicHoliday"></bean:define>
		                                        		<html:link styleClass="delete" action="/deletePublicHoliday?idPublicHoliday=${idph}"><i class="glyphicon glyphicon-remove icon-delete"></i></html:link>
		                                        	</td>
		                                        </tr>
	                                        </logic:iterate>
	                                    </tbody>
	                                </table>
	                                <div class="col-sm-offset-2">
	                                	<div class="col-sm-3" style="margin-top: 21px;">
		                                	<html:link action="/addPublicHoliday" style="margin-left: 20px;" styleClass="btn btn-info">Add</html:link>
		                                </div>
		                                <div class="col-sm-7">
			                                <ul class="pagination col-sm-12" style="margin-left: 20%;">
												<bean:define id="currentPage" name="publicHolidayForm" property="currentPage"></bean:define>
												<p id="activeCP" hidden>${currentPage}</p>
									    		<c:if test="${currentPage != 1}">
									    			<li><html:link style="color: #ffffff;margin-left: 3px;background-color: #8fc6ff;border-radius: 4px;" href="list-public-holiday.do?page=${currentPage-1}">« Previous Page</html:link></li>
									            </c:if>
									            <logic:iterate name="publicHolidayForm" property="listPage" id="pag">
									            	<li class="${pag}"><html:link styleClass="${pag}" style="color: #ffffff;margin-left: 3px;background-color: #8fc6ff;border-radius: 4px;" href="list-public-holiday.do?page=${pag}" ><bean:write name="pag"/></html:link></li>
									            </logic:iterate>
									            <bean:define id="noOfPages" name="publicHolidayForm" property="noOfPages"></bean:define>
									            <c:if test="${currentPage < noOfPages}">
									                <li><html:link style="color: #ffffff;margin-left: 3px;background-color: #8fc6ff;border-radius: 4px;" href="list-public-holiday.do?page=${currentPage+1}">Next »​</html:link></li>
									            </c:if>
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
<!-- script -->
<script src="js/jquery.min.js"></script>
<script type="text/javascript">
	$(".delete").attr('data-toggle','tooltip');
	$(".delete").attr('data-placement','bottom');
	$(".delete").attr('title','Delete');
</script>
<script type="text/javascript">
	var activeCP = $("#activeCP").text();
	$("."+activeCP+"").addClass('active');
	$("."+activeCP+"").css('background-color','#337ab7');
</script>
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
</html>