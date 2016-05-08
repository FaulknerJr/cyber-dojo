'use strict';

//author = @wstueve
//http://www.cyber-dojo.org/kata/edit/7070BE?avatar=toucan
let phoneNumbers = require('./phoneNumber.js');
let assert = require('assert');

//assert.throws(() => { phoneNumbers.parseList() });
assert.ok(phoneNumbers.parseList());
assert.equal(phoneNumbers.listItems.length, 0);

assert.ok(phoneNumbers.parseList([]), true);
assert.equal(phoneNumbers.listItems.length, 0);

assert.ok(phoneNumbers.parseList(['Bob 123 123']));
assert.equal(phoneNumbers.listItems.length, 1);
assert.equal(phoneNumbers.listItems[0].name, 'Bob');
assert.equal(phoneNumbers.listItems[0].phoneNumber, '123123');

assert.ok(phoneNumbers.verifyList());
assert.equal(phoneNumbers.listItems.length, 1);
assert.equal(phoneNumbers.listItems[0].name, 'Bob');
assert.equal(phoneNumbers.listItems[0].phoneNumber, '123123');

assert.ok(phoneNumbers.verifyList(['Bob 123 123', 'Wes 234 234 3245']));
assert.equal(phoneNumbers.listItems.length, 2);
assert.equal(phoneNumbers.listItems[0].name, 'Bob');
assert.equal(phoneNumbers.listItems[0].phoneNumber, '123123');
assert.equal(phoneNumbers.listItems[1].name, 'Wes');
assert.equal(phoneNumbers.listItems[1].phoneNumber, '2342343245');

//WDS - The original input file
assert.ok(!phoneNumbers.verifyList([
  'Bob 91 12 54 26',
  'Alice 97 625 992',
  'Emergency 911']
));
assert.equal(phoneNumbers.listItems.length, 3);

console.log('All tests passed');