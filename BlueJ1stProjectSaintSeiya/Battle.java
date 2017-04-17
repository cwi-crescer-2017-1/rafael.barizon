
/**
 * Write a description of class Battle here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Battle
{
    private Double damage = 10.0;
    private Saint saintOne;
    private Saint saintTwo;
    private Armor armorSaintOne;
    private Armor armorSaintTwo;
    
    public Battle(Saint saintOne, Saint saintTwo){
        this.saintOne = saintOne;
        this.saintTwo = saintTwo;
    }
    
    public void Fight(){
        this.armorSaintOne = saintOne.getArmor();
        this.armorSaintTwo = saintTwo.getArmor();
        
        
        if(armorSaintOne.getCategory().getValor() >= armorSaintTwo.getCategory().getValor()){
            saintTwo.loseLifePoints(damage);
        }else saintOne.loseLifePoints(damage);
    }
}
