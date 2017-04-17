public class Armor {
    private String armor;
    private Category category ;
    
    public Armor(String armor, Category category){
        this.armor = armor;
        this.category = category;
   }
    
   public Category getCategory(){
       return this.category;
   }
    
}    