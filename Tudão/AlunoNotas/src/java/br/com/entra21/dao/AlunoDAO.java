package br.com.entra21.dao;

import br.com.entra21.bean.AlunosBean;
import br.com.entra21java.database.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Crispim Paiano dos Santos
 */
public class AlunoDAO {
    
    public List<AlunosBean> obterTodos(){
        
        List<AlunosBean> alunos = new ArrayList<>();
        String sql = "SELECT * FROM alunos";
        try {
            Statement st = Conexao.obterConexao().createStatement();
            st.execute(sql);
            ResultSet resultset = st.getResultSet();
            while (resultset.next()) {
                AlunosBean aluno = new AlunosBean();
                aluno.setId(resultset.getInt("id"));
                aluno.setNome(resultset.getString("nome"));
                aluno.setCodMatricula(resultset.getString("codigoMatricula"));
                aluno.setNota1(Float.parseFloat(resultset.getString("nota1")));
                aluno.setNota2(Float.parseFloat(resultset.getString("nota2")));
                aluno.setNota3(Float.parseFloat(resultset.getString("nota3")));
                aluno.setFrequencia(Byte.parseByte(resultset.getString("frequencia")));
                alunos.add(aluno);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.fecharConexao();
        }
        return alunos;
    }
    
    public int adicionar(AlunosBean aluno){
        
        String sql = "INSERT INTO alunos (nome, codigoMatricula, nota1, nota2, nota3, frequencia) VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            int quantidade = 1;
            ps.setString(quantidade++,aluno.getNome());
            ps.setString(quantidade++, aluno.getCodMatricula());
            ps.setFloat(quantidade++, aluno.getNota1());
            ps.setFloat(quantidade++, aluno.getNota2());
            ps.setFloat(quantidade++, aluno.getNota3());
            ps.setByte(quantidade++, aluno.getFrequencia());
            ps.execute();
            ResultSet resultSet = ps.getGeneratedKeys();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.fecharConexao();
        }return -1;
        
    }
    
    public boolean excluir(int id){
        String sql = "DELETE FROM alunos WHERE id = ?";
        try {
            PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
            ps.setInt(1, id);
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            Conexao.fecharConexao();
        }
        return false;
    }

    public AlunosBean obterPeloId(int id) {
        String sql = "SELECT * FROM alunos WHERE id= ?";
        try {
            PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            ResultSet resultSet = ps.getResultSet();
            if (resultSet.next()) {
                AlunosBean aluno = new AlunosBean();
                aluno.setId(id);
                aluno.setNome(resultSet.getString("nome"));
                aluno.setCodMatricula(resultSet.getString("codigoMatricula"));
                aluno.setNota1(resultSet.getFloat("nota1"));
                aluno.setNota2(resultSet.getFloat("nota2"));
                aluno.setNota3(resultSet.getFloat("nota3"));
                aluno.setFrequencia(resultSet.getByte("frequencia"));
                return aluno;
            }
        } catch (Exception e) {e.printStackTrace();
        } finally {
            Conexao.fecharConexao();
        }
        return  null;
    }

    public boolean alterar(AlunosBean aluno) {
        String sql = "UPDATE alunos SET nome = ?, codigoMatricula = ?, nota1 = ?, nota2 = ?, nota3 = ?, frequencia = ? WHERE id= ?";
        try {
            PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
            ps.setString(1, aluno.getNome());
            ps.setString(2, aluno.getCodMatricula());
            ps.setFloat(3, aluno.getNota1());
            ps.setFloat(4, aluno.getNota2());
            ps.setFloat(5, aluno.getNota3());
            ps.setByte(6, aluno.getFrequencia());
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.fecharConexao();
        }
        return false;
    }
    
}
