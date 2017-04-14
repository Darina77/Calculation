/*
Маленький скрипт працбє з кнопкою "Розпочати"
її id=#begin;
*/
//it's ajax: https://www.w3schools.com/jquery/jquery_ajax_load.asp
$(document).ready(function(){
    
    $('#begin').click(function(e){
         e.preventDefault();
        // var url ="html/page.html";
        // $(location).attr('href', url);
        $('body').load("/html/page.html");
       
        });
 
});

