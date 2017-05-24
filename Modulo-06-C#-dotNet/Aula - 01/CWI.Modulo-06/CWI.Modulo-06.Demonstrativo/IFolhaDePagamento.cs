using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CWI.Modulo_06.Demonstrativo
{
    public interface IFolhaDePagamento
    {
        Demonstrativo GerarDemonstrativo(int horasCategoria, double salarioBase, double horasExtras, double horasDescontadas);
    }
}
