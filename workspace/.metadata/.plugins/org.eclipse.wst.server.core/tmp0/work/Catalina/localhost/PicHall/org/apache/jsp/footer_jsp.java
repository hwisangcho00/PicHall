/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.59
 * Generated at: 2021-01-10 12:45:07 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class footer_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
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

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
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

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<!--\r\n");
      out.write("\tMassively by Pixelarity\r\n");
      out.write("\tpixelarity.com | hello@pixelarity.com\r\n");
      out.write("\tLicense: pixelarity.com/license\r\n");
      out.write("-->\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<title>PicHall - 환영합니다</title>\r\n");
      out.write("<meta charset=\"utf-8\" />\r\n");
      out.write("<meta name=\"viewport\"\r\n");
      out.write("\tcontent=\"width=device-width, initial-scale=1, user-scalable=no\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"assets/css/main.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"assets/css/exhibition_list.css\" />\r\n");
      out.write("<noscript>\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"assets/css/noscript.css\" />\r\n");
      out.write("</noscript>\r\n");
      out.write("<style>\r\n");
      out.write("/*  @import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap');\r\n");
      out.write("\tbody{\r\n");
      out.write("\t\tfont-family: 'Noto Sans KR', sans-serif;\r\n");
      out.write("\t} */\r\n");
      out.write("@font-face {\r\n");
      out.write("\tfont-family: 'MaruBuri-Regular';\r\n");
      out.write("\tsrc:\r\n");
      out.write("\t\turl('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_20-10-21@1.0/MaruBuri-Regular.woff')\r\n");
      out.write("\t\tformat('woff');\r\n");
      out.write("\tfont-weight: normal;\r\n");
      out.write("\tfont-style: normal;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("body {\r\n");
      out.write("\tfont-family: 'MaruBuri-Regular';\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body class=\"is-preload\">\r\n");
      out.write("\r\n");
      out.write("\t\t<!-- Footer -->\r\n");
      out.write("\t\t<footer id=\"footer\">\r\n");
      out.write("\t\t\t<!-- <section>\r\n");
      out.write("\t\t\t\t<form method=\"post\" action=\"#\">\r\n");
      out.write("\t\t\t\t\t<div class=\"fields\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"field\">\r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"name\">Name</label> <input type=\"text\" name=\"name\"\r\n");
      out.write("\t\t\t\t\t\t\t\tid=\"name\" />\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"field\">\r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"email\">Email</label> <input type=\"text\" name=\"email\"\r\n");
      out.write("\t\t\t\t\t\t\t\tid=\"email\" />\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"field\">\r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"message\">Message</label>\r\n");
      out.write("\t\t\t\t\t\t\t<textarea name=\"message\" id=\"message\" rows=\"3\"></textarea>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<ul class=\"actions\">\r\n");
      out.write("\t\t\t\t\t\t<li><input type=\"submit\" value=\"Send Message\" /></li>\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\t\t\t</section> -->\r\n");
      out.write("\t\t\t<section class=\"split contact\">\r\n");
      out.write("\t\t\t\t<section class=\"alt\">\r\n");
      out.write("\t\t\t\t\t<h3>Address</h3>\r\n");
      out.write("\t\t\t\t\t<p>\r\n");
      out.write("\t\t\t\t\t\t서울특별시 강남구 테헤란로 26길 12 제일비전타워 13층\r\n");
      out.write("\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t</section>\r\n");
      out.write("\t\t\t\t<section>\r\n");
      out.write("\t\t\t\t\t<h3>Phone</h3>\r\n");
      out.write("\t\t\t\t\t<p>\r\n");
      out.write("\t\t\t\t\t\t<a href=\"#\">1588-5890</a>\r\n");
      out.write("\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t</section>\r\n");
      out.write("\t\t\t\t<section>\r\n");
      out.write("\t\t\t\t\t<h3>Email</h3>\r\n");
      out.write("\t\t\t\t\t<p>\r\n");
      out.write("\t\t\t\t\t\t<a href=\"#\">koreais@koreaedugroup.com</a>\r\n");
      out.write("\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t</section>\r\n");
      out.write("\t\t\t\t<section>\r\n");
      out.write("\t\t\t\t\t<h3>Social</h3>\r\n");
      out.write("\t\t\t\t\t<ul class=\"icons alt\">\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"https://www.twitter.com\" class=\"icon brands alt fa-twitter\"><span\r\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"label\">Twitter</span></a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"https://www.facebook.com\" class=\"icon brands alt fa-facebook-f\"><span\r\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"label\">Facebook</span></a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"https://www.instagram.com\" class=\"icon brands alt fa-instagram\"><span\r\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"label\">Instagram</span></a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"https://www.github.com\" class=\"icon brands alt fa-github\"><span\r\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"label\">GitHub</span></a></li>\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</section>\r\n");
      out.write("\t\t\t</section>\r\n");
      out.write("\t\t</footer>\r\n");
      out.write("\r\n");
      out.write("\t\t<!-- Copyright -->\r\n");
      out.write("\t\t<div id=\"copyright\">\r\n");
      out.write("\t\t\t<ul>\r\n");
      out.write("\t\t\t\t<li>&copy; PicHall</li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
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