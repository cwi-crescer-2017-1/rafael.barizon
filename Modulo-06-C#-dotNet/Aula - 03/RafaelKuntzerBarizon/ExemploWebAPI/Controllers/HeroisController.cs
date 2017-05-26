using ExemploWebAPI.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace ExemploWebAPI.Controllers
{
    public class HeroisController : ApiController
    {
        private static List<Heroi> listaHerois = new List<Heroi>();
        private static int idIncremento = 0;
        public List<Heroi> Get(int? id = null)
        {

            //var herois = new List<Heroi>()
            //            {
            //                new Heroi() { Id= 1, Nome = "Goku",
            //                                        Poder = new Poder() {
            //                                            Nome = "Genki Dama",
            //                                            Dano = 8000
            //                                        }
            //                            },
            //                new Heroi() { Id= 2, Nome = "Luffy",
            //                                        Poder = new Poder() {
            //                                            Nome = "Giganto Pistol",
            //                                            Dano = 15000
            //                                        }
            //                            },
            //                new Heroi() { Id= 3, Nome = "Roronora Zoro",
            //                                        Poder = new Poder() {
            //                                            Nome = "Kyutoryu",
            //                                            Dano = 10000
            //                                        }
            //                            }
            //            };
            return listaHerois;
                //id != null ? herois.Where(x => x.Id == id).ToList() : herois;
        }

        public IHttpActionResult Post(Heroi heroi)
        {
            if (heroi == null)
            {
                return BadRequest();
            }
            else
            {
                heroi.Id = idIncremento++;
                listaHerois.Add(heroi);
                return Ok(heroi);
            }
        }
    }
}
