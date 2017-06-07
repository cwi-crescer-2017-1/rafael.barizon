using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using LocacaoDeFestasCrescer.Dominio.Entidades;
using System.Data.Entity;

namespace LocacaoDeFestasCrescer.Infraestrutura.Repositorios
{
    public class UsuarioRepositorio: IDisposable
    {
        private Contexto contexto = new Contexto();
        
        public void Criar(Usuario usuario)
        {
            contexto.Usuarios.Add(usuario);
            contexto.SaveChanges();
        }

        public void Alterar(Usuario usuario)
        {
            contexto.Entry(usuario).State = EntityState.Modified;
            contexto.SaveChanges();
        }

        public Usuario Obter(string email)
        {
            return contexto.Usuarios.FirstOrDefault(u => u.Email == email);
        }

        public void Dispose()
        {
            contexto.Dispose();
        }
    }
}
