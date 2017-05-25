console.log("comecou");

/* Exercício 1
Busca por número
Crie um arquivo pokesearch.html (com javascript incluído) e implemente o evento de click do botão para pesquisar pelo pokémon a partir do número digitado no input. No retorno da requisição, renderize dentro de uma div as seguintes informações do pokémon:
Nome
Número
Sprite principal do pokémon (front_default)
Lista de descrições dos tipos (pode ser um elemento <ul>)
Fique à vontade para estilizar a página como desejar. Compartilhe no slack com seus colegas! */
let div = document.getElementById("detalhesPokemon");
let img = document.createElement('img');
let pName = document.createElement('p');
let pId = document.createElement('p');

document.addEventListener(`DOMContentLoaded`, function(){
  var btnPesquisar = document.getElementById("enviarInputPokemon");
  btnPesquisar.onclick = function(){
    let pokemonNumber = document.getElementById("inputPokemon").value;
    let url = "http://pokeapi.co/api/v2/pokemon/" + pokemonNumber + "/";
    fetch(url).then(response => response.json())
    .then(json=> {
      console.log(json);
img.src = json.sprites.front_default;
pName.innerHTML = json.name;
pId.innerHTML = json.id;

div.append(pName);
div.append(pId);
div.append(img);
//      console.log(json);
//       console.log(json.sprites.front_default);
//       let div = document.getElementById('detalhesPokemon');
//       let img = document.createElement('img');
//       img.src = json.sprites.front_default;
//       div.append(img);
    })
  }
}
)





//
