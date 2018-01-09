<?php
	include "../koneksi.php";
	
	$nama=$_POST['nama'];
    $email=$_POST['email'];
    $pesan=$_POST['pesan'];
 	$jawab=$_POST['jawab'];
	
	$tanggal=date('Y-m-d');
		
	if(!$_POST['nama'] || !$_POST['pesan'] || !$_POST['jawab'] || !$_POST['email']){
		$response["success"] = 0;
     	echo json_encode($response); 	
	}else{
		if ($jawab=="7"){
			
			$response["success"] = 1;
     		echo json_encode($response); 
			
			$namanya=$_REQUEST['nama'];
			$emailnya=$_REQUEST['email'];
			$pesannya=$_REQUEST['pesan'];
			
			$query = "INSERT INTO saran_kritiktbl (nama , email, tanggal, pesan) 
						 VALUES ('$namanya','$emailnya','$tanggal','$pesannya')";
			$result = mysql_query($query);
			if ($result) {
				$perintah="select id from saran_kritiktbl order by id DESC limit 1";
				$hasil=mysql_query($perintah);
				$data=mysql_fetch_array($hasil);
				$id_pesan=$data['id'];
				$mail_to="muhammad.sadeli@gmail.com";				
				$mail_subject="Komentar Buku Tamu dari ".$namanya." (Mobile Phone Android)";
				$mail_body ="Isi Komentar Buku Tamu dari ".$namanya." adalah sebagai berikut :\n\n";
				$mail_body.="Nama       : ".$namanya."\n";
				$mail_body.="Tanggal    : ".IndonesiaTgl($tanggal)."\n";
				$mail_body.="Email      : ".$emailnya."\n";
				$mail_body.="Komentar   : \n";
				$mail_body.=$pesannya."\n\n";
				$kirim = mail($mail_to,$mail_subject,$mail_body, "From: $emailnya");
				if ($kirim) {
					$response["success"] = 1;
					echo json_encode($response); 
				}else{
					$response["success"] = 1;
					echo json_encode($response); 
				}
			}else{
				$response["success"] = 0;
				echo json_encode($response); 
			}
		}else{
			$response["success"] = 0;
			echo json_encode($response); 
		}
	}
?>