

function request (url, metodo, data,callback) {
    console.log(data);
    if (!data) { data = ''; }
	$.ajax({
        data: data,
        method:metodo,
        contentType: 'application/json',
        dataType:"json",
        url:url,
        success:callback,
        error:function(error){
        }
    });
}

function id_url(){
		var paramstr = window.location.search.substr(1);
		var paramarr = paramstr.split ("&");
		var params = {};

		for ( var i = 0; i < paramarr.length; i++) {
	    	var tmparr = paramarr[i].split("=");
	    	params[tmparr[0]] = tmparr[1];
		}
		
		if (params['id']) {
	   		console.log('El valor del parámetro variable es: '+params['id']);
		} else {
	   		console.log('No se envió el parámetro id');
		}
		return params['id'];	
}

function fechaActual(){
		var today = new Date();
		var dd = String(today.getDate()).padStart(2, '0');
		var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
		var yyyy = today.getFullYear();
		today = yyyy + '-' + mm + '-' + dd;
		console.log(today);

	return today;
}

function calcularEdad(fecha) {
    var hoy = new Date();
    var cumpleanos = new Date(fecha);
    var edad = hoy.getFullYear() - cumpleanos.getFullYear();
    var m = hoy.getMonth() - cumpleanos.getMonth();

    if (m < 0 || (m === 0 && hoy.getDate() < cumpleanos.getDate())) {
        edad--;
    }

    return edad;
}	