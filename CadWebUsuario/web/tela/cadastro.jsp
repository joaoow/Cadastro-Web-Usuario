<%-- 
    Document   : cadastro
    Created on : 30/03/2022, 08:44:50
    Author     : sala305b
--%>

<%@page import="modelo.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String acao = "cadastrar", idcliente = "", nome = "", datanascimento = "",
            documento = "", tipodocumento = "", escolaridade = "", sexo = "", dddtelefone = "",
            email = "", cep = "", logradouro = "", numero = "", bairro = "", cidade = "", uf = "",
            complemento = "", datacadastro = "", ddd = "", telefone = "";

    Cliente clie = new Cliente();
    if (request.getParameter("acao") != null) {
        if (request.getParameter("acao").equals("editar")) {

            idcliente = request.getParameter("idcliente");
            boolean achou = clie.BuscarPorId(idcliente);
            if (!achou) {
                out.print("<script>"
                        + "window.alert('Cliente não Encontrado');"
                        + "</script>");
            } else {
                acao = "editar";
                idcliente = String.valueOf(clie.getId());
                nome = clie.getNome();
                tipodocumento = clie.getTipoDocumento();
                documento = clie.getDocumento();
                sexo = clie.getSexo();
                datanascimento = String.valueOf(clie.getDataNascimento());
                ddd = clie.getDdd();
                telefone = clie.getTelefone();
                escolaridade = clie.getEscolaridade();
                email = clie.getEmail();
                cep = clie.getCep();
                logradouro = clie.getLogradouro();
                numero = clie.getNumero();
                complemento = clie.getComplemento();
                bairro = clie.getBairro();
                cidade = clie.getCidade();
                uf = clie.getUf();
                datacadastro = String.valueOf(clie.getDataCadastro());
            }
        }
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema de Cadastro</title>

        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="css/bootstrap.css" />

    </head>
    <body>
        <form action="ClienteServlet" method="POST">
            <input type="hidden" name="acao" value="<%=acao%>">
            <table border="0" cellspacing="0" cellpadding="5">
                <tr>
                    <td>
                        <label for="">ID:</label><br/>
                        <input size="5" value="<%=idcliente%>"
                               type="text" name="idcliente" />
                    </td>
                    <td>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="">Nome Completo:</label><br/>
                        <input size="30" 
                               value="<%=nome%>"
                               type="text" name="nome" />
                    </td>
                    <td>
                        <label for="">Data de Nascimento:</label><br/>
                        <input size="30"  value="<%=datanascimento%>"
                               type="date" name="datanascimento" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="">Documento:</label><br/>
                        <input size="30" id="txtDocumento"  value="<%=documento%>"
                               type="text" name="documento" />
                    </td>
                    <td>
                        <table border="0" cellspacing="0" cellpadding="0">
                            <tr>
                                <td colspan="3">
                                    <label for="">Tipo Documento:</label>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <input id="rdbCPF"
                                           checked="checked"
                                           type="radio" 
                                           name="tipodocumento"
                                           value="<%=tipodocumento.equals("CPF") ? "checked" : ""%>"/>
                                    <label for="rdbCPF">CPF</label>
                                </td>
                                <td>
                                    <input id="rdbCNH"
                                           type="radio" 
                                           name="tpdocumento"
                                           value="<%=tipodocumento.equals("CNH") ? "checked" : ""%>"/>
                                    <label for="rdbCNH">CNH</label> 
                                </td>
                                <td>
                                    <input id="rdbRG"
                                           type="radio" 
                                           name="tpdocumento"
                                           value="<%=tipodocumento.equals("RG") ? "checked" : ""%>"/>
                                    <label for="rdbRG">RG</label>
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="sltEscolaridade">Escolaridade:</label>
                        <select id="sltEscolaridade" name="escolaridade">
                            <option <%= escolaridade.equals("EM") ? "selected": "" %> 
                                value="EM">Ensino Médio</option>
                            <option <%= escolaridade.equals("ET") ? "selected": "" %>
                                value="ET">Ensino Técnico</option>
                            <option <%= escolaridade.equals("ES") ? "selected": "" %>
                                value="ES">Ensino Superior</option>
                            <option <%= escolaridade.equals("PG") ? "selected": "" %>
                                value="PG">Pós Graduação</option>
                        </select>
                    </td>
                    <td>
                        <table border="0" cellspacing="0" cellpadding="0">
                            <tr>
                                <td colspan="3">
                                    <label for="">Sexo:</label>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <input id="rdbM"
                                           type="radio" 
                                           name="sexo"
                                           value="<%=tipodocumento.equals("M") ? "checked" : ""%>"/>
                                    <label for="rdbM">Masculino</label>
                                </td>
                                <td>
                                    <input id="rdbF"
                                           type="radio" 
                                           name="sexo"
                                           value="<%=tipodocumento.equals("F") ? "checked" : ""%>"/>
                                    <label for="rdbF">Feminino</label> 
                                </td>
                                <td>
                                    <input id="rdbO"
                                           type="radio" 
                                           name="sexo"
                                           value="<%=tipodocumento.equals("O") ? "checked" : ""%>"/>
                                    <label for="rdbO">Outro</label>
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="txtDddTelefone">DDD/Telefone:</label><br/>
                        <input size="30"
                               id="txtDddTelefone"
                               type="text" name="dddtelefone" value="<%=dddtelefone%>" />
                    </td>
                    <td>
                        <label for="">Email:</label><br/>
                        <input size="30"  value="<%=email%>"
                               type="email" name="email" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="txtCEP">CEP:</label><br/>
                        <input id="txtCEP" size="30" type="text" name="cep" value="<%=cep%>" />
                    </td>
                    <td>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <table border="0" cellspacing="0" cellpadding="0">
                            <tr>
                                <td width="90%">
                                    <label for="">Logradouro:</label><br/>
                                    <input size="55"type="text" name="logradouro" value="<%=logradouro%>" />
                                </td>
                                <td width="10%">
                                    <label for="">Numero:</label><br/>
                                    <input size="5" type="text" name="numero" value="<%=numero%>" />
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="">Bairro:</label><br/>
                        <input size="30" type="text" name="bairro" value="<%=bairro%>" />
                    </td>
                    <td>
                        <label for="">Cidade:</label><br/>
                        <input size="30" type="text" name="cidade" value="<%=cidade%>" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="">UF:</label><br/>
                        <select id="sltEstado" name="uf" value="<%=uf%>">
                            <option value="">Selecione</option>
                            <option <%= uf.equals("AC") ? "selected": "" %>
                                value="AC">Acre</option>
                            <option <%= uf.equals("AL") ? "selected": "" %>
                                value="AL">Alagoas</option>
                            <option <%= uf.equals("AP") ? "selected": "" %>
                                value="AP">Amapá</option>
                            <option <%= uf.equals("AM") ? "selected": "" %>
                                value="AM">Amazonas</option>
                            <option <%= uf.equals("BA") ? "selected": "" %>
                                value="BA">Bahia</option>
                            <option <%= uf.equals("PG") ? "selected": "" %>
                                value="CE">Ceará</option>
                            <option <%= uf.equals("DF") ? "selected": "" %>
                                value="DF">Distrito Federal</option>
                            <option <%= uf.equals("ES") ? "selected": "" %>
                                value="ES">Espirito Santo</option>
                            <option <%= uf.equals("GO") ? "selected": "" %>
                                value="GO">Goiás</option>
                            <option <%= uf.equals("MA") ? "selected": "" %>
                                value="MA">Maranhão</option>
                            <option <%= uf.equals("MS") ? "selected": "" %>
                                value="MS">Mato Grosso do Sul</option>
                            <option <%= uf.equals("MT") ? "selected": "" %>
                                value="MT">Mato Grosso</option>
                            <option <%= uf.equals("MG") ? "selected": "" %>
                                value="MG">Minas Gerais</option>
                            <option <%= uf.equals("PA") ? "selected": "" %>
                                value="PA">Pará</option>
                            <option <%= uf.equals("PB") ? "selected": "" %>
                                value="PB">Paraíba</option>
                            <option <%= uf.equals("PR") ? "selected": "" %>
                                value="PR">Paraná</option>
                            <option <%= uf.equals("PE") ? "selected": "" %>
                                value="PE">Pernambuco</option>
                            <option <%= uf.equals("PT") ? "selected": "" %>
                                value="PI">Piauí</option>
                            <option <%= uf.equals("RJ") ? "selected": "" %>
                                value="RJ">Rio de Janeiro</option>
                            <option <%= uf.equals("RN") ? "selected": "" %>
                                value="RN">Rio Grande do Norte</option>
                            <option <%= uf.equals("RS") ? "selected": "" %>
                                value="RS">Rio Grande do Sul</option>
                            <option <%= uf.equals("RO") ? "selected": "" %>
                                value="RO">Rondônia</option>
                            <option <%= uf.equals("RR") ? "selected": "" %>
                                value="RR">Roraima</option>
                            <option <%= uf.equals("SC") ? "selected": "" %>
                                value="SC">Santa Catarina</option>
                            <option <%= uf.equals("SP") ? "selected": "" %>
                                value="SP">São Paulo</option>
                            <option <%= uf.equals("SE") ? "selected": "" %>
                                value="SE">Sergipe</option>
                            <option <%= uf.equals("TO") ? "selected": "" %>
                                value="TO">Tocantins</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input class="btn btn-primary" type="submit" value="Salvar" />
                    </td>
                </tr>
            </table>
        </form>
        <script type="text/javascript" src="js/bootstrap.js"></script>
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/jquery.mask.js"></script>
        <script type="text/javascript">
            jQuery(document).ready(function ($) {

                $("#txtDocumento").mask("000.000.000-00");
                $("#rdbCNH").on("click", function (e) {
                    $("#txtDocumento").mask("00000000000");
                });
                $("#rdbRG").on("click", function (e) {
                    $("#txtDocumento").mask("0.000.000");
                });
                $("#rdbCPF").on("click", function (e) {
                    $("#txtDocumento").mask("000.000.000-00");
                });
                $("#txtDddTelefone").on("click", function (e) {
                    $("#txtDddTelefone").mask("(00) 0000-0000");
                });
                $("#txtCEP").on("click", function (e) {
                    $("#txtCEP").mask("00000-000");
                });
            });
        </script>
    </body>
</html>
