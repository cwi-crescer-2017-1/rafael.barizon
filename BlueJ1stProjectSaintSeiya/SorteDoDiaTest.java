
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class SorteDoDiaTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class SorteDoDiaTest
{
 
    @Test
    public void sortearTrueOrFalse(){
        SorteDoDia sorteDoDia = new SorteDoDia(new DadoD6());
        boolean resultadoBool = sorteDoDia.estouComSorte();
        int resultado = sorteDoDia.getResultado();
        if (resultado == 2 ||resultado == 4 ||resultado == 6)
            assertTrue(resultadoBool);
        else  if(resultado == 1 ||resultado == 3 ||resultado == 5)
                    assertFalse(resultadoBool);
    }
    
}
