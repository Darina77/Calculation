$(document).ready(function(){
    //here will be aded recepie when searchpage will be opened
     var MassyfRecepie=["Огірок","Бешбармак","Трісіні","Диявольські яйця","Фаршмак"];
   fillDishGrid();
    function fillDishGrid(){
        for(var i=0;i<MassyfRecepie.length;i++){
       var all=" <div class=\"ha col col-xs-12 col-sm-6 col-lg-3\" id=\"0\"><input type=\"text\" value=\""+MassyfRecepie[i]+"\"  disabled class=\"NameOfRecepie\"  id=\"1\" onclick=\"choose()\"> </div>";

      $('.row').append(all);   }
        }
        
    
   
$("#addDish").click(function(){
        //тут очищюється content, видаляються клітинки зі стравами...
        $("#content").empty();
        // Тут завантажиться форма для створення своєї страви, а саме  //productForm.html
        // завантажиться в id="#content"
         $("#content").load('../html/productForm.html', function(){ 
             
         });
    }); 

//функція для пошуку при нажатті клавіші викликається ця функція у ній треба викликати функцію 
    //fillDishGrid() яку заповнюється масивом рецептів також тут треба перевизначити MassyfRecepie
function dof(){
    
    
}
//якщо на якийсь рецепт нажмуть
 function choose(){
    alert("f");
    
}
   
});