$(document).ready(function(){
//Тут відбуваються дії при натисканні кнопки додати свою страву на сторінці productForm
$(".Ad").click(function(){
      
    });
$(".Back").click(function(){
    
});
  $(".AdIngridians").click(function(){
    var IngrName=document.getElementById("NameOfIngrst").value;

       var all="<tr> <td class=\"NameIngr\"> <input type=\"text\" value=\""+IngrName+"\" class=\"TextNameIngr\" required pattern=\"^[а-яА-Я\s]+$\"></td><td class=\"MassIngr\"><input type=\"text\" value=\"\" class=\"TextMassIngr\" pattern=\"^[0-9\s]+$\" required>  </td><td class=\"MassIngr\"><input type=\"text\" value=\"\" class=\"TextMassBruttoIngr\" pattern=\"^[0-9\s]+$\" required>  </td><td class=\"PrizeIngr\">  <input type=\"text\" value=\"\"  class=\"TextPrizeIngr\" pattern=\"^[0-9\s]+$\" required> </td></tr>";

      $('#Choosen').append(all);   
      alert("Введіть будь ласка масу та ціну в форму!")
});  
   
});
