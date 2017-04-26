import java.util.Random;

public class AtaqueDuplo implements Movimento{
    private Saint golpeador, golpeado;
    
    
    
    /**
     Roll The Dice
O golpeador tem 33.3% de chance de desferir um ataque com o dobro do dano (que deve seguir as regras normais de dano, já implementadas previamente).
Caso o golpeador não consiga desferir o ataque duplo (ou seja, estiver fora dos 33.3%), ele deve desferir um ataque normalmente mas perde 5% de vida. 
Quando o Saint tiver menos que 1 de vida ele morre (exemplo: 0.99 de vida já é considerado morto).
     */
    public AtaqueDuplo(Saint golpeador, Saint golpeado){
        this.golpeador = golpeador;
        this.golpeado = golpeado;
    }
    
    public void executar() throws Exception{
        this.ataqueDuplo();
    }
    
    public boolean sortear(){
        final Random random = new Random();
        final int min =1, max = 3;
        if (random.nextInt(max-min+1)+min == 1)
            return true;
        return false;
    }
    
    public void ataqueDuplo() throws Exception{
        int dano = golpeador.getProximoGolpe().getFatorDano();
        if(sortear()){
           dano *= 2; 
           this.golpeado.perdeVida((double)dano); 
        } else{
            this.golpeado.perdeVida((double)dano);
            double golpeadorPerdeVida = golpeador.getVida() * 0.05;
            this.golpeador.perdeVida(golpeadorPerdeVida);
        }
    }
}
