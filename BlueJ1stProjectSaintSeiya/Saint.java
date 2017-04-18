import java.util.ArrayList;
import java.security.InvalidParameterException;
public class Saint {
    private String nome;
    private Armadura armadura;
    private boolean armaduraVestida;
    private Genero genero= Genero.NAO_INFORMADO;
    private Status status = Status.VIVO;
    private Double vida = 100.0;
    protected int qtdSentidosDespertados;
    private int golpeNumero = 0;
    private ArrayList<Golpe> golpesList = new ArrayList<>();

    public Saint(String nome, Armadura armadura) {
        this.nome = nome;
        this.armadura = armadura;
    }   
    
    public String getNome(){
        return this.nome;
    }
    
    public void vestirArmadura(){
        this.armaduraVestida = true;
    }    
    
    public boolean getArmaduraVestida(){
        return this.armaduraVestida;
    }    
    
    public Genero getGenero(){
        return this.genero;
    }
    
    public void setGenero(Genero genero){
        this.genero = genero;
    }
    
    public Armadura getArmadura(){
        return this.armadura;
    }
    
    public Double getVida(){
        return this.vida;
    }
    
    public void perdeVida(Double dano) throws Exception{
        if(dano < 0.0) {
            throw new InvalidParameterException("Parametro passado nao pode ser negativo");
        }
        if(this.vida > 1.0){
            this.vida -= dano;
            if(this.vida<1.0) status = Status.MORTO;
        }
    }
    
   // public void setStatus(Status status){
   //     this.status = status;
   // }
    
    public Status getStatus(){
        return this.status;
    }
    
    public int getQtdSentidosDespertados(){
        return this.qtdSentidosDespertados;
    }
    
    public ArrayList<Golpe> getGolpes(){
        return this.armadura.getConstelacao().getGolpes();
    }
    
    public void aprenderGolpe(Golpe golpe)throws Exception{
        this.armadura.getConstelacao().adicionarGolpe(golpe);
    }
    
    public Golpe getProximoGolpe(){
        this.golpesList = getGolpes();
        int aux = this.golpeNumero % golpesList.size();
        this.golpeNumero++;
        return golpesList.get(aux);
    }
}