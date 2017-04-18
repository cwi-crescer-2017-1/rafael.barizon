import java.util.ArrayList;
public class ListaSaints
{
    private ArrayList<Saint> listaSaints = new ArrayList<>();
    public ListaSaints(){
    }
    
    public void adicionar(Saint saint){
        this.listaSaints.add(saint);
    }
    
    public Saint getIndice(int indice){
        return this.listaSaints.get(indice);
    }
    
    public ArrayList<Saint> getTodos(){
        return this.listaSaints;
    }
        
    public void removerSaint(Saint saint){
        this.listaSaints.remove(saint);
    }
/**
 Crie uma classe ListaSaints que será responsável por manter um cadastro atualizados dos Saints de Atena, 
 para que ela possa se organizar para a Guerra Santa. 
 Nesta classe, implemente as seguintes operações:

buscarPorNome(String): retorna o primeiro Saint que encontrar com o mesmo nome informado no parâmetro
buscarPorCategoria(Categoria): retorna uma sub-lista de Saint que tenham armadura na categoria informada
buscarPorStatus(Status): retorna uma sub-lista de Saint que tenham o status informado por parâmetro
getSaintMaiorVida(): retorna o Saint com maior vida da lista.
getSaintMenorVida(): retorna o Saint com menor vida da lista.
ordenar(): ordena os Saints de acordo com sua vida (ascendente, do menor ao maior). 
Importante: esta operação APENAS ordena a lista de Saints e não a retorna.
 */
}
