/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula1exec;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rafael.barizon
 */
public class MeuParcelator implements IParcelator{

    @Override
    public Map<String, BigDecimal> calcular(BigDecimal valorParcelar, int numeroParcelas, double taxaJuros, Date dataPrimeiroVencimento) {
        /*
        O método calcular deve retornar um map com a data de vencimento (dd/MM/yyyy) da parcela e o valor (R$ .....).
            // Ex. valor: 1000  juros: 10%, parcelas: 10  data: 30/06/2016
            1. 30/06/2016 - R$ 110,00
            2. 31/07/2016 - R$ 110,00
            3. 30/08/2016 - R$ 110,00 ...
        */
        Map<String, BigDecimal> retorno = new LinkedHashMap<>();
        BigDecimal juros = valorParcelar.multiply(BigDecimal.valueOf(taxaJuros/100));
        BigDecimal total = valorParcelar.add(juros);
        BigDecimal parcela = total.divide(BigDecimal.valueOf(numeroParcelas), 2,  RoundingMode.HALF_UP);
        BigDecimal vlResto = parcela.multiply(BigDecimal.valueOf(numeroParcelas)).subtract(total);
        SimpleDateFormat sp = new SimpleDateFormat("dd/MM/yyyy");
        String data = sp.format(dataPrimeiroVencimento);
        for( int i = 0 ; i < numeroParcelas; i++){  
            retorno.put(data, parcela.subtract(vlResto));
            
            vlResto = BigDecimal.ZERO;
            
            Calendar c = Calendar.getInstance();
            try {
                c.setTime(sp.parse(data));
            } catch (ParseException ex) {
                Logger.getLogger(MeuParcelator.class.getName()).log(Level.SEVERE, null, ex);
            }
            c.add(Calendar.MONTH, 1);  // number of days to add
            data = sp.format(c.getTime()); 
        }
        
        return retorno;
    }
    
}
