using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace LocacaoDeFestasCrescer.Dominio.Entidades
{
    public class Cliente
    {
        public int Id { get; private set; }
        public string Nome { get; set; }
        public string Cpf { get; set; }
        public string Endereco { get; set; }
        public Genero Genero { get; set; }
        public DateTime DataNascimento { get; set; }
        public List<string> Mensagens { get; private set; }

        protected Cliente () { }

        public Cliente ( string nome, string cpf, string endereco, Genero genero, DateTime dataNascimento)
        {
            Nome = nome;
            Cpf = cpf;
            Endereco = endereco;
            Genero = genero;
            DataNascimento = dataNascimento;
            Mensagens = new List<string>();
        }
        public void AlterarCliente(string nome, string cpf, string endereco, Genero genero, DateTime dataNascimento)
        {
            Nome = nome;
            Cpf = cpf;
            Endereco = endereco;
            Genero = genero;
            DataNascimento = dataNascimento;
        }

        public bool Validar()
        {
            Mensagens.Clear();

            if(string.IsNullOrEmpty(Nome) || Nome.Length < 6 )
                Mensagens.Add("Nome é inválido.");
            if (string.IsNullOrEmpty(Cpf) || Cpf.Length != 11)
                Mensagens.Add("CPF inválido.");
            if (string.IsNullOrEmpty(Endereco))
                Mensagens.Add("Endereco é inválido.");
            if (DataNascimento == null)
                Mensagens.Add("Data de Nascimento é inválida.");

            return Mensagens.Count == 0;

        }
    }
}