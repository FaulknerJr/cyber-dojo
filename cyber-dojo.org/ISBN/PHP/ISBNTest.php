<?php

require_once 'ISBN.php';

class HikerTest extends PHPUnit_Framework_TestCase
{
    public function test01()
    {
        $this->assertEquals(10, tst01());
    }

    public function test02()
    {
        $this->assertEquals(13, tst02());
    }
}


?>
