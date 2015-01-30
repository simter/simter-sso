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
@WebServlet("/simter/sso/login")
public class LoginServlet extends HttpServlet {
    private static Logger logger = LoggerFactory.getLogger(LoginServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("contextPath={}, url={}", req.getContextPath(), req.getRequestURI());
        req.getRequestDispatcher("/simter/sso/login.jsp").forward(req, resp);
    }
}
