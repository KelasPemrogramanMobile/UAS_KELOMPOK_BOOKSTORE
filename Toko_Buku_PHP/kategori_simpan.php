<?php
$sql = "INSERT INTO kategoritbl(kode_kategori,nama_kategori) VALUES ('$_POST[kdkategoritxt]','$_POST[nmkategoritxt]')";
$proses = mysql_query($sql);
	if ($proses) {
		header("location:home.php?go=Kategori");
	} else { echo "Data belum dapat di simpan!!"; 
	}
?>