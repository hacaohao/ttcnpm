package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_spring_bind_path;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_spring_bind_path = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_spring_bind_path.release();
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\r\n");
      out.write("    \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>Welcome to Spring Web MVC project</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <form action=\"post.html\" method=\"Post\">\r\n");
      out.write("            ");
      //  spring:bind
      org.springframework.web.servlet.tags.BindTag _jspx_th_spring_bind_0 = (org.springframework.web.servlet.tags.BindTag) _jspx_tagPool_spring_bind_path.get(org.springframework.web.servlet.tags.BindTag.class);
      _jspx_th_spring_bind_0.setPageContext(_jspx_page_context);
      _jspx_th_spring_bind_0.setParent(null);
      _jspx_th_spring_bind_0.setPath("user.email");
      int[] _jspx_push_body_count_spring_bind_0 = new int[] { 0 };
      try {
        int _jspx_eval_spring_bind_0 = _jspx_th_spring_bind_0.doStartTag();
        if (_jspx_eval_spring_bind_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\r\n");
            out.write("                <input type=\"text\" name=\"email\" value=\"\"><br />\r\n");
            out.write("            ");
            int evalDoAfterBody = _jspx_th_spring_bind_0.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_spring_bind_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
      } catch (Throwable _jspx_exception) {
        while (_jspx_push_body_count_spring_bind_0[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_spring_bind_0.doCatch(_jspx_exception);
      } finally {
        _jspx_th_spring_bind_0.doFinally();
        _jspx_tagPool_spring_bind_path.reuse(_jspx_th_spring_bind_0);
      }
      out.write("\r\n");
      out.write("            ");
      //  spring:bind
      org.springframework.web.servlet.tags.BindTag _jspx_th_spring_bind_1 = (org.springframework.web.servlet.tags.BindTag) _jspx_tagPool_spring_bind_path.get(org.springframework.web.servlet.tags.BindTag.class);
      _jspx_th_spring_bind_1.setPageContext(_jspx_page_context);
      _jspx_th_spring_bind_1.setParent(null);
      _jspx_th_spring_bind_1.setPath("user.password");
      int[] _jspx_push_body_count_spring_bind_1 = new int[] { 0 };
      try {
        int _jspx_eval_spring_bind_1 = _jspx_th_spring_bind_1.doStartTag();
        if (_jspx_eval_spring_bind_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\r\n");
            out.write("                <input type=\"text\" name=\"password\" value=\"\"><br />\r\n");
            out.write("            ");
            int evalDoAfterBody = _jspx_th_spring_bind_1.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_spring_bind_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
      } catch (Throwable _jspx_exception) {
        while (_jspx_push_body_count_spring_bind_1[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_spring_bind_1.doCatch(_jspx_exception);
      } finally {
        _jspx_th_spring_bind_1.doFinally();
        _jspx_tagPool_spring_bind_path.reuse(_jspx_th_spring_bind_1);
      }
      out.write("\r\n");
      out.write("            ");
      //  spring:bind
      org.springframework.web.servlet.tags.BindTag _jspx_th_spring_bind_2 = (org.springframework.web.servlet.tags.BindTag) _jspx_tagPool_spring_bind_path.get(org.springframework.web.servlet.tags.BindTag.class);
      _jspx_th_spring_bind_2.setPageContext(_jspx_page_context);
      _jspx_th_spring_bind_2.setParent(null);
      _jspx_th_spring_bind_2.setPath("user.role");
      int[] _jspx_push_body_count_spring_bind_2 = new int[] { 0 };
      try {
        int _jspx_eval_spring_bind_2 = _jspx_th_spring_bind_2.doStartTag();
        if (_jspx_eval_spring_bind_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\r\n");
            out.write("                <input type=\"text\" name=\"role\" value=\"\"><br />\r\n");
            out.write("            ");
            int evalDoAfterBody = _jspx_th_spring_bind_2.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_spring_bind_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
      } catch (Throwable _jspx_exception) {
        while (_jspx_push_body_count_spring_bind_2[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_spring_bind_2.doCatch(_jspx_exception);
      } finally {
        _jspx_th_spring_bind_2.doFinally();
        _jspx_tagPool_spring_bind_path.reuse(_jspx_th_spring_bind_2);
      }
      out.write("\r\n");
      out.write("            ");
      //  spring:bind
      org.springframework.web.servlet.tags.BindTag _jspx_th_spring_bind_3 = (org.springframework.web.servlet.tags.BindTag) _jspx_tagPool_spring_bind_path.get(org.springframework.web.servlet.tags.BindTag.class);
      _jspx_th_spring_bind_3.setPageContext(_jspx_page_context);
      _jspx_th_spring_bind_3.setParent(null);
      _jspx_th_spring_bind_3.setPath("employee.code");
      int[] _jspx_push_body_count_spring_bind_3 = new int[] { 0 };
      try {
        int _jspx_eval_spring_bind_3 = _jspx_th_spring_bind_3.doStartTag();
        if (_jspx_eval_spring_bind_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\r\n");
            out.write("                <input type=\"text\" name=\"code\" value=\"\"><br />\r\n");
            out.write("            ");
            int evalDoAfterBody = _jspx_th_spring_bind_3.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_spring_bind_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
      } catch (Throwable _jspx_exception) {
        while (_jspx_push_body_count_spring_bind_3[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_spring_bind_3.doCatch(_jspx_exception);
      } finally {
        _jspx_th_spring_bind_3.doFinally();
        _jspx_tagPool_spring_bind_path.reuse(_jspx_th_spring_bind_3);
      }
      out.write("\r\n");
      out.write("            ");
      //  spring:bind
      org.springframework.web.servlet.tags.BindTag _jspx_th_spring_bind_4 = (org.springframework.web.servlet.tags.BindTag) _jspx_tagPool_spring_bind_path.get(org.springframework.web.servlet.tags.BindTag.class);
      _jspx_th_spring_bind_4.setPageContext(_jspx_page_context);
      _jspx_th_spring_bind_4.setParent(null);
      _jspx_th_spring_bind_4.setPath("employee.name");
      int[] _jspx_push_body_count_spring_bind_4 = new int[] { 0 };
      try {
        int _jspx_eval_spring_bind_4 = _jspx_th_spring_bind_4.doStartTag();
        if (_jspx_eval_spring_bind_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\r\n");
            out.write("                <input type=\"text\" name=\"name\" value=\"\"><br />\r\n");
            out.write("            ");
            int evalDoAfterBody = _jspx_th_spring_bind_4.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_spring_bind_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
      } catch (Throwable _jspx_exception) {
        while (_jspx_push_body_count_spring_bind_4[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_spring_bind_4.doCatch(_jspx_exception);
      } finally {
        _jspx_th_spring_bind_4.doFinally();
        _jspx_tagPool_spring_bind_path.reuse(_jspx_th_spring_bind_4);
      }
      out.write("\r\n");
      out.write("            ");
      //  spring:bind
      org.springframework.web.servlet.tags.BindTag _jspx_th_spring_bind_5 = (org.springframework.web.servlet.tags.BindTag) _jspx_tagPool_spring_bind_path.get(org.springframework.web.servlet.tags.BindTag.class);
      _jspx_th_spring_bind_5.setPageContext(_jspx_page_context);
      _jspx_th_spring_bind_5.setParent(null);
      _jspx_th_spring_bind_5.setPath("employee.phone");
      int[] _jspx_push_body_count_spring_bind_5 = new int[] { 0 };
      try {
        int _jspx_eval_spring_bind_5 = _jspx_th_spring_bind_5.doStartTag();
        if (_jspx_eval_spring_bind_5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\r\n");
            out.write("                <input type=\"text\" name=\"phone\" value=\"\"><br />\r\n");
            out.write("            ");
            int evalDoAfterBody = _jspx_th_spring_bind_5.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_spring_bind_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
      } catch (Throwable _jspx_exception) {
        while (_jspx_push_body_count_spring_bind_5[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_spring_bind_5.doCatch(_jspx_exception);
      } finally {
        _jspx_th_spring_bind_5.doFinally();
        _jspx_tagPool_spring_bind_path.reuse(_jspx_th_spring_bind_5);
      }
      out.write("\r\n");
      out.write("                <input type=\"submit\"/>\r\n");
      out.write("        </form>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
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
