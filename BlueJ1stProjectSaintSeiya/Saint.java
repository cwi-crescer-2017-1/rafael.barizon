public class Saint {
    private String nome;
    private Armadura armadura;
    private boolean armaduraVestida;
    private Genero genero= Genero.NAO_INFORMADO;
    private Status status = Status.VIVO;
    private Double vida = 100.0;
    protected int qtdSentidosDespertados;

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
            throw new Exception("Parametro passado nao pode ser negativo");
        }
        if(this.vida > 1.0){
            this.vida = this.vida - dano;
            if(this.vida<1.0) setStatus(Status.MORTO);
        }
        //tem necessidade de colocar o "THIS" nesse momento? eu acredito que nao mas gostaria de ter certeza.
    }
    
    public void setStatus(Status status){
        this.status = status;
    }
    
    public Status getStatus(){
        return this.status;
    }
    
    public int getQtdSentidosDespertados(){
        return this.qtdSentidosDespertados;
    }
}