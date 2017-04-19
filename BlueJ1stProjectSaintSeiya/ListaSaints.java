import java.util.ArrayList;
import java.util.stream.Collectors;
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
        
        for(int i = 0 ; i< listaSaints.size() ; i++)
            if (listaSaints.get(i).getNome().equals(saint))
                return listaSaints.get(i);
        return null;
    }
    
    public ArrayList<Saint> buscarPorCategoria(Categoria categoria){
        ArrayList<Saint> listaSaintCategoria = new ArrayList<>();
        
        for( Saint saint : this.listaSaints){
            if (saint.getArmadura().getCategoria() == categoria) 
                listaSaintCategoria.add(saint);
        }
        //for( int i = 0 ; i < this.listaSaints.size() ; i++)
        //    if (this.listaSaints.get(i).getArmadura().getCategoria() == categoria) 
        //        listaSaintCategoria.add(this.listaSaints.get(i));
        return  listaSaintCategoria;      
    }
    
    public ArrayList<Saint> buscarPorCategoriaUtilizandoStreams(Categoria categoria){
        return (ArrayList<Saint>)this.listaSaints.stream()
        .filter(s -> s.getArmadura().getCategoria().equals(categoria))
        .collect(Collectors.toList());
    }
    
    public ArrayList<Saint> buscarPorStatus(Status status){
        
        return  (ArrayList<Saint>)this.listaSaints.stream()
        .filter(s -> s.getStatus().equals(status))
        .collect(Collectors.toList());      
    }
    
    public Saint getSaintMaiorVida(){
        
        
        if(listaSaints.isEmpty()) return null;
        Saint saint = this.listaSaints.get(0);
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
        for(int i = 0; i < this.listaSaints.size()-1; i++){
            for(int j = 1; j < this.listaSaints.size(); j++){
                if ( this.listaSaints.get(i).getVida() > this.listaSaints.get(j).getVida()){
                    saint = this.listaSaints.get(i);
                    this.listaSaints.set(i, this.listaSaints.get(j));
                    this.listaSaints.set(j, saint);
                }
            }        
        }        
    }
    
    public void ordenar(TipoOrdenacao tipoOrdenacao){
        boolean posicoesSendoTrocadas;
        boolean tipoOrdem=false;
        if(tipoOrdenacao== TipoOrdenacao.DESCENDENTE) tipoOrdem = true;
        do {
            posicoesSendoTrocadas = false;
            for (int i = 0; i < this.listaSaints.size() - 1; i++) {
                Saint atual = this.listaSaints.get(i);
                Saint proximo = this.listaSaints.get(i + 1);
                boolean precisaTrocar;
                if(tipoOrdem)
                    precisaTrocar = atual.getVida() < proximo.getVida();
                else precisaTrocar = atual.getVida() > proximo.getVida();
                if (precisaTrocar) {
                    this.listaSaints.set(i, proximo);
                    this.listaSaints.set(i + 1, atual);
                    posicoesSendoTrocadas = true;
                }
            }
        } while (posicoesSendoTrocadas);  
    }
    
    public void addAllList(ArrayList<Saint> outraLista){
        this.listaSaints.addAll(outraLista);
    }
    
    public ListaSaints unir(ArrayList<Saint> outraLista){
        ListaSaints listaRetorno = new ListaSaints("Retorno");
        
        listaRetorno.addAllList(listaSaints);
        listaRetorno.addAllList(outraLista);
        
        /*for(int i = 0; i<this.listaSaints.size(); i++){
            listaRetorno.adicionar(this.listaSaints.get(i));
        }
        for(int i = 0; i<outraLista.size(); i++){
            listaRetorno.adicionar(outraLista.get(i));    
        } */
        return listaRetorno;
    }
}
