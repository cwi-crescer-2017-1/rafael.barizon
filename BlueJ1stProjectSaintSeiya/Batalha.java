
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
    private boolean order = false;
    
    public Batalha(Saint saintOne, Saint saintTwo){
        this.saintOne = saintOne;
        this.saintTwo = saintTwo;
    }
    
    public void iniciar() throws Exception{
        this.armaduraSaintOne = saintOne.getArmadura();
        this.armaduraSaintTwo = saintTwo.getArmadura();
        Golpear golpearSaintTwo = new Golpear(this.saintOne, this.saintTwo);
        Golpear golpearSaintOne = new Golpear(this.saintTwo, this.saintOne);
  
        if(armaduraSaintOne.getCategoria().getValor() >= armaduraSaintTwo.getCategoria().getValor()){
            saintOne.getProximoMovimento().executar();
            order = false;
        }else {
            saintTwo.getProximoMovimento().executar();
            order = true;
        }
               
        while (saintOne.getVida() > 0.0 && saintTwo.getVida() > 0.0){           
            if(order){
                saintOne.getProximoMovimento().executar();
                order = false;
            } else {
                saintTwo.getProximoMovimento().executar();
                order = true;
            }
        }
    }
}
