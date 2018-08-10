package br.com.entra21java.web.alunos;

import br.com.entra21.bean.AlunosBean;
import br.com.entra21.dao.AlunoDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Crispim Paiano dos Santos
 */

@WebServlet(urlPatterns = "/alunos/store")
public class AlunosStore extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
        AlunosBean aluno = new AlunosBean();
        aluno.setNome(req.getParameter("nome"));
        aluno.setCodMatricula(req.getParameter("matricula"));
        aluno.setNota1(Float.parseFloat(req.getParameter("nota-1")));
        aluno.setNota2(Float.parseFloat(req.getParameter("nota-2")));
        aluno.setNota3(Float.parseFloat(req.getParameter("nota-3")));
        aluno.setFrequencia(Byte.parseByte(req.getParameter("frequencia")));
        
        int codigo = new AlunoDAO().adicionar(aluno);

        if(codigo > 0){
            resp.sendRedirect("/AlunoNotas/alunos");
        }
    
    }    
    
}
