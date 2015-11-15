domain = "http://127.0.0.1:4567";

$.when(
    $.get(domain + "/homepage/donated"),
    $.get(domain + "/homepage/served"),
    $.get(domain + "/homepage/available_all"),
    $.get(domain + "/homepage/num_partners")
).done(function(donated, served, avail, partners){
    $("#mealsDonated").html(Number(donated));
    $("#mealsServed").html(Number(served));
    $("#localPartners").html(Number(avail));
    $("#sinceLaunch").html(Number(partners));
});
