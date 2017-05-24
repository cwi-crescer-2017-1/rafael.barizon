using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CWI.Modulo_06.Demonstrativo
{

    public class HorasCalculadas
    {
            public HorasCalculadas(double qtdHoras, double valorTotalHoras)
            {
                QtdHoras = qtdHoras;
                ValorTotalHoras = valorTotalHoras;
            }
            public double QtdHoras { get; private set; }
            public double ValorTotalHoras { get; private set; }
        

    }
}
