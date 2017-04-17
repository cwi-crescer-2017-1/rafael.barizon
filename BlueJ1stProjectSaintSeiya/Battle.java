
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
    private Armadura armaduraSaintOne;
    private Armadura armaduraSaintTwo;
    private int order;
    
    public Battle(Saint saintOne, Saint saintTwo){
        this.saintOne = saintOne;
        this.saintTwo = saintTwo;
    }
    
    public void Fight(){
        this.armaduraSaintOne = saintOne.getArmadura();
        this.armaduraSaintTwo = saintTwo.getArmadura();
        
        System.out.println(saintOne.getNome() + "(" + saintOne.getVida()+")"+ " vs. " + saintTwo.getNome()+ "(" + saintTwo.getVida()+")" + "\n");
        
        
        //while(saintOne.getVida() > 0.0 && saintTwo.getVida() > 0.0){
            if(armaduraSaintOne.getCategoria().getValor() >= armaduraSaintTwo.getCategoria().getValor()){
                saintTwo.perdeVida(damage);
                order = 1;
                System.out.println(saintOne.getNome() + " Atacou e " + saintTwo.getNome() + " agora tem " + saintTwo.getVida() + " pontos de vida\n");
            }else {
                saintOne.perdeVida(damage);
                order = 2;
                System.out.println(saintTwo.getNome() + " Atacou e " + saintOne.getNome() + " agora tem " + saintOne.getVida() + " pontos de vida\n");
            }
            
            if(order == 1){
                while (saintOne.getVida() > 0.0 && saintTwo.getVida() > 0.0){
                    saintOne.perdeVida(damage);
                    System.out.println(saintTwo.getNome() + " Atacou e " + saintOne.getNome() + " agora tem " + saintOne.getVida() + " pontos de vida\n");
                    saintTwo.perdeVida(damage);
                    System.out.println(saintOne.getNome() + " Atacou e " + saintTwo.getNome() + " agora tem " + saintTwo.getVida() + " pontos de vida\n");
                }
                
            } else if(order == 2){
                 while (saintOne.getVida() > 0.0 && saintTwo.getVida() > 0.0){
                    saintTwo.perdeVida(damage);
                    System.out.println(saintOne.getNome() + " Atacou e " + saintTwo.getNome() + " agora tem " + saintTwo.getVida() + " pontos de vida\n");
                    saintOne.perdeVida(damage);
                    System.out.println(saintTwo.getNome() + " Atacou e " + saintOne.getNome() + " agora tem " + saintOne.getVida() + " pontos de vida\n");
                }
            }
            
            
            
            if (saintOne.getVida() == 0.0) {
                saintOne.setStatus(Status.MORTO);
                System.out.println("Saint " + saintOne.getNome() + " morreu\n");
            }else{     
                saintTwo.setStatus(Status.MORTO);
                System.out.println("Saint " + saintTwo.getNome() + " morreu\n");
            }
        //}
    }
}
