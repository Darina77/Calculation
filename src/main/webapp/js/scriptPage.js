/*
 Буде працювати з рештою
*/
$(document).ready(function(){

    var dishClass = ["Холодні закуски", "Страви з сільсько-господарської птиці, пернатої дичі та кролика", "Соуси","Супи", "Страви з риби морепродуктів і раків", "Страви з м'яса та м'ясних виробів", "Страви з картоплі овочів та грибів", "Солодкі страви", "Страви з творогу", "Страви з макаронних виробів", "Гарніри", "Страви з бобових", "Страви з круп", "Борошняні вироби", "Страви з яєць", "Напої"];

    
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


});
