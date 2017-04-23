$(document).ready(function(){
<<<<<<< HEAD
=======
$(".Ing").click(function(event){
      // ось тут я не розумію, як саме мені дістати імя я уже крутила вертила ніяк не получається
      // все додається, правильно робить, але мені лише треба якось витягнути назву
       var IngrName = this.val();
     var all="<tr> <td class=\"NameIngr\"> <input type=\"text\" value="+IngrName+" class=\"TextNameIngr\"></td><td class=\"MassIngr\"><input type=\"text\" value=\"100гр\" class=\"TextMassIngr\">  </td> <td class=\"PrizeIngr\">  <input type=\"text\" value=\"200грн\"  class=\"TextPrizeIngr\"> </td></tr>";
      $('#Choosen').append(all); 
    });
>>>>>>> 9e30f43c951331267e56232cec64affbd3ab9671
//Тут відбуваються дії при натисканні кнопки додати свою страву на сторінці productForm
$(".Ad").click(function(){
      
    });
$(".Back").click(function(){
    
});
<<<<<<< HEAD
  $(".AdIngridians").click(function(){
    var IngrName=document.getElementById("NameOfIngrst").value;
       var all="<tr> <td class=\"NameIngr\"> <input type=\"text\" value=\""+IngrName+"\" class=\"TextNameIngr\" ></td><td class=\"MassIngr\"><input type=\"text\" value=\"\" class=\"TextMassIngr\"required>  </td> <td class=\"PrizeIngr\">  <input type=\"text\" value=\"\"  class=\"TextPrizeIngr\" required> </td></tr>";
      $('#Choosen').append(all);   
      alert("Введіть будь ласка масу та ціну в форму!")
});  
});
=======
});
>>>>>>> 9e30f43c951331267e56232cec64affbd3ab9671
