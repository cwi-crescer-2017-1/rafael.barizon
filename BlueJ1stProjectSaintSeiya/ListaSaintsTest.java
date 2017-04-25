
import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ListaSaintsTest
{   
    @Test
    public void buscarSaintExistentePorNome() throws Exception{
        ListaSaints listaSaints = new ListaSaints("Atena");
        Saint seiya = new BronzeSaint("Seiya", "Pegaso");
        listaSaints.adicionar(seiya);
        assertEquals(listaSaints.buscarPorNome("Seiya"), seiya);
       // this.listaSaints.get(listaSaints.indexOf(saint));
    }
    
    @Test
    public void buscarSaintExistenteComRepeticaoDeNomes() throws Exception{
        ListaSaints listaSaints = new ListaSaints("Atena");
        Saint shiryu = new BronzeSaint("Shiryu", "Dragao");
        listaSaints.adicionar(shiryu);
        listaSaints.adicionar(shiryu);
        listaSaints.adicionar(shiryu);
        assertEquals(listaSaints.buscarPorNome("Shiryu"), shiryu);
    }
    
    
    @Test
    public void buscarSaintInexistente() throws Exception{
        ListaSaints listaSaints = new ListaSaints("Atena");
        Saint shiryu = new BronzeSaint("Shiryu", "Dragao");
        listaSaints.adicionar(shiryu);
        assertNull(listaSaints.buscarPorNome("Hallelujah"));
    
    }
    @Test
    public void buscarSaintComListaVazia(){
        assertNull(new ListaSaints("Athena").buscarPorNome("Jou"));
    }
    
    
    @Test
    public void buscarPorCategoriaListaVazia(){
        ListaSaints listaSaints = new ListaSaints("Athena");
        
        ArrayList<Saint> l2 = listaSaints.buscarPorCategoriaUtilizandoStreams(Categoria.BRONZE);
        assertEquals(new ArrayList<Saint>(), l2);
    }
    
    @Test
    public void buscarPorCategoriaInexistente() throws Exception{
        ListaSaints listaSaints = new ListaSaints();
        Saint june = new BronzeSaint("June", "Camaleão");
        listaSaints.adicionar(june);
        ArrayList<Saint> resultadoBusca = listaSaints.buscarPorCategoria(Categoria.PRATA);
        assertEquals(new ArrayList<Saint>(), resultadoBusca);
    }
    
    @Test
    public void buscarPorCategoriaExistente() throws Exception{
        ListaSaints listaSaints = new ListaSaints();
        Saint june = new BronzeSaint("June", "Camaleão");
        Saint misty = new SilverSaint("Misty", "Lagarto");
        listaSaints.adicionar(misty);
        listaSaints.adicionar(june);
        ArrayList<Saint> resultadoBusca = listaSaints.buscarPorCategoria(Categoria.BRONZE);
        assertEquals(june, resultadoBusca.get(0));
        assertEquals(1, resultadoBusca.size());
    }
    
    @Test
    public void buscarPorCategoriaComMaisDeUmExistenteNaCategoria() throws Exception{
        ListaSaints listaSaints = new ListaSaints();
        Saint june = new BronzeSaint("June", "Camaleão");
        Saint misty = new SilverSaint("Misty", "Lagarto");
        Saint shun = new BronzeSaint("June", "Andrômeda");
        listaSaints.adicionar(shun);
        listaSaints.adicionar(misty);
        listaSaints.adicionar(june);
        ArrayList<Saint> resultadoBusca = listaSaints.buscarPorCategoria(Categoria.BRONZE);
        assertEquals(shun, resultadoBusca.get(0));
        assertEquals(june, resultadoBusca.get(1));
        assertEquals(2, resultadoBusca.size());
    }
    
    @Test
    public void getSaintMaiorVidaComApenasUm() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint june = new BronzeSaint("June", "Camaleão");
        listaSaints.adicionar(june);
        assertEquals(june, listaSaints.getSaintMaiorVida());
    }

    @Test
    public void getSaintMaiorVidaComApenasTres() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint june = new BronzeSaint("June", "Camaleão");
        Saint misty = new SilverSaint("Misty", "Lagarto");
        Saint shun = new BronzeSaint("June", "Andrômeda");
        listaSaints.adicionar(shun);
        listaSaints.adicionar(misty);
        listaSaints.adicionar(june);
        shun.perdeVida(10.0);
        june.perdeVida(20.0);
        assertEquals(misty, listaSaints.getSaintMaiorVida());
    }

    @Test
    public void getSaintMaiorVidaComListaVazia() {
        ListaSaints listaSaints = new ListaSaints();
        Saint maiorVida = listaSaints.getSaintMaiorVida();
        assertNull(maiorVida);
    }

    @Test
    public void getSaintMenorVidaComApenasUm() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint june = new BronzeSaint("June", "Camaleão");
        listaSaints.adicionar(june);
        assertEquals(june, listaSaints.getSaintMenorVida());
    }

    @Test
    public void getSaintMenorVidaComApenasTres() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint june = new BronzeSaint("June", "Camaleão");
        Saint misty = new SilverSaint("Misty", "Lagarto");
        Saint shun = new BronzeSaint("June", "Andrômeda");
        listaSaints.adicionar(shun);
        listaSaints.adicionar(misty);
        listaSaints.adicionar(june);
        shun.perdeVida(10.0);
        june.perdeVida(20.0);
        assertEquals(june, listaSaints.getSaintMenorVida());
    }

    @Test
    public void getSaintMenorVidaComListaVazia() {
        ListaSaints listaSaints = new ListaSaints();
        Saint menorVida = listaSaints.getSaintMenorVida();
        assertNull(menorVida);
    }
    
    @Test
    public void ordenarComListaTotalmenteDesordenada() throws Exception {
        ListaSaints listaSaints = new ListaSaints("Athena");
        Saint june = new BronzeSaint("June", "Camaleão");
        Saint misty = new SilverSaint("Misty", "Lagarto");
        Saint shun = new BronzeSaint("Shun", "Andrômeda");
        listaSaints.adicionar(shun);
        listaSaints.adicionar(misty);
        listaSaints.adicionar(june);
        shun.perdeVida(10.0);
        misty.perdeVida(20.0);
        june.perdeVida(30.0);
        listaSaints.ordenar(TipoOrdenacao.ASCENDENTE);
        ArrayList<Saint> resultado = listaSaints.getTodos();
        assertEquals(shun, resultado.get(2));
        assertEquals(misty, resultado.get(1));
        assertEquals(june, resultado.get(0));
    }
    
    
    @Test
    public void ordenarComListaTotalmenteOrdenada() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint june = new BronzeSaint("June", "Camaleão");
        Saint misty = new SilverSaint("Misty", "Lagarto");
        Saint shun = new BronzeSaint("Shun", "Andrômeda");
        listaSaints.adicionar(shun);
        listaSaints.adicionar(misty);
        listaSaints.adicionar(june);
        shun.perdeVida(30.0);
        misty.perdeVida(20.0);
        june.perdeVida(10.0);
        listaSaints.ordenar();
        ArrayList<Saint> resultado = listaSaints.getTodos();
        assertEquals(shun, resultado.get(0));
        assertEquals(misty, resultado.get(1));
        assertEquals(june, resultado.get(2));
    }

    @Test
    public void ordenarComListaVazia() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        listaSaints.ordenar();
        ArrayList<Saint> resultado = listaSaints.getTodos();
        assertEquals(new ArrayList<Saint>(), resultado);
    }

    @Test
    public void ordenarComListaApenasUm() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint shun = new BronzeSaint("Shun", "Andrômeda");
        listaSaints.adicionar(shun);
        shun.perdeVida(30.0);
        listaSaints.ordenar();
        ArrayList<Saint> resultado = listaSaints.getTodos();
        assertEquals(shun, resultado.get(0));
        assertEquals(1, resultado.size());
    }

    @Test
    public void ordenarComListaDeValoresIguais() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint june = new BronzeSaint("June", "Camaleão");
        Saint misty = new SilverSaint("Misty", "Lagarto");
        Saint shun = new BronzeSaint("Shun", "Andrômeda");
        listaSaints.adicionar(shun);
        listaSaints.adicionar(misty);
        listaSaints.adicionar(june);
        listaSaints.ordenar();
        ArrayList<Saint> resultado = listaSaints.getTodos();
        assertEquals(shun, resultado.get(0));
        assertEquals(misty, resultado.get(1));
        assertEquals(june, resultado.get(2));
    }

    // TipoOrdenacao.ASCENDENTE

    @Test
    public void ordenarTipoOrdenacaoComListaTotalmenteDesordenada() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint june = new BronzeSaint("June", "Camaleão");
        Saint misty = new SilverSaint("Misty", "Lagarto");
        Saint shun = new BronzeSaint("Shun", "Andrômeda");
        listaSaints.adicionar(shun);
        listaSaints.adicionar(misty);
        listaSaints.adicionar(june);
        shun.perdeVida(10.0);
        misty.perdeVida(20.0);
        june.perdeVida(30.0);
        listaSaints.ordenar(TipoOrdenacao.ASCENDENTE);
        ArrayList<Saint> resultado = listaSaints.getTodos();
        assertEquals(june, resultado.get(0));
        assertEquals(misty, resultado.get(1));
        assertEquals(shun, resultado.get(2));
    }

    @Test
    public void ordenarTipoOrdenacaoComListaTotalmenteOrdenada() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint june = new BronzeSaint("June", "Camaleão");
        Saint misty = new SilverSaint("Misty", "Lagarto");
        Saint shun = new BronzeSaint("Shun", "Andrômeda");
        listaSaints.adicionar(shun);
        listaSaints.adicionar(misty);
        listaSaints.adicionar(june);
        shun.perdeVida(30.0);
        misty.perdeVida(20.0);
        june.perdeVida(10.0);
        listaSaints.ordenar(TipoOrdenacao.ASCENDENTE);
        ArrayList<Saint> resultado = listaSaints.getTodos();
        assertEquals(shun, resultado.get(0));
        assertEquals(misty, resultado.get(1));
        assertEquals(june, resultado.get(2));
    }

    @Test
    public void ordenarTipoOrdenacaoComListaVazia() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        listaSaints.ordenar(TipoOrdenacao.ASCENDENTE);
        ArrayList<Saint> resultado = listaSaints.getTodos();
        assertEquals(new ArrayList<Saint>(), resultado);
    }

    @Test
    public void ordenarTipoOrdenacaoComListaApenasUm() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint shun = new BronzeSaint("Shun", "Andrômeda");
        listaSaints.adicionar(shun);
        shun.perdeVida(30.0);
        listaSaints.ordenar(TipoOrdenacao.ASCENDENTE);
        ArrayList<Saint> resultado = listaSaints.getTodos();
        assertEquals(shun, resultado.get(0));
        assertEquals(1, resultado.size());
    }

    @Test
    public void ordenarTipoOrdenacaoComListaDeValoresIguais() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint june = new BronzeSaint("June", "Camaleão");
        Saint misty = new SilverSaint("Misty", "Lagarto");
        Saint shun = new BronzeSaint("Shun", "Andrômeda");
        listaSaints.adicionar(shun);
        listaSaints.adicionar(misty);
        listaSaints.adicionar(june);
        listaSaints.ordenar(TipoOrdenacao.ASCENDENTE);
        ArrayList<Saint> resultado = listaSaints.getTodos();
        assertEquals(shun, resultado.get(0));
        assertEquals(misty, resultado.get(1));
        assertEquals(june, resultado.get(2));
    }

    // TipoOrdenacao.DESCENDENTE

    @Test
    public void ordenarTipoOrdenacaoDescendenteComListaTotalmenteDesordenada() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint june = new BronzeSaint("June", "Camaleão");
        Saint misty = new SilverSaint("Misty", "Lagarto");
        Saint shun = new BronzeSaint("Shun", "Andrômeda");
        listaSaints.adicionar(shun);
        listaSaints.adicionar(misty);
        listaSaints.adicionar(june);
        shun.perdeVida(10.0);
        misty.perdeVida(20.0);
        june.perdeVida(30.0);
        listaSaints.ordenar(TipoOrdenacao.DESCENDENTE);
        ArrayList<Saint> resultado = listaSaints.getTodos();
        assertEquals(shun, resultado.get(0));
        assertEquals(misty, resultado.get(1));
        assertEquals(june, resultado.get(2));
    }

    @Test
    public void ordenarTipoOrdenacaoDescendenteComListaTotalmenteOrdenada() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint june = new BronzeSaint("June", "Camaleão");
        Saint misty = new SilverSaint("Misty", "Lagarto");
        Saint shun = new BronzeSaint("Shun", "Andrômeda");
        listaSaints.adicionar(shun);
        listaSaints.adicionar(misty);
        listaSaints.adicionar(june);
        shun.perdeVida(30.0);
        misty.perdeVida(20.0);
        june.perdeVida(10.0);
        listaSaints.ordenar(TipoOrdenacao.DESCENDENTE);
        ArrayList<Saint> resultado = listaSaints.getTodos();
        assertEquals(june, resultado.get(0));
        assertEquals(misty, resultado.get(1));
        assertEquals(shun, resultado.get(2));
    }

    @Test
    public void ordenarTipoOrdenacaoDescendenteComListaVazia() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        listaSaints.ordenar(TipoOrdenacao.DESCENDENTE);
        ArrayList<Saint> resultado = listaSaints.getTodos();
        assertEquals(new ArrayList<Saint>(), resultado);
    }

    @Test
    public void ordenarTipoOrdenacaoDescendenteComListaApenasUm() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint shun = new BronzeSaint("Shun", "Andrômeda");
        listaSaints.adicionar(shun);
        shun.perdeVida(30.0);
        listaSaints.ordenar(TipoOrdenacao.DESCENDENTE);
        ArrayList<Saint> resultado = listaSaints.getTodos();
        assertEquals(shun, resultado.get(0));
        assertEquals(1, resultado.size());
    }

    @Test
    public void ordenarTipoOrdenacaoDescendenteComListaDeValoresIguais() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint june = new BronzeSaint("June", "Camaleão");
        Saint misty = new SilverSaint("Misty", "Lagarto");
        Saint shun = new BronzeSaint("Shun", "Andrômeda");
        listaSaints.adicionar(shun);
        listaSaints.adicionar(misty);
        listaSaints.adicionar(june);
        listaSaints.ordenar(TipoOrdenacao.DESCENDENTE);
        ArrayList<Saint> resultado = listaSaints.getTodos();
        assertEquals(shun, resultado.get(0));
        assertEquals(misty, resultado.get(1));
        assertEquals(june, resultado.get(2));
    }
    
    @Test
    public void unirDuasListasComUmSaintCada() throws Exception{
        ListaSaints listaSaints = new ListaSaints("Retorno");
        ListaSaints listaSaints2 = new ListaSaints("Lista2");
        ListaSaints listaSaintsRetorno = new ListaSaints("Retorno");
        Saint june = new BronzeSaint("June", "Camaleão");
        Saint june2 = new BronzeSaint("June2", "Camaleão");
        listaSaints.adicionar(june);
        listaSaints2.adicionar(june2);
        listaSaintsRetorno = listaSaints.unir(listaSaints2.getTodos());
        listaSaints.adicionar(june2);
        assertEquals(listaSaintsRetorno.getTodos(), listaSaints.getTodos() );
    }
    
    @Test
    public void intersecDuasListasComUmSaintIgual() throws Exception{
        ListaSaints listaSaints = new ListaSaints();
        ListaSaints listaSaints2 = new ListaSaints();
        ListaSaints listaSaintsRetorno = new ListaSaints();
        Saint june = new BronzeSaint("June", "Camaleão");
        //Saint june2 = new Saint("June", "Camaleão); nao criei novo equals entao vai da erro no teste se nao adicionar o june mesmo na lista 2...
        Saint june3 = new BronzeSaint("June2", "Camaleão");
        listaSaints.adicionar(june);
        listaSaints.adicionar(june3);
        listaSaints2.adicionar(june);
        listaSaintsRetorno = listaSaints.intersec(listaSaints2.getTodos());
        //listaSaints.adicionar(june2);
        assertEquals(listaSaintsRetorno.getTodos(), listaSaints2.getTodos());
    }
    
     @Test
    public void getCSVComListaVazia() throws Exception {
        ListaSaints lista = new ListaSaints();
        assertEquals("", lista.getCSV());
    }

    @Test
    public void getCSVComApenasUmSaint() throws Exception {
        ListaSaints lista = new ListaSaints();
        Saint june = new BronzeSaint("June", "Camaleão");
        june.setGenero(Genero.FEMININO);
        june.perdeVida(15.5);
        lista.adicionar(june);
        String esperado = "June,84.5,Camaleão,BRONZE,VIVO,FEMININO,false";
        assertEquals(esperado, lista.getCSV());
    }

    @Test
    public void getCSVComApenasDoisSaints() throws Exception {
        ListaSaints lista = new ListaSaints();
        Saint june = new BronzeSaint("June", "Camaleão");
        june.setGenero(Genero.FEMININO);
        june.perdeVida(15.5);
        lista.adicionar(june);
        Saint dohko = new GoldSaint("Dohko", "Touro");
        dohko.perdeVida(90.0);
        dohko.vestirArmadura();
        lista.adicionar(dohko);
        String separador = System.getProperty("line.separator");
        String esperado = "June,84.5,Camaleão,BRONZE,VIVO,FEMININO,false"+separador+"Dohko,10.0,Touro,OURO,VIVO,NAO_INFORMADO,true";
        
        assertEquals(esperado, lista.getCSV());
    }
    
}
