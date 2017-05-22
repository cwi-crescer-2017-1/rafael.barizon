// INICIALIZACAO DO MODULO
var myapp = angular.module(`myapp`,[]);
// INICIALIZACAO DO ARRAY DE AULAS
let aulas = [
  { id: 0,    // Gerado
    nome:'Orientacao a Objetos' // Obrigatório (length = min 3, max 20)
  },
  {
    id: 1,
    nome:'Banco de Dados'
  },
  {
    id: 2,
    nome: ""
  },
  {
    id:3,
    nome: 'BD2'
  }
];
// INICIALIZACAO DO ARRAY DE INSTRUTORES
let instrutores = [
  { id: 0,                              // Gerado
    nome: 'Bernardo',                   // Obrigatório (length = min 3, max 20)
    sobrenome: 'Rezende',               // Opcional (length = max 30)
    idade: 30,                          // Obrigatório (max 90)
    email: 'bernardo@cwi.com.br',       // Obrigatório (type=email)
    jaDeuAula: true,                    // true ou false
    aula: [aulas[0], aulas[1]],                   // Opcional (array)
    urlFoto: 'http://foto.com/3.png'    // Opcional (porém tem uma default de livre escolha)
  },
  {
    id:1,
    nome: 'Nunes',
    aula: [aulas[3]]
  },
  {
    id:2,
    nome: 'Antonio',
    aula: [aulas[3]]
  }


];
// INICIO CONTROLLER
myapp.controller('controller', ['$scope', function($scope){
  $scope.incluirAula = function (){
    if($scope.formIncluiAula.$valid){
      let aulaExiste = false;
      for(a of aulas){
        if(a.nome === $scope.novaAula.nome)
          aulaExiste = true;
      }
      if(!aulaExiste){
        $scope.novaAula.id = aulas.length;
        aulas.push($scope.novaAula);
        $scope.novaAula = {};
        alert("Aula Incluida");
      }
    } else {
      alert("Nome Aula Incompleto ou Atingiu numero max de Letras")
    }
  }

  $scope.alterarAula = function(){
    aulas[$scope.selecaoAula.id].nome = $scope.alterarAula.nome;
    alert("aula Alterada");
  }

  $scope.deletarAula = function (){
      let deletar = $scope.deletarAula.nome
      if($scope.formDeletarAula.$valid){
        let auxiliar = false;
        let index = aulas.map(a => a.nome).indexOf(deletar)
        if(index != -1){
          let arrayInstrutoresAulas = instrutores.map(i => i.aula)
          for(array of arrayInstrutoresAulas)
          for(a of array){
            if(a.nome.indexOf(deletar) != -1){
              auxiliar = true;
              break;
            }
          }
          if(!auxiliar){
            aulas.splice(index, 1);
            $scope.deletarAula = {};
            alert("aula deletada");
          }
        } else  auxiliar ? alert("Não é possível excluir esta aula. Está sendo utilizada.") : alert("nao existe essa aula no array de aulas");
      }
    }

  $scope.incluirInstrutor = function (){
    if($scope.formIncluiInstrutor.$valid){
      let instrutorExiste = false;
      let emailExiste = false;
      for(i of instrutores){
        if(i.nome === $scope.novoInstrutor.nome &&
           i.sobrenome === $scope.novoInstrutor.sobrenome)
          instrutorExiste = true;
        if(i.email === $scope.novoInstrutor.email &&
           $scope.novoInstrutor.email != null )
           emailExiste = true;
      }

      if(!instrutorExiste && !emailExiste){
        $scope.novoInstrutor.id = instrutores.length;
        let aulasInstrutor = [];
        if($scope.novoInstrutor.aula != null)
        for(a of aulas)
          for(i of $scope.novoInstrutor.aula){
            if(a.nome === i){
            aulasInstrutor.push(a);
            }
        }
        $scope.novoInstrutor.aula = aulasInstrutor;
        instrutores.push($scope.novoInstrutor);
        $scope.novoInstrutor = {};
        alert("Inclusão realizada com Sucesso.")
      }else instrutorExiste ? alert("Instrutor já cadastrado.") : alert("Email já está sendo utilizado.")

    } else {
      alert("Informacoes Incompletas");
    }
  }

  $scope.alterarInstrutor = function (){
    if($scope.alteraNovoInstrutor != undefined){
      let indexInstrutor;
      for (i of instrutores){
        if(i.nome === $scope.selectAltera)
          indexInstrutor = instrutores.indexOf(i);
        }

        if($scope.alteraNovoInstrutor.nome       != undefined)
          instrutores[indexInstrutor].nome        = $scope.alteraNovoInstrutor.nome       ;
        if($scope.alteraNovoInstrutor.sobrenome  != undefined)
          instrutores[indexInstrutor].sobrenome   = $scope.alteraNovoInstrutor.sobrenome  ;
        if($scope.alteraNovoInstrutor.idade      != undefined)
          instrutores[indexInstrutor].idade       = $scope.alteraNovoInstrutor.idade      ;
        if($scope.alteraNovoInstrutor.email      != undefined)
          instrutores[indexInstrutor].email       = $scope.alteraNovoInstrutor.email      ;
        if($scope.alteraNovoInstrutor.dandoAula  != undefined)
          instrutores[indexInstrutor].dandoAula   = $scope.alteraNovoInstrutor.dandoAula  ;
        if($scope.alteraNovoInstrutor.aula       != undefined)
          instrutores[indexInstrutor].aula        = $scope.alteraNovoInstrutor.aula       ;
        if($scope.alteraNovoInstrutor.urlFoto    != undefined)
          instrutores[indexInstrutor].urlFoto     = $scope.alteraNovoInstrutor.urlFoto    ;

        $scope.alteraNovoInstrutor = {};
        alert("alterou");
  } else {
    alert("Nenhuma Informacao passada para alterar Instrutor");
  }
}
  $scope.deletarInstrutor = function (){
    let dandoAula = false;

    if($scope.formDeletaInstrutor.$valid){
      for (i of instrutores){
        let indexInstrutor = instrutores.indexOf(i);
        if(i.nome === $scope.instrutorDeletar){
            if(i.jaDeuAula) dandoAula = true;
            else {
              instrutores.splice(indexInstrutor, 1);
              alert("Deletou");
            }
        }
      }
    }
    if(dandoAula) alert("Não é possível excluir este instrutor. Está dando aula.")
  }
  $scope.aulas = aulas;
  $scope.instrutores = instrutores;

}]);
// FIM CONTROLLER


myapp.filter('aulaOrderBy', function(){
  return function(){
    return aulas.sort(function(a, b) {
          var nameA = a.nome.toUpperCase(); // ignore upper and lowercase
          var nameB = b.nome.toUpperCase(); // ignore upper and lowercase
          if (nameA < nameB) {
            return -1;
          }
          if (nameA > nameB) {
            return 1;
          }
          // names must be equal
          return 0;
        });
  }
})
myapp.filter('instrutorOrderBy', function(){
  return function(){
    return instrutores.sort(function(a, b) {
          var nameA = a.nome.toUpperCase(); // ignore upper and lowercase
          var nameB = b.nome.toUpperCase(); // ignore upper and lowercase
          if (nameA < nameB) {
            return -1;
          }
          if (nameA > nameB) {
            return 1;
          }
          // names must be equal
          return 0;
        });
  }
})
