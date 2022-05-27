package org.apache.jsp.tela;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import modelo.Cliente;

public final class listar_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            List<Cliente> clientes = new Cliente().ListarCliente();
        
      out.write("\n");
      out.write("        <table border=\"1\" cellspacing=\"0\" cellpadding=\"5\">\n");
      out.write("            <tr>\n");
      out.write("                <th>ID</th>\n");
      out.write("                <th>Usuario</th>\n");
      out.write("                <th>Nome</th>\n");
      out.write("                <th>Tipo Documento</th>\n");
      out.write("                <th>Documento</th>\n");
      out.write("                <th>Sexo</th>\n");
      out.write("                <th>Data Nascimento</th>\n");
      out.write("                <th>Data Cadastro</th>\n");
      out.write("            </tr>\n");
      out.write("            ");

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
            
      out.write("\n");
      out.write("        </table>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
