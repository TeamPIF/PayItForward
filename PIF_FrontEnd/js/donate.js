domain = "http://127.0.0.1:4567";

$.when(
    $.get(domain + "/homepage/donated"),
    $.get(domain + "/homepage/served"),
    $.get(domain + "/homepage/available_all"),
    $.get(domain + "/homepage/num_partners")
).done(function(donated, served, avail, partners){
    $("#mealsDonated").html(Number(JSON.parse(donated[0]).sum));
    $("#mealsServed").html(Number(JSON.parse(served[0]).sum));
    $("#localPartners").html(Number(JSON.parse(avail[0]).sum));
    $("#sinceLaunch").html(Number(JSON.parse(partners[0]).sum));
});

$.ajax({
    type: "POST",
    url: "http://127.0.0.1:4567/stories/submit",
    data: {"name": "Horris Grant",
            "message" : "You guys saved me, I used to make millions in the NBA now I'm broke"
          }
}).done(function(data) {console.log(data);});
