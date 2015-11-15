$(document).ready(function() {
    $(".receiveAccept").click(function() {
        console.log("HIIIIIII");
        $.post("/tablet/claim",
        JSON.stringify({ "name" : "Model's", "donor_id" : NULL }))
        .done(function() {
            
        });
    });
});
