<style type="text/css">
.main {
	margin-top: 5px;
	margin-left: 10px;
	margin-right: 10px;
	margin-bottom: 10px;
}
</style>
<div class="main">
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
	<tr>
		<th align="center" scope="col"><font face="Tahoma, Geneva, sans-serif" color="#000000" size="3">KATEGORI BUKU</font></th>
		</tr>
	<tr>
	  <td><hr /></td>
    </tr>
	<tr>
	<td>
		<table width="400" border="0" align="center" cellpadding="4" cellspacing="1">
  			<tr>
    			<td colspan="4" align="right" valign="middle" scope="col"><a href="index.php"><img src="gambar/menu.png" width="32" height="32" title="Ke Menu" /></a>&nbsp;&nbsp;<a href="home.php?go=Kategori_Tambah"><img src="gambar/tambah.png" width="32" height="32" title="Tambah Data" /></a></td>
   		  </tr>
          	<tr>
                <th width="9%" align="center" bgcolor="#06988b" scope="col"><font face="Tahoma, Geneva, sans-serif" size="2" color="#FFFFFF">No</font></th>
                <th width="29%" align="left" bgcolor="#06988b" scope="col"><font face="Tahoma, Geneva, sans-serif" size="2" color="#FFFFFF">Kode Kategori</font></th>
              <th width="49%" align="left" bgcolor="#06988b" scope="col"><font face="Tahoma, Geneva, sans-serif" size="2" color="#FFFFFF">Nama Kategori</font></th>    
              <th width="13%" align="Center" bgcolor="#06988b" scope="col"><font face="Tahoma, Geneva, sans-serif" size="2" color="#FFFF00">Aksi</font></th>
		  </tr>

<?php
$no=1;
$sql = "select * from kategoritbl order by id asc";
$proses = mysql_query($sql);
$totrecord = mysql_num_rows($proses);
while ($record = mysql_fetch_array($proses))
{
?>
  <tr>
    <td align="center" scope="col"><font face="Tahoma, Geneva, sans-serif" size="2"><?php echo $no ?></font></td>
    <td align="left" scope="col"><font face="Tahoma, Geneva, sans-serif" size="2"><?php echo $record['kode_kategori'] ?></font></td>
    <td align="left" scope="col"><font face="Tahoma, Geneva, sans-serif" size="2"><?php echo $record['nama_kategori']?></font></td>
    <th align="Center" scope="col"><a href="?go=Kategori_Hapus&amp;id=<?php echo $record['id']; ?>"><img src="gambar/hapus.png" width="15" height="15" title="Hapus" /></a></th>
  </tr>
  <?php $no++;}?>
  <tr>
    <td colspan="4" align="left" scope="col" bgcolor="#FFFFFF"><hr /></td>
  </tr>
  <tr>
    <td colspan="4" align="left" scope="col" bgcolor="#FFFFFF"><font face="Tahoma, Geneva, sans-serif" size="2"><b>Jumlah : </b><?php echo $totrecord ?></font></td>
  </tr>
</table>
</td>
</tr>
</table>
</div>