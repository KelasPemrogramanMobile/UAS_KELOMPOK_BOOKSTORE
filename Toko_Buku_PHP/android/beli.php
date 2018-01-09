<?php
	include "../koneksi.php";
	
	$kode=$_POST['kode'];
	$email=$_POST['email'];	
    $tanggal=date("Y-m-d");
    $total=str_replace(".","",$_POST['total']);
	
	$tanggal=date('Y-m-d');
		
	if(!$_POST['kode']){
		$response["success"] = 0;
     	echo json_encode($response); 	
	}else{
		$result0 = mysql_query("SELECT * FROM pelanggantbl where email='$email'") or die(mysql_error());
		if (mysql_num_rows($result0) > 0) {
			
			$result1 = mysql_query("SELECT * FROM transaksi_jualtbl where email='$email' and status='1'") or die(mysql_error());
			if (mysql_num_rows($result1) <= 0) {
				$query0 = "INSERT INTO transaksi_jualtbl (tanggal,email,total,status) 
								 VALUES ('$tanggal','$email','$total','1')";
				$result2 = mysql_query($query0);
			} else {
				$query2 = "UPDATE transaksi_jualtbl set total = total+$total where email='$email' and status='1'";
				$result5 = mysql_query($query2);
			}
							
				$result3 = mysql_query("SELECT * FROM transaksi_jualtbl where email='$email' and status='1'") or die(mysql_error());
				$row = mysql_fetch_array($result3);
				
				$query1 = "INSERT INTO transaksi_jual_rincitbl (id,kode_buku,harga,jumlah,sub_total) 
							 VALUES ('".$row['id']."','$kode','$total','1','$total')";
				$result4 = mysql_query($query1);
								
				$response["success"] = 1;
				echo json_encode($response); 

		}else{
			$response["success"] = 0;
			echo json_encode($response); 
		}
	}
?>