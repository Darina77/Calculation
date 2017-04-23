$(document).ready(function(){
    //here will be aded recepie when searchpage will be opened
 /*    fillDishGrid();
    function fillDishGrid(){
        var DISH_TEMPLATE = $(".dish")[0].outerHTML;
        for (var i=1; i<5; i++){
            var node = $(DISH_TEMPLATE);
            node.find('input').attr('type',"text");
            node.attr('id', i);
            //ось тут замість огірок має бути назва рецепту
            node.attr('value',"Огірок");
            node.attr('disabled');
            node.attr('class',"NameOfRecepie")
            $('#innerGrid-dish').append(node);  
        }
        
        
    }*/
$("#addDish").click(function(){
        //тут очищюється content, видаляються клітинки зі стравами...
        $("#content").empty();
        // Тут завантажиться форма для створення своєї страви, а саме  //productForm.html
        // завантажиться в id="#content"
         $("#content").load('../html/productForm.html', function(){ 
             
         });
    }); 




});