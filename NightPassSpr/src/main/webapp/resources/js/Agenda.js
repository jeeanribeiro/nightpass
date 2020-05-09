window.onload = function() {

	
	//obtem uma coleção com as TagName o colchetes define qual o item desejado
	var Doc = document.getElementsByTagName("html")[0];
		
	var form = document.getElementsByName("formbt");
	
	var btnstatus = document.getElementsByName("btnstatus");
	
	for (i = 0; i < form.length; i++) {
		
		//o form contem toda a coleção o item(x), traz o item x da coleção
		form.item(i).onsubmit = function(){
			
			Doc.className="whaitcursor";
			
		}
		
	}
	
	

	
}
	
	
	