import java.util.Random;

public class AtaqueDuplo implements Movimento{
    private Saint golpeador, golpeado;
    
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
        boolean vaiAtacarComDanoDuplo = random.nextInt(max-min+1)+min == 1;
        return vaiAtacarComDanoDuplo;
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
