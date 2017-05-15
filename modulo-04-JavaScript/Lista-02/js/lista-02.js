console.log("Comecou!");
console.log(series);
// Exercício 1
// Séries Inválidas
// Nesse exercício deverá ser implementada uma função chamada seriesInvalidas(series) que recebe o array de séries, verifica quais são as séries inválidas e retorna o título das séries inválidas em formato String.
// Exemplo:
// seriesInvalidas(series); // retorna "Séries Inválidas: Série 1 - Série 2 ..."
// Condições para as séries serem inválidas:
// Ano de estreia maior que o ano atual;
// Possuir algum campo que seja undefined ou null.

function seriesInvalidas(series){
  var anoAtual = new Date().getFullYear();
  var retorno = "";
  for (var invalido of series){
              if( invalido.anoEstreia > anoAtual
        || typeof invalido.diretor        === 'undefined'  || invalido.diretor         === null
        || typeof invalido.distribuidora  === 'undefined'  || invalido.distribuidora   === null
        || typeof invalido.elenco         === 'undefined'  || invalido.elenco          === null
        || typeof invalido.genero         === 'undefined'  || invalido.genero          === null
        || typeof invalido.numeroEpisodios=== 'undefined'  || invalido.numeroEpisodios === null
        || typeof invalido.temporadas     === 'undefined'  || invalido.temporadas      === null
        || typeof invalido.titulo         === 'undefined'  || invalido.titulo          === null
        || typeof invalido.diretor        === 'undefined'  || invalido.diretor         === null){
          retorno = retorno + invalido.titulo + " - ";
   }
  }
  return retorno;
}

console.log(seriesInvalidas(series));

// Exercício 2
//
// Séries a partir de um determinado ano
//
// Nesse exercício deverá ser implementada uma função chamada filtrarSeriesPorAno(series, ano) que recebe o array de séries e devolve um outro array contendo apenas as séries com ano maior ou igual ao ano passado por parâmetro.
//
// Exemplo:
//
// filtrarSeriesPorAno(series, 2017); // retorna um array com todas as séries com ano de estreia igual ou maior que 2017.

function filtrarSeriesPorAno(series, ano) {
    var retorno = [];
    for(var i of series)
        if( i.anoEstreia >= ano)
          retorno.push(i);
    return retorno;
}

console.log(filtrarSeriesPorAno(series, 2015));

// Exercício 3
//
// Média de Episódios
//
// Crie uma função chamada mediaDeEpisodios(series) que recebe o array de séres e retorna a média dos episódios de todas as séries contidas no array.
//
// Exemplo:
//
// mediaDeEpisodios(series); // retorna o valor da média da soma dos episódios/quantidade de séries no array.

function mediaDeEpisodios(series){
  var media = 0, quantidade = 0;
  for(var i of series){
      media = media + i.numeroEpisodios;
      quantidade++;
  }
  return media/quantidade;
}
console.log("Media de Episodios dos seriados: ",mediaDeEpisodios(series));
// Exercício 4
//
// Eu sou um ator de séries?
//
// Crie uma função chamada procurarPorNome(series, nome) que recebe um array de séries e um nome e caso esse nome possua no elenco das séries, retorna true.
//
// Exemplo:
//
// procurarPorNome(series, "Mateus"); // retorna verdadeiro se tiver um "Mateus" em algum dos elencos
// Dica: No campo nome da função experimente passar seu próprio nome.
//
function procurarPorNome(series, nome) {
  for(var i of series){
    for(var j of i.elenco)
      if (j.includes(nome)) return true;
  }
  return false;
}

console.log("Series contain('Mateus')",procurarPorNome(series, "Mateus"))

// Exercício 5
//
// Mascada em Série
//
// Uma série tem seu elenco e diretor(es), mas para ela acontecer, eles devem ser pagos. Crie uma função chamada mascadaEmSerie que retornará o valor total do salário a ser pago por mês para determinada série. Para isso, suponha que os Big-Bosses, os Diretores, ganhem R$ 100.000; Enquanto os operarios os peões o pessoal do elenco ganha R$ 40.000;
//
// Exemplo:
//
// mascadaEmSerie(series[0]); //Retorna o valor total de gastos contando os diretores e o elenco

function mascadaEmSerie(serieRecebida){
  return serieRecebida.diretor.length*100000 + serieRecebida.elenco.length*40000;
}
console.log("Custo Total Serie[0]: ",mascadaEmSerie(series[0]))
// Exercício 6
//
// Buscas!
//
// A) Não sei o que quero assitir, mas quero ver CAOS! Escreva uma função chamada queroGenero que retorne um array, com os títulos das séries que são correspondentes com o genero do parâmetro.
//
// Exemplo:
//
// queroGenero("Caos"); // Retorna ["Bernardo The Master of the Wizards", "10 Days Why"]

