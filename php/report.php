<?php
	include_once('open_connection.php');

	$sql = "SELECT * FROM history ORDER BY `time_stamp` DESC";
	$queried = $conn -> query($sql);

	$result = array();
	while ($record = mysqli_fetch_array($queried)) {
		array_push($result, array(
			"behavior" => $record['behavior'],
			"time_stamp" => $record['time_stamp']));
	}

	echo json_encode($result);
	mysqli_close($conn);
?>