console.log("Comecou");

// Exercício 1
//
// Daisy Game!
//
// Faça uma função chamada daisyGame que receba por argumento o número de pétalas da margarida e retorne 'Love me' ou 'Love me not' (Lembre do jogo "Bem me quer, mal me quer").
//Exemplo:
//
// daisyGame(4); // retorna 'Love me not'
function daisyGame(indice){
  if((indice%2) === 1)
    return "Love me";
  return "Love me not";
}

console.log("daisyGame(0):", daisyGame(0));
console.log("daisyGame(1):", daisyGame(1));
console.log("daisyGame(2):", daisyGame(2));
console.log("daisyGame(3):", daisyGame(3));
console.log("daisyGame(4):", daisyGame(4));

// Exercício 2
//
// Maior texto
//
// Faça uma função chamada maiorTexto que receba um array de strings e retorne o texto com maior número de caracteres.
//

function maiorTexto(arrayDeStrings){
  var maior = "";
  for (var i = 0; i < arrayDeStrings.length ; i++)
    if(maior.length < arrayDeStrings[i].length)
        maior = arrayDeStrings[i];
  return maior;
}
console.log("maiorTexto: ", maiorTexto(["12345 67","1234 5678"]));
console.log("maiorTexto: ", maiorTexto(["22345 678","1234 5678"]));
console.log("maiorTexto: ", maiorTexto(["12345 678","123 45678","123 4567 89"]));

// Exercício 3
//
// Instrutor querido
//
// Faça uma função chamada imprime que receba dois parâmetros:
//
// Um array de strings; e
// Uma função.
// Dentro da função imprime chame a função do segundo parâmetro para cada elemento do array. Exemplo:
//
// imprime(
//   // primeiro parâmetro: array
//   [ 'bernardo', 'nunes', 'fabrício', 'ben-hur', 'carlos' ],
//   // segundo parâmetro: função
//   function(instrutor) {
//    console.log('olá querido instrutor:', instrutor)
//   }
// );
// Deve resultar em:
//
// "olá querido instrutor: bernardo"
// "olá querido instrutor: nunes"
// "olá querido instrutor: fabrício"
// "olá querido instrutor: ben-hur"
// "olá querido instrutor: carlos"
//
// Atenção! Faça um tratamento para evitar que a função imprime seja chamada com um segundo parâmetro que não seja uma função, por exemplo:
//
// imprime([ 'bernardo', 'nunes', 'fabrício', 'ben-hur', 'carlos' ], 3.14);
// // Jabulani:
// // 'TypeError: number is not a function'
function imprime (arrayDeNomes, umaFuncao){
    if(typeof umaFuncao !== 'function' )
          return console.log("TypeError:"+ umaFuncao + " is not a function");
    for(var i = 0; i < arrayDeNomes.length; i++ ){
    umaFuncao(arrayDeNomes[i]);
    }
}
imprime(
  // primeiro parâmetro: array
  [ 'bernardo', 'nunes', 'fabrício', 'ben-hur', 'carlos' ],
  // segundo parâmetro: função
  function(instrutor) {
   console.log('olá querido instrutor:', instrutor)
 }
);

// Exercício 4
//
// Soma diferentona
//
// Escreva uma função somar que permite somar dois números através de duas chamadas diferentes (não necessariamente pra mesma função). Pirou? Ex:
//
// adicionar(3)(4); // 7
// adicionar(5642)(8749); // 14391

function somaDiferentona(a){
     function somaDentro(b){
       return a+b;
     }
     return somaDentro;
}
console.log("Soma Diferentona(3)(4)",somaDiferentona(3)(4));
console.log("Soma Diferentona(5642)(8749)",somaDiferentona(5642)(8749));

// Exercício 5
//
// Fibona
//
// Faça uma função fiboSum que calcule a soma da sequência de Fibonacci para n números informados. Exemplo de chamada:
//
// fiboSum(7);
// // 33 (soma dos 7 primeiros números da sequência: 1+1+2+3+5+8+13)
// Dica: aproveite toda "beleza" dos algoritmos recursivos! #sqn
//


function fiboSum(qtdNumeros){
    if(qtdNumeros === 1) return console.log(1);
    var fibo = [1,1];
    var soma = 2;
    for(var i = 2; i<qtdNumeros; i++){
        fibo[i] = fibo[i-2] + fibo[i-1];
        soma += fibo[i];
    }
    return soma;
}
console.log("fibo(3)", fiboSum(3));
console.log("fibo(4)", fiboSum(4));
console.log("fibo(5)", fiboSum(5));
console.log("fibo(6)", fiboSum(6));
console.log("fibo(7)", fiboSum(7));
// Exercício 6
//
// Quero café
//
// Escreva uma função queroCafe que recebe dois parâmetros:
//
// mascada: Valor numérico
// precos: Lista de preços de café
// A sua implementação deve retornar uma string com todos os preços que estão abaixo ou igual ao valor mascada ordenados de forma ascendente e separados por ,. Ex:
//
// queroCafe(3.14, [ 5.16, 2.12, 1.15, 3.11, 17.5 ]);
// // '1.15,2.12,3.11'


function queroCafe(mascada, precos){
  var lista = [ 0.0 ];
  // lista[0] = precos[0];
  //console.log(lista.length);
    for(var i = 0; i<precos.length;i++)
        if(precos[i] <= mascada)
          lista[lista.length] = precos[i];
   function ordenaAscendente(listaComValores){
     var posicoesSendoTrocadas = false;
     do{
       posicoesSendoTrocadas = false;
        for(var i = 0; i<listaComValores.length-1;i++)
          if(listaComValores[i]>listaComValores[i+1]){
            var aux = listaComValores[i];
            listaComValores[i] = listaComValores[i+1];
            listaComValores[i+1] = aux ;
            posicoesSendoTrocadas = true;
          }
    }while(posicoesSendoTrocadas)
    return listaComValores
   }

   lista = ordenaAscendente(lista);
   var retorno = lista[1];
   for(var i = 2; i<lista.length;i++)
        retorno = retorno + "," + lista[i]
   return retorno;

}
console.log(queroCafe(3.14, [ 5.16, 2.12, 1.15, 3.11, 17.5 ]));
