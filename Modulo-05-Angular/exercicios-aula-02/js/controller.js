var myapp =  angular.module('myApp',[])
var aulass = [{nome:"OO"},
{nome:"ANGULAR"},
{nome:"BANCO DE DADOS"},
{nome:"HTML/CSS"},
{nome:"JavaScript"}
]
var aulas = [
            {numero: "1",
            nome:"OO",
            instrutor:"Bernardo"},

            {numero: "2",
            nome:"Banco de Dados I",
            instrutor:"Nunes"},

            {numero: "3",
            nome:"HTML e CSS",
            instrutor:"Pedro (PHP)"},

            {numero: "4",
            nome:"Javascript",
            instrutor:"Bernardo"},

            {numero: "55",
            nome:"AngularJS",
            instrutor:"Zanatta"},
];
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

myapp.controller('controller',['$scope', function($scope){
  $scope.aulas = aulas;
  $scope.aulass = aulass;
  $scope.instrutores = instrutores;
  $scope.minhaFuncao = function(){
    var data = $scope.dataDigitada;
    data = data.split('/');
    data = new Date(data[2], data[1]-1, data[0])
    $scope.dataTerminada = data;
  }
  $scope.incluir = function(){
    console.log("oi");
    if($scope.formIncluiInstrutores.$invalid)
      return;
    console.log("form eh valido");
    var objInclusao = {ministraAulas:[]};
    objInclusao.nome = $scope.novoNome;
    objInclusao.sobrenome = $scope.novoSobrenome;
    objInclusao.idade = $scope.novoIdade;
    objInclusao.email = $scope.novoEmail;
    objInclusao.aula = $scope.novoJaDeuAula;
    objInclusao.ministraAulas.push( $scope.novoMinistraAulas);
    instrutores.push(objInclusao);
    console.log("incluido");
    console.log(objInclusao);
}
}])


myapp.filter('mascada', function(){
  return function(nome){
     return nome.replace(/(nunes)/i,'$ $1 $')
    // return  nome.replace(/(nunes|bernardo|zanatta)/i,'$ $1 $')
  }
})
// 3- Criar um novo filtro que recebe o objeto aula e formata como "numero - aula", onde numero deve ser lpad 3 (0) e aula uppercase. utilizar ele na listagem do exercício 2.
//
// Ex:
//
// 001 - OO                  Bernardo
// 002 - BANCO DE DADOS      $ Nunes $
// 003 - HTML e CSS          Pedro (PHP)
// 004 - Javascript          Bernardo
// 005 - AngularJS           Zanatta


myapp.filter(`numeroAula`,function(){
  return function(aula){
    let numero = pad(aula.numero, 3);
    return numero + " - "+ aula.nome.toUpperCase();
  }
})
// function for leftpadding from stackoverflow
function pad(n, width, z) {
  z = z || '0';
  n = n + '';
  return n.length >= width ? n : new Array(width - n.length + 1).join(z) + n;
}

//fazer de outra forma para pegar o array de dentro

// myapp.filter('outroFiltro', function(){
//   return function(aula){
//     let retorno = [];
//
//   }
//
// })
//




/* listar Instrutores
   Permitir Inclusao de novos instrutores

   Instrutor deve ter:

    Nome (texto - obrigatorio - 3~20Letras)
    Sobrenome ( texto - max 30 Letras)
    Idade (Numero - Obrigatorio)
    Email (obrigatorio)
    Informar se ja deu aula (checkbox)
    Qual aula ele ministra (select - lista de string de aulas)*/







































//
