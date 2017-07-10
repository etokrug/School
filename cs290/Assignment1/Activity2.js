/**
 * Created by etokrug on 7/9/17.
 */
// Initial Program
// Function call before declaration
console.log(sweetSyntax(3));

// Declaration
function sweetSyntax(myNum) {
    return myNum / 3.14159265358979;
}

// Works!!

//// Secondary
// Call to undeclared var which breaks
console.log(myFuncVar("Will"));

var myFuncVar = function (eem) {
    return "Hello, " + eem + "! Dope name!";
};

// Call which, when top call is commented, will function properly.
console.log(myFuncVar("Will"));

function buildList(list) {
    var result = [];
    for (var i = 0; i < list.length; i++) {
        var item = 'item' + list[i];
        var pushVal = item + ' ' + list[i];
        result.push( function(x) {
            return function () {
                console.log(x);
            };
        }(pushVal));
    }
    return result;
}

function testList() {
    var fnlist = buildList([1,2,3]);
// using j only to help prevent confusion - could use i
    for (var j = 0; j < fnlist.length; j++) {
        fnlist[j]();
    }
}