<?php	
	include "../koneksi.php";

	$nama=$_POST['nama'];	
    $alamat=$_POST['alamat'];	
    $email=$_POST['email'];	
 	$telepon=$_POST['telepon'];
		
	if(!$_POST['nama'] || !$_POST['alamat'] || !$_POST['email'] || !$_POST['telepon']){
		$response["success"] = 0;
     	echo json_encode($response); 	
	}else{
		
		$response["success"] = 1;
     	echo json_encode($response); 
		
		$nama=$_REQUEST['nama'];
		$alamat=$_REQUEST['alamat'];
		$email=$_REQUEST['email'];
		$telepon=$_REQUEST['telepon'];				
			
		$cari="select * from pelanggantbl where email='$email'";
		$qrycr=mysql_query($cari);
		if(mysql_num_rows($qrycr) > 0){		
			$query0 = "UPDATE pelanggantbl set nama = '$nama', alamat = '$alamat', 
			telepon = '$telepon' where email = '$email'";
			$result0 = mysql_query($query0);
			if ($result0) {
				$response["success"] = 1;
				echo json_encode($response); 
			}else{
				$response["success"] = 0;
				echo json_encode($response); 
			}			
		}else{	
			$query1 = "INSERT INTO pelanggantbl (nama, alamat, email, telepon) 
							 VALUES ('$nama','$alamat','$email','$telepon')";						
			$result1 = mysql_query($query1);
			if ($result1) {
				$response["success"] = 1;
				echo json_encode($response); 
			}else{
				$response["success"] = 0;
				echo json_encode($response); 
			}					
		}
	}
?>