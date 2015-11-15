domain = "http://127.0.0.1:4567";
var donate; var serve; var available;

$.when(
    $.get(domain + "/homepage/donated"),
    $.get(domain + "/homepage/served"),
    $.get(domain + "/homepage/available_all")
    // $.get(domain + "/homepage/num_partners")
).done(function(donated, served, avail, partners){
    donate = Number(JSON.parse(donated[0]).sum);
    serve = Number(JSON.parse(served[0]).sum);
    available = Number(JSON.parse(avail[0]).sum);
    // $("#mealsDonated").html(Number(JSON.parse(donated[0]).sum));
    // $("#mealsServed").html(Number(JSON.parse(served[0]).sum));
    // $("#available").html(Number(JSON.parse(avail[0]).sum));
    // $("#localPartners").html(Number(JSON.parse(partners[0]).sum));
});
