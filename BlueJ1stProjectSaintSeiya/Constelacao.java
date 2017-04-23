import java.util.ArrayList;
public class Constelacao
{
    private String nome;
    private ArrayList<Golpe> golpesList = new ArrayList<>();
    
    public Constelacao(String nome){
        this.nome = nome;
    }
    
    public void adicionarGolpe(Golpe golpe){
        golpesList.add(golpe);
    }
    
    public ArrayList<Golpe> getGolpes(){
        return this.golpesList;
    }
    
    public String getNome(){
        return this.nome;
    }
    
}
