<?php 	
	include "../koneksi.php";
	$respon = array();
	$email=$_POST['email'];
	$result = mysql_query("SELECT * FROM transaksi_jualtbl inner join transaksi_jual_rincitbl on transaksi_jualtbl.id = transaksi_jual_rincitbl.id inner join bukutbl on bukutbl.kode_buku = transaksi_jual_rincitbl.kode_buku where transaksi_jualtbl.email='$email' and transaksi_jualtbl.status ='1'") or die(mysql_error());
	
	if (mysql_num_rows($result) > 0) {
		$respon["Data_BK"] = array();
		while ($row = mysql_fetch_array($result)) {
			$Data_BK = array();
			$Data_BK["cover"] = $row['cover'];		
			
			if (strlen($row['judul_buku']) > 45) {
				$judul = "".substr($row['judul_buku'], 0, 45)." ...";
			}else {
				$judul = $row['judul_buku'];
			}
				
			$Data_BK["judul"] = $judul;
			$Data_BK["penulis"] = $row['pengarang'];
			$Data_BK["kode_buku"] = $row['kode_buku'];	
			$Data_BK["harga"] = number_format($row['harga'], 0, ',','.');	
			
			$deskripsi = "".substr($row['deskripsi'], 0, 175)." ...";
			
			$Data_BK["deskripsi"] = $deskripsi;							
			$Data_BK["rating"] = $row['rating'];	

			array_push($respon["Data_BK"], $Data_BK);
		}
		$respon["sukses"] = 1;
		echo json_encode($respon);
	} else {
		$respon["sukses"] = 0;
		echo json_encode($respon);
	}
?>
