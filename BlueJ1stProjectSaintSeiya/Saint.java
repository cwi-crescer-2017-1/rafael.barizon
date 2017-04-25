import java.util.ArrayList;
import java.security.InvalidParameterException;
public abstract class Saint {
    private String nome;
    private Armadura armadura;
    private boolean armaduraVestida;
    private Genero genero= Genero.NAO_INFORMADO;
    private Status status = Status.VIVO;
    private Double vida = 100.0;
    protected int qtdSentidosDespertados;
    private int golpeNumero = 0;
    private ArrayList<Golpe> golpesList = new ArrayList<>();
    private ArrayList<Movimento> movimentos = new ArrayList<>();
    private int movimentoNumero = 0;
    private static int qtdSaints = 0;
    private int id;

    protected Saint(String nome, Armadura armadura) {
        this.nome = nome;
        this.armadura = armadura;
        Saint.qtdSaints++;
        this.id = getQtdSaints();
    }
    
    public static int getQtdSaints(){
        return Saint.qtdSaints;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public int getId(){
        return this.id;
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
    
    public Status getStatus(){
        return this.status;
    }
    
    public int getQtdSentidosDespertados(){
        return this.qtdSentidosDespertados;
    }
    
    private Constelacao getConstelacao() {
        return this.armadura.getConstelacao();
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
    
    public String getCSV(){
        return String.format(
            "%s,%s,%s,%s,%s,%s,%s",
            this.nome,
            this.vida,
            this.getConstelacao().getNome(),
            this.armadura.getCategoria(),
            this.status,
            this.genero,
            this.armaduraVestida
        );
    }
    
    public void adicionarMovimento(Movimento movimento){
        this.movimentos.add(movimento);    
    }
    
    public Movimento getProximoMovimento(){
        int aux = this.movimentoNumero % this.movimentos.size(); 
        this.movimentoNumero++;
        return this.movimentos.get(aux);
    }
    
    public void golpear(Saint golpeado) {
         this.adicionarMovimento(new Golpear(this, golpeado));
     }
     
     
}