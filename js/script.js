$(document).ready(function(){
    
    $('#begin').click(function(){
        
       $(this).toggle( "bounce", { times: 3 }, "slow");
        
       setTimeout(
          function(){
             var url ="page.html";
             $(location).attr('href', url);
          }, 1000 );
    });
 
});

