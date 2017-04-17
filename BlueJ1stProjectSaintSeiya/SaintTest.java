

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
   public void suitUpArmorSetSuited(){
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
   public void creatingSaintWithoutGender(){
       Saint shaka = new Saint("Shaka", new Armadura("Virgo", Categoria.OURO));
    }
}
