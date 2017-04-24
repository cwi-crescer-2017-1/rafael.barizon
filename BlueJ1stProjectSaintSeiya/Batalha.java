
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
    private boolean ordemDeMovimentoDeSaints = false;
    
    public Batalha(Saint saintOne, Saint saintTwo){
        this.saintOne = saintOne;
        this.saintTwo = saintTwo;
    }
    
    public void iniciar() throws Exception{
        int prioridadeAtaqueSaintOne = saintOne.getArmadura().getCategoria().getValor();
        int prioridadeAtaqueSaintTwo = saintTwo.getArmadura().getCategoria().getValor();
        
        if(prioridadeAtaqueSaintOne >= prioridadeAtaqueSaintTwo){
            saintOne.getProximoMovimento().executar();
            ordemDeMovimentoDeSaints = false;
        }else {
            saintTwo.getProximoMovimento().executar();
            ordemDeMovimentoDeSaints = true;
        }
               
        while (saintOne.getStatus() == Status.VIVO && saintTwo.getStatus() == Status.VIVO){           
            if(ordemDeMovimentoDeSaints){
                saintOne.getProximoMovimento().executar();
                ordemDeMovimentoDeSaints = false;
            } else {
                saintTwo.getProximoMovimento().executar();
                ordemDeMovimentoDeSaints = true;
            }
        }
    }
}
