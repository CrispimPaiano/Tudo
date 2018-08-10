/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.entra21java.web.alunos;

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
@WebServlet(urlPatterns = "/alunos/cadastro")
public class AlunosCadastro extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Alunos - Cadastro</title>");
        out.println("<body>");
        out.println("<div >");

        out.println("<form action='/AlunoNotas/alunos/store' method='post''>");
        out.println("<div>");
        out.println("<label for='campo-nome'>Nome<span class='text-danger font-weight-bold'>*</span></label>");
        out.println("<input type='text' id='campo-nome' name='nome' required='required'>");
        out.println("</div>");
        out.println("<div id='div-campo-codigo-matricula' class='form-group'>");
        out.println("<label for='campo-quantidade'>Codigo de Mátricula<span class='text-danger font-weight-bold'>*</span></label>");
        out.println("<input type='text' id='campo-codigo-matricula' name='matricula' required='required'>");
        out.println("</div>");
        out.println("<div>");
        out.println("<label for='campo-nota-1'>Nota 1<span class='text-danger font-weight-bold'>*</span></label>");
        out.println("<input class='form-control' type='number' id='campo-nota-1' name='nota-1' required='required'>");
        out.println("</div>");
        out.println("<div>");
        out.println("<label for='campo-nota-2'>Nota 2<span class='text-danger font-weight-bold'>*</span></label>");
        out.println("<input class='form-control' type='number' id='campo-nota-2' name='nota-2' required='required'>");
        out.println("</div>");
        out.println("<div>");
        out.println("<label for='campo-nota-3'>Nota 3<span class='text-danger font-weight-bold'>*</span></label>");
        out.println("<input class='form-control' type='number' id='campo-nota-3' name='nota-3' required='required'>");
        out.println("</div>");
        out.println("<div>");
        out.println("<label for='campo-frequencia'>Frequência<span class='text-danger font-weight-bold'>*</span></label>");
        out.println("<input class='form-control' type='text' id='campo-frequencia' name='frequencia' required='required'>");
        out.println("</div>");
        out.println("<input class='btn btn-sucess' type='submit' value='Cadastrar'>");
        out.println("</form>");

        out.println("</div>");
        out.println("</body>");
        out.println("</html>");

        
    }
    
}
