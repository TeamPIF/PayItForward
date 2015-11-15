$(document).ready(function() {
    $(".giveAccept").click(function() {
        console.log("HIIIII");
        $.post("/tablet/donation",
        JSON.stringify({ "name" : "Model's", "donor_id" : NULL }))
        .done(function() {
            
        });
    });
});
