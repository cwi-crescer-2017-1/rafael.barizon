public class Saint {
    private String nome;
    private Armadura armadura;
    private boolean armaduraVestida;
    private Genero genero= Genero.NAO_INFORMADO;
    private Status status = Status.VIVO;
    private Double vida = 100.0;
    protected int qtsSentidosDespertados;

    /* */
    public Saint(String nome, Armadura armadura) {
        this.nome = nome;
        this.armadura = armadura;
        
        if (this.armadura.getCategoria() == Categoria.BRONZE){
            this.qtsSentidosDespertados = 5;
        }else if (this.armadura.getCategoria() == Categoria.PRATA){
            this.qtsSentidosDespertados = 6;
        }else if(this.armadura.getCategoria() == Categoria.OURO){
            this.qtsSentidosDespertados = 7;
        }
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
    
    public void perdeVida(Double dano){
        this.vida = this.vida - dano;
        //tem necessidade de colocar o "THIS" nesse momento? eu acredito que nao mas gostaria de ter certeza.
    }
    
    public void setStatus(Status status){
        this.status = status;
    }
    
    public int getQtsSentidosDespertados(){
        return this.qtsSentidosDespertados;
    }
}