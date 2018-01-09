<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
	<tr>
		<th align="center" scope="col"><font face="Tahoma, Geneva, sans-serif" color="#000000" size="3">DATA PENJUALAN</font></th>
  </tr>
	<tr>
	  <td><hr /></td>
    </tr>
	<tr>
	<td align="center">
    <table width="700" border="0" align="center" cellpadding="4" cellspacing="0">
  			<tr>
    			<td colspan="8" align="right" valign="middle" scope="col"><a href="index.php"><img src="gambar/menu.png" width="32" height="32" title="Ke Menu" /></a></td>
   		  </tr>
	  <tr>
	    <th width="7%" align="center" scope="col" bgcolor="#CCCCCC">No</th>
	    <th width="17%" align="left" scope="col" bgcolor="#CCCCCC">No Faktur</th>
	    <th width="17%" align="left" scope="col" bgcolor="#CCCCCC">Tanggal</th>
	    <th width="49%" align="right" scope="col" bgcolor="#CCCCCC">Total</th>
	    <th width="10%" align="center" scope="col" bgcolor="#CCCCCC"><font color="#FFFFFF">Aksi</font></th>
	    </tr>
	  <?php
$no=1;
$sql = "select * from transaksi_jualtbl order by id desc";
$proses = mysql_query($sql);
while ($record = mysql_fetch_array($proses))
{
$tgl = substr($record['tanggal'],8,2)."-".substr($record['tanggal'],5,2)."-". substr($record['tanggal'],0,4); 		
?>
	  <tr>
	    <td align="center" scope="col" bgcolor="#FFFFFF"><?php echo $no ?></td>
	    <td align="left" scope="col" bgcolor="#FFFFFF"><?php echo $record['id'] ?></td>
	    <td align="left" scope="col" bgcolor="#FFFFFF"><?php echo $tgl ?></td>
	    <td align="right" scope="col" bgcolor="#FFFFFF"><?php echo number_format($record['total'], 0, ',','.') ?></td>
	    <td align="center" scope="col" bgcolor="#FFFFFF"><a href="?go=Penjualan_Rincian&amp;id=<?php echo $record['id']; ?>" title="Rincian Data" target="_self"><img src="gambar/ubah.png" width="15" height="15" /></a>&nbsp;&nbsp;<a onclick="return confirm('Yakin data penjualan ini akan di hapus?');" href="?go=Penjualan_Hapus&amp;id=<?php echo $record['id']; ?>"><img src="gambar/hapus.png" width="15" height="15" /></a></td>
	    </tr>
	  <?php $no++;}?>
	  </table>
<br />
</td>
</tr>
</table>