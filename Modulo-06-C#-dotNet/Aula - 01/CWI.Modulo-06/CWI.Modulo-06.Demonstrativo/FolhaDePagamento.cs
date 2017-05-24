﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CWI.Modulo_06.Demonstrativo
{
    public class FolhaDePagamento : IFolhaDePagamento
    {
        public FolhaDePagamento() { }
        public Demonstrativo GerarDemonstrativo(int horasBase, double salarioBase, double horasExtras, double horasDescontadas)
        {
            //Categoria = horasBase
            //Saláriobase: 
            double valorHora = Math.Round(salarioBase / horasBase, 2);
            //Valor Hora: é o Salário - base dividido pelo número de horas estabelecido pela convenção.
            double valorTotalExtras = Math.Round(valorHora * horasExtras,2);
            HorasCalculadas HorasExtras = new HorasCalculadas(horasExtras, valorTotalExtras);
            //Horas Extras: A quantidade de horas extras realizadas pelo colaborador na Folha do Ponto que serão pagas.
            double valorTotalDescontadas = Math.Round(valorHora * horasDescontadas,2);
            HorasCalculadas HorasDescontadas = new HorasCalculadas(horasDescontadas, valorTotalDescontadas);
            //Horas Descontadas: A quantidade de horas (faltas, atrasos, etc) não justificadas pelo colaborador na Folha do Ponto que serão descontadas.
            double TotalProventos = Math.Round(salarioBase + HorasExtras.ValorTotalHoras - HorasDescontadas.ValorTotalHoras,2);
            //Total de Proventos: A soma do Salário-base + Total Horas Extras - Total Horas Descontadas.
            double impostoINSS = salarioBase <= 1500.0 ? salarioBase <=1000.0? 0.08: 0.09 : 0.1;
            //Até R$1000,00 utilize 8 %, até R$1500,00 9 % e acima disso 10 %.
            double valorINSS = Math.Round(TotalProventos * impostoINSS,2);
            //INSS: Calcule o INSS com base no Total de Proventos e aplique a alíquota conforme as faixas salariais: 
            Desconto INSS = new Desconto(impostoINSS, valorINSS);
            
            double impostoIRRF = salarioBase <= 4271.59 ? salarioBase <= 3418.59 ? salarioBase <= 2563.91 ? salarioBase <= 1710.78 ? .0 : .075 : .15 : .225 : 0.275;
            //Aplique a aliquota conforme as faixas: até R$1710.78 isento, até R$2563.91 7,5 %, até R$3418.59 15 %, até R$4271.59 22,5 % e acima disso 27,5 %.
            double valorIRRF = Math.Round((TotalProventos-valorINSS) * impostoIRRF,2);
            //Imposto de renda retido na fonte(IRRF): Considere como base cálculo o Total de Proventos deduzido o INSS. 
            Desconto IRRF = new Desconto(impostoIRRF, valorIRRF);
            
            double TotalDescontos = INSS.Valor + IRRF.Valor;
            //Total de descontos:é a soma do INSS e do IRRF.
            double SalarioLiquido = Math.Round(TotalProventos - TotalDescontos,2);
            //Salário líquido: A remuneração a ser repassada(transferida) para o colaborador.Para o cálculo some o Total de Proventos -Total de Descontos.
            double valorFGTS = Math.Round(TotalProventos * 0.11, 2);
            Desconto FGTS = new Desconto(0.11, valorFGTS);
            //FGTS: Fundo de garantia sobre tempo de serviço deve ser apenas discriminado 11 % fixo.

            return new Demonstrativo(salarioBase, horasBase, HorasExtras, HorasDescontadas, TotalProventos,
                                     INSS, IRRF, TotalDescontos, SalarioLiquido, FGTS); 
        }

    }
}
