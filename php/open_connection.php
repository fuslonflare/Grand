<?php
	define('HOST',	'mysql.hostinger.in');
	define('USER',	'u840414725_44214');
	define('PASS',	'PocketMonsteR');
	define('DB',	'u840414725_elder');

	$conn = mysqli_connect(HOST, USER, PASS, DB);
	       
	if (!$conn) die("Connection failed: " .mysqli_connect_error());
?>