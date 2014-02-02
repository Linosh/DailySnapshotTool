<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<title>Daily Snapshot Tool</title>

	<link rel="stylesheet" href="css/jquery-ui/smoothness/jquery-ui-1.10.4.custom.css">
	<link rel="stylesheet" href="css/style.css" type="text/css">

	<script src="js/jquery/jquery-2.0.3.js"></script>
	<script src="js/jquery/jquery-ui/jquery-ui-1.10.4.custom.js"></script>
	<script src="js/jquery/jquery.json-2.4.js"></script>
	<script src="js/templates/jsviews.js"></script>
	<script src="js/dst/utils/GlobalUtils.js"></script>
	<script src="js/dst/utils/RPC.js"></script>
	<script src="js/dst/records/RecordUtils.js"></script>
	<script src="js/dst/records/records.js"></script>

</head>
<body>
<jsp:include page="templates/records/editableRecord.jsp"/>
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