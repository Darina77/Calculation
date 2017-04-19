$(document).ready(function(){
$(".Ing").click(function(event){
       var IngrName = this.val();
     var all="<tr> <td class=\"NameIngr\"> <input type=\"text\" value="+IngrName+" class=\"TextNameIngr\"></td><td class=\"MassIngr\"><input type=\"text\" value=\"100гр\" class=\"TextMassIngr\">  </td> <td class=\"PrizeIngr\">  <input type=\"text\" value=\"200грн\"  class=\"TextPrizeIngr\"> </td></tr>";
      $('#Choosen').append(all); 
    });
//Тут відбуваються дії при натисканні кнопки додати свою страву на сторінці productForm
$(".Ad").click(function(){
      
    });
$(".Back").click(function(){
    
});
});