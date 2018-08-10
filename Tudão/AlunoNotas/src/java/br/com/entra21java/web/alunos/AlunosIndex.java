/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.entra21java.web.alunos;

import br.com.entra21.bean.AlunosBean;
import br.com.entra21.dao.AlunoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alunos
 */
@WebServlet(urlPatterns = "/alunos")
public class AlunosIndex extends HttpServlet{
 
    private PrintWriter out;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        List<AlunosBean> alunos = new AlunoDAO().obterTodos();
        out = resp.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Alimentos - Lista</title>");
        out.println("<body>");
        out.println("<div class='container-fluid'>");

        out.println("<div class='row'>");
        out.println("<div class='col-md-12'>");
        out.println("<h3 class='text-center'>Alunos</h3>");

        out.println("</div>");
        out.println("</div>");

        out.println("<div class='row'>");
        out.println("<div class='col-md-2 offset-md-10'>");

        out.println("<a href='/AlunoNotas/alunos/cadastro' class='btn btn-primary float-right'><i class='fa fa-user'> Adicionar Aluno</i></a>");

        out.println("</div>");
        out.println("</div>");

                gerarTabela(alunos);

        out.println("</div>");
        out.println("</body>");
        out.println("</html>");

    }
    
    private void gerarTabela(List<AlunosBean> alunos){
        out.println("<div>");
        out.println("<div>");

        out.println("<table >");
        out.println("<thead>");
        out.println("<tr >");
        out.println("<th>ID</th>");
        out.println("<th>Nome</th>");
        out.println("<th>Código Mátricula</th>");
        out.println("<th>Nota 1</th>");
        out.println("<th>Nota 2</th>");
        out.println("<th>Nota 3</th>");
        out.println("<th>Frequência</th>");
        out.println("<th>Condição</th>");
        out.println("<th>Ação</th>");
        out.println("</tr>");
        out.println("</thead>");
        out.println("<tbody>");

        for(AlunosBean aluno: alunos){
            out.println("<tr>");
            out.println("<td>"+aluno.getId()+"</td>");
            out.println("<td>"+aluno.getNome()+"</td>");
            out.println("<td>"+aluno.getCodMatricula()+"</td>");
            out.println("<td>"+aluno.getNota1()+"</td>");
            out.println("<td>"+aluno.getNota2()+"</td>");
            out.println("<td>"+aluno.getNota3()+"</td>");
            out.println("<td>"+aluno.getFrequencia()+"</td>");
            out.println("<td>"+aluno.getCondicao()+"</td>"); //CONDIÇÂO DO ALUNO

            out.println("<td>");

            out.println("<a href='/AlunoNotas/alunos/editar?id="+aluno.getId()+"'>Editar</a>");
            out.println("<a href='/AlunoNotas/alunos/excluir?id="+aluno.getId()+"'>Excluir</a>");

            out.println("</td>");
            out.println("</tr>");
        }

        out.println("</tbody>");
        out.println("<tfoot>");
        out.println("<tr>");
        out.println("<th>ID</th>");
        out.println("<th>Nome</th>");
        out.println("<th>Código Mátricula</th>");
        out.println("<th>Nota 1</th>");
        out.println("<th>Nota 2</th>");
        out.println("<th>Nota 3</th>");
        out.println("<th>Frequência</th>");
        out.println("<th>Condição</th>");
        out.println("<th>Ação</th>");
        out.println("</tr>");
        out.println("</tfoot>");
        out.println("</table>");

        out.println("</div>");
        out.println("</div>");
    }
    
}
