/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/11.0.4
 * Generated at: 2025-03-18 13:55:25 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;
import java.util.Map;
import java.util.List;
import uk.ac.ucl.model.NoteIndex;
import uk.ac.ucl.model.Note;

public final class indexCategories_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports,
                 org.apache.jasper.runtime.JspSourceDirectives {

  private static final jakarta.servlet.jsp.JspFactory _jspxFactory =
          jakarta.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(4);
    _jspx_imports_packages.add("jakarta.servlet");
    _jspx_imports_packages.add("jakarta.servlet.http");
    _jspx_imports_packages.add("jakarta.servlet.jsp");
    _jspx_imports_classes = new java.util.LinkedHashSet<>(6);
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("uk.ac.ucl.model.Note");
    _jspx_imports_classes.add("java.util.Map");
    _jspx_imports_classes.add("uk.ac.ucl.model.NoteIndex");
  }

  private volatile jakarta.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public boolean getErrorOnELNotFound() {
    return false;
  }

  public jakarta.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final jakarta.servlet.http.HttpServletRequest request, final jakarta.servlet.http.HttpServletResponse response)
      throws java.io.IOException, jakarta.servlet.ServletException {

    if (!jakarta.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final jakarta.servlet.jsp.PageContext pageContext;
    jakarta.servlet.http.HttpSession session = null;
    final jakarta.servlet.ServletContext application;
    final jakarta.servlet.ServletConfig config;
    jakarta.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    jakarta.servlet.jsp.JspWriter _jspx_out = null;
    jakarta.servlet.jsp.PageContext _jspx_page_context = null;


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

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <title>Your Notes</title>\n");
      out.write("    <style>\n");
      out.write("        body {\n");
      out.write("            background-color: #fce0e0;\n");
      out.write("            font-family: Arial, sans-serif;\n");
      out.write("            margin: 0;\n");
      out.write("            display: flex;\n");
      out.write("            justify-content: center;\n");
      out.write("            align-items: center;\n");
      out.write("            height: 100vh;\n");
      out.write("        }\n");
      out.write("        .container {\n");
      out.write("            background-color: white;\n");
      out.write("            padding: 20px;\n");
      out.write("            border-radius: 10px;\n");
      out.write("            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);\n");
      out.write("            text-align: center;\n");
      out.write("            width: 100%;\n");
      out.write("            max-width: 600px;\n");
      out.write("        }\n");
      out.write("        h2 {\n");
      out.write("            margin-bottom: 20px;\n");
      out.write("            color: #333;\n");
      out.write("        }\n");
      out.write("        ul {\n");
      out.write("            list-style-type: none;\n");
      out.write("            padding: 0;\n");
      out.write("        }\n");
      out.write("        li {\n");
      out.write("            border: 2px solid #d66;\n");
      out.write("            border-radius: 10px;\n");
      out.write("            padding: 10px;\n");
      out.write("            margin: 10px 0;\n");
      out.write("            font-size: 1.1em;\n");
      out.write("            text-align: center;\n");
      out.write("            font-weight: bold;\n");
      out.write("            color: black;\n");
      out.write("            transition: all 0.3s ease;\n");
      out.write("        }\n");
      out.write("        a {\n");
      out.write("            text-decoration: none;\n");
      out.write("            color: black;\n");
      out.write("            font-weight: bold;\n");
      out.write("            transition: color 0.3s;\n");
      out.write("        }\n");
      out.write("        a:hover {\n");
      out.write("            color: #a44;\n");
      out.write("        }\n");
      out.write("        input[type=\"button\"] {\n");
      out.write("            background-color: #d66;\n");
      out.write("            color: white;\n");
      out.write("            padding: 10px 20px;\n");
      out.write("            border: none;\n");
      out.write("            border-radius: 5px;\n");
      out.write("            font-size: 1.1em;\n");
      out.write("            cursor: pointer;\n");
      out.write("            transition: background-color 0.3s ease;\n");
      out.write("        }\n");
      out.write("        input[type=\"button\"]:hover {\n");
      out.write("            background-color: #a44;\n");
      out.write("        }\n");
      out.write("        input[type=\"submit\"], input[type=\"button\"], button {\n");
      out.write("          background-color: #d66;\n");
      out.write("          color: white;\n");
      out.write("          padding: 10px 20px;\n");
      out.write("          border: none;\n");
      out.write("          border-radius: 5px;\n");
      out.write("          font-size: 1.1em;\n");
      out.write("          cursor: pointer;\n");
      out.write("          transition: background-color 0.3s ease;\n");
      out.write("        }\n");
      out.write("        input[type=\"submit\"]:hover, input[type=\"button\"]:hover, button:hover {\n");
      out.write("          background-color: #a44;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <div class=\"container\">\n");
      out.write("            <h2>Your Notes</h2>\n");
      out.write("            <button onclick=\"window.location.href='addNote.jsp'\">Add New Note</button>\n");
      out.write("            <button onclick=\"window.location.href='indexNotes.jsp'\">See All Notes</button>\n");
      out.write("\n");
      out.write("            <h3>Categories</h3>\n");
      out.write("            <ul>\n");
      out.write("                ");

                    NoteIndex noteIndex = NoteIndex.getInstance();
                    List<String> allCategories = noteIndex.getAllCategories();

                    for (String category : allCategories) {
                
      out.write("\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"indexNotesCategories.jsp?category=");
      out.print( java.net.URLEncoder.encode(category, "UTF-8") );
      out.write("\">\n");
      out.write("                            ");
      out.print( category );
      out.write("\n");
      out.write("                        </a>\n");
      out.write("                    </li>\n");
      out.write("                ");
 } 
      out.write("\n");
      out.write("            </ul>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            <form action=\"addCategory\" method=\"POST\" style=\"display: flex; justify-content: center; align-items: center; gap: 10px; margin-bottom: 10px;\">\n");
      out.write("                <label for=\"category\">Create a New Category:</label>\n");
      out.write("                <input type=\"text\" name=\"category\" id=\"category\" required style=\"padding: 5px; font-size: 1em;\">\n");
      out.write("                <button type=\"submit\" style=\"padding: 5px 10px; font-size: 0.9em;\">Add</button>\n");
      out.write("            </form>\n");
      out.write("\n");
      out.write("\n");
      out.write("            <br><button onclick=\"window.history.back();\">Back</button>\n");
      out.write("        </div>\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof jakarta.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
