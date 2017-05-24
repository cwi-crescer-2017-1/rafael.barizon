using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CWI.Modulo_06.Demonstrativo
{
    public class Desconto
    {
        public Desconto(double aliquota, double valor)
        {
            Aliquota = aliquota;
            Valor = valor;
        }

        public double Aliquota { get; private set; }
        public double Valor { get; private set; }
    }
}
