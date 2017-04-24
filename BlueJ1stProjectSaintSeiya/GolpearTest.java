import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GolpearTest
{
    @Test
    public void golpearBronzeConArmaduraVestida() throws Exception{
        Saint seiya = new BronzeSaint("Seiya","Pégaso");
        Saint shiryu = new BronzeSaint("Shiryu", "Dragão");
        shiryu.aprenderGolpe(new Golpe("Colera do Dragao",10));
        new VestirArmadura(shiryu).executar();
        Movimento golpear = new Golpear(shiryu, seiya);
        golpear.executar();
        assertEquals(seiya.getVida(), 80.0, 0.01);
        assertEquals(shiryu.getVida(), 100.0, 0.01);
    }    
    
    @Test
    public void golpearBronzeConArmaduraNaoVestida() throws Exception{
        Saint seiya = new BronzeSaint("Seiya","Pégaso");
        Saint shiryu = new BronzeSaint("Shiryu", "Dragão");
        shiryu.aprenderGolpe(new Golpe("Colera do Dragao",10));
        //new VestirArmadura(shiryu).executar();
        Movimento golpear = new Golpear(shiryu, seiya);
        golpear.executar();
        assertEquals(seiya.getVida(), 90.0, 0.01);
        assertEquals(shiryu.getVida(), 100.0, 0.01);
    }  
}
