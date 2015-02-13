package org.simter.sso.server;

/**
 * Created by dragon on 2015/2/13.
 */
public interface LoginService {
    /**
     * 使用指定的帐号密码登录系统
     * @param account 帐号
     * @param password 密码
     * @throws AuthenticationException 认证失败
     */
    void login(String account, String password) throws AuthenticationException;
}
