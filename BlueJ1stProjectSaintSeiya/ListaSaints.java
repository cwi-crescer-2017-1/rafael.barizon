import java.util.ArrayList;
public class ListaSaints
{
    private ArrayList<Saint> listaSaints = new ArrayList<>();
    private String dono;
    public ListaSaints(String dono){
        this.dono = dono;
    }
    
    public int getSize(){
        return listaSaints.size();
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
    
    public Saint buscarPorNome(String saint){
        return this.listaSaints.get(listaSaints.indexOf(saint));
    }
    
    public ArrayList<Saint> buscarPorCategoria(Categoria categoria){
        ArrayList<Saint> listaSaintCategoria = new ArrayList<>();
        for( int i = 0 ; i < this.listaSaints.size() ; i++)
            if (this.listaSaints.get(i).getArmadura().getCategoria() == categoria) 
                listaSaintCategoria.add(this.listaSaints.get(i));
        return  listaSaintCategoria;      
    }
    
    public ArrayList<Saint> buscarPorStatus(Status status){
        ArrayList<Saint> listaSaintStatus = new ArrayList<>();
        for( int i = 0 ; i < this.listaSaints.size() ; i++)
            if (this.listaSaints.get(i).getStatus() == status) 
                listaSaintStatus.add(this.listaSaints.get(i));
        return  listaSaintStatus;      
    }
    
    public Saint getSaintMaiorVida() throws Exception{
        Saint saint = this.listaSaints.get(0);
        
        if(listaSaints.isEmpty()) throw new Exception ("Lista nao possui nenhum Saint");
        
        //saint = this.listaSaints.get(0);
        for(int i = 1; i < this.listaSaints.size(); i++)
            if ( saint.getVida() < this.listaSaints.get(i).getVida())
                saint = this.listaSaints.get(i);
        return saint;
    }
    
    public Saint getSaintMenorVida() throws Exception{
        Saint saint = this.listaSaints.get(0);
        
        if(listaSaints.isEmpty()) throw new Exception ("Lista nao possui nenhum Saint");
        
        for(int i = 1; i < this.listaSaints.size(); i++)
            if ( saint.getVida() > this.listaSaints.get(i).getVida())
                saint = this.listaSaints.get(i);
        
        return saint;
    }
    /** BubbleSort */
    public void ordenar(){
        Saint saint = new Saint();
        for(int i = 0; i < this.listaSaints.size(); i++){
            for(int j = 1; j < this.listaSaints.size(); j++){
                if ( this.listaSaints.get(i).getVida() > this.listaSaints.get(j).getVida()){
                    saint = this.listaSaints.get(i);
                    this.listaSaints.add(i, this.listaSaints.get(j));
                    this.listaSaints.add(j, saint);
                }
            }        
        }        
    }
/**
 Crie uma classe ListaSaints que será responsável por manter um cadastro atualizados dos Saints de Atena, 
 para que ela possa se organizar para a Guerra Santa. 
 Nesta classe, implemente as seguintes operações:
ordenar(): ordena os Saints de acordo com sua vida (ascendente, do menor ao maior). 
Importante: esta operação APENAS ordena a lista de Saints e não a retorna.
 */
}
