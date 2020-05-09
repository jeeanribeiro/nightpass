window.onload = function() {

	var statusPresenca = document.getElementById("statusPresenca");

	AtualizaPresenca();

	function AtualizaPresenca(){

		var statusVou = document.getElementById("statusVou");
		var statusNaoVou = document.getElementById("statusNaoVou");
		var statusNaoInformado = document.getElementById("statusNaoInformado");

		window.alert(statusPresenca.innerHTML);

		switch (statusPresenca.innerHTML){

		case "MARCOU PRESENÇA":
			window.alert("sim");
			statusVou.selected = true;
			break;
		case "DESMARCOU PRESENÇA":
			window.alert("nao");
			statusNaoVou.selected = true;
			break;
		default:
			window.alert("nao informado");
			statusNaoInformado.selected = true;
			break;
		}

	}

}
