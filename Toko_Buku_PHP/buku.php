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
	<th align="center" scope="col"><font face="Tahoma, Geneva, sans-serif" color="#000000" size="3">DATA BUKU</font></th>
		</tr>
	<tr>
	  <td><hr /></td>
    </tr>
	<tr>
	<td>
		<table width="850" border="0" align="center" cellpadding="4" cellspacing="1">
  			<tr>
    			<td colspan="9" align="right" valign="middle" scope="col"><a href="index.php"><img src="gambar/menu.png" width="32" height="32" title="Ke Menu" /></a>&nbsp;&nbsp;<a href="home.php?go=Buku_Tambah"><img src="gambar/tambah.png" width="32" height="32" title="Tambah Data" /></a></td>
   		  </tr>
          
<?php
$sql = "select * from  kategoritbl inner join bukutbl on bukutbl.kode_kategori = kategoritbl.kode_kategori group by kategoritbl.kode_kategori order by kategoritbl.id asc";
$proses = mysql_query($sql);
while ($record = mysql_fetch_array($proses)) 
{
?>

 	<tr>
    <td colspan="9"align="left" scope="col"><font face="Tahoma, Geneva, sans-serif" size="2"><b>Kategori : </b><?php echo $record['nama_kategori']?></font>
    </td>
  </tr>          
          	<tr>
              <th width="5%" align="center" bgcolor="#06988b" scope="col"><font face="Tahoma, Geneva, sans-serif" size="2" color="#FFFFFF">No</font></th>
              <th width="13%" align="center" bgcolor="#06988b" scope="col"><font face="Tahoma, Geneva, sans-serif" size="2" color="#FFFFFF">Cover</font></th>
              <th width="13%" align="left" bgcolor="#06988b" scope="col"><font face="Tahoma, Geneva, sans-serif" size="2" color="#FFFFFF">Kode</font></th>
              <th width="42%" align="left" bgcolor="#06988b" scope="col"><font face="Tahoma, Geneva, sans-serif" size="2" color="#FFFFFF">Judul Buku</font></th>
              <th width="20%" align="left" bgcolor="#06988b" scope="col"><font face="Tahoma, Geneva, sans-serif" size="2" color="#FFFFFF">Pengarang</font></th>
              <th width="12%" align="right" bgcolor="#06988b" scope="col"><font face="Tahoma, Geneva, sans-serif" size="2" color="#FFFFFF">Harga</font></th>  
              <th width="8%" align="Center" bgcolor="#06988b" scope="col"><font face="Tahoma, Geneva, sans-serif" size="2" color="#FFFF00">Aksi</font></th>
		  </tr>

<?php
$no=1;
$sql1 = "select * from bukutbl where kode_kategori ='$record[kode_kategori]' order by id asc";
$proses1 = mysql_query($sql1);
while ($record1 = mysql_fetch_array($proses1)) 
{
?>

  <tr>
    <td align="center" scope="col"><font face="Tahoma, Geneva, sans-serif" size="2"><?php echo $no ?></font></td>
    <td align="center" scope="col"><img src="Cover/<?php echo $record1['cover'] ?>" width="80" height="110" border="1"></td>
    <td align="left" scope="col"><font face="Tahoma, Geneva, sans-serif" size="2"><?php echo $record1['kode_buku'] ?></font></td>
    <td align="left" scope="col"><font face="Tahoma, Geneva, sans-serif" size="2"><?php echo $record1['judul_buku']?></font></td>
    <td align="left" scope="col"><font face="Tahoma, Geneva, sans-serif" size="2"><?php echo $record1['pengarang']?></font></td>
    <td align="right" scope="col"><font face="Tahoma, Geneva, sans-serif" size="2"><?php echo number_format($record1['harga'], 0, ',','.') ?></font></td>
    <th align="Center" scope="col"><a href="?go=Buku_Hapus&amp;id=<?php echo $record1['id']; ?>"><img src="gambar/hapus.png" width="15" height="15" title="Hapus" /></a></th>
  </tr>
  <?php $no++;}?>
  
   <tr>
     <td colspan="9"align="left" scope="col"><hr /></td>
   </tr>
   <tr>
    <td colspan="9"align="left" scope="col"><font face="Tahoma, Geneva, sans-serif" size="2"><b>Jumlah : </b><?php echo $no-1; } ?></font></td>
  </tr>  
    <tr>
    <td colspan="9" align="center" scope="col" bgcolor="#FFFFFF">&nbsp;</td>
  </tr>
</table>
<br />
</td>
</tr>
</table>
</div>