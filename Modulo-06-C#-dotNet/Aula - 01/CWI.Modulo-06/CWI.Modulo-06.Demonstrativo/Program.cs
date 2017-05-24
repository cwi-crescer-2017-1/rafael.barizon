using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CWI.Modulo_06.Demonstrativo
{
    class Program
    {
        static void Main(string[] args)
        {
            FolhaDePagamento folha = new FolhaDePagamento();
            Demonstrativo demonstrativo = folha.GerarDemonstrativo(200, 5000, 50, 10);

            Console.WriteLine($"Salario Base ({demonstrativo.HrsConvencao}hrs)                      {demonstrativo.SalarioBase}");
            Console.WriteLine($"Horas Extras ({demonstrativo.HorasExtras.QtdHoras}hrs)                       {demonstrativo.HorasExtras.ValorTotalHoras}" );
            Console.WriteLine($"Horas Descontadas ({demonstrativo.HorasDescontadas.QtdHoras}hrs)                  {demonstrativo.HorasDescontadas.ValorTotalHoras}");
            Console.WriteLine($"TotalProventos                             " + demonstrativo.TotalProventos);
            Console.WriteLine($"INSS {demonstrativo.Inss.Aliquota*100}                                    {demonstrativo.Inss.Valor}" );
            Console.WriteLine($"Irrf {demonstrativo.Irrf.Aliquota * 100}                                  {demonstrativo.Irrf.Valor}");
            Console.WriteLine("TotalDescontos                             " + demonstrativo.TotalDescontos);
            Console.WriteLine("TotalLiquido                               " + demonstrativo.TotalLiquido);
            Console.WriteLine($"Fgts {demonstrativo.Fgts.Aliquota * 100}                                    {demonstrativo.Fgts.Valor}");
            
            Console.ReadKey();
        }
    }
}
