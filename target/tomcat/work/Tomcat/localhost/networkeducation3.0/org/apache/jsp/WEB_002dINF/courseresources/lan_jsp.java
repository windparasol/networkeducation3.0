/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2020-05-03 08:01:35 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.courseresources;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class lan_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <title>局域网</title>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath());
      out.write("/bootstrap-3.3.7/css/bootstrap-theme.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath());
      out.write("/bootstrap-3.3.7/css/bootstrap.min.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath());
      out.write("/CSS/lan.css\">\r\n");
      out.write("    <script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath());
      out.write("/jquery-1.11.3/jquery.min.js\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath());
      out.write("/bootstrap-3.3.7/js/bootstrap.min.js\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath());
      out.write("/JS/lan.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body style=\"background-color:papayawhip;\">\r\n");
      out.write("<nav class=\"navbar navbar-inverse\" id=\"nav\">\r\n");
      out.write("    <div class=\"container-fluid\">\r\n");
      out.write("        <div class=\"navbar-header\">\r\n");
      out.write("            <button type=\"button\" class=\"navbar-toggle collapsed\" data-toggle=\"collapse\" data-target=\"#bs-example-navbar-collapse-1\" aria-expanded=\"false\">\r\n");
      out.write("                <span class=\"sr-only\">Toggle navigation</span>\r\n");
      out.write("                <span class=\"icon-bar\"></span>\r\n");
      out.write("                <span class=\"icon-bar\"></span>\r\n");
      out.write("                <span class=\"icon-bar\"></span>\r\n");
      out.write("            </button>\r\n");
      out.write("            <a class=\"navbar-brand\" href=\"#\"></a>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <!-- Collect the nav links, forms, and other content for toggling -->\r\n");
      out.write("        <div class=\"collapse navbar-collapse\" id=\"bs-example-navbar-collapse-1\">\r\n");
      out.write("            <ul class=\"nav navbar-nav\">\r\n");
      out.write("\r\n");
      out.write("                <li id=\"brand\">\r\n");
      out.write("                    <a href=\"");
      out.print(request.getContextPath());
      out.write("/index.do\">主页</a>\r\n");
      out.write("                </li>\r\n");
      out.write("\r\n");
      out.write("                <li class=\"active\">\r\n");
      out.write("                    <a href=\"javascript:void(0)\">案例资源<span class=\"sr-only\">(current)</span></a>\r\n");
      out.write("                </li>\r\n");
      out.write("\r\n");
      out.write("                <li class=\"dropdown\">\r\n");
      out.write("                    <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\" aria-expanded=\"false\">关于我们 <span class=\"caret\"></span></a>\r\n");
      out.write("                    <ul class=\"dropdown-menu\">\r\n");
      out.write("                        <li>\r\n");
      out.write("                            <a href=\"#\"></a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li>\r\n");
      out.write("                            <a href=\"#\">项目介绍</a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li>\r\n");
      out.write("                            <a href=\"#\">加入我们</a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li role=\"separator\" class=\"divider\"></li>\r\n");
      out.write("                        <li>\r\n");
      out.write("                            <a href=\"");
      out.print(request.getContextPath());
      out.write("/jumpcontentinput.do\">课程输入测试</a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li>\r\n");
      out.write("                    <img src=\"");
      out.print(request.getContextPath());
      out.write("/HtmlImage/head.PNG\" alt=\"...\" class=\"img-circle\"  id=\"Head_portrait\"/>\r\n");
      out.write("\r\n");
      out.write("                </li>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                <li class=\"dropdown\">\r\n");
      out.write("                    <button class=\"btn btn-success btn-sm dropdown-toggle\" type=\"button\" id=\"dropdownMenu1\"\r\n");
      out.write("                            data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"true\" style=\"margin-top: 8px;\">\r\n");
      out.write("                        ");
      out.print(session.getAttribute("username"));
      out.write("\r\n");
      out.write("                        <span class=\"caret\"></span>\r\n");
      out.write("                    </button>\r\n");
      out.write("                    <ul class=\"dropdown-menu\">\r\n");
      out.write("                        <li>\r\n");
      out.write("                            <a href=\"#\" style=\"text-align: center;\"><span class=\"glyphicon glyphicon-user\" ></span>&nbsp;个人中心</a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li style=\"margin-top: 10px;\">\r\n");
      out.write("                            <a href=\"#\" style=\"text-align: center;\"><span class=\"glyphicon glyphicon-edit\"></span>&nbsp;课程反馈</a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li role=\"separator\" class=\"divider\"></li>\r\n");
      out.write("                        <li>\r\n");
      out.write("                            <a href=\"#\" style=\"text-align: center;\"><span class=\"glyphicon glyphicon-off\"></span>&nbsp;返回到登录</a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </li>\r\n");
      out.write("\r\n");
      out.write("            </ul>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</nav>\r\n");
      out.write("<div class=\"jumbotron\">\r\n");
      out.write("    <div class=\"row\">\r\n");
      out.write("        <div class=\"col-sm-5 col-sm-offset-1\">\r\n");
      out.write("            <div class=\"page-header\">\r\n");
      out.write("                <h2 id=\"head\" style=\"color: peru ;font-size: 40px\">小型局域网的搭建</h2>\r\n");
      out.write("            </div>\r\n");
      out.write("            <p><small style=\"color:peru;margin-left: 25%\">课程id：&nbsp01</small></p>\r\n");
      out.write("            <p ><small style=\"color: peru;margin-left: 25%\">制作人：&nbspwindparasol</small></p>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("<div class=\"container-fluid\">\r\n");
      out.write("\r\n");
      out.write("    <div class=\"row\">\r\n");
      out.write("        <div class=\"col-sm-8 col-sm-offset-2\" style=\"background-color: white;height: 650px;\">\r\n");
      out.write("            <ul class=\"nav nav-pills\" role=\"tablist\" style=\"margin-left: 3%;margin-top: 3%;\">\r\n");
      out.write("                <li role=\"presentation\" class=\"active\"><a href=\"#frist\" aria-controls=\"frist\" role=\"tab\" data-toggle=\"tab\">案例信息</a></li>\r\n");
      out.write("                <li role=\"presentation\" ><a href=\"#second\" aria-controls=\"second\" role=\"tab\" data-toggle=\"tab\" id=\"newcom\">基本知识点</a></li>\r\n");
      out.write("                <li role=\"presentation\" ><a href=\"#second\" aria-controls=\"second\" role=\"tab\" data-toggle=\"tab\" id=\"video\">实验内容</a></li>\r\n");
      out.write("            </ul>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"tab-content\" style=\"border: lavender solid 1px;margin-top: 2%;padding-bottom: 3%\">\r\n");
      out.write("                <div role=\"tabpanel\" class=\"tab-pane active\" id=\"frist\">\r\n");
      out.write("                    <div class=\"row\">\r\n");
      out.write("                        <div class=\"col-sm-4\" style=\" margin-top: 3%;margin-left: 3%\">\r\n");
      out.write("                                <img src=\"");
      out.print(request.getContextPath());
      out.write("/img/timg.jpg\" alt=\"...\"class=\"img-thumbnail\">\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"col-sm-6\" style=\"height: 400px;\">\r\n");
      out.write("                            <div class=\"row\">\r\n");
      out.write("                                <div class=\"page-header\">\r\n");
      out.write("                                    <h3 class=\"text-info\"style=\"color:goldenrod\">情景描述</h3>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"row\">\r\n");
      out.write("                                <div class=\"col-sm-8\" style=\"margin-left: 29%\">\r\n");
      out.write("                                    <p id=\"p1\" class=\"text-success\">\r\n");
      out.write("\r\n");
      out.write("                                    </p>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <div role=\"tabpanel\" class=\"tab-pane\" id=\"second\">\r\n");
      out.write("                    <div class=\"row\">\r\n");
      out.write("                        <div class=\"col-sm-6 \">\r\n");
      out.write("                            <div class=\"input-group input-group-lg\" style=\"margin-top: 30px\">\r\n");
      out.write("                                <span class=\"input-group-addon\"><span class=\"glyphicon glyphicon-list-alt\"></span></span>\r\n");
      out.write("                                <input type=\"text\" class=\"form-control\"id=\"casetitile\" placeholder=\"案例课程名\" aria-describedby=\"sizing-addon1\">\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"row\"style=\"margin-top: 50px\">\r\n");
      out.write("                        <div class=\"col-sm-6\">\r\n");
      out.write("                            <label for=\"casedescrible\" class=\"form-control-static\">案例描述</label>\r\n");
      out.write("                            <textarea id=\"casedescrible\" rows=\"6\"class=\"form-control\"></textarea>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"row\">\r\n");
      out.write("                        <div class=\"col-sm-6\">\r\n");
      out.write("                            <label for=\"aim\" class=\"form-control-static\">教学目标</label>\r\n");
      out.write("                            <textarea id=\"aim\" rows=\"6\" class=\"form-control\"></textarea>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"form-group\" style=\"margin-top: 30px\">\r\n");
      out.write("                        <div class=\"control-label\"><label for=\"annex\" style=\"font-size: 20px\"><span style=\"top: 3px;\" class=\"glyphicon glyphicon-folder-open\"></span>&nbsp;&nbsp;可添加附件</label></div>\r\n");
      out.write("                        <div class=\"col-sm-7\">\r\n");
      out.write("                            <div class=\"input-group\">\r\n");
      out.write("                                <input id='location' class=\"form-control\" onclick=\"$('#annex').click();\">\r\n");
      out.write("                                <label class=\"input-group-btn\">\r\n");
      out.write("                                    <input type=\"button\" id=\"i-check\" value=\"浏览文件\" class=\"btn btn-success\" onclick=\"$('#annex').click();\">\r\n");
      out.write("                                </label>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <input type=\"file\" name=\"file\" id=\"annex\"  accept=\".png,.jpg,.docx,.pdf\" onchange=\"$('#location').val($('#annex').val());\" style=\"display: none\">\r\n");
      out.write("\r\n");
      out.write("                        <a class=\"btn btn-danger\" style=\"margin-left: 54px\" id=\"submit\">提交</a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
