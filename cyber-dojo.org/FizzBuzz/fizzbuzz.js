'use strict';

//author: @wstueve
//http://www.cyber-dojo.org/kata/edit/305D22CF67?avatar=butterfly
module.exports = {

  fizzBuzz: function() {
    for (var i = 1; i <= 100; i++) {
      var printed = false;
      if (i % 5 === 0) {
        console.log('Buzz');
        printed = true;
      }
      if (i % 3 === 0) {
        console.log('Fizz');
        printed = true;
      }
      if (!printed) {
        console.log(i);
      }
    }
  }
};