<%-- 
    Document   : listar
    Created on : 28/03/2022, 09:04:12
    Author     : sala305b
--%>

<%@page import="java.util.List"%>
<%@page import="modelo.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            List<Cliente> clientes = new Cliente().ListarCliente();
        %>
        <table border="1" cellspacing="0" cellpadding="5">
            <tr>
                <th>ID</th>
                <th>Usuario</th>
                <th>Nome</th>
                <th>Tipo Documento</th>
                <th>Documento</th>
                <th>Sexo</th>
                <th>Data Nascimento</th>
                <th>DDD/Telefone</th>
                <th>Data Cadastro</th>
            </tr>
            <%
                for (Cliente c : clientes) {
                    out.print("<tr>");

                    out.print("<td>");
                    out.print(c.getId());
                    out.print("</td>");

                    out.print("<td>");
                    out.print(c.getUser());
                    out.print("</td>");

                    out.print("<td>");
                    out.print(c.getNome());
                    out.print("</td>");

                    out.print("<td>");
                    out.print(c.getTipoDocumento());
                    out.print("</td>");

                    out.print("<td>");
                    out.print(c.getDocumento());
                    out.print("</td>");

                    out.print("<td>");
                    out.print(c.getSexo());
                    out.print("</td>");

                    out.print("<td>");
                    out.print(c.getDataNascimento());
                    out.print("</td>");

                    out.print("<td>");
                    out.print(c.getDdd() + c.getTelefone());
                    out.print("</td>");

                    out.print("<td>");
                    out.print(c.getDataCadastro());
                    out.print("</td>");

                    out.print("<td>");

                    out.print("<div style='display:inline-block'>");;
                    out.print("<form action='index.jsp' method='POST'>");
                    out.print("<input name='acao' type='hidden' value='editar' />");
                    out.print("<input name='idcliente' type='hidden' value='" + c.getId() + "' />");
                    out.print("<button type='submit'>Editar</button>");
                    out.print("</form>");
                    out.print("</div>");

                    out.print("&nbsp;");
                    out.print("&nbsp;");

                    out.print("<div style='display:inline-block'>");
                    out.print("<form action='ClienteServlet' method='POST'>");
                    out.print("<input name='acao' type='hidden' value='apagar' />");
                    out.print("<input name='idcliente' type='hidden' value='" + c.getId() + "' />");
                    out.print("<button type='submit'>Deletar</button>");
                    out.print("</form>");
                    out.print("</div>");

                    out.print("</td>");
                    out.print("</tr>");
                }
            %>
        </table>
    </body>
</html>
