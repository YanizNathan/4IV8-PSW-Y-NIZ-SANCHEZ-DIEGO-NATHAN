function validarn(e){
    var teclado = (document.all)?e.keyCode:e.which;
    if(teclado == 8)return true;

    var patron = /[0-9\d .]/;

    var prueba = String.fromCharCode(teclado);
    return patron.test(prueba);
}

function calculo(){
    var valor = document.formulario.compra.value;
    var valor_a = parseInt(valor);
    var final = valor_a * 0.15;

    document.formulario.final.value = (valor_a - final) + " $";
    document.formulario.final_descuento.value = final + " $";
}

function borrar(){
    document.formulario.compra.value = "";
    document.formulario.final.value = "";
    document.formulario.final_descuento.value = "";
}