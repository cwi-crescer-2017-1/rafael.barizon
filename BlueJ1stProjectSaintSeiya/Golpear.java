public class Golpear implements Movimento{
    Saint golpeador;
    Saint golpeado;
    
    public Golpear(Saint golpeador, Saint golpeado) {
        this.golpeador = golpeador;
        this.golpeado = golpeado;
    }
    
    public void executar() throws Exception{
        double multiplicadorDano = 1.0;
        double dano;
        if(golpeador.getArmaduraVestida()){
            multiplicadorDano += golpeador.getArmadura().getCategoria().getValor();
        }
        Golpe golpe = golpeador.getProximoGolpe();
        dano = golpe.getFatorDano() * multiplicadorDano ;
        golpeado.perdeVida(dano);
    }
}