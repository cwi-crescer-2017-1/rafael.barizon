using System;
using System.Collections.Generic;
using System.Linq;
using System.Web.Http;

namespace LocacaoDeFestasCrescer.Dominio
{
    public static class WebApiConfig
    {
        public static void Register(HttpConfiguration config)
        {
            
            // Rotas da API da Web
            config.MapHttpAttributeRoutes();

            config.Routes.MapHttpRoute(
                name: "DefaultApi",
                routeTemplate: "api/{controller}/{id}",
                defaults: new { id = RouteParameter.Optional }
            );
        }
    }
}
