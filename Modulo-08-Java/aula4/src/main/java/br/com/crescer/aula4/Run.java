package br.com.crescer.aula4;

import br.com.crescer.aula4.cliente.Cliente;
import br.com.crescer.aula4.cliente.ClienteDaoImpl;

/**
 * @author rafael.barizon
 */
public class Run {

    public static void main(String[] args) {

        final Cliente cliente = new Cliente();
        cliente.setId(2l);
        cliente.setNome("Rafael");

        new ClienteDaoImpl().insert(cliente);
        cliente.setNome("Rafael");
        new ClienteDaoImpl().update(cliente);
        new ClienteDaoImpl().delete(cliente);

    }

}
