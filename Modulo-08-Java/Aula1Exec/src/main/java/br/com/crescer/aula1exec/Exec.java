/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula1exec;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

/**
 *
 * @author rafael.barizon
 */
public class Exec {
    public static void main(String[] args) {
        MeuCalendarUtils meuCalUtil = new MeuCalendarUtils();
        
        Date date = new Date();
        String diaSem = meuCalUtil.diaSemana(date).toString();
        System.out.println("Dia da semana eh da data: " + date + " eh: " + diaSem);
        
        Date outra = new Date(2015-1900, 2, 20);
        System.out.println("Diferenca entre data de hj e data passada eh: "+meuCalUtil.tempoDecorrido(outra));
        
        MeuParcelator meuParc = new MeuParcelator();
        
        Map<String, BigDecimal> meuMap = meuParc.calcular(BigDecimal.valueOf(1000), 10, 0.1, date);
        
        
        ArrayList<String> array = new ArrayList<>();
        
        meuMap.forEach( (key, value) -> { 
            //1. 30/06/2016 - R$ 110,00
            array.add(key + " - R$ " + value ); 
        });
         
        for(int i = 0; i < array.size(); i++)
            System.out.println((i+1) +". "+array.get(i));
        //meuMap.forEach((BiConsumer<? super String, ? super BigDecimal>) m -> m.);
        //BigDecimal valorParcelar, int numeroParcelas, double taxaJuros, Date dataPrimeiroVencimento
        
        
//        Iterator<Map.Entry<String, BigDecimal>> iter = meuMap.entrySet().iterator();
//		if( iter != null ) {
//			while( iter.hasNext() ) {
//				Map.Entry<String, BigDecimal> entry = iter.next();
//				System.out.println( "Key: " + entry.getKey() + "\t" + " Value: " + entry.getValue() );
//			}
//		}
    
        MeuStringUtils meuString = new MeuStringUtils();
        
        String string = "A sogra má e amargosa";
        
        System.out.println(meuString.isPalindromo(string));
    
    }
    
}
