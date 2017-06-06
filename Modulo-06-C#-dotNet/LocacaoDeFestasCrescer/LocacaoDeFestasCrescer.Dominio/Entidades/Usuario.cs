﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Cryptography;
using System.Text;
using System.Threading.Tasks;

namespace LocacaoDeFestasCrescer.Dominio.Entidades
{
    public class Usuario
    {
        static readonly char[] _caracteresNovaSenha = "abcdefghijklmnopqrstuvzwyz1234567890*-_".ToCharArray();
        static readonly int _numeroCaracteresNovaSenha = 10;

        public int Id { get; private set; }
        public string Nome { get; private set; }
        public string Email { get; private set; }
        public string Senha { get; private set; }
        public bool Gerente { get; private set; }
        public List<string> Mensagens { get; private set; }

        // Construtor padrão para o Entity Framework
        protected Usuario()
        {
        }

        public Usuario(string nome, string email, string senha)
        {
            Nome = nome;
            Email = email;
            if (!string.IsNullOrWhiteSpace(senha))
                Senha = CriptografarSenha(senha);
            Gerente = false;
            Mensagens = new List<string>();
        }

        public string ResetarSenha()
        {
            var senha = string.Empty;
            for (int i = 0; i < _numeroCaracteresNovaSenha; i++)
            {
                senha += new Random().Next(0, _caracteresNovaSenha.Length);
            }

            Senha = CriptografarSenha(senha);

            return senha;
        }

        private string CriptografarSenha(string senha)
        {
            MD5 md5 = MD5.Create();
            byte[] inputBytes = Encoding.Default.GetBytes(Email + senha);
            byte[] hash = md5.ComputeHash(inputBytes);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < hash.Length; i++)
                sb.Append(hash[i].ToString("x2"));

            return sb.ToString();
        }

        public bool ValidarSenha(string senha)
        {
            return CriptografarSenha(senha) == Senha;
        }

        public void AtribuirPermissaoDeGerente()
        {
            Gerente = true;
        }

        public bool Validar()
        {
            Mensagens.Clear();

            if (string.IsNullOrWhiteSpace(Nome))
                Mensagens.Add("Nome é inválido.");

            if (string.IsNullOrWhiteSpace(Email))
                Mensagens.Add("Email é inválido.");

            if (string.IsNullOrWhiteSpace(Senha))
                Mensagens.Add("Senha é inválido.");

            return Mensagens.Count == 0;
        }
    }
}
