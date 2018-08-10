package dao;

import bean.AlunoBean;
import conexao.ConexaoFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Crispim
 */
public class AlunoDAO {

    public int inserir(AlunoBean aluno) {
        Connection conexao = ConexaoFactory.obterConexao();
        if (conexao != null) {
            String sql = "INSERT INTO media"
                    + "\n(nome, codMatricula, nota1, nota2, nota3,frequencia)"
                    + "\nVALUES(?,?,?,?,?)";
            try {
                PreparedStatement preparedStatement = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, aluno.getNome());
                preparedStatement.setString(2, aluno.getCodigoMatricula());
                preparedStatement.setFloat(3, aluno.getNota1());
                preparedStatement.setFloat(4, aluno.getNota2());
                preparedStatement.setFloat(5, aluno.getNota3());
                preparedStatement.setByte(6, aluno.getFrequencia());
                preparedStatement.execute();

                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                if (resultSet.next()) {
                    return resultSet.getInt(1);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                ConexaoFactory.fecharConexao();
            }
        }
        return 0;
    }

    public boolean alterar(AlunoBean aluno) {
        Connection conexao = ConexaoFactory.obterConexao();
        String sql = "UPDATE media SET nome=?, codMatricula=?, nota1=?, nota2=?, nota3=?,frequencia=? WHERE id=?";
        try{
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, aluno.getNome());
            ps.setString(2, aluno.getCodigoMatricula());
            ps.setFloat(3, aluno.getNota1());
            ps.setFloat(4, aluno.getNota2());
            ps.setFloat(5, aluno.getNota3());
            ps.setByte(5, aluno.getFrequencia());
            return ps.executeUpdate() == 1;
        } catch (SQLException e){
            e.printStackTrace();
        } finally{
            ConexaoFactory.fecharConexao();
        }        
        
        return false;
    }

    public boolean apagar(int id) {
        String sql = "DELETE FROM media WHERE id = ?";
        Connection conexao = ConexaoFactory.obterConexao();
        if (conexao != null) {
            try {
                PreparedStatement ps = conexao.prepareStatement(sql);
                ps.setInt(1, id);
                return ps.executeUpdate() == 1;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                ConexaoFactory.fecharConexao();
            }
        }
        return false;
    }

    public AlunoBean obterClientePeloId(int id) {
        String sql = "SELECT id, nome, codMatricula, nota1, nota2, nota3,frequencia FROM media WHERE id = ?";
        Connection conexao = ConexaoFactory.obterConexao();
        if (conexao != null) {
            try {
                PreparedStatement ps = conexao.prepareStatement(sql);
                ps.setInt(1, id);
                ps.execute();
                ResultSet resultSet = ps.getResultSet();
                if (resultSet.next()) {
                    AlunoBean cliente = new AlunoBean();
                    cliente.setId(resultSet.getInt("id"));
                    cliente.setNome(resultSet.getString("nome"));
                    cliente.setCodigoMatricula(resultSet.getString("codMatricula"));
                    cliente.setNota1(resultSet.getFloat("nota1"));
                    cliente.setNota2(resultSet.getFloat("nota2"));
                    cliente.setNota3(resultSet.getFloat("nota3"));
                    cliente.setFrequencia(resultSet.getByte("frequencia"));
                    return cliente;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                ConexaoFactory.fecharConexao();
            }
        }
        return null;
    }

    public List<AlunoBean> obterClientes() {
        List<AlunoBean> alunos = new ArrayList<>();

        Connection conexao = ConexaoFactory.obterConexao();
        if (conexao != null) {
            String sql = "SELECT id, nome, codMatricula, nota1, nota2, nota3,frequencia FROM media;";
            try {
                Statement statement = conexao.createStatement();
                statement.execute(sql);
                ResultSet resultSet = statement.getResultSet();
                while (resultSet.next()) {
                    AlunoBean aluno = new AlunoBean();
                    aluno.setId(resultSet.getInt("id"));
                    aluno.setNome(resultSet.getString("nome"));
                    aluno.setCodigoMatricula(resultSet.getString("codMatricula"));
                    aluno.setNota1(resultSet.getFloat("nota1"));
                    aluno.setNota1(resultSet.getFloat("nota2"));
                    aluno.setNota1(resultSet.getFloat("nota3"));
                    aluno.setFrequencia(resultSet.getByte("frequencia"));
                    alunos.add(aluno);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                ConexaoFactory.fecharConexao();
            }
        }

        return alunos;
    }

}
