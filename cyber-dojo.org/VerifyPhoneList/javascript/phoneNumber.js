'use strict';

//@author = wstueve
//test out at: http://www.cyber-dojo.org/kata/edit/7070BE?avatar=toucan
module.exports = 
{
  verifyList: function(inputList) {
    if (inputList) {
      this.parseList(inputList);
    }

    var myThis = this;
    var retVal = myThis.listItems.some(function (item, i) {
      var chars = item.phoneNumber.split('');
      var searchString = '';
      return chars.some(function (chr) {
        searchString += chr;
        for (var j = i + 1; j < myThis.listItems.length; j++) {
          var phoneNumber = myThis.listItems[j].phoneNumber;
          if (phoneNumber.startsWith(searchString) && 
            (searchString.length === phoneNumber.length || 
              searchString.length === chr.length)) {
              return true;
          }
        }
      });
    }); 

    return !retVal;
  },
  parseList: function (inputList) {
    this.listItems = [];
    var myThis = this;
    if (!inputList) { 
      return true;
    }

    inputList.forEach(function (item) {
      var li = myThis.listItem();
      li.parseItem(item);
      myThis.listItems.push(li);
    });
    return true;
  },
  listItems: [],
  listItem: function() {
    return {
      parseItem: function(item) {
        var temp = item.split(' ');
        this.name = temp[0];
        temp.shift();
        this.phoneNumber = temp.join('');
      },
      name: "",
      phoneNumber: ""
    };
  }
};