<?php
class UtilityFCM {
  public function send_notification($payload_notification, $payload_data) {

    $url = 'https://fcm.googleapis.com/fcm/send';
    $fields = array(
      'to' => '/topics/agedCare',
      'priority' => 'high',
      'notification' => $payload_notification,
      'data' => $payload_data
    );
    
    $header = array(
      'Authorization: key=AAAAfXxolWg:APA91bEA8Rs5xntbpnAgKTWvzg4uTZWGF971k8Sbjfq2Tscyz5C-YKceflelxVYYJ8LtyqU49ivQ08KK-ZeoECnQmuP_Rpxv0f5i0saZF0ryRzKpLFRenyuFSgWMtYSgTsCFKBShGw19',
      'Content-Type: application/json'
    );

    $ch = curl_init();
    curl_setopt($ch, CURLOPT_URL, $url);
    curl_setopt($ch, CURLOPT_POST, true);
    curl_setopt($ch, CURLOPT_HTTPHEADER, $header);
    curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
    curl_setopt($ch, CURLOPT_SSL_VERIFYPEER, false);
    curl_setopt($ch, CURLOPT_POSTFIELDS, json_encode($fields));
    $result = curl_exec($ch);
    if ($result === FALSE) {
      die('cURL failed: ' . curl_error($ch));
    }
    curl_close($ch);
    echo $result;
  }
}
?>
