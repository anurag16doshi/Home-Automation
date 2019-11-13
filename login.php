<?php

$user ="root";
$pass="";
$db="user";

$db=new mysqli('localhost',$user,$pass,$db)or die("unable to connect");
echo "hii..";


/*$servername = "localhost";
$username = "username";
$password = "password";

// Create connection
$conn = new mysqli($servername, $username, $password);

// Check connection
*/

/*$db="user";
$user= $_POST["username"];
$pass=$_POST["password"];
$host="localhost";
$conn=mysqli_connect($host,$user,$pass,$db);

if($conn)
{ 
	echo "connected";
	
	$q= "select * from testtable where username like '$user' and
	password like '$pass'";
	$result= mysqli_query($conn,$q);
	if(mysqli_num_rows($result)>0)
	{
		echo"login successful";
	}
	else {
		echo "login failed";
	}
		
}else
{echo "Not Connected..";
}*?
/*$con = mysql_connect("localhost","root","student");
mysql_connect("localhost","root","12020210749343");
mysql_select_db("users");

$usr=$_POST["username"];
$pwdIn=$_POST["password"];
$q=mysql_query("SELECT password FROM userlist WHERE username = '$usr'");

while($e=mysql_fetch_assoc($q)){
	$output[]=$e;
	$pwd = $e['password'];
}
if($pwd == $pwdIn)
	print("true");
else
	print("false");

mysql_close();*/
?>
