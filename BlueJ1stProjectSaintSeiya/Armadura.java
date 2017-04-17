public class Armadura {
    private String armadura;
    private Categoria categoria ;
    
    public Armadura(String armadura, Categoria categoria){
        this.armadura = armadura;
        this.categoria = categoria;
   }
    
   public Categoria getCategoria(){
       return this.categoria;
   }
    
}    