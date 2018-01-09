<?php
	include "../koneksi.php";
	
	$email=$_POST['email'];	
	
	$result = mysql_query("SELECT * FROM transaksi_jualtbl where email='$email' and status='1'") or die(mysql_error());
		if (mysql_num_rows($result) > 0) {
			$query = "UPDATE transaksi_jualtbl set status = '0' where email='$email'";
			$result2 = mysql_query($query);
				
			$response["success"] = 1;
			echo json_encode($response); 
		}
?>