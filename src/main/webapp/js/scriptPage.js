$(document).ready(function(){

    fillDishGrid();
    function fillDishGrid(){

        var DISH_TEMPLATE = $(".dish")[0].outerHTML;
        for (var i=1; i<12; i++){
            var node = $(DISH_TEMPLATE);
            node.find('img').attr('src', '/img/'+i+'.jpeg');
            node.attr('id', i);
            $('#innerGrid-dish').append(node);  
        }
        
    }
    
    var dishClass = ["Холодні закуски", "!", "!", "Соуси", "!", "Горячі страи",
                     "!", "!", "!", "!", "Десерти", "Напої"];
    
    $(".dish").click(function(){
        $(this).effect("shake", 600);
    });
    
    $(".dish").mouseenter(function() {
       $(this).find(".darkDish").show();
       var id = $(this).attr('id');
       $(this).find(".darkDish").text(dishClass [id]);
        
    }); 
    
    $(".dish").mouseleave(function() {
        $(this).find(".darkDish").hide();
    });
});
