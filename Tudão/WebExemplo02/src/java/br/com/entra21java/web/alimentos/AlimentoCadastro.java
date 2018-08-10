package br.com.entra21java.web.alimentos;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Crispim Paiano dos Santos
 */

@WebServlet(urlPatterns = "/alimentos/cadastro")
public class AlimentoCadastro extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Alimentos - Cadastro</title>");
        out.println("<link rel='stylesheet' type='text/css' href='/WebExemplo02/bootstrap/css/bootstrap.css'>");
        
        out.println("<script src='/WebExemplo02/alimentos-cadastro.js'></script>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class='container-fluid'>");
        
        out.println("<form action='/WebExemplo02/alimentos/store' method='post' onsubmit='validarFomulario()'>");
        out.println("<div id='div-campo-nome' class='form-group'>");
        out.println("<label for='campo-nome'>Nome<span class='text-danger font-weight-bold'>*</span></label>");
        out.println("<input class='form-control' type='text' id='campo-nome' name='nome' required='required' onfocusout='validarCampoNome()'>");
        //required='required'
        out.println("</div>");
        out.println("<div id='div-campo-quantidade' class='form-group'>");
        out.println("<label for='campo-quantidade'>Quantidade<span class='text-danger font-weight-bold'>*</span></label>");
        out.println("<input class='form-control' type='number' id='campo-quantidade' name='quantidade' required='required' onfocusout='validarCampoQuantidade()'>");
        out.println("</div>");
        out.println("<div class='form-group'>");
        out.println("<label for='campo-preco'>Preço<span class='text-danger font-weight-bold'>*</span></label>");
        out.println("<input class='form-control' type='text' id='campo-preco' name='preco' required='required'>");
        out.println("</div>");
        out.println("<div class='form-group'>");
        out.println("<label for='campo-descricao'>Descrição</label>");
        out.println("<textarea class='form-control' id='campo-descricao' cols='30' rows='10' name='descricao'>");
        out.println("</textarea>");
        out.println("</div>");
        out.println("<input class='btn btn-sucess' type='submit' value='Cadastrar'>");
        out.println("</form>");
        
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
        
    }
    
}
