var myapp =  angular.module('myApp',[])

myapp.controller('controller',['$scope', function($scope){
  var instrutores = [{
      nome: 'Bernardo',
      aula: [{
         numero: 1,
         nome: 'OO'},
        {numero: 4,
         nome: 'Javascript'}]},
    {
      nome: 'Nunes',
      aula: [{
        numero: 2,
        nome: 'Banco de Dados I'}]},
    {
      nome: 'Pedro (PHP)',
      aula: [{
        numero: 3,
        nome: 'HTML e CSS'}]},
    {
      nome: 'Zanatta',
      aula: [{
        numero: 5,
        nome: 'AngularJS'}]}
  ];
  $scope.instrutores = instrutores;
  $scope.minhaFuncao = function(){
    var data = $scope.dataDigitada;
    data = data.split('/');
    data = new Date(data[2], data[1]-1, data[0])
    $scope.dataTerminada = data;
  }
}])

myapp.filter('mascada', function(){
  return function(nome){
     return nome.replace(/(nunes)/i,'$ $1 $')
    // return  nome.replace(/(nunes|bernardo|zanatta)/i,'$ $1 $')

  }
})
