<?php
mysql_connect("localhost","root","12020210749343");

mysql_select_db("users");

$usr=$_POST["username"];
mysql_select_db("questions");


		$q=mysql_query("SELECT * FROM user_questions WHERE username = '$usr'");
		while($e=mysql_fetch_assoc($q))
			$output[]=$e;
		
print(json_encode($output));
mysql_close();
?>