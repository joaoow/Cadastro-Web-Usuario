/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import util.BancoDados;

/**
 *
 * @author João Victor Pereira Miranda
 */
public class Cliente {

    private long id;
    private Usuario user;
    private String nome;
    private String tipoDocumento;
    private String documento;
    private String sexo;
    private Date dataNascimento;
    private String email;
    private String ddd;
    private String telefone;
    private String escolaridade;
    private String cep;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String uf;
    private Timestamp dataCadastro;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public Timestamp getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Timestamp dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public long Cadastrar() {
        try {

            Connection conn = BancoDados.getConexao();
            String sql = "INSERT INTO tb_cliente ";
            sql += " (nome, tpdocumento, documento, "
                    + "sexo, dtnascimento, ddd, telefone, "
                    + "escolaridade, email, cep, logradouro,"
                    + " numero, complemento, bairro, cidade, uf) ";
            sql += " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
            PreparedStatement ps = conn.prepareStatement(sql,
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, this.getNome());
            ps.setString(2, this.getTipoDocumento());
            ps.setString(3, this.getDocumento());
            ps.setString(4, this.getSexo());
            ps.setDate(5, this.getDataNascimento());
            ps.setString(6, this.getDdd());
            ps.setString(7, this.getTelefone());
            ps.setString(8, this.getEscolaridade());
            ps.setString(9, this.getEmail());
            ps.setString(10, this.getCep());
            ps.setString(11, this.getLogradouro());
            ps.setString(12, this.getNumero());
            ps.setString(13, this.getComplemento());
            ps.setString(14, this.getBairro());
            ps.setString(15, this.getCidade());
            ps.setString(16, this.getUf());
            int linhasafetadas = ps.executeUpdate();
            if (linhasafetadas > 0) {
                final ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    final long lastId = rs.getLong(1);
                    System.out.println("O numero do id é:"
                            + lastId);
                    return lastId;
                } else {
                    return 0;
                }
            } else {
                return 0;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public List<Cliente> ListarCliente() {
        try {
            Connection conn = BancoDados.getConexao();
            String sql = "SELECT * FROM tb_cliente; ";
            PreparedStatement ps = conn.prepareStatement(sql);
            List<Cliente> lista = new ArrayList();
            final ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                //id, idusuario, nome, tpdocumento, documento, sexo, dtnascimento, ddd, telefone, escolaridade, email, cep, logradouro,
                //numero, complemento, bairro, cidade, uf, dtcadastro
                Cliente cli = new Cliente();
                cli.setId(rs.getInt("id"));
                Usuario user = new Usuario();
                user.setId(rs.getLong("idusuario"));
                cli.setUser(user);
                cli.setNome("nome");
                cli.setTipoDocumento(rs.getString("tipodocumento"));
                cli.setDocumento(rs.getString("documento"));
                cli.setSexo(rs.getString("sexo"));
                cli.setDataNascimento(rs.getDate("datanascimento"));
                cli.setDdd(rs.getString("ddd"));
                cli.setTelefone(rs.getString("telefone"));
                cli.setDataCadastro(rs.getTimestamp("datacadastro"));
                lista.add(cli);
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
                //id, idusuario, nome, tpdocumento, documento, sexo, dtnascimento, ddd, telefone, escolaridade, email, cep, logradouro, numero, complemento, bairro, cidade, uf, dtcadastro
                this.setId(rs.getInt("id"));
                this.setNome(rs.getString("nome"));
                this.setTipoDocumento(rs.getString("tipodocumento"));
                this.setDocumento(rs.getString("documento"));
                this.setSexo(rs.getString("sexo"));
                this.setDataNascimento(rs.getDate("datanascimento"));
                this.setDdd(rs.getString("ddd"));
                this.setTelefone(rs.getString("telefone"));
                this.setEscolaridade(rs.getString("escolaridade"));
                this.setEmail(rs.getString("email"));
                this.setLogradouro(rs.getString("logradouro"));
                this.setComplemento(rs.getString("complemento"));
                this.setBairro(rs.getString("bairro"));
                this.setCidade(rs.getString("cidade"));
                this.setUf(rs.getString("uf"));
                this.setDataCadastro(rs.getTimestamp("datacadastro"));
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
            //id, idusuario, nome, tpdocumento, documento, sexo, dtnascimento, ddd, telefone, escolaridade, email,
            //cep, logradouro, numero, complemento, bairro, cidade, uf, dtcadastro
            String sql = "UPDATE tb_cliente ";
            sql += " SET nome = ?, ";
            sql += " tpdocumento = ?, ";
            sql += " documento = ?, ";
            sql += " sexo = ?, ";
            sql += " dtnascimento = ?, ";
            sql += " ddd = ?, ";
            sql += " telefone = ?, ";
            sql += " escolaridade = ?, ";
            sql += " email = ?, ";
            sql += " cep = ?, ";
            sql += " logradouro = ?, ";
            sql += " numero = ?, ";
            sql += " complemento = ?, ";
            sql += " bairro = ?, ";
            sql += " cidade = ?, ";
            sql += " uf = ? ";
            sql += " WHERE id = ?; ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, this.getNome());
            ps.setString(2, this.getTipoDocumento());
            ps.setString(3, this.getDocumento());
            ps.setString(4, this.getSexo());
            ps.setDate(5, this.getDataNascimento());
            ps.setString(6, this.getDdd());
            ps.setString(7, this.getTelefone());
            ps.setString(8, this.getEscolaridade());
            ps.setString(9, this.getEmail());
            ps.setString(10, this.getCep());
            ps.setString(11, this.getLogradouro());
            ps.setString(12, this.getNumero());
            ps.setString(13, this.getComplemento());
            ps.setString(14, this.getBairro());
            ps.setString(15, this.getCidade());
            ps.setString(16, this.getUf());
            ps.setLong(17, this.getId());
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

    public static boolean Excluir(long id) {
        try {
            Connection conn = BancoDados.getConexao();
            String sql = "DELETE FROM tb_cliente  WHERE id = ?; ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, id);
            int linhasafetadas = ps.executeUpdate();
            if (linhasafetadas > 0) {
                System.out.println("Apagou!!");
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            return false;
        }
    }
}
