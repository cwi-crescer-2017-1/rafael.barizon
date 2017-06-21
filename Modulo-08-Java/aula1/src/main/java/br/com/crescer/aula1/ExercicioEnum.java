package br.com.crescer.aula1;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @author cresce2017.rafael.barizon
 */
public class ExercicioEnum {
    public static void main(String[] args) {
//        String hi = "1234567890";
//        hi = new StringBuilder(hi).reverse().toString();
//        System.out.println(hi);
//        
//        String string = "HaHeù";
//        string =
//                Normalizer
//                .normalize(string, Normalizer.Form.NFD)
//                .replaceAll("[^\\p{ASCII}]", "");
//        System.out.println(string);
//        
//        String palindromo = "A ,sogra má, e amargosa";
//        palindromo = Normalizer
//                .normalize(palindromo, Normalizer.Form.NFD)
//                .replaceAll("[^\\p{ASCII}]", "")
//                .toLowerCase()
//                .replaceAll("[^a-zA-Z]", "");
//        
//       // String pal = palindromo;
//        
//        System.out.println(" Verificando se A sogra má e amargosa eh palindromo: " + palindromo + " string invertida : " + new StringBuilder(palindromo).reverse().toString());
//        System.out.println(palindromo.equals(new StringBuilder(palindromo).reverse().toString()));
//        
        
        
        
        ArrayList<String> estados = new ArrayList<String>();
        for (Estados n : Estados.values()) {
           estados.add(n.getNome());
        }
        Collections.sort(estados);
        
        StringBuffer buffer = new StringBuffer();
        buffer.append(estados.get(0));
        for ( int i = 1 ; i < estados.size(); i++){
            buffer.append(",\n" + estados.get(i));
        }
        System.out.println(buffer);
    }
}
