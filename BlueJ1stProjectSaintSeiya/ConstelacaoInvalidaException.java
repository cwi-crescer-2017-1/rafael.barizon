public class ConstelacaoInvalidaException extends Exception {
    public ConstelacaoInvalidaException(){
        super("Verifique se a constelacao é valida");
    }
    
    public ConstelacaoInvalidaException(String mensagem){
        super(mensagem);
    }

}
