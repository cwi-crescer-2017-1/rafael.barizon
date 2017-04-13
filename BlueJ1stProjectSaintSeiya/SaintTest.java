

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
       Armor scorpion = new Armor("Scorpion", Category.GOLD);
       Saint milo = new Saint("Milo", scorpion);
       //2
       milo.suitUpArmor();
       //3
       boolean result = milo.getSuited();
       assertEquals(true, result); 
   }
   
   @Test
   public void dontSuitUp(){
       Saint hyoga = new Saint("Hyoga", new Armor("Sawn", Category.SILVER));
       assertEquals(false, hyoga.getSuited());
   }
   
   @Test
   public void creatingSaintWithoutGender(){
       Saint shaka = new Saint("Shaka", new Armor("Virgo", Category.GOLD));
    }
}
