using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Text;
using System.Web;
using System.Web.Http;
using System.Web.Http.Controllers;

namespace EditoraCrescer.Api.App_Start
{
    public class BasicAuthorizationAttribute: AuthorizeAttribute
    {
        public override void OnAuthorization(HttpActionContext actionContext)
        {
            if (actionContext.Request.Headers.Authorization == null)
            {
                actionContext.Response =
                    actionContext
                    .Request
                    .CreateResponse(HttpStatusCode.Unauthorized);
            }
            else
            {
                string tokenAutenticacao =
                    actionContext.Request.Headers.Authorization.Parameter;
                string decodedAutenticacao =
                    Encoding.Default.GetString(Convert.FromBase64String(tokenAutenticacao));
                //BUSCAR DO BANCO PARA AUTENTICAR
                string[] userNameAndPassword = decodedAutenticacao.Split(':');
                string usuario = userNameAndPassword[0];
                string senha = userNameAndPassword[1];
                string permissoes = "Administrador";
                if(!(usuario == "rafael.barizon" && senha == "123456"))
                {
                    actionContext.Response =
                    actionContext
                    .Request
                    .CreateResponse(HttpStatusCode.Unauthorized);
                }
                if(Roles != permissoes)
                {
                    actionContext.Response =
                                            actionContext
                                            .Request
                                            .CreateResponse(HttpStatusCode.Unauthorized);
                }
            }
        }
    }
}