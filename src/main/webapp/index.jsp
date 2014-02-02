<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<title>Daily Snapshot Tool</title>

	<link rel="stylesheet" href="css/jquery-ui/smoothness/jquery-ui-1.10.4.custom.css">
	<link rel="stylesheet" href="css/style.css" type="text/css">

	<script src="js/jquery-2.0.3.js"></script>
	<script src="js/jquery-ui/jquery-ui-1.10.4.custom.js"></script>
	<script src="js/jsviews.js"></script>
	<script src="js/DstUtils.js"></script>
	<script src="js/records.js"></script>

</head>
<body>
<jsp:include page="templates/record.jsp"/>
<header>
	<div id="title">
		<div>Daily Snapshot Tool</div>
		<hr/>
	</div>
	<aside>
		<a id="settings" href="#">Settings</a>
	</aside>
</header>
<div id="body">
	<a id="addRecord" href="#">Add Rec</a>
	<br/>
	<div id="records"></div>
</div>
<footer>
</footer>
</body>
</html>