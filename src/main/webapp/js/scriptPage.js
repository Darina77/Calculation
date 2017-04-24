/*
 Буде працювати з рештою
*/
$(document).ready(function(){

    //Коли завантажується page.html одразу вставляю productClassification.html,
    //it's ajax: https://www.w3schools.com/jquery/jquery_ajax_load.asp
    //changed!
    $("#content").load('../html/productClassification.html', function(){   
    
    fillDishGrid();
    function fillDishGrid(){
        var DISH_TEMPLATE = $(".dish")[0].outerHTML;
        for (var i=1; i<16; i++){
            var node = $(DISH_TEMPLATE);
            node.find('img').attr('src', '/img/'+i+'.jpeg');
            node.attr('id', i);
            $('#innerGrid-dish').append(node); 
            
        }
        
    }
    
//Масиа назв клітинок з продуктами. достається по id елемента
    var dishClass = ["Холодні страви", "Страви з сільсько-господарської птиці, пернатої дичі та кролика", "Соуси","Супи", "Страви з риби морепродуктів і раків", "Страви з м'яса та м'ясних виробів", "Страви з картоплі овочів та грибів", "Солодкі страви", "Страви з творогу", "Страви з макаронних виробів", "Гарніри", "Страви з бобових", "Страви з круп", "Борошняні вироби", "Страви з яєць", "Напої"];
    
//Тут відбудеться event при натисканні на якусь клітику зі стравою
    $(".dish").click(function(){
       
       $("#content").load('../html/reciepe.html', function(){ 
            $("#addDish").click(function(){
            //тут очищюється content, видаляються клітинки зі стравами...
            $("#content").empty();
            // Тут завантажиться форма для створення своєї страви, а саме  //productForm.html
            // завантажиться в id="#content"
            $("#content").load('../html/productForm.html', function(){

            });
        });
       });
        
    });
    
    $(".dish").mouseenter(function() {
       $(this).find(".darkDish").show();
       var id = $(this).attr('id');
       var text = dishClass [id];
       var node =  $(this).find(".darkDish");
       node.find("div").text(text);
        
        if (text.length < 20)
        {
          node.find("div").css("margin-top", node.height()*0.3);
        }
        else if (text.length < 36)
        {
         node.find("div").css("margin-top", node.height()*0.2);  
        }
    }); 
    
    $(".dish").mouseleave(function() {
        $(this).find(".darkDish").hide();
    });
        
        
//натискаємо "Додати свою страву", id=#content
//it's ajax: https://www.w3schools.com/jquery/jquery_ajax_load.asp
    
   });

});
