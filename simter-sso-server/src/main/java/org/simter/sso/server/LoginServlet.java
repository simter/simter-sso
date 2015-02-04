package org.simter.sso.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by dragon on 2015/1/30.
 */
@WebServlet("/simter/sso/login")
public class LoginServlet extends HttpServlet {
    private static Logger logger = LoggerFactory.getLogger(LoginServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (this.hasLogin(req)) {// 已经登录的处理
            this.gotoSuccessPage(req, resp);
        } else {  // 未登录，返回登录页面
            req.getRequestDispatcher("/simter/sso/login.jsp").forward(req, resp);
        }
    }

    private void gotoSuccessPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String origin = req.getParameter("origin");
        if (origin == null || origin.isEmpty()) {// 无参数 origin，返回 SSO 主页
            resp.sendRedirect(req.getContextPath() + "/simter/sso/index");
        } else {  // 有参数 origin，则附带 ticket 参数跳转到 src 页面
            String ticket = this.getTicket(req);
            if (ticket == null || ticket.isEmpty())
                throw new ServletException("no ticket");
            origin = this.addParameter(origin, "ticket", ticket);
            resp.sendRedirect(origin);
        }
    }

    // 判断当前会话是否已经处于登录状态
    private boolean hasLogin(HttpServletRequest req) {
        String ticket = (String) req.getSession().getAttribute("ticket");
        return ticket != null;
    }

    // 获取已登录的 ticket 信息
    private String getTicket(HttpServletRequest req) {
        // TODO
        return req.getSession().getId();
    }

    // 在 url 后附加指定的 请求参数
    private String addParameter(String src, String name, String value) {
        return (src.indexOf("?") == -1 ? src + "?" : src + "&") + name + "=" + value;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean ok = this.validate(req);
        if (ok) {// 登录成功返回
            this.gotoSuccessPage(req, resp);
        } else { // 登录失败返回登录页面
            req.setAttribute("msg", "登录失败"); // TODO
            req.getRequestDispatcher("/simter/sso/login.jsp").forward(req, resp);
        }
    }

    private boolean validate(HttpServletRequest req) {
        String account = req.getParameter("account");
        String password = req.getParameter("password");
        // TODO
        if (account.equals("test") && password.equals("888888")) {
            // 生成并记录登录票据
            req.getSession().setAttribute("account", account);
            req.getSession().setAttribute("ticket", getTicket(req));
            req.getSession().setAttribute("ticketTime", new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(new Date()));
            return true;
        } else {
            return false;
        }
    }
}