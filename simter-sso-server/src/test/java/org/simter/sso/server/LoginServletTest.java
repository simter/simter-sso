package org.simter.sso.server;

import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import javax.servlet.ServletException;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by dragon on 2015/1/30.
 */
public class LoginServletTest {
    //private static Logger logger = LoggerFactory.getLogger(LoginServletTest.class);
    private LoginServlet servlet;
    private MockHttpServletRequest request;
    private MockHttpServletResponse response;

    @Before
    public void setUp() {
        servlet = new LoginServlet();
        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
    }

    @Test
    public void loginPage() throws ServletException, IOException {
        request.addParameter("account", "me");
        request.addParameter("password", "111111");
        servlet.doGet(request, response);
        assertThat("/simter/sso/login.jsp", equalTo(response.getForwardedUrl()));
    }

    @Test
    public void loginFailed() throws ServletException, IOException {
        request.addParameter("account", "test");
        request.addParameter("password", "111111");
        servlet.doPost(request, response);
        assertThat(response.getContentAsString(), equalTo("false"));
    }

    @Test
    public void loginSuccess() throws ServletException, IOException {
        request.addParameter("account", "test");
        request.addParameter("password", "888888");
        servlet.doPost(request, response);
        assertThat(response.getContentAsString(), equalTo("true"));
    }
}