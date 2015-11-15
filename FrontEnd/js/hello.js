var rootURL = "http://localhost:4567/hello";


$.get( rootURL, function( data ) {
    $( ".result" ).html( data );
    alert( "Load was performed." );
});