<?php 
	include "../koneksi.php";
	$respon = array();
	$result = mysql_query("SELECT * FROM saran_kritiktbl ORDER BY id desc LIMIT 0,25") or die(mysql_error());
	
	if (mysql_num_rows($result) > 0) {
		$respon["Data_SK"] = array();
		
		while ($row = mysql_fetch_array($result)) {
			$Data_SK = array();
			$Data_SK["nama"] = $row["nama"];
			$Data_SK["tanggal"] =  substr($row['tanggal'],8,2)."-".substr($row['tanggal'],5,2)."-". substr($row['tanggal'],0,4); 
			$Data_SK["email"] = $row["email"];
			$Data_SK["pesan"] = $row["pesan"];		
			
			array_push($respon["Data_SK"], $Data_SK);
		}

		$respon["sukses"] = 1;
		echo json_encode($respon);
	} else {
		$respon["sukses"] = 0;
		echo json_encode($respon);
	}
?>
