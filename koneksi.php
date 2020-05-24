<?php 
$server="localhost";
$username="id10770483_root";
$password="oMzPjp99]!>cP~=F";
$dbname="id10770483_dbardi";

//Koneksi
$koneksi=new mysqli($server,$username,$password,$dbname);

//Cek Koneksi
if ($koneksi=connect_error()){
	die("Koneksi Gagal ".$koneksi->connect_error());
}

$sql="SELECT * FROM tbmenu";
$result=$koneksi->query($sql);
$data=array();

if ($result->num_rows>0){
	while ($row=$result->fetch_assoc()) {
		$data[]=$row;
	}
}else {
	echo "Data Kosong";
}
?>
