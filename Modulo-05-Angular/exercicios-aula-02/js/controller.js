var myapp =  angular.module('myApp',[])

myapp.controller('controller',['$scope', function($scope){

  $scope.minhaFuncao = function(){

    var data = $scope.dataDigitada;
    data = data.split('/');
    console.log(data);
    data = new Date(data[2], data[1]-1, data[0])
    $scope.dataTerminada = data;
    console.log(data);

    console.log("Clicou");
  }
  // 
  //
  // $scope.outraFuncao = function(){
  //
  //
  //   let dataFormatada = $scope.dataDigitada.split('/');
  //
  //
  //
  // }
  console.log("oi");
}])
