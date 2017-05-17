var myapp = angular.module('myApp',[]);


myapp.controller('controllerPokemon', ['$scope', function($scope){
$scope.pokemon = {};
$scope.pokemon.nome = "Pokemon";
$scope.pokemon.id = 0;
}
])
myapp.controller('controllerPokemonRepeat', ['$scope', function($scope){
  var pokemons= [
    {nome:"Bulbasaur", tipo:"Poison/Grass"},
    {nome:"Charmander", tipo:"Fire"},
    {nome:"Squirtle", tipo:"Water"}];
$scope.pokemons = pokemons;
}
])
