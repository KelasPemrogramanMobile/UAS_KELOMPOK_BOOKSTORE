<style type="text/css">
.main {
	margin-top: 5px;
	margin-left: 10px;
	margin-right: 10px;
	margin-bottom: 10px;
}
</style>

<?php
$sql = "select * from bukutbl order by id desc";
$proses = mysql_query($sql);
$record = mysql_fetch_array($proses)
?>
<div class="main">
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
	<tr>
		<th align="left" scope="col"><font face="Tahoma, Geneva, sans-serif" color="#000000" size="3">TAMBAH DATA BUKU</font></th>
  </tr>
	<tr>
	  <td><hr /></td>
  </tr>
	<tr>
	<td>
<form id="form1" name="form1" method="post" action="home.php?go=Buku_Simpan">
  <table width="450" border="0" align="center">
    <tr>
      <td align="left" valign="middle"><a href="home.php?go=Buku"><img src="gambar/menu.png" alt="" width="32" height="32" title="Ke Menu" /></a></td>
      <td align="left" valign="middle">&nbsp;</td>
      <td align="left" valign="top">&nbsp;</td>
    </tr>
    <tr>
      <td width="30%" align="left" valign="middle">Kode Buku</td>
      <td width="2%" align="left" valign="middle">:</td>
      <td width="68%" align="left" valign="middle"><input name="kdbukutxt" type="text" id="kdbukutxt" size="5" maxlength="5" value="<?php echo "B-"; echo $record['id']+1 ?>" readonly="readonly" /></td>
    </tr>
    <tr>
      <td align="left" valign="middle">Judul Buku</td>
      <td align="left" valign="middle">:</td>
      <td align="left" valign="middle"><input name="judultxt" type="text" id="judultxt" size="50" maxlength="50" /></td>
    </tr>
    <tr>
      <td align="left" valign="middle">Pengarang</td>
      <td align="left" valign="middle">:</td>
      <td align="left" valign="middle"><input name="pengarangtxt" type="text" id="pengarangtxt" size="35" maxlength="35" /></td>
    </tr>
    <tr>
      <td align="left" valign="middle">Harga</td>
      <td align="left" valign="middle">:</td>
      <td align="left" valign="middle"><input name="hrgtxt" type="text" id="hrgtxt" size="15" maxlength="10" /></td>
    </tr>
    <tr>
      <td align="left" valign="middle">Deskripsi</td>
      <td align="left" valign="middle">:</td>
      <td align="left" valign="middle"><textarea name="deskripsitxt" rows="4" id="deskripsitxt"></textarea></td>
    </tr>
    <tr>
      <td align="left" valign="middle">Kategori</td>
      <td align="left" valign="middle">:</td>
      <td align="left" valign="middle"><select name="kategorilist" id="kategorilist">
        <option value="K-0" selected="selected">K-0 - Akan Terbit</option>
        <?php
  $sql1="select * from kategoritbl order by id asc";
  $proses1=mysql_query($sql1);
  while ($record1 = mysql_fetch_array($proses1))
 {
  ?>
        <option value="<?php echo "$record1[kode_kategori]"; ?>"><?php echo "$record1[kode_kategori] - $record1[nama_kategori]"; }?></option>
      </select></td>
    </tr>
    <tr>
      <td align="left" valign="middle">Cover</td>
      <td align="left" valign="middle">:</td>
      <td align="left" valign="middle"><input name="cover" type="file" id="cover" size="15" maxlength="15" /></td>
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