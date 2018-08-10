package br.com.entra21java.web.alunos;

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
@WebServlet(urlPatterns = "/alunos/excluir")
public class AlunosExcluir extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        int id = Integer.parseInt(req.getParameter("id"));
        boolean apagou = new AlunoDAO().excluir(id);
        
        if (apagou) {
            resp.getWriter().print("Apagou com sucesso");
        } else {
            resp.getWriter().print("Não foi possível apagar");
        }
        
    }
    
}
