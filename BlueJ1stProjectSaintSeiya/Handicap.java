import java.util.Random;
public class Handicap implements Movimento{
    private Saint golpeador, golpeado;
    
    public Handicap(Saint golpeador, Saint golpeado){
        this.golpeador = golpeador;
        this.golpeado = golpeado;
    }
    
    public boolean contraAtaque(){
        if(!golpeado.getArmaduraVestida() && golpeado.getVida() < 50.0){
            boolean naoVaiTomaDanoNoProximoGolpe = this.sortear();
            if(naoVaiTomaDanoNoProximoGolpe)
                return true;
        }
        return false;
    }
    
    /**
     Handicap

Implemente um Movimento de contra-ataque que siga a regra abaixo:

Recebe o golpeador e o golpeado no construtor.
Caso o golpeado tenha menos da metade da vida e esteja sem armadura, 
ele tem 66.6% de chance de, no próximo ataque que tentarem desferir contra ele, 
não sofrer dano e ainda aplicar um ataque simples (sem regras de categoria, etc) 
no adversário que tira 25% da vida. Altere classes caso necessário.

     */
    
    
    public void executar() throws Exception{
        if(this.contraAtaque());
            
        /**
         * FALTA ADICIONAR NOS SAINTS 1 VARIAVEL DE CONTRA ATAQUE BOOLEANA QUE VAI SER SETADA PARA TRUE CASO
         * SAINT POSSA CONTRA ATACAR NO PROX ATAQUE A SER SOFRIDO
         */
        
    }
    
    public boolean sortear(){
        final Random random = new Random();
        final int min =1, max = 3;
        boolean naoVaiTomaDanoNoProximoGolpe = random.nextInt(max-min+1)+min > 1;
        return naoVaiTomaDanoNoProximoGolpe;
    }
}