using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace LocacaoDeFestasCrescer.Dominio.Entidades
{
    public class Cliente
    {
        public int Id { get; set; }
        public string Nome { get; set; }
        public string Cpf { get; set; }
        public string Endereco { get; set; }
        public Genero Genero { get; set; }
        public DateTime DataNascimento { get; set; }

        public bool Validar()
        {
            return Nome.Length > 6 ?
                   Cpf.Length == 11 ?
                   Endereco != null ?
                   DataNascimento != null?
                   true :
                   true :
                   true :
                   true :
                   false;

        }
    }
}