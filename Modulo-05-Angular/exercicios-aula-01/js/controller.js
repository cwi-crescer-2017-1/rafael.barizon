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
myapp.controller('controllerFiltro', ['$scope', function($scope){
  let pokemons = [
    $scope.pokemons = {nome:"Bulbasaur" , tipo:"Grass"},
    $scope.pokemons = {nome:"Charmander" , tipo:"Fire"},
    $scope.pokemons = {nome:"Squirtle" , tipo:"Water"},
    $scope.pokemons = {nome:"Metapod" , tipo:"Bug"},
    $scope.pokemons = {nome:"Kakuna" , tipo:"Bug"},
    $scope.pokemons = {nome:"Pidgeotto" , tipo:"Flying"},
    $scope.pokemons = {nome:"Spearow" , tipo:"Flying"},
    $scope.pokemons = {nome:"Arbok" , tipo:"Poison"},
    $scope.pokemons = {nome:"Sandshrew" , tipo:"Ground"},
    $scope.pokemons = {nome:"Nidoqueen" , tipo:"Poison"},
    $scope.pokemons = {nome:"Vulpix" , tipo:"Fire"}
  ];
$scope.pokemons = pokemons;
}]);
