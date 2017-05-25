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

            while (true) {

                String Horas, Salario, horasExtra, HorasDesconto;

                Horas = Console.ReadLine();
                Salario = Console.ReadLine();
                horasExtra = Console.ReadLine();
                HorasDesconto = Console.ReadLine();


                Demonstrativo demonstrativo = folha.GerarDemonstrativo(int.Parse(Horas), double.Parse(Salario), double.Parse(horasExtra), double.Parse(HorasDesconto));

            Console.WriteLine($"Salario Base ({demonstrativo.HrsConvencao}hrs)                      {demonstrativo.SalarioBase}");
            Console.WriteLine($"Horas Extras ({demonstrativo.HorasExtras.QtdHoras}hrs)                       {demonstrativo.HorasExtras.ValorTotalHoras}" );
            Console.WriteLine($"Horas Descontadas ({demonstrativo.HorasDescontadas.QtdHoras}hrs)                  {demonstrativo.HorasDescontadas.ValorTotalHoras}");
            Console.WriteLine($"TotalProventos                             " + demonstrativo.TotalProventos);
            Console.WriteLine($"INSS {demonstrativo.Inss.Aliquota*100}                                    {demonstrativo.Inss.Valor}" );
            Console.WriteLine($"Irrf {demonstrativo.Irrf.Aliquota * 100}                                  {demonstrativo.Irrf.Valor}");
            Console.WriteLine("TotalDescontos                             " + demonstrativo.TotalDescontos);
            Console.WriteLine("TotalLiquido                               " + demonstrativo.TotalLiquido);
            Console.WriteLine($"Fgts {demonstrativo.Fgts.Aliquota * 100}                                    {demonstrativo.Fgts.Valor}");

            Console.WriteLine("Digite exit para sair ou next para outro demonstrativo");
            string exit = Console.ReadLine();

                if (exit.ToLower() == "exit")
                    break;
            }
        }
    }
}
