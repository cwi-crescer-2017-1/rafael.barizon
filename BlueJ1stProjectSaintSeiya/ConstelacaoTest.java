import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class ConstelacaoTest
{
   
   @Test
   public void adicionarUmGolpe() throws Exception{
       Constelacao gemeos = new Constelacao("Gemeos");
       Golpe outraDimensao = new Golpe("Outra Dimensao", 10);
       gemeos.adicionarGolpe(outraDimensao);
       ArrayList<Golpe> golpesList = new ArrayList<>();
       golpesList = gemeos.getGolpes();
       assertEquals(outraDimensao, golpesList.get(0));
   }
   
   @Test
   public void adicionarDoisGolpes() throws Exception{
       Constelacao gemeos = new Constelacao("Gemeos");
       Golpe outraDimensao = new Golpe("Outra Dimensao", 10);
       gemeos.adicionarGolpe(outraDimensao);
       ArrayList<Golpe> golpesList = new ArrayList<>();
       golpesList = gemeos.getGolpes();
       assertEquals(outraDimensao, golpesList.get(0));
       gemeos.adicionarGolpe(outraDimensao);
       assertEquals(outraDimensao, golpesList.get(1));
    
   }

   @Test
   public void adicionarTresGolpes() throws Exception{
       Constelacao gemeos = new Constelacao("Gemeos");
       Golpe outraDimensao = new Golpe("Outra Dimensao", 10);
       gemeos.adicionarGolpe(outraDimensao);
       ArrayList<Golpe> golpesList = new ArrayList<>();
       golpesList = gemeos.getGolpes();
       assertEquals(outraDimensao, golpesList.get(0));
       gemeos.adicionarGolpe(outraDimensao);
       assertEquals(outraDimensao, golpesList.get(1));
       gemeos.adicionarGolpe(outraDimensao);
       assertEquals(outraDimensao, golpesList.get(2));
   }
   
   
}
