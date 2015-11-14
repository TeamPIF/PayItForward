

//var Request = unirest.get('http://localhost:4567/hello');
//document.getElementById("hello").innerHTML = Request.toString();


//var carName = "Volvo";
//document.getElementById("demo").innerHTML = carName;


var unirest = require('unirest');

unirest.get('http://localhost:4567/hello')
    .send()
    .end(function (response) {
        document.getElementById("demo").innerHTML = response.body;
    });

