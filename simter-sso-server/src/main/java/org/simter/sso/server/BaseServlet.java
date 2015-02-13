package org.simter.sso.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * 整合 Spring 的基础 Servlet
 * Created by dragon on 2015/2/12.
 */
public class BaseServlet extends HttpServlet {
    private static Logger logger = LoggerFactory.getLogger(BaseServlet.class);
    protected ApplicationContext context;

    @Override
    public void init() throws ServletException {
        logger.debug("init spring context");
        super.init();
        context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
    }
}