public class Saint {
    private String name = "Seiya";
    private Armor armor;
    private boolean suited;
    /* */
    public Saint(String name, Armor armor) {
        this.name = name;
        this.armor = armor;
    }   
    
    public void suitUpArmor(){
        this.suited = true;
    }    
}