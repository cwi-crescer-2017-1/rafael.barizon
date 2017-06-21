/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula1;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author rafael.barizon
 */
public class ExercicioData {
    
    public static void main(String[] args) {
        
        Date data = new Date();
        System.out.println(data);
        
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String entrada, saida;
        SimpleDateFormat sp = new SimpleDateFormat("dd/MM/yyyy");
        Date nascimento;
        try (final Scanner scanner = new Scanner(System.in)) {
            System.out.println("Informe data");
            entrada = scanner.nextLine();
            System.out.println("informe dias");
            int qtd = scanner.nextInt();
            
            nascimento = sp.parse(entrada);
            
            Calendar cal = Calendar.getInstance();
            cal.setTime(nascimento);
            cal.add(Calendar.DATE, qtd);
            
            saida = sp.format(cal.getTime());
            
            System.out.println(saida);
        } catch (Exception e) {
            //...
        }
    }
}
