<?php
$sql = "INSERT INTO bukutbl(kode_buku,judul_buku,pengarang,harga,deskripsi,kode_kategori,cover) VALUES ('$_POST[kdbukutxt]','$_POST[judultxt]','$_POST[pengarangtxt]','$_POST[hrgtxt]','$_POST[deskripsitxt]','$_POST[kategorilist]','$_POST[cover]')";
$proses = mysql_query($sql);
	if ($proses) {
		header("location:home.php?go=Buku");
	} else { echo "Data belum dapat di simpan!!"; 
	}
?>