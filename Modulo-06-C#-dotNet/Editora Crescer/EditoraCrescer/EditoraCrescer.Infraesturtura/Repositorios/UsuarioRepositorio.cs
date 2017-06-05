using AutDemo.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;


namespace EditoraCrescer.Infraesturtura.Repositorios
{
    public class UsuarioRepositorio: IDisposable
    {
        private Contexto contexto = new Contexto();
        //static readonly Dictionary<string, Usuario> _usuarios = new Dictionary<string, Usuario>();



        //static UsuarioRepositorio()
        //{
        //    // YWRtaW5AY3dpLmNvbS5icjoxMjM0NTY=
        //    var usrAdmin = new Usuario("admin", "admin@cwi.com.br", "123456");
        //    usrAdmin.AtribuirPermissoes("Administrador");
        //    _usuarios.Add(usrAdmin.Email, usrAdmin);

        //    // Z2lvdmFuaUBjd2kuY29tLmJyOjEyMzQ1Ng==
        //    var usrGiovani = new Usuario("giovani", "giovani@cwi.com.br", "123456");
        //    _usuarios.Add(usrGiovani.Email, usrGiovani);
        //}
             
        
        public bool AuthUsuario(string auth)
        {
            if(auth == null)
            {
                return false;
            }
            else
            {
                string tokenAutenticacao = auth;
                string decodedAutenticacao = 
                    Encoding.Default.GetString(Convert.FromBase64String(tokenAutenticacao));
                //BUSCAR DO BANCO PARA AUTENTICAR
                string[] userNameAndPassword = decodedAutenticacao.Split(':');
                string usuario = userNameAndPassword[0];
                string senha = userNameAndPassword[1];

                if (!(usuario == "rafael.barizon" && senha == "123456"))
                {
                    return false;
                }
                var permissoes = contexto.Usuarios.Where(x => x.Email == usuario)
                    .Select(x => new { Roles = x.Permissoes });
                //    .Include(x => x.Revisor)

                if (permissoes == null)
                {
                    return false;
                }
            }
            return true;
        }
        
        public bool Inserir(Usuario usuario)
        {
            try
            {
                contexto.Usuarios.Add(usuario);
                contexto.SaveChanges();
                return true;
            }
            catch
            {
                return false;
            }
        }

        public bool Delete(int id)
        {
            try
            {
                var usuarioDelete = contexto.Usuarios.FirstOrDefault(x => x.Id == id);
                contexto.Usuarios.Remove(usuarioDelete);
                contexto.SaveChanges();
                return true;
            }
            catch
            {
                return false;
            }
        }
        
        public bool Alterar(int id, Usuario usuario)
        {
            try
            {
                if (id != usuario.Id)
                    return false;
                if (contexto.Usuarios.Count(x => x.Id == id) > 0)
                {
                    contexto.Entry(usuario).State = EntityState.Modified;
                    contexto.SaveChanges();
                    return true;
                }
                return false;
            }
            catch
            {
                return false;
            }
        }

        public IEnumerable<Usuario> Listar()
        {
            return contexto.Usuarios;
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
