<?php
	echo "<h1>ISBN-10 Validator</h1>";

	//count digits
	$str = "0 1 -234 56 78 - 9 ";
	$cntDigits = preg_match_all( "/[0-9]/", $str );

	//ISBN-10 Validation
	$rmChr = "0671027034"; // valid isbn-10 number
	
    $dgts = preg_replace("/[^0-9]/","", $rmChr);
	echo "ISBN-10 Number:<br>".$dgts."<br><br>";
	
	$strArr = str_split($dgts);
	
	$arr0 = $strArr[0] * 10;
	$arr1 = $strArr[1] * 9;
	$arr2 = $strArr[2] * 8;
	$arr3 = $strArr[3] * 7;
	$arr4 = $strArr[4] * 6;
	$arr5 = $strArr[5] * 5;
	$arr6 = $strArr[6] * 4;
	$arr7 = $strArr[7] * 3;
	$arr8 = $strArr[8] * 2;
	
	$arrSum = $arr0 + $arr1 + $arr2 + $arr3
		 + $arr4 + $arr5 + $arr6 + $arr7 + 
		$arr8; // + $arr9;
	
	$iMod = $arrSum % 11;
	$chkDigit = 11 - $iMod;

	if($strArr[9] == $chkDigit){
		echo "CONFIRMED: <br>" . $dgts. 
			"<br>Is a valid ISBN-10 Number<br>";
	} 
	else{
		echo "ERROR: <br> ". $dgts . "<br> 
			Your ISBN-10 Number is Not Valid<br>";
	}

		
?>
