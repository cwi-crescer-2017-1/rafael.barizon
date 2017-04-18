public class Constelacao
{
    private String nome;
    private Golpe[] golpes = new Golpe[3];
    private int ultimoGolpe = 0;
    
    public Constelacao(String nome){
        this.nome = nome;
    }
    
    public void adicionarGolpe(Golpe golpe) {
        if(ultimoGolpe<10){
            this.golpes[ultimoGolpe] = golpe;
            this.ultimoGolpe++;
        }else System.out.println("Numero maximo de golpes atingido\n");
    }
    
    public Golpe[] getGolpes(){
        return this.golpes;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public int getUltimoGolpeNumero(){
        return this.ultimoGolpe;
    }
}
