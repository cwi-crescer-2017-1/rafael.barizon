// Crescer 2017-1 | Módulo 04 - AngularJS
//
// # AngularJS - Aula 01 - Exercícios
//
// Exibir uma lista de pokémons (um pokémon tem nome e tipo) e permitir que o usuário possa filtrar (por nome, conforme for digitando).
//
// ### Requisitos Mínimos
// - Campo Filtro deve ser um `input` de texto.
// - Utilizar `controller`.
// - Lista deve ter pelo menos 10 pokémons.
// - Exemplo de Pokémon:
// ```javascript
// let pikachu = {
//   nome: 'Pikachu',
//   tipo: 'Raio'
// }
// ```
//
// ### Observaçõs
// - HTML e CSS ainda existem. Façam algo bonito.
// - Podem fazer mais que o mínimo, porém não menos.
// outra hora...

var myapp = angular.module('myApp',[]);
var pokemons = [
  {nome:"Bulbasaur" , tipo:"Grass"},
  {nome:"Charmander" , tipo:"Fire"},
  {nome:"Squirtle" , tipo:"Water"},
  {nome:"Metapod" , tipo:"Bug"},
  {nome:"Kakuna" , tipo:"Bug"},
  {nome:"Pidgeotto" , tipo:"Flying"},
  {nome:"Spearow" , tipo:"Flying"},
  {nome:"Arbok" , tipo:"Poison"},
  {nome:"Sandshrew" , tipo:"Ground"},
  {nome:"Nidoqueen" , tipo:"Poison"},
  {nome:"Vulpix" , tipo:"Fire"},
                ];
myapp.controller('controller', ['$scope', function($scope){
$scope.pokemons = pokemons;
}]);
