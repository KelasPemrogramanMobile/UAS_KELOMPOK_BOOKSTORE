<?php
$sql = "DELETE from transaksi_jual_rincitbl where no_faktur ='$_GET[id]'";
$proses = mysql_query($sql);

$sql = "DELETE from transaksi_jualtbl where no_faktur ='$_GET[id]'";
$proses = mysql_query($sql);

	if ($proses) {
		echo "<script>alert('Penghapusan data transaksi jual berhasil !')</script>";
		echo "<meta http-equiv='refresh' content='0;home.php?go=Penjualan'>";
	} else { 
		echo "<script>alert('Penghapusan data transaksi jual tidak berhasil !')</script>";
		echo "<meta http-equiv='refresh' content='0;home.php?go=Penjualan'>";
	}
?>
