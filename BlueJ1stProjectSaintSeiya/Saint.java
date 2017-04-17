public class Saint {
    private String name;
    private Armor armor;
    private boolean suited;
    private Gender gender= Gender.NOT_INFORMED;
    private Status status = Status.ALIVE;
    private Double life = 100.0;

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
    
    public Armor getArmor(){
        return this.armor;
    }

    public void loseLifePoints(Double damage){
        this.life = this.life - damage;
        //tem necessidade de colocar o "THIS" nesse momento? eu acredito que nao mas gostaria de ter certeza.
    }
}