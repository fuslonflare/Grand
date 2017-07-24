<?php
	class store_log {
		public function store_history($behavior) {
			$msgResult;
			//$behavior = $_POST['behaviorId'];
			require_once('open_connection.php');

			$sql_command = "INSERT INTO history (`behavior`)
							VALUES('$behavior')";
			
			if (mysqli_query ($conn, $sql_command)) {
				$msgResult = 'Successfully to insert data.';
			} else {
				$msgResult = 'Unable to update status, Please try again later~';
			}
			echo json_encode(array("result"=>$msgResult));
			mysqli_close($conn);
		}
	}
?>