
import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ListaSaintsTest
{   
    @Test
    public void buscarSaintExistentePorNome() throws Exception{
        ListaSaints listaSaints = new ListaSaints("Atena");
        Saint seiya = new Saint("Seiya", new Armadura(new Constelacao("Pegaso"), Categoria.BRONZE));
        listaSaints.adicionar(seiya);
        assertEquals(listaSaints.buscarPorNome("Seiya"), seiya);
       // this.listaSaints.get(listaSaints.indexOf(saint));
    }
    
    @Test
    public void buscarSaintExistenteComRepeticaoDeNomes() throws Exception{
        ListaSaints listaSaints = new ListaSaints("Atena");
        Saint shiryu = new Saint("Shiryu", new Armadura(new Constelacao("Dragao"), Categoria.BRONZE));
        listaSaints.adicionar(shiryu);
        listaSaints.adicionar(shiryu);
        listaSaints.adicionar(shiryu);
        assertEquals(listaSaints.buscarPorNome("Shiryu"), shiryu);
    }
    
    
    @Test
    public void buscarSaintInexistente() throws Exception{
        ListaSaints listaSaints = new ListaSaints("Atena");
        Saint shiryu = new Saint("Shiryu", new Armadura(new Constelacao("Dragao"), Categoria.BRONZE));
        listaSaints.adicionar(shiryu);
        assertNull(listaSaints.buscarPorNome("Hallelujah"));
    
    }
    @Test
    public void buscarSaintComListaVazia(){
        assertNull(new ListaSaints("Athena").buscarPorNome("Jou"));
    }
    
    
    @Test
    public void buscarPorCategoriaListaVazia(){
        ListaSaints listaSaints = new ListaSaints("Athena");
        Saint shiryu = new Saint("Shiryu", new Armadura(new Constelacao("Dragao"), Categoria.BRONZE));
        
        Saint shiryu2 = new Saint("Shiryu", new Armadura(new Constelacao("Dragao"), Categoria.PRATA));
        
        Saint shiryu3 = new Saint("Shiryu", new Armadura(new Constelacao("Dragao"), Categoria.BRONZE));
        
        listaSaints.adicionar(shiryu);
        listaSaints.adicionar(shiryu2);
        listaSaints.adicionar(shiryu3);
        ArrayList<Saint> l2 = new ArrayList<>();
        l2 = listaSaints.buscarPorCategoriaUtilizandoStreams(Categoria.BRONZE);
        assertEquals(2, l2.size());
    }
    
    @Test
    public void buscarPorCategoriaInexistente(){}
    
    @Test
    public void buscarPorCategoriaExistente(){}
    
    @Test
    public void buscarPorCategoriaComMaisDeUmExistente(){}
    
    
    @Test
    public void ordenarComListaTotalmenteDesordenada() throws Exception {
        ListaSaints listaSaints = new ListaSaints("Athena");
        Saint june = new Saint("June", new Armadura(new Constelacao("Camaleão"), Categoria.BRONZE));
        Saint misty = new SilverSaint("Misty", new Armadura(new Constelacao("Lagarto"), Categoria.PRATA));
        Saint shun = new Saint("Shun", new Armadura(new Constelacao("Andrômeda"), Categoria.BRONZE));
        listaSaints.adicionar(shun);
        listaSaints.adicionar(misty);
        listaSaints.adicionar(june);
        shun.perdeVida(10.0);
        misty.perdeVida(20.0);
        june.perdeVida(30.0);
        listaSaints.ordenar(TipoOrdenacao.ASCENDENTE);
        ArrayList<Saint> resultado = listaSaints.getTodos();
        assertEquals(shun, resultado.get(2));
        assertEquals(misty, resultado.get(1));
        assertEquals(june, resultado.get(0));
    }
    
}
