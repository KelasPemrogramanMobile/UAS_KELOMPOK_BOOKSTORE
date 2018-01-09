<?php error_reporting(E_ERROR | E_WARNING | E_PARSE); ?>
<?php
	include "koneksi.php";
	
	switch($_GET['go']){		
		case 'Buku':
			include("buku.php");
		break;
		
		case 'Buku_Tambah':
			include("buku_tambah.php");
		break;		
		
		case 'Buku_Simpan':
			include("buku_simpan.php");
		break;				
		
		case 'Buku_Hapus':
			include("buku_hapus.php");
		break;																			
				
		case 'Kategori':
			include("kategori.php");
		break;	
		
		case 'Kategori_Tambah':
			include("kategori_tambah.php");
		break;
		
		case 'Kategori_Simpan':
			include("kategori_simpan.php");
		break;		
		
		case 'Kategori_Hapus':
			include("kategori_hapus.php");
		break;		
		
		case 'Penjualan':
			include("penjualan.php");
		break;	
		
		case 'Penjualan_Rincian':
			include("penjualan_rincian.php");
		break;		
		
		case 'Penjualan_Hapus':
			include("penjualan_hapus.php");
		break;	
		
		case 'Laporan_Penjualan_Form':
			include("laporan_penjualan_form.php");
		break;			
		
		case 'Laporan_Penjualan':
			include("laporan_penjualan.php");
		break;			
				
	};
?>	