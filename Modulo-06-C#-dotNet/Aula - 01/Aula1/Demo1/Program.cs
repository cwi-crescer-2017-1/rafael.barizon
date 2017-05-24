using System;
using System.Collections.Generic;

namespace Demo1
{
    class Program
    {
        static void Main(string[] args)
        {
            List<int> entradasList = new List<int>();
            var entradasArray = new int[] { };

            Console.WriteLine("Digite numeros inteiros ou exit para sair");

            while (true)
            {
                var linhaLida = Console.ReadLine();
                if(linhaLida.ToLower() == "exit")
                {
                    break;
                }

                var nrEntradas = entradasArray.Length;

                var entradasArrayAux = new int[nrEntradas + 1];

                for (int i = 0; i < nrEntradas; i++)
                {
                    entradasArrayAux[i] = entradasArray[i];
                }

                entradasArrayAux[nrEntradas] = int.Parse(linhaLida);

                entradasArray = entradasArrayAux;
            }
            Console.WriteLine("Array Printado, formato statico");
            foreach (var entrada in entradasArray)
            {
                Console.WriteLine(entrada);
            }

            Console.WriteLine("Digite numeros ou exit para sair");

            while (true)
            {
                var linhaLida = Console.ReadLine();
                if (linhaLida.ToLower() == "exit")
                {
                    Console.WriteLine("Pritando com formato dinamico");
                    foreach (var entrada in entradasList)
                    {
                        Console.WriteLine(entrada);
                    }
                    break;
                }
                entradasList.Add(int.Parse(linhaLida));
            }



            Console.ReadKey();
        }
    }
}
