package org.simter.sso.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by dragon on 2015/1/30.
 */
@WebServlet("/simter/sso/test")
public class TestServlet extends HttpServlet {
    private static Logger logger = LoggerFactory.getLogger(TestServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String html = "";
        html += "request.getContextPath = " + req.getContextPath() + "\r\n";
        html += "request.getRequestURI = " + req.getRequestURI() + "\r\n";
        html += "request.getRequestURL = " + req.getRequestURL() + "\r\n";

        html += "request.getRemoteAddr = " + req.getRemoteAddr() + "\r\n";
        html += "request.getRemoteHost = " + req.getRemoteHost() + "\r\n";
        html += "request.getRemotePort = " + req.getRemotePort() + "\r\n";
        html += "request.getRemoteUser = " + req.getRemoteUser() + "\r\n";

        html += "request.getLocalAddr = " + req.getLocalAddr() + "\r\n";
        html += "request.getLocalName = " + req.getLocalName() + "\r\n";
        html += "request.getLocalPort = " + req.getLocalPort() + "\r\n";

        html += "request.getServletPath = " + req.getServletPath() + "\r\n";
        html += "request.getScheme = " + req.getScheme() + "\r\n";
        html += "request.getServerName = " + req.getServerName() + "\r\n";
        html += "request.getServerPort = " + req.getServerPort() + "\r\n";
        html += "request.getQueryString = " + req.getQueryString() + "\r\n";

        html += "request.getSession.getId = " + req.getSession().getId() + "\r\n";

        String path = req.getParameter("path");
        if (path == null) {
            path = "/simter/sso/test.jsp";
        }
        html += "request.getServletContext.getRealPath(\"" + path + "\") = " +
                req.getServletContext().getRealPath(path) + "\r\n";

        html += "request.getPathTranslated = " + req.getPathTranslated() + "\r\n";
        html += "request.getPathInfo = " + req.getPathInfo() + "\r\n";

        resp.getWriter().append(html);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
