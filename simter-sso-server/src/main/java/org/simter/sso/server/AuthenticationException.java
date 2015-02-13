package org.simter.sso.server;

/**
 * 认证异常
 * Created by dragon on 2015/2/13.
 */
public class AuthenticationException extends Exception{
    public AuthenticationException(String message, Throwable e){
        super(message, e);
    }
}
