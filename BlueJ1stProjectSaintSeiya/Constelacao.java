public class Constelacao
{
    private String nome;
    private Golpe[] golpes = new Golpe[3];
    private int ultimoGolpe = 0;
    
    public Constelacao(String nome){
        this.nome = nome;
    }
    
    public void adicionarGolpe(Golpe golpe) throws Exception{
        if(ultimoGolpe<3){
            this.golpes[ultimoGolpe] = golpe;
            this.ultimoGolpe++;
        }else throw new Exception("Numero maximo de golpes atingido\n");
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
