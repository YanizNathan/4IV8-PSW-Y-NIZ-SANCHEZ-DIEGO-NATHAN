function problema3(){

    let Pepe = document.querySelector('#p3-input').value;
    let palabras = Pepe.split(",");
    let palabralarga="";
 
    for(let word of palabras){
        if(word.length> palabralarga.length){
        palabralarga=word;
 
        var pepe = palabralarga.split("");
        var Num = pepe.length;
        }
    }
    
    document.querySelector('#p3-output').textContent = 'Las palabras son : '+
    palabralarga + '   Sus letras son   ' + pepe + ' Repetidas  ' + Num;
}