package org.simter.sso.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by dragon on 2015/2/13.
 */
@Service
public class LoginServiceImpl implements LoginService {
    private static Logger logger = LoggerFactory.getLogger(LoginServlet.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void login(String account, String password) throws AuthenticationException {
        String sql = "" +
                "select true from ST_SSO_ACCOUNT a\n" +
                "  inner join ST_SSO_AUTH t on t.pid = a.id\n" +
                "  where a.status_ = ?\n" +
                "  and (\n" +
                "    a.code_ = ?\n" +
                "    or exists (select 0 from ST_SSO_BIND b where b.pid = a.id and b.code_ = ?)\n" +
                "  )\n" +
                "  and t.data_ = ?";
        logger.debug("account={},password={},sql={}", account, password, sql);
        try {
            this.jdbcTemplate.queryForObject(sql, new Object[]{1, account, password}, Boolean.class);
        } catch (EmptyResultDataAccessException e) {
            throw new AuthenticationException("认证失败");
        }
    }
}