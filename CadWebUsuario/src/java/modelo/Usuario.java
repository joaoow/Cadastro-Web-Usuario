/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import util.BancoDados;

/**
 *
 * @author sala305b
 */
public class Usuario {

    private long id;
    private String login;
    private String responsavel;
    private String nome;
    private String senha;
    private Timestamp dataCadastro;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Timestamp getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Timestamp dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    
    public boolean TemUsuario() {
        try {
            Connection conn = BancoDados.getConexao();
            String sql = "SELECT id,responsavel,dtcadastro "
                    + "FROM tb_usuario "
                    + "WHERE login = ? AND senha = ? ; ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, this.getLogin());
            ps.setString(2, this.getSenha());
            final ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                this.setId(rs.getInt("id"));
                this.setResponsavel(rs.getString("responsavel"));
                this.setDataCadastro(rs.getTimestamp("dtcadastro"));
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
/*
   
    public List<Cliente> ListarTodos() {
        try {

            Connection conn = BancoDados.getConexao();
            String sql = "SELECT * FROM tb_cliente; ";
            PreparedStatement ps = conn.prepareStatement(sql);
            List<Cliente> lista = new ArrayList();
            final ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Cliente c = new Cliente();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setTpDocumento(rs.getString("tpdocumento"));
                c.setDocumento(rs.getString("documento"));
                c.setSexo(rs.getString("sexo"));
                c.setDdd(rs.getString("ddd"));
                c.setTelefone(rs.getString("telefone"));
                c.setEscolaridade(rs.getString("escolaridade"));
                c.setDtNascimento(rs.getDate("dtnascimento"));
                c.setEmail(rs.getString("email"));
                c.setDtCadastro(rs.getTimestamp("dtcadastro"));
                lista.add(c);
            }
            return lista;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public boolean BuscarPorId(String id) {

        try {

            long idcli = Long.parseLong(id);

            Connection conn = BancoDados.getConexao();
            String sql = "SELECT * FROM tb_cliente WHERE id = ?; ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, idcli);
            final ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                this.setId(rs.getInt("id"));
                this.setNome(rs.getString("nome"));
                this.setTpDocumento(rs.getString("tpdocumento"));
                this.setDocumento(rs.getString("documento"));
                this.setSexo(rs.getString("sexo"));
                this.setDdd(rs.getString("ddd"));
                this.setTelefone(rs.getString("telefone"));
                this.setEscolaridade(rs.getString("escolaridade"));
                this.setDtNascimento(rs.getDate("dtnascimento"));
                this.setEmail(rs.getString("email"));
                this.setDtCadastro(rs.getTimestamp("dtcadastro"));

                return true;

            } else {
                return false;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean Atualizar() {
        try {
            Connection conn = BancoDados.getConexao(); //conectar com o bando de dados e enviar os dados salvos da classe Contato.
            String sql = "UPDATE tb_cliente "
                    + " SET nome = ?, "
                    + " tpdocumento = ?, "
                    + " documento = ?, "
                    + " sexo =?, "
                    + " dtnascimento = ?, "
                    + " ddd = ?, "
                    + " telefone = ?, "
                    + " escolaridade = ?, "
                    + " email = ? "
                    + " WHERE id = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, this.getNome());
            ps.setString(2, this.getTpDocumento());
            ps.setString(3, this.getDocumento());
            ps.setString(4, this.getSexo());
            ps.setDate(5, this.getDtNascimento());
            ps.setString(6, this.getDdd());
            ps.setString(7, this.getTelefone());
            ps.setString(8, this.getEscolaridade());
            ps.setString(9, this.getEmail());
            ps.setLong(10, this.getId());
            int linhasafetadas = ps.executeUpdate();
            if (linhasafetadas > 0) {
                System.out.println("atualizou!");
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            return false;
        }
    }
*/
}
