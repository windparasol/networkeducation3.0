/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2020-04-11 12:41:39 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.teacher;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class courseapplication_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


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

      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>案例课程</title>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath());
      out.write("/jquery-1.11.3/jquery.min.js\"></script>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath());
      out.write("/bootstrap-3.3.7/css/bootstrap-theme.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath());
      out.write("/bootstrap-3.3.7/css/bootstrap.min.css\">\r\n");
      out.write("    <script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath());
      out.write("/bootstrap-3.3.7/js/bootstrap.min.js\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath());
      out.write("/JS/courseapplication.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"container\">\r\n");
      out.write("    <div class=\"row\">\r\n");
      out.write("        <div class=\"col-sm-6\">\r\n");
      out.write("            <div class=\"form-group\">\r\n");
      out.write("                <label for=\"casetitile\"class=\"col-sm-2 control-label\" >案例课程名</label>\r\n");
      out.write("                <div ></div>\r\n");
      out.write("                <div class=\"col-sm-5\">\r\n");
      out.write("                    <input type=\"text\" class=\"form-control\" id=\"casetitile\"  placeholder=\"电子邮箱\">\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <div class=\"row\"style=\"margin-top: 50px\">\r\n");
      out.write("        <div class=\"col-sm-5\">\r\n");
      out.write("            <textarea id=\"casedescrible\" rows=\"10\"class=\"form-control\"></textarea>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"col-sm-offset-1 col-sm-5\">\r\n");
      out.write("            <textarea id=\"aim\" rows=\"10\" class=\"form-control\"></textarea>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <div class=\"form-group\" style=\"margin-top: 30px\">\r\n");
      out.write("        <div class=\"control-label\"><label for=\"annex\" style=\"font-size: 20px\"><span style=\"top: 3px;\" class=\"glyphicon glyphicon-folder-open\"></span>&nbsp;&nbsp;可添加附件</label></div>\r\n");
      out.write("        <div class=\"col-sm-7\">\r\n");
      out.write("            <div class=\"input-group\">\r\n");
      out.write("                <input id='location' class=\"form-control\" onclick=\"$('#annex').click();\">\r\n");
      out.write("                <label class=\"input-group-btn\">\r\n");
      out.write("                    <input type=\"button\" id=\"i-check\" value=\"浏览文件\" class=\"btn btn-success\" onclick=\"$('#annex').click();\">\r\n");
      out.write("                </label>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <input type=\"file\" name=\"file\" id=\"annex\"  accept=\".png,.jpg,.docx,.pdf\" onchange=\"$('#location').val($('#annex').val());\" style=\"display: none\">\r\n");
      out.write("    </div>\r\n");
      out.write("    <a class=\"btn btn-danger\" style=\"margin-left: 54px\" id=\"submit\">提交</a>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
