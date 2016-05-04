<?php

// There are two ISBN standards: 
// ISBN-10 and ISBN-13.

// ISBN-10
// ISBN-10 is made up of 9 digits plus a 
// check digit (which may be 'X') 
function tst01()
{
    $iTen = "0123456789x";
    return preg_match_all( "/[0-9]/", $iTen );
}

// ISBN-13
// ISBN-13 is made up of 12 digits plus a
// check digit. 
function tst02()
{
    $iThr = "0123456789123x";
    return preg_match_all( "/[0-9]/", $iThr);
}

?>
