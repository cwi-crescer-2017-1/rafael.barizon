
import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ListaSaintsTest
{
    
    @Test
    public void adicionarUmSaintERetornSaintDoIndiceInformado(){
        Saint seiya = new Saint("Seiya", new Armadura(new Constelacao("Pegaso"), Categoria.BRONZE));
        ListaSaints listaSaints = new ListaSaints("Atena");
        listaSaints.adicionar(seiya);
        assertEquals(seiya, listaSaints.getIndice(0)); 
    }
    @Test
    public void adicionarDoisSaintsERetornSaintsDosIndicesInformados(){
        Saint seiya = new Saint("Seiya", new Armadura(new Constelacao("Pegaso"), Categoria.BRONZE));
        ListaSaints listaSaints = new ListaSaints("Atena");
        listaSaints.adicionar(seiya);
        Saint shiryu = new Saint("Shiryu", new Armadura(new Constelacao("Dragao"), Categoria.BRONZE));
        listaSaints.adicionar(shiryu);
        assertEquals(seiya, listaSaints.getIndice(0)); 
        assertEquals(shiryu, listaSaints.getIndice(1));
        
    }
    
    @Test
    public void retornarTodosSaints(){
        Saint seiya = new Saint("Seiya", new Armadura(new Constelacao("Pegaso"), Categoria.BRONZE));
        ListaSaints listaSaints = new ListaSaints("Atena");
        listaSaints.adicionar(seiya);
        Saint shiryu = new Saint("Shiryu", new Armadura(new Constelacao("Dragao"), Categoria.BRONZE));
        listaSaints.adicionar(shiryu);
        ArrayList<Saint> listaRetorno = new ArrayList<>();
        listaRetorno = listaSaints.getTodos();
        assertEquals(listaRetorno,listaSaints.getTodos());
    }
    @Test
    public void removerSaint(){
        Saint seiya = new Saint("Seiya", new Armadura(new Constelacao("Pegaso"), Categoria.BRONZE));
        ListaSaints listaSaints = new ListaSaints("Atena");
        listaSaints.adicionar(seiya);
        Saint shiryu = new Saint("Shiryu", new Armadura(new Constelacao("Dragao"), Categoria.BRONZE));
        listaSaints.adicionar(shiryu);
        listaSaints.removerSaint(seiya);
        assertEquals(listaSaints.getSize(),1);
      //  return;
//remover(Saint): retira o Saint informado da lista
    }
    
    @Test
    public void removerMaisDeUmSaint(){
        Saint seiya = new Saint("Seiya", new Armadura(new Constelacao("Pegaso"), Categoria.BRONZE));
        ListaSaints listaSaints = new ListaSaints("Atena");
        listaSaints.adicionar(seiya);
        Saint shiryu = new Saint("Shiryu", new Armadura(new Constelacao("Dragao"), Categoria.BRONZE));
        listaSaints.adicionar(shiryu);
        listaSaints.removerSaint(seiya);
        listaSaints.removerSaint(shiryu);
        assertEquals(listaSaints.getSize(),0);
      //  return;
//remover(Saint): retira o Saint informado da lista
    }
    @Test
    public void buscarPorNome(){
        ListaSaints listaSaints = new ListaSaints("Atena");
        Saint shiryu = new Saint("Shiryu", new Armadura(new Constelacao("Dragao"), Categoria.BRONZE));
        listaSaints.adicionar(shiryu);
        Saint seiya = new Saint("Seiya", new Armadura(new Constelacao("Pegaso"), Categoria.BRONZE));
        listaSaints.adicionar(seiya);
        //Saint seiya2 = new Saint("Seiya", new Armadura(new Constelacao("Pegaso"), Categoria.BRONZE));
        //listaSaints.adicionar(seiya2);
        assertEquals(listaSaints.getIndice(1), seiya);
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
