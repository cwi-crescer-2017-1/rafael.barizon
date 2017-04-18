
/**
 * Write a description of class Batalha here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Batalha
{
    private Double dano = 10.0;
    private Saint saintOne;
    private Saint saintTwo;
    private Armadura armaduraSaintOne;
    private Armadura armaduraSaintTwo;
    private int order;
    
    public Batalha(Saint saintOne, Saint saintTwo){
        this.saintOne = saintOne;
        this.saintTwo = saintTwo;
    }
    
    public void iniciar(){
        this.armaduraSaintOne = saintOne.getArmadura();
        this.armaduraSaintTwo = saintTwo.getArmadura();
        
       // System.out.println(saintOne.getNome() + "(" + saintOne.getVida()+")"+ " vs. " + saintTwo.getNome()+ "(" + saintTwo.getVida()+")" + "\n");
        
        
        //while(saintOne.getVida() > 0.0 && saintTwo.getVida() > 0.0){
            try{
            if(armaduraSaintOne.getCategoria().getValor() >= armaduraSaintTwo.getCategoria().getValor()){
                saintTwo.perdeVida(this.dano);
                order = 1;
             //   System.out.println(saintOne.getNome() + " Atacou e " + saintTwo.getNome() + " agora tem " + saintTwo.getVida() + " pontos de vida\n");
            }else {
                saintOne.perdeVida(this.dano);
                order = 2;
               // System.out.println(saintTwo.getNome() + " Atacou e " + saintOne.getNome() + " agora tem " + saintOne.getVida() + " pontos de vida\n");
            }
        } catch(Exception e){
        }
        
            /*
            if(order == 1){
                while (saintOne.getVida() > 0.0 && saintTwo.getVida() > 0.0){
                    saintOne.perdeVida(dano);
                    System.out.println(saintTwo.getNome() + " Atacou e " + saintOne.getNome() + " agora tem " + saintOne.getVida() + " pontos de vida\n");
                    saintTwo.perdeVida(dano);
                    System.out.println(saintOne.getNome() + " Atacou e " + saintTwo.getNome() + " agora tem " + saintTwo.getVida() + " pontos de vida\n");
                }
                
            } else if(order == 2){
                 while (saintOne.getVida() > 0.0 && saintTwo.getVida() > 0.0){
                    saintTwo.perdeVida(dano);
                    System.out.println(saintOne.getNome() + " Atacou e " + saintTwo.getNome() + " agora tem " + saintTwo.getVida() + " pontos de vida\n");
                    saintOne.perdeVida(dano);
                    System.out.println(saintTwo.getNome() + " Atacou e " + saintOne.getNome() + " agora tem " + saintOne.getVida() + " pontos de vida\n");
                }
            }
            
            */
        //}
    }
}
