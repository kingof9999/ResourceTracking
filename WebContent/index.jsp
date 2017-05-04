<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="s" uri="http://struts.apache.org/tags-faces" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Index Page</title>
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
<script>
	function autoClick(){
		document.getElementById('click').click();
	}
</script>
<title>Đang tải...</title>
</head>
<body onload="setTimeout('autoClick();', 3000);">
	<center>
		<span>bạn sẽ tự động chuyển sang trang chủ sau 3s!!!</span>
	</center>
	<center>
		<i class="fa fa-spinner fa-spin fa-3x fa-fw"></i><br/>Hoặc<br/>
		<html:link style="color: #2f937b;" styleId="click" action="/list-public-holiday">Bấm vào đây để vào trang chủ</html:link>
	</center>
</body>
</html>