function queroGenero(genero){
  var seriesGenero = [];
  for(var i of series){
    for(var j of i.genero)
      if(j === genero) seriesGenero.push(i.titulo);
  }
  return seriesGenero;
}
console.log(queroGenero("Caos"));
// B) Sei exatamente o que quero assisitir! Escreva uma função chamada queroTitulo que retorne um array, com os títulos das séries que tem título semelhante ao passado
//
// Exemplo:
//
// queroTitulo("The"); // Retorna ["The Walking Dead", "Bernardo The Master of the Wizards"]
// E ai, tudo tranquilo até agora? Manjando dos paranauês? Tem o dom? Eu sei JavaScript?
//
// Vamos começar a dificultar um pouco mais.
//

function queroTitulo(titulo){
  var seriesTitulo = [];
  for(var i of series){
      if(i.titulo.includes(titulo)) seriesTitulo.push(i.titulo);
  }
  return seriesTitulo;
}
console.log(queroTitulo("The"));

// Exercício 7
//
// Créditos
//
// Ao final de um episódio, temos os créditos do episódio. Para isso vamos implementar uma função, chamada de creditosIlluminatis que recebe uma série como parâmetro e imprima os créditos a partir dela.
//
// Tranquilo né? Easy! MAS, tem o seguinte: Os créditos são sempre ordenados alfabeticamente, mas pelo ÚLTIMO NOME!! Faça os ajustes necessários para que isso seja possível.
//
// Dica: Consulte as interwebsss para ajudar
//
// anoEstreia:2016
// diretor:Array(2)
// distribuidora:"Netflix"
// elenco:Array(11)
// genero:Array(3)
// numeroEpisodios:8
// temporadas:1
// titulo:"Stranger Things"

// Deverá ser impresso, o Título da serie,
// os Diretores, avisando com um título que é o bloco deles.
// Em seguida vem o elenco, também com um título de Elenco.

function creditosIlluminatis(serie){
  function diretores(diretores){
    var retornoDiretores = [];
    for(let i of diretores){
      retornoDiretores.push(i)
    }
    return retornoDiretores;
  }
  function elenco(elencoSeriado){
    var retornoElenco = [];
    for(let i of elencoSeriado)
      retornoElenco.push(i);


  retornoElenco.sort(function compare(a, b) {
      var splitA = a.split(" ");
      var splitB = b.split(" ");
      var lastA = splitA[splitA.length - 1];
      var lastB = splitB[splitB.length - 1];

      if (lastA < lastB) return -1;
      if (lastA > lastB) return 1;
      return 0;
  })
    return retornoElenco;
  }
  return serie.titulo + "<h1>Diretores</h1>"+
    diretores(serie.diretor) + "<h1>Elenco</h1>" +
    elenco(serie.elenco)
}

console.log(creditosIlluminatis(series[0]));

// Exercício 8
//
// Serie Illuminati
//
// Escondemos um pequeno easter egg neste exercicio!
//
// Para que ele seja descoberto, será necessário algumas informações; Quando abreviamos um nome colocamos a primeira letra do nome seguida de um ponto final
//
// Exemplo:
//
// Bernardo Bosak Rezende -> Bernardo B. Rezende
//
// Augusto Schiller Wartchow -> Augusto S. Wartchow
//
// Essa é a informação básica! Construa uma função que identificará aquela série que tem TODOS do elenco com nomes abreviados.
//
// Dica: Construa uma função separada para identificar se aquela String tem a abreviação;
//
function nomeAbreviado(nome){
  if(nome.includes(".")){
    return nome.indexOf(".")-1;
}
  return false;
}
// Show de bola, estamos quase lá!
//
// Uma vez achada a série, vamos modificar um pouquinho a implementação. Coloque todas as palavras abreviadas (de preferência sem os pontos finais) em uma string que será retornada ao final do método.
//
// Forme uma hashtag com a palavra! #PALAVRA
//

function serieIlluminati(serie){
  var retorno = "";
  for (var i of serie){
    for(var j of i.elenco){
        let nomeAbrev = nomeAbreviado(j)
        if(nomeAbrev !== false)
          retorno = retorno.concat(j[nomeAbrev])
        else break;
    }
  }
  return retorno;
}

console.log(serieIlluminati(series));
// Ao commitar, coloque no comentário do commit o que achou ;)
//
// Um bom FDS!
//
// NÃO SURTEM!!
//
