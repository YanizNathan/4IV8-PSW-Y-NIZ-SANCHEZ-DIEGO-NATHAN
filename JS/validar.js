function validar(formulario){
    /*Queremos validar que se escriban
    mas de 5 caracteres en el cmapo de 
    nombre*/

    if(formulario.nombre.value.length < 5){
        alert("porfavor escribe mas de 5 caracteres en el cmpo nombre")
        formulario.nombre.focus();
    return false;

    }
    /*
    Validar que solo acepte letras estas chingaderas owo
    */

    var checkOk = "QWERTYUIOPASDFGHJKLÑZXCVBNM "
    + "qwertyuiopasdfghjklñzxcvbnm ";
    
    var checkStr = formulario.nombre.value;

    var allValid = true;

    for(var i = 0; i< checkStr.length; i++){
        var ch = checkStr.charAt(i);
        for(var j = 0; j< checkOk.length; j++)
        if(ch == checkOk.charAt(j))
        break;
        
        if(j == checkOk.length){
            allValid = false;
            break;
        }

    }

    if(!allValid){
        alert("Escribe solo letras sin numeros en el nombre")
        formulario.nombre.focus();
        return false;
    }

    

    /*
    vamos a valudar solo numeros poke soy flojo
    */

    var checkOk = "1234567890 ";
    
    
    var checkStr = formulario.edad.value;

    var allValid = true;

    for(var i = 0; i< checkStr.length; i++){
        var ch = checkStr.charAt(i);
        for(var j = 0; j< checkOk.length; j++)
        if(ch == checkOk.charAt(j))
        break;
        
        if(j == checkOk.length){
            allValid = false;
            break;
        }

    }

    if(!allValid){
        alert("Escribe solo numeros sin letras en la edad")
        formulario.edad.focus();
        return false;
    }
    /*
    Validar correo electronico
    expresiones regulares
    a poder diferenciar una cadena de caracteres y 
    definir que caracteres son validos de
    acuerdo a una condicion
    
    */

    var txt = formulario.email.value;

    //expresion regular

    var b = /^[^@\s]+@[^@\.\s]+(\.[^@\.\s]+)+$/;

    alert("Email " + (b.test(txt)?"":"no ")+ "valido");



}