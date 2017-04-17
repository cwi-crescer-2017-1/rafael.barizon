
/**
 * Enumeration class Category - write a description of the enum class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public enum Categoria{
    OURO(3), PRATA(2), BRONZE(1);
    
    private int valor;
    private Categoria(int valor){
        this.valor = valor;
    }    
    
    public int getValor(){
        return this.valor;
    }
}
