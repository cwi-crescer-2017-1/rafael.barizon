import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ConstelacaoTest
{
   @Test
   public void adicionarUmGolpe() throws Exception{
       Constelacao gemeos = new Constelacao("Gemeos");
       Golpe outraDimensao = new Golpe("Outra Dimensao", 10);
       gemeos.adicionarGolpe(outraDimensao);
       Golpe[] golpes = gemeos.getGolpes();
       assertEquals(outraDimensao, golpes[0]);
   }
   
   @Test
   public void adicionarDoisGolpes() throws Exception{
       Constelacao gemeos = new Constelacao("Gemeos");
       Golpe outraDimensao = new Golpe("Outra Dimensao", 10);
       gemeos.adicionarGolpe(outraDimensao);
       Golpe[] golpes = gemeos.getGolpes();
       assertEquals(outraDimensao, golpes[0]);
       gemeos.adicionarGolpe(outraDimensao);
       assertEquals(outraDimensao, golpes[1]);
    
   }

   @Test
   public void adicionarTresGolpes() throws Exception{
       Constelacao gemeos = new Constelacao("Gemeos");
       Golpe outraDimensao = new Golpe("Outra Dimensao", 10);
       gemeos.adicionarGolpe(outraDimensao);
       Golpe[] golpes = gemeos.getGolpes();
       assertEquals(outraDimensao, golpes[0]);
       gemeos.adicionarGolpe(outraDimensao);
       assertEquals(outraDimensao, golpes[1]);
       gemeos.adicionarGolpe(outraDimensao);
       assertEquals(outraDimensao, golpes[2]);
   }
   
   @Test (expected = Exception.class)
   public void adicionarQuatroGolpes() throws Exception{
       Constelacao gemeos = new Constelacao("Gemeos");
       Golpe outraDimensao = new Golpe("Outra Dimensao", 10);
       gemeos.adicionarGolpe(outraDimensao);
       Golpe[] golpes = gemeos.getGolpes();
       gemeos.adicionarGolpe(outraDimensao);
       gemeos.adicionarGolpe(outraDimensao);
       gemeos.adicionarGolpe(outraDimensao);
       
   }
}
