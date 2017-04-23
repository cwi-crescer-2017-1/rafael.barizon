import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class ConstelacaoTest
{
   
   @Test
   public void adicionarUmGolpe()  {
       Constelacao gemeos = new Constelacao("Gemeos");
       Golpe outraDimensao = new Golpe("Outra Dimensao", 10);
       gemeos.adicionarGolpe(outraDimensao);
       ArrayList<Golpe> golpesList = new ArrayList<>();
       golpesList = gemeos.getGolpes();
       assertEquals(outraDimensao, golpesList.get(0));
   }
   
   @Test
   public void adicionarDoisGolpes()  {
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
   public void adicionarTresGolpes() {
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
   
   @Test
    public void adicionarQuatroGolpes() {
        Constelacao gemeos = new Constelacao("Gêmeos");
        Golpe outraDimensao = new Golpe("Outra dimensão", 10);
        Golpe explosaoGalatica = new Golpe("Explosão Galáctica", 11);
        Golpe sataImperial = new Golpe("Satã Imperial", 60);
        gemeos.adicionarGolpe(outraDimensao);
        gemeos.adicionarGolpe(explosaoGalatica);
        gemeos.adicionarGolpe(sataImperial);
        gemeos.adicionarGolpe(new Golpe("Cólera do café intenso", 80));
        ArrayList<Golpe> golpes = gemeos.getGolpes();
        assertEquals(outraDimensao, golpes.get(0));
        assertEquals(explosaoGalatica, golpes.get(1));
        assertEquals(sataImperial, golpes.get(2));
        assertEquals(new Golpe("Cólera do café intenso", 80), golpes.get(3));
    }
}
