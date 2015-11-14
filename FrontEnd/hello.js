
var unirest = require('unirest');

var Request = unirest.get('http://localhost:4567/hello');
document.getElementById("hello").innerHTML = Request.toString();
console.log(Request.toString());

var carName = "Volvo";
document.getElementById("demo").innerHTML = carName;