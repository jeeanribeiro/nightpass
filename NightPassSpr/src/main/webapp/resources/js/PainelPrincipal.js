window.onload = function(){


    this.setInterval(myFunction,3000);


    function myFunction(){

        var icount;

        for (icount=1; icount<=10; icount++){

            var foto1 = document.getElementById(icount + "_foto1");
            var foto2 = document.getElementById(icount + "_foto2");
            var foto3 = document.getElementById(icount + "_foto3");

            //console.log(icount + "_foto1");

            if(foto1 == null){
            	
            	break;
            }
            
            var fotom = foto1.getAttribute("src");

            //console.log(fotom);
    
            	foto1.setAttribute("src", foto2.getAttribute("src"));
            	foto2.setAttribute("src", foto3.getAttribute("src"));
            	foto3.setAttribute("src", fotom);
            	
        }





        
        
        //console.log(fotom);

    }










}