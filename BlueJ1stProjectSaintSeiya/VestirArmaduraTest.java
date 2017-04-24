

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class VestirArmaduraTest
{
    @Test
    public void vestirArmadura() throws Exception{
        Saint hyoga = new BronzeSaint("Hyoga","Cisne");
        Movimento vestirArmadura = new VestirArmadura(hyoga);
        vestirArmadura.executar();
        assertTrue(hyoga.getArmaduraVestida());
    }
    
    @Test
    public void naoVestirArmadura() throws Exception{
        Saint shaina = new SilverSaint("Shaina", "Serpente");
        Movimento movimento = new VestirArmadura(shaina);
        assertFalse(shaina.getArmaduraVestida());
    }
    
    @Test(expected=NullPointerException.class)
    public void vestirArmaduraSaintNull() throws Exception{
        Saint shaina = null;
        Movimento movimento = new VestirArmadura(shaina);
        movimento.executar();
    }
}
