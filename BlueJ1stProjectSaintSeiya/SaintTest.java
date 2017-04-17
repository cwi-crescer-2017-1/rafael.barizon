

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class SaintTest.
 *
 * @author  (Rafael Kuntzer Barizon)
 * @version (13-04-17)
 */
public class SaintTest{
   @Test
   public void vestirArmaduraDeixaArmaduraVestida(){
       /** 
        * AAA
        * 1 - Arrange  - Build up data test
        * 2 - Act - Invoke action to be tested
        * 3 - Assert - Verification of the test results
        */
       
       //1
       Armadura scorpion = new Armadura("Scorpion", Categoria.OURO);
       Saint milo = new Saint("Milo", scorpion);
       //2
       milo.vestirArmadura();
       //3
       boolean result = milo.getArmaduraVestida();
       assertEquals(true, result); 
   }
   
   @Test
   public void naoVistaArmadura(){
       Saint hyoga = new Saint("Hyoga", new Armadura("Sawn", Categoria.PRATA));
       assertEquals(false, hyoga.getArmaduraVestida());
   }
   
   @Test
   public void CriandoSaintSemGenero(){
       Saint shaka = new Saint("Shaka", new Armadura("Virgo", Categoria.OURO));
    }
   /** ADICIONAR OUTROS TESTES NESSA PARTE - Do que era o tema do modulo 1 */ 
   @Test
   public void criarSaintNasceCom5SentidosDespertados(){
    Saint seiya = new Saint("Seiya", new Armadura("Pegaso", Categoria.BRONZE));
    assertEquals(5,seiya.getQtsSentidosDespertados());
    }
    
   @Test
   public void criarSaintNasceCom6SentidosDespertados(){
    Saint marin = new Saint("Marin", new Armadura("Aguia", Categoria.PRATA));
    assertEquals(6,marin.getQtsSentidosDespertados());
    }
   
   @Test
   public void criarSaintNasceCom7SentidosDespertados(){
    Saint afrodite = new Saint("Afrodite", new Armadura("Peixes", Categoria.OURO));
    assertEquals(7,afrodite.getQtsSentidosDespertados());
    }
}
