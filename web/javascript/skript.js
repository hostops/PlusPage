function povecajtext(a){
   var b= document.getElementById("naslov"+a).value.length;
   
  
   if(b>75) {
       document.getElementById("naslov"+a).size="75";
   }else{
   document.getElementById("naslov"+a).size=b;
   }
   document.getElementById("innerdiv"+a).src = document.getElementById("naslov"+a).value;
}

function nastaviMin(i){
    var a = document.getElementById("draggable"+i).offsetHeight;
    var b = document.getElementById("draggable"+i).offsetWidth;
 
    
    $( "#premakni"+i ).resizable({

      minHeight: a,
      minWidth: b
    });
    
    
}

function dobiNotranjiOdmikX(i){
   
 
   var b= document.getElementById("premakni"+i).offsetLeft;
   var c = -b;
   return c;
}

function dobiNotranjiOdmikY(i){
       
   var b= document.getElementById("premakni"+i).offsetTop;
  var c = -b;
   return c;
    
}
