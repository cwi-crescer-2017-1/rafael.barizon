/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula1exec;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rafael.barizon
 */
public class MeuCalendarUtils implements ICalendarUtils {

    @Override
    public DiaSemana diaSemana(Date date) {
        //O método diaSemana recebe uma data e devolve o dia da semana conforme enum.
        SimpleDateFormat sp = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(sp.parse(sp.format(date)));
            int dia = cal.get(Calendar.DAY_OF_WEEK)-1;
            return DiaSemana.values()[dia];
        } catch (ParseException ex) {
            System.out.println("Nao foi possivel fazer parse da data");
            return null;
        }
        
    }

    @Override
    public String tempoDecorrido(Date date) {
        //O método tempoDecorrido recebe uma data e devolve o tempo decorrido até a 
        //data atual no formato 30 ano(s), 3 messe(s) e 12 dia(s)
        int qtdAno, qtdDia, qtdMes;
        
        Date atual = new Date();
        
        long diff = Math.abs(atual.getTime() - date.getTime());
        long diffDays = diff / (24 * 60 * 60 * 1000);
        
        qtdAno = (int)diffDays / 365;
        diffDays = diffDays-(qtdAno*365);
        qtdMes = (int)diffDays / 30;
        diffDays = diffDays-(qtdMes*30);
        qtdDia = (int)diffDays ;

        return qtdAno + " ano(s), "+ qtdMes +" mes(es) e " + qtdDia + " dia(s)";
    }
    
}
