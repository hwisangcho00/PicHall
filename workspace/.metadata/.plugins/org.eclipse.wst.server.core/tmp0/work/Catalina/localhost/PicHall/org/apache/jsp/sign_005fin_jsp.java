/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.59
 * Generated at: 2021-01-10 12:45:10 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class sign_005fin_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<title>PicHall ????????????</title>\r\n");
      out.write("<meta charset=\"utf-8\" />\r\n");
      out.write("<meta name=\"viewport\"\r\n");
      out.write("\tcontent=\"width=device-width, initial-scale=1, user-scalable=no\" />\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("\thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/assets/css/main.css\" />\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("\thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/assets/css/sign_in.css\" />\r\n");
      out.write("<noscript>\r\n");
      out.write("\t<link rel=\"stylesheet\"\r\n");
      out.write("\t\thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/assets/css/noscript.css\" />\r\n");
      out.write("</noscript>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body class=\"is-preload\">\r\n");
      out.write("\t<form name=\"joinForm\"\r\n");
      out.write("\t\taction=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/member/MemberJoinOk.me\"\r\n");
      out.write("\t\tmethod=\"post\">\r\n");
      out.write("\t\t<!-- Main -->\r\n");
      out.write("\t\t<div id=\"main\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t<!-- Post -->\r\n");
      out.write("\t\t\t<section class=\"post\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<div class=\"row gtr-uniform\">\r\n");
      out.write("\t\t\t\t\t<div class=\"col-6\" id=\"sign_up_wrap\">\r\n");
      out.write("\t\t\t\t\t\t<br> <label>??????</label>\r\n");
      out.write("\t\t\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" name=\"member_name\" id=\"member_name\"/>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<br> <label>?????????</label>\r\n");
      out.write("\t\t\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" name=\"member_id\" id=\"member_id\"\r\n");
      out.write("\t\t\t\t\t\t\t\tplaceholder=\"5~15??????\" />\r\n");
      out.write("\t\t\t\t\t\t\t<p id=\"idCheck_text\"></p>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<br> <label>????????????</label>\r\n");
      out.write("\t\t\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"password\" name=\"member_pw\" id=\"member_pw\" value=\"\"\r\n");
      out.write("\t\t\t\t\t\t\t\tplaceholder=\"8~32??????\" /> <input type=\"password\"\r\n");
      out.write("\t\t\t\t\t\t\t\tname=\"member_pw_re\" id=\"member_pw_re\" value=\"\"\r\n");
      out.write("\t\t\t\t\t\t\t\tplaceholder=\"???????????? ?????????\" style=\"margin-top: 0.5em\" />\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<br> <label>?????????</label>\r\n");
      out.write("\t\t\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"text\" name=\"member_nickname\" id=\"member_nickname\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tplaceholder=\"2~20??????\" />\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<br> <label>?????????</label>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"email\" name=\"member_email\" id=\"member_email\"\r\n");
      out.write("\t\t\t\t\t\t\t\tplaceholder=\"email@pichall.com\" />\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<br><p id=\"emailCheck_text\"></p>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<div class=\"col-6\" id=\"img_wrap\">\r\n");
      out.write("\t\t\t\t\t\t<br>\r\n");
      out.write("\t\t\t\t\t\t<div style=\"padding-right: 0px\">\r\n");
      out.write("\t\t\t\t\t\t\t<span class=\"image fit\"><img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/images/pic03.jpg\" alt=\"\" /></span>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"row gtr-uniform\" id=\"sign_btn_wrap\" style=\"margin-top: 1em\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<div class=\"col-12\">\r\n");
      out.write("\t\t\t\t\t\t<!-- ?????? ????????? form ????????? submit??? ???????????? ????????? ????????? input[type=button]?????? ?????? -->\r\n");
      out.write("\t\t\t\t\t\t<input type=\"button\" class=\"btn\" value=\"???????????? ????????????\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<!-- ?????? ?????? Modal -->\r\n");
      out.write("\t\t\t\t\t\t<div class=\"modal\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<!-- ?????? ?????? Modal??? ?????? -->\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"modal-content\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<span class=\"close\">&times;</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t<textarea style=\"height: 600px\">\r\n");
      out.write("                     ???????????? : 2020??? 11??? 16???\r\n");
      out.write("\r\n");
      out.write("???1??? (??????)\r\n");
      out.write("??? ????????? WEB7 ????????????(?????? '??????')??? ?????? ?????????(?????? ???????????????)??? ????????? ?????????????????? ???????????? ?????????(?????? ???????????????)??? ???????????? ?????? (?????? '??????')?????? ????????? ?????? ??? ?????? ??? ?????? ??????????????? ???????????? ???????????? ?????????.\r\n");
      out.write("\r\n");
      out.write("???2??? (????????? ??????)\r\n");
      out.write("??? ???????????? ???????????? ????????? ????????? ????????? ????????????.\r\n");
      out.write("???. '??????'?????? ?????? ??? ????????? ???????????? ??????????????? ????????? ?????????ID(????????????)??? ??????????????? ???????????? ?????????, ????????? ???????????? ???????????? ????????? ??? ?????? ???????????? ????????????.\r\n");
      out.write("???. '?????????ID'??? ?????? ????????? ?????? ??? ????????? ????????? ????????? ????????? ????????? ?????? ????????? ?????? ?????? ???????????? ????????? ????????? ????????? ????????? ????????????.\r\n");
      out.write("???. '????????????'??? ?????? ?????????ID??? ???????????? ????????? ?????? ????????? ???????????? ????????? ????????? ???????????? ????????? ????????? ????????? ????????? ????????? ????????? ????????????.\r\n");
      out.write("???. ????????????????????? ?????? ?????????ID??? ??????????????? ????????? ????????? ?????? ??? ?????? ??? ???????????? ??????????????? ????????? ??? ?????? ????????? ????????????.\r\n");
      out.write("???. '??????'??? ?????? ????????? ????????? ????????? ???????????? ?????? ????????????.\r\n");
      out.write("???. ?????????ID??? ??? ?????? ???????????? ?????? ?????? ?????? ?????? ????????? ?????? ??? ??? ????????? ??? ????????? ?????? ??????????????? ????????? ???????????? ???????????????.\r\n");
      out.write("??? ???????????? ???????????? ?????? ??? ???1????????? ????????? ????????? ?????? ?????? ?????? ??? ????????? ??? ???????????? ????????? ?????? ?????????, ??? ????????? ?????? ????????? ????????????.\r\n");
      out.write("\r\n");
      out.write("???3??? (??????????????? ?????? ??? ??????)\r\n");
      out.write("1. ??? ????????? ???????????? ?????? ??????????????? ???????????? ????????? ????????? ????????? ???????????????. ??? ????????? ????????? ???????????? ???????????? ???????????? ?????????.\r\n");
      out.write("2. ????????? ???????????? ????????? ????????? ?????? ?????? ????????? ???????????? ?????? ?????? ????????? ????????? ????????? ??? ????????????. ????????? ????????? ???????????? ?????? ??????????????? ????????? ???????????? ???????????? ?????????????????? ??? ????????? ????????????, ???????????? ?????? ?????? ????????? ?????? ????????? ????????? 7??? ?????? ???????????????.\r\n");
      out.write("3. ????????? ????????? ?????? ????????? ?????? ?????? ???????????? ????????? ????????? ???????????? ???????????? ????????????.\r\n");
      out.write("4. ????????? ????????? ????????? ???????????? ?????? ?????? ????????? ????????? ???????????? ?????? ????????? ????????? ??? ????????????. ???, ????????? ???????????? ???????????? ??? 2????????? ?????? ?????? ?????? ????????? ????????? ?????? ??? 30??? ????????? ??????????????? ?????? ?????? ????????? ????????? ????????? ????????? ????????? ???????????????. \r\n");
      out.write("\r\n");
      out.write("???4??? (????????? ??????)\r\n");
      out.write("????????? ????????? ?????? ?????? ???????????? ????????? ?????? ???????????? ?????? ????????????(?????? '????????? ??? ??????'?????? ?????????)??? ?????? ??? ?????????, ??? ????????? ????????? ??? ????????? ????????? ???????????? ???????????? ????????? ??? ????????? ????????? ???????????? ???????????????.\r\n");
      out.write("\r\n");
      out.write("???5??? (?????? ??????)\r\n");
      out.write("1. ??? ????????? ????????? ???????????? ?????? ?????? ?????? ???????????? ??? ??????????????????????????? ??????????????? ??????????????? ?????? ????????? ???????????? ????????? ???????????? ???????????? ????????? ?????????????????? ??????????????????. \r\n");
      out.write("2. ???????????? ???????????? ???????????? ??????????????? ?????? ???????????? ???????????? ???????????? ?????? ??????(???????????????????????? ??? 1??? ??????????????? ??????????????? ?????????)??? ??????????????? ?????????.\r\n");
      out.write("3. ????????? ????????? ?????? ????????? ????????? ?????????????????? ???????????? ????????? ??? ?????????, ????????? ????????? ??????????????? ????????? ????????? ???????????? ??? ????????? ????????? ????????? ???????????? ?????? ????????? ????????? ????????? ???????????? ????????? ????????? ????????? ??? ?????????, ?????? ????????? ?????? ?????? ?????? ??? ????????????. ?????? ??? 3????????? ????????? ????????? ????????? ????????? ?????????, ????????? ????????? ????????? ????????? ????????? ????????? ?????? ????????? ????????? ??? ????????????.\r\n");
      out.write("\r\n");
      out.write("???6??? (??????????????? ?????? ??? ??????)\r\n");
      out.write("1. ????????? ?????? ????????? ????????? ?????? ?????? ????????? ??????????????? ???????????? ?????? ???????????????. ??????????????? ?????? ??? ????????? ???????????? ?????? ?????? ??? ????????? ??????????????????????????? ?????? ?????? ????????????. ???, ????????? ?????????ID ??? ???????????? ?????? ???????????? ???????????? ????????? ????????? ???????????? ?????? ????????? ????????? ??????????????? ?????? ????????? ????????? ????????? ????????? ?????? ????????????.\r\n");
      out.write("2. ????????? ????????? ???????????? ??????????????? ??? ????????? ????????? ????????? ????????? ????????? ??? ????????????.\r\n");
      out.write("3. ????????? ????????? ????????? ??????????????? ????????? ?????? ?????? ?????? ??? 3????????? ????????? ??? ????????????. ???, ?????? ??? ?????? ???????????? ???????????? ????????? ?????????.\r\n");
      out.write("???. ??????????????? ?????????????????? ???????????? ??????\r\n");
      out.write("???. ????????????????????? ??? ??????????????? ????????? ??????????????? ???????????? ????????? ?????? ???????????? ????????? ????????? ?????????????????????????????? ????????? ?????? ??????\r\n");
      out.write("???. ????????????, ????????????, ??????????????? ????????? ????????? ???????????? ?????? ???????????? ????????? ??? ?????? ????????? ???????????? ??????\r\n");
      out.write("\r\n");
      out.write("???7??? (????????? ?????? ?????? ??? ????????????)\r\n");
      out.write("1. ????????? ????????? ????????? ???????????? ?????? ????????? ????????? ????????? ???????????? ????????? ??????????????????, ????????????????????? ??? ??? ????????????.\r\n");
      out.write("2. ????????? ??????????????? ???????????? ????????? ?????? ??? ?????? ?????? ?????????????????? ?????? 7??? ?????? ?????????????????? ?????? ????????? ????????? ??? ????????????.\r\n");
      out.write("3. ????????? ???????????? ????????? ????????? ????????? ????????? ???????????? ?????? ????????? ????????? ?????????????????? ??????, ??????, SMS, ?????? ?????? ???????????? ???????????? ????????? ??? ????????????.\r\n");
      out.write("4. ????????? ????????? ?????? ??? ?????? ????????? ????????? ?????? ?????? ???????????? ????????? ?????? ?????? ?????? ????????? ?????? ???????????? ?????? ????????? ????????? ??? ????????????.\r\n");
      out.write("\r\n");
      out.write("???8???(???????????? ?????? ?????? ??? ??????)\r\n");
      out.write("1. ????????? ????????? ????????? ????????? ?????? ????????? ????????? ????????? ?????? ??? ????????????, 1??? 24?????? ????????? ???????????? ?????????. ???, ????????? ????????? ????????????, ?????? ??? ????????? ?????? ????????? ?????? ????????? ????????? ???????????? ?????? ????????? ??? ?????????, ???????????? ?????? ???????????? ?????? ????????? ?????? ????????? ????????? ?????? ????????? ???????????? ????????? ???????????????.\r\n");
      out.write("2. ????????? ????????? ????????? ??????, ?????? ??? ??????, ????????? ??????, ????????? ????????? ??????, ??????????????????, ?????? ??? ???????????? ????????? ????????? ?????? ?????? ?????? ?????? ??????????????? ???????????? ?????? ?????? ????????? ????????? ??? ????????????.\r\n");
      out.write("3. ????????? ????????? ?????? ??? ????????? ?????? ??? ????????? ?????? ?????? ?????? ?????? ???????????? ????????? ????????? ??? ????????? ???????????? ?????? ?????? ?????? ?????? ?????? ?????????.\r\n");
      out.write("\r\n");
      out.write("???9??? (????????? ??????)\r\n");
      out.write("1. ????????? ??? ????????? ????????? ?????? ?????? ??????????????? ???????????? ???????????? ???????????? ????????? ???????????????.\r\n");
      out.write("2. ????????? ????????? ???????????? ????????? ?????? ?????? ???????????? ???????????? ???????????? ??????????????? ???????????? ???????????????.\r\n");
      out.write("3. ????????? ???????????? ????????? ????????? ?????? ????????? ????????? ???????????? ??????????????? ????????? ????????? ???????????? ?????????????????? ??????????????? ??????????????? ????????? ?????? ????????? ???????????????.\r\n");
      out.write("4. ????????? ?????????????????? ???????????? ???????????? ??????????????? ??????????????? ??????????????? ????????? ???????????? ????????? ????????? ?????? ?????? ??????????????? ?????????. ??????, ????????? ????????? ????????? ????????? ???????????? ??? ????????? ??????????????? ??????????????? ?????????.\r\n");
      out.write("\r\n");
      out.write("???10??? (????????? ??????)\r\n");
      out.write("1. ????????? ???????????? ?????? ?????? ???????????? ?????? ??? ?????? ????????? ????????? ???????????? ????????? ?????? ????????? ??????????????? ??????, ?????? ?????? ????????? ????????? ????????? ?????? ?????? ????????? ?????? ????????? ????????? ??? ????????????.\r\n");
      out.write("2. ????????? ??? ???????????? ???????????? ????????? ?????? ????????? ?????? ?????? ??????, ???????????? ??? ????????? ???????????? ?????? ??? ?????? ????????? ??????????????? ??????, ?????? ????????? ????????? ????????? ?????? ??????, ????????? ????????? ??????????????? ??????, ???????????? ????????? ?????? ????????? ????????? ????????????.\r\n");
      out.write("3. ????????? ??????, ?????????, ???????????? ?????? ??? ????????? ??????????????? ????????? ????????? ?????? ????????? ?????? ?????? ????????? ?????? ????????? ?????????.\r\n");
      out.write("4. ????????? ??????ID, ???????????? ?????? ???????????? ???????????? ????????? ????????? ?????? ????????? ????????????.\r\n");
      out.write("5. ????????? ??????ID, ???????????? ?????? ?????? ???????????? ??? 3?????? ???????????? ????????? ????????? ???????????? ?????? ????????? ???????????? ????????? ????????? ?????? ???????????? ?????? ????????? ?????????.\r\n");
      out.write("6. ????????? ????????? ?????? ???1???, ??? 2???, ??? 3???, ??? 4???, ??? 5?????? ???????????? ???????????? ????????? ????????? ????????? ????????? ????????? ???????????? ????????????.\r\n");
      out.write("\r\n");
      out.write("???11??? (?????? ?????? ??? ?????? ??????)\r\n");
      out.write("1. ????????? ????????? ???????????? ?????? ????????? ????????? ??? ????????? ????????? ????????? ?????? ?????? ?????? ????????? ?????? ????????? ?????? ????????? ?????? ?????? ??????????????????????????? ?????? ?????? ????????? ???????????????.\r\n");
      out.write("2. ????????? ?????? ??????????????? ???????????? ???????????? ????????? ???????????? ????????? ?????? ??????????????? ?????? ??????????????? ?????? ???????????? ?????? ?????? ????????? ???????????? ??????????????? ????????????.\r\n");
      out.write("3. ????????? ????????? ????????? ????????? ??? ?????? ??? 10??? ????????? ???????????????, ?????? ??? ?????? ????????? ???????????? ?????? ????????? ???????????? ???????????? ?????? ??? ??????????????? ????????? ??? ??? ????????????.\r\n");
      out.write("???. ?????? ????????? ????????? ???????????? ?????? ????????? ??????\r\n");
      out.write("???. ?????? ??? ?????? ?????? ????????? ????????? ????????? ??????\r\n");
      out.write("???. ??????????????? ????????? ???????????? ??????????????? ????????? ????????? ?????? ??????\r\n");
      out.write("???. ????????? ???????????? ?????? ??????????????? ????????? ???????????? ??????????????? ????????? ????????? ?????? ??????\r\n");
      out.write("???. ?????? ????????? ?????? ????????? ????????? ??????????????? ??? ????????? ???????????? ??? ????????????????????? ???????????? ??????\r\n");
      out.write("???. ?????? ?????? ????????? ??? ????????? ???????????? ????????? ?????? ?????? ??????\r\n");
      out.write("4. ????????? ???????????? ???????????? ????????? ????????? ?????? ???????????? ?????? ?????? ???????????? ????????? ????????? ???????????????.\r\n");
      out.write("\r\n");
      out.write("???12??? (??????ID ??????)\r\n");
      out.write("1. ????????? ????????? ??? ?????? ??? 1??? ?????? ????????? ???????????? ?????? ?????? ?????? ?????? ?????????ID ??? ??????????????? ??????ID??? ?????? ???????????????.\r\n");
      out.write("2. ????????? ??????ID ?????? ???????????? ?????? 30??? ?????? ????????? ????????? ??? ?????? ??????, ??????ID??? ???????????? ????????? ????????? ?????? ??? ???????????? ?????? ????????? ?????? ?????? ?????? ??? ?????? ????????? ID??? ????????? ??????????????????.\r\n");
      out.write("\r\n");
      out.write("???13??? (????????????)\r\n");
      out.write("1. ????????? ??????????????? ????????? ???????????? ???????????? ????????? ???????????? ?????????????????????????????? ????????? ????????? ???????????? ?????? ????????? ????????? ????????? ????????? ????????? ?????? ????????????.\r\n");
      out.write("\r\n");
      out.write("???14??? (????????????)\r\n");
      out.write("1. ????????? ????????????, ??????, ???????????????????????? ????????? ?????? ??? ?????? ?????? ????????? ?????????????????? ????????? ???????????? ????????? ??? ?????? ???????????? ????????? ????????? ?????? ?????? ?????? ????????????.\r\n");
      out.write("2. ????????? ???????????? ????????? ??????, ??????, ????????????, ?????? ??? ???????????? ????????? ????????? ????????? ?????? ????????? ???????????????.\r\n");
      out.write("3. ????????? ????????? ???????????? ????????? ??????, ??????, ????????? ?????????, ????????? ??? ??? ????????? ???????????? ????????? ????????? ???????????? ????????????, ????????? ????????? ???????????? ???????????? ????????????, ???????????? ???????????? ?????? ?????? ????????? ?????? ?????? ????????? ????????? ??????????????? ????????? ????????????, ?????? ????????? ????????? ???????????? ????????? ???????????? ?????????????????? ?????? ?????? ?????? ????????? ???????????? ????????????.\r\n");
      out.write("4. ????????? ???????????? ????????? ????????? ????????? ???????????? ????????? ??? ????????????. ????????? ??? ???????????? ????????? ?????? ?????? ????????? ????????? ???????????? ??????????????? ????????? ???????????? ???????????? ?????????, ????????? ????????? ???????????? ????????? ???????????? ???????????? ????????? ????????? ????????? ???????????? ????????????.\r\n");
      out.write("5. ????????? ????????? ???????????? ???????????? ???????????? ????????? ?????? ???????????? ????????? ?????? ????????? ????????? ?????? ?????????, ???????????? ??????????????? ?????? ????????? ?????? ????????? ????????? ????????? ?????? ????????????.\r\n");
      out.write("6. ????????? ????????? ???????????? ?????? ?????? ???????????? ????????? ??????????????? ???????????? ????????? ?????? ?????? ??????????????? ??? ????????? ?????????, ??? ????????? ?????? ????????? ?????? ???????????????.\r\n");
      out.write("\r\n");
      out.write("???15??? (????????? ?????? ??? ????????????)\r\n");
      out.write("1. ??? ????????? ???????????? ?????? ????????? ?????? ????????? ???????????? ????????????.\r\n");
      out.write("2. ????????? ?????? ???????????? ????????? ?????? ????????? ?????? ?????? ???????????? ?????????????????? ????????? ????????? ?????? ?????? ??? ????????? ????????????.\r\n");
      out.write("3. ????????? ?????? ????????? ????????? ????????? ?????? ????????? ???????????? ?????? ?????? ????????? ?????????????????????????????? ?????????.\r\n");
      out.write("\r\n");
      out.write("???16??? (???????????? ??? ?????????)\r\n");
      out.write("1. ??? ????????? ???????????? ?????? ????????? ????????????????????? ??? ??????????????? ??????????????? ???????????? ????????????.\r\n");
      out.write("2. ????????? ?????? ????????? ?????? ??? ?????? ?????? ????????? ?????? ????????? ?????? ?????? ???????????? ?????????????????? ????????? ????????? ?????? ?????? ??? ????????? ????????????.\r\n");
      out.write("3. ??? ?????? ??? ???????????? ????????? ????????? ????????? ?????? ????????? ????????? ?????? ???????????? ???????????? ????????? ???????????????.\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("?????? (?????????)\r\n");
      out.write("??? ????????? 2020??? 11??? 16????????? ????????????, 2016??? 5??? 2????????? ???????????? ????????? ????????? ??? ???????????? ???????????????.\r\n");
      out.write("                                    \r\n");
      out.write("                  </textarea>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<div class=\"col-12 checkbox\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"checkbox\" id=\"agree\" name=\"agree\" value=\"agree\"> \r\n");
      out.write("\t\t\t\t\t\t<label for=\"agree\" style=\"font-family: inherit\">??? ????????? ???????????????</label>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<div class=\"col-12\">\r\n");
      out.write("\t\t\t\t\t\t<a href=\"javascript:formSubmit()\" class=\"button primary\"\r\n");
      out.write("\t\t\t\t\t\t\tid=\"sign_up_btn\">????????????</a>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<br>\r\n");
      out.write("\r\n");
      out.write("\t\t\t</section>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</form>\r\n");
      out.write("</body>\r\n");
      out.write("<!-- Scripts -->\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/assets/js/jquery.min.js\"></script>\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/assets/js/jquery.scrollex.min.js\"></script>\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/assets/js/jquery.scrolly.min.js\"></script>\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/assets/js/browser.min.js\"></script>\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/assets/js/breakpoints.min.js\"></script>\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/assets/js/util.js\"></script>\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/assets/js/main.js\"></script>\r\n");
      out.write("<script src=\"//code.jquery.com/jquery-3.5.1.min.js\"></script>\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/app/member/join.js\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("\tvar contextPath = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\";\r\n");
      out.write("</script>\r\n");
      out.write("<!-- ???????????? modal js????????? -->\r\n");
      out.write("<script>\r\n");
      out.write("\t// Modal??? ???????????????.\r\n");
      out.write("\tvar modals = document.getElementsByClassName(\"modal\");\r\n");
      out.write("\t// Modal??? ????????? ????????? ????????? ???????????????.\r\n");
      out.write("\tvar btns = document.getElementsByClassName(\"btn\");\r\n");
      out.write("\t// Modal??? ?????? close ???????????? ???????????????.\r\n");
      out.write("\tvar spanes = document.getElementsByClassName(\"close\");\r\n");
      out.write("\tvar funcs = [];\r\n");
      out.write("\r\n");
      out.write("\t// Modal??? ????????? ?????? ?????? ???????????? ????????? ??????\r\n");
      out.write("\tfunction Modal(num) {\r\n");
      out.write("\t\treturn function() {\r\n");
      out.write("\t\t\t// ?????? ???????????? ????????? ???????????? Modal??? ????????????.\r\n");
      out.write("\t\t\tbtns[num].onclick = function() {\r\n");
      out.write("\t\t\t\tmodals[num].style.display = \"block\";\r\n");
      out.write("\t\t\t\tconsole.log(num);\r\n");
      out.write("\t\t\t\t$('body').css(\"overflow\", \"hidden\");\r\n");
      out.write("\t\t\t};\r\n");
      out.write("\r\n");
      out.write("\t\t\t// <span> ??????(X ??????)??? ???????????? Modal??? ????????????.\r\n");
      out.write("\t\t\tspanes[num].onclick = function() {\r\n");
      out.write("\t\t\t\tmodals[num].style.display = \"none\";\r\n");
      out.write("\t\t\t\t$('body').css(\"overflow\", \"scroll\");\r\n");
      out.write("\t\t\t};\r\n");
      out.write("\t\t};\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t// ????????? Modal ????????? Modal ????????? ???????????? funcs ????????? ???????????????.\r\n");
      out.write("\tfor (var i = 0; i < btns.length; i++) {\r\n");
      out.write("\t\tfuncs[i] = Modal(i);\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t// ????????? Modal ????????? funcs ????????? ???????????????.\r\n");
      out.write("\tfor (var j = 0; j < btns.length; j++) {\r\n");
      out.write("\t\tfuncs[j]();\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t// Modal ?????? ?????? ???????????? Modal??? ????????????.\r\n");
      out.write("\twindow.onclick = function(event) {\r\n");
      out.write("\t\tif (event.target.className == \"modal\") {\r\n");
      out.write("\t\t\tevent.target.style.display = \"none\";\r\n");
      out.write("\t\t\t$('body').css(\"overflow\", \"scroll\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
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
