import java.util.ArrayList;
import java.util.stream.Collectors;
public class ListaSaints
{
    private ArrayList<Saint> listaSaints = new ArrayList<>();
    private String dono;
    public ListaSaints(String dono){
        this.dono = dono;
    }
    public ListaSaints(){
        this.dono = "Sem dono";
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
    
    public Saint getSaintMenorVida() {
        
        
        if(listaSaints.isEmpty()) return null;
        Saint saint = this.listaSaints.get(0);
        for(int i = 1; i < this.listaSaints.size(); i++)
            if ( saint.getVida() > this.listaSaints.get(i).getVida())
                saint = this.listaSaints.get(i);
        
        return saint;
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
                // Operador TERNARIO
                //boolean precisaTrocarr = TipoOrdenacao.ASCENDENTE == tipoOrdenacao ? atual.getVida() < proximo.getVida() : atual.getVida() > proximo.getVida();
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
    
    /** BubbleSort */
    public void ordenar(){
        ordenar(TipoOrdenacao.ASCENDENTE);
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
    
    public ListaSaints diff(ArrayList<Saint> listaRef){
        ListaSaints listaRetorno = new ListaSaints("Retorno");
        /***
         * criar sem os metodos prontos
         */
        this.listaSaints.removeAll(listaRef);
        listaRetorno.addAllList(listaSaints); 
        return listaRetorno;
    }
    
    public ListaSaints intersec(ArrayList<Saint> listaRef){
        ListaSaints listaRetorno = new ListaSaints();
        
        for(Saint saint : this.listaSaints){
            for(Saint saintRef : listaRef){
                if(saint.equals(saintRef))
                    listaRetorno.adicionar(saintRef);
            }
        }
        return listaRetorno;
        /***
         * criar sem os metodos prontos
         */
        //this.listaSaints.retainAll(listaRef);
        //listaRetorno.addAllList(this.listaSaints);
       
    }
    
    public String getCSVComMetodoDoSaint(){
        String csv="";
        
        for( Saint saint : this.listaSaints){
            csv += saint.getCSV() + "\n";
        }
        
        return csv;
    }
    
     public String getCSV() {
        if (this.listaSaints.isEmpty()) {
            return "";
        }

        String separador = System.getProperty("line.separator");
        StringBuilder builder = new StringBuilder(512);

        builder.append(this.listaSaints.get(0).getCSV());
        for (int i = 1; i < this.listaSaints.size(); i++) {
            Saint saint = this.listaSaints.get(i);
            //resultado += separador + saint.getCSV();
            //builder.append(String.format("%s%s", separador, saint.getCSV()));
            builder.append(separador);
            builder.append(saint.getCSV());
        }

        return builder.toString();
    }
   /* 
    public String getCSV(){
        String csv="";
        
        if(this.listaSaints.isEmpty()) return null;
        
        for( Saint saint : this.listaSaints){
            csv +=  saint.getNome()                                 + "," + 
                    saint.getVida()                                 + "," + 
                    saint.getArmadura().getConstelacao().getNome()  + "," + 
                    saint.getArmadura().getCategoria()              + "," + 
                    saint.getStatus()                               + "," +     
                    saint.getGenero()                               + "," + 
                    saint.getArmaduraVestida()                      + "\n";
        }
        // PERCORRER O ARRAYLIST E ADICIONAR TUDO NO CSV
        //csv += ;
        
        return csv;
   
   }
   */
}
