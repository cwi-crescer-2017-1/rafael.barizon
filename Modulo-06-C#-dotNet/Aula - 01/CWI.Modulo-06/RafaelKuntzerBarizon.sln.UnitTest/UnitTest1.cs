using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using CWI.Modulo_06.Demonstrativo;

namespace RafaelKuntzerBarizon.sln.UnitTest
{
    [TestClass]
    public class FolhaDePagamentoUnitTest
    {
        [TestMethod]
        public void TestFolhaDePagamento()
        {
            FolhaDePagamento folha = new FolhaDePagamento();

            Demonstrativo demonstrativo = folha.GerarDemonstrativo(200, 5000, 50, 10);

            Assert.AreEqual(1250, demonstrativo.HorasExtras.ValorTotalHoras);
            Assert.AreEqual(250, demonstrativo.HorasDescontadas.ValorTotalHoras);
            Assert.AreEqual(6000, demonstrativo.TotalProventos);
            Assert.AreEqual(2085, demonstrativo.TotalDescontos);
            Assert.AreEqual(3915, demonstrativo.TotalLiquido);
            Assert.AreEqual(660, demonstrativo.Fgts.Valor);

        }
    }
}
