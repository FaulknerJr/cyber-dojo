<?php
	echo "<h1>ISBN-13 Validator</h1>";

	//count digits
	$str = "0 1 -234 56 7438 - 9 ";
	$cntDigits = preg_match_all( "/[0-9]/", $str );

	//ISBN-13 Validation
	$rmChr = "978-0-8493-9640-3"; // valid isbn-13 number
	
    $dgts = preg_replace("/[^0-9]/","", $rmChr);
	echo "ISBN-10 Number:<br>".$dgts."<br><br>";
	
	$strArr = str_split($dgts);
	
	$arr0  = $strArr[0]  * 1;
	$arr1  = $strArr[1]  * 3;
	$arr2  = $strArr[2]  * 1;
	$arr3  = $strArr[3]  * 3;
	$arr4  = $strArr[4]  * 1;
	$arr5  = $strArr[5]  * 3;
	$arr6  = $strArr[6]  * 1;
	$arr7  = $strArr[7]  * 3;
	$arr8  = $strArr[8]  * 1;
	$arr9  = $strArr[9]  * 3;
	$arr10 = $strArr[10] * 1;
	$arr11 = $strArr[11] * 3;
	
	$arrSum = $arr0 + $arr1 + $arr2 + $arr3
		 + $arr4 + $arr5 + $arr6 + $arr7 + 
		$arr8 + $arr9 + $arr10 + $arr11; // + $arr9;
	
	$iMod = $arrSum % 10;
	$chkDigit = 10- $iMod;

	if($strArr[12] == $chkDigit){
		echo "CONFIRMED: <br>" . $dgts. 
			"<br>Is a valid ISBN-13 Number<br>";
	} 
	else{
		echo "ERROR: <br> ". $dgts . "<br> 
			Your ISBN-13 Number is Not Valid<br>";
	}

		
?>
