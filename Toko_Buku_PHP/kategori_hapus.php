<?php
$sql = "DELETE from kategoritbl where id ='$_GET[id]'";
$proses = mysql_query($sql);
	if ($proses) {
	echo "<meta http-equiv='refresh' content='0;home.php?go=Kategori'>";		
	} else { echo "Data belum dapat di hapus!!"; 
	}
?>
