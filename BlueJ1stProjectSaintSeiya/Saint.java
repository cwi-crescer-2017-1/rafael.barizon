public class Saint {
    private String name;
    private Armor armor;
    private boolean suited;
    private Gender gender= Gender.NA;
    /* */
    public Saint(String name, Armor armor) {
        this.name = name;
        this.armor = armor;
    }   
    
    public void suitUpArmor(){
        this.suited = true;
    }    
    
    public boolean getSuited(){
        return this.suited;
    }    
    
    public Gender getGender(){
        return this.gender;
    }
    
    public void setGender(Gender gender){
        this.gender = gender;
    }
}