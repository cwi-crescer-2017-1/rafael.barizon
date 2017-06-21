/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula1exec;

import java.text.Normalizer;

/**
 *
 * @author rafael.barizon
 */
public class MeuStringUtils implements IStringUtils {

    @Override
    public boolean isEmpty(String string) {
        //O método isEmpty deve validar se a string está nula e vazia.
        return string == null || string.trim().isEmpty();
    }

    @Override
    public String inverter(String string) {
        //O método inverter deve inverter uma string caso a mesma não estiver vazia, exemplo - carlos > solrac
        if(!isEmpty(string)){
            return new StringBuilder(string).reverse().toString();
        }
        else 
            return "Nao foi possivel inverter";
    }

    @Override
    public int contaVogais(String string) {
        //O método contarVogais que conte o nº de vogais da String (a,e,i,o,u), exemplo - carlos > 2
        String normalizada = normalizaString(string);
        
        int vogais = 0;
        for(char ch: normalizada.toCharArray()){
            if (ch == 'a' || ch == 'e' || ch == 'i' ||  ch == 'o' || ch == 'u'){
                    vogais++;
            }
        }
        return vogais;
    }

    @Override
    public boolean isPalindromo(String string) {
        //O método isPalindromo deve identificar se a string é um palíndromo, 
        //ou seja se quando invertida ela tem os mesmos caracteres sem os espaços, 
        //acentuação e case sensitive, exemplo - "ovo", "Ame a ema", "A sogra má e amargosa")
        String strNormalizada = normalizaString(string);
        String srtInvertida = inverter(string);
        
        return strNormalizada.equals(srtInvertida);
    }

    private String normalizaString(String string) {
        return Normalizer
                .normalize(string, Normalizer.Form.NFD)
                .replaceAll("[^\\p{ASCII}]", "")
                .replaceAll("[^a-zA-Z]", "")
                .toLowerCase();
    }
    
}
