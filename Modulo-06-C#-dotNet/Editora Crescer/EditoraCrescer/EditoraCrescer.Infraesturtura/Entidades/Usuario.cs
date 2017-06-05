using System;
using System.Collections.Generic;
using System.Security.Cryptography;
using System.Text;

namespace AutDemo.Dominio.Entidades
{
    public class Usuario 
    {
        public int Id { get;  set; }
        public string Nome { get;  set; }
        public string Email { get;  set; }
        public string Senha { get;  set; }
        public List<Permissao> Permissoes { get; set; }
        
    }
}
