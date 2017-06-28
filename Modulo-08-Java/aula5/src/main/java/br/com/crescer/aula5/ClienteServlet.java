package br.com.crescer.aula5;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rafael.barizon
 */
public class ClienteServlet extends HttpServlet {

    String form = "<form action=\"/aula5/cliente\" method=\"POST\">\n"
            + "  <label for=\"nome\">Nome</label>\n"
            + "  <input type=\"text\" name=\"nome\" value=\"\" autofocus>\n"
            + "  <button type=\"submit\" name=\"button\">Submit</button>\n"
            + "</form>";
    
    
    ArrayList<String> nomes = new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        String nome = req.getParameter("nome");

        try (final PrintWriter out = resp.getWriter();) {
            out.append(form);
            for(String s : nomes)
            out.append(s +"<br>");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        String nome = req.getParameter("nome");
        if(nome != null){
            nomes.add(nome);
        }
        try (final PrintWriter out = res.getWriter();) {
            for(String s : nomes)
            out.append(s);
            res.sendRedirect("/aula5/cliente");
        }
        
    }

}
