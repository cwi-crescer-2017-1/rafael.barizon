
/**
 * Enumeration class Category - write a description of the enum class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public enum Category{
    GOLDEN(3), SILVER(2), BRONZE(1);
    
    private int valor;
    private Category(int valor){
        this.valor = valor;
    }    
    
    public int getValor(){
        return this.valor;
    }
}
