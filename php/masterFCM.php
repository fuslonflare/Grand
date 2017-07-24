<?php
	
	$behavior = $_POST['behavior'];

	include_once 'UtilityFCM.php';
	include_once 'store_log.php';
	
	$notification = array(
		'title' => 'Alert!',
		'body' => $behavior,
		'sound' => 'default',
		'icon' => 'myicon/ic_done_black_24dp.xml',
		'click_action' => 'OPEN_ACTIVITY'
	);
	$data = array(
		'message' => $behavior
	);
	$fcm = new UtilityFCM();
	$log = new store_log();

	$fcm -> send_notification($notification, $data);
	$log -> store_history($behavior);
?>