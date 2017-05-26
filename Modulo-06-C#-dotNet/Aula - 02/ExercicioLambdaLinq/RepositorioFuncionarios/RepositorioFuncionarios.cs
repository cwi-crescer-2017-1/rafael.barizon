using System;
using System.Collections;
using System.Collections.Generic;
using System.ComponentModel;
using System.Dynamic;
using System.Globalization;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace Repositorio
{
    public class RepositorioFuncionarios
    {
        public List<Funcionario> Funcionarios { get; private set; }

        public RepositorioFuncionarios()
        {
            CriarBase();
        }

        private void CriarBase()
        {
            Funcionarios = new List<Funcionario>();

            Cargo desenvolvedor1 = new Cargo("Desenvolvedor Júnior", 190);
            Cargo desenvolvedor2 = new Cargo("Desenvolvedor Pleno", 250);
            Cargo desenvolvedor3 = new Cargo("Desenvolvedor Sênior", 550.5);

            Funcionario lucasLeal = new Funcionario(1, "Marcelinho Carioca", new DateTime(1995, 01, 24));
            lucasLeal.Cargo = desenvolvedor1;
            lucasLeal.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(lucasLeal);

            Funcionario jeanPinzon = new Funcionario(2, "Mark Zuckerberg", new DateTime(1991, 04, 25));
            jeanPinzon.Cargo = desenvolvedor1;
            jeanPinzon.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(jeanPinzon);

            Funcionario rafaelBenetti = new Funcionario(3, "Aioros de Sagitário", new DateTime(1991, 08, 15));
            rafaelBenetti.Cargo = desenvolvedor1;
            rafaelBenetti.TurnoTrabalho = TurnoTrabalho.Noite;
            Funcionarios.Add(rafaelBenetti);

            Funcionario mauricioBorges = new Funcionario(4, "Uchiha Madara", new DateTime(1996, 11, 30));
            mauricioBorges.Cargo = desenvolvedor1;
            mauricioBorges.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(mauricioBorges);

            Funcionario leandroAndreolli = new Funcionario(5, "Barack Obama", new DateTime(1990, 03, 07));
            leandroAndreolli.Cargo = desenvolvedor1;
            leandroAndreolli.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(leandroAndreolli);

            Funcionario felipeNervo = new Funcionario(6, "Whindersson  Nunes", new DateTime(1994, 01, 12));
            felipeNervo.Cargo = desenvolvedor1;
            felipeNervo.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(felipeNervo);

            Funcionario lucasKauer = new Funcionario(7, "Optimus Prime", new DateTime(1997, 05, 10));
            lucasKauer.Cargo = desenvolvedor1;
            lucasKauer.TurnoTrabalho = TurnoTrabalho.Noite;
            Funcionarios.Add(lucasKauer);

            Funcionario eduardoArnold = new Funcionario(8, "Arnold Schwarzenegger", new DateTime(1989, 09, 16));
            eduardoArnold.Cargo = desenvolvedor1;
            eduardoArnold.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(eduardoArnold);

            Funcionario gabrielAlboy = new Funcionario(9, "Bill Gates", new DateTime(1990, 02, 25));
            gabrielAlboy.Cargo = desenvolvedor2;
            gabrielAlboy.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(gabrielAlboy);

            Funcionario carlosHenrique = new Funcionario(10, "Linus Torvalds", new DateTime(1965, 12, 02));
            carlosHenrique.Cargo = desenvolvedor2;
            carlosHenrique.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(carlosHenrique);

            Funcionario margareteRicardo = new Funcionario(11, "Dollynho Developer", new DateTime(1980, 10, 10));
            margareteRicardo.Cargo = desenvolvedor3;
            margareteRicardo.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(margareteRicardo);
        }

        public IList<Funcionario> BuscarPorCargo(Cargo cargo)
        {
            return Funcionarios
                .Where(funcionario => funcionario.Cargo.Titulo == cargo.Titulo
                                   && funcionario.Cargo.Salario == cargo.Salario)
                .ToList();
        }

        public IList<Funcionario> OrdenadosPorCargo()
        {
            return Funcionarios
                .OrderBy(funcionario => funcionario.Cargo.Titulo)
                .ThenBy(funcionario => funcionario.Nome)
                .ToList();
        }

        public IList<Funcionario> BuscarPorNome(string nome)
        {
            return Funcionarios
                .FindAll(f => f.Nome.IndexOf(nome, StringComparison.OrdinalIgnoreCase) >= 0);
        }

        public IList<Funcionario> BuscarPorTurno(params TurnoTrabalho[] turnos)
        {
            var retorno = new List<Funcionario>();

            foreach (var turno in turnos)
            {
                retorno.AddRange(Funcionarios.Where(f => f.TurnoTrabalho == turno).ToList());
            }

            return turnos.Length == 0 ? Funcionarios : retorno;
        }

        public IList<Funcionario> FiltrarPorIdadeAproximada(int idade)
        {
            return Funcionarios
            .Where(f => CalcularIdade(f.DataNascimento) <= idade + 5 && CalcularIdade(f.DataNascimento) >= idade - 5)
            .ToList();
        }

        private int CalcularIdade(DateTime dataNascimento)
        {
            DateTime DataAgora = DateTime.Today;
            var idade = DataAgora.Year - dataNascimento.Year;
            if (dataNascimento > DataAgora.AddYears(-idade)) idade--;
            Console.WriteLine(idade);
            return idade;
        }

        public double SalarioMedio(TurnoTrabalho? turno = null)
        {
            var listaFuncionariosTurno = turno == null ? Funcionarios : Funcionarios.Where(f => f.TurnoTrabalho.Equals(turno)).ToList();

            double totalSalario = 0.0;

            foreach (var f in listaFuncionariosTurno)
            {
                totalSalario += f.Cargo.Salario;
            }
            return totalSalario / listaFuncionariosTurno.Count;
        }

        public IList<Funcionario> AniversariantesDoMes()
        {
            DateTime mesAtual = DateTime.Today;

            return Funcionarios
                .Where(f => f.DataNascimento.Month == mesAtual.Month)
                .ToList();
        }

        public IList<dynamic> BuscaRapida()
        {
            dynamic list = new List<Object>();

            foreach (var f in Funcionarios)
            {
                var obj = new { NomeFuncionario = f.Nome, TituloCargo = f.Cargo.Titulo };
                list.Add(obj);
            }

            return list;
        }

        public IList<dynamic> QuantidadeFuncionariosPorTurno()
        {
            //Deve retornar a quantidade de funcionários por turno, para isso, devolver o resultado na estrutura de uma lista cujo objeto tenha as propriedades Turno e Quantidade.
            dynamic list = new List<Object>();


            var listaManha = BuscarPorTurno(TurnoTrabalho.Manha);
            var listaTarde = BuscarPorTurno(TurnoTrabalho.Tarde);
            var listaNoite = BuscarPorTurno(TurnoTrabalho.Noite);

            var objManha = new { Turno = TurnoTrabalho.Manha, Quantidade = listaManha.Count };
            var objTarde = new { Turno = TurnoTrabalho.Tarde, Quantidade = listaTarde.Count };
            var objNoite = new { Turno = TurnoTrabalho.Noite, Quantidade = listaNoite.Count };

            list.Add(objManha);
            list.Add(objTarde);
            list.Add(objNoite);

            return list;
        }

        public dynamic FuncionarioMaisComplexo()
        {
            var consoantes = new HashSet<char> { 'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'x' };

            var listFuncionarios = Funcionarios
                                .Where(f => f.TurnoTrabalho != TurnoTrabalho.Tarde && f.Cargo.Titulo != "Desenvolvedor Júnior")
                                .ToList();

            Funcionario funcionarioMaior = listFuncionarios[0];
            int totalConsoantesMaior = 0;
            foreach (var f in listFuncionarios)
            {
                int totalConsoantes = 0;
                for (int i = 0; i < f.Nome.Length; i++)
                {
                    if (consoantes.Contains(f.Nome[i]))
                    {
                        totalConsoantes++;
                    }
                }
                if (totalConsoantesMaior < totalConsoantes)
                {
                    funcionarioMaior = f;
                }
            }
            var qtdMesmoCargo = BuscarPorCargo(funcionarioMaior.Cargo).Count;
            string text = "";
            DateTime dt;
            if (DateTime.TryParseExact(funcionarioMaior.DataNascimento.ToString(), "MM/dd/yyyy hh:mm:ss",
                                       CultureInfo.InvariantCulture, DateTimeStyles.None,
                                       out dt))
            {
                text = dt.ToString("dd/MM/yyyy", CultureInfo.InvariantCulture);
            }
            Console.WriteLine(string.Format("{0:0.00}", funcionarioMaior.Cargo.Salario));
            var funcionarioRetorno = new
            {
                Nome = funcionarioMaior.Nome,
                DataNascimento = text,
                SalarioRS = "R$ " + string.Format("{0:0.00}", funcionarioMaior.Cargo.Salario),
                SalarioUS = "$" + funcionarioMaior.Cargo.Salario.ToString("0.00", System.Globalization.CultureInfo.InvariantCulture),
                QuantidadeMesmoCargo = qtdMesmoCargo
            };

            return funcionarioRetorno;
        }
    }
}


