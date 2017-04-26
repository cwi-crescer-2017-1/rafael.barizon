public class SorteDoDia{
    private Sorteador sorteador;
    private int resultado;
    public SorteDoDia(Sorteador sorteador){
        this.sorteador = sorteador;
    }
    
    public boolean estouComSorte(){
        this.resultado = this.sorteador.sortear();
        return this.resultado % 2==0;
    }
    
    public int getResultado(){
        return this.resultado;
    }
}