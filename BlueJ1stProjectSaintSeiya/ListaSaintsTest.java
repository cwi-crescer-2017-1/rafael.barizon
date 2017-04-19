
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
    public void buscarPorCategoriaListaVazia(){}
    
    @Test
    public void buscarPorCategoriaInexistente(){}
    
    @Test
    public void buscarPorCategoriaExistente(){}
    
    @Test
    public void buscarPorCategoriaComMaisDeUmExistente(){}
    
    
    /*@Test
    public void buscarPorCategoria(){
        ListaSaints listaSaints = new ListaSaints("Atena");
        Saint shiryu = new Saint("Shiryu", new Armadura(new Constelacao("Dragao"), Categoria.BRONZE));
        listaSaints.adicionar(shiryu);
        Saint seiya = new Saint("Seiya", new Armadura(new Constelacao("Pegaso"), Categoria.BRONZE));
        listaSaints.adicionar(seiya);
        //Saint seiya2 = new Saint("Seiya", new Armadura(new Constelacao("Pegaso"), Categoria.BRONZE));
        //listaSaints.adicionar(seiya2);
        assertEquals(listaSaints.buscarPorCategoria(Categoria.BRONZE), listaSaints);
       // this.listaSaints.get(listaSaints.indexOf(saint));
       // return;
    }
    
    /**@Test
    public void adicionarSaint(){
        return;
    }
    @Test
    public void adicionarSaint(){
        return;
    }
    @Test
    public void adicionarSaint(){
        return;
    }
    @Test
    public void adicionarSaint(){
        return;
    }
    @Test
    public void adicionarSaint(){
        return;
    }
    
buscarPorNome(String): retorna o primeiro Saint que encontrar com o mesmo nome informado no parâmetro
buscarPorCategoria(Categoria): retorna uma sub-lista de Saint que tenham armadura na categoria informada
buscarPorStatus(Status): retorna uma sub-lista de Saint que tenham o status informado por parâmetro
getSaintMaiorVida(): retorna o Saint com maior vida da lista.
getSaintMenorVida(): retorna o Saint com menor vida da lista.
ordenar(): ordena os Saints de acordo com sua vida (ascendente, do menor ao maior). Importante: esta operação APENAS ordena a lista de Saints e não a retorna.
*/
}
