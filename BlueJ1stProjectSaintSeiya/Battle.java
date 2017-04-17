
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
    private int order;
    
    public Battle(Saint saintOne, Saint saintTwo){
        this.saintOne = saintOne;
        this.saintTwo = saintTwo;
    }
    
    public void Fight(){
        this.armorSaintOne = saintOne.getArmor();
        this.armorSaintTwo = saintTwo.getArmor();
        
        System.out.println(saintOne.getName() + "(" + saintOne.getLife()+")"+ " vs. " + saintTwo.getName()+ "(" + saintTwo.getLife()+")" + "\n");
        
        
        //while(saintOne.getLife() > 0.0 && saintTwo.getLife() > 0.0){
            if(armorSaintOne.getCategory().getValor() >= armorSaintTwo.getCategory().getValor()){
                saintTwo.loseLifePoints(damage);
                order = 1;
                System.out.println(saintOne.getName() + " Attack and " + saintTwo.getName() + " now has " + saintTwo.getLife() + " life Points\n");
            }else {
                saintOne.loseLifePoints(damage);
                order = 2;
                System.out.println(saintTwo.getName() + " Attack and " + saintOne.getName() + " now has " + saintOne.getLife() + " life Points\n");
            }
            
            if(order == 1){
                while (saintOne.getLife() > 0.0 && saintTwo.getLife() > 0.0){
                    saintOne.loseLifePoints(damage);
                    System.out.println(saintTwo.getName() + " Attack and " + saintOne.getName() + " now has " + saintOne.getLife() + " life Points\n");
                    saintTwo.loseLifePoints(damage);
                    System.out.println(saintOne.getName() + " Attack and " + saintTwo.getName() + " now has " + saintTwo.getLife() + " life Points\n");
                }
                
            } else if(order == 2){
                 while (saintOne.getLife() > 0.0 && saintTwo.getLife() > 0.0){
                    saintTwo.loseLifePoints(damage);
                    System.out.println(saintOne.getName() + " Attack and " + saintTwo.getName() + " now has " + saintTwo.getLife() + " life Points\n");
                    saintOne.loseLifePoints(damage);
                    System.out.println(saintTwo.getName() + " Attack and " + saintOne.getName() + " now has " + saintOne.getLife() + " life Points\n");
                }
            }
            
            
            
            if (saintOne.getLife() == 0.0) {
                saintOne.setStatus(Status.DEAD);
                System.out.println("Saint " + saintOne.getName() + " died\n");
            }else{     
                saintTwo.setStatus(Status.DEAD);
                System.out.println("Saint " + saintTwo.getName() + " died\n");
            }
        //}
    }
}
