<style type="text/css">
.main {
	margin-top: 5px;
	margin-left: 10px;
	margin-right: 10px;
	margin-bottom: 10px;
}
</style>

<?php
$sql = "select * from kategoritbl order by id desc";
$proses = mysql_query($sql);
$record = mysql_fetch_array($proses)
?>
<div class="main">
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
	<tr>
		<th align="left" scope="col"><font face="Tahoma, Geneva, sans-serif" color="#000000" size="3">TAMBAH DATA KATEGORI</font></th>
  </tr>
	<tr>
	  <td><hr /></td>
  </tr>
	<tr>
	<td>
<form id="form1" name="form1" method="post" action="home.php?go=Kategori_Simpan">
  <table width="400" border="0" align="center">
    <tr>
      <td align="left" valign="middle"><a href="home.php?go=Kategori"><img src="gambar/menu.png" alt="" width="32" height="32" title="Ke Menu" /></a></td>
      <td align="left" valign="middle">&nbsp;</td>
      <td align="left" valign="top">&nbsp;</td>
    </tr>
    <tr>
      <td width="30%" align="left" valign="middle">Kode Kategori</td>
      <td width="2%" align="left" valign="middle">:</td>
      <td width="68%" align="left" valign="top"><input name="kdkategoritxt" type="text" id="kdkategoritxt" size="5" maxlength="5" value="<?php echo "K-"; echo $record['id']+1 ?>" readonly="readonly" /></td>
    </tr>
    <tr>
      <td align="left" valign="middle">Nama Kategori</td>
      <td align="left" valign="middle">:</td>
      <td align="left" valign="top"><input name="nmkategoritxt" type="text" id="nmkategoritxt" size="35" maxlength="50" /></td>
    </tr>
    <tr>
      <td align="left" valign="top">&nbsp;</td>
      <td align="left" valign="top">&nbsp;</td>
      <td align="left" valign="top">&nbsp;</td>
    </tr>
    <tr>
      <td align="left" valign="top">&nbsp;</td>
      <td align="left" valign="top">&nbsp;</td>
      <td align="left" valign="top"><label>
        <input type="submit" name="Submit" value="Simpan" />
        </label>
        </span></td>
    </tr>
  </table>
</form>
</td>
</tr>
</table